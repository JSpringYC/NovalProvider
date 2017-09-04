package com.jiangyc.library.util;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtils {

    public static URL toUrl(String address) {
        URL url = null;

        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            // 如果失败，则取Null
        }

        return url;
    }

    /**
     * 获取URL中的Host
     * @param address
     * @return URL中的Host
     */
    public static String getHost(String address) {
        URL url = toUrl(address);

        if (url == null) {
            return null;
        }

        return url.getHost();
    }
}
