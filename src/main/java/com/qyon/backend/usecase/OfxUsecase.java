package com.qyon.backend.usecase;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.qyon.backend.entity.ofx.BankRequestMessageSetV1;
import com.qyon.backend.entity.ofx.FinancialInstitution;
import com.qyon.backend.entity.ofx.OpenFinancialExchange;
import com.qyon.backend.repository.OfxRepository;

import net.sf.ofx4j.domain.data.RequestEnvelope;
import net.sf.ofx4j.domain.data.RequestMessage;
import net.sf.ofx4j.domain.data.RequestMessageSet;
import net.sf.ofx4j.domain.data.ResponseEnvelope;
import net.sf.ofx4j.domain.data.signon.SignonRequest;
import net.sf.ofx4j.domain.data.signon.SignonRequestMessageSet;
import net.sf.ofx4j.io.AggregateUnmarshaller;

@Component
public class OfxUsecase {

    private final OfxRepository repository;

    @Autowired
    public OfxUsecase(OfxRepository repository) {
        this.repository = repository;
    }

    public List<OpenFinancialExchange> findAll() {
        return repository.findAll();
    }

    public void delete(Integer Id) {
        repository.findById(Id);
    }

    public Optional<OpenFinancialExchange> findById(Integer Id) {
        return repository.findById(Id);
    }

    public String upload(MultipartFile file) {
        AggregateUnmarshaller<RequestEnvelope> unmarshaller = new AggregateUnmarshaller<RequestEnvelope>(
                RequestEnvelope.class);

        try {
            InputStream inputStream = file.getInputStream();
            RequestEnvelope envelope = unmarshaller.unmarshal(inputStream);

            File ofx = new File("C:\\ofx\\" + envelope.getUID() + ".ofx");
            file.transferTo(ofx);
           
            // FinancialInstitution financialInstitution = new FinancialInstitution( null, null)

          //  repository.findById(Id).map(ofxSaved ->{
          //  if(ofxFile == null)
          //  ofxFile = new OpenFinancialExchange(ofx);
          //      repository.save(ofxFile);
          //  })
          //  return ofxSaved.getId().toString();

          return "ok";

        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
