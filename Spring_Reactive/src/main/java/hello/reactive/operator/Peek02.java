package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;

public class Peek02 {
	public static void main(String[] args) {
		Flux
				.just("HI", "HELLO")
				.filter(data -> data.equals("HI"))
				.doOnTerminate(() -> Logger.doOnTerminate("filter"))
				.doAfterTerminate(() -> Logger.doAfterTerminate("filter"))
				.map(data -> data.toLowerCase())
				.doOnTerminate(() -> Logger.doOnTerminate("map"))
				.doAfterTerminate(() -> Logger.doAfterTerminate("map"))
				.subscribe(
						data -> Logger.onNext(data),
						error -> {},
						() -> Logger.doOnComplete());
	}
}
