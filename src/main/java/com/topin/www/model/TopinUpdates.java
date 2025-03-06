package com.topin.www.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class TopinUpdates {

    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private String status;

    @ManyToOne 
    @JoinColumn(name = "topin_update_id") 
    private Topin topin;
}
