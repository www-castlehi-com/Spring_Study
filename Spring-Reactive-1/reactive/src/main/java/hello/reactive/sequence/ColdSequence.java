package hello.reactive.sequence;

import hello.reactive.util.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Slf4j
public class ColdSequence {
	public static void main(String[] args) {
		Flux<String> coldFlux = Flux.fromIterable(Arrays.asList("RED", "YELLOW", "PINK"))
				.map(String::toLowerCase);

		coldFlux.subscribe(country -> Logger.info("# Subscriber1: {}", country));
		Logger.info("-------------------------");
		coldFlux.subscribe(country -> Logger.info("# Subscriber2: {}", country));
	}
}
