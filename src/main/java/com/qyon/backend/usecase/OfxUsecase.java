package com.qyon.backend.usecase;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.qyon.backend.entity.OfxData;
import com.qyon.backend.repository.OfxRepository;

import net.sf.ofx4j.domain.data.RequestEnvelope;
import net.sf.ofx4j.io.AggregateUnmarshaller;

@Component
public class OfxUsecase {

    private final OfxRepository repository;

    @Autowired
    public OfxUsecase(OfxRepository repository) {
        this.repository = repository;
    }

    public List<OfxData> findAll() {
        return repository.findAll();
    }

    public void delete(Integer Id) {
        repository.findById(Id);
    }

    public Optional<OfxData> findById(Integer Id) {
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

            OfxData data = new OfxData();
            repository.save(data);

            return data.getId().toString();

        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
