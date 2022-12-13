package accesingdatamysql.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import accesingdatamysql.entity.Course;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Query("SELECT name FROM Course c WHERE c.name=:name2")
    Course findByName(@Param("name2") String name2);
}