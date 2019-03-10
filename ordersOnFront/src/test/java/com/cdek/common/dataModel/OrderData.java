package com.cdek.common.dataModel;

import java.util.Date;

public class OrderData {

    String numberOrd;
    String numberIn;
    String sellerAddress;
    String shipperName;
    String shipperAddress;
    Date dateInvoice;
    String taxpayerIdentificationNumber;
    String pasSer;
    String pasNum;
    Date dateIssue;
    String issuedBy;
    Date dateOfBirth;
    String nameEx;
    Double weightBrutto;
    String link;

    public OrderData setNumberOrd (String numberOrd) {
        this.numberOrd = numberOrd;
        return this;
    }

    public OrderData setNumberIn (String numberIn) {
        this.numberIn = numberIn;
        return this;
    }

    public OrderData setSellerAddress (String sellerAddress) {
        this.sellerAddress = sellerAddress;
        return this;
    }

    public OrderData setShipperName (String shipperName) {
        this.shipperName = shipperName;
        return this;
    }

    public OrderData setShipperAddress (String shipperAddress) {
        this.shipperAddress = shipperAddress;
        return this;
    }

    public OrderData setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
        return this;
    }

    public OrderData setTaxpayerIdentificationNumber (String taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        return this;
    }

    public OrderData getPasSer(String pasSer) {
        this.pasSer = pasSer;
        return this;
    }

    public OrderData setPasNum(String pasNum) {
        this.pasNum = pasNum;
        return this;
    }

    public OrderData setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
        return this;
    }

    public OrderData setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
        return this;
    }

    public OrderData setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public OrderData setNameEx(String nameEx) {
        this.nameEx = nameEx;
        return this;
    }

    public OrderData setWeightBrutto(Double weightBrutto) {
        this.weightBrutto = weightBrutto;
        return this;
    }

    public OrderData getLink(String link) {
        this.link = link;
        return this;
    }

}
