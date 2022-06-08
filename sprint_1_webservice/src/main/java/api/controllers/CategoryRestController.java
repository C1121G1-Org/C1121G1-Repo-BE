package api.controllers;

import api.models.Category;
import api.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    //Create by chienLV
//Time: 7h00 07/06/2022
//Function: get list category from database
    @GetMapping("/list")
    public ResponseEntity<List<Category>> getListCategory() {
        List<Category> categories = iCategoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
