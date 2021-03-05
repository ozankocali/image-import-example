package com.ozeeesoftware.imageimportexample.controller;

import com.ozeeesoftware.imageimportexample.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/addImage/{studentId}")
    public ResponseEntity<Object> storeImage(@RequestParam("file") MultipartFile image, @PathVariable long studentId) {
        return imageService.storeImage(image,studentId);
    }


    @GetMapping("/downloadImage/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String imageName, HttpServletRequest request) {
        Resource resource = imageService.loadFileAsResource(imageName);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception ex) {
            return  ResponseEntity.notFound().build();
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
