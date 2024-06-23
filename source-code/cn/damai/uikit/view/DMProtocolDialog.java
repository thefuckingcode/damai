package cn.damai.uikit.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import com.alipay.sdk.m.u.n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.aa0;
import tb.ir;
import tb.jr;
import tb.up2;

/* compiled from: Taobao */
public class DMProtocolDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView a;
    private LinearLayout b;
    private DMProtocolDialogTextItemView c;
    private DMProtocolDialogTextItemView d;
    private DMProtocolDialogTextItemView e;
    private DMProtocolDialogTextItemView f;
    private FrameLayout g;
    private FrameLayout h;
    private OnClickListener i;
    private OnDialogShowTimeListener j;
    public long k;
    public long l;

    /* compiled from: Taobao */
    public enum DMDialogTheme {
        THEME_DNA
    }

    /* compiled from: Taobao */
    public interface OnClickListener {
        void onClickNegative();

        void onClickPositive(DialogInterface dialogInterface, boolean z);

        void onProtocolClick(String str);
    }

    /* compiled from: Taobao */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1902932289")) {
                ipChange.ipc$dispatch("1902932289", new Object[]{this});
            } else if (DMProtocolDialog.this.c.getDataLine() == 2) {
                DMProtocolDialog.this.f.setVisibility(8);
            } else if (DMProtocolDialog.this.d.getDataLine() == 2 || DMProtocolDialog.this.e.getDataLine() == 2 || DMProtocolDialog.this.f.getDataLine() == 2) {
                DMProtocolDialog.this.c.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "469228255")) {
                ipChange.ipc$dispatch("469228255", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(DMProtocolDialog.this.c.getProtocolLink())) {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.c.getProtocolLink());
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714448672")) {
                ipChange.ipc$dispatch("-1714448672", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(DMProtocolDialog.this.d.getProtocolLink())) {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.d.getProtocolLink());
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "396841697")) {
                ipChange.ipc$dispatch("396841697", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(DMProtocolDialog.this.e.getProtocolLink())) {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.e.getProtocolLink());
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1786835230")) {
                ipChange.ipc$dispatch("-1786835230", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(DMProtocolDialog.this.f.getProtocolLink())) {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.f.getProtocolLink());
            }
        }
    }

    public DMProtocolDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private boolean h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864451189")) {
            return ((Boolean) ipChange.ipc$dispatch("1864451189", new Object[]{this})).booleanValue();
        } else if (this.c.getIsCheck() != null && !this.c.getIsCheck().booleanValue()) {
            return false;
        } else {
            if (this.d.getIsCheck() != null && !this.d.getIsCheck().booleanValue()) {
                return false;
            }
            if (this.e.getIsCheck() != null && !this.e.getIsCheck().booleanValue()) {
                return false;
            }
            if (this.f.getIsCheck() == null || this.f.getIsCheck().booleanValue()) {
                return true;
            }
            return false;
        }
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362454293")) {
            ipChange.ipc$dispatch("-362454293", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.damai_protocol_dialog, (ViewGroup) null);
        MaxHeightLinearLayout maxHeightLinearLayout = (MaxHeightLinearLayout) inflate.findViewById(R$id.damai_protocol_dialog_layout);
        int c2 = up2.c(getContext(), maxHeightLinearLayout.getMaxHeight(), 50, n.g, GridBean.TYPE_PIC_URL);
        this.a = (ImageView) inflate.findViewById(R$id.iv_background);
        int i2 = (c2 * n.g) / GridBean.TYPE_PIC_URL;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) maxHeightLinearLayout.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = i2;
        layoutParams2.width = c2;
        layoutParams2.height = i2;
        this.a.setLayoutParams(layoutParams2);
        maxHeightLinearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.fl_cancel_btn);
        this.h = frameLayout;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        double d2 = (double) i2;
        double d3 = 0.1087d * d2;
        layoutParams3.height = Double.valueOf(d3).intValue();
        this.h.setLayoutParams(layoutParams3);
        FrameLayout frameLayout2 = (FrameLayout) inflate.findViewById(R$id.fl_ok_btn);
        this.g = frameLayout2;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) frameLayout2.getLayoutParams();
        layoutParams4.height = Double.valueOf(d3).intValue();
        this.g.setLayoutParams(layoutParams4);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ll_text_content);
        this.b = linearLayout;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams5.height = Double.valueOf(d2 * 0.2174d).intValue();
        this.b.setLayoutParams(layoutParams5);
        this.c = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips1);
        this.d = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips2);
        this.e = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips3);
        this.f = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips4);
        setContentView(inflate);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(OnClickListener onClickListener, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44628376")) {
            ipChange.ipc$dispatch("44628376", new Object[]{this, onClickListener, view});
        } else if (onClickListener != null) {
            onClickListener.onClickPositive(this, h());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(OnClickListener onClickListener, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58161177")) {
            ipChange.ipc$dispatch("58161177", new Object[]{this, onClickListener, view});
        } else if (onClickListener != null) {
            onClickListener.onClickNegative();
            dismiss();
        }
    }

    private DMProtocolDialog l(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474765908")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-1474765908", new Object[]{this, Integer.valueOf(i2)});
        }
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
        return this;
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "25324512")) {
            ipChange.ipc$dispatch("25324512", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
            long currentTimeMillis = System.currentTimeMillis();
            this.l = currentTimeMillis;
            OnDialogShowTimeListener onDialogShowTimeListener = this.j;
            if (onDialogShowTimeListener != null) {
                onDialogShowTimeListener.exposureTime(currentTimeMillis - this.k);
            }
        }
    }

    public DMProtocolDialog m(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418204257")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("1418204257", new Object[]{this, bitmap});
        }
        ImageView imageView = this.a;
        if (!(imageView == null || bitmap == null)) {
            imageView.setImageBitmap(bitmap);
        }
        return this;
    }

    public DMProtocolDialog n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868731924")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-1868731924", new Object[]{this, Boolean.valueOf(z)});
        }
        setCancelable(z);
        setCanceledOnTouchOutside(z);
        return this;
    }

    public DMProtocolDialog o(List<aa0> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726604750")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-726604750", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 4 - list.size(); i2++) {
            arrayList.add(new aa0());
        }
        arrayList.addAll(list);
        aa0 aa0 = (aa0) arrayList.get(0);
        this.c.setData(aa0.a(), aa0.b(), aa0.f(), aa0.e(), aa0.c(), aa0.d());
        aa0 aa02 = (aa0) arrayList.get(1);
        this.d.setData(aa02.a(), aa02.b(), aa02.f(), aa02.e(), aa02.c(), aa02.d());
        aa0 aa03 = (aa0) arrayList.get(2);
        this.e.setData(aa03.a(), aa03.b(), aa03.f(), aa03.e(), aa03.c(), aa03.d());
        aa0 aa04 = (aa0) arrayList.get(3);
        this.f.setData(aa04.a(), aa04.b(), aa04.f(), aa04.e(), aa04.c(), aa04.d());
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-126523537")) {
            ipChange.ipc$dispatch("-126523537", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public DMProtocolDialog p(OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727810463")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-1727810463", new Object[]{this, onClickListener});
        }
        this.i = onClickListener;
        FrameLayout frameLayout = this.g;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new jr(this, onClickListener));
        }
        FrameLayout frameLayout2 = this.h;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new ir(this, onClickListener));
        }
        if (this.c.getIsCheck() != null) {
            this.c.setProtocolClick(new b());
        }
        if (this.d.getIsCheck() != null) {
            this.d.setProtocolClick(new c());
        }
        if (this.e.getIsCheck() != null) {
            this.e.setProtocolClick(new d());
        }
        if (this.f.getIsCheck() != null) {
            this.f.setProtocolClick(new e());
        }
        return this;
    }

    public void q(OnDialogShowTimeListener onDialogShowTimeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749239798")) {
            ipChange.ipc$dispatch("749239798", new Object[]{this, onDialogShowTimeListener});
            return;
        }
        this.j = onDialogShowTimeListener;
    }

    public DMProtocolDialog r(DMDialogTheme dMDialogTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352032629")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-352032629", new Object[]{this, dMDialogTheme});
        }
        int i2 = R$drawable.damai_protocol_dialog_dna;
        DMDialogTheme dMDialogTheme2 = DMDialogTheme.THEME_DNA;
        l(i2);
        return this;
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433587779")) {
            ipChange.ipc$dispatch("1433587779", new Object[]{this});
            return;
        }
        super.show();
        this.k = System.currentTimeMillis();
    }

    public DMProtocolDialog(@NonNull Context context, int i2) {
        super(context, i2);
        i();
    }
}
