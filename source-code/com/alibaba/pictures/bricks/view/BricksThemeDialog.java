package com.alibaba.pictures.bricks.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.discover.bean.GridBean;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import tb.u50;

/* compiled from: Taobao */
public class BricksThemeDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private RoundImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ScrollView g;
    private TextView h;
    private TextView i;
    private BricksIconFontTextView j;
    private LinearLayout k;
    private MaxHeightLinearLayout l;
    private int m;

    /* compiled from: Taobao */
    public enum DMDialogTheme {
        THEME_REWARD,
        THEME_COMMENT,
        THEME_SYS_UPDATE,
        THEME_LOCATION,
        THEME_NOTIFICATION,
        THEME_ORDER_FAILURE,
        THEME_PERMISSION_ALBUM,
        THEME_PERMISSION_CAMERA,
        THEME_PERMISSION_CALENDAR,
        THEME_PERMISSION_CONTACTS,
        THEME_REAL_NAME,
        THEME_TAOBAO_LOGIN,
        THEME_GUARD_SUCCESS,
        THEME_YOUKU_LIVE,
        THEME_SUPPORT_WANNA
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        a(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-343521428")) {
                ipChange.ipc$dispatch("-343521428", new Object[]{this, view});
                return;
            }
            BricksThemeDialog.this.dismiss();
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(BricksThemeDialog.this, -2);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-415907986")) {
                ipChange.ipc$dispatch("-415907986", new Object[]{this, view});
                return;
            }
            BricksThemeDialog.this.dismiss();
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(BricksThemeDialog.this.h);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        c(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1695382383")) {
                ipChange.ipc$dispatch("1695382383", new Object[]{this, view});
                return;
            }
            BricksThemeDialog.this.dismiss();
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(BricksThemeDialog.this.i);
            }
        }
    }

    public BricksThemeDialog(@NonNull Context context) {
        this(context, R$style.BricksThemeDialogTheme);
    }

    public static int c(Context context, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809298040")) {
            return ((Integer) ipChange.ipc$dispatch("809298040", new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})).intValue();
        } else if (i4 == 0 || i5 == 0) {
            return 0;
        } else {
            u50 u50 = u50.INSTANCE;
            int b2 = DisplayMetrics.getwidthPixels(u50.d(context)) - u50.b(context, i3 + i3);
            return (b2 * i4) / i5 >= i2 ? (i2 * i5) / i4 : b2;
        }
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1132387961")) {
            ipChange.ipc$dispatch("1132387961", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.bricks_theme_dialog, (ViewGroup) null);
        this.l = (MaxHeightLinearLayout) inflate.findViewById(R$id.damai_theme_dialog_layout);
        this.a = c(getContext(), (int) (((double) this.l.getMaxHeight()) * 0.5d), 50, 220, GridBean.TYPE_PIC_URL);
        RoundImageView roundImageView = (RoundImageView) inflate.findViewById(R$id.damai_theme_dialog_top_image_bg);
        this.b = roundImageView;
        int i2 = (this.a * AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER) / GridBean.TYPE_PIC_URL;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) roundImageView.getLayoutParams();
        layoutParams.width = this.a;
        layoutParams.height = i2;
        this.b.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.damai_theme_dialog_top_image);
        this.c = imageView;
        int i3 = (this.a * 220) / GridBean.TYPE_PIC_URL;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = this.a;
        layoutParams2.height = i3;
        this.c.setLayoutParams(layoutParams2);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.damai_theme_dialog_container);
        this.k = linearLayout;
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams3.width = this.a;
        this.k.setLayoutParams(layoutParams3);
        this.d = (TextView) inflate.findViewById(R$id.damai_theme_dialog_title);
        this.e = (TextView) inflate.findViewById(R$id.damai_theme_dialog_subtitle);
        this.g = (ScrollView) inflate.findViewById(R$id.damai_theme_dialog_content_layout);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.damai_theme_dialog_content_container);
        this.f = (TextView) inflate.findViewById(R$id.damai_theme_dialog_tip_content);
        this.i = (TextView) inflate.findViewById(R$id.damai_theme_dialog_cancel_btn);
        this.h = (TextView) inflate.findViewById(R$id.damai_theme_dialog_confirm_btn);
        this.j = (BricksIconFontTextView) inflate.findViewById(R$id.damai_theme_dialog_close_btn);
        inflate.findViewById(R$id.damai_theme_dialog_bottom_space).setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (((double) DisplayMetrics.getheightPixels(u50.INSTANCE.d(getContext()))) * 0.05d)));
        setContentView(inflate);
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212092562")) {
            ipChange.ipc$dispatch("212092562", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
        }
    }

    public BricksThemeDialog e(@DrawableRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931499817")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("931499817", new Object[]{this, Integer.valueOf(i2)});
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setBackgroundResource(i2);
        }
        return this;
    }

    public BricksThemeDialog f(@DrawableRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865257465")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1865257465", new Object[]{this, Integer.valueOf(i2)});
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setBackgroundResource(i2);
        }
        return this;
    }

    public BricksThemeDialog g(CharSequence charSequence, int i2, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1056883266")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1056883266", new Object[]{this, charSequence, Integer.valueOf(i2), onClickListener});
        }
        if (this.i != null && !TextUtils.isEmpty(charSequence)) {
            this.i.setText(charSequence);
            if (i2 != 0) {
                this.i.setTextColor(i2);
            }
            this.i.setVisibility(0);
            this.m++;
            TextView textView = this.i;
            if (textView != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
        return this;
    }

    public BricksThemeDialog h(boolean z, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777389055")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-1777389055", new Object[]{this, Boolean.valueOf(z), onClickListener});
        }
        BricksIconFontTextView bricksIconFontTextView = this.j;
        if (bricksIconFontTextView == null) {
            return this;
        }
        if (z) {
            bricksIconFontTextView.setVisibility(0);
            this.j.setOnClickListener(new c(onClickListener));
        } else {
            bricksIconFontTextView.setVisibility(8);
        }
        return this;
    }

    public BricksThemeDialog i(CharSequence charSequence, int i2, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1974391154")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-1974391154", new Object[]{this, charSequence, Integer.valueOf(i2), onClickListener});
        }
        if (this.h != null && !TextUtils.isEmpty(charSequence)) {
            this.h.setText(charSequence);
            if (i2 != 0) {
                this.h.setTextColor(i2);
            }
            this.h.setVisibility(0);
            this.m++;
            this.h.setOnClickListener(new b(onClickListener));
        }
        return this;
    }

    public BricksThemeDialog j(SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1936617281")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1936617281", new Object[]{this, spannableString});
        }
        if (!(this.g == null || this.f == null || TextUtils.isEmpty(spannableString))) {
            this.f.setText(spannableString);
            this.g.setVisibility(0);
        }
        return this;
    }

    public BricksThemeDialog k(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657432252")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("657432252", new Object[]{this, Integer.valueOf(i2)});
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setGravity(i2);
        }
        return this;
    }

    public BricksThemeDialog l(SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084797818")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1084797818", new Object[]{this, spannableString});
        }
        if (spannableString != null) {
            this.e.setText(spannableString);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        return this;
    }

    public BricksThemeDialog m(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180054590")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1180054590", new Object[]{this, charSequence});
        }
        if (this.d != null && !TextUtils.isEmpty(charSequence)) {
            this.d.setText(charSequence);
            this.d.setVisibility(0);
        }
        return this;
    }

    public BricksThemeDialog n(@DrawableRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968497667")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-968497667", new Object[]{this, Integer.valueOf(i2)});
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
        return this;
    }

    public BricksThemeDialog o(@DrawableRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510711249")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-510711249", new Object[]{this, Integer.valueOf(i2)});
        }
        RoundImageView roundImageView = this.b;
        if (roundImageView != null) {
            roundImageView.setImageResource(i2);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746648865")) {
            ipChange.ipc$dispatch("746648865", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public BricksThemeDialog p(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001157330")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("2001157330", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        if (i2 > 0 && i3 > 0) {
            int i4 = (this.a * i3) / i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = this.a;
            layoutParams.height = i4;
            this.b.setLayoutParams(layoutParams);
        }
        return this;
    }

    public BricksThemeDialog q(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973694496")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("973694496", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        if (i2 > 0 && i3 > 0) {
            this.c.setLayoutParams(new FrameLayout.LayoutParams(this.a, (this.a * i3) / i2));
        }
        return this;
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891910353")) {
            ipChange.ipc$dispatch("1891910353", new Object[]{this});
            return;
        }
        super.show();
    }

    public BricksThemeDialog(@NonNull Context context, int i2) {
        super(context, i2);
        d();
    }
}
