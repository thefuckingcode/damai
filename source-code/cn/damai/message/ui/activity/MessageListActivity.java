package cn.damai.message.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.message.bean.MessageGroupItem;
import cn.damai.message.bean.MessageItem;
import cn.damai.message.bean.MessageList;
import cn.damai.message.contract.MessageContract;
import cn.damai.message.presenter.MessagePresenter;
import cn.damai.message.ui.adapter.MessageAdapter;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshListView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.gr;
import tb.ne2;
import tb.p21;
import tb.pp2;
import tb.vc1;
import tb.wc1;
import tb.wk;
import tb.xf2;

/* compiled from: Taobao */
public class MessageListActivity extends DamaiBaseActivity<MessagePresenter, MessageContract.Model> implements MessageContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String PAGE_SIZE = "10";
    private DMIconFontTextView ivBack;
    private MessageAdapter mAdapter;
    private MessageItem mCurrentDeleteMessageItem;
    private List<MessageItem> mDatas = new ArrayList();
    private boolean mIsLoading;
    private ListView mListView;
    private MessageGroupItem mMessageGroupItem;
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        /* class cn.damai.message.ui.activity.MessageListActivity.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MessageItem messageItem;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "25276807")) {
                ipChange.ipc$dispatch("25276807", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)});
                return;
            }
            int i2 = i - 1;
            if (i2 < xf2.e(MessageListActivity.this.mDatas) && (messageItem = (MessageItem) MessageListActivity.this.mDatas.get(i2)) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("titlelabel", MessageListActivity.this.mMessageGroupItem.getMsgTypeName());
                hashMap.put("contentlabel", messageItem.getTitle());
                c.e().x(wc1.m().g(wc1.HOME_MESSAGE_LIST_PAGE, "list", "item_" + i2, hashMap, Boolean.TRUE));
                if (!xf2.j(messageItem.actionUrl)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("from", "push");
                    DMNav.from(MessageListActivity.this.mContext).withExtras(bundle).toUri(messageItem.actionUrl);
                    return;
                }
                Log.e("PushMessageActivity", " push url is null");
                MessageListActivity.this.startPage(messageItem);
            }
        }
    };
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        /* class cn.damai.message.ui.activity.MessageListActivity.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.message.ui.activity.MessageListActivity$2$a */
        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ MessageItem a;

            a(MessageItem messageItem) {
                this.a = messageItem;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1288198334")) {
                    ipChange.ipc$dispatch("-1288198334", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                MessageListActivity.this.requestDeleteMessage(this.a);
                dialogInterface.dismiss();
            }
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            MessageItem messageItem;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1050043952")) {
                return ((Boolean) ipChange.ipc$dispatch("1050043952", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)})).booleanValue();
            }
            int i2 = i - 1;
            if (i2 >= xf2.e(MessageListActivity.this.mDatas) || (messageItem = (MessageItem) MessageListActivity.this.mDatas.get(i2)) == null) {
                return false;
            }
            new AlertDialog.Builder(MessageListActivity.this.mContext).setCancelable(true).setItems(new String[]{"删除消息"}, new a(messageItem)).create().show();
            return true;
        }
    };
    private PullToRefreshBase.OnLastItemVisibleListener mOnLastItemVisibleListener = new b();
    private PullToRefreshBase.OnRefreshListener<ListView> mOnRefreshListener = new a();
    private int mPageIndex = 1;
    private PullToRefreshListView mPullToRefreshListView;
    private boolean mRefreshOrLoadMore;
    private View mViewStatusBarSpace;
    private TextView titleContent;

    /* compiled from: Taobao */
    public class a implements PullToRefreshBase.OnRefreshListener<ListView> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
        public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1166201425")) {
                ipChange.ipc$dispatch("1166201425", new Object[]{this, pullToRefreshBase});
                return;
            }
            MessageListActivity.this.mPageIndex = 1;
            MessageListActivity.this.mIsLoading = true;
            MessageListActivity.this.requestMessageList(true);
        }
    }

    /* compiled from: Taobao */
    public class b implements PullToRefreshBase.OnLastItemVisibleListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener
        public void onLastItemVisible() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "595654927")) {
                ipChange.ipc$dispatch("595654927", new Object[]{this});
            } else if (!MessageListActivity.this.mIsLoading) {
                MessageListActivity.access$308(MessageListActivity.this);
                MessageListActivity.this.mIsLoading = true;
                MessageListActivity.this.requestMessageList(false);
            }
        }
    }

    static /* synthetic */ int access$308(MessageListActivity messageListActivity) {
        int i = messageListActivity.mPageIndex;
        messageListActivity.mPageIndex = i + 1;
        return i;
    }

    private void initPullToRefreshListView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747501765")) {
            ipChange.ipc$dispatch("-747501765", new Object[]{this});
            return;
        }
        PullToRefreshListView pullToRefreshListView = (PullToRefreshListView) findViewById(R$id.message_item_listview);
        this.mPullToRefreshListView = pullToRefreshListView;
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ListView listView = (ListView) this.mPullToRefreshListView.getRefreshableView();
        this.mListView = listView;
        listView.setDividerHeight(0);
        this.mPullToRefreshListView.setOnRefreshListener(this.mOnRefreshListener);
        this.mPullToRefreshListView.setOnLastItemVisibleListener(this.mOnLastItemVisibleListener);
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.mListView.setOnItemLongClickListener(this.mOnItemLongClickListener);
        MessageAdapter messageAdapter = new MessageAdapter(this, this.mDatas);
        this.mAdapter = messageAdapter;
        this.mListView.setAdapter((ListAdapter) messageAdapter);
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319879076")) {
            ipChange.ipc$dispatch("-319879076", new Object[]{this});
            return;
        }
        this.mViewStatusBarSpace = findViewById(R$id.message_title_bar_space);
        this.ivBack = (DMIconFontTextView) findViewById(R$id.title_left_icon);
        this.titleContent = (TextView) findViewById(R$id.message_list_title);
        this.ivBack.setOnClickListener(this);
        setImmersionStyle();
        this.titleContent.setText(this.mMessageGroupItem.getMsgTypeName());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestDeleteMessage(MessageItem messageItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787819377")) {
            ipChange.ipc$dispatch("-787819377", new Object[]{this, messageItem});
            return;
        }
        this.mCurrentDeleteMessageItem = messageItem;
        HashMap hashMap = new HashMap();
        hashMap.put(ShareperfenceConstants.OLD_LOGIN_KEY, d20.q());
        hashMap.put("messageId", messageItem.getMessageId());
        ((MessagePresenter) this.mPresenter).deleteMessage(hashMap);
        startProgressDialog();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestMessageList(boolean z) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311620905")) {
            ipChange.ipc$dispatch("311620905", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRefreshOrLoadMore = z;
        HashMap hashMap = new HashMap();
        hashMap.put(ShareperfenceConstants.OLD_LOGIN_KEY, d20.q());
        hashMap.put("groupId", String.valueOf(this.mMessageGroupItem.getGroupId()));
        if (!z) {
            if (xf2.e(this.mDatas) > 0) {
                List<MessageItem> list = this.mDatas;
                str = list.get(list.size() - 1).getMessageId();
            } else {
                str = "0";
            }
            hashMap.put("messageId", str);
            hashMap.put("size", "10");
        }
        hashMap.put("pageIndex", String.valueOf(this.mPageIndex));
        ((MessagePresenter) this.mPresenter).getMessageItemList(hashMap, z);
    }

    private void setEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368767409")) {
            ipChange.ipc$dispatch("368767409", new Object[]{this});
        } else if (xf2.e(this.mDatas) <= 0) {
            this.mPullToRefreshListView.setEmptyView(getLayoutInflater().inflate(R$layout.layout_message_empty_view, (ViewGroup) null));
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-545987871")) {
            ipChange.ipc$dispatch("-545987871", new Object[]{this});
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

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "517034793")) {
            ipChange.ipc$dispatch("517034793", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.message.contract.MessageContract.View
    public void deleteMessageFailure(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-985725497")) {
            ipChange.ipc$dispatch("-985725497", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        vc1.a(this.mContext, str, str2);
    }

    @Override // cn.damai.message.contract.MessageContract.View
    public void deleteMessageSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2002329318")) {
            ipChange.ipc$dispatch("-2002329318", new Object[]{this});
            return;
        }
        this.mDatas.remove(this.mCurrentDeleteMessageItem);
        ToastUtil.a().j(this.mContext, "删除成功");
        if (xf2.e(this.mDatas) <= 10 && !this.mIsLoading) {
            requestMessageList(false);
        }
        this.mAdapter.notifyDataSetChanged();
        stopProgressDialog();
        setResult(-1);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-809236191")) {
            return R$layout.layout_activity_msg_model_detail;
        }
        return ((Integer) ipChange.ipc$dispatch("-809236191", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178516870")) {
            ipChange.ipc$dispatch("-1178516870", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803423503")) {
            ipChange.ipc$dispatch("-803423503", new Object[]{this});
            return;
        }
        ((MessagePresenter) this.mPresenter).setVM(this, (MessageContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746948340")) {
            ipChange.ipc$dispatch("-746948340", new Object[]{this});
            return;
        }
        MessageGroupItem messageGroupItem = (MessageGroupItem) getIntent().getParcelableExtra("intent_extra_key_group_model");
        this.mMessageGroupItem = messageGroupItem;
        if (messageGroupItem == null) {
            finish();
            return;
        }
        initTitleView();
        initPullToRefreshListView();
        requestMessageList(true);
        hideBaseLayout();
        startProgressDialog();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197789710")) {
            ipChange.ipc$dispatch("-197789710", new Object[]{this, view});
        } else if (view.getId() == R$id.title_left_icon) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-913755218")) {
            ipChange.ipc$dispatch("-913755218", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (this.mMessageGroupItem != null) {
            setDamaiUTKeyBuilder(wc1.m().o(this.mMessageGroupItem.getMsgTypeName()));
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64033705")) {
            ipChange.ipc$dispatch("64033705", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886854836")) {
            ipChange.ipc$dispatch("-1886854836", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917955339")) {
            ipChange.ipc$dispatch("-1917955339", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459943428")) {
            ipChange.ipc$dispatch("-459943428", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76121451")) {
            ipChange.ipc$dispatch("-76121451", new Object[]{this});
            return;
        }
        super.onResume();
    }

    @Override // cn.damai.message.contract.MessageContract.View
    public void returnMessageItemListFailures(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498914924")) {
            ipChange.ipc$dispatch("1498914924", new Object[]{this, str, str2});
            return;
        }
        this.mIsLoading = false;
        setEmptyView();
        this.mAdapter.notifyDataSetChanged();
        this.mPullToRefreshListView.onRefreshComplete();
        stopProgressDialog();
        vc1.a(this.mContext, str, str2);
    }

    @Override // cn.damai.message.contract.MessageContract.View
    public void returnMessageItemListSuccess(MessageList messageList) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2109127122")) {
            ipChange.ipc$dispatch("2109127122", new Object[]{this, messageList});
            return;
        }
        this.mIsLoading = false;
        if (this.mRefreshOrLoadMore) {
            this.mDatas.clear();
        }
        if (messageList != null) {
            i = xf2.e(messageList.getMessageList());
        }
        if (i > 0) {
            this.mDatas.addAll(messageList.getMessageList());
        }
        setEmptyView();
        this.mAdapter.notifyDataSetChanged();
        this.mPullToRefreshListView.onRefreshComplete();
        stopProgressDialog();
        setResult(-1);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1702552021")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1702552021", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030546380")) {
            ipChange.ipc$dispatch("-2030546380", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670946288")) {
            ipChange.ipc$dispatch("670946288", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099041836")) {
            ipChange.ipc$dispatch("-2099041836", new Object[]{this, str});
        }
    }

    public void startPage(MessageItem messageItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766013269")) {
            ipChange.ipc$dispatch("-766013269", new Object[]{this, messageItem});
            return;
        }
        String actionValue = TextUtils.isEmpty(messageItem.getActionValue()) ? "" : messageItem.getActionValue();
        int actionType = messageItem.getActionType();
        if (actionType == 2) {
            pp2.b().q((Activity) this.mContext, pp2.SCHEME_HOMEPAGE);
        } else if (actionType == 3) {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, actionValue);
            bundle.putInt(DamaiConstants.PUSH_MSG_BACK_TYPE, 1);
            DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
        } else if (actionType == 6) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("backPage", true);
            bundle2.putString("orderId", actionValue);
            DMNav.from(this.mContext).withExtras(bundle2).toUri(NavUri.b(gr.g));
        } else if (actionType != 9) {
            switch (actionType) {
                case 12:
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(TicketDetailExtFragment.PERFORM_ID, actionValue);
                    DMNav.from(this.mContext).withExtras(bundle3).toUri(NavUri.b(gr.a0));
                    return;
                case 13:
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(TicketDetailExtFragment.PERFORM_ID, actionValue);
                    DMNav.from(this.mContext).withExtras(bundle4).toUri(NavUri.b(gr.Z));
                    return;
                case 14:
                    if (!TextUtils.isEmpty(actionValue)) {
                        Bundle bundle5 = new Bundle();
                        bundle5.putString(p21.ISSUE_PARAM_COMMENT_ID, actionValue);
                        DMNav.from(this.mContext).withExtras(bundle5).toUri(NavUri.b("commentdetail"));
                        return;
                    }
                    return;
                default:
                    switch (actionType) {
                        case 17:
                            Bundle bundle6 = new Bundle();
                            bundle6.putString("followCommentType", StarFragment.KEY_FOLLOW);
                            bundle6.putString(DamaiConstants.PUSH_MSG_SUMMARY, actionValue);
                            DMNav.from(this.mContext).withExtras(bundle6).toUri(NavUri.b(gr.y));
                            return;
                        case 18:
                            Bundle bundle7 = new Bundle();
                            bundle7.putString(DamaiConstants.PUSH_MSG_SUMMARY, actionValue);
                            bundle7.putString("followCommentType", "comment");
                            DMNav.from(this.mContext).withExtras(bundle7).toUri(NavUri.b(gr.y));
                            return;
                        case 19:
                            Bundle bundle8 = new Bundle();
                            bundle8.putBoolean("backPage", true);
                            bundle8.putString("orderId", actionValue);
                            DMNav.from(this.mContext).withExtras(bundle8).toUri(NavUri.b(gr.h));
                            return;
                        default:
                            return;
                    }
            }
        } else {
            DMNav.from(this.mContext).toUri(gr.d());
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310393167")) {
            ipChange.ipc$dispatch("310393167", new Object[]{this});
        }
    }
}
