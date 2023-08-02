package net.example.springboot.kafka.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import net.example.springboot.kafka.model.student;

public interface myrepository extends MongoRepository<student, String> {

}
