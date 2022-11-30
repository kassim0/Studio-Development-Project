package accesingdatamysql.repository;
import org.springframework.data.repository.CrudRepository;

import accesingdatamysql.entity.Course;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CourseRepository extends CrudRepository<Course, Integer> {

}