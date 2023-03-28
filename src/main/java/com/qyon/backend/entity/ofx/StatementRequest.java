package com.qyon.backend.entity.ofx;

import javax.persistence.*;

@Entity
public class StatementRequest {
    @Id
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn (name ="bankAccount_id")
    private Integer bankAccount;

    @OneToOne
    @JoinColumn (name ="incTransaction_id")
    private Integer incTransaction;

    public StatementRequest(Integer id, Integer bankAccount, Integer incTransaction) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.incTransaction = incTransaction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Integer bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getIncTransaction() {
        return incTransaction;
    }

    public void setIncTransaction(Integer incTransaction) {
        this.incTransaction = incTransaction;
    }


}
