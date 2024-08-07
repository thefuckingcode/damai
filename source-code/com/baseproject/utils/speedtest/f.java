package com.baseproject.utils.speedtest;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class f {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static a[] b = new a[10];
    private static int c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        String a;
        volatile String[] b;
        long c;
        int d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public String a() {
            if (this.b == null || this.c < System.currentTimeMillis()) {
                f.c(this);
            }
            String[] strArr = this.b;
            int i = this.d;
            this.d = i + 1;
            return strArr[i % this.b.length];
        }
    }

    public static String a(String str) {
        int i = 0;
        while (true) {
            a[] aVarArr = b;
            if (i < aVarArr.length) {
                a aVar = aVarArr[i];
                if (aVar != null && aVar.a.equals(str)) {
                    return aVar.a();
                }
                i++;
            } else {
                a aVar2 = new a();
                aVar2.a = str;
                a[] aVarArr2 = b;
                int i2 = c;
                c = i2 + 1;
                aVarArr2[i2 % aVarArr2.length] = aVar2;
                return aVar2.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(a aVar) {
        com.youku.b.a.a.a("SmartDns", "updateDnsRecord begin");
        if (aVar != null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(aVar.a);
                String[] strArr = new String[allByName.length];
                for (int i = 0; i < allByName.length; i++) {
                    strArr[i] = allByName[i].getHostAddress();
                }
                aVar.b = strArr;
                aVar.d = 0;
                aVar.c = System.currentTimeMillis() + 300000;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        com.youku.b.a.a.a("SmartDns", "updateDnsRecord end");
    }
}
