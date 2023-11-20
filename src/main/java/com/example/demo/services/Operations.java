package com.example.demo.services;

import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.OperationsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Operations {

    @Autowired
    private HistoryRepository historyRepository;


    public String computeModule(Integer number1, Integer number2) {

        int result;
        String answer;

        if (number2 != 0){
            result = number1 % number2;
            answer = "The result is: " + result;
        }else{
            answer = number2 + " can not be divided";
        }

        OperationsEntity operationsEntity = new OperationsEntity();
        operationsEntity.setOperation(answer);
        historyRepository.save(operationsEntity);

        return answer;

    }

    public String squareRoot(double number){

        double squareRoot = Math.sqrt(number);
        String result = "The Square Root of the number " + number + " is: " + squareRoot;

        OperationsEntity operationsEntity = new OperationsEntity();
        operationsEntity.setOperation(result);
        historyRepository.save(operationsEntity);

        return result;
    }


    public String multiplicationTable(Integer number){

        String table = "";
        int result;
        for (int i = 1; i <= 10; i++) {
            result = i * number;
            table += " " + number + " * " + i + " = " + result + " <br> ";
        }

        OperationsEntity operationsEntity = new OperationsEntity();
        operationsEntity.setOperation(table);
        historyRepository.save(operationsEntity);

        return table;
    }



    public String imc(double height, double weight){

        String answer = "";
        double imc = weight / (height*height);

        if (height == 0) {
            answer = "The height can not be 0";
        }else {
            if (imc <  18.5) {
                answer = "Below Normal "+ imc;
            }else if (imc >= 18.5 && imc <= 24.9) {
                answer = "Normal Weight " + imc;
            } else if (imc >= 25.0 && imc <= 29.9) {
                answer = "Above Normal " + imc;
            } else if (imc > 30.0) {
                answer = "OBESITY! " + imc;
            }
        }

        OperationsEntity operationsEntity = new OperationsEntity();
        operationsEntity.setOperation(answer);
        historyRepository.save(operationsEntity);

        return answer;
    }
}
