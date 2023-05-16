package com.pocketMoney.money.service.Impl;

import com.pocketMoney.money.model.Student;
import com.pocketMoney.money.reporiste.StudentRepository;
import org.springframework.stereotype.Service;

import static org.springframework.util.ClassUtils.isPresent;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){ this.studentRepository = studentRepository;};

    public void registerUser(Student student) {
        studentRepository.save(student);

    }

    public Student authenticate(String email, String password) {
        Student student =  studentRepository.findByEmailAndPassword(email, password);
        return student;

    }

    public Student registerstudent() {
        return null;
    }



}
