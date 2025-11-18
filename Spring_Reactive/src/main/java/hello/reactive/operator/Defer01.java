package hello.reactive.operator;

import hello.reactive.util.Logger;
import hello.reactive.util.TimeUtils;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class Defer01 {
	public static void main(String[] args) {
		Logger.info("# Starting");

		Mono<LocalDateTime> justMono = Mono.just(LocalDateTime.now());
		Mono<LocalDateTime> deferMono = Mono.defer(() -> Mono.just(LocalDateTime.now()));

		TimeUtils.sleep(2000);

		justMono.subscribe(data -> Logger.onNext("just1", data));
		deferMono.subscribe(data -> Logger.onNext("defer1", data));

		TimeUtils.sleep(2000);

		justMono.subscribe(data -> Logger.onNext("just2", data));
		deferMono.subscribe(data -> Logger.onNext("defer2", data));
	}
}
