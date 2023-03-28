package com.qyon.backend.entity.ofx;

import javax.persistence.*;


@Entity
public class FinancialInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String org;

    private String fid;

    public FinancialInstitution(Integer id, String org, String fid) {
        this.id = id;
        this.org = org;
        this.fid = fid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

   

}
