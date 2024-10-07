package hello.spring_core_principlesbasic.web;

import org.springframework.stereotype.Service;

import hello.spring_core_principlesbasic.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class  LogDemoService {

	private final MyLogger myLogger;

	public void logic(String id) {
		myLogger.log("service id = " + id);
	}
}
