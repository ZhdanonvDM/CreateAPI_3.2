package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Collection<Student> findStudentsByAgeBetween(int min, int max);
    //    public Set<Student> findStudentsByFaculty_Id(long faculty_id);
    @Query (value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    public int findCountOfStudents ();
    @Query (value = "SELECT AVG(age) FROM student", nativeQuery = true)
    public float findAverageAgeOfStudents ();

    @Query (value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    public List<Student> findLastFiveOfStudents ();

}
