package hello.reactive.operator;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.zip.DataFormatException;

public class Error {
	public static void main(String[] args) {
		Flux
				.just('a', 'b', 'c', '3', 'd')
				.flatMap(letter -> {
					return convert(letter);
				})
				.subscribe(Logger::onNext,
						Logger::onError);
	}

	private static Mono<String> convert(char ch) {
		if (!Character.isAlphabetic(ch)) {
			return Mono.error(new DataFormatException("Not Alphabetic"));
		}
		return Mono.just("Converted to " + Character.toUpperCase(ch));
	}
}
