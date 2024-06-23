package cn.damai.commonbusiness.scriptmurder.coupon;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoPresent;
import com.alient.onearch.adapter.delegate.BasicDelegate;
import com.alient.onearch.adapter.event.StickyHeaderEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import tb.Cdo;
import tb.k21;

/* compiled from: Taobao */
public final class CouponHeaderDelegate extends BasicDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* renamed from: onReceiveStickyHeader$lambda-6$lambda-5  reason: not valid java name */
    public static final void m9onReceiveStickyHeader$lambda6$lambda5(INavStatusBarFeature iNavStatusBarFeature) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176588945")) {
            ipChange.ipc$dispatch("-176588945", new Object[]{iNavStatusBarFeature});
            return;
        }
        k21.i(iNavStatusBarFeature, "$this_apply");
        iNavStatusBarFeature.setLightStatusBarFontColor();
        iNavStatusBarFeature.setDarkStatusBarFontColor();
    }

    @Subscribe(eventType = {CouponInfoPresent.CHANGE_BAR_EVENT})
    public final void onReceiveChangeNavbar(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414378960")) {
            ipChange.ipc$dispatch("414378960", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        GenericFragment fragment = getFragment();
        Boolean bool = null;
        FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
        INavStatusBarFeature iNavStatusBarFeature = activity instanceof INavStatusBarFeature ? (INavStatusBarFeature) activity : null;
        if (iNavStatusBarFeature != null) {
            Object obj = event.data;
            HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
            Object obj2 = hashMap != null ? hashMap.get("bannerStatus") : null;
            String str = obj2 instanceof String ? (String) obj2 : null;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 48) {
                    if (hashCode != 49) {
                        if (hashCode == 1444 && str.equals("-1")) {
                            iNavStatusBarFeature.setNavBarColor(ColorUtil.parseColorSafely("#825542"));
                            iNavStatusBarFeature.setDarkStatusBarFontColor();
                        }
                    } else if (str.equals("1")) {
                        Object obj3 = event.data;
                        HashMap hashMap2 = obj3 instanceof HashMap ? (HashMap) obj3 : null;
                        Object obj4 = hashMap2 != null ? hashMap2.get("hasTopBanner") : null;
                        if (obj4 instanceof Boolean) {
                            bool = (Boolean) obj4;
                        }
                        if (bool != null) {
                            boolean booleanValue = bool.booleanValue();
                            iNavStatusBarFeature.setNavBarTitle("");
                            if (booleanValue) {
                                iNavStatusBarFeature.setNavBarColor(ColorUtil.parseColorSafely("#00000000"));
                                iNavStatusBarFeature.setLightStatusBarFontColor();
                                return;
                            }
                            iNavStatusBarFeature.setNavBarColor(ColorUtil.parseColorSafely("#825542"));
                            iNavStatusBarFeature.setLightStatusBarFontColor();
                        }
                    }
                } else if (str.equals("0")) {
                    Object obj5 = event.data;
                    HashMap hashMap3 = obj5 instanceof HashMap ? (HashMap) obj5 : null;
                    Object obj6 = hashMap3 != null ? hashMap3.get("hasTopBanner") : null;
                    if (obj6 instanceof Boolean) {
                        bool = (Boolean) obj6;
                    }
                    if (bool != null) {
                        bool.booleanValue();
                        iNavStatusBarFeature.setNavBarColor(ColorUtil.parseColorSafely("#FFFFFF"));
                        iNavStatusBarFeature.setDarkStatusBarFontColor();
                        iNavStatusBarFeature.setNavBarTitle("团购详情");
                    }
                }
            }
        }
    }

    @Subscribe(eventType = {"EventBus://business/notification/scriptMurder/get_header_info"})
    public final void onReceiveHeaderInfo(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749792587")) {
            ipChange.ipc$dispatch("749792587", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        Object obj = event.data;
        INavStatusBarFeature iNavStatusBarFeature = null;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap != null) {
            GenericFragment fragment = getFragment();
            FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
            if (activity instanceof INavStatusBarFeature) {
                iNavStatusBarFeature = (INavStatusBarFeature) activity;
            }
            if (iNavStatusBarFeature != null) {
                iNavStatusBarFeature.onHeaderInfoUpdate(hashMap);
            }
        }
    }

    @Subscribe(eventType = {StickyHeaderEvent.ON_STICKY})
    public final void onReceiveStickyHeader(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140415046")) {
            ipChange.ipc$dispatch("1140415046", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        GenericFragment fragment = getFragment();
        INavStatusBarFeature iNavStatusBarFeature = null;
        FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
        if (activity instanceof INavStatusBarFeature) {
            iNavStatusBarFeature = (INavStatusBarFeature) activity;
        }
        if (iNavStatusBarFeature != null) {
            iNavStatusBarFeature.setNavBarColor(ColorUtil.parseColorSafely("#FFFFFF"));
            new Handler().postDelayed(new Cdo(iNavStatusBarFeature), 25);
        }
    }
}
