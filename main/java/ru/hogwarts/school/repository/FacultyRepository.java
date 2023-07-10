package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Set;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
 //   public Faculty findFacultyByStudents(Set<Student> students);
//    public Faculty findFacultyByStudentsContainingIgnoreCase (String studentName);
//    public Faculty findFacultyById (long id);

    public Faculty findFacultyByColorOrNameIgnoreCase (String color, String name);

}
