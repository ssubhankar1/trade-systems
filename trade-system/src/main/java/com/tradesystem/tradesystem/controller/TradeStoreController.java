package com.tradesystem.tradesystem.controller;

import com.tradesystem.tradesystem.exception.TradeSystemException;
import com.tradesystem.tradesystem.model.ErrorConstants;
import com.tradesystem.tradesystem.model.TradeStoreDTO;
import com.tradesystem.tradesystem.service.TradeStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api/tradestore")
public class TradeStoreController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = true)
    private TradeStoreService tradeStoreService;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "Trade Store is UP and Running";
    }

    @GetMapping("/{boookingId}/{version}/")
    public TradeStoreDTO getTradeStoreInformation(@PathVariable("id") long boookingId){

        return null;
    }

    @GetMapping(value = "/getTradeStoreInformation",
                produces = "application/json")
    public List<TradeStoreDTO> getAllTradeStoreInformation(){
        List<TradeStoreDTO> tradeStoreInformation = null;
        try{
            tradeStoreInformation= tradeStoreService.getAllTradeStoreInformation();
        }catch(TradeSystemException exception){
            logger.error("Exception = "+exception);
        }
        return tradeStoreInformation;
    }

    @PostMapping("/saveTrade")
    public TradeStoreDTO saveTradeStoreInformation(@RequestBody TradeStoreDTO tradeStoreDTO){
        // call service to perform valdiate and save operation
        try{
            tradeStoreService.validateVersion(tradeStoreDTO.getVersion(),tradeStoreDTO.getTradeId());
            tradeStoreService.validateMaturiyDate(tradeStoreDTO.getMaturityDate());
            // if all true then save will be called
            tradeStoreService.saveTrade(tradeStoreDTO);
        }catch(TradeSystemException tradeSystemException){
            logger.error("Exception = "+tradeSystemException);
            tradeStoreDTO.setErrorDetails(tradeSystemException.toString());
        }
        return tradeStoreDTO;
    }

    @PostMapping("/updateMaturedTradesToExpired")
    public TradeStoreDTO checkAndupdateMaturedTradesToExpired(@RequestBody TradeStoreDTO tradeStoreDTO){
        try {
            tradeStoreService.checkAndupdateMaturedTradesToExpired(tradeStoreDTO);
        }catch(TradeSystemException tradeSystemException){
            logger.error("Exception = "+tradeSystemException);
            tradeStoreDTO.setErrorDetails(tradeSystemException.toString());
        }
        return tradeStoreDTO;
    }
}
