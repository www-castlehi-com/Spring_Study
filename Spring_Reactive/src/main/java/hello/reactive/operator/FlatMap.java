package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FlatMap {
	public static void main(String[] args) {
		Flux
				.range(2, 8)
				.flatMap(dan -> Flux
						.range(1, 9)
						.publishOn(Schedulers.parallel())
						.map(n -> dan + " * " + n + " = " + dan * n))

				.subscribe(Logger::onNext);

		TimeUtils.sleep(200L);
	}
}
