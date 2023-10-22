package com.juaracoding.utils;

public class CheckoutElement {
    public static final String PROCEEDCHECKOUT = "//p[@class='woocommerce-thankyou-order-received']";
    public static final String FIRSTNAME = "//input[@id='billing_first_name']";
    public static final String LASTNAME = "//input[@id='billing_last_name']";
    public static final String REGION = "//span[@id='select2-billing_country-container']";
    public static final String STREET = "//input[@id='billing_address_1']";
    public static final String TOWN = "//input[@id='billing_city']";
    public static final String PROVINCE = "//span[@id='select2-billing_state-container']";
    public static final String POSTCODE = "//input[@id='billing_postcode']";
    public static final String TERMAGREEMENT = "//input[@id='terms']";
    public static final String ORDER = "//button[@id='place_order']";
    public static final String TXTVALIDATION = "//p[@class='woocommerce-thankyou-order-received']";
}
