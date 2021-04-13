package com.tradesystem.tradesystem.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TRADE_STORE")
public class TradeStore {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="TRADE_ID")
    private String tradeId;

    @Column(name="COUNTER_PARTY_ID")
    private String counterPartyId;

    @Column(name="VERSION")
    private Integer version;

    @Column(name="BOOK_ID")
    private String bookingId;

    @Column(name="EXPIRED_FLAG")
    private String expiredFlag;

    @Column(name="MATURITY_ON")
    private Date maturityDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="CREATED_ON")
    private Date createdDate;


}
