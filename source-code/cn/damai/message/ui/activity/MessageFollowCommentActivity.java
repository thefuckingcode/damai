package cn.damai.message.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.message.ui.adapter.MessageListMainAdapter;
import cn.damai.message.ui.fragment.MessageCommentFragment;
import cn.damai.message.ui.fragment.MessageFollowFragment;
import cn.damai.uikit.indicator.PagerIndicator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.br;
import tb.d20;
import tb.wc1;
import tb.yp;

/* compiled from: Taobao */
public class MessageFollowCommentActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private String DM_MSGBOX_ATTENTION = "DM_MSGBOX_ATTENTION";
    private String DM_MSGBOX_REPLY = "DM_MSGBOX_REPLY";
    private MessageCommentFragment commentFragment;
    private MessageFollowFragment followFragment;
    private List<Fragment> fragments;
    private DMBadgeListener listenerBadge = new b();
    private MessageListMainAdapter mainAdapter;
    private yp manager;
    private PagerIndicator pagerIndicator;
    List<String> rootNodes = new ArrayList() {
        /* class cn.damai.message.ui.activity.MessageFollowCommentActivity.AnonymousClass1 */

        {
            add(MessageFollowCommentActivity.this.DM_MSGBOX_ATTENTION);
            add(MessageFollowCommentActivity.this.DM_MSGBOX_REPLY);
        }
    };
    private String type;
    private ViewPager viewPager;

    /* compiled from: Taobao */
    public class a implements PagerIndicator.TabViewFactory {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.indicator.PagerIndicator.TabViewFactory
        public void addTabs(ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "657870850")) {
                ipChange.ipc$dispatch("657870850", new Object[]{this, viewGroup, Integer.valueOf(i)});
                return;
            }
            viewGroup.removeAllViews();
            LayoutInflater from = LayoutInflater.from(MessageFollowCommentActivity.this);
            int i2 = R$layout.message_follow_comment_tab;
            View inflate = from.inflate(i2, viewGroup, false);
            int i3 = R$id.tabName;
            ((TextView) inflate.findViewById(i3)).setText("关注我的");
            viewGroup.addView(inflate);
            View inflate2 = LayoutInflater.from(MessageFollowCommentActivity.this).inflate(i2, viewGroup, false);
            ((TextView) inflate2.findViewById(i3)).setText("回复我的");
            viewGroup.addView(inflate2);
        }
    }

    /* compiled from: Taobao */
    public class b implements DMBadgeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeChanged(String str, BadgeNodeItem badgeNodeItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2020543003")) {
                ipChange.ipc$dispatch("-2020543003", new Object[]{this, str, badgeNodeItem});
                return;
            }
            Log.d("wxq", "nodeId:" + str);
            Log.d("wxq", "badgeNodeItem:" + badgeNodeItem.toString());
            if (str.equals(MessageFollowCommentActivity.this.DM_MSGBOX_ATTENTION)) {
                if (MessageFollowCommentActivity.this.followFragment != null) {
                    MessageFollowCommentActivity.this.followFragment.updateTitle(badgeNodeItem.getCount());
                }
            } else if (str.equals(MessageFollowCommentActivity.this.DM_MSGBOX_REPLY) && MessageFollowCommentActivity.this.commentFragment != null) {
                MessageFollowCommentActivity.this.commentFragment.updateTitle(badgeNodeItem.getCount());
            }
            MessageFollowCommentActivity.this.initPageTab(str, badgeNodeItem.getCount());
            if (MessageFollowCommentActivity.this.manager == null) {
                MessageFollowCommentActivity.this.manager = yp.a();
            }
            MessageFollowCommentActivity.this.manager.i(str, MessageFollowCommentActivity.this.listenerBadge);
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeQueryFail(List<String> list, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-25297299")) {
                ipChange.ipc$dispatch("-25297299", new Object[]{this, list, str, str2});
                return;
            }
            if (MessageFollowCommentActivity.this.manager == null) {
                MessageFollowCommentActivity.this.manager = yp.a();
            }
            MessageFollowCommentActivity.this.manager.j(list, MessageFollowCommentActivity.this.listenerBadge);
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374718783")) {
            ipChange.ipc$dispatch("-1374718783", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("关注");
        arrayList.add("回复");
        this.followFragment = MessageFollowFragment.newInstance();
        this.commentFragment = MessageCommentFragment.newInstance();
        ArrayList arrayList2 = new ArrayList();
        this.fragments = arrayList2;
        arrayList2.add(this.followFragment);
        this.fragments.add(this.commentFragment);
        MessageListMainAdapter messageListMainAdapter = new MessageListMainAdapter(getSupportFragmentManager(), this.fragments, arrayList);
        this.mainAdapter = messageListMainAdapter;
        this.viewPager.setAdapter(messageListMainAdapter);
        this.pagerIndicator.setViewPager(this.viewPager);
        this.pagerIndicator.setTabViewFactory(new a());
        this.pagerIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.message.ui.activity.MessageFollowCommentActivity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "188155799")) {
                    ipChange.ipc$dispatch("188155799", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2084693194")) {
                    ipChange.ipc$dispatch("-2084693194", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1298651230")) {
                    ipChange.ipc$dispatch("-1298651230", new Object[]{this, Integer.valueOf(i)});
                } else if (i == 0) {
                    br.c(StarFragment.KEY_FOLLOW, "5");
                    MessageFollowCommentActivity messageFollowCommentActivity = MessageFollowCommentActivity.this;
                    messageFollowCommentActivity.markNode(messageFollowCommentActivity.DM_MSGBOX_ATTENTION);
                    c.e().x(wc1.m().j(d20.E()));
                } else {
                    br.c("comment", "6");
                    MessageFollowCommentActivity messageFollowCommentActivity2 = MessageFollowCommentActivity.this;
                    messageFollowCommentActivity2.markNode(messageFollowCommentActivity2.DM_MSGBOX_REPLY);
                    c.e().x(wc1.m().h(d20.E()));
                }
            }
        });
        setPageData(false);
    }

    private void initExtras() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909152232")) {
            ipChange.ipc$dispatch("1909152232", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            this.type = StarFragment.KEY_FOLLOW;
        } else if (extras.containsKey("followCommentType")) {
            this.type = extras.getString("followCommentType", StarFragment.KEY_FOLLOW);
        } else {
            String string = extras.getString("value");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (string.equals("0")) {
                this.type = StarFragment.KEY_FOLLOW;
            } else {
                this.type = "comment";
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initPageTab(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572482144")) {
            ipChange.ipc$dispatch("-1572482144", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        View view = null;
        if (str.equals(this.DM_MSGBOX_ATTENTION)) {
            view = this.pagerIndicator.getTab(0);
        } else if (str.equals(this.DM_MSGBOX_REPLY)) {
            view = this.pagerIndicator.getTab(1);
        }
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R$id.unreadTips);
            if (i > 0) {
                textView.setVisibility(0);
                if (i > 9) {
                    textView.setText("9+");
                    textView.setBackgroundResource(R$drawable.unread_count_max);
                    return;
                }
                textView.setText(String.valueOf(i));
                textView.setBackgroundResource(R$drawable.unread_count_one);
                return;
            }
            textView.setVisibility(8);
        }
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906734303")) {
            ipChange.ipc$dispatch("-1906734303", new Object[]{this});
            return;
        }
        this.viewPager = (ViewPager) findViewById(R$id.vPager);
        this.pagerIndicator = (PagerIndicator) findViewById(R$id.indicator);
        initData();
    }

    private void query() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-457099513")) {
            ipChange.ipc$dispatch("-457099513", new Object[]{this});
            return;
        }
        Log.d("wxq", "query:");
        if (this.manager == null) {
            this.manager = yp.a();
        }
        this.manager.h(this.rootNodes, this.listenerBadge);
        this.manager.d(this.rootNodes);
    }

    private void setPageData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555381440")) {
            ipChange.ipc$dispatch("-1555381440", new Object[]{this, Boolean.valueOf(z)});
        } else if (LoginManager.k().q()) {
            if (this.type.equals("comment")) {
                if (z) {
                    br.c("comment", "6");
                }
                this.viewPager.setCurrentItem(1);
            } else {
                if (z) {
                    br.c(StarFragment.KEY_FOLLOW, "5");
                }
                this.viewPager.setCurrentItem(0);
            }
            query();
        } else {
            LoginManager.k().x(this, new Intent(), 100);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579888131")) {
            ipChange.ipc$dispatch("579888131", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1275045881")) {
            return R$layout.message_followcomment_main;
        }
        return ((Integer) ipChange.ipc$dispatch("-1275045881", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561251924")) {
            ipChange.ipc$dispatch("1561251924", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1769936809")) {
            ipChange.ipc$dispatch("-1769936809", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931281382")) {
            ipChange.ipc$dispatch("1931281382", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtras();
        findViewById(R$id.title_left_icon).setOnClickListener(this);
        initViewPager();
    }

    public void markNode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939953110")) {
            ipChange.ipc$dispatch("1939953110", new Object[]{this, str});
            return;
        }
        if (this.manager == null) {
            this.manager = yp.a();
        }
        this.manager.h(this.rootNodes, this.listenerBadge);
        this.manager.c(str);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785850957")) {
            ipChange.ipc$dispatch("785850957", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 100) {
            setPageData(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423884212")) {
            ipChange.ipc$dispatch("-1423884212", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.title_left_icon) {
            finish();
        }
    }

    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772386430")) {
            ipChange.ipc$dispatch("772386430", new Object[]{this, bundle, persistableBundle});
            return;
        }
        super.onCreate(bundle, persistableBundle);
        setDamaiUTKeyBuilder(wc1.m().l());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1491164797")) {
            ipChange.ipc$dispatch("-1491164797", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942302770")) {
            ipChange.ipc$dispatch("1942302770", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-969398725")) {
            return "关注与回复";
        }
        return (String) ipChange.ipc$dispatch("-969398725", new Object[]{this});
    }
}
