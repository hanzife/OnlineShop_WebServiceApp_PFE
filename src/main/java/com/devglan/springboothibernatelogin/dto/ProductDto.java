package com.devglan.springboothibernatelogin.dto;

import com.devglan.springboothibernatelogin.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ProductDto {

    private String nameProduct;
    private String descriptionProduct;
    private int qntStockProduct;
    private int category;

}
