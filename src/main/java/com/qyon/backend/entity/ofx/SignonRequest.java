package com.qyon.backend.entity.ofx;

import javax.persistence.*;


@Entity
public class SignonRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uid;

    private String pwd;

    private String language;

    @MapsId
    @OneToOne(targetEntity = FinancialInstitution.class)
    @JoinColumn(name= "financialInstitution_id")
    private Integer financialInstitution;

    private String appId;

    private String appV;
    
    public SignonRequest(Integer id, String uid, String pwd, String language, Integer financialInstitution,
            String appId, String appV) {
        this.id = id;
        this.uid = uid;
        this.pwd = pwd;
        this.language = language;
        this.financialInstitution = financialInstitution;
        this.appId = appId;
        this.appV = appV;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(Integer financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppV() {
        return appV;
    }

    public void setAppV(String appV) {
        this.appV = appV;
    }
    
    
}
