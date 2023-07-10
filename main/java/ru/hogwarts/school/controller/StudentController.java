package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("{studentId}")
    public ResponseEntity getStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping()
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/faculty_id/{faculty_id}")
    public ResponseEntity getStudent(@PathVariable long faculty_id) {
        Set<Student> students = studentService.findStudentsByFaculty_Id(faculty_id);
        if(students == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/find_student_by_age_between/")
    public ResponseEntity findStudentsByAgeBetween(@RequestParam int min, @RequestParam int max) {
        Collection<Student> students = studentService.findStudentsByAgeBetween(min, max);
        if(students == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }




/*    @GetMapping("/age/{studentAge}")
    public ResponseEntity studentExtractByAge (@PathVariable int studentAge) {
        List<Student> students = studentService.studentExtractByAge(studentAge);
        if(students == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }*/
    
}
