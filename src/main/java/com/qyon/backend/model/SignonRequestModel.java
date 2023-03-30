package com.qyon.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sr_data")
public class SignonRequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String uid;

    private String pwd;

    private String language;

    @OneToOne
    @JoinColumn(name = "sr_id")
    private FinancialInstitutionModel financialInstitution;

    private String appId;

    private String appVersion;
}
