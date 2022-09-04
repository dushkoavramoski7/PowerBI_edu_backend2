package com.example.powerbi_edu_backend2.Web;

import com.example.powerbi_edu_backend2.Model.Entities.Influencers;
import com.example.powerbi_edu_backend2.Service.InfluencersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/channels")
@CrossOrigin(value = "*")
public class InfluencersController {
    private final InfluencersService influencersService;

    public InfluencersController(InfluencersService influencersService) {
        this.influencersService = influencersService;
    }

    @GetMapping
    public List<Influencers> getAll() {
        return this.influencersService.findAll();
    }
}
