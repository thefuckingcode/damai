package com.taobao.android.purchase.core.dinamcX.constructor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.taobao.android.dinamic.constructor.DTextViewConstructor;
import com.taobao.android.purchase.core.dinamcX.view.CountDownTextView;
import java.util.ArrayList;
import java.util.Map;
import tb.o70;
import tb.s70;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
public class TradeCountDownConstructor extends DTextViewConstructor {
    private static final String D_BEGIN_TIME = "dBeginTime";
    private static final String D_COUNT_INTERVAL = "dCountInterval";
    private static final String D_IDLE_TEXT = "dIdleText";
    private static final String D_TIME_IN_FUTURE = "dTimeInFuture";
    private static final String VIEW_EVENT_ON_CLICK = "onClick";
    private static final String VIEW_EVENT_ON_FINISH = "onFinish";
    public static final String VIEW_TAG = "TradeCountDownTimer";

    /* compiled from: Taobao */
    private static class b extends s70 {
        private b() {
        }

        @Override // tb.s70
        public void b(View view, x70 x70) {
            e(view, x70);
        }

        public void e(View view, x70 x70) {
            z70 z70 = (z70) view.getTag(o70.PROPERTY_KEY);
            if (z70 != null) {
                Map<String, String> map = z70.d;
                if (!map.isEmpty()) {
                    if (map.containsKey("onClick") && (view instanceof CountDownTextView)) {
                        view.setOnClickListener(new c(this, x70, z70, (CountDownTextView) view));
                    }
                    if (map.containsKey("onFinish") && (view instanceof CountDownTextView)) {
                        ((CountDownTextView) view).setOnFinishListener(new d(this, x70, z70, view));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c implements View.OnClickListener {
        private b a;
        private x70 b;
        private z70 c;
        private CountDownTextView d;
        private String e;

        public c(b bVar, x70 x70, z70 z70, CountDownTextView countDownTextView) {
            this.a = bVar;
            this.b = x70;
            this.c = z70;
            this.d = countDownTextView;
            Map<String, String> map = z70.d;
            if (!map.isEmpty()) {
                this.e = map.get("onClick");
            }
        }

        public void onClick(View view) {
            if (!this.d.isCountDowning() && !TextUtils.isEmpty(this.e)) {
                s70.d(this.d, this.b, this.c, this.e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d implements CountDownTextView.OnFinishListener {
        private b a;
        private x70 b;
        private z70 c;
        private View d;
        private String e;

        public d(b bVar, x70 x70, z70 z70, View view) {
            this.a = bVar;
            this.b = x70;
            this.c = z70;
            this.d = view;
            Map<String, String> map = z70.d;
            if (!map.isEmpty()) {
                this.e = map.get("onFinish");
            }
        }

        @Override // com.taobao.android.purchase.core.dinamcX.view.CountDownTextView.OnFinishListener
        public void onFinish(CountDownTextView countDownTextView) {
            if (!TextUtils.isEmpty(this.e)) {
                s70.d(this.d, this.b, this.c, this.e);
            }
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor, com.taobao.android.dinamic.constructor.DTextViewConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new CountDownTextView(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor, com.taobao.android.dinamic.constructor.DTextViewConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, x70 x70) {
        super.setAttributes(view, map, arrayList, x70);
        CountDownTextView countDownTextView = view instanceof CountDownTextView ? (CountDownTextView) view : null;
        if (countDownTextView != null) {
            if (arrayList.contains(D_IDLE_TEXT)) {
                Object obj = map.get(D_IDLE_TEXT);
                countDownTextView.setIdleText(obj != null ? obj.toString() : "");
            }
            if (arrayList.contains(D_COUNT_INTERVAL)) {
                try {
                    countDownTextView.setCountInterval(Long.parseLong(map.get(D_COUNT_INTERVAL).toString()));
                } catch (Throwable unused) {
                }
            }
            if (arrayList.contains(D_TIME_IN_FUTURE)) {
                try {
                    countDownTextView.setTimeInFuture(Long.parseLong(map.get(D_TIME_IN_FUTURE).toString()));
                } catch (Throwable unused2) {
                }
            }
            if (arrayList.contains(D_BEGIN_TIME)) {
                try {
                    countDownTextView.startCount(Long.parseLong(map.get(D_BEGIN_TIME).toString()));
                } catch (Throwable unused3) {
                }
            }
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setEvents(View view, x70 x70) {
        new b().b(view, x70);
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor
    public void setText(TextView textView, String str) {
    }
}
