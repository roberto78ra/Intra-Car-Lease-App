package pl.coderslab.IntraCarLease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.IntraCarLease.model.Lessor;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Long> {

    Lessor findById(long id);
    Lessor findByFullName(String fullName);
    Lessor findByNip(String nip);

}
