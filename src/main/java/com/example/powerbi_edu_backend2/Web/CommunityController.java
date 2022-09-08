package com.example.powerbi_edu_backend2.Web;

import com.example.powerbi_edu_backend2.Model.Entities.CommunityDocuments;
import com.example.powerbi_edu_backend2.Model.Entities.CommunityLinks;
import com.example.powerbi_edu_backend2.Model.dto.CommunityLinkResource;
import com.example.powerbi_edu_backend2.Service.CommunityService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/community")
@CrossOrigin(value = "*")
public class CommunityController {
    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping(value = "/uploadDocument/{description}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadDocument(@RequestParam MultipartFile file, @PathVariable String description) throws IOException {
        this.communityService.uploadDocument(file, description);
    }

    @GetMapping("/documents")
    public List<CommunityDocuments> findAllDocuments() {
        return  this.communityService.findAllDocuments();
    }

    @GetMapping("/document/{id}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable Long id) {

        CommunityDocuments doc = this.communityService.findById(id);
        ByteArrayResource resource = new ByteArrayResource(doc.getContent());

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + doc.getFileName())
                .contentLength(doc.getSize())
                .contentType(MediaType.parseMediaType(doc.getContentType()))
                .body(resource);
    }

    @DeleteMapping("/document/delete/{id}")
    public void deleteDocument(@PathVariable Long id) {
        this.communityService.deleteById(id);
    }


    @GetMapping("/links")
    public List<CommunityLinks> findAllLinks() {
        return  this.communityService.findAllLinks();
    }


    @PostMapping("/addLink")
    public void addCommunityLink(@RequestBody CommunityLinkResource communityLinkResource) {
        this.communityService.addCommunityLink(communityLinkResource);
    }

    @DeleteMapping("/link/delete/{id}")
    public void deleteLink(@PathVariable Long id) {
        this.communityService.deleteLinkById(id);
    }
}
