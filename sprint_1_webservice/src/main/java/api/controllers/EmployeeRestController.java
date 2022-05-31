package api.controllers;

import api.dto.EmployeeDto;
import api.models.*;
import api.services.IEmployeeService;
import api.services.IPositionService;
import api.services.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(value = "/list")
    public String listEmployee() {
        return null;
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

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteEmployee() {
        return null;
    }

}
