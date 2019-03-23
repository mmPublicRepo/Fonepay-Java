package com.fonepay;

import com.fonepay.model.FonepayPaymentRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Formatter;

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

    private static String generateDataValidationDvForPaymentRequest(FonepayPaymentRequest paymentRequest) {
        String formattedPaymentRequestString = getFormattedPaymentRequestString(paymentRequest);

        return calculateHMAC(formattedPaymentRequestString, paymentRequest.getMerchantSecretKey());
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    private static String calculateHMAC(String data, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA512);
            Mac mac;

            mac = Mac.getInstance(HMAC_SHA512);

            mac.init(secretKeySpec);
            return toHexString(mac.doFinal(data.getBytes()));
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

}
