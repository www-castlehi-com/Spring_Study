package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello-v1")
	public String helloV1(HttpServletRequest request) {
		String data = request.getParameter("data");    // 문자 ㅌ ㅏ입 조회
		Integer intValue = Integer.valueOf(data);// 숫자 타입으로 변경

		System.out.println("intValue = " + intValue);

		return "ok";
	}

	@GetMapping("/hello-v2")
	public String helloV2(@RequestParam(name = "data") Integer data) {
		System.out.println("data = " + data);

		return "ok";
	}

	@GetMapping("/ip-port")
	public String ipPort(@RequestParam(name = "ip-port") IpPort ipPort) {
		System.out.println("ipPort.getIp() = " + ipPort.getIp());
		System.out.println("ipPort.getPort() = " + ipPort.getPort());
		return "ok";
	}
}
