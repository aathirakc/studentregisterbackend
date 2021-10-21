package com.studentapp.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long>{
//	@Query("{'name':1}")
//   public List<Student> findAllOrderByNameAsc();
}
