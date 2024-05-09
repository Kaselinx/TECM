package com.taishinlife.tecm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "act_ge_property", schema = "dbo")
public class ActGeProperty {

    @Id
    @Column(name = "NAME_")
    private String name;

    @Column(name = "VALUE_")
    private String value;

    @Column(name = "REV_")
    private Integer rev;

    // getters and setters
}