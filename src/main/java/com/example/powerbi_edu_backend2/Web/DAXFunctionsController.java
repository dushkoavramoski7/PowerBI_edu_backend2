package com.example.powerbi_edu_backend2.Web;


import com.example.powerbi_edu_backend2.Model.Entities.DAXFunctions;
import com.example.powerbi_edu_backend2.Service.DAXFunctionsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/DAXFunctions")
@CrossOrigin(value = "*")
public class DAXFunctionsController {
    private final DAXFunctionsService daxFunctionsService;

    public DAXFunctionsController(DAXFunctionsService daxFunctionsService) {
        this.daxFunctionsService = daxFunctionsService;
    }

    @GetMapping
    public List<DAXFunctions> getAllDAXFunctions() {
        return this.daxFunctionsService.findAll();
    }

    @GetMapping("/categories")
    public List<String> getAllDAXFunctionsCategories() {
        return this.daxFunctionsService.findAllDAXFuncCategories();
    }
}
