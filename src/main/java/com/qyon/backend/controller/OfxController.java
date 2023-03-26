package com.qyon.backend.controller;

import java.io.File;
import java.io.InputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sf.ofx4j.domain.data.RequestEnvelope;
import net.sf.ofx4j.io.AggregateUnmarshaller;

@RestController
public class OfxController {

    @PostMapping("/upload")
     public String fileUpload(@RequestParam("file") MultipartFile file) {

        AggregateUnmarshaller<RequestEnvelope> unmarshaller = new AggregateUnmarshaller<RequestEnvelope>(
            RequestEnvelope.class);
        
        try {
            InputStream inputStream = file.getInputStream();
            RequestEnvelope envelope = unmarshaller.unmarshal(inputStream);

            File ofx = new File("C:\\ofx\\" + envelope.getUID() + ".ofx");
            file.transferTo(ofx);

        } catch (Exception e) {
            return e.getMessage();
        }

        return "ok";
    }
}   
