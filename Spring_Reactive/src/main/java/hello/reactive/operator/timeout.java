package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class timeout {
	public static void main(String[] args) {
		requestToServer()
				.timeout(Duration.ofSeconds(2))
				.subscribe(response -> Logger.onNext(response),
						error -> Logger.onError(error));

		TimeUtils.sleep(3500);
	}

	private static Mono<String> requestToServer() {
		return Mono.just("complete to process request from client successfully")
				.delayElement(Duration.ofSeconds(3));
	}
}
