package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.Component;
import hello.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.proxy.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

	@Test
	void noDecorator() {
		RealComponent component = new RealComponent();
		DecoratorPatternClient client = new DecoratorPatternClient(component);
		client.execute();
	}

	@Test
	void decorator1() {
		Component component = new RealComponent();
		Component messageDecorator = new MessageDecorator(component);
		DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);

		client.execute();
	}
}
