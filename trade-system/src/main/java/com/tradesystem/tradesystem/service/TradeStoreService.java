package com.tradesystem.tradesystem.service;

import com.tradesystem.tradesystem.exception.TradeSystemException;
import com.tradesystem.tradesystem.model.TradeStoreDTO;

import java.util.Date;
import java.util.List;

public interface TradeStoreService {

    public List<TradeStoreDTO> getAllTradeStoreInformation();

    public void saveTrade(TradeStoreDTO tradeStoreDTO);

    public boolean validateVersion(Integer version,final String tradeId) throws TradeSystemException;

    public boolean validateMaturiyDate(Date maturityDate) throws TradeSystemException;

    public void checkAndupdateMaturedTradesToExpired(TradeStoreDTO tradeStoreDTO) throws TradeSystemException;
}
