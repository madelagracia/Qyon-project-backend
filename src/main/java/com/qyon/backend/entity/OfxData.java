package com.qyon.backend.entity;

import javax.persistence.*;


@Entity
public class OfxData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private byte[] ofxData;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getOfxData() {
        return ofxData;
    }

    public void setOfxData(byte[] ofxData) {
        this.ofxData = ofxData;
    }

   

    

}
