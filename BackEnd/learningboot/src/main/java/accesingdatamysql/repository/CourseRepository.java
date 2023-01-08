package accesingdatamysql.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import accesingdatamysql.entity.Course;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Query("SELECT id FROM Course c WHERE c.name=:name2")
    Integer findByName(@Param("name2") String name2);

    @Query("SELECT id FROM Course c WHERE c.university=:univ2")
    List<Integer> getCoursesByUniversity(@Param("univ2") String univ2);
}