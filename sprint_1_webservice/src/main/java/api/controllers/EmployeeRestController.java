package api.controllers;

import api.dto.AccountDto;
import api.dto.EmployeeInterface;
import api.models.Employee;
import api.models.Position;
import api.dto.EmployeeDto;
import api.dto.PositionDto;
import api.models.*;
import api.services.*;
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
import java.util.*;
import javax.validation.Valid;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeRestController {

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
        Function: get position by id
    */
    @GetMapping(value = "/position/list")
    public ResponseEntity<ResponseObject> listPosition() {
        List<Position> positionList = getAllPosition();
        return new ResponseEntity<>(new ResponseObject(
                true, "OK", new HashMap<>(), positionList), HttpStatus.OK);
    }

    /*
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function: findAllEmployee = list Employee.
    */
    @GetMapping(value = {"/list"})

    public ResponseEntity<Page<EmployeeInterface>> findAllEmployee(@PageableDefault(value = 7) Pageable pageable,
                                                          @RequestParam Optional<String> keyName) {
        String nameValue = keyName.orElse("");

        Page<EmployeeInterface> employeePage = iEmployeeService.findAllEmployee(pageable, nameValue);
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: Create Employee
    */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createEmployee(@Valid @RequestBody EmployeeDto employeeDto,
                                                         BindingResult bindingResult) {

        employeeDto.setIEmployeeService(iEmployeeService);
        employeeDto.validate(employeeDto, bindingResult);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String checkEmail = employeeDto.getAccountDto().getEmail();
        Account account1 = this.iAccountService.findByEmail(employeeDto.getAccountDto().getEmail());
        if (account1 != null && account1.getEmail().equals(checkEmail)) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            errorMap.put("email", " email tồn tại ! ");
            return new ResponseEntity<>(new ResponseObject(false, "Failed", errorMap, new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String checkUserName = employeeDto.getAccountDto().getUserName();
        Account account = this.iAccountService.findByUserName(employeeDto.getAccountDto().getUserName());
        if (account != null && account.getUserName().equals(checkUserName)) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            errorMap.put("userName", "tên đăng nhập tồn tại ! ");
            return new ResponseEntity<>(new ResponseObject(false, "Failed", errorMap, new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);

        } else {
            account = new Account();
            Employee employee = new Employee();

            AccountRole accountRole = new AccountRole();

            Position position = new Position();
            BeanUtils.copyProperties(employeeDto, employee);
            BeanUtils.copyProperties(employeeDto.getAccountDto(), account);
            BeanUtils.copyProperties(employeeDto.getPositionDto(), position);
            account.setVerificationCode("");
            account.setIsEnabled(true);
            iAccountService.save(account);
            Role role = iRoleService.findById(position.getId());
            accountRole.setAccount(account);
            accountRole.setRole(role);
            iAccountRoleService.save(accountRole);
            employee.setPosition(position);
            employee.setAccount(account);
            employee.setDeleteFlag(false);
            iEmployeeService.save(employee);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: find Employee by id.
    */
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Long id) {
        Employee employee = this.iEmployeeService.findEmployee(id);

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
        employeeDto.setIEmployeeService(iEmployeeService);
        employeeDto.validate(employeeDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();

        if (bindingResult.hasFieldErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        } else {


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

    /*
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function: findAllEmployee = delete flag employee.
    */

    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(Optional<Employee> employee) {
        if (employee.isPresent()) {
            iEmployeeService.saveDelete(employee.get().getId());
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
