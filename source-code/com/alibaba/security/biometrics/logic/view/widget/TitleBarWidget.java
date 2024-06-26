package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.c.c.b;
import com.alibaba.security.biometrics.skin.model.NavigatorSkinData;

/* compiled from: Taobao */
public class TitleBarWidget extends BaseWidget {
    private static final String b = "TitleBarWidget";
    private ImageView c;
    private LinearLayout d;
    private TextView e;
    private boolean f;
    private View.OnClickListener g;

    public TitleBarWidget(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        NavigatorSkinData b2 = b("navigator");
        if (b2 != null) {
            b.a(this.c, b2.getCloseImageView(), R.drawable.rp_face_top_back);
        } else {
            this.c.setImageResource(R.drawable.rp_face_top_back);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void d() {
        RelativeLayout.LayoutParams layoutParams;
        if (b.a(getContext()) > 0 && (layoutParams = (RelativeLayout.LayoutParams) getLayoutParams()) != null) {
            layoutParams.setMargins(0, b.a(getContext()), 0, 0);
            setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "navigator";
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void setTitle(String str) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public TitleBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.c = (ImageView) findViewById(R.id.abfl_widget_tb_close);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.abfl_widget_tb_close_parent);
        this.d = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget.AnonymousClass1 */

            public final void onClick(View view) {
                if (TitleBarWidget.this.g != null) {
                    TitleBarWidget.this.g.onClick(view);
                }
            }
        });
        this.e = (TextView) findViewById(R.id.tvTitle);
    }

    public TitleBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
