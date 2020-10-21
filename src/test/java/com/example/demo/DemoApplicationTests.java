package com.example.demo;

import com.example.demo.model.Permission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	@Qualifier("kafkaTemplate")
	private KafkaTemplate<String, List<Permission>> kafkaTemplate;

	@Test
	void contextLoads() {
		Permission p1 = new Permission();
		p1.setName("name 1");
		p1.setType("Hi 1");

		Permission p2 = new Permission();
		p2.setName("name 2");
		p2.setType("Hi 2");

		List<Permission> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		kafkaTemplate.send("test",UUID.randomUUID().toString(),list);
	}

}
