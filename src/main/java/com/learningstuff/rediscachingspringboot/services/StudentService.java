package com.learningstuff.rediscachingspringboot.services;

import com.learningstuff.rediscachingspringboot.models.Student;
import com.learningstuff.rediscachingspringboot.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২/১/২০
 * Time: ৯:১৭ AM
 * Email: mdshamim723@gmail.com
 */

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

//    @Cacheable(value = "STUDENT_REPOSITORY", key = "'all'")
    @Cacheable(value = "STUDENT_SERVICE", key = "'all'")
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

//    @Cacheable(value = "STUDENT_REPOSITORY", key = "#studentId", unless = "#result.id < 2")
    @Cacheable(value = "STUDENT_SERVICE", key = "#studentId", unless = "#result.id < 2")
    public Optional<Student> findStudentById(long studentId) {
        return studentRepository.findById(studentId);
    }


    public List<Student> createMultipleStudent(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

//    @CachePut(value = "STUDENT_REPOSITORY", key = "#studentId")
    @CachePut(value = "STUDENT_SERVICE", key = "#studentId")
    public Student updateStudent(Student student, long studentId) {
        return studentRepository.findById(studentId).map(oldStudent -> {
            oldStudent.setName(student.getName());
            return studentRepository.save(oldStudent);
        }).orElseThrow(() -> new RuntimeException("Student not found by id: " + studentId));
    }

//    @CacheEvict(value = "STUDENT_REPOSITORY", allEntries=true)
    @CacheEvict(value = "STUDENT_SERVICE", allEntries=true)
    public boolean deleteStudent(long studentId) {
        return studentRepository.findById(studentId).map(student -> {
            studentRepository.delete(student);
            return true;
        }).orElseThrow(() -> new RuntimeException("Student not found by id: " + studentId));
    }
}
