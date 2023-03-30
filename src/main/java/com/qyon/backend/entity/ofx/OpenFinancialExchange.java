package com.qyon.backend.entity.ofx;

import javax.persistence.*;

@Entity
public class OpenFinancialExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapsId
    @OneToOne(targetEntity = BankRequestMessageSetV1.class)
    @JoinColumn (name ="bankRequestMessageSetV1t_id")
    private Integer bankRequestMessageSetV1;

    @MapsId
    @OneToOne(targetEntity = SignonRequestMessageSetV1.class)
    @JoinColumn (name ="signonRequestMessageSetV1_id")
    private Integer signonRequestMessageSetV1;

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
