package hello.reactive.schedulers;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnAndPublishOn {

	public static void main(String[] args) {
		Flux.fromArray(new Integer[] {1, 3, 5, 7})
				.subscribeOn(Schedulers.boundedElastic())
				.filter(data -> data > 3)
				.doOnNext(data -> Logger.doOnNext("filter", data))
				.publishOn(Schedulers.parallel())
				.map(data -> data * 10)
				.doOnNext(data -> Logger.doOnNext("map", data))
				.subscribe(Logger::onNext);

		TimeUtils.sleep(500L);
	}
}
