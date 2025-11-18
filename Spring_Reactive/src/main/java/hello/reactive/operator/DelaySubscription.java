package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelaySubscription {
	public static void main(String[] args) {
		Flux
				.range(1, 10)
				.doOnSubscribe(subscription -> Logger.info("# doOnSubscribe > upstream"))
				.delaySubscription(Duration.ofSeconds(2))
				.doOnSubscribe(subscription -> Logger.info("# doOnSubscribe > downstream"))
				.subscribe(Logger::onNext);

		TimeUtils.sleep(2500);
	}
}
