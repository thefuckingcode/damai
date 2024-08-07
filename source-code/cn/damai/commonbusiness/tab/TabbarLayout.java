package cn.damai.commonbusiness.tab;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.n42;
import tb.ri2;
import tb.v50;
import tb.xs0;

/* compiled from: Taobao */
public class TabbarLayout extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAB_CHANGE_KEYWORD = "tabchange";
    private static HashMap<String, Boolean> clickTag = new HashMap<>();
    private static ImageLoader sImageLoader;
    private ITabView mCurentTabView;
    private String mCurrentTab;
    private TabItem mCurrentTabItem;
    private FrameLayout mPopViewsContainer;
    public ImageView mTabBackImg;
    private TabBarListener mTabBarListener;
    private List<TabItem> mTabItems;
    private ri2 mTabViewFactory;
    private List<ITabView> mTabViews;
    private LinearLayout mTabViewsContainer;
    private View mTopLineView;

    /* compiled from: Taobao */
    public enum BadgeType {
        POINT,
        TEXT,
        NONE
    }

    /* compiled from: Taobao */
    public interface TabBarListener {
        void onTabClicked(TabItem tabItem);

        void onTabLongClicked(TabItem tabItem);

        void onTabReselected(TabItem tabItem);

        void onTabSelected(TabItem tabItem);
    }

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(TabbarLayout tabbarLayout) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-13488016")) {
                ipChange.ipc$dispatch("-13488016", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1314124283")) {
                ipChange.ipc$dispatch("-1314124283", new Object[]{this, eVar});
                return;
            }
            TabbarLayout.this.mTabBackImg.setImageDrawable(eVar.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TabItem a;

        c(TabItem tabItem) {
            this.a = tabItem;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1307971649")) {
                ipChange.ipc$dispatch("1307971649", new Object[]{this, view});
            } else if (TabbarLayout.this.mTabBarListener == null) {
            } else {
                if (TextUtils.equals(this.a.tab, TabbarLayout.this.mCurrentTab)) {
                    TabbarLayout.this.mTabBarListener.onTabReselected(this.a);
                    return;
                }
                TabbarLayout.this.popHide(this.a);
                TabbarLayout.this.mTabBarListener.onTabClicked(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TabItem a;

        d(TabItem tabItem) {
            this.a = tabItem;
        }

        public boolean onLongClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-873219670")) {
                return ((Boolean) ipChange.ipc$dispatch("-873219670", new Object[]{this, view})).booleanValue();
            } else if (TabbarLayout.this.mTabBarListener == null) {
                return false;
            } else {
                TabbarLayout.this.mTabBarListener.onTabLongClicked(this.a);
                return true;
            }
        }
    }

    public TabbarLayout(@NonNull Context context) {
        this(context, null);
    }

    public static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1802966268")) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("1802966268", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    private void drawTabPopView(TabItem tabItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351440258")) {
            ipChange.ipc$dispatch("1351440258", new Object[]{this, tabItem, Integer.valueOf(i)});
        } else if (tabItem != null && !TextUtils.isEmpty(tabItem.popText) && tabItem.popPosition > -1) {
            if (!clickTag.containsKey(tabItem.type) || !clickTag.get(tabItem.type).booleanValue()) {
                View inflate = LayoutInflater.from(getContext()).inflate(R$layout.home_tab_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_homepage_tab_top_right);
                int i2 = DisplayMetrics.getwidthPixels(v50.b(getContext())) / i;
                textView.setText(tabItem.popText);
                if (tabItem.popPosition == DamaiTabViewHelper.g - 1) {
                    textView.setMaxWidth(v50.a(getContext(), (float) (i2 / 2)));
                } else {
                    textView.setMaxWidth(v50.a(getContext(), 46.0f));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins((tabItem.popPosition * i2) + (i2 / 2) + v50.a(getContext(), 4.0f), 0, 0, 0);
                this.mPopViewsContainer.addView(inflate, layoutParams);
                clickTag.put(tabItem.type, Boolean.FALSE);
            }
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401307984")) {
            ipChange.ipc$dispatch("-401307984", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.mTabViewsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.mTabViewsContainer.setGravity(80);
        int a2 = n42.a(xs0.a(), 60.0f);
        ImageView imageView = new ImageView(getContext());
        this.mTabBackImg = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.mTabBackImg, new RelativeLayout.LayoutParams(-1, a2));
        addView(this.mTabViewsContainer, new RelativeLayout.LayoutParams(-1, -2));
        View view = new View(getContext());
        this.mTopLineView = view;
        view.setBackground(new ColorDrawable(Color.parseColor("#eeeeee")));
        addView(this.mTopLineView, new RelativeLayout.LayoutParams(-1, n42.a(xs0.a(), 0.5f)));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mPopViewsContainer = frameLayout;
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -2));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void popHide(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993849893")) {
            ipChange.ipc$dispatch("993849893", new Object[]{this, tabItem});
            return;
        }
        if (clickTag.containsKey(tabItem.type)) {
            clickTag.put(tabItem.type, Boolean.TRUE);
        }
        invalidatePopView();
    }

    private void resetTabbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732658403")) {
            ipChange.ipc$dispatch("-732658403", new Object[]{this});
            return;
        }
        this.mTabItems.clear();
        this.mTabViewsContainer.removeAllViews();
        this.mTabViews.clear();
    }

    private void setUpOne(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436512837")) {
            ipChange.ipc$dispatch("1436512837", new Object[]{this, tabItem});
            return;
        }
        ITabView a2 = this.mTabViewFactory.a(getContext(), tabItem);
        tabItem.tabView = a2;
        a2.setUpTabItem(tabItem, this.mCurrentTab);
        this.mTabViewsContainer.addView(a2.getTabView(), new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.mTabViews.add(a2);
        if (TextUtils.equals(tabItem.tab, this.mCurrentTab)) {
            this.mCurrentTabItem = tabItem;
            this.mCurentTabView = a2;
        }
        a2.getClickView().setOnClickListener(new c(tabItem));
        a2.getClickView().setOnLongClickListener(new d(tabItem));
        drawTabPopView(tabItem, this.mTabItems.size());
    }

    public View getContainerLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2009086707")) {
            return this.mTabViewsContainer;
        }
        return (View) ipChange.ipc$dispatch("-2009086707", new Object[]{this});
    }

    public List<ITabView> getTabViews() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1269508660")) {
            return this.mTabViews;
        }
        return (List) ipChange.ipc$dispatch("-1269508660", new Object[]{this});
    }

    public void invalidatePopView() {
        List<TabItem> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516170319")) {
            ipChange.ipc$dispatch("516170319", new Object[]{this});
            return;
        }
        this.mPopViewsContainer.removeAllViews();
        if (!(this.mPopViewsContainer == null || (list = this.mTabItems) == null || list.size() <= 0)) {
            for (int i = 0; i < this.mTabItems.size(); i++) {
                drawTabPopView(this.mTabItems.get(i), this.mTabItems.size());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r5 = r4.mTabBarListener;
     */
    public void onActivityIntent(Uri uri) {
        final TabBarListener tabBarListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766509743")) {
            ipChange.ipc$dispatch("-766509743", new Object[]{this, uri});
        } else if (uri != null) {
            try {
                if (uri.toString().contains(TAB_CHANGE_KEYWORD) && tabBarListener != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class cn.damai.commonbusiness.tab.TabbarLayout.AnonymousClass3 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-2106362000")) {
                                ipChange.ipc$dispatch("-2106362000", new Object[]{this});
                                return;
                            }
                            TabItem tabItem = TabbarLayout.this.mCurrentTabItem;
                            if (tabItem != null) {
                                tabBarListener.onTabSelected(tabItem);
                            }
                            ITabView iTabView = TabbarLayout.this.mCurentTabView;
                            if (iTabView != null) {
                                iTabView.onTabSelected();
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                Log.w("TabbarLayout", th);
            }
        }
    }

    public void selectCurrentTab(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532120942")) {
            ipChange.ipc$dispatch("-1532120942", new Object[]{this, str});
            return;
        }
        setCurrentTab(str);
        for (int i = 0; i < this.mTabItems.size(); i++) {
            TabItem tabItem = this.mTabItems.get(i);
            if (i < this.mTabViews.size()) {
                this.mTabViews.get(i).setUpTabItem(tabItem, this.mCurrentTab);
            }
        }
    }

    public void setBadge(String str, BadgeType badgeType, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304016862")) {
            ipChange.ipc$dispatch("304016862", new Object[]{this, str, badgeType, str2});
            return;
        }
        for (ITabView iTabView : new ArrayList(this.mTabViews)) {
            if (iTabView != null && TextUtils.equals(str, iTabView.getTab())) {
                iTabView.setBadge(badgeType, str2);
            }
        }
    }

    public void setCurrentTab(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223422006")) {
            ipChange.ipc$dispatch("223422006", new Object[]{this, str});
            return;
        }
        this.mCurrentTab = str;
    }

    public void setTabBackGroundPic(@Nullable String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1192034197")) {
            ipChange.ipc$dispatch("-1192034197", new Object[]{this, str});
            return;
        }
        ImageView imageView = this.mTabBackImg;
        if (imageView != null) {
            imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#FBFBFB")));
            boolean isEmpty = TextUtils.isEmpty(str);
            View view = this.mTopLineView;
            if (!isEmpty) {
                i = 8;
            }
            view.setVisibility(i);
            if (!isEmpty) {
                int a2 = n42.a(xs0.a(), 60.0f);
                cn.damai.common.image.a.b().f(str, DisplayMetrics.getwidthPixels(n42.b(xs0.a())), a2).n(new b()).e(new a(this)).f();
            }
        }
    }

    public void setTabBarListener(TabBarListener tabBarListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744866208")) {
            ipChange.ipc$dispatch("744866208", new Object[]{this, tabBarListener});
            return;
        }
        this.mTabBarListener = tabBarListener;
    }

    public void setTabViewFactory(ri2 ri2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193971956")) {
            ipChange.ipc$dispatch("193971956", new Object[]{this, ri2});
        } else if (ri2 != null) {
            this.mTabViewFactory = ri2;
        }
    }

    public void setUp(List<TabItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322415550")) {
            ipChange.ipc$dispatch("1322415550", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            resetTabbar();
            this.mTabItems.addAll(list);
            for (int i = 0; i < this.mTabItems.size(); i++) {
                setUpOne(this.mTabItems.get(i));
            }
        }
    }

    public TabbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mTabItems = new ArrayList();
        this.mTabViews = new ArrayList();
        this.mTabViewFactory = new ri2();
        init();
    }
}
