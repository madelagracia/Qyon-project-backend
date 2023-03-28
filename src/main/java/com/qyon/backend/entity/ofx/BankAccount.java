package com.qyon.backend.entity.ofx;

import javax.persistence.*;

@Entity
public class BankAccount {
    @Id
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer bankId;

    private String accountIdType;

    private String AccountEnum;

    public BankAccount(Integer id, Integer bankId, String accountIdType, String accountEnum) {
        this.id = id;
        this.bankId = bankId;
        this.accountIdType = accountIdType;
        AccountEnum = accountEnum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getAccountIdType() {
        return accountIdType;
    }

    public void setAccountIdType(String accountIdType) {
        this.accountIdType = accountIdType;
    }

    public String getAccountEnum() {
        return AccountEnum;
    }

    public void setAccountEnum(String accountEnum) {
        AccountEnum = accountEnum;
    }

}
