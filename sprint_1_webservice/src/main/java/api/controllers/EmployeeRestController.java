package api.controllers;

import api.models.Employee;
import api.models.Position;
import api.dto.EmployeeDto;
import api.models.*;
import api.services.IEmployeeService;
import api.services.IPositionService;
import api.services.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import java.util.Optional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IPositionService iPositionService;

    @Autowired
    IRoleService iRoleService;

    @ModelAttribute
    public List<Role> getAllRole() {
        return iRoleService.findAll();
    }

    @ModelAttribute
    public List<Position> getAllPosition() {
        return iPositionService.findAll();
    }

    @GetMapping(value = "/position/list")
    public ResponseEntity<ResponseObject> listPosition() {
        List<Position> positionList = getAllPosition();
        return new ResponseEntity<>(new ResponseObject(true, "OK", new HashMap<>(), positionList), HttpStatus.OK);
    }

    /*
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function: findAllEmployee = list Employee.
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
    public ResponseEntity<ResponseObject> createEmployee(@Valid @RequestBody EmployeeDto employeeDto,
                                                         BindingResult bindingResult) {
        employeeDto.validate(employeeDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasFieldErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        Account account = new Account();
        AccountRole accountRole = new AccountRole();
        Position position = new Position();
        BeanUtils.copyProperties(employeeDto.getAccountDto(), account);
//        employee.setAccount(account);
//        employee.setPosition(position);
//        account.setId(account.getId());
//        accountRole.setId(accountRole.getId());
        BeanUtils.copyProperties(employeeDto, employee);
        account.setIsEnabled(true);

        return null;
    }

    @PatchMapping(value = "/update")
    public String updateEmployee() {
        return null;
    }

    /*
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function: findAllEmployee = delete flag employee.
    */
    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = iEmployeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setDeleteFlag(true);
        iEmployeeService.saveDelete(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
