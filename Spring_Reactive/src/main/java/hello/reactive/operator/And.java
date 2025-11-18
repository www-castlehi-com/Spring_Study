package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class And {
	public static void main(String[] args) {
		Mono
				.just("Okay")
				.delayElement(Duration.ofSeconds(1))
				.doOnNext(Logger::doOnNext)
				.and(
						Flux
								.just("Hi", "Tom")
								.delayElements(Duration.ofSeconds(2))
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
