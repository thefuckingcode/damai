package com.alibaba.android.ultron.vfw.web;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.vessel.VesselView;
import java.util.Map;
import tb.h1;
import tb.jw2;
import tb.wv2;

/* compiled from: Taobao */
public class c extends h1 {
    public static final String KEY_USE_BRIDGE = "useBridge";
    private static final Float g = Float.valueOf(375.0f);
    private VesselView c;
    private a d;
    private String e;
    private String f;

    public c(wv2 wv2, String str) {
        super(wv2);
        this.e = str;
    }

    private String f(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return str;
        }
        if (jSONObject.containsKey(KEY_USE_BRIDGE)) {
            if (Boolean.TRUE.toString().equals(jSONObject.getString(KEY_USE_BRIDGE))) {
                return str;
            }
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            if (entry != null) {
                buildUpon.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return buildUpon.build().toString();
    }

    /* access modifiers changed from: protected */
    @Override // tb.h1
    public void d(@NonNull IDMComponent iDMComponent) {
        if (this.c != null && iDMComponent != null) {
            JSONObject fields = iDMComponent.getFields();
            String str = this.e;
            if (fields != null) {
                str = f(str, fields);
            }
            if (str == null || !str.equals(this.f)) {
                this.f = str;
                a aVar = new a(this.a);
                this.d = aVar;
                aVar.a(iDMComponent);
                this.c.setVesselViewCallback(this.d);
                this.c.loadUrl(str);
                if (this.c.findViewWithTag(WebMaskView.TAG) == null) {
                    this.c.setOnLoadListener(new b(new WebMaskView(this.c, str), str, this.a.k()));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045 A[SYNTHETIC, Splitter:B:12:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    @Override // tb.h1
    public View e(@Nullable ViewGroup viewGroup) {
        int i;
        int i2;
        this.c = new VesselView(this.a.l());
        if (TextUtils.isEmpty(this.e)) {
            return jw2.a(this.a.l());
        }
        Uri parse = Uri.parse(this.e);
        String queryParameter = parse.getQueryParameter("height");
        String queryParameter2 = parse.getQueryParameter("width");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                i = Integer.parseInt(queryParameter);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    i2 = Integer.parseInt(queryParameter2);
                } catch (Exception unused2) {
                }
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                if (i > 0) {
                    layoutParams.height = (int) ((((float) i) / g.floatValue()) * ((float) viewGroup.getWidth()));
                }
                if (i2 > 0) {
                    if (i2 > 375) {
                        i2 = 375;
                    }
                    layoutParams.width = (int) ((((float) i2) / g.floatValue()) * ((float) viewGroup.getWidth()));
                }
                this.c.setLayoutParams(layoutParams);
                return this.c;
            }
            i2 = -1;
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            if (i > 0) {
            }
            if (i2 > 0) {
            }
            this.c.setLayoutParams(layoutParams2);
            return this.c;
        }
        i = -1;
        if (!TextUtils.isEmpty(queryParameter2)) {
        }
        i2 = -1;
        ViewGroup.LayoutParams layoutParams22 = new ViewGroup.LayoutParams(-1, -1);
        if (i > 0) {
        }
        if (i2 > 0) {
        }
        this.c.setLayoutParams(layoutParams22);
        return this.c;
    }

    public void g() {
        VesselView vesselView = this.c;
        if (vesselView != null) {
            vesselView.onDestroy();
        }
    }
}
