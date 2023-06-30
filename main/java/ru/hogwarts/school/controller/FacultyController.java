package ru.hogwarts.school.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("{facultyId}")
    public ResponseEntity getFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedfaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedfaculty);
    }
    @DeleteMapping("{facultyId}")
    public ResponseEntity deleteFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        facultyService.deleteFaculty(facultyId);
        return ResponseEntity.ok(faculty);
    }
    @GetMapping("/color/{facultyColor}")
    public ResponseEntity facultyExtractByAge (@PathVariable String facultyColor) {
        List<Faculty> faculties = facultyService.facultyExtractByColor(facultyColor);
        if(faculties == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculties);
    }
}