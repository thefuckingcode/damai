package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.common.track.model.a;

/* compiled from: Taobao */
public class GuideWidget extends AbsGuideWidget {
    private static final String b = "GuideWidget";
    private ImageView c;
    private TextView d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private Button i;
    private TextView j;

    public GuideWidget(Context context) {
        super(context);
    }

    private void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.e.setVisibility(0);
            this.g.setText(str);
        } else {
            this.e.setVisibility(8);
        }
        setVisibility(0);
    }

    private static void g() {
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.c = (ImageView) findViewById(R.id.abfl_widget_guide_icon);
        this.e = (LinearLayout) findViewById(R.id.abfl_widget_guide_subtext_parent);
        this.d = (TextView) findViewById(R.id.abfl_widget_guide_text);
        this.f = (TextView) findViewById(R.id.abfl_widget_guide_subtext_left);
        this.g = (TextView) findViewById(R.id.abfl_widget_guide_subtext_center);
        this.h = (TextView) findViewById(R.id.abfl_widget_guide_subtext_right);
        Button button = (Button) findViewById(R.id.abfl_widget_guide_btn);
        this.i = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.alibaba.security.biometrics.logic.view.widget.GuideWidget.AnonymousClass1 */

            public final void onClick(View view) {
                GuideWidget.this.setVisibility(8);
                ALBiometricsActivityParentView.a aVar = GuideWidget.this.a;
                if (aVar != null) {
                    aVar.d();
                }
            }
        });
        this.j = (TextView) findViewById(R.id.abfl_widget_guide_copyright);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        b.a(this.d, d("titleText"));
        b.a(this.f, d("messageText"));
        b.a(this.h, d("messageText"));
        b.a(this.g, d("markMessageText"));
        b.a(this.i, c("mainButton"));
        b.a(this.j, d("privacyTipText"));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return a.b.m;
    }

    public GuideWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.c, com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a(String... strArr) {
        String str = strArr.length > 0 ? strArr[0] : null;
        if (!TextUtils.isEmpty(str)) {
            this.e.setVisibility(0);
            this.g.setText(str);
        } else {
            this.e.setVisibility(8);
        }
        setVisibility(0);
    }
}
