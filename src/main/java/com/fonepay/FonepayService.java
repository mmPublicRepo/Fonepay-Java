package com.fonepay;

import com.fonepay.model.FonepayPaymentRequest;
import com.fonepay.model.FonepayPaymentVerificationRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FonepayService {

    private static final String HMAC_SHA512 = "HmacSHA512";

    public static String generateFonepayUrlForPaymentRequest(FonepayPaymentRequest paymentRequest) {
        String fonepayRedirectUrl;
        try {
            fonepayRedirectUrl = paymentRequest.getFonepayUrl() + "/api/merchantRequest" + "?" +
                    "PID=" + paymentRequest.getMerchantCodePid() + "&" +
                    "MD=" + paymentRequest.getMd() + "&" +
                    "AMT=" + paymentRequest.getAmountAmt() + "&" +
                    "CRN=" + paymentRequest.getCurrencyCrn() + "&" +
                    "R1=" + URLEncoder.encode(paymentRequest.getRemarks1(), "UTF-8") + "&" +
                    "R2=" + URLEncoder.encode(paymentRequest.getRemarks2(), "UTF-8") + "&" +
                    "DT=" + URLEncoder.encode(paymentRequest.getDateDt(), "UTF-8") + "&" +
                    "PRN=" + URLEncoder.encode(paymentRequest.getProductNumberPrn(), "UTF-8") + "&" +
                    "RU=" + URLEncoder.encode(paymentRequest.getMerchantWebsiteReturnUrl(), "UTF-8") + "&" +
                    "DV=" + generateDataValidationDvForPaymentRequest(paymentRequest);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
        return fonepayRedirectUrl;
    }

    public static String generateFonepayUrlForPaymentVerificationRequest(FonepayPaymentVerificationRequest fonepayPaymentVerificationRequest) {
        return fonepayPaymentVerificationRequest.getFonepayVerificationUrl() +
                "/api/merchantRequest/verificationMerchant" + "?" +
                "PRN=" + fonepayPaymentVerificationRequest.getProductNumberPrn() + "&" +
                "PID=" + fonepayPaymentVerificationRequest.getMerchantCodePid() + "&" +
                "BID=" + fonepayPaymentVerificationRequest.getBillIdBid() + "&" +
                "AMT=" + fonepayPaymentVerificationRequest.getMerchantRequestedAmountAmt() + "&" +
                "UID=" + fonepayPaymentVerificationRequest.getFonepayTraceIdUniqueUid() + "&" +
                "DV=" + generateDataValidationDvForPaymentVerificationRequest(fonepayPaymentVerificationRequest);
    }

    private static String generateDataValidationDvForPaymentVerificationRequest(FonepayPaymentVerificationRequest fonepayPaymentVerificationRequest) {
        String formattedPaymentRequestString = getFormattedPaymentRequestVerificationString(fonepayPaymentVerificationRequest);

        return calculateHMAC(formattedPaymentRequestString, fonepayPaymentVerificationRequest.getMerchantSecretKey());
    }

    private static String generateDataValidationDvForPaymentRequest(FonepayPaymentRequest paymentRequest) {
        String formattedPaymentRequestString = getFormattedPaymentRequestString(paymentRequest);

        return calculateHMAC(formattedPaymentRequestString, paymentRequest.getMerchantSecretKey());
    }

    private static String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static String calculateHMAC(String data, String secretKey) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA512);
            Mac mac;

            mac = Mac.getInstance(HMAC_SHA512);

            mac.init(secretKeySpec);
            return bytesToHex(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            return "";
        }
    }

    private static String getFormattedPaymentRequestString(FonepayPaymentRequest paymentRequest) {
        return paymentRequest.getMerchantCodePid() + "," +
                paymentRequest.getMd() + "," +
                paymentRequest.getProductNumberPrn() + "," +
                paymentRequest.getAmountAmt() + "," +
                paymentRequest.getCurrencyCrn() + "," +
                paymentRequest.getDateDt() + "," +
                paymentRequest.getRemarks1() + "," +
                paymentRequest.getRemarks2() + "," +
                paymentRequest.getMerchantWebsiteReturnUrl();
    }

    private static String getFormattedPaymentRequestVerificationString(FonepayPaymentVerificationRequest fonepayPaymentVerificationRequest) {
        return fonepayPaymentVerificationRequest.getMerchantCodePid() + "," +
                fonepayPaymentVerificationRequest.getMerchantRequestedAmountAmt() + "," +
                fonepayPaymentVerificationRequest.getProductNumberPrn() + "," +
                fonepayPaymentVerificationRequest.getBillIdBid() + "," +
                fonepayPaymentVerificationRequest.getFonepayTraceIdUniqueUid();
    }

}
