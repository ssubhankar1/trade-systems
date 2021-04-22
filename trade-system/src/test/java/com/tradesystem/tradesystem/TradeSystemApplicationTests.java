package com.tradesystem.tradesystem;

import com.tradesystem.tradesystem.controller.TradeStoreController;
import com.tradesystem.tradesystem.model.TradeStoreDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TradeSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TradeStoreController tradeStoreController;

	@Test
	public void validateVersionAndThrowExceptionForSameVersion(){// reject the trade for lower versio
		TradeStoreDTO tradeStoreDTO =
				tradeStoreController.saveTradeStoreInformation(createTradeStoreForVersionValidation());
		assert(tradeStoreDTO.getErrorDetails()!=null);
	}

	@Test
	public void updateSameVersion(){// override trade if same version being passed
		TradeStoreDTO tradeStoreDTO =
				tradeStoreController.saveTradeStoreInformation(createTradeStoreForSameVersion());
		assert(tradeStoreDTO.getErrorDetails()==null);
	}

	@Test
	public void validateMaturiyDateAndThrowException(){// do not allow trade when maturity date is
		// less than today date
		TradeStoreDTO tradeStoreDTO =
				tradeStoreController.saveTradeStoreInformation(createTradeStoreForMaturityDateValidation());
		assert(tradeStoreDTO.getErrorDetails()!=null);
	}

	@Test
	public void updateExpiredFlag(){// process to update Expired Flag as Y if trade crosses maturity date
		TradeStoreDTO tradeStoreDTO =
				tradeStoreController.checkAndupdateMaturedTradesToExpired(createTradeStoreForExpiredTrades());
		assert(tradeStoreDTO.getErrorDetails()==null);
	}

	@Test
	public void makeSuccessfulTrade(){// process to update Expired Flag as Y if trade crosses maturity date
		TradeStoreDTO tradeStoreDTO =
				tradeStoreController.saveTradeStoreInformation(createTradeStoreSuccessfully());
		assert(tradeStoreDTO.getErrorDetails()==null);
	}

	@Test
	public void getAllTradeInformation(){// test to retrieve all trade information
		List<TradeStoreDTO> tradeStoreInformation =
				tradeStoreController.getAllTradeStoreInformation();
		assert(tradeStoreInformation.size()>0);
	}



	private TradeStoreDTO createTradeStoreSuccessfully() {

		TradeStoreDTO tradeStoreDTO = new TradeStoreDTO();
		tradeStoreDTO.setTradeId("T5");
		tradeStoreDTO.setBookingId("B5");
		tradeStoreDTO.setVersion(1);
		tradeStoreDTO.setCounterPartyId("Cp-4");
		tradeStoreDTO.setCreatedDate(new Date());
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 2);
		dt = c.getTime();
		tradeStoreDTO.setMaturityDate(dt);
		tradeStoreDTO.setExpiredFlag("N");
		return tradeStoreDTO;
	}

	private TradeStoreDTO createTradeStoreForExpiredTrades() {

		TradeStoreDTO tradeStoreDTO = new TradeStoreDTO();
		tradeStoreDTO.setTradeId("T3");
		tradeStoreDTO.setBookingId("B3");
		tradeStoreDTO.setVersion(4);
		tradeStoreDTO.setCounterPartyId("Cp-3");
		tradeStoreDTO.setCreatedDate(new Date());
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, -1);
		dt = c.getTime();
		tradeStoreDTO.setMaturityDate(dt);
		tradeStoreDTO.setExpiredFlag("N");
		return tradeStoreDTO;
	}

	private TradeStoreDTO createTradeStoreForMaturityDateValidation() {

		TradeStoreDTO tradeStoreDTO = new TradeStoreDTO();
		tradeStoreDTO.setTradeId("T3");
		tradeStoreDTO.setBookingId("B3");
		tradeStoreDTO.setVersion(4);
		tradeStoreDTO.setCounterPartyId("Cp-3");
		tradeStoreDTO.setCreatedDate(new Date());
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, -1);
		dt = c.getTime();
		tradeStoreDTO.setMaturityDate(dt);
		tradeStoreDTO.setExpiredFlag("N");
		return tradeStoreDTO;
	}

	private TradeStoreDTO createTradeStoreForVersionValidation() {

		TradeStoreDTO tradeStoreDTO = new TradeStoreDTO();
		tradeStoreDTO.setTradeId("T3");
		tradeStoreDTO.setBookingId("B3");
		tradeStoreDTO.setVersion(2);
		tradeStoreDTO.setCounterPartyId("Cp-3");
		tradeStoreDTO.setCreatedDate(new Date());
		tradeStoreDTO.setMaturityDate(new Date());
		tradeStoreDTO.setExpiredFlag("N");
		return tradeStoreDTO;
	}

	private TradeStoreDTO createTradeStoreForSameVersion() {

		TradeStoreDTO tradeStoreDTO = new TradeStoreDTO();
		tradeStoreDTO.setTradeId("T3");
		tradeStoreDTO.setBookingId("B3");
		tradeStoreDTO.setVersion(3);
		tradeStoreDTO.setCounterPartyId("Cp-3");
		tradeStoreDTO.setCreatedDate(new Date());
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		tradeStoreDTO.setMaturityDate(dt);
		tradeStoreDTO.setExpiredFlag("N");
		return tradeStoreDTO;
	}

}
