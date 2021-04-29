package com.devglan.springboothibernatelogin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameImage;

    private String typeImage;

    @Lob
    private byte[] dataImage;


    public Image(String fileName, String contentType, byte[] bytes) {
    }
}
