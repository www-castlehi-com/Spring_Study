package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Mono;

public class Using {
	public static void main(String[] args) {
		Mono
				.using(() -> "Resource",
						resource -> Mono.just(resource),
						resource -> Logger.info("cleanup: {}", resource)
				)
				.subscribe(Logger::onNext);
	}
}
