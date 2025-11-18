package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Defer02 {
	public static void main(String[] args) {
		Logger.info("# Start");
		Mono
				.just("Hello")
				.delayElement(Duration.ofSeconds(3))
				.switchIfEmpty(Mono.defer(() -> sayDefault()))
				.subscribe(Logger::onNext);

		TimeUtils.sleep(3500);
	}

	private static Mono<String> sayDefault() {
		Logger.info("# Say Hi");
		return Mono.just("Hi");
	}
}
