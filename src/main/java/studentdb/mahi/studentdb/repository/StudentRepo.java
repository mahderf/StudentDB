package studentdb.mahi.studentdb.repository;

import org.springframework.data.repository.CrudRepository;
import studentdb.mahi.studentdb.models.Student;

public interface StudentRepo extends CrudRepository <Student, Long>{
}
