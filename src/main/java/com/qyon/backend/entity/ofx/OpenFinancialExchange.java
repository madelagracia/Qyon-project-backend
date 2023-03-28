package com.qyon.backend.entity.ofx;

import javax.persistence.*;

@Entity
public class OpenFinancialExchange {
    @Id
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn (name ="bankRequestMessageSetV1t_id")
    private Integer bankRequestMessageSetV1;

    @OneToOne
    @JoinColumn (name ="signonRequestMessageSetV1_id")
    private Integer signonRequestMessageSetV1;

    public OpenFinancialExchange(Integer id, Integer bankRequestMessageSetV1, Integer signonRequestMessageSetV1) {
        this.id = id;
        this.bankRequestMessageSetV1 = bankRequestMessageSetV1;
        this.signonRequestMessageSetV1 = signonRequestMessageSetV1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankRequestMessageSetV1() {
        return bankRequestMessageSetV1;
    }

    public void setBankRequestMessageSetV1(Integer bankRequestMessageSetV1) {
        this.bankRequestMessageSetV1 = bankRequestMessageSetV1;
    }

    public Integer getSignonRequestMessageSetV1() {
        return signonRequestMessageSetV1;
    }

    public void setSignonRequestMessageSetV1(Integer signonRequestMessageSetV1) {
        this.signonRequestMessageSetV1 = signonRequestMessageSetV1;
    }
    
    
}
