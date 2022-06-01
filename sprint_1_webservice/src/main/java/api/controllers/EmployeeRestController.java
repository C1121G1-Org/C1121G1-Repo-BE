package api.controllers;

import api.models.Employee;
import api.models.Position;
import api.services.IEmployeeService;
import api.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IPositionService iPositionService;


    @ModelAttribute("positionObj")
    public List<Position> positionList() {
        return iPositionService.findAll();
    }


    /*
  Created by HuyNH
  Time: 19:00 31/05/2022
  Function:     findAllEmployee = list Employee

*/
    @GetMapping(value = {"/list"})
    public ResponseEntity<Page<Employee>>findAllEmployee(@PageableDefault(value = 2)Pageable pageable,
                                                         @RequestParam Optional<String> keyName) {
        String nameValue = keyName.orElse("");

        Page<Employee> employeePage = iEmployeeService.findAllEmployee(pageable, nameValue);
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public String createEmployee(){
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateEmployee(){
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteEmployee(){
        return null;
    }


    /*
  Created by HuyNH
  Time: 19:00 31/05/2022
  Function:     findAllEmployee = delete flag employee

*/
    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
    Employee employee = iEmployeeService.findById(id);
    if (employee == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
        iEmployeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
