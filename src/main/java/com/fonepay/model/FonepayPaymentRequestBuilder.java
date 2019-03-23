package com.fonepay.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class FonepayPaymentRequestBuilder {
    private String merchantCodePid;
    private String productNumberPrn;
    private Double amountAmt;
    private String currencyCrn = "NP";
    private String dateDt = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    private String remarks1;
    private String remarks2 = "N/A";
    private String md = "P";
    private String fonepayUrl;
    private String merchantWebsiteReturnUrl;
    private String merchantSecretKey;

    private FonepayPaymentRequestBuilder() {
    }

    public static FonepayPaymentRequestBuilder aFonepayPaymentRequest() {
        return new FonepayPaymentRequestBuilder();
    }

    public FonepayPaymentRequestBuilder merchantCodePid(String merchantCodePid) {
        this.merchantCodePid = merchantCodePid;
        return this;
    }

    public FonepayPaymentRequestBuilder productNumberPrn(String productNumberPrn) {
        this.productNumberPrn = productNumberPrn;
        return this;
    }

    public FonepayPaymentRequestBuilder amountAmt(Double amountAmt) {
        this.amountAmt = amountAmt;
        return this;
    }

    public FonepayPaymentRequestBuilder currencyCrn(String currencyCrn) {
        this.currencyCrn = currencyCrn;
        return this;
    }

    public FonepayPaymentRequestBuilder dateDt(String dateDt) {
        this.dateDt = dateDt;
        return this;
    }

    public FonepayPaymentRequestBuilder remarks1(String remarks1) {
        this.remarks1 = remarks1;
        return this;
    }

    public FonepayPaymentRequestBuilder remarks2(String remarks2) {
        this.remarks2 = remarks2;
        return this;
    }

    public FonepayPaymentRequestBuilder md(String md) {
        this.md = md;
        return this;
    }

    public FonepayPaymentRequestBuilder merchantWebsiteReturnUrl(String merchantWebsiteReturnUrl) {
        this.merchantWebsiteReturnUrl = merchantWebsiteReturnUrl;
        return this;
    }

    public FonepayPaymentRequestBuilder merchantSecretKey(String merchantSecretKey) {
        this.merchantSecretKey = merchantSecretKey;
        return this;
    }

    public FonepayPaymentRequestBuilder fonepayUrl(String fonepayUrl) {
        this.fonepayUrl = fonepayUrl;
        return this;
    }

    public FonepayPaymentRequest build() {
        FonepayPaymentRequest fonepayPaymentRequest = new FonepayPaymentRequest();
        fonepayPaymentRequest.setMerchantCodePid(merchantCodePid);
        fonepayPaymentRequest.setProductNumberPrn(productNumberPrn);
        fonepayPaymentRequest.setAmountAmt(amountAmt);
        fonepayPaymentRequest.setCurrencyCrn(currencyCrn);
        fonepayPaymentRequest.setDateDt(dateDt);
        fonepayPaymentRequest.setRemarks1(remarks1);
        fonepayPaymentRequest.setRemarks2(remarks2);
        fonepayPaymentRequest.setMd(md);
        fonepayPaymentRequest.setMerchantWebsiteReturnUrl(merchantWebsiteReturnUrl);
        fonepayPaymentRequest.setMerchantSecretKey(merchantSecretKey);
        fonepayPaymentRequest.setFonepayUrl(fonepayUrl);
        return fonepayPaymentRequest;
    }
}
