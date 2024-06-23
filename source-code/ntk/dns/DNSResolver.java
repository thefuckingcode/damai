package ntk.dns;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class DNSResolver {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static a[] b = new a[10];
    private static int c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        String a;
        volatile String[] b;
        long c;

        a() {
        }

        /* access modifiers changed from: package-private */
        public String[] a() {
            if (this.b == null || this.c < System.currentTimeMillis()) {
                DNSResolver.e(this);
            }
            return this.b;
        }
    }

    public static String[] c(String str) {
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

    private static ArrayList<String> d(String str) {
        return new ArrayList<>();
    }

    /* access modifiers changed from: private */
    public static void e(final a aVar) {
        a.execute(new Runnable() {
            /* class ntk.dns.DNSResolver.AnonymousClass1 */

            public void run() {
                DNSResolver.f(aVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void f(a aVar) {
        if (aVar != null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(aVar.a);
                String[] strArr = new String[allByName.length];
                for (int i = 0; i < allByName.length; i++) {
                    strArr[i] = allByName[i].getHostAddress();
                }
                aVar.b = strArr;
                if (NetworkUtil.d() == 1) {
                    ArrayList<String> d = d(aVar.a);
                    if (!d.isEmpty()) {
                        String[] strArr2 = (String[]) d.toArray(new String[d.size()]);
                    }
                }
                aVar.c = System.currentTimeMillis() + 300000;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
