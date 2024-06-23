package com.alibaba.security.realidentity.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.security.biometrics.R;

/* compiled from: Taobao */
public final class a {
    Dialog a;

    /* renamed from: com.alibaba.security.realidentity.view.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0110a {
        Context a;
        public String b;
        public String c;
        public String d;
        int e;
        int f;
        int g;
        public boolean h = true;
        public boolean i = false;
        public String j = "";
        int k;
        public c l = new c() {
            /* class com.alibaba.security.realidentity.view.a.C0110a.AnonymousClass1 */

            @Override // com.alibaba.security.realidentity.view.a.c
            public final void a(Dialog dialog) {
            }
        };
        public String m = "";
        int n;
        public b o = new b() {
            /* class com.alibaba.security.realidentity.view.a.C0110a.AnonymousClass2 */

            @Override // com.alibaba.security.realidentity.view.a.b
            public final void a(Dialog dialog) {
            }
        };

        public C0110a(Context context) {
            this.a = context;
            int i2 = R.color.rpsdk_common_text;
            this.e = ContextCompat.getColor(context, i2);
            int i3 = R.color.rpsdk_gray_light;
            this.f = ContextCompat.getColor(context, i3);
            this.g = ContextCompat.getColor(context, i2);
            this.k = ContextCompat.getColor(context, R.color.rpsdk_identity_primary);
            this.n = ContextCompat.getColor(context, i3);
        }

        private a a() {
            return new a(this);
        }

        private C0110a b(String str) {
            this.c = str;
            return this;
        }

        private C0110a c(String str) {
            this.d = str;
            return this;
        }

        private C0110a a(String str) {
            this.b = str;
            return this;
        }

        private C0110a b() {
            this.h = true;
            this.i = false;
            return this;
        }

        private C0110a a(String str, c cVar) {
            this.j = str;
            this.l = cVar;
            return this;
        }

        private C0110a a(String str, b bVar) {
            this.m = str;
            this.o = bVar;
            return this;
        }

        private C0110a a(int i2, int i3, int i4, int i5, int i6) {
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.k = i5;
            this.n = i6;
            return this;
        }
    }

    /* compiled from: Taobao */
    public interface b {
        void a(Dialog dialog);
    }

    /* compiled from: Taobao */
    public interface c {
        void a(Dialog dialog);
    }

    public a(final C0110a aVar) {
        Dialog dialog = new Dialog(aVar.a);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(aVar.a).inflate(R.layout.rp_alrealidentity_alert_dialog, (ViewGroup) null);
        this.a.setContentView(inflate);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.a.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        this.a.getWindow().setAttributes(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.rp_dialog_title_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.rp_dialog_subtitle_text);
        TextView textView3 = (TextView) inflate.findViewById(R.id.rp_dialog_content_text);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.rp_dialog_close_btn);
        Button button = (Button) inflate.findViewById(R.id.rp_dialog_positive_btn);
        Button button2 = (Button) inflate.findViewById(R.id.rp_dialog_negative_btn);
        textView.setTextColor(aVar.e);
        textView2.setTextColor(aVar.f);
        textView3.setTextColor(aVar.g);
        button.setTextColor(aVar.k);
        button2.setTextColor(aVar.n);
        if (TextUtils.isEmpty(aVar.b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(aVar.b);
        }
        if (TextUtils.isEmpty(aVar.c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(aVar.c);
        }
        if (TextUtils.isEmpty(aVar.d)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(aVar.d);
        }
        if (TextUtils.isEmpty(aVar.j)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(aVar.j);
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.alibaba.security.realidentity.view.a.AnonymousClass1 */

                public final void onClick(View view) {
                    aVar.l.a(a.this.a);
                }
            });
        }
        if (TextUtils.isEmpty(aVar.m)) {
            button2.setVisibility(8);
        } else {
            button2.setVisibility(0);
            button2.setText(aVar.m);
            button2.setOnClickListener(new View.OnClickListener() {
                /* class com.alibaba.security.realidentity.view.a.AnonymousClass2 */

                public final void onClick(View view) {
                    aVar.o.a(a.this.a);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.alibaba.security.realidentity.view.a.AnonymousClass3 */

            public final void onClick(View view) {
                aVar.o.a(a.this.a);
            }
        });
        this.a.setCancelable(aVar.h);
        this.a.setCanceledOnTouchOutside(aVar.i);
        this.a.show();
    }

    private void a() {
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
