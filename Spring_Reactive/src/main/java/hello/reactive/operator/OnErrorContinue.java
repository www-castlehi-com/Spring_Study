package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;

public class OnErrorContinue {
	public static void main(String[] args) {
		Flux
				.just(1, 2, 4, 0, 6, 12)
				.map(num -> 12 / num)
				.onErrorContinue((error, num) -> Logger.onError("error: {}, num: {}", error, num))
				.subscribe(Logger::onNext,
						Logger::onError);
	}
}
