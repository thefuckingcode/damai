package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.ArrayList;
import java.util.Map;
import tb.c80;
import tb.dc0;
import tb.kk1;
import tb.q42;
import tb.s70;
import tb.uj;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
public class DSwitchConstructor extends DinamicViewAdvancedConstructor {
    private static final int CHECKED_COLOR = -45056;
    private static final String D_HEIGHT = "dHeight";
    private static final String D_OFF_COLOR = "dOffColor";
    private static final String D_ON_COLOR = "dOnColor";
    private static final String D_SWITCH_ON = "dSwitchOn";
    private static final String D_WIDTH = "dWidth";
    private static final String STRING_CHECKED_COLOR = "#ffff5000";
    private static final String STRING_UNCHECKED_COLOR = "#ffe5e5e5";
    private static final int UNCHECKED_COLOR = -1710619;
    private static final String VIEW_EVENT_ON_CHANGE = "onChange";
    public static final String VIEW_TAG = "DSwitch";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class OnChangeListener implements CompoundButton.OnCheckedChangeListener {
        private x70 mDinamicParams;
        private b mHandler;
        private String mOnChangeExpression;
        private z70 mProperty;
        private View mView;

        public OnChangeListener(b bVar, x70 x70, z70 z70, View view) {
            this.mHandler = bVar;
            this.mDinamicParams = x70;
            this.mProperty = z70;
            this.mView = view;
            Map<String, String> map = z70.d;
            if (!map.isEmpty()) {
                this.mOnChangeExpression = map.get("onChange");
            }
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Object tag = compoundButton.getTag(R$id.change_with_attribute);
            if (!TextUtils.isEmpty(this.mOnChangeExpression) && !"true".equals(tag)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add(Boolean.valueOf(compoundButton.isChecked()));
                this.mView.setTag(c80.VIEW_PARAMS, arrayList);
                s70.d(this.mView, this.mDinamicParams, this.mProperty, this.mOnChangeExpression);
            }
        }
    }

    /* compiled from: Taobao */
    private static class b extends s70 {
        private b() {
        }

        @Override // tb.s70
        public void b(View view, x70 x70) {
            e(view, x70);
        }

        public void e(View view, x70 x70) {
            z70 z70 = (z70) view.getTag(c80.PROPERTY_KEY);
            if (z70 != null) {
                Map<String, String> map = z70.d;
                if (!map.isEmpty() && map.containsKey("onChange") && (view instanceof SwitchCompat)) {
                    ((SwitchCompat) view).setOnCheckedChangeListener(new OnChangeListener(this, x70, z70, view));
                }
            }
        }
    }

    private StateListDrawable getSelector(Drawable drawable, Drawable drawable2) {
        return dc0.b(drawable, drawable2, dc0.STATE_CHECKED);
    }

    private GradientDrawable getThumbDrawable(Context context, int i) {
        return dc0.c((int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()), 16777215, i / 2, -1, i, i);
    }

    private GradientDrawable getTrackDrawable(Context context, String str, int i, int i2) {
        return dc0.c(0, 16777215, i2 / 2, uj.a(str, i), i2, i2);
    }

    private void setEnable(View view, boolean z) {
        view.setEnabled(z);
    }

    private void updateInternalStatus(SwitchCompat switchCompat, Drawable drawable, Drawable drawable2, Drawable drawable3) {
        if (switchCompat != null) {
            switchCompat.setTrackDrawable(getSelector(drawable, drawable2));
            switchCompat.setThumbDrawable(drawable3);
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        SwitchCompat switchCompat = new SwitchCompat(context, attributeSet);
        switchCompat.setClickable(true);
        switchCompat.setTextOn("");
        switchCompat.setTextOff("");
        switchCompat.setShowText(false);
        switchCompat.setThumbTextPadding(0);
        switchCompat.setSplitTrack(false);
        return switchCompat;
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        super.setAttributes(view, map, arrayList, x70);
        SwitchCompat switchCompat = view instanceof SwitchCompat ? (SwitchCompat) view : null;
        if (arrayList.contains("dHeight") || arrayList.contains(D_ON_COLOR) || arrayList.contains(D_OFF_COLOR)) {
            Object obj = map.get("dHeight");
            Object obj2 = map.get(D_ON_COLOR);
            Object obj3 = map.get(D_OFF_COLOR);
            String str = obj2 instanceof String ? (String) obj2 : STRING_CHECKED_COLOR;
            String str2 = obj3 instanceof String ? (String) obj3 : STRING_UNCHECKED_COLOR;
            int b2 = q42.b(view.getContext(), obj, -1);
            if (b2 != -1) {
                updateInternalStatus(switchCompat, getTrackDrawable(view.getContext(), str, CHECKED_COLOR, b2), getTrackDrawable(view.getContext(), str2, UNCHECKED_COLOR, b2), getThumbDrawable(view.getContext(), b2));
            }
        }
        if (arrayList.contains("dWidth")) {
            Object obj4 = map.get("dWidth");
            Object obj5 = map.get("dHeight");
            int b3 = q42.b(view.getContext(), obj4, -1);
            int b4 = q42.b(view.getContext(), obj5, -1);
            if (!(b3 == -1 || b4 == -1 || b3 < b4 * 2)) {
                setSwitchMinWidth(switchCompat, b3);
            }
        }
        if (arrayList.contains(D_SWITCH_ON)) {
            setChecked(switchCompat, kk1.b((String) map.get(D_SWITCH_ON)));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ENABLED)) {
            String str3 = (String) map.get(DAttrConstant.VIEW_ENABLED);
            if (!TextUtils.isEmpty(str3)) {
                setEnable(view, kk1.b(str3));
            } else {
                setEnable(view, true);
            }
        }
    }

    public void setChecked(SwitchCompat switchCompat, boolean z) {
        if (switchCompat != null) {
            int i = R$id.change_with_attribute;
            switchCompat.setTag(i, "true");
            switchCompat.setChecked(z);
            switchCompat.setTag(i, "false");
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setEvents(View view, x70 x70) {
        new b().b(view, x70);
    }

    public void setSwitchMinWidth(SwitchCompat switchCompat, int i) {
        if (switchCompat != null) {
            switchCompat.setSwitchMinWidth(i);
        }
    }
}
