package com.fonepay.model;

public final class FonepayPaymentVerificationRequestBuilder {
    private String merchantCodePid;
    private String merchantRequestedAmountAmt;
    private String productNumberPrn;
    private String billIdBid;
    private String fonepayTraceIdUniqueUid;
    private String merchantSecretKey;
    private String fonepayVerificationUrl;

    private FonepayPaymentVerificationRequestBuilder() {
    }

    public static FonepayPaymentVerificationRequestBuilder aFonepayPaymentVerificationRequest() {
        return new FonepayPaymentVerificationRequestBuilder();
    }

    public FonepayPaymentVerificationRequestBuilder withMerchantCodePid(String merchantCodePid) {
        this.merchantCodePid = merchantCodePid;
        return this;
    }

    public FonepayPaymentVerificationRequestBuilder withMerchantRequestedAmountAmt(String merchantRequestedAmountAmt) {
        this.merchantRequestedAmountAmt = merchantRequestedAmountAmt;
        return this;
    }

    public FonepayPaymentVerificationRequestBuilder withProductNumberPrn(String productNumberPrn) {
        this.productNumberPrn = productNumberPrn;
        return this;
    }

    public FonepayPaymentVerificationRequestBuilder withBillIdBid(String billIdBid) {
        this.billIdBid = billIdBid;
        return this;
    }

    public FonepayPaymentVerificationRequestBuilder withFonepayTraceIdUniqueUid(String fonepayTraceIdUniqueUid) {
        this.fonepayTraceIdUniqueUid = fonepayTraceIdUniqueUid;
        return this;
    }

    public FonepayPaymentVerificationRequestBuilder withMerchantSecretKey(String merchantSecretKey) {
        this.merchantSecretKey = merchantSecretKey;
        return this;
    }

    public FonepayPaymentVerificationRequestBuilder withFonepayVerificationUrl(String fonepayVerificationUrl) {
        this.fonepayVerificationUrl = fonepayVerificationUrl;
        return this;
    }

    public FonepayPaymentVerificationRequest build() {
        FonepayPaymentVerificationRequest fonepayPaymentVerificationRequest = new FonepayPaymentVerificationRequest();
        fonepayPaymentVerificationRequest.setMerchantCodePid(merchantCodePid);
        fonepayPaymentVerificationRequest.setMerchantRequestedAmountAmt(merchantRequestedAmountAmt);
        fonepayPaymentVerificationRequest.setProductNumberPrn(productNumberPrn);
        fonepayPaymentVerificationRequest.setBillIdBid(billIdBid);
        fonepayPaymentVerificationRequest.setFonepayTraceIdUniqueUid(fonepayTraceIdUniqueUid);
        fonepayPaymentVerificationRequest.setMerchantSecretKey(merchantSecretKey);
        fonepayPaymentVerificationRequest.setFonepayVerificationUrl(fonepayVerificationUrl);
        return fonepayPaymentVerificationRequest;
    }
}
