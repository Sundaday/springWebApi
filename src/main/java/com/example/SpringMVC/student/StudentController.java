package com.example.SpringMVC.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService _studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this._studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return _studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        _studentService.addNewStudent(student);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("{studentId}") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        _studentService.updateStudent(studentId, name, email);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        _studentService.deleteStudent(studentId);
    }
}
