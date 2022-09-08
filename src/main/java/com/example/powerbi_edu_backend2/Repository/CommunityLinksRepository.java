package com.example.powerbi_edu_backend2.Repository;

import com.example.powerbi_edu_backend2.Model.Entities.CommunityLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityLinksRepository extends JpaRepository<CommunityLinks, Long> {
}
