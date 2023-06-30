package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedFacultyId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculties.put(generatedFacultyId, faculty);
        generatedFacultyId++;
        return faculty;
    }

    public Faculty getFacultyById(Long facultyId) {
        return faculties.get(facultyId);
    }

    public Faculty updateFaculty(Long facultyId, Faculty faculty) {
        faculties.put(facultyId, faculty);
        return faculty;
    }

    public Faculty deleteFaculty (Long facultyId) {
        return faculties.remove(facultyId);
    }

    //Получение списка факультетов по цвету
    public List<Faculty> facultyExtractByColor(String color) {
        return faculties.values().stream()
                .filter(e -> e.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
