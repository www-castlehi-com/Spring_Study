package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Zip02 {
	public static void main(String[] args) {
		Flux
				.zip(
						Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300L)),
						Flux.just(4, 5, 6).delayElements(Duration.ofMillis(500L)),
						(n1, n2) -> n1 * n2
				)
				.subscribe(Logger::onNext);

		TimeUtils.sleep(2500L);
	}
}
