package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelaySequence {
	public static void main(String[] args) {
		Flux
				.range(1, 10)
				.doOnSubscribe(subscription -> Logger.doOnSubscribe())
				.delaySequence(Duration.ofSeconds(2))
				.doOnSubscribe(subscription -> Logger.doOnSubscribe())
				.subscribe(Logger::onNext);

		TimeUtils.sleep(2500);
	}
}
