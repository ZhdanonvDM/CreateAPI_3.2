package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;
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
    public Set<Student> findStudentsByFaculty_Id(long faculty_id) {
        return sr.findStudentsByFaculty_Id(faculty_id);
    }

    public Collection<Student> findStudentsByAgeBetween(int min, int max) {
        return sr.findStudentsByAgeBetween(min, max);
    }

    //Получение списка студентов по возрасту
/*    public List<Student> studentExtractByAge(int age) {
        return students.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }*/
}
