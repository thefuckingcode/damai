package cn.damai.commonbusiness.scriptmurder.venuedetail;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.share.ShareManager;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.bean.VenueInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class VenueDetailActivity extends CommonNavbarActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private VenueInfoBean venueInfoBean;

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851424792")) {
            ipChange.ipc$dispatch("1851424792", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Drawable drawable = null;
        String stringExtra = intent != null ? intent.getStringExtra(VenueDetailFragment.VENUE_ID) : null;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.container;
        VenueDetailFragment venueDetailFragment = new VenueDetailFragment();
        Bundle bundle = new Bundle();
        if (stringExtra != null) {
            bundle.putString(VenueDetailFragment.VENUE_ID, stringExtra);
        }
        venueDetailFragment.setArguments(bundle);
        ur2 ur2 = ur2.INSTANCE;
        beginTransaction.add(i, venueDetailFragment);
        beginTransaction.commit();
        View findViewById = findViewById(R$id.nav_bar);
        if (findViewById != null) {
            Resources resources = getResources();
            if (resources != null) {
                drawable = resources.getDrawable(R$drawable.venue_top_nav_default_bg);
            }
            findViewById.setBackground(drawable);
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addUtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302916250")) {
            ipChange.ipc$dispatch("1302916250", new Object[]{this});
            return;
        }
        setDamaiUTKeyBuilder(new a.b().i("venue_new").a(d20.d()));
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void initBaseInfo(@NotNull Object obj) {
        Object obj2;
        String bid;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813095346")) {
            ipChange.ipc$dispatch("-813095346", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        VenueInfoBean venueInfoBean2 = null;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap != null && (obj2 = hashMap.get("value")) != null) {
            if (obj2 instanceof VenueInfoBean) {
                venueInfoBean2 = (VenueInfoBean) obj2;
            }
            this.venueInfoBean = venueInfoBean2;
            if (venueInfoBean2 != null && (bid = venueInfoBean2.getBid()) != null) {
                initAttentionView(bid, venueInfoBean2.getFavoriteFlag(), "3");
            }
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void onShareClick() {
        ShareInfoBean share;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743676807")) {
            ipChange.ipc$dispatch("-743676807", new Object[]{this});
            return;
        }
        VenueInfoBean venueInfoBean2 = this.venueInfoBean;
        if (venueInfoBean2 != null) {
            k21.f(venueInfoBean2);
            if (venueInfoBean2.getShare() != null) {
                Bundle bundle = new Bundle();
                VenueInfoBean venueInfoBean3 = this.venueInfoBean;
                if (!(venueInfoBean3 == null || (share = venueInfoBean3.getShare()) == null)) {
                    bundle.putString("title", share.getShareTitle());
                    bundle.putString("message", share.getShareSubTitle());
                    bundle.putString("imageurl", share.getShareImage());
                    bundle.putString("producturl", share.getShareUrl());
                }
                ShareManager.E().T(this, bundle, getWindow().getDecorView());
                ShareManager.E().l0();
            }
        }
    }
}
