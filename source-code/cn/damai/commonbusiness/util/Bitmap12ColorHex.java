package cn.damai.commonbusiness.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.damai.common.util.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.g91;
import tb.ns1;

/* compiled from: Taobao */
public class Bitmap12ColorHex {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String C_DEFAULT_HEX_COLOR = "#6E82AB";
    public static final String C_HEX_3F96D8 = "#3F96D8";
    public static final String C_HEX_40AAC8 = "#40AAC8";
    public static final String C_HEX_4EAC98 = "#4EAC98";
    public static final String C_HEX_536388 = "#536388";
    public static final String C_HEX_6E82AB = "#6E82AB";
    public static final String C_HEX_7176D4 = "#7176D4";
    public static final String C_HEX_89B959 = "#89B959";
    public static final String C_HEX_965BBD = "#965BBD";
    public static final String C_HEX_DE3F64 = "#DE3F64";
    public static final String C_HEX_E65549 = "#E65549";
    public static final String C_HEX_E87934 = "#E87934";
    public static final String C_HEX_EEA446 = "#EEA446";
    private static Bitmap12ColorHex c;
    private HashMap<String, String> a = new HashMap<>();
    private Handler b = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    public interface OnHexColorListener {
        void onHexColor(String str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String d(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520237813")) {
            return (String) ipChange.ipc$dispatch("1520237813", new Object[]{this, bitmap});
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i2 += Color.red(iArr[i6]);
            i3 += Color.green(iArr[i6]);
            i4 += Color.blue(iArr[i6]);
            i5 += Color.alpha(iArr[i6]);
        }
        int i7 = i5 / i;
        float[] fArr = new float[3];
        Color.colorToHSV(Color.argb(i7, i2 / i, i3 / i, i4 / i), fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        if (((double) fArr[2]) <= 0.35d) {
            return C_HEX_536388;
        }
        if (((double) f2) <= 0.05d) {
            return "#6E82AB";
        }
        if (f <= 10.0f) {
            return C_HEX_E65549;
        }
        if (f <= 30.0f) {
            return C_HEX_E87934;
        }
        if (f <= 50.0f) {
            return C_HEX_EEA446;
        }
        if (f <= 150.0f) {
            return C_HEX_89B959;
        }
        if (f <= 180.0f) {
            return C_HEX_4EAC98;
        }
        if (f <= 200.0f) {
            return C_HEX_40AAC8;
        }
        if (f <= 230.0f) {
            return C_HEX_3F96D8;
        }
        if (f <= 250.0f) {
            return C_HEX_7176D4;
        }
        if (f <= 280.0f) {
            return "#965BBD";
        }
        return f <= 340.0f ? C_HEX_DE3F64 : C_HEX_E65549;
    }

    public static Bitmap12ColorHex e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104767963")) {
            return (Bitmap12ColorHex) ipChange.ipc$dispatch("1104767963", new Object[0]);
        }
        if (c == null) {
            c = new Bitmap12ColorHex();
        }
        return c;
    }

    public void f(final Bitmap bitmap, final String str, final OnHexColorListener onHexColorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-567995048")) {
            ipChange.ipc$dispatch("-567995048", new Object[]{this, bitmap, str, onHexColorListener});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.a.get(str);
            if (!TextUtils.isEmpty(str2)) {
                onHexColorListener.onHexColor(str2);
                g91.c("HexColor", "use local " + str);
                return;
            }
        }
        ns1.a(new PriorityTask("Bitmap12ColorHex", null) {
            /* class cn.damai.commonbusiness.util.Bitmap12ColorHex.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.util.PriorityTask
            public void doTask() {
                final String str;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1529328134")) {
                    ipChange.ipc$dispatch("1529328134", new Object[]{this});
                    return;
                }
                try {
                    str = Bitmap12ColorHex.this.d(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                    str = "#6E82AB";
                }
                Bitmap12ColorHex.this.b.post(new Runnable() {
                    /* class cn.damai.commonbusiness.util.Bitmap12ColorHex.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1008354116")) {
                            ipChange.ipc$dispatch("-1008354116", new Object[]{this});
                            return;
                        }
                        g91.c("HexColor", "use new execute " + str);
                        if (!TextUtils.isEmpty(str)) {
                            Bitmap12ColorHex.this.a.put(str, str);
                        }
                        onHexColorListener.onHexColor(str);
                    }
                });
            }
        });
    }
}
