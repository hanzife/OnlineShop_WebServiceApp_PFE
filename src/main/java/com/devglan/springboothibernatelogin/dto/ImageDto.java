package com.devglan.springboothibernatelogin.dto;

import com.devglan.springboothibernatelogin.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ImageDto {

    private String urlImage;
    private String typeImage;
    private long product;

}
