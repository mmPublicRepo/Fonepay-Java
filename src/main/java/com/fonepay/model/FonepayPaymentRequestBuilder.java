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

    public FonepayPaymentRequestBuilder withMerchantCodePid(String merchantCodePid) {
        this.merchantCodePid = merchantCodePid;
        return this;
    }

    public FonepayPaymentRequestBuilder withProductNumberPrn(String productNumberPrn) {
        this.productNumberPrn = productNumberPrn;
        return this;
    }

    public FonepayPaymentRequestBuilder withAmountAmt(Double amountAmt) {
        this.amountAmt = amountAmt;
        return this;
    }

    public FonepayPaymentRequestBuilder withCurrencyCrn(String currencyCrn) {
        this.currencyCrn = currencyCrn;
        return this;
    }

    public FonepayPaymentRequestBuilder withDateDt(String dateDt) {
        this.dateDt = dateDt;
        return this;
    }

    public FonepayPaymentRequestBuilder withRemarks1(String remarks1) {
        this.remarks1 = remarks1;
        return this;
    }

    public FonepayPaymentRequestBuilder withRemarks2(String remarks2) {
        this.remarks2 = remarks2;
        return this;
    }

    public FonepayPaymentRequestBuilder withMd(String md) {
        this.md = md;
        return this;
    }

    public FonepayPaymentRequestBuilder withMerchantWebsiteReturnUrl(String merchantWebsiteReturnUrl) {
        this.merchantWebsiteReturnUrl = merchantWebsiteReturnUrl;
        return this;
    }

    public FonepayPaymentRequestBuilder withMerchantSecretKey(String merchantSecretKey) {
        this.merchantSecretKey = merchantSecretKey;
        return this;
    }

    public FonepayPaymentRequestBuilder withFonepayUrl(String fonepayUrl) {
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
