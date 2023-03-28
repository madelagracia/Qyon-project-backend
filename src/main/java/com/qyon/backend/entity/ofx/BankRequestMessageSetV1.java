package com.qyon.backend.entity.ofx;

import javax.persistence.*;

@Entity
public class BankRequestMessageSetV1 {
    @Id
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn (name ="statementTransactionRequest_id")
    private Integer statementTransactionRequest;

    public BankRequestMessageSetV1(Integer id, Integer statementTransactionRequest) {
        this.id = id;
        this.statementTransactionRequest = statementTransactionRequest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatementTransactionRequest() {
        return statementTransactionRequest;
    }

    public void setStatementTransactionRequest(Integer statementTransactionRequest) {
        this.statementTransactionRequest = statementTransactionRequest;
    }
}
