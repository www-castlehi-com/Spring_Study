package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;

public class collectMap {
	public static void main(String[] args) {
		Flux
				.range(0, 26)
				.collectMap(key -> key, value -> value * 2)
				.subscribe(map -> Logger.onNext(map));
	}
}
