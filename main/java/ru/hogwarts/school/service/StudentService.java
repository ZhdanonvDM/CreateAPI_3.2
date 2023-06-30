package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private Long generatedStudentId = 1L;

    public Student createStudent(Student student) {
        students. put(generatedStudentId, student);
        generatedStudentId++;
        return student;
    }

    public Student getStudentById(Long studentId) {
        return students.get(studentId);
    }

    public Student updateStudent(Long studentId, Student student) {
        students.put(studentId, student);
        return student;
    }

    public Student deletestudent(Long studentId) {
        return students.remove(studentId);
    }

    //Получение списка студентов по возрасту
    public List<Student> studentExtractByAge(int age) {
        return students.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}
