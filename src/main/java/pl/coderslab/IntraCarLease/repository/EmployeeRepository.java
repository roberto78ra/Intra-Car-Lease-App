package pl.coderslab.IntraCarLease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.IntraCarLease.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

}
