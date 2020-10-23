package com.example.demo.listner;

import com.example.demo.model.FooObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageListener {
    @KafkaListener(topics = "fooTopic", groupId = "foo", containerFactory = "fooListener")
    void listener(List<FooObject> data) {
        data.forEach(o-> System.out.println(o.getType()+":"+o.getName()));
    }
}
