package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Skip01 {
	public static void main(String[] args) {
		Flux
				.interval(Duration.ofSeconds(1))
				.doOnNext(Logger::doOnNext)
				.skip(3)
				.subscribe(Logger::onNext);

		TimeUtils.sleep(5000L);
	}
}
