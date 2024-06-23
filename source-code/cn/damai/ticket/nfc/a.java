package cn.damai.ticket.nfc;

import android.content.Intent;
import android.nfc.Tag;
import android.nfc.tech.NfcV;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import tb.qi1;
import tb.sc0;
import tb.ui2;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "a";

    public static String a(String str, String str2, NfcV nfcV) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688598164")) {
            return (String) ipChange.ipc$dispatch("-688598164", new Object[]{str, str2, nfcV});
        } else if (nfcV == null) {
            Log.e(TAG, "authenticate - nfcV is null.");
            return null;
        } else {
            String str3 = TAG;
            Log.d(str3, "random challenge data: " + str2);
            String str4 = sc0.CMD_AUTH_PREFIX + str + "000000" + str2;
            byte[] d = ui2.d(str4);
            Log.d(str3, "authentication request => " + str4);
            String a = ui2.a(nfcV.transceive(d));
            Log.d(str3, "authentication response <= " + a);
            if (!a.startsWith(sc0.RESP_AUTH_RESULT_PREFIX)) {
                Log.e(str3, "auth response command is wrong: " + a);
                return null;
            }
            String f = ui2.f(a.substring(4));
            Log.d(str3, "cipher tex: " + f);
            Log.d(str3, "authentication result:  failed");
            return f;
        }
    }

    public static String b(String str, NfcV nfcV) throws IOException {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555658047")) {
            return (String) ipChange.ipc$dispatch("1555658047", new Object[]{str, nfcV});
        } else if (nfcV == null) {
            Log.e(TAG, "getSid - nfcV is null.");
            return null;
        } else {
            try {
                str2 = ui2.a(nfcV.transceive(ui2.d(sc0.CMD_READ_PREFIX + str + "0F")));
            } catch (Exception e) {
                e.printStackTrace();
                str2 = null;
            }
            String str3 = TAG;
            Log.d(str3, "read block0F response: " + str2);
            if (str2 == null || !str2.startsWith("00")) {
                Log.e(str3, "read dara error..");
                return null;
            } else if (str2.length() >= 12) {
                String f = ui2.f(str2.substring(2, 12));
                Log.d(str3, "sid: " + f);
                return f;
            } else {
                Log.d(str3, "sid length < 12 ");
                return null;
            }
        }
    }

    public static String c(String str, NfcV nfcV) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-619022050")) {
            return (String) ipChange.ipc$dispatch("-619022050", new Object[]{str, nfcV});
        } else if (nfcV == null) {
            Log.e(TAG, "getTid - nfcV is null.");
            return null;
        } else {
            String str2 = sc0.CMD_READ_PREFIX + str + "38";
            String a = ui2.a(nfcV.transceive(ui2.d(str2)));
            String a2 = ui2.a(nfcV.transceive(ui2.d(sc0.CMD_READ_PREFIX + str + "39")));
            if (!a.startsWith("00") || !a2.startsWith("00")) {
                Log.e(TAG, "read data error..");
                return null;
            }
            String f = ui2.f(a2.substring(10) + a.substring(2));
            String str3 = TAG;
            Log.d(str3, "read block 38 response <= " + a);
            Log.d(str3, "read block 39 response <= " + a2);
            Log.d(str3, "get tid <= " + f);
            return f;
        }
    }

    public static String d(NfcV nfcV) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311908915")) {
            return (String) ipChange.ipc$dispatch("311908915", new Object[]{nfcV});
        } else if (nfcV == null) {
            Log.e(TAG, "getUid - nfcV is null.");
            return null;
        } else {
            byte[] a = sc0.a();
            String str = TAG;
            Log.d(str, "get uid request => 260100");
            nfcV.connect();
            String a2 = ui2.a(nfcV.transceive(a));
            if (a2.startsWith("0000")) {
                String substring = a2.substring(4);
                Log.i(str, "get uid response <= " + substring);
                return substring;
            }
            Log.e(str, "get UID failed.");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00db, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r0.a = false;
        r0.b = "read nfc tag error";
        r0.c = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f0, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f1, code lost:
        if (r1 != null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f8, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fb, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dd */
    @NonNull
    public static b e(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "741774914")) {
            return (b) ipChange.ipc$dispatch("741774914", new Object[]{intent});
        }
        b bVar = new b();
        NfcV nfcV = null;
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        if (tag == null) {
            bVar.a = false;
            bVar.b = "tag is null";
            bVar.c = 1;
            return bVar;
        }
        String[] techList = tag.getTechList();
        if (techList == null) {
            bVar.a = false;
            bVar.c = 2;
            bVar.b = "not support this tech";
            return bVar;
        }
        boolean z = false;
        for (String str : techList) {
            Log.i(TAG, "tag tech: " + str);
            if (str.contains("NfcV")) {
                z = true;
            }
        }
        if (z) {
            nfcV = NfcV.get(tag);
            String d = d(nfcV);
            if (TextUtils.isEmpty(d)) {
                bVar.a = false;
                bVar.c = 3;
                bVar.b = "read uId/sId/tId error";
                if (nfcV != null) {
                    try {
                        nfcV.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bVar;
            }
            String b = b(d, nfcV);
            String c = c(d, nfcV);
            if (TextUtils.isEmpty(d) || TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
                bVar.a = false;
                bVar.c = 3;
                bVar.b = "read uId/sId/tId error";
            } else {
                String e2 = ui2.e(20);
                String a = a(d, e2, nfcV);
                qi1 qi1 = new qi1();
                qi1.j(d);
                qi1.h(b);
                qi1.i(c);
                qi1.f(e2);
                qi1.g(a);
                bVar.a = true;
                bVar.d = qi1;
            }
            if (nfcV != null) {
                try {
                    nfcV.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return bVar;
        }
        bVar.a = false;
        bVar.b = "not support nfc v";
        bVar.c = 5;
        return bVar;
    }
}
