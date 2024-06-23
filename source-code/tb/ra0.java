package tb;

import android.text.TextUtils;
import com.youku.android.liveservice.LivePlayerController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import ntk.dns.DNSResolver;
import tb.ny0;

/* compiled from: Taobao */
public class ra0 {
    private static boolean a = true;

    private static String[] a(String str) {
        LinkedList linkedList = new LinkedList();
        ArrayList<ny0.a> a2 = ny0.a(str);
        if (a2 != null) {
            Iterator<ny0.a> it = a2.iterator();
            while (it.hasNext()) {
                ny0.a next = it.next();
                if (!next.a() && next.c() == 80) {
                    String b = next.b();
                    if (d(b)) {
                        linkedList.add(b);
                    }
                }
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    public static String[] b(String str) {
        return (!a || TextUtils.isEmpty(str)) ? (String[]) new ArrayList().toArray(new String[0]) : a(str);
    }

    public static String[] c(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] c = DNSResolver.c(str);
                if (c != null) {
                    for (String str2 : c) {
                        if (d(str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && !"0.0.0.0".equals(str) && !LivePlayerController.CLIENT_IP.equals(str);
    }
}
