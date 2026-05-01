package com.example.redisintermediateproject.like;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LikeScheduler {

	private final RedisTemplate<String, String> redisTemplate;
	private final LikeRepository likeRepository;

	@Scheduled(fixedDelay = 1000)
	public void saveLikesToDb() {
		List<Like> likesToSave = new ArrayList<>();
		while (true) {
			String value = redisTemplate.opsForList().leftPop("like_queue");
			if (value == null) {
				break;
			}

			String[] split = value.split(":");
			long userId = Long.parseLong(split[0]);
			long postId = Long.parseLong(split[1]);

			likesToSave.add(new Like(userId, postId));

			if (likesToSave.size() >= 1000) {
				break;
			}
		}

		likeRepository.saveAll(likesToSave);
		log.info("DB 저장 완료: {} 건", likesToSave.size());
	}
}
