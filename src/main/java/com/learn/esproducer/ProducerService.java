package com.learn.esproducer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private final Producer producer;

    public ProducerService(Producer producer) {
        this.producer = producer;
    }

    public void singleUser(User user){
        producer.produce(user);
    }

    public void multipleUsers(List<User> users){
        users.forEach(producer::produce);
    }
}
