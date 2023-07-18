package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{
    @Query(value = "SELECT * FROM avatar", nativeQuery = true)
    public List<Avatar> findAll ();
 //   public Optional<Avatar> findAvatarByStudentId (long student_id);


}
