package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelayElements {
	public static void main(String[] args) {
		Flux
				.range(1, 10)
				.delayElements(Duration.ofMillis(500))
				.doOnNext(num -> Logger.doOnNext(num))
				.subscribe(Logger::onNext);

		TimeUtils.sleep(6000);
	}
}
