package cn.damai.message;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.im.AliMeUtil;
import cn.damai.message.bean.MessageGroupItem;
import cn.damai.message.bean.MessageGroupResponse;
import cn.damai.message.bean.MessageNotice;
import cn.damai.message.contract.MessageGroupContract;
import cn.damai.message.presenter.MessageGroupPresenter;
import cn.damai.message.ui.activity.MessageFollowCommentActivity;
import cn.damai.message.ui.activity.MessageListActivity;
import cn.damai.message.ui.adapter.MessageListAdapter;
import cn.damai.message.viewholder.MessageModelViewHolder;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.ne2;
import tb.uc1;
import tb.vc1;
import tb.wc1;
import tb.wk;
import tb.xf2;
import tb.yp;

/* compiled from: Taobao */
public class MessageMainActivity extends DamaiBaseActivity<MessageGroupPresenter, MessageGroupContract.Model> implements MessageGroupContract.View, MessageModelViewHolder.MessageAdapterCallback, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DM_MSGBOX_ATTENTION_REPLY = "DM_MSGBOX_ATTENTION_REPLY";
    private static final String DM_MSGBOX_MY_HONEY = "DM_MSGBOX_MY_HONEY";
    private static final String DM_MSGBOX_NOTICE = "DM_MSGBOX_NOTICE";
    private static final String DM_MSGBOX_RECOMMEND = "DM_MSGBOX_RECOMMEND";
    private static final int MESSAGE_LIST_REQUEST_CODE = 1000;
    private static final String MESSAGE_PUSH_TIP_SHOW = "MESSAGE_PUSH_TIP_SHOW";
    private static final String PUSH_PERMISSION_CLOSE = "push_permission_close";
    private static final int REQUEST_PUSH_OPEN = 1001;
    private int count = 0;
    private boolean isNeedRequest = false;
    private DMIconFontTextView ivBack;
    private DMBadgeListener listenerBadge = new b();
    private LinearLayout ll_empty_view;
    private List<MessageGroupItem> mDatas = new ArrayList();
    private MessageListAdapter mListAdapter;
    private FrameLayout mMessageTipContainer;
    private IRecyclerView mRecyclerView;
    private View mViewStatusBarSpace;
    private yp manager;
    private List<String> rootNodes;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "286260095")) {
                ipChange.ipc$dispatch("286260095", new Object[]{this, view});
                return;
            }
            MessageMainActivity.this.hiddenMessageTip();
            MessageMainActivity.this.pushStatusCtrl();
            uc1.d(MessageMainActivity.this, this.a, this.b);
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
            if (AndroidInstantRuntime.support(ipChange, "-1597700022")) {
                ipChange.ipc$dispatch("-1597700022", new Object[]{this, str, badgeNodeItem});
                return;
            }
            MessageMainActivity.this.combineData(str, badgeNodeItem);
            MessageMainActivity.this.mListAdapter.notifyDataSetChanged();
            MessageMainActivity.this.mRecyclerView.setRefreshing(false);
            MessageMainActivity.this.manager.i(str, MessageMainActivity.this.listenerBadge);
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeQueryFail(List<String> list, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1261764754")) {
                ipChange.ipc$dispatch("1261764754", new Object[]{this, list, str, str2});
                return;
            }
            MessageMainActivity.this.mListAdapter.notifyDataSetChanged();
            MessageMainActivity.this.mRecyclerView.setRefreshing(false);
            MessageMainActivity.this.manager.j(list, MessageMainActivity.this.listenerBadge);
        }
    }

    /* compiled from: Taobao */
    public class c implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1988876318")) {
                    ipChange.ipc$dispatch("-1988876318", new Object[]{this});
                    return;
                }
                AliMeUtil.o();
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1161313326")) {
                    ipChange.ipc$dispatch("-1161313326", new Object[]{this, str});
                    return;
                }
                AliMeUtil.b(MessageMainActivity.this, AliMeUtil.c(AliMeUtil.FROM_MESSAGE, str));
            }
        }

        c() {
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1227124757")) {
                ipChange.ipc$dispatch("1227124757", new Object[]{this});
                return;
            }
            AliMeUtil.o();
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "878080815")) {
                ipChange.ipc$dispatch("878080815", new Object[]{this, Long.valueOf(j)});
                return;
            }
            AliMeUtil.e(j, AliMeUtil.FROM_MESSAGE, new a());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void combineData(String str, BadgeNodeItem badgeNodeItem) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "199977579")) {
            ipChange.ipc$dispatch("199977579", new Object[]{this, str, badgeNodeItem});
            return;
        }
        int size = this.mDatas.size();
        while (true) {
            if (i < size) {
                if (1 != this.mDatas.get(i).getGroupId() || !DM_MSGBOX_RECOMMEND.equals(str)) {
                    if (4 != this.mDatas.get(i).getGroupId() || !DM_MSGBOX_NOTICE.equals(str)) {
                        if (7 != this.mDatas.get(i).getGroupId() || !DM_MSGBOX_ATTENTION_REPLY.equals(str)) {
                            if (8 == this.mDatas.get(i).getGroupId() && DM_MSGBOX_MY_HONEY.equals(str)) {
                                this.mDatas.get(i).setUnBadgeReadCount(String.valueOf(badgeNodeItem.getCount()));
                                break;
                            }
                            i++;
                        } else {
                            this.mDatas.get(i).setUnBadgeReadCount(String.valueOf(badgeNodeItem.getCount()));
                            break;
                        }
                    } else {
                        this.mDatas.get(i).setUnBadgeReadCount(String.valueOf(badgeNodeItem.getCount()));
                        break;
                    }
                } else {
                    this.mDatas.get(i).setUnBadgeReadCount(String.valueOf(badgeNodeItem.getCount()));
                    break;
                }
            } else {
                break;
            }
        }
        this.count++;
    }

    private void daMaiService() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973452516")) {
            ipChange.ipc$dispatch("1973452516", new Object[]{this});
            return;
        }
        AliMeUtil.j(new c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hiddenMessageTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-461521693")) {
            ipChange.ipc$dispatch("-461521693", new Object[]{this});
            return;
        }
        this.mMessageTipContainer.removeAllViews();
        this.mMessageTipContainer.setVisibility(8);
    }

    private void initPullToRefreshListView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778153925")) {
            ipChange.ipc$dispatch("-1778153925", new Object[]{this});
            return;
        }
        this.mListAdapter = new MessageListAdapter(this, this.mDatas);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.message_irecyclerview);
        this.mRecyclerView.addFooterView(LayoutInflater.from(this).inflate(R$layout.message_footerview, (ViewGroup) null));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(this.mListAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this, R$color.white));
    }

    private void initRootNodes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303373238")) {
            ipChange.ipc$dispatch("-303373238", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.rootNodes = arrayList;
        arrayList.add(DM_MSGBOX_NOTICE);
        this.rootNodes.add(DM_MSGBOX_RECOMMEND);
        this.rootNodes.add(DM_MSGBOX_ATTENTION_REPLY);
        this.rootNodes.add(DM_MSGBOX_MY_HONEY);
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695793828")) {
            ipChange.ipc$dispatch("-695793828", new Object[]{this});
            return;
        }
        this.mViewStatusBarSpace = findViewById(R$id.message_title_bar_space);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.title_left_icon);
        this.ivBack = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
        setImmersionStyle();
    }

    private void markNode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1280601724")) {
            ipChange.ipc$dispatch("1280601724", new Object[]{this, str});
            return;
        }
        if (this.manager == null) {
            this.manager = yp.a();
        }
        this.manager.h(this.rootNodes, this.listenerBadge);
        this.manager.c(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pushStatusCtrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985517206")) {
            ipChange.ipc$dispatch("-1985517206", new Object[]{this});
        } else if (PUSH_PERMISSION_CLOSE.equals(d20.B(MESSAGE_PUSH_TIP_SHOW)) || PermissionsHelper.a(getApplicationContext())) {
            hiddenMessageTip();
        } else {
            showOpenNotificationTip();
        }
    }

    private void query() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778729633")) {
            ipChange.ipc$dispatch("1778729633", new Object[]{this});
            return;
        }
        if (this.manager == null) {
            this.manager = yp.a();
        }
        this.manager.h(this.rootNodes, this.listenerBadge);
        this.manager.d(this.rootNodes);
    }

    private void requestMessageGroupList(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148314064")) {
            ipChange.ipc$dispatch("-1148314064", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            startProgressDialog();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ShareperfenceConstants.OLD_LOGIN_KEY, d20.q());
        hashMap.put(Constants.KEY_OS_TYPE, "2");
        ((MessageGroupPresenter) this.mPresenter).getMessageGroupList(hashMap);
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787833313")) {
            ipChange.ipc$dispatch("787833313", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                this.mViewStatusBarSpace.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private void setPush() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1357754547")) {
            ipChange.ipc$dispatch("-1357754547", new Object[]{this});
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, 1001);
    }

    private void showMessageNoticeTip(final String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008657148")) {
            ipChange.ipc$dispatch("1008657148", new Object[]{this, str, str2});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.message_tip_notice, (ViewGroup) null);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) inflate.findViewById(R$id.message_notice_arrow);
        final DMIconFontTextView dMIconFontTextView2 = (DMIconFontTextView) inflate.findViewById(R$id.message_notice_click_view);
        ((TextView) inflate.findViewById(R$id.message_notice_content)).setText(str);
        if (TextUtils.isEmpty(str2)) {
            dMIconFontTextView.setText(getResources().getString(R$string.iconfont_guanbi12));
            dMIconFontTextView2.setOnClickListener(new a(str, str2));
        } else {
            dMIconFontTextView.setText(getResources().getString(R$string.iconfont_youjiantou12));
            dMIconFontTextView2.setOnClickListener(new View.OnClickListener() {
                /* class cn.damai.message.MessageMainActivity.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1897416832")) {
                        ipChange.ipc$dispatch("-1897416832", new Object[]{this, view});
                        return;
                    }
                    uc1.d(MessageMainActivity.this, str, str2);
                    DMNav.from(MessageMainActivity.this).toUri(str2);
                    dMIconFontTextView2.postDelayed(new Runnable() {
                        /* class cn.damai.message.MessageMainActivity.AnonymousClass2.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1841180611")) {
                                ipChange.ipc$dispatch("1841180611", new Object[]{this});
                                return;
                            }
                            MessageMainActivity.this.hiddenMessageTip();
                            MessageMainActivity.this.pushStatusCtrl();
                        }
                    }, 200);
                }
            });
        }
        this.mMessageTipContainer.removeAllViews();
        this.mMessageTipContainer.addView(inflate);
        this.mMessageTipContainer.setVisibility(0);
    }

    private void showOpenNotificationTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119532800")) {
            ipChange.ipc$dispatch("-1119532800", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.message_tip_notification, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.message_tv_push_status)).setOnClickListener(this);
        ((DMIconFontTextView) inflate.findViewById(R$id.message_tv_push)).setOnClickListener(this);
        this.mMessageTipContainer.removeAllViews();
        this.mMessageTipContainer.addView(inflate);
        this.mMessageTipContainer.setVisibility(0);
    }

    private void showView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062315649")) {
            ipChange.ipc$dispatch("-2062315649", new Object[]{this});
        } else if (xf2.e(this.mDatas) <= 0) {
            this.ll_empty_view.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            this.mRecyclerView.setRefreshing(false);
        } else {
            this.mRecyclerView.setRefreshing(false);
            this.mRecyclerView.setVisibility(0);
            this.ll_empty_view.setVisibility(8);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1379601367")) {
            ipChange.ipc$dispatch("-1379601367", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-313538527")) {
            return R$layout.layout_msg_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("-313538527", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303208826")) {
            ipChange.ipc$dispatch("1303208826", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179338255")) {
            ipChange.ipc$dispatch("-1179338255", new Object[]{this});
            return;
        }
        ((MessageGroupPresenter) this.mPresenter).setVM(this, (MessageGroupContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130423796")) {
            ipChange.ipc$dispatch("-1130423796", new Object[]{this});
            return;
        }
        initTitleView();
        initPullToRefreshListView();
        this.ll_empty_view = (LinearLayout) findViewById(R$id.ll_empty_view);
        this.mMessageTipContainer = (FrameLayout) findViewById(R$id.message_tip_container);
        requestMessageGroupList(true);
        initRootNodes();
        hideBaseLayout();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088775411")) {
            ipChange.ipc$dispatch("2088775411", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            pushStatusCtrl();
        } else if (i2 == -1 && i == 1000) {
            this.isNeedRequest = false;
            requestMessageGroupList(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083235598")) {
            ipChange.ipc$dispatch("-2083235598", new Object[]{this, view});
        } else if (view.getId() == R$id.message_tv_push) {
            cn.damai.common.user.c.e().x(wc1.m().p("0"));
            d20.T(MESSAGE_PUSH_TIP_SHOW, PUSH_PERMISSION_CLOSE);
            hiddenMessageTip();
        } else if (view.getId() == R$id.message_tv_push_status) {
            cn.damai.common.user.c.e().x(wc1.m().p("1"));
            setPush();
        } else if (view.getId() == R$id.title_left_icon) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "766964398")) {
            ipChange.ipc$dispatch("766964398", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(wc1.m().n());
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834196932")) {
            return ((Boolean) ipChange.ipc$dispatch("1834196932", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            finish();
            return false;
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1749207895")) {
            ipChange.ipc$dispatch("-1749207895", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391157172")) {
            ipChange.ipc$dispatch("-1391157172", new Object[]{this});
        }
    }

    @Override // cn.damai.message.viewholder.MessageModelViewHolder.MessageAdapterCallback
    public void onMessageClick(View view, int i) {
        MessageGroupItem messageGroupItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "33238450")) {
            ipChange.ipc$dispatch("33238450", new Object[]{this, view, Integer.valueOf(i)});
        } else if (i < xf2.e(this.mDatas) && (messageGroupItem = this.mDatas.get(i)) != null) {
            this.isNeedRequest = true;
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", messageGroupItem.getMsgTypeName());
            hashMap.put("usercode", d20.E());
            if (messageGroupItem.getGroupId() == 7) {
                markNode(DM_MSGBOX_ATTENTION_REPLY);
                startActivity(new Intent(this, MessageFollowCommentActivity.class));
                cn.damai.common.user.c.e().x(wc1.m().g("message", "list", wc1.FOLLOW_REPLY_MSG, hashMap, Boolean.TRUE));
            } else if (messageGroupItem.getGroupId() == 8) {
                markNode(DM_MSGBOX_MY_HONEY);
                cn.damai.common.user.c.e().x(wc1.m().g("message", "list", wk.MY_ALIME_PAGE, hashMap, Boolean.TRUE));
                daMaiService();
            } else {
                if (1 == messageGroupItem.getGroupId()) {
                    markNode(DM_MSGBOX_RECOMMEND);
                    cn.damai.common.user.c.e().x(wc1.m().g("message", "list", "recommend", hashMap, Boolean.TRUE));
                } else if (4 == messageGroupItem.getGroupId()) {
                    markNode(DM_MSGBOX_NOTICE);
                    cn.damai.common.user.c.e().x(wc1.m().g("message", "list", "notice", hashMap, Boolean.TRUE));
                }
                Intent intent = new Intent(this, MessageListActivity.class);
                intent.putExtra("intent_extra_key_group_model", messageGroupItem);
                startActivityForResult(intent, 1000);
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730074123")) {
            ipChange.ipc$dispatch("-730074123", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021782268")) {
            ipChange.ipc$dispatch("2021782268", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1126043411")) {
            ipChange.ipc$dispatch("-1126043411", new Object[]{this});
            return;
        }
        requestMessageGroupList(false);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459596907")) {
            ipChange.ipc$dispatch("-459596907", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.isNeedRequest) {
            this.isNeedRequest = false;
            requestMessageGroupList(true);
        }
    }

    @Override // cn.damai.message.contract.MessageGroupContract.View
    public void returnMessageGroupListFailure(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411651737")) {
            ipChange.ipc$dispatch("411651737", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        this.mDatas.clear();
        showView();
        this.mListAdapter.notifyDataSetChanged();
        this.mRecyclerView.setRefreshing(false);
        vc1.a(this.mContext, str, str2);
    }

    @Override // cn.damai.message.contract.MessageGroupContract.View
    public void returnMessageGroupListSuccess(MessageGroupResponse messageGroupResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356882182")) {
            ipChange.ipc$dispatch("356882182", new Object[]{this, messageGroupResponse});
            return;
        }
        stopProgressDialog();
        this.mDatas.clear();
        if (!(messageGroupResponse == null || messageGroupResponse.getModel() == null)) {
            MessageNotice notice = messageGroupResponse.getModel().getNotice();
            if (notice == null || TextUtils.isEmpty(notice.getContent()) || uc1.c(this, notice.getContent(), notice.getUrl())) {
                pushStatusCtrl();
            } else {
                showMessageNoticeTip(notice.getContent(), notice.getUrl());
            }
        }
        if (((messageGroupResponse == null || messageGroupResponse.getModel() == null) ? 0 : xf2.e(messageGroupResponse.getModel().getMessageGroupList())) > 0) {
            this.mDatas.addAll(messageGroupResponse.getModel().getMessageGroupList());
        }
        showView();
        query();
        this.mListAdapter.notifyDataSetChanged();
        this.mRecyclerView.setRefreshing(false);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "671899861")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("671899861", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888506164")) {
            ipChange.ipc$dispatch("1888506164", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825496304")) {
            ipChange.ipc$dispatch("825496304", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835194156")) {
            ipChange.ipc$dispatch("-1835194156", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806090831")) {
            ipChange.ipc$dispatch("806090831", new Object[]{this});
        }
    }
}
