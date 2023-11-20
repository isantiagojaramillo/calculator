package com.example.demo.controllers;

import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.OperationsEntity;
import com.example.demo.services.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/operations1")
public class ComputeModule {

    @Autowired
    private Operations operations;
    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/findall")
    public Iterable<OperationsEntity> computeModule(){
        return  historyRepository.findAll();

    }

    @GetMapping("/operation")
    public String computeModule2(@RequestParam Integer number1, @RequestParam Integer number2){
        return operations.computeModule(number1, number2);
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
