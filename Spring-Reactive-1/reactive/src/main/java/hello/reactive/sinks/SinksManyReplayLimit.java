package hello.reactive.sinks;

import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import static reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST;

public class SinksManyReplayLimit {
	public static void main(String[] args) {
		// 구독 이후, emit된 데이터 중에서 최신 데이터 2개만 replay 한다.
		Sinks.Many<Integer> replaySink = Sinks.many().replay().limit(2);
		Flux<Integer> fluxView = replaySink.asFlux();

		replaySink.emitNext(1, FAIL_FAST);
		replaySink.emitNext(2, FAIL_FAST);
		replaySink.emitNext(3, FAIL_FAST);

		fluxView.subscribe(data -> Logger.onNext("Subscriber1", data));

		replaySink.emitNext(4, FAIL_FAST);

		fluxView.subscribe(data -> Logger.onNext("Subscriber2", data));
	}
}
