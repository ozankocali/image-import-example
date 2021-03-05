package com.ozeeesoftware.imageimportexample.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "deleted = false")
@Data
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "imageName")
    private String name;
    @Column(name = "imageUrl")
    private String url;

    private boolean deleted;
}
