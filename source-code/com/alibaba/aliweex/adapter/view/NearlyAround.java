package com.alibaba.aliweex.adapter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.aliweex.R$drawable;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.R$layout;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.List;
import tb.kh1;

/* compiled from: Taobao */
public class NearlyAround {
    private Context a;
    private LinearLayout b;
    private List<kh1> c;
    private OnNearlyItemClickListener d;
    private ViewGroup e;
    private String f;
    private List<kh1> g;

    /* compiled from: Taobao */
    public interface OnNearlyItemClickListener {
        void OnNearlyItemClick(kh1 kh1);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (NearlyAround.this.d != null) {
                NearlyAround.this.d.OnNearlyItemClick((kh1) view.getTag());
            }
        }
    }

    public NearlyAround(Context context) {
        this.a = context;
        c();
    }

    private void c() {
        this.c = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R$layout.huichang_nearlyaround_layout, (ViewGroup) null);
        this.e = viewGroup;
        if (viewGroup != null) {
            TextView textView = (TextView) viewGroup.findViewById(R$id.nearlyaround_title);
            this.b = (LinearLayout) this.e.findViewById(R$id.nearlyaround_linear);
        }
    }

    public View b() {
        return this.e;
    }

    public void d(OnNearlyItemClickListener onNearlyItemClickListener) {
        this.d = onNearlyItemClickListener;
    }

    @SuppressLint({"NewApi"})
    public void e() {
        this.b.removeAllViews();
        String string = PreferenceManager.getDefaultSharedPreferences(this.a).getString("huichang_footstep_cache", "");
        this.f = string;
        Log.d("huichang_footstep_cache", string);
        if (TextUtils.isEmpty(this.f)) {
            this.e.findViewById(R$id.nearlyaround_title1).setVisibility(0);
            return;
        }
        try {
            this.g = JSON.parseArray(this.f, kh1.class);
        } catch (Exception unused) {
        }
        List<kh1> list = this.g;
        if (list == null || list.size() <= 0) {
            this.e.findViewById(R$id.nearlyaround_title1).setVisibility(0);
            return;
        }
        this.e.findViewById(R$id.nearlyaround_title1).setVisibility(8);
        this.c.clear();
        this.c.addAll(this.g);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            kh1 kh1 = this.g.get(i);
            TextView textView = new TextView(this.a);
            textView.setText(kh1.a());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(WXViewUtils.dip2px(12.0f), 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(Color.parseColor("#fffef0"));
            textView.setTextSize(16.0f);
            textView.setBackgroundDrawable(this.a.getResources().getDrawable(R$drawable.huichang_nearlyaround_tv_bg));
            textView.setTag(kh1);
            textView.setOnClickListener(new a());
            this.b.addView(textView);
        }
    }
}
