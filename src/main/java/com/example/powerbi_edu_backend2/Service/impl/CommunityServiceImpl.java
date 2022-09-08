package com.example.powerbi_edu_backend2.Service.impl;

import com.example.powerbi_edu_backend2.Model.Entities.CommunityDocuments;
import com.example.powerbi_edu_backend2.Model.Entities.CommunityLinks;
import com.example.powerbi_edu_backend2.Model.dto.CommunityLinkResource;
import com.example.powerbi_edu_backend2.Repository.CommunityDocumentsRepository;
import com.example.powerbi_edu_backend2.Repository.CommunityLinksRepository;
import com.example.powerbi_edu_backend2.Service.CommunityService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityServiceImpl implements CommunityService {
    private final CommunityDocumentsRepository communityDocumentsRepository;
    private final CommunityLinksRepository communityLinksRepository;

    public CommunityServiceImpl(CommunityDocumentsRepository communityDocumentsRepository, CommunityLinksRepository communityLinksRepository) {
        this.communityDocumentsRepository = communityDocumentsRepository;
        this.communityLinksRepository = communityLinksRepository;
    }

    @Override
    public void uploadDocument(MultipartFile file, String description) throws IOException {
        this.communityDocumentsRepository.save(new CommunityDocuments(file.getOriginalFilename(), file.getContentType(), file.getSize(), description, file.getBytes(), LocalDateTime.now(), true));
    }

    public List<CommunityDocuments> findAllDocuments() {
        return this.communityDocumentsRepository.findAll();
    }

    @Override
    public CommunityDocuments findById(Long id) {
        Optional<CommunityDocuments> communityDocuments = this.communityDocumentsRepository.findById(id);
        return communityDocuments.orElse(null);
    }


    @Override
    public void deleteById(Long id) {
         this.communityDocumentsRepository.deleteById(id);
    }

    @Override
    public List<CommunityLinks> findAllLinks() {
        return communityLinksRepository.findAll();
    }

    @Override
    public void addCommunityLink(CommunityLinkResource communityLinkResource) {
        this.communityLinksRepository.save(new CommunityLinks(communityLinkResource.getName(), communityLinkResource.getDescription(), communityLinkResource.getUrl(), LocalDateTime.now(), true));
    }

    @Override
    public void deleteLinkById(Long id) {
        this.communityLinksRepository.deleteById(id);
    }
}
