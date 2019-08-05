[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.fonepay/payment/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.fonepay/payment)

# Fonepay-Java

Fonepay Payment library for java

## Documentation

https://docs.google.com/document/d/e/2PACX-1vQoPiR4invPzLumeixLndjkVW8MgYsQw2TZGJQQI8CXdrLf5lxrAvEBxzxqhPz7W-kMCs-JzBn4qVox/pub

### Maven:

    <dependency>
      <groupId>com.fonepay</groupId>
      <artifactId>payment</artifactId>
      <version>0.9</version>
    </dependency>

### Gradle

    implementation 'com.fonepay:payment:0.9'

Check https://github.com/fonepay/Fonepay-Spring-Boot-Integration-Sample for example on how to used this libray.

### Example to make payment request:

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
         
         
Note: Redirect user to fonepayPaymentRequestUrl.

### Example to verify payment request:
         
         FonepayPaymentVerificationRequest fonepayPaymentVerification =
                        FonepayPaymentVerificationRequestBuilder.aFonepayPaymentVerificationRequest()
                                .withProductNumberPrn(productNumberPrn)
                                .withMerchantCodePid(merchantCodePID)
                                .withBillIdBid(billId)
                                .withFonepayTraceIdUniqueUid(fonepayTraceIdUid)
                                .withFonepayVerificationUrl(fonepayVerificationReturnUrl)
                                .withMerchantRequestedAmountAmt(paymentRequest.getAmountAmt() + "")
                                .withMerchantSecretKey(merchantSecretKey)
                                .build();
        
         String fonepayUrlForPaymentVerification = FonepayService.generateFonepayUrlForPaymentVerificationRequest(fonepayPaymentVerification);

Note: Call fonepayUrlForPaymentVerification api url to verify payment.