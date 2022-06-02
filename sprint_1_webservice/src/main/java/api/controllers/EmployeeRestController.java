package api.controllers;

import api.dto.AccountDto;
import api.dto.EmployeeDto;
import api.dto.PositionDto;
import api.models.*;
import api.services.*;
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

//    @Autowired
//    private PasswordEncoder encoder;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IPositionService iPositionService;

    @Autowired
    IAccountService iAccountService;

    @Autowired
    IAccountRoleService iAccountRoleService;

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

    /*
    Created by Khoa PTD
    Time: 09:00 02/06/2022
    Function: get position
    */
    @GetMapping(value = "/position/list")
    public ResponseEntity<ResponseObject> listPosition() {
        List<Position> positionList = getAllPosition();
        return new ResponseEntity<>(new ResponseObject(
                true, "OK", new HashMap<>(), positionList), HttpStatus.OK);
    }



    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: Create Employee
    */
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
        BeanUtils.copyProperties(employeeDto, employee);
        BeanUtils.copyProperties(employeeDto.getAccountDto(), account);
        BeanUtils.copyProperties(employeeDto.getPositionDto(), position);

        account.setIsEnabled(true);
        iAccountService.save(account);
//        Account acc = iAccountService.findByUserName(account.getUserName());
        Role role = iRoleService.findById(position.getId());
        accountRole.setAccount(account);//sửa lại thành acc
        accountRole.setRole(role);
        iAccountRoleService.save(accountRole);
        employee.setPosition(position);
        employee.setAccount(account);
        iEmployeeService.save(employee);

        return new ResponseEntity<>(HttpStatus.OK);


    }

    /*
    Created by Khoa PTD
    Time: 09:00 02/06/2022
    Function: find Employee by id
*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Long id) {
        Employee employee = this.iEmployeeService.findById(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();

        BeanUtils.copyProperties(employee.getPosition(), positionDto);
        BeanUtils.copyProperties(employee.getAccount(), accountDto);

        employeeDto.setPositionDto(positionDto);
        employeeDto.setAccountDto(accountDto);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }



    /*
    Created by Khoa PTD
    Time: 09:00 02/06/2022
    Function: edit Employee
*/
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateEmployee(@PathVariable Integer id,
                                                         @Valid @RequestBody EmployeeDto employeeDto,
                                                         BindingResult bindingResult) {

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


        Position position = new Position();
        employeeDto.setId(Long.valueOf(id));
        BeanUtils.copyProperties(employeeDto, employee);
        BeanUtils.copyProperties(employeeDto.getAccountDto(), account);
        BeanUtils.copyProperties(employeeDto.getPositionDto(), position);

        account.setIsEnabled(true);

        AccountRole accountRole = iAccountRoleService.findByIdAccount(account.getId());
        System.out.println("id position" + position.getId());
        iAccountRoleService.setRoleId(accountRole.getId(), position.getId());


        employee.setPosition(position);
        employee.setAccount(account);
        System.out.println(employee.getId());

        this.iEmployeeService.update(employee, account);

        return new ResponseEntity<>(HttpStatus.OK);

    }



}
