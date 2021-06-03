package com.devglan.springboothibernatelogin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 35, unique = true)
    private String nameProduct;

    @Column(nullable = false, length = 250)
    private String descriptionProduct;

    @Column(nullable = false, length = 250)
    private Double priceProduct;

    @NotNull
    private int qntStockProduct;

    /*
    @ElementCollection
    @CollectionTable(name="listOfUsers")
    private ArrayList<String> images = new ArrayList<String>();*/


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categorie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

}
