package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;

public class Map {
	public static void main(String[] args) {
		Flux
				.just("Green-Circle", "Yellow-Circle", "Blue-Circle")
				.map(circle -> circle.replace("Circle", "Rectangle"))
				.subscribe(Logger::onNext);

	}
}
