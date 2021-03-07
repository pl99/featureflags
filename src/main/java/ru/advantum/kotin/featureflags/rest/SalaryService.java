package ru.advantum.kotin.featureflags.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.advantum.kotin.featureflags.config.FeatureAssociation;
import ru.advantum.kotin.featureflags.config.MyFeatures;
import ru.advantum.kotin.featureflags.dao.Employee;
import ru.advantum.kotin.featureflags.dao.EmployeeRepository;

@Service
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
@Slf4j
public class SalaryService {

    @Autowired
    EmployeeRepository employeeRepository;

    @FeatureAssociation(value = MyFeatures.EMPLOYEE_MANAGEMENT_FEATURE)
    public void increaseSalary(long id) {
        log.info("{}", MyFeatures.EMPLOYEE_MANAGEMENT_FEATURE.isActive());
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (null != employee) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * 0.1);
            employeeRepository.save(employee);
        }
    }
}