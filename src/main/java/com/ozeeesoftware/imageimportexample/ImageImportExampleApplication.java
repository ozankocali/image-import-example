package com.ozeeesoftware.imageimportexample;

import com.ozeeesoftware.imageimportexample.config.ImageStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ImageStorageProperties.class})
public class ImageImportExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageImportExampleApplication.class, args);
	}

}
