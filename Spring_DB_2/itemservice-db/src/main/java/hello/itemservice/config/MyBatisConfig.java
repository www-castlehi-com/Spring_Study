package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.mybatis.ItemMapper;
import hello.itemservice.repository.mybatis.MyBatisItemRepository;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@MapperScan("hello.itemservice.repository.mybatis")
public class MyBatisConfig {

	private final ItemMapper itemMapper;

	@Bean
	public ItemService itemService() {
		return new ItemServiceV1(itemRepository());
	}

	@Bean
	public ItemRepository itemRepository() {
		return new MyBatisItemRepository(itemMapper);
	}
}
