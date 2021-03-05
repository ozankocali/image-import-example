package com.ozeeesoftware.imageimportexample.repository;

import com.ozeeesoftware.imageimportexample.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
