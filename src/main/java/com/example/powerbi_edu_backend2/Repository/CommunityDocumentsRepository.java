package com.example.powerbi_edu_backend2.Repository;

import com.example.powerbi_edu_backend2.Model.Entities.CommunityDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityDocumentsRepository extends JpaRepository<CommunityDocuments, Long> {
}
