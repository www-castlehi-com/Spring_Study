package hello.reactive.stepverifier;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class BackPressureDropTest {
	@Test
	public void generateNumberTest() {
		StepVerifier
				.create(BackpressureExample.generateNumberByErrorStrategy(), 1L)
				.thenConsumeWhile(num -> num >= 1)
				.expectError()
				.verifyThenAssertThat()
				.hasDiscardedElements()
				.hasDiscarded(2)
				.hasDroppedElements()
				.hasDropped(3, 4, 5, 6, 98, 99, 100);
	}
}
