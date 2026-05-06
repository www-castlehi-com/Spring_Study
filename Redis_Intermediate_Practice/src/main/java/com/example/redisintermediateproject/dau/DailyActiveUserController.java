package com.example.redisintermediateproject.dau;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/dau")
@RequiredArgsConstructor
public class DailyActiveUserController {

	private final DailyActiveUserService dailyActiveUserService;

	// 활동 유저 기록 API
	@PostMapping("/record")
	public void recordActiveUser(
			@RequestBody RecordActiveUserRequestDto recordActiveUserRequestDto
	) {
		dailyActiveUserService.recordActiveUser(recordActiveUserRequestDto.getUserId());
	}

	// DAU 조회 API
	@GetMapping("/count")
	public long getDau(
			@RequestParam
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate date
	) {
		return dailyActiveUserService.getDau(date);
	}

	// 활동 유저 기록 API
	@PostMapping("/record/redis")
	public void recordActiveUserWithRedis(
			@RequestBody RecordActiveUserRequestDto recordActiveUserRequestDto
	) {
		dailyActiveUserService.recordActiveUserWithRedis(recordActiveUserRequestDto.getUserId());
	}

	// DAU 조회 API
	@GetMapping("/count/redis")
	public long getDauWithRedis(
			@RequestParam
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate date
	) {
		return dailyActiveUserService.getDauWithRedis(date);
	}
}
