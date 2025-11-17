package hello.reactive.schedulers;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Parallel01 {
	public static void main(String[] args) {
		Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23})
				.parallel()
				.runOn(Schedulers.parallel())
				.subscribe(Logger::onNext);

		TimeUtils.sleep(100L);
	}
}
