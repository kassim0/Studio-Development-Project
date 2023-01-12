package accesingdatamysql.repository;

import accesingdatamysql.entity.Course;
import accesingdatamysql.entity.LA;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UsersRepository extends CrudRepository<LA, Integer> {
    @Query("SELECT id FROM users u WHERE u.name=:name2")
    Integer findByName(@Param("name2") String name2);


}