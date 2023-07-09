package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
/*    private Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedFacultyId = 1L;*/

    private final FacultyRepository fr;

    public FacultyService(FacultyRepository fr) {
        this.fr = fr;
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

    //Получение списка факультетов по цвету
/*    public List<Faculty> facultyExtractByColor(String color) {
        return faculties.values().stream()
                .filter(e -> e.getColor().equals(color))
                .collect(Collectors.toList());
    }*/
}
