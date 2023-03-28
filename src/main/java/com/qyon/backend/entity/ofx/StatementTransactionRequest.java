package com.qyon.backend.entity.ofx;

import javax.persistence.*;

@Entity
public class StatementTransactionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapsId
    @OneToOne(targetEntity = StatementRequest.class)
    @JoinColumn (name ="statementRequest_id")
    private Integer statementRequest;

    private Integer uid;

    public StatementTransactionRequest(Integer id, Integer statementRequest, Integer uid) {
        this.id = id;
        this.statementRequest = statementRequest;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatementRequest() {
        return statementRequest;
    }

    public void setStatementRequest(Integer statementRequest) {
        this.statementRequest = statementRequest;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
}
