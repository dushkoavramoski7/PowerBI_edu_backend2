package com.example.powerbi_edu_backend2.Service;

import com.example.powerbi_edu_backend2.Model.Entities.DAXFunctions;

import java.util.List;

public interface DAXFunctionsService {

    List<DAXFunctions> findAll();

    List<String> findAllDAXFuncCategories();
}
