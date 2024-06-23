package cn.damai.commonbusiness.wannasee.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.wannasee.adapter.StatePagerAdapter;
import cn.damai.commonbusiness.wannasee.bean.PageType;
import cn.damai.commonbusiness.wannasee.bean.WannaBean;
import cn.damai.commonbusiness.wannasee.listener.AdapterPageChangeListener;
import cn.damai.commonbusiness.wannasee.listener.OnWannaBeanListener;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.commonbusiness.wannasee.listener.RefreshCallBack;
import cn.damai.login.LoginManager;
import cn.damai.mine.activity.MineMainActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import tb.d20;
import tb.f81;
import tb.r3;
import tb.za;

/* compiled from: Taobao */
public class Wanna2SeeFragment extends Fragment implements PtrChildHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean isEnableDeleteItem;
    private boolean isFirst = true;
    public boolean isNeedLogin;
    private StatePagerAdapter mAdapter;
    private RadioButton mCompilationBtn;
    private int mLastCheckId = -1;
    private r3 mLoginListener = new a();
    private RadioButton mRecordBtn;
    private RadioButton mScriptBtn;
    private HorizontalScrollView mScrollView;
    private RadioButton mShowBtn;
    private RadioGroup mTabGroup;
    public String mUserId;
    public String mUtPageName;
    private RadioButton mValidShowBtn;
    private ViewPager mViewPager;
    private int tabIndex;

    /* compiled from: Taobao */
    public class a extends r3 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.login.havana.ILoginListener, tb.r3
        public void onLoginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1273236356")) {
                ipChange.ipc$dispatch("1273236356", new Object[]{this});
                return;
            }
            Wanna2SeeFragment wanna2SeeFragment = Wanna2SeeFragment.this;
            if (wanna2SeeFragment.isNeedLogin) {
                wanna2SeeFragment.showTabGroup(true);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnWannaBeanListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnWannaBeanListener
        public void onWannaBean(WannaBean wannaBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "212113291")) {
                ipChange.ipc$dispatch("212113291", new Object[]{this, wannaBean});
                return;
            }
            Wanna2SeeFragment.this.updateBtnText(wannaBean);
            Wanna2SeeFragment.this.autoScrollSelectTab();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void autoScrollSelectTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424092157")) {
            ipChange.ipc$dispatch("1424092157", new Object[]{this});
            return;
        }
        this.mTabGroup.post(new Runnable() {
            /* class cn.damai.commonbusiness.wannasee.fragment.Wanna2SeeFragment.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1585886206")) {
                    ipChange.ipc$dispatch("1585886206", new Object[]{this});
                    return;
                }
                int childCount = Wanna2SeeFragment.this.mTabGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = Wanna2SeeFragment.this.mTabGroup.getChildAt(i);
                    if ((childAt instanceof RadioButton) && ((RadioButton) childAt).isChecked()) {
                        int scrollX = Wanna2SeeFragment.this.mScrollView.getScrollX();
                        int width = Wanna2SeeFragment.this.mScrollView.getWidth();
                        int width2 = childAt.getWidth();
                        int left = childAt.getLeft() - scrollX;
                        int right = childAt.getRight() - scrollX;
                        if (width2 >= width) {
                            Wanna2SeeFragment.this.mScrollView.smoothScrollBy(left, 0);
                            return;
                        } else if (left < 0) {
                            Wanna2SeeFragment.this.mScrollView.smoothScrollBy(left, 0);
                            return;
                        } else if (right > width) {
                            Wanna2SeeFragment.this.mScrollView.smoothScrollBy(right - width, 0);
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
        });
    }

    private void exposeFavoriteTabs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841460818")) {
            ipChange.ipc$dispatch("841460818", new Object[]{this});
            return;
        }
        String str = this.mUtPageName;
        RadioButton radioButton = this.mShowBtn;
        PageType pageType = PageType.SHOW;
        f81.k(str, radioButton, pageType.tabName, pageType.tabIndex);
        String str2 = this.mUtPageName;
        RadioButton radioButton2 = this.mRecordBtn;
        PageType pageType2 = PageType.RECORD;
        f81.k(str2, radioButton2, pageType2.tabName, pageType2.tabIndex);
        String str3 = this.mUtPageName;
        RadioButton radioButton3 = this.mCompilationBtn;
        PageType pageType3 = PageType.COMPILATION;
        f81.k(str3, radioButton3, pageType3.tabName, pageType3.tabIndex);
        String str4 = this.mUtPageName;
        RadioButton radioButton4 = this.mScriptBtn;
        PageType pageType4 = PageType.SCRIPT;
        f81.k(str4, radioButton4, pageType4.tabName, pageType4.tabIndex);
        String str5 = this.mUtPageName;
        RadioButton radioButton5 = this.mValidShowBtn;
        PageType pageType5 = PageType.VALID_SHOW;
        f81.k(str5, radioButton5, pageType5.tabName, pageType5.tabIndex);
    }

    private PtrChildHandler findChildPtrHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204496223")) {
            return (PtrChildHandler) ipChange.ipc$dispatch("-204496223", new Object[]{this});
        }
        StatePagerAdapter statePagerAdapter = this.mAdapter;
        if (statePagerAdapter == null) {
            return null;
        }
        Fragment a2 = statePagerAdapter.a();
        if (a2 instanceof PtrChildHandler) {
            return (PtrChildHandler) a2;
        }
        return null;
    }

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399489402")) {
            ipChange.ipc$dispatch("1399489402", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.isEnableDeleteItem = arguments.getBoolean("isEnableDeleteItem", false);
            this.mUserId = arguments.getString("userId", "");
            this.mUtPageName = arguments.getString("utPageName", "live");
            this.isNeedLogin = arguments.getBoolean(MtopJSBridge.MtopJSParam.NEED_LOGIN, true);
            this.tabIndex = arguments.getInt(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX);
        }
    }

    public static Wanna2SeeFragment newInstance(boolean z, String str, String str2, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181435985")) {
            return (Wanna2SeeFragment) ipChange.ipc$dispatch("-1181435985", new Object[]{Boolean.valueOf(z), str, str2, Boolean.valueOf(z2)});
        }
        Wanna2SeeFragment wanna2SeeFragment = new Wanna2SeeFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isEnableDeleteItem", z);
        bundle.putString("userId", str);
        bundle.putString("utPageName", str2);
        bundle.putBoolean(MtopJSBridge.MtopJSParam.NEED_LOGIN, z2);
        wanna2SeeFragment.setArguments(bundle);
        return wanna2SeeFragment;
    }

    private void setCurrentItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455983805")) {
            ipChange.ipc$dispatch("455983805", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            switchFragment(R$id.valid_show_btn);
        } else if (i == 2) {
            switchFragment(R$id.script_btn);
        } else if (i == 3) {
            switchFragment(R$id.record_btn);
        } else if (i == 4) {
            switchFragment(R$id.compilation_btn);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showTabGroup(boolean z) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1816993003")) {
            ipChange.ipc$dispatch("1816993003", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RadioGroup radioGroup = this.mTabGroup;
        if (radioGroup != null) {
            if (!z) {
                i = 8;
            }
            radioGroup.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void switchFragment(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168878857")) {
            ipChange.ipc$dispatch("-168878857", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mLastCheckId != i) {
            this.mLastCheckId = i;
            if (!this.isFirst) {
                if (i == R$id.record_btn) {
                    f81 u = f81.u();
                    String str = this.mUtPageName;
                    PageType pageType = PageType.RECORD;
                    za.j(u.E(str, pageType.tabIndex, pageType.tabName));
                } else if (i == R$id.show_btn) {
                    f81 u2 = f81.u();
                    String str2 = this.mUtPageName;
                    PageType pageType2 = PageType.SHOW;
                    za.j(u2.E(str2, pageType2.tabIndex, pageType2.tabName));
                } else if (i == R$id.compilation_btn) {
                    f81 u3 = f81.u();
                    String str3 = this.mUtPageName;
                    PageType pageType3 = PageType.COMPILATION;
                    za.j(u3.E(str3, pageType3.tabIndex, pageType3.tabName));
                } else if (i == R$id.script_btn) {
                    f81 u4 = f81.u();
                    String str4 = this.mUtPageName;
                    PageType pageType4 = PageType.SCRIPT;
                    za.j(u4.E(str4, pageType4.tabIndex, pageType4.tabName));
                } else if (i == R$id.valid_show_btn) {
                    f81 u5 = f81.u();
                    String str5 = this.mUtPageName;
                    PageType pageType5 = PageType.VALID_SHOW;
                    za.j(u5.E(str5, pageType5.tabIndex, pageType5.tabName));
                }
            }
            this.isFirst = false;
            if (i == R$id.show_btn) {
                this.mViewPager.setCurrentItem(0);
            } else if (i == R$id.valid_show_btn) {
                this.mViewPager.setCurrentItem(1);
            } else if (i == R$id.script_btn) {
                this.mViewPager.setCurrentItem(2);
            } else if (i == R$id.record_btn) {
                this.mViewPager.setCurrentItem(3);
            } else if (i == R$id.compilation_btn) {
                this.mViewPager.setCurrentItem(4);
            }
            autoScrollSelectTab();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateBtnText(WannaBean wannaBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391896747")) {
            ipChange.ipc$dispatch("-391896747", new Object[]{this, wannaBean});
        } else if (wannaBean != null) {
            this.mShowBtn.setText(PageType.SHOW.getTabName(wannaBean.totalItem));
            this.mRecordBtn.setText(PageType.RECORD.getTabName(wannaBean.totalCard));
            this.mCompilationBtn.setText(PageType.COMPILATION.getTabName(wannaBean.totalRanking));
            this.mScriptBtn.setText(PageType.SCRIPT.getTabName(wannaBean.totalScriptInfo));
            this.mValidShowBtn.setText(PageType.VALID_SHOW.getTabName(wannaBean.totalPurchasableItem));
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1470248306")) {
            return ((Boolean) ipChange.ipc$dispatch("1470248306", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
        }
        PtrChildHandler findChildPtrHandler = findChildPtrHandler();
        if (findChildPtrHandler != null) {
            return findChildPtrHandler.checkCanDoRefresh(ptrFrameLayout, view, view2);
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148568481")) {
            ipChange.ipc$dispatch("-1148568481", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        LoginManager.k().c(this.mLoginListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1526352325")) {
            return layoutInflater.inflate(R$layout.fragment_wanna2_see, viewGroup, false);
        }
        return (View) ipChange.ipc$dispatch("1526352325", new Object[]{this, layoutInflater, viewGroup, bundle});
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516232543")) {
            ipChange.ipc$dispatch("1516232543", new Object[]{this});
            return;
        }
        super.onDestroy();
        LoginManager.k().C(this.mLoginListener);
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public void onRefreshBegin(PtrFrameLayout ptrFrameLayout, RefreshCallBack refreshCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561017331")) {
            ipChange.ipc$dispatch("1561017331", new Object[]{this, ptrFrameLayout, refreshCallBack});
            return;
        }
        PtrChildHandler findChildPtrHandler = findChildPtrHandler();
        if (findChildPtrHandler != null) {
            findChildPtrHandler.onRefreshBegin(ptrFrameLayout, refreshCallBack);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823081592")) {
            ipChange.ipc$dispatch("823081592", new Object[]{this, view, bundle});
            return;
        }
        getData();
        this.mScrollView = (HorizontalScrollView) view.findViewById(R$id.tab_group_scroll_view);
        this.mTabGroup = (RadioGroup) view.findViewById(R$id.tab_group);
        int i = R$id.show_btn;
        this.mShowBtn = (RadioButton) view.findViewById(i);
        this.mRecordBtn = (RadioButton) view.findViewById(R$id.record_btn);
        this.mCompilationBtn = (RadioButton) view.findViewById(R$id.compilation_btn);
        this.mScriptBtn = (RadioButton) view.findViewById(R$id.script_btn);
        this.mValidShowBtn = (RadioButton) view.findViewById(R$id.valid_show_btn);
        this.mViewPager = (ViewPager) view.findViewById(R$id.view_pager);
        ArrayList arrayList = new ArrayList();
        MultipleListFragment instance = MultipleListFragment.instance(PageType.SHOW);
        MultipleListFragment instance2 = MultipleListFragment.instance(PageType.VALID_SHOW);
        MultipleListFragment instance3 = MultipleListFragment.instance(PageType.SCRIPT);
        MultipleListFragment instance4 = MultipleListFragment.instance(PageType.RECORD);
        MultipleListFragment instance5 = MultipleListFragment.instance(PageType.COMPILATION);
        instance.setUtPageName(this.mUtPageName, this.mUserId, this.isEnableDeleteItem, this.isNeedLogin);
        instance2.setUtPageName(this.mUtPageName, this.mUserId, this.isEnableDeleteItem, this.isNeedLogin);
        instance4.setUtPageName(this.mUtPageName, this.mUserId, this.isEnableDeleteItem, this.isNeedLogin);
        instance5.setUtPageName(this.mUtPageName, this.mUserId, this.isEnableDeleteItem, this.isNeedLogin);
        instance3.setUtPageName(this.mUtPageName, this.mUserId, this.isEnableDeleteItem, this.isNeedLogin);
        b bVar = new b();
        instance.setListener(bVar);
        instance2.setListener(bVar);
        instance4.setListener(bVar);
        arrayList.add(instance);
        arrayList.add(instance2);
        arrayList.add(instance3);
        arrayList.add(instance4);
        arrayList.add(instance5);
        this.mViewPager.addOnPageChangeListener(new AdapterPageChangeListener() {
            /* class cn.damai.commonbusiness.wannasee.fragment.Wanna2SeeFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.wannasee.listener.AdapterPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1526144813")) {
                    ipChange.ipc$dispatch("1526144813", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                View childAt = Wanna2SeeFragment.this.mTabGroup.getChildAt(i);
                if (childAt instanceof RadioButton) {
                    ((RadioButton) childAt).setChecked(true);
                }
            }
        });
        StatePagerAdapter statePagerAdapter = new StatePagerAdapter(getChildFragmentManager(), arrayList);
        this.mAdapter = statePagerAdapter;
        this.mViewPager.setAdapter(statePagerAdapter);
        this.mTabGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class cn.damai.commonbusiness.wannasee.fragment.Wanna2SeeFragment.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "309050117")) {
                    ipChange.ipc$dispatch("309050117", new Object[]{this, radioGroup, Integer.valueOf(i)});
                    return;
                }
                Wanna2SeeFragment.this.switchFragment(i);
            }
        });
        this.mTabGroup.check(i);
        if (this.isNeedLogin) {
            showTabGroup(LoginManager.k().q());
        } else {
            showTabGroup(true);
        }
        int i2 = this.tabIndex;
        if (i2 > 0) {
            setCurrentItem(i2);
        }
        exposeFavoriteTabs();
    }

    public static Wanna2SeeFragment newInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "428532611") ? (Wanna2SeeFragment) ipChange.ipc$dispatch("428532611", new Object[0]) : newInstance(false, d20.i(), "live", true);
    }
}
