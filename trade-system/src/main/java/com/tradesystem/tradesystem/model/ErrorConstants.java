package com.tradesystem.tradesystem.model;

public interface ErrorConstants {

    public String error_code_1 = "ERR_VER_01,Lower Version already exist for same TradeId";
    public String error_code_2 = "ERR_VER_02,Maturity Date is older than current date,trade cannot be processed";
    public String error_code_3 = "ERR_VER_03,Exception while updating Expired Flag";
    public String error_code_4 = "ERR_VER_04,Exception while saving Trade data";
    public String error_code_5 = "ERR_VER_05,Exception while retrieving trade information";
}
