package com.ozeeesoftware.imageimportexample.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Data
public class ImageStorageProperties {
    private String uploadDir;
}
