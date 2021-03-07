package ru.advantum.kotin.featureflags;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.advantum.kotin.featureflags.dao.Employee;
import ru.advantum.kotin.featureflags.dao.EmployeeRepository;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SetupEmp implements CommandLineRunner {
    EmployeeRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Employee emp = new Employee(1, 2000.0d);
        repository.save(emp);

    }
}
