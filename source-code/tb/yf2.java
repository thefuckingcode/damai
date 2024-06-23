package tb;

import android.content.Context;
import android.util.Base64;
import cn.damai.common.user.c;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.utils.a;
import cn.damai.ticklet.utils.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.ByteBuffer;
import java.util.HashMap;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class yf2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204017354")) {
            return (String) ipChange.ipc$dispatch("204017354", new Object[]{context, str});
        }
        try {
            if (c(str)) {
                return "";
            }
            byte[] bArr = null;
            try {
                bArr = a.a(Base64.decode(str, 2), fs1.c(), Base64.decode(fs1.b(context, "salt", ""), 2));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bArr == null) {
                return str;
            }
            return new String(bArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993133484")) {
            return (String) ipChange.ipc$dispatch("993133484", new Object[]{context, str, str2, str3});
        }
        try {
            String a = a(context, str);
            if (a != null) {
                if (!"".equals(a)) {
                    String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                    byte[] decode = Base64.decode(split[0], 2);
                    long currentTimeMillis = System.currentTimeMillis();
                    String e = b30.e(String.valueOf(b30.b(currentTimeMillis)));
                    byte[] bytes = e.getBytes();
                    StringBuilder sb = new StringBuilder();
                    str4 = "";
                    try {
                        sb.append("票码：");
                        sb.append(split[0]);
                        sb.append(b30.e(String.valueOf(b30.a())));
                        g91.b("TimeDown", sb.toString());
                        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + decode.length);
                        allocate.put(bytes);
                        allocate.put(decode);
                        byte[] bArr = null;
                        try {
                            bArr = b.a(allocate.array(), str2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        String str5 = new String(Base64.encode(bArr, 2));
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(str5.trim());
                        if (split.length != 0) {
                            for (int i = 1; i < split.length; i++) {
                                stringBuffer.append("|");
                                stringBuffer.append(split[i]);
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("voucherCode", a);
                        hashMap.put("timeStamp", e);
                        hashMap.put("pubKey", str2);
                        hashMap.put(TicketDetailExtFragment.PERFORM_ID, str3);
                        hashMap.put("userCode", fs1.c());
                        hashMap.put("currentTime", b30.g(currentTimeMillis));
                        hashMap.put("sysTime", b30.g(b30.b(currentTimeMillis)));
                        hashMap.put("mBuffer", stringBuffer.toString().trim());
                        c.e().A(hashMap, "qr_code", "ticklet_qr_encrypte");
                        return stringBuffer.toString().trim();
                    } catch (Exception unused) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("voucherCode", str);
                        hashMap2.put("pubKey", str2);
                        hashMap2.put("userCode", fs1.c());
                        c.e().A(hashMap2, "qr_code", "ticklet_qr_encrypte_exception");
                        return str4;
                    }
                }
            }
            return "";
        } catch (Exception unused2) {
            str4 = "";
            HashMap hashMap22 = new HashMap();
            hashMap22.put("voucherCode", str);
            hashMap22.put("pubKey", str2);
            hashMap22.put("userCode", fs1.c());
            c.e().A(hashMap22, "qr_code", "ticklet_qr_encrypte_exception");
            return str4;
        }
    }

    public static boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1656998474")) {
            return str == null || "".equals(str.trim()) || str.trim().length() == 0 || "null".equals(str.trim());
        }
        return ((Boolean) ipChange.ipc$dispatch("1656998474", new Object[]{str})).booleanValue();
    }
}
