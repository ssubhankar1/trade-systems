package com.tradesystem.tradesystem.model;

public class TradeStorePayload {

    private String tradeId;

    private String counterPartyId;

    private Integer version;

    private String bookingId;

    private String expiredFlag;

    private Integer maturityDate;

    private Integer createdDate;

    @Override
    public String toString() {
        return "TradeStorePayload{" +
                "tradeId='" + tradeId + '\'' +
                ", counterPartyId='" + counterPartyId + '\'' +
                ", version=" + version +
                ", bookingId='" + bookingId + '\'' +
                ", expiredFlag='" + expiredFlag + '\'' +
                ", maturityDate=" + maturityDate +
                ", createdDate=" + createdDate +
                '}';
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getExpiredFlag() {
        return expiredFlag;
    }

    public void setExpiredFlag(String expiredFlag) {
        this.expiredFlag = expiredFlag;
    }

    public Integer getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Integer maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }
}
