package com.upgrad.payment.controller;

import com.upgrad.payment.dto.TransactionDetailsEntityDTO;
import com.upgrad.payment.model.TransactionDetailsEntity;
import com.upgrad.payment.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Integer> getPayment(@RequestBody TransactionDetailsEntityDTO entityDTO)
    {
        TransactionDetailsEntity entity=modelMapper.map(entityDTO, TransactionDetailsEntity.class);
        int id=paymentService.saveDetails(entity);
        return new ResponseEntity<Integer>(id, HttpStatus.CREATED);

    }


    @GetMapping(value="/{transactionid}", produces =MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<TransactionDetailsEntityDTO> getDetails(@PathVariable int transactionid)
    {
        TransactionDetailsEntity entity=paymentService.getDetails(transactionid);
        TransactionDetailsEntityDTO entityDTO=modelMapper.map(entity, TransactionDetailsEntityDTO.class);

        return new ResponseEntity<TransactionDetailsEntityDTO>(entityDTO,HttpStatus.OK);
    }
}
