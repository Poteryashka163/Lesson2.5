package controller;
import service.DepartmentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentsService departmentsService;
    public DepartmentsController (DepartmentsService departmentsService){
        this.departmentsService=departmentsService;}
    @GetMapping(path = "/max-salary")
    public String maxSalary (@RequestParam int departmentId){
        return null;
    }
    @GetMapping(path = "/min-salary")
    public String minSalary (@RequestParam int departmentId){
        return null;
    }
    @GetMapping(path = "/all")
    public String allId (@RequestParam int departmentId){
        return null;
    }

}
