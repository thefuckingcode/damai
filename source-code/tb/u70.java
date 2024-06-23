package tb;

import android.text.TextUtils;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.expression.parser.DinamicDataParser;
import com.taobao.android.dinamic.expression.parser.a;
import com.taobao.android.dinamic.expressionv2.g;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
public class u70 {
    public static final String currentVersion = "2.0";

    public static Object a(String str, String str2, x70 x70) {
        Object obj = null;
        if (!(x70 == null || x70.d() == null || str == null)) {
            if (str.startsWith(o70.DINAMIC_PREFIX_AT)) {
                return g.g(str, str2, x70);
            }
            char[] charArray = str.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            boolean z = false;
            boolean z2 = false;
            StringBuffer stringBuffer3 = stringBuffer;
            String str3 = null;
            for (char c : charArray) {
                if ('$' == c) {
                    stringBuffer3 = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    z = true;
                } else if ('{' == c && z) {
                    str3 = stringBuffer3.toString();
                    if (a.a(str3)) {
                        z = false;
                        z2 = true;
                    } else {
                        z = false;
                    }
                } else if ('}' != c || !z2) {
                    if (z) {
                        stringBuffer3.append(c);
                    } else if (z2) {
                        stringBuffer2.append(c);
                    }
                } else {
                    String stringBuffer4 = stringBuffer2.toString();
                    if (TextUtils.isEmpty(stringBuffer4)) {
                        obj = x70.d();
                    } else {
                        DinamicDataParser b = a.b(str3);
                        if (b != null) {
                            try {
                                obj = b.parser(stringBuffer4, x70);
                            } catch (Throwable th) {
                                if (b.e()) {
                                    DinamicLog.i("DinamicExpresstion", th, "parse express failed, parser=", b.getClass().getName());
                                }
                                x70.e().b().a(r70.ERROR_CODE_TEMPLATE_PARSER_EXCEPTION, str2);
                            }
                        } else {
                            x70.e().b().a(r70.ERROR_CODE_TEMPLATE_PARSER_NOT_FOUND, str2);
                        }
                    }
                    if (!(obj == null || ((obj instanceof String) && TextUtils.isEmpty(obj.toString())))) {
                        return obj;
                    }
                    z = false;
                }
                z2 = false;
            }
        }
        return obj;
    }
}
