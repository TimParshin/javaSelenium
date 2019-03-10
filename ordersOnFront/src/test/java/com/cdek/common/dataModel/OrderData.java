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

    public String getNumberOrd (String numberOrd) {
        this.numberOrd = numberOrd;
        return numberOrd;
    }

    public String getNumberIn (String numberIn) {
        this.numberIn = numberIn;
        return numberIn;
    }

    public String getSellerAddress (String sellerAddress) {
        this.sellerAddress = sellerAddress;
        return sellerAddress;
    }

    public String getShipperName (String shipperName) {
        this.shipperName = shipperName;
        return shipperName;
    }

    public String getShipperAddress (String shipperAddress) {
        this.shipperAddress = shipperAddress;
        return shipperAddress;
    }

    public Date getDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
        return dateInvoice;
    }

    public String getTaxpayerIdentificationNumber (String taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        return taxpayerIdentificationNumber;
    }

    public String getPasSer(String pasSer) {
        this.pasSer = pasSer;
        return pasSer;
    }

    public String getPasNum(String pasNum) {
        this.pasNum = pasNum;
        return pasNum;
    }

    public Date getDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
        return dateIssue;
    }

    public String getIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
        return issuedBy;
    }

    public Date getDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return dateOfBirth;
    }

    public String getNameEx(String nameEx) {
        this.nameEx = nameEx;
        return nameEx;
    }

    public Double getWeightBrutto(Double weightBrutto) {
        this.weightBrutto = weightBrutto;
        return weightBrutto;
    }

    public String getLink(String link) {
        this.link = link;
        return link;
    }
}
