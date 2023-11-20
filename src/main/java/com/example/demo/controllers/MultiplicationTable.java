package com.example.demo.controllers;

import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.OperationsEntity;
import com.example.demo.services.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/operations3")
public class MultiplicationTable {

    @Autowired
    private Operations operations;
    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/findall")
    public Iterable<OperationsEntity> multiplicationTable(){
        return historyRepository.findAll();
    }


    @GetMapping("/operation")
    public String multiplicationTable2(@RequestParam int number){
        return operations.multiplicationTable(number);
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
