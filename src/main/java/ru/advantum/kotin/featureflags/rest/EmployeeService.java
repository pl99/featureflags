package ru.advantum.kotin.featureflags.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.advantum.kotin.featureflags.dao.Employee;
import ru.advantum.kotin.featureflags.dao.EmployeeRepository;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeService {
    EmployeeRepository repository;
    SalaryService salaryService;

    public List<Employee> getAll() {
        return repository.findAll();
    }

}
