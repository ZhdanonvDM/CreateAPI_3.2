package ru.hogwarts.school.service;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final StudentRepository sr;

    public StudentService(StudentRepository sr) {
        this.sr = sr;
    }

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public int sum () {
        System.currentTimeMillis();
        int sum = Stream
                .iterate(1, a -> a +1)
                .parallel()
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b );
        return sum;
    }



    public List<String> findNameStudentBeginA () {
        List<Student> students = sr.findAll();
        return students.stream()
                .filter(s -> s.getName().charAt(0) == 'А')
                .map(Student::getName)
                .map(s -> s.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }
    public Double findStudentAverageAge () {
        List<Student> students = sr.findAll();
        return students.stream().
                mapToInt(Student::getAge).
                average().getAsDouble();
    }

    public int findCountOfStudents () {
        return sr.findCountOfStudents();
    }

    public float findAverageAgeOfStudents () {
        return sr.findAverageAgeOfStudents();
    }
    public List<Student> findLastFiveOfStudents () {
        return sr.findLastFiveOfStudents();
    }


    public Student createStudent(Student student) {
        logger.debug("Create student {}", student);
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
/*    public Set<Student> findStudentsByFaculty_Id(long faculty_id) {
        return sr.findStudentsByFaculty_Id(faculty_id);
    }*/

    public Collection<Student> findStudentsByAgeBetween(int min, int max) {
        return sr.findStudentsByAgeBetween(min, max);
    }

    public void getStudentByThread () {
        var students = sr.findAll()
                .stream()
                .limit(6)
                .collect(Collectors.toList());
        System.out.println(students.get(0));
        System.out.println(students.get(1));
        new Thread(() -> {
            System.out.println(students.get(2));
            System.out.println(students.get(3));
        }).start();
        new Thread(() -> {
            System.out.println(students.get(4));
            System.out.println(students.get(5));
        }).start();
    }

    public void getStudentByThreadSync () {
        var students = sr.findAll()
                .stream()
                .limit(6)
                .collect(Collectors.toList());

        print(students.get(0));
        print(students.get(1));
        new Thread(() -> {
            print(students.get(2));
            print(students.get(3));
        }).start();
        new Thread(() -> {
            print(students.get(4));
            print(students.get(5));
        }).start();
    }
    private synchronized void print (Object obj) {
        System.out.println(obj.toString());
    }


}
