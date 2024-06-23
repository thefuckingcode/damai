package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamicx.c;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.Map;
import tb.kk1;
import tb.q42;
import tb.sp;
import tb.x70;

/* compiled from: Taobao */
public class DTextViewConstructor extends DinamicViewAdvancedConstructor {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final String TAG = "DTextViewConstructor";

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void applyDefaultProperty(View view, Map<String, Object> map, x70 x70) {
        super.applyDefaultProperty(view, map, x70);
        TextView textView = (TextView) view;
        if (!map.containsKey(DAttrConstant.TV_TEXT_SIZE)) {
            textView.setTextSize(1, 12.0f);
        }
        if (!map.containsKey(DAttrConstant.TV_TEXT_COLOR)) {
            textView.setTextColor(-16777216);
        }
        if (!map.containsKey(DAttrConstant.TV_MAX_LINES)) {
            textView.setMaxLines(1);
        }
        if (!map.containsKey(DAttrConstant.TV_LINE_BREAK_MODE)) {
            textView.setEllipsize(null);
        }
        if (!map.containsKey(DAttrConstant.TV_TEXT_GRAVITY) && !map.containsKey(DAttrConstant.TV_TEXT_ALIGNMENT)) {
            textView.setGravity(16);
        }
        if (!map.containsKey(DAttrConstant.VIEW_ACCESSIBILITYTEXT_HIDDEN)) {
            setAccessibilityHidden(view, true);
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new TextView(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        super.setAttributes(view, map, arrayList, x70);
        TextView textView = (TextView) view;
        if (arrayList.contains(DAttrConstant.TV_TEXT)) {
            setText(textView, (String) map.get(DAttrConstant.TV_TEXT));
        }
        if (arrayList.contains(DAttrConstant.TV_TEXT_SIZE)) {
            if (c.g(x70.c())) {
                boolean z = true;
                if (map.containsKey(DAttrConstant.TV_TEXT_SIZE_ENABLE_STRATEGY)) {
                    z = kk1.b((String) map.get(DAttrConstant.TV_TEXT_SIZE_ENABLE_STRATEGY));
                }
                if (z) {
                    setElderTextSize(textView, (String) map.get(DAttrConstant.TV_TEXT_SIZE));
                } else {
                    setTextSize(textView, (String) map.get(DAttrConstant.TV_TEXT_SIZE));
                }
            } else {
                setTextSize(textView, (String) map.get(DAttrConstant.TV_TEXT_SIZE));
            }
        }
        if (arrayList.contains(DAttrConstant.TV_TEXT_THEME) || arrayList.contains(DAttrConstant.TV_TEXT_STYLE)) {
            setTextTheme(textView, (String) map.get(DAttrConstant.TV_TEXT_THEME), (String) map.get(DAttrConstant.TV_TEXT_STYLE));
        }
        if (arrayList.contains(DAttrConstant.TV_TEXT_COLOR)) {
            setTextColor(textView, (String) map.get(DAttrConstant.TV_TEXT_COLOR));
        }
        if (arrayList.contains(DAttrConstant.TV_MAX_LINES)) {
            setMaxLines(textView, (String) map.get(DAttrConstant.TV_MAX_LINES));
        }
        if (arrayList.contains(DAttrConstant.TV_MAX_WIDTH)) {
            setMaxWidth(textView, (String) map.get(DAttrConstant.TV_MAX_WIDTH));
        }
        if (arrayList.contains(DAttrConstant.TV_LINE_BREAK_MODE)) {
            setTextLineBreakMode(textView, (String) map.get(DAttrConstant.TV_LINE_BREAK_MODE));
        }
        if (arrayList.contains(DAttrConstant.TV_STRIKE_THROUGH)) {
            setDeleteLine(textView, (String) map.get(DAttrConstant.TV_STRIKE_THROUGH));
        }
        if (arrayList.contains(DAttrConstant.TV_TEXT_GRAVITY) || arrayList.contains(DAttrConstant.TV_TEXT_ALIGNMENT)) {
            setTextGravity(textView, (String) map.get(DAttrConstant.TV_TEXT_GRAVITY), (String) map.get(DAttrConstant.TV_TEXT_ALIGNMENT));
        }
    }

    public void setDeleteLine(TextView textView, String str) {
        if (TextUtils.equals(Constants.LayoutType.SINGLE, str)) {
            textView.getPaint().setFlags(16);
        }
    }

    public void setElderTextSize(TextView textView, String str) {
        int a = (int) c.a((float) q42.b(textView.getContext(), str, -1));
        if (a == -1) {
            textView.setTextSize(1, 18.0f);
        } else {
            textView.setTextSize(0, (float) a);
        }
    }

    public void setMaxLines(TextView textView, String str) {
        Integer valueOf = Integer.valueOf(str);
        if (valueOf.intValue() <= 0) {
            textView.setMaxLines(Integer.MAX_VALUE);
        } else if (valueOf.intValue() == 1) {
            textView.setMaxLines(1);
        } else {
            textView.setMaxLines(valueOf.intValue());
        }
    }

    public void setMaxWidth(TextView textView, String str) {
        int b = q42.b(textView.getContext(), str, -1);
        if (b != -1) {
            textView.setMaxWidth(b);
        }
    }

    public void setText(TextView textView, String str) {
        textView.setText(str);
    }

    public void setTextAlignment(TextView textView, String str) {
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 0) {
            textView.setGravity(19);
        } else if (intValue == 1) {
            textView.setGravity(17);
        } else if (intValue == 2) {
            textView.setGravity(21);
        }
    }

    public void setTextColor(TextView textView, String str) {
        textView.setTextColor(sp.d(str, -16777216));
    }

    public void setTextGravity(TextView textView, String str, String str2) {
        if (str == null) {
            setTextAlignment(textView, str2);
        } else if ("left".equals(str)) {
            textView.setGravity(19);
        } else if ("center".equals(str)) {
            textView.setGravity(17);
        } else if ("right".equals(str)) {
            textView.setGravity(21);
        } else {
            textView.setGravity(16);
        }
    }

    public void setTextLineBreakMode(TextView textView, String str) {
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 0) {
            textView.setEllipsize(null);
        } else if (intValue == 1) {
            textView.setEllipsize(TextUtils.TruncateAt.START);
        } else if (intValue == 2) {
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (intValue == 3) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void setTextSize(TextView textView, String str) {
        int b = q42.b(textView.getContext(), str, -1);
        if (b == -1) {
            textView.setTextSize(1, 12.0f);
        } else {
            textView.setTextSize(0, (float) b);
        }
    }

    public void setTextStyle(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
            return;
        }
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 0) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        } else if (intValue == 1) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
        } else if (intValue == 2) {
            textView.setTypeface(Typeface.defaultFromStyle(2));
        } else if (intValue == 3) {
            textView.setTypeface(Typeface.defaultFromStyle(3));
        }
    }

    public void setTextTheme(TextView textView, String str, String str2) {
        if (str == null) {
            setTextStyle(textView, str2);
        } else if ("normal".equals(str)) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        } else if (Constants.Value.BOLD.equals(str)) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
        } else if (Constants.Value.ITALIC.equals(str)) {
            textView.setTypeface(Typeface.defaultFromStyle(2));
        } else {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
    }
}
