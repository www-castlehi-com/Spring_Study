package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Take02 {
	public static void main(String[] args) {
		Flux
				.interval(Duration.ofSeconds(1))
				.doOnNext(Logger::doOnNext)
				.take(Duration.ofSeconds(2))
				.subscribe(Logger::onNext);

		TimeUtils.sleep(4000L);
	}
}
