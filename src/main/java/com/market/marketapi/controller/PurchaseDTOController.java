package com.market.marketapi.controller;

import com.market.marketapi.dto.PurchaseDTO;
import com.market.marketapi.service.PurchaseDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
@ComponentScan("market-api")
public class PurchaseDTOController {
    @Autowired
    private PurchaseDTOService purchaseDTOService;
    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getAll(){
        return new ResponseEntity<>(purchaseDTOService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDTO> getPurchase(@PathVariable("id") Integer idPurchase){
        return purchaseDTOService.getPurchase(idPurchase)
                .map(purchaseDTO -> new ResponseEntity<>(purchaseDTO,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDTO>> getByIdClient(@PathVariable("id") String idClient){
        return purchaseDTOService.getByIdClient(idClient)
                .map(purchaseDTOS -> new ResponseEntity<>(purchaseDTOS,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchaseDTO){
        return purchaseDTOService.save(purchaseDTO)
                .map(purchaseDTO1 -> new ResponseEntity<>(purchaseDTO1,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
