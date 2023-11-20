package com.example.demo.controllers;

import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.OperationsEntity;
import com.example.demo.services.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/operations2")
public class SquareRoot {
    @Autowired
    private Operations operations;
    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/findall")
    public Iterable<OperationsEntity> squareRoot(){
        return historyRepository.findAll();
    }

    @GetMapping("/operation")
    public String squareRoot2(@RequestParam double number){
        return operations.squareRoot(number);
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
