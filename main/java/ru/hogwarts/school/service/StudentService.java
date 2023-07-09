package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository sr;

    public StudentService(StudentRepository sr) {
        this.sr = sr;
    }

    public Student createStudent(Student student) {
        return sr.save(student);
    }

    public Student getStudentById(long studentId) {
        return sr.findById(studentId).get();
    }

    public Student updateStudent(Student student) {
        return sr.save(student);
    }

    public void deleteStudent (Long studentId) {
        sr.deleteById(studentId);
        }

    //Получение списка студентов по возрасту
/*    public List<Student> studentExtractByAge(int age) {
        return students.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }*/
}
