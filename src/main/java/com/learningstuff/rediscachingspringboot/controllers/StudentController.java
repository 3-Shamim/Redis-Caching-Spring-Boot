package com.learningstuff.rediscachingspringboot.controllers;

import com.learningstuff.rediscachingspringboot.models.Student;
import com.learningstuff.rediscachingspringboot.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২/১/২০
 * Time: ৯:১৮ AM
 * Email: mdshamim723@gmail.com
 */

@AllArgsConstructor
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAllStudent());
    }

    @GetMapping(value = "/{studentId}")
    public ResponseEntity<?> findStudentId(@PathVariable(value = "studentId") long studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(studentId));
    }

    @PostMapping(value = "/multiple-create")
    public ResponseEntity<?> createMultipleStudent(@RequestBody List<Student> students) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createMultipleStudent(students));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(student));
    }

    @PutMapping(value = "/update/{studentId}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student,
                                           @PathVariable(value = "studentId") long studentId) {

        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(student, studentId));
    }

    @DeleteMapping(value = "/{studentId}")
    public ResponseEntity<?> deleteStudentId(@PathVariable(value = "studentId") long studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudent(studentId));
    }

}
