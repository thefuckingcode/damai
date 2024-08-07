package com.youku.player.util;

import android.text.TextUtils;
import android.util.Log;
import com.youku.player.networkscheduler.NetworkSchedulerWrapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.ny0;

/* compiled from: Taobao */
public class a {
    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 24) & 255);
        return sb.toString();
    }

    public static String a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        c.a("HttpDnsUtil", "getIpArrayByOrange -----> host ：" + str);
        try {
            String a = d.a().a("player_network_https", str, "0");
            ArrayList<ny0.a> a2 = ny0.a(str);
            if (a2 != null) {
                if (a2.size() > 0) {
                    int size = a2.size();
                    c.a("HttpDnsUtil", "getIpArrayByOrange -----> list.size() : " + size);
                    Iterator<ny0.a> it = a2.iterator();
                    while (it.hasNext()) {
                        ny0.a next = it.next();
                        String b = next.b();
                        c.a("HttpDnsUtil", "getIpArrayByOrange -----> canWithSPDY : " + next.a() + " / ip :" + b + " / port :" + a);
                        if (!next.a() && next.c() == 80) {
                            stringBuffer.append(a);
                            stringBuffer.append(":");
                            stringBuffer.append(b);
                            stringBuffer.append(";");
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    c.a("HttpDnsUtil", "getIpArrayByOrange : " + str + " ---> " + stringBuffer.toString() + " / time :" + currentTimeMillis2 + "ms");
                    return stringBuffer.toString();
                }
            }
            c.a("HttpDnsUtil", "getIpArrayByOrange -----> list is null");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            c.a("HttpDnsUtil", "getIpArrayByOrange -----> exception : " + Log.getStackTraceString(e));
        }
    }

    public static String b(String str) {
        if ("0".equals(d.a().a("player_network_https", "isHttpdns", "1"))) {
            return "";
        }
        String c = c(str);
        if (!TextUtils.isEmpty(c)) {
            c.a("HttpDnsUtil", "use aps_dns:" + c);
            return c;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        c.a("HttpDnsUtil", "getIpArrayByHost -----> host ：" + str);
        try {
            ArrayList<ny0.a> a = ny0.a(str);
            if (a != null) {
                if (a.size() > 0) {
                    int size = a.size();
                    c.a("HttpDnsUtil", "getIpArrayByHost -----> list.size() : " + size);
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<ny0.a> it = a.iterator();
                    while (it.hasNext()) {
                        ny0.a next = it.next();
                        String b = next.b();
                        c.a("HttpDnsUtil", "getIpArrayByHost -----> canWithSPDY : " + next.a() + " / ip :" + b);
                        if (!next.a() && next.c() == 80) {
                            arrayList.add(b);
                        }
                    }
                    NetworkSchedulerWrapper.getInstance().resolveIpsFromDomain(str, arrayList);
                    Iterator<String> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        stringBuffer.append(it2.next());
                        stringBuffer.append(";");
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    c.a("HttpDnsUtil", "getIpArrayByHost : " + str + " ---> " + stringBuffer.toString() + " / time :" + currentTimeMillis2 + "ms");
                    return stringBuffer.toString();
                }
            }
            c.a("HttpDnsUtil", "getIpArrayByHost -----> list is null");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            c.a("HttpDnsUtil", "getIpArrayByHost -----> exception : " + Log.getStackTraceString(e));
        }
    }

    private static String c(String str) {
        if (str == null || !"1".equals(d.a().a("aps_dns", "aps_dns_switch", "0"))) {
            return null;
        }
        String a = d.a().a("aps_dns", str, "");
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        c.a("HttpDnsUtil", "DNSInterference:" + a);
        Matcher matcher = Pattern.compile("ips=(.+),valid_time=(\\d+),ttl=(\\d+),port=(\\d+)").matcher(a);
        if (matcher.find()) {
            c.a("HttpDnsUtil", "parse DNSInterference data");
            try {
                String group = matcher.group(1);
                long parseLong = Long.parseLong(matcher.group(2));
                long parseLong2 = Long.parseLong(matcher.group(3));
                String group2 = matcher.group(4);
                if (Calendar.getInstance().getTimeInMillis() < parseLong2 + parseLong && Calendar.getInstance().getTimeInMillis() > parseLong && "80".equals(group2)) {
                    return group;
                }
                c.a("HttpDnsUtil", "DNSInterference expire_time or port is wrong");
                return null;
            } catch (NumberFormatException unused) {
                c.b("HttpDnsUtil", "DNSInterference NumberFormatException expire_time error!");
                return null;
            }
        } else {
            c.a("HttpDnsUtil", "DNSInterference invalid format ");
            return null;
        }
    }
}
