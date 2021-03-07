//package ru.advantum.kotin.featureflags.rest;
//
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import ru.advantum.kotin.featureflags.dao.Employee;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("emp")
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
//public class EmployeeController {
//
//    EmployeeService service;
//    SalaryService salaryService;
//
//    @GetMapping
//    List<Employee> getAll() {
//        return service.getAll();
//    }
//
//    //    @PutMapping("{id}")
////    Employee increaseSalary(@PathVariable Long id,  @RequestBody Employee entity){
////        return service.increaseSalary(id, entity);
////    }
//    @PostMapping("/increaseSalary")
//    public void increaseSalary(@RequestParam long id) {
//        salaryService.increaseSalary(id);
//    }
//
//
//}
