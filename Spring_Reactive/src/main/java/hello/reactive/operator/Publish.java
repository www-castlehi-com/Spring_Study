package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Publish {
	public static void main(String[] args) {
		ConnectableFlux<Integer> flux =
				Flux
						.range(1, 5)
						.delayElements(Duration.ofMillis(300L))
						.publish();

		TimeUtils.sleep(500L);
		flux.subscribe(data -> Logger.onNext("subscriber1: ", data));

		TimeUtils.sleep(200L);
		flux.subscribe(data -> Logger.onNext("subscriber2: ", data));

		flux.connect();

		TimeUtils.sleep(1000L);
		flux.subscribe(data -> Logger.onNext("subscriber3: ", data));

		TimeUtils.sleep(2000L);
	}
}
