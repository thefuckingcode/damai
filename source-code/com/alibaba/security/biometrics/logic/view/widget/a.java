package com.alibaba.security.biometrics.logic.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.skin.model.DialogSkinData;

/* compiled from: Taobao */
public final class a {
    private static final String b = "ABAlertDialog";
    public Dialog a;
    private RPSkinManager c = RPSkinManager.getInstance();

    /* renamed from: com.alibaba.security.biometrics.logic.view.widget.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0101a {
        Context a;
        public String b;
        int c;
        public boolean d = true;
        public boolean e = false;
        public String f = "";
        int g;
        public c h = new c() {
            /* class com.alibaba.security.biometrics.logic.view.widget.a.C0101a.AnonymousClass1 */

            @Override // com.alibaba.security.biometrics.logic.view.widget.a.c
            public final void a(Dialog dialog) {
            }
        };
        public String i = "";
        int j;
        public b k = new b() {
            /* class com.alibaba.security.biometrics.logic.view.widget.a.C0101a.AnonymousClass2 */

            @Override // com.alibaba.security.biometrics.logic.view.widget.a.b
            public final void a(Dialog dialog) {
            }
        };

        public C0101a(Context context) {
            this.a = context;
            this.c = ContextCompat.getColor(context, R.color.rpsdk_color_333333);
            this.g = ContextCompat.getColor(context, R.color.rpsdk_ab_face_dialog_positive);
            this.j = ContextCompat.getColor(context, R.color.rpsdk_ab_face_dialog_negative);
        }

        private a a() {
            return new a(this);
        }

        private C0101a b() {
            this.d = true;
            this.e = false;
            return this;
        }

        private C0101a a(String str) {
            this.b = str;
            return this;
        }

        private C0101a a(String str, c cVar) {
            this.f = str;
            this.h = cVar;
            return this;
        }

        private C0101a a(String str, b bVar) {
            this.i = str;
            this.k = bVar;
            return this;
        }

        private C0101a a(int i2, int i3, int i4) {
            this.c = i2;
            this.g = i3;
            this.j = i4;
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

    public a(final C0101a aVar) {
        Dialog dialog = new Dialog(aVar.a, R.style.RP_Dialog);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(aVar.a).inflate(R.layout.rp_face_dialog, (ViewGroup) null);
        this.a.setContentView(inflate);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.a.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        this.a.getWindow().setAttributes(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.abfl_dialog_content_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.abfl_dialog_positive_btn);
        TextView textView3 = (TextView) inflate.findViewById(R.id.abfl_dialog_negative_btn);
        textView.setTextColor(aVar.c);
        textView2.setTextColor(aVar.g);
        textView3.setTextColor(aVar.j);
        if (TextUtils.isEmpty(aVar.b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(aVar.b);
        }
        if (TextUtils.isEmpty(aVar.f)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(aVar.f);
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.alibaba.security.biometrics.logic.view.widget.a.AnonymousClass1 */

                public final void onClick(View view) {
                    aVar.h.a(a.this.a);
                }
            });
        }
        if (TextUtils.isEmpty(aVar.i)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(aVar.i);
            textView3.setOnClickListener(new View.OnClickListener() {
                /* class com.alibaba.security.biometrics.logic.view.widget.a.AnonymousClass2 */

                public final void onClick(View view) {
                    aVar.k.a(a.this.a);
                }
            });
        }
        DialogSkinData dialogSkinData = (DialogSkinData) this.c.getGlobalSkinData("alertDialog", DialogSkinData.class);
        if (dialogSkinData != null) {
            b.a(textView2, dialogSkinData.getPositiveText());
            b.a(textView3, dialogSkinData.getNegativeText());
            b.a(textView, dialogSkinData.getTitleText());
        }
        this.a.setCancelable(aVar.d);
        this.a.setCanceledOnTouchOutside(aVar.e);
    }

    private void b() {
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void c() {
        Dialog dialog = this.a;
        if (dialog != null && !dialog.isShowing()) {
            this.a.show();
        }
    }

    private DialogSkinData d() {
        return (DialogSkinData) this.c.getGlobalSkinData("alertDialog", DialogSkinData.class);
    }

    public final boolean a() {
        Dialog dialog = this.a;
        return dialog != null && dialog.isShowing();
    }
}
