package com.example.powerbi_edu_backend2.Service.impl;

import com.example.powerbi_edu_backend2.Model.Entities.Influencers;
import com.example.powerbi_edu_backend2.Repository.InfluencersRepository;
import com.example.powerbi_edu_backend2.Service.InfluencersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencersServiceImpl implements InfluencersService {
    private final InfluencersRepository influencersRepository;

    public InfluencersServiceImpl(InfluencersRepository influencersRepository) {
        this.influencersRepository = influencersRepository;
    }

    @Override
    public List<Influencers> findAll() {
        return this.influencersRepository.findAll();
    }
}
