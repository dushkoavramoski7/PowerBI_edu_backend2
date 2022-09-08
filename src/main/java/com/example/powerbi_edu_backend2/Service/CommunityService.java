package com.example.powerbi_edu_backend2.Service;

import com.example.powerbi_edu_backend2.Model.Entities.CommunityDocuments;
import com.example.powerbi_edu_backend2.Model.Entities.CommunityLinks;
import com.example.powerbi_edu_backend2.Model.dto.CommunityLinkResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CommunityService {

    void uploadDocument(MultipartFile file, String description) throws IOException;

    List<CommunityDocuments> findAllDocuments();

    CommunityDocuments findById(Long id);

    void deleteById(Long id);

    List<CommunityLinks> findAllLinks();

    void addCommunityLink(CommunityLinkResource communityLinkResource);

    void deleteLinkById(Long id);
}