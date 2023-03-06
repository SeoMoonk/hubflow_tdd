package com.ll;


import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String url;
    private String path;
    private Map<String, String> queryParams;

    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        queryParams = new HashMap<>();

        if (urlBits.length == 2) {
            String queryStr = urlBits[1];

            queryParams = getMapFromQueryStr(queryStr);
        }
    }

    private static Map<String, String> getMapFromQueryStr(String queryStr) {
        Map<String, String> queryParams = new HashMap<>();

        String[] paramBits = queryStr.split("&");

        for (String paramBit : paramBits) {
            String[] paramNameAndValue = paramBit.split("=", 2);

            if (paramNameAndValue.length == 1) {
                continue;
            }

            String paramName = paramNameAndValue[0].trim();
            String paramValue = paramNameAndValue[1].trim();

            queryParams.put(paramName, paramValue);
        }

        return queryParams;
    }

    public int getIntParam(String paramName, int defaultValue) {
        if (queryParams.containsKey(paramName) == false) {
            return defaultValue;
        }

        String paramValue = queryParams.get(paramName);

        if (paramValue.length() == 0) {
            return defaultValue;
        }

        return Integer.parseInt(paramValue);
    }

    public String getPath() {
        return path;
    }
}