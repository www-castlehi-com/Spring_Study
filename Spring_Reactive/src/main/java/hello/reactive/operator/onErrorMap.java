package hello.reactive.operator;

import hello.reactive.util.CannotDivideByZeroException;
import hello.reactive.util.Logger;
import reactor.core.publisher.Flux;

public class onErrorMap {
	public static void main(String[] args) {
		Flux.just(1, 3, 0, 6, 8)
				.filter(num -> num % 3 == 0) // 3으로 나누어 떨어지는 숫자만 필터링 하기 위한 작업. 0도 포함된다.
				.doOnNext(Logger::doOnNext)
				.map(num -> (num * 2) / num) // 0으로 나눌 수 없으므로 ArithmeticException이 발생한다.
				.onErrorMap(error -> new CannotDivideByZeroException(error.getMessage()))
				.subscribe(
						Logger::onNext,
						Logger::onError
				);

	}
}
