# Fonepay-Java
Fonepay library for java

Example:

    FonepayPaymentRequest fonepayPaymentRequest = FonepayPaymentRequestBuilder.aFonepayPaymentRequest()
                .merchantCodePid(paymentRequest.getMerchantCodePid())
                .productNumberPrn(paymentRequest.getProductNumberPrn())
                .amountAmt(paymentRequest.getAmountAmt())
                .remarks1(paymentRequest.getRemarks1())
                .fonepayUrl(fonepayPaymentUrl)
                .merchantWebsiteReturnUrl(merchantPaymentSuccessReturnUrl)
                .merchantSecretKey(merchantSecretKey)
                .build();

        String fonepayPaymentRequestUrl = FonepayService.generateFonepayUrlForPaymentRequest(fonepayPaymentRequest);
        
Check https://github.com/fonepay/Fonepay-Spring-Boot-Integration-Sample for example on how to used this libray.
