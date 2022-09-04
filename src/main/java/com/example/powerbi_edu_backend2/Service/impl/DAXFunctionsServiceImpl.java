package com.example.powerbi_edu_backend2.Service.impl;

import com.example.powerbi_edu_backend2.Model.Entities.DAXFunctions;
import com.example.powerbi_edu_backend2.Repository.DAXFunctionsRepository;
import com.example.powerbi_edu_backend2.Service.DAXFunctionsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DAXFunctionsServiceImpl implements DAXFunctionsService {
    private final DAXFunctionsRepository daxFunctionsRepository;

    public DAXFunctionsServiceImpl(DAXFunctionsRepository daxFunctionsRepository) {
        this.daxFunctionsRepository = daxFunctionsRepository;
    }

    @Override
    public List<DAXFunctions> findAll() {
        return this.daxFunctionsRepository.findAll();
    }

    @Override
    public List<String> findAllDAXFuncCategories() {
        return this.daxFunctionsRepository.findAll().stream().map(DAXFunctions::getCategory).distinct().collect(Collectors.toList());
    }
}
