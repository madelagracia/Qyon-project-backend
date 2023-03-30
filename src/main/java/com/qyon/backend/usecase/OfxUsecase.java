package com.qyon.backend.usecase;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.qyon.backend.model.*;
import com.qyon.backend.repository.OfxRepository;

import net.sf.ofx4j.domain.data.RequestEnvelope;
import net.sf.ofx4j.domain.data.RequestMessage;
import net.sf.ofx4j.domain.data.RequestMessageSet;
import net.sf.ofx4j.domain.data.ResponseEnvelope;
import net.sf.ofx4j.domain.data.banking.BankStatementRequestTransaction;
import net.sf.ofx4j.domain.data.banking.BankingRequestMessageSet;
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

    public List<OfxModel> findAll() {
        return repository.findAll();
    }

    public void delete(Integer Id) {
        repository.findById(Id);
    }

    public Optional<OfxModel> findById(Integer Id) {
        return repository.findById(Id);
    }

    public String upload(MultipartFile file) {
        AggregateUnmarshaller<RequestEnvelope> unmarshaller = new AggregateUnmarshaller<RequestEnvelope>(
                RequestEnvelope.class);

        try {
            InputStream inputStream = file.getInputStream();
            RequestEnvelope envelope = unmarshaller.unmarshal(inputStream);

            // salva no diretório
            File ofxFile = new File("C:\\ofx\\" + envelope.getUID() + ".ofx");
            file.transferTo(ofxFile);
            
            SignonRequestMessageSet signonRequestMessageSet = envelope.getMessageSets().stream()
                .filter(SignonRequestMessageSet.class::isInstance) // filtra pelo objeto instanciado
                .map(SignonRequestMessageSet.class::cast) // converte para objeto desejado
                .collect(Collectors.toList()).get(0); // obtem o primeiro objeto da lista filtrada

            BankingRequestMessageSet bankingRequestMessageSet = envelope.getMessageSets().stream()
                .filter(BankingRequestMessageSet.class::isInstance)
                .map(BankingRequestMessageSet.class::cast)
                .collect(Collectors.toList()).get(0);

            SignonRequest signonRequest = signonRequestMessageSet.getSignonRequest();
            BankStatementRequestTransaction statementRequest = bankingRequestMessageSet.getStatementRequest();

            FinancialInstitutionModel fi = new FinancialInstitutionModel();
            fi.setFid(signonRequest.getFinancialInstitution().getId());
            fi.setOrg(signonRequest.getFinancialInstitution().getOrganization());

            // salvar fi

            SignonRequestModel srd = new SignonRequestModel();
            srd.setAppId(signonRequest.getApplicationId());
            srd.setAppVersion(signonRequest.getApplicationVersion());
            srd.setFinancialInstitution(fi);
            srd.setLanguage(signonRequest.getLanguage());
            srd.setPwd(signonRequest.getPassword());
            srd.setUid(signonRequest.getUserId());

            // salvar srd

            SignonRequestMessageModel sr = new SignonRequestMessageModel();
            sr.setSignonRequest(srd);

            // salvar sr

            BankAccountModel ba = new BankAccountModel();
            ba.setBankId(statementRequest.getMessage().getAccount().getBankId());
            ba.setAccountId(statementRequest.getMessage().getAccount().getAccountNumber());
    
            BankStatementRequestModel bsd = new BankStatementRequestModel();
            bsd.setUid(statementRequest.getUID());
            bsd.setBankAccount(ba);
    
            BankingRequestMessageModel bs = new BankingRequestMessageModel();
            bs.setBankingRequestMessage(bsd);;
    
            OfxModel ofx = new OfxModel();
            ofx.setBankingRequestMessage(bs);
            ofx.setSignonRequestMessage(sr);;

            repository.save(ofx);

          return ofx.getId().toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
