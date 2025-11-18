package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Skip02 {

	public static void main(String[] args) {
		Flux
				.interval(Duration.ofSeconds(1))
				.skip(Duration.ofMillis(2500))
				.subscribe(Logger::onNext);

		TimeUtils.sleep(5000L);
	}
}
