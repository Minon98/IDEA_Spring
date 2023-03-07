package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("---------");

		var objectMapper = new ObjectMapper();

		// obj -> text
		// object mapper get method 를 활용
		var user = new User("my", 10, "010-1111-2222");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

		//text -> obj
		// object mapper는 default 생성자가 필요User()
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
