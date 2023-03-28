package com.qyon.backend.entity.ofx;

import javax.persistence.*;


@Entity
public class SignonRequestMessageSetV1 {
    @Id
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name= "signonRequest_id")
    private Integer signonRequest;

    public SignonRequestMessageSetV1(Integer id, Integer signonRequest) {
        this.id = id;
        this.signonRequest = signonRequest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSignonRequest() {
        return signonRequest;
    }

    public void setSignonRequest(Integer signonRequest) {
        this.signonRequest = signonRequest;
    }
}
