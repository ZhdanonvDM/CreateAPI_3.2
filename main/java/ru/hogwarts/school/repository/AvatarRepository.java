package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Optional;
import java.util.Set;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{

    public Optional<Avatar> findAvatarByStudentId (long student_id);


}
