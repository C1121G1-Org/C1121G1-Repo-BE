package api.controllers;

import api.services.IAccountService;
import api.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/home")
public class AccountRestController {

    @Autowired
    IAccountService iAccountService;

    @Autowired
    IRoleService iRoleService;
}
