package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;

public class CollectList {
	public static void main(String[] args) {
		Flux
				.just(1, 3, 5)
				.map(number -> multiply(number))
				.collectList()
				.subscribe(list -> Logger.onNext(list));
	}

	public static Integer multiply(int number) {
		return number * 2;
	}
}
