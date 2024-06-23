package tb;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.homepage.ui.fragment.HomeFragmentAgent;
import cn.damai.homepage.ui.fragment.HomeTabFragment;
import cn.damai.homepage.v2.HomePageFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class lw0 implements HomeFragmentAgent {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final HomePageFragment a;

    public lw0(@NotNull HomePageFragment homePageFragment) {
        k21.i(homePageFragment, "newHome");
        this.a = homePageFragment;
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    @NotNull
    public Fragment getCurFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2060067175")) {
            return this.a;
        }
        return (Fragment) ipChange.ipc$dispatch("-2060067175", new Object[]{this});
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public int getCurIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "113915302")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("113915302", new Object[]{this})).intValue();
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void logoutRefreshUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216358198")) {
            ipChange.ipc$dispatch("216358198", new Object[]{this});
            return;
        }
        this.a.logoutRefreshUI();
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshAllFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156865689")) {
            ipChange.ipc$dispatch("156865689", new Object[]{this});
            return;
        }
        this.a.refreshAllFragment();
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshHomeFragment(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808927389")) {
            ipChange.ipc$dispatch("-808927389", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.a.refreshHomeFragment(z);
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToRecommend() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305823705")) {
            ipChange.ipc$dispatch("-1305823705", new Object[]{this});
            return;
        }
        this.a.scrollToRecommend();
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927703698")) {
            ipChange.ipc$dispatch("-927703698", new Object[]{this});
            return;
        }
        this.a.scrollToTop();
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    @NotNull
    public Fragment self() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1445715605")) {
            return this.a;
        }
        return (Fragment) ipChange.ipc$dispatch("-1445715605", new Object[]{this});
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public void setArguments(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955239801")) {
            ipChange.ipc$dispatch("1955239801", new Object[]{this, bundle});
            return;
        }
        this.a.setArguments(bundle);
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public void setOnTabClickListener(@Nullable HomeTabFragment.OnTabClickListener onTabClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779112340")) {
            ipChange.ipc$dispatch("1779112340", new Object[]{this, onTabClickListener});
        }
    }

    @Override // cn.damai.homepage.ui.fragment.HomeFragmentAgent
    public void setSelectTab(@Nullable TabExtra tabExtra) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851725621")) {
            ipChange.ipc$dispatch("1851725621", new Object[]{this, tabExtra});
        }
    }
}
