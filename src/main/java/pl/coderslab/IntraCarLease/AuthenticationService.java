package pl.coderslab.IntraCarLease;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.IntraCarLease.model.CarUser;
import pl.coderslab.IntraCarLease.model.Employee;
import pl.coderslab.IntraCarLease.model.Lessor;
import pl.coderslab.IntraCarLease.repository.CarUserRepository;
import pl.coderslab.IntraCarLease.repository.EmployeeRepository;
import pl.coderslab.IntraCarLease.repository.LessorRepository;

@Service
public class AuthenticationService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CarUserRepository carUserRepository;
    @Autowired
    private LessorRepository lessorRepository;

    // for Fleet Manager
    public boolean givenEmailExistInDatabase(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if(employee != null) {
            return true;
        }
        return false;
    }
    public Employee authenticateEmployee(String email, String password) {
        Employee employee = employeeRepository.findByEmail(email);
        boolean equalPassword = BCrypt.checkpw(password, employee.getPassword());
        if (equalPassword) {
            return employee;
        }
        return null;
    }

    // for Car User
    public boolean givenCompanyIdExistInDatabse(String companyId) {
        CarUser carUser = carUserRepository.findByCompanyId(companyId);
        if (carUser != null) {
            return true;
        }
        return false;
    }
    public CarUser authenticateDriver(String email) {
        CarUser carUser = carUserRepository.findByEmail(email);
        return carUser;
    }

    // for Lessor
    public boolean givenLessorNameExistInDatabase(String fullName) {
        Lessor lessor = lessorRepository.findByFullName(fullName);
        if(lessor != null) {
            return true;
        }
        return false;
    }
    public Lessor authenticateLessor (String nip) {
        Lessor lessor = lessorRepository.findByNip(nip);
        return lessor;
    }
}
