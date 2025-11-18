package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class When {
	public static void main(String[] args) {
		Mono
				.when(
						Flux
								.just("Hi", "Tom")
								.delayElements(Duration.ofSeconds(2))
								.doOnNext(Logger::doOnNext),
						Flux
								.just("Hello", "David")
								.delayElements(Duration.ofSeconds(1))
								.doOnNext(Logger::doOnNext)
				)
				.subscribe(
						Logger::onNext,
						Logger::onError,
						Logger::onComplete
				);

		TimeUtils.sleep(5000);
	}
}
