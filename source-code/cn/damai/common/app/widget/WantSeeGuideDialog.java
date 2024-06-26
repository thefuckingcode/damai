package cn.damai.common.app.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import cn.damai.uikit.util.TDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class WantSeeGuideDialog extends TDialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private Listener h;
    LottieAnimationView i;
    TextView j;
    TextView k;
    TextView l;
    View m;

    /* compiled from: Taobao */
    public interface Listener {
        void onCloseBtnClick();

        void onWantSeeBtnClick();
    }

    /* compiled from: Taobao */
    public interface WantGuidePageSource {
        String getButtonName();

        String getSubTitle();

        String getTitle();

        String lottieUrl();

        String schema();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1496928464")) {
                ipChange.ipc$dispatch("1496928464", new Object[]{this, view});
                return;
            }
            WantSeeGuideDialog.this.dismiss();
            if (WantSeeGuideDialog.this.h != null) {
                WantSeeGuideDialog.this.h.onCloseBtnClick();
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
            if (AndroidInstantRuntime.support(ipChange, "-686748463")) {
                ipChange.ipc$dispatch("-686748463", new Object[]{this, view});
                return;
            }
            WantSeeGuideDialog.this.dismiss();
            if (WantSeeGuideDialog.this.h != null) {
                WantSeeGuideDialog.this.h.onWantSeeBtnClick();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements LottieListener<Throwable> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void onResult(Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1417442416")) {
                ipChange.ipc$dispatch("-1417442416", new Object[]{this, th});
                return;
            }
            WantSeeGuideDialog.this.i.setAnimation("wantseeguidelottie.zip");
        }
    }

    public WantSeeGuideDialog(@NonNull Context context, Listener listener) {
        super(context, R$style.translucent_dialog_style);
        j(context);
        this.h = listener;
        this.i.setAnimation("wantseeguidelottie.zip");
        k();
    }

    private void j(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254602379")) {
            ipChange.ipc$dispatch("254602379", new Object[]{this, context});
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_want_see_pop, (ViewGroup) null);
        setContentView(inflate);
        setCanceledOnTouchOutside(false);
        this.i = (LottieAnimationView) inflate.findViewById(R$id.id_dialog_want_lottie);
        this.j = (TextView) inflate.findViewById(R$id.id_dialog_want_btn_tv);
        this.k = (TextView) inflate.findViewById(R$id.id_dialog_want_btn_title);
        this.l = (TextView) inflate.findViewById(R$id.id_dialog_want_btn_subtitle);
        this.m = inflate.findViewById(R$id.id_dialog_want_close_btn);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225155803")) {
            ipChange.ipc$dispatch("-1225155803", new Object[]{this});
            return;
        }
        this.m.setOnClickListener(new a());
        this.j.setOnClickListener(new b());
    }

    public WantSeeGuideDialog(@NonNull Context context, Listener listener, WantGuidePageSource wantGuidePageSource) {
        super(context, R$style.translucent_dialog_style);
        j(context);
        this.h = listener;
        if (wantGuidePageSource != null) {
            if (!TextUtils.isEmpty(wantGuidePageSource.lottieUrl())) {
                String lottieUrl = wantGuidePageSource.lottieUrl();
                this.i.setFailureListener(new c());
                this.i.setAnimationFromUrl(lottieUrl);
            } else {
                this.i.setAnimation("wantseeguidelottie.zip");
            }
            if (!TextUtils.isEmpty(wantGuidePageSource.getTitle())) {
                this.k.setText(wantGuidePageSource.getTitle());
            }
            if (!TextUtils.isEmpty(wantGuidePageSource.getSubTitle())) {
                this.l.setText(wantGuidePageSource.getSubTitle());
            }
            if (!TextUtils.isEmpty(wantGuidePageSource.getButtonName())) {
                this.j.setText(wantGuidePageSource.getButtonName());
            }
        } else {
            this.i.setAnimation("wantseeguidelottie.zip");
        }
        k();
    }
}
