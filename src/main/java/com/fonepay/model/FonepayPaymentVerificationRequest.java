package com.fonepay.model;


public class FonepayPaymentVerificationRequest {

    private String merchantCodePid;

    private String merchantRequestedAmountAmt;

    private String productNumberPrn;

    private String billIdBid;

    private String fonepayTraceIdUniqueUid;

    private String merchantSecretKey;

    private String fonepayVerificationUrl;

    public FonepayPaymentVerificationRequest() {
    }

    public String getMerchantCodePid() {
        return merchantCodePid;
    }

    public void setMerchantCodePid(String merchantCodePid) {
        this.merchantCodePid = merchantCodePid;
    }

    public String getMerchantRequestedAmountAmt() {
        return merchantRequestedAmountAmt;
    }

    public void setMerchantRequestedAmountAmt(String merchantRequestedAmountAmt) {
        this.merchantRequestedAmountAmt = merchantRequestedAmountAmt;
    }

    public String getProductNumberPrn() {
        return productNumberPrn;
    }

    public void setProductNumberPrn(String productNumberPrn) {
        this.productNumberPrn = productNumberPrn;
    }

    public String getBillIdBid() {
        return billIdBid;
    }

    public void setBillIdBid(String billIdBid) {
        this.billIdBid = billIdBid;
    }

    public String getFonepayTraceIdUniqueUid() {
        return fonepayTraceIdUniqueUid;
    }

    public void setFonepayTraceIdUniqueUid(String fonepayTraceIdUniqueUid) {
        this.fonepayTraceIdUniqueUid = fonepayTraceIdUniqueUid;
    }

    public String getMerchantSecretKey() {
        return merchantSecretKey;
    }

    public void setMerchantSecretKey(String merchantSecretKey) {
        this.merchantSecretKey = merchantSecretKey;
    }

    public String getFonepayVerificationUrl() {
        return fonepayVerificationUrl;
    }

    public void setFonepayVerificationUrl(String fonepayVerificationUrl) {
        this.fonepayVerificationUrl = fonepayVerificationUrl;
    }
}
