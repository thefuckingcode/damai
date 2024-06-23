package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.mine.userinfo.bean.UserBanner;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class be1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FrameLayout b;
    private RoundImageView c;
    private int d = 50;
    private int e = 350;
    private int f;
    private int g;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1074427369")) {
                ipChange.ipc$dispatch("1074427369", new Object[]{this, dVar});
                return;
            }
            be1.this.h();
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-11627330")) {
                ipChange.ipc$dispatch("-11627330", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
                be1.this.h();
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = eVar.a.getIntrinsicHeight();
                be1 be1 = be1.this;
                be1.g = (int) ((((float) (intrinsicHeight * be1.f)) * 1.0f) / ((float) intrinsicWidth));
                be1.this.c.getLayoutParams().width = be1.this.f;
                be1.this.c.getLayoutParams().height = be1.this.g;
                be1.this.c.setImageDrawable(eVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserBanner a;

        c(UserBanner userBanner) {
            this.a = userBanner;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1982814521")) {
                ipChange.ipc$dispatch("1982814521", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(this.a.url)) {
                cn.damai.common.user.c.e().x(yd1.x().K());
                DMNav.from(be1.this.a).toUri(this.a.url);
            }
        }
    }

    public be1(Context context, View view) {
        this.a = context;
        this.b = (FrameLayout) view.findViewById(R$id.ll_mine_olympic);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.iv_olympic);
        this.c = roundImageView;
        roundImageView.setType(1);
        this.c.setBorderRadius(12);
        this.f = DisplayMetrics.getwidthPixels(n42.b(context)) - n42.a(context, 24.0f);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1701475339")) {
            ipChange.ipc$dispatch("1701475339", new Object[]{this});
            return;
        }
        this.c.setImageResource(R$drawable.bg_olympic_banner);
        this.g = (int) ((((float) (this.d * this.f)) * 1.0f) / ((float) this.e));
        this.c.getLayoutParams().width = this.f;
        this.c.getLayoutParams().height = this.g;
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749974435")) {
            ipChange.ipc$dispatch("1749974435", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void i(UserBanner userBanner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722259818")) {
            ipChange.ipc$dispatch("722259818", new Object[]{this, userBanner});
        } else if (userBanner == null || TextUtils.isEmpty(userBanner.bannerPic)) {
            this.b.setVisibility(8);
        } else {
            DMImageCreator e2 = cn.damai.common.image.a.b().e(userBanner.bannerPic);
            int i = R$drawable.bg_olympic_banner;
            e2.i(i).c(i).n(new b()).e(new a()).f();
            this.b.setVisibility(0);
            yd1.x().L(this.b);
            this.c.setOnClickListener(new c(userBanner));
        }
    }
}
