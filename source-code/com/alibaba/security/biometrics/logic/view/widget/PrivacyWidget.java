package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.common.track.model.a;

/* compiled from: Taobao */
public class PrivacyWidget extends BaseWidget {
    private Button b;
    private ImageView c;

    public PrivacyWidget(Context context) {
        super(context);
    }

    private static void g() {
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.b = (Button) findViewById(R.id.btnAgree);
        this.c = (ImageView) findViewById(R.id.ivLogoView);
        this.b.setOnClickListener(new View.OnClickListener() {
            /* class com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget.AnonymousClass1 */

            public final void onClick(View view) {
                PrivacyWidget privacyWidget = PrivacyWidget.this;
                if (privacyWidget.a != null) {
                    privacyWidget.setVisibility(8);
                    PrivacyWidget.this.a.e();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        b.a(this.b, c("mainButton"));
        b.a(this.c, a("logoImageView"), R.drawable.rp_face_privacy_logo);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return a.b.n;
    }

    public PrivacyWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivacyWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
