package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Collection<Student> findStudentsByAgeBetween(int min, int max);
    //    public Set<Student> findStudentsByFaculty_Id(long faculty_id);

}
