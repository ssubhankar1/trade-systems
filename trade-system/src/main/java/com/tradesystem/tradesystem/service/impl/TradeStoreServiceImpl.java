package com.tradesystem.tradesystem.service.impl;

import com.tradesystem.tradesystem.exception.TradeSystemException;
import com.tradesystem.tradesystem.model.ErrorConstants;
import com.tradesystem.tradesystem.model.TradeStoreDTO;
import com.tradesystem.tradesystem.persistence.entity.TradeStore;
import com.tradesystem.tradesystem.persistence.repository.TradeStoreRepository;
import com.tradesystem.tradesystem.service.TradeStoreService;
import com.tradesystem.tradesystem.util.CustomForEach;
import com.tradesystem.tradesystem.util.TradeSystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class TradeStoreServiceImpl implements TradeStoreService {

    private static Logger logger = LoggerFactory.getLogger(TradeStoreService.class);

    @Autowired
    private TradeStoreRepository tradeStoreRepository;

    @Override
    public List<TradeStoreDTO> getAllTradeStoreInformation() {
        List<TradeStoreDTO> tradeStoreDTOList = new ArrayList<>();
        try{
            Iterable<TradeStore> iterable = tradeStoreRepository.findAll();
            iterable.forEach(tradeStore->setTradeStore(tradeStoreDTOList,tradeStore));
        }catch(Exception exception){
            throw new TradeSystemException(ErrorConstants.error_code_5);
        }
        return tradeStoreDTOList;
    }

    private void setTradeStore(List<TradeStoreDTO> tradeStoreDTOList,TradeStore tradeStore){

        TradeStoreDTO tradeStoreDTO = new TradeStoreDTO();
        BeanUtils.copyProperties(tradeStore,tradeStoreDTO);
        tradeStoreDTOList.add(tradeStoreDTO);
    }

    @Override
    @Transactional
    public void saveTrade(TradeStoreDTO tradeStoreDTO) {
        logger.info("Inside save Trade");
        try{
            tradeStoreRepository.save(createTradeStore(tradeStoreDTO));
        }catch (Exception ex){
            throw new TradeSystemException(ErrorConstants.error_code_4);
        }
    }

    private TradeStore createTradeStore(TradeStoreDTO tradeStoreDTO){
        TradeStore tradeStore = new TradeStore();
        tradeStore.setTradeId(tradeStoreDTO.getTradeId());
        tradeStore.setBookingId(tradeStoreDTO.getBookingId());
        tradeStore.setCounterPartyId(tradeStoreDTO.getCounterPartyId());
        tradeStore.setExpiredFlag(tradeStoreDTO.getExpiredFlag());
        tradeStore.setCreatedDate(tradeStoreDTO.getCreatedDate());
        tradeStore.setVersion(tradeStoreDTO.getVersion());
        tradeStore.setMaturityDate(tradeStoreDTO.getMaturityDate());
        return tradeStore;
    }

    @Override
    public boolean validateMaturiyDate(Date maturityDate) throws TradeSystemException{
        boolean tradeMaturedFlag = false;
        if (maturityDate.before(new Date()))
            tradeMaturedFlag= true;

        if (tradeMaturedFlag)
            throw new TradeSystemException(
                    ErrorConstants.error_code_2);
        return tradeMaturedFlag;
    }

    @Override
    public boolean validateVersion(Integer version,final String tradeId) throws TradeSystemException{
        boolean validateVersionFailed = false;
        try{
            Iterable<TradeStore> iterable = tradeStoreRepository.findAll();
            for (TradeStore tradeStore : iterable){
                if(tradeId.equals(tradeStore.getTradeId()) && version<tradeStore.getVersion()){
                    validateVersionFailed = true;
                    break;
                }
            }
            if (validateVersionFailed)
                throw new TradeSystemException(ErrorConstants.error_code_1);
        }catch(Exception exception){
            throw new TradeSystemException("Unable to fetch records"+exception);
        }
        return validateVersionFailed;
    }

    @Override
    public void checkAndupdateMaturedTradesToExpired(TradeStoreDTO tradeStoreDTO)
            throws TradeSystemException {
        try{
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            Date currentDate =  dateFormatter.parse(dateFormatter.format(new Date() ));
            Iterable<TradeStore> iterable = tradeStoreRepository.findAll();
            for (TradeStore tradeStore : iterable){
                Date maturityDate = dateFormatter.parse(dateFormatter.format(tradeStore.getMaturityDate()));
                if (maturityDate.compareTo(currentDate)<0){
                    tradeStore.setExpiredFlag("Y");
                    tradeStoreRepository.save(tradeStore);
                }
            }
        }catch(Exception ex){
            throw new TradeSystemException(ErrorConstants.error_code_3);
        }
    }
}
