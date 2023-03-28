package com.qyon.backend.entity.ofx;

import javax.persistence.*;

@Entity
public class IncTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String include;

    public IncTransaction(Integer id, String include) {
        this.id = id;
        this.include = include;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

}
