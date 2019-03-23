package com.fonepay.model;

public class FonepayPaymentRequest {

    private String merchantCodePid;

    private String productNumberPrn;

    private Double amountAmt;

    private String currencyCrn;

    private String dateDt;

    private String remarks1;

    private String remarks2;

    private String md;

    private String merchantWebsiteReturnUrl;

    private String merchantSecretKey;

    private String fonepayUrl;

    public FonepayPaymentRequest() {
    }

    public String getMerchantCodePid() {
        return merchantCodePid;
    }

    public void setMerchantCodePid(String merchantCodePid) {
        this.merchantCodePid = merchantCodePid;
    }

    public String getProductNumberPrn() {
        return productNumberPrn;
    }

    public void setProductNumberPrn(String productNumberPrn) {
        this.productNumberPrn = productNumberPrn;
    }

    public Double getAmountAmt() {
        return amountAmt;
    }

    public void setAmountAmt(Double amountAmt) {
        this.amountAmt = amountAmt;
    }

    public String getCurrencyCrn() {
        return currencyCrn;
    }

    public void setCurrencyCrn(String currencyCrn) {
        this.currencyCrn = currencyCrn;
    }

    public String getDateDt() {
        return dateDt;
    }

    public void setDateDt(String dateDt) {
        this.dateDt = dateDt;
    }

    public String getRemarks1() {
        return remarks1;
    }

    public void setRemarks1(String remarks1) {
        this.remarks1 = remarks1;
    }

    public String getRemarks2() {
        return remarks2;
    }

    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }


    public String getFonepayUrl() {
        return fonepayUrl;
    }

    public void setFonepayUrl(String fonepayUrl) {
        this.fonepayUrl = fonepayUrl;
    }

    public String getMerchantWebsiteReturnUrl() {
        return merchantWebsiteReturnUrl;
    }

    public void setMerchantWebsiteReturnUrl(String merchantWebsiteReturnUrl) {
        this.merchantWebsiteReturnUrl = merchantWebsiteReturnUrl;
    }

    public String getMerchantSecretKey() {
        return merchantSecretKey;
    }

    public void setMerchantSecretKey(String merchantSecretKey) {
        this.merchantSecretKey = merchantSecretKey;
    }
}
