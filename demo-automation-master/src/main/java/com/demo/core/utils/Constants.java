package com.demo.core.utils;

public class Constants {
    public static String URL = getBaseUrl();
    public static String REMOTE_URL = System.getProperty("remoteurl");

    public static final String CDT_TEMPLATE_NAME = "AUTOMATION_SAV_TO_CHK_CDT";

    public static String USERNAME = "autestthredone";
    //    public static String USERNAME = "autotest";
    public static String PASSWORD = "autestthredone";
    //    public static String PASSWORD = "autotest";
    //    public static String FIRST_NAME = "autotest";
    public static String FIRST_NAME = "autestthredone";
    //    public static String LAST_NAME = "autotest";
    public static String LAST_NAME = "autestthredone";
    /**
     * Browsers
     */
    public static String CHROME = "chrome";
    public static String FIREFOX = "firefox";

    private static String getBaseUrl() {
        switch (getEnvironment()) {
            case "dev6":
            default:
                return "https://dev6.demo.com/";
            case "dev12":
                return "https://dev12.demo.com/frontoffice";
            case "dev21":
                return "https://dev21.nj1.demo.com/frontoffice/";
            case "dev4":
                return "https://frontoffice.nj1.demo.com/frontoffice/#/crm/login";
            case "dev18":
                return "https://dev18.nj1.demo.com/frontoffice/#/crm/login";
        }
    }

    public static String getEnvironment() {
        return System.getProperty("domain", "dev6");
    }

}