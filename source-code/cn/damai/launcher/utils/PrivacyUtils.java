package cn.damai.launcher.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.AppConfig;
import cn.damai.homepage.R$array;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$string;
import cn.damai.launcher.splash.SplashWebViewActivity;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.DecimalFormat;
import java.util.ArrayList;
import tb.rs1;
import tb.xf2;

/* compiled from: Taobao */
public class PrivacyUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    private static ClickableSpan a(final Context context, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640821441")) {
            return (ClickableSpan) ipChange.ipc$dispatch("640821441", new Object[]{context, str});
        } else if (context == null || TextUtils.isEmpty(str)) {
            return null;
        } else {
            return new ClickableSpan() {
                /* class cn.damai.launcher.utils.PrivacyUtils.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(@NonNull View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2035085842")) {
                        ipChange.ipc$dispatch("-2035085842", new Object[]{this, view});
                        return;
                    }
                    Intent intent = new Intent(context, SplashWebViewActivity.class);
                    intent.putExtra("url", str);
                    context.startActivity(intent);
                }

                public void updateDrawState(@NonNull TextPaint textPaint) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2065149577")) {
                        ipChange.ipc$dispatch("2065149577", new Object[]{this, textPaint});
                        return;
                    }
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(context.getResources().getColor(R$color.color_ff2d79));
                }
            };
        }
    }

    public static TextView b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632915421")) {
            return (TextView) ipChange.ipc$dispatch("-1632915421", new Object[]{context});
        }
        String[] stringArray = context.getResources().getStringArray(R$array.privacy_url_list);
        String[] stringArray2 = context.getResources().getStringArray(R$array.privacy_content_list);
        int length = stringArray2 != null ? stringArray2.length : 0;
        if (length != (stringArray != null ? stringArray.length : 0) || length == 0) {
            Log.d("privacy", "content or url error");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        String b = rs1.b();
        if (!TextUtils.isEmpty(b)) {
            arrayList.addAll(JSON.parseArray(b, Integer.class));
            int e = xf2.e(arrayList);
            if (e > length) {
                e = length;
            }
            sb.append(context.getResources().getString(R$string.dialog_content_title));
            for (int i = 0; i < e; i++) {
                int intValue = ((Integer) arrayList.get(i)).intValue();
                if (intValue < length) {
                    sb.append(stringArray2[intValue]);
                }
            }
            sb.append(context.getResources().getString(R$string.dialog_content_end));
        } else {
            sb.append(context.getResources().getString(R$string.dialog_content));
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        String sb2 = sb.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb2);
        int e2 = xf2.e(arrayList);
        for (int i3 = 0; i3 < e2; i3++) {
            int intValue2 = ((Integer) arrayList.get(i3)).intValue();
            if (intValue2 < length) {
                int indexOf = sb2.indexOf(stringArray2[intValue2]);
                int length2 = stringArray2[intValue2].length() + indexOf;
                ClickableSpan a = a(context, stringArray[intValue2]);
                if (a != null) {
                    spannableStringBuilder.setSpan(new StyleSpan(0), indexOf, length2, 18);
                    spannableStringBuilder.setSpan(a, indexOf, length2, 18);
                }
            }
        }
        for (int i4 = 0; i4 < length; i4++) {
            int lastIndexOf = sb2.lastIndexOf(stringArray2[i4]);
            int length3 = stringArray2[i4].length() + lastIndexOf;
            ClickableSpan a2 = a(context, stringArray[i4]);
            if (a2 != null) {
                spannableStringBuilder.setSpan(new StyleSpan(0), lastIndexOf, length3, 18);
                spannableStringBuilder.setSpan(a2, lastIndexOf, length3, 18);
            }
        }
        TextView textView = new TextView(context);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 14.0f);
        textView.setText(spannableStringBuilder);
        textView.setTextColor(Color.parseColor("#9C9CA5"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        return textView;
    }

    @Deprecated
    public static boolean isSpecificVersion() {
        int parseInt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883723042")) {
            return ((Boolean) ipChange.ipc$dispatch("1883723042", new Object[0])).booleanValue();
        }
        if (rs1.i()) {
            rs1.n();
            String q = AppConfig.q();
            if (!TextUtils.isEmpty(q) && q.contains(".")) {
                String format = new DecimalFormat("0").format((long) Integer.parseInt(q.replace(".", "")));
                if (TextUtils.isEmpty(format) || format.length() < 4 || (parseInt = Integer.parseInt(format.substring(0, 4))) < 7765 || parseInt > 7800) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
