package com.example.demo.controllers;

import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.OperationsEntity;
import com.example.demo.services.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/operations4")
public class Imc {

    @Autowired
    private Operations operations;
    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/findall")
    public Iterable<OperationsEntity> imc(){
        return historyRepository.findAll();
    }

    @GetMapping("/operation")
    public String imc2(@RequestParam double height, double weight){
        return operations.imc(height, weight);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean prueba(@PathVariable Long id){

        if (!historyRepository.findById(id).equals(Optional.empty())){
            historyRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
