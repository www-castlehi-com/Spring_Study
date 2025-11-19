package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;

public class Buffer {
	public static void main(String[] args) {
		Flux
				.range(1, 95)
				.buffer(10)
				.subscribe(buffer -> Logger.onNext(buffer));
	}
}
