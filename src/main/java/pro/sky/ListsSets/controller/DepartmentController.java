package pro.sky.ListsSets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.ListsSets.model.Employee;
import pro.sky.ListsSets.service.DepartmentService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam("department") int department){
        return departmentService.findEmployeeWithMaxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam("department") int department){
        return departmentService.findEmployeeWithMinSalary(department);
    }

    @GetMapping(value="/all", params = "department")
    public Collection<Employee> findEmployeeFromDepartment(@RequestParam("department") int department){
        return departmentService.findEmployeeFromDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer,Collection<Employee>> findEmployees(){
        return departmentService.findEmployees();
    }
}
