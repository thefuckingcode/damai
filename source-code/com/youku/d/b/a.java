package com.youku.d.b;

import anet.channel.util.ALog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import tb.ag2;
import tb.jl1;

/* compiled from: Taobao */
public class a {
    public static String a(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append("=");
                    sb.append(URLEncoder.encode(ag2.j(entry.getValue()), str).replace(jl1.PLUS, "%20"));
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (UnsupportedEncodingException e) {
            ALog.d("Request", "format params failed", null, e, new Object[0]);
        }
        return sb.toString();
    }

    public static boolean a(double d, double d2, double d3) {
        return Math.abs(d - d2) <= d3;
    }
}
