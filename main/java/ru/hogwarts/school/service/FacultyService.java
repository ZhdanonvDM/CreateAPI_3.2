package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {
/*    private Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedFacultyId = 1L;*/

    private final FacultyRepository fr;

    public FacultyService(FacultyRepository fr) {
        this.fr = fr;
    }


    public String findLongTitleOfFaculty () {
        List<Faculty> faculties = fr.findAll();
/*        faculties.stream().map(Faculty::getName).map(String::length).
                max(Integer::compare).get().toString();*/
        String s = faculties.stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(v -> v.length()))
                .get().toString();
        return s;
    }

    public Faculty createFaculty(Faculty faculty) {
        return fr.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        return fr.findById(facultyId).get();
    }

    public Faculty updateFaculty(Faculty faculty) {
        return fr.save(faculty);
    }

    public void deleteFaculty (Long facultyId) {
        fr.deleteById(facultyId);
 //       return faculties.remove(facultyId);
    }

    public Faculty findFacultyByColorOrNameIgnoreCase (String color, String name) {
        return fr.findFacultyByColorOrNameIgnoreCase(color, name);
    }

/*    public Faculty findFacultyByStudents (Set<Student> students) {
        return fr.findFacultyByStudents(students);
    }*/

/*    public Faculty findFacultyByStudentsContainingIgnoreCase (String studentName) {
        return fr.findFacultyByStudentsContainingIgnoreCase(studentName);
    }*/

/*    public Faculty findFacultyById (long id) {
        return fr.findFacultyById(id);
    }*/
    //Получение списка факультетов по цвету
/*    public List<Faculty> facultyExtractByColor(String color) {
        return faculties.values().stream()
                .filter(e -> e.getColor().equals(color))
                .collect(Collectors.toList());
    }*/
}
