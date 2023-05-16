package com.pocketMoney.money.reporiste;

import com.pocketMoney.money.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    boolean findFirstByEmail(String email);

    Student findByEmailAndPassword(String email, String password);
}
