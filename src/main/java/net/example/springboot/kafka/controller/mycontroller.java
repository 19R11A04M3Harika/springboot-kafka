package net.example.springboot.kafka.controller;

import net.example.springboot.kafka.model.student;
import net.example.springboot.kafka.repository.myrepository;
import net.example.springboot.kafka.service.producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class mycontroller {

    @Autowired
    private myrepository studentRepository;

    private producer p;

   // @PostMapping("/")
//    public ResponseEntity<?> addStudent(@RequestBody student student) {
//        p.message(student);
//        return ResponseEntity.ok(p);
 //   }

    @PostMapping({"/"})
    public String addStudent(@RequestBody student student){
         student save = (student)this.studentRepository.save(student);
         return"data entered";
    }
    @GetMapping("/")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }
    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") student id ) {
        this.studentRepository.delete(id);
        return "Deleted";
    }
    @DeleteMapping("/")
    public String delete (@RequestBody student student ) {
        this.studentRepository.deleteAll();
        return "Deleted";
    }
//
@PutMapping("/")
public ResponseEntity<?> updateStudent(@RequestBody student student)
{
    return ResponseEntity.ok(studentRepository.save(student));
}
}
