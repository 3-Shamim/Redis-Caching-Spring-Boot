package com.learningstuff.rediscachingspringboot.repositories;

import com.learningstuff.rediscachingspringboot.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২/১/২০
 * Time: ৯:১৬ AM
 * Email: mdshamim723@gmail.com
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
