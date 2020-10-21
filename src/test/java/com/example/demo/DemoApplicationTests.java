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
		p1.setKey(UUID.randomUUID().toString());
		p1.setType("Hi Buddhi 2");

		Permission p2 = new Permission();
		p2.setKey(UUID.randomUUID().toString());
		p2.setType("Hi Thisumi 3");

		List<Permission> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		kafkaTemplate.send("test",UUID.randomUUID().toString(),list);
	}

}
