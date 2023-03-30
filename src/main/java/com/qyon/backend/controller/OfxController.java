package com.qyon.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qyon.backend.entity.ofx.OpenFinancialExchange;
import com.qyon.backend.usecase.OfxUsecase;


@RestController
@RequestMapping("api/ofx")
public class OfxController {

    private final OfxUsecase usecase;
    
    @Autowired
    public OfxController(OfxUsecase usecase) {
        this.usecase = usecase;
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
       return usecase.upload(file);                                        
    }

    @GetMapping("/findAll")
    public List<OpenFinancialExchange> findAll() {
        return usecase.findAll();
    }

    @PostMapping("/delete/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Integer Id) {
        usecase.findById(Id).map(record -> {
            usecase.delete(Id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/findById/{Id}")
    public ResponseEntity<OpenFinancialExchange> findById(Integer Id) {
        return usecase.findById(Id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

}
