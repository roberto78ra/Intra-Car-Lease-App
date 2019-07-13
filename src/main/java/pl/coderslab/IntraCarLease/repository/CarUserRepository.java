package pl.coderslab.IntraCarLease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.IntraCarLease.model.CarUser;

@Repository
public interface CarUserRepository extends JpaRepository<CarUser, Long> {

    CarUser findByCompanyId(String companyId);
    CarUser findByEmail(String email);
    CarUser findByFullName(String fullName);
}
