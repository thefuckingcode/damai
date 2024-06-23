package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.OnCellClickListener;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol;

/* compiled from: Taobao */
public abstract class BaseChatListAdapter<T> extends FrameLayout implements AILPChatListProtocol, View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static final int CHAT_LAST_MSG_UPDATE = 6;
    protected static final int CHAT_MASK_LAYER_UPDATE = 4;
    protected static final int CHAT_MSG = 1;
    protected static final int CHAT_MSG_CLEAR = 7;
    protected static final int CHAT_MSG_LOCAL = 2;
    protected static final int CHAT_MSG_UPDATE = 5;
    protected static final int CHAT_UPDATE = 3;
    private static int MESSAGE_DELAY_TIME;
    private boolean isScrollBottom = true;
    private long lastTime = 0;
    private BaseChatListRecyclerViewAdapter mAdapter;
    protected OnCellClickListener mCellClickListener;
    private RecyclerView mChatRecyclerView;
    private int mCurrentOrientation = 1;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter */
        /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter */
        /* JADX DEBUG: Multi-variable search result rejected for r6v15, resolved type: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter */
        /* JADX DEBUG: Multi-variable search result rejected for r6v17, resolved type: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListRecyclerViewAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1784949414")) {
                ipChange.ipc$dispatch("1784949414", new Object[]{this, message});
                return;
            }
            Object obj = message.obj;
            switch (message.what) {
                case 1:
                    BaseChatListAdapter.this.updateChatData(obj, false);
                    return;
                case 2:
                    BaseChatListAdapter.this.updateChatData(obj, true);
                    return;
                case 3:
                    BaseChatListAdapter.this.mAdapter.notifyUpdateList();
                    if (BaseChatListAdapter.this.mAdapter.isSlideToBottom() || BaseChatListAdapter.this.mAdapter.getNewCount() == 0) {
                        BaseChatListAdapter.this.hideNewMsgLayout();
                        return;
                    } else {
                        BaseChatListAdapter.this.showNewMsgLayout();
                        return;
                    }
                case 4:
                    BaseChatListAdapter.this.updateMaskLayer();
                    return;
                case 5:
                    BaseChatListAdapter.this.updateLastChatData(obj);
                    return;
                case 6:
                    BaseChatListAdapter.this.mAdapter.notifyUpdateLastItem(obj);
                    return;
                case 7:
                    BaseChatListAdapter.this.mAdapter.clearData();
                    return;
                default:
                    return;
            }
        }
    };
    private int mLastOrientation = 1;
    private TextView mNewMessageTextView;
    private View mNewMessageTips;
    public float topMaskHeightScale = 0.0f;
    public float topMaskStartAlpha = 0.0f;
    private long updateLastTime = 0;
    private boolean useLocal = false;

    /* compiled from: Taobao */
    private class OnScrollListener extends RecyclerView.OnScrollListener {
        int nNewState;

        private OnScrollListener() {
            this.nNewState = -2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            this.nNewState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (BaseChatListAdapter.this.mAdapter != null && BaseChatListAdapter.this.mAdapter.isSlideToBottom()) {
                BaseChatListAdapter.this.hideNewMsgLayout();
                BaseChatListAdapter.this.addCacheData();
            }
            BaseChatListAdapter.this.mHandler.sendEmptyMessage(4);
        }
    }

    public BaseChatListAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateLayout(context);
        RecyclerView chatRecyclerView = getChatRecyclerView();
        this.mChatRecyclerView = chatRecyclerView;
        chatRecyclerView.setItemAnimator(null);
        this.mNewMessageTips = getNewMessageTips();
        this.mNewMessageTextView = getNewMessageTextView();
        this.mNewMessageTips.setOnClickListener(this);
        BaseChatListRecyclerViewAdapter createAdapter = createAdapter(context);
        this.mAdapter = createAdapter;
        this.mChatRecyclerView.setAdapter(createAdapter);
        this.mChatRecyclerView.setLayoutManager(getLayoutManager(context));
        this.mChatRecyclerView.addOnScrollListener(new OnScrollListener());
        this.mChatRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onGlobalLayout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1754518125")) {
                    ipChange.ipc$dispatch("1754518125", new Object[]{this});
                    return;
                }
                BaseChatListAdapter.this.mChatRecyclerView.getHeight();
            }
        });
        hideNewMsgLayout();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addCacheData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565736448")) {
            ipChange.ipc$dispatch("565736448", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = this.mChatRecyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1690678492")) {
                        ipChange.ipc$dispatch("-1690678492", new Object[]{this});
                    } else if (BaseChatListAdapter.this.mAdapter != null) {
                        BaseChatListAdapter.this.mAdapter.addCacheData();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideNewMsgLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923607618")) {
            ipChange.ipc$dispatch("-923607618", new Object[]{this});
            return;
        }
        View view = this.mNewMessageTips;
        if (view != null && view.getVisibility() == 0) {
            this.mNewMessageTips.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateMaskLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919524387")) {
            ipChange.ipc$dispatch("919524387", new Object[]{this});
            return;
        }
        RecyclerView chatRecyclerView = getChatRecyclerView();
        if (chatRecyclerView != null && chatRecyclerView.getHeight() > 0) {
            float f = this.topMaskHeightScale;
            if (f > 0.0f && f <= 1.0f) {
                float f2 = this.topMaskStartAlpha;
                if (f2 > 0.0f && f2 <= 1.0f) {
                    int childCount = chatRecyclerView.getChildCount();
                    int height = (int) (((float) chatRecyclerView.getHeight()) * this.topMaskHeightScale);
                    if (childCount > 0) {
                        for (int i = 0; i < childCount; i++) {
                            View childAt = chatRecyclerView.getChildAt(i);
                            if (childAt != null) {
                                if (childAt.getY() < 0.0f) {
                                    childAt.setAlpha(0.0f);
                                } else {
                                    float f3 = (float) height;
                                    if (childAt.getY() < f3) {
                                        float y = childAt.getY();
                                        float f4 = this.topMaskStartAlpha;
                                        childAt.setAlpha(((y * f4) / f3) + f4);
                                    } else {
                                        childAt.setAlpha(1.0f);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void addMessage(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055134401")) {
            ipChange.ipc$dispatch("1055134401", new Object[]{this, t});
        } else if (t != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.lastTime;
            int i = MESSAGE_DELAY_TIME;
            if (uptimeMillis - j < ((long) i)) {
                uptimeMillis = ((long) i) + j;
            }
            this.lastTime = uptimeMillis;
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.mHandler.sendMessageAtTime(obtainMessage, uptimeMillis);
        }
    }

    public void addMessageLocal(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196335370")) {
            ipChange.ipc$dispatch("-196335370", new Object[]{this, t});
        } else if (t != null) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = t;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public void clearMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1168427857")) {
            ipChange.ipc$dispatch("1168427857", new Object[]{this});
            return;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 7;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public abstract BaseChatListRecyclerViewAdapter createAdapter(Context context);

    /* access modifiers changed from: protected */
    public abstract RecyclerView getChatRecyclerView();

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager getLayoutManager(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115167694")) {
            return (RecyclerView.LayoutManager) ipChange.ipc$dispatch("-2115167694", new Object[]{this, context});
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    /* access modifiers changed from: protected */
    public abstract TextView getNewMessageTextView();

    /* access modifiers changed from: protected */
    public abstract View getNewMessageTips();

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1208751334")) {
            return this;
        }
        return (View) ipChange.ipc$dispatch("1208751334", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public abstract View inflateLayout(Context context);

    /* access modifiers changed from: protected */
    public boolean isLocalRepetition(T t) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "306112461")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("306112461", new Object[]{this, t})).booleanValue();
    }

    public boolean isUseLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1232123935")) {
            return this.useLocal;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1232123935", new Object[]{this})).booleanValue();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148462596")) {
            ipChange.ipc$dispatch("-1148462596", new Object[]{this, view});
        } else if (view == this.mNewMessageTips) {
            addCacheData();
            hideNewMsgLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357371042")) {
            ipChange.ipc$dispatch("1357371042", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        int i = this.mCurrentOrientation;
        this.mLastOrientation = i;
        int i2 = configuration.orientation;
        this.mCurrentOrientation = i2;
        if (i2 == 1 && i == 2 && this.mAdapter != null) {
            postDelayed(new Runnable() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1494164987")) {
                        ipChange.ipc$dispatch("-1494164987", new Object[]{this});
                        return;
                    }
                    BaseChatListAdapter.this.mAdapter.scrollToEnd();
                }
            }, 200);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456067296")) {
            ipChange.ipc$dispatch("-456067296", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1188091482")) {
            ipChange.ipc$dispatch("1188091482", new Object[]{this});
            return;
        }
        BaseChatListRecyclerViewAdapter baseChatListRecyclerViewAdapter = this.mAdapter;
        if (baseChatListRecyclerViewAdapter != null) {
            baseChatListRecyclerViewAdapter.refreshData();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public void setLimitSize(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245005243")) {
            ipChange.ipc$dispatch("245005243", new Object[]{this, str});
            return;
        }
        try {
            this.mAdapter.setLimit(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public void setMessageDelay(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "524238891")) {
            ipChange.ipc$dispatch("524238891", new Object[]{this, str});
            return;
        }
        try {
            MESSAGE_DELAY_TIME = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int i2 = MESSAGE_DELAY_TIME;
        if (i2 >= 0) {
            i = i2;
        }
        MESSAGE_DELAY_TIME = i;
    }

    /* access modifiers changed from: protected */
    public void setNewMessageText(TextView textView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600183624")) {
            ipChange.ipc$dispatch("1600183624", new Object[]{this, textView, Integer.valueOf(i)});
        } else if (textView != null) {
            textView.setText(i + "条新消息");
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064201103")) {
            ipChange.ipc$dispatch("2064201103", new Object[]{this, onCellClickListener});
            return;
        }
        this.mCellClickListener = onCellClickListener;
        this.mAdapter.setOnCellClickListener(onCellClickListener);
    }

    /* access modifiers changed from: protected */
    public void showNewMsgLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776032931")) {
            ipChange.ipc$dispatch("776032931", new Object[]{this});
            return;
        }
        View view = this.mNewMessageTips;
        if (view != null && view.getVisibility() == 8) {
            this.mNewMessageTips.setVisibility(0);
        }
        BaseChatListRecyclerViewAdapter baseChatListRecyclerViewAdapter = this.mAdapter;
        if (baseChatListRecyclerViewAdapter != null && this.mNewMessageTextView != null) {
            setNewMessageText(this.mNewMessageTextView, baseChatListRecyclerViewAdapter.getNewCount());
        }
    }

    public void turnOffLocal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520963346")) {
            ipChange.ipc$dispatch("520963346", new Object[]{this});
            return;
        }
        this.useLocal = false;
    }

    public void turnOnLocal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606032976")) {
            ipChange.ipc$dispatch("-1606032976", new Object[]{this});
            return;
        }
        this.useLocal = true;
    }

    /* access modifiers changed from: protected */
    public void updateChatData(T t, boolean z) {
        BaseChatListRecyclerViewAdapter baseChatListRecyclerViewAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-538075048")) {
            ipChange.ipc$dispatch("-538075048", new Object[]{this, t, Boolean.valueOf(z)});
        } else if (t != null) {
            if ((z || !isUseLocal() || !isLocalRepetition(t)) && (baseChatListRecyclerViewAdapter = this.mAdapter) != null) {
                baseChatListRecyclerViewAdapter.notifyAddItem(t);
                if (this.mCurrentOrientation == 2) {
                    this.mAdapter.refreshData();
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long j = this.updateLastTime;
                int i = MESSAGE_DELAY_TIME;
                if (uptimeMillis - j < ((long) i)) {
                    uptimeMillis = ((long) i) + j;
                }
                this.updateLastTime = uptimeMillis;
                this.mHandler.sendEmptyMessageAtTime(3, uptimeMillis + ((long) i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateLastChatData(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2085572742")) {
            ipChange.ipc$dispatch("2085572742", new Object[]{this, t});
        } else if (t != null && this.mAdapter != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.updateLastTime;
            int i = MESSAGE_DELAY_TIME;
            if (uptimeMillis - j < ((long) i)) {
                uptimeMillis = ((long) i) + j;
            }
            this.updateLastTime = uptimeMillis;
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 6;
            obtainMessage.obj = t;
            this.mHandler.sendMessageAtTime(obtainMessage, uptimeMillis + ((long) MESSAGE_DELAY_TIME));
        }
    }

    public void updateLastMessage(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1219014963")) {
            ipChange.ipc$dispatch("1219014963", new Object[]{this, t});
        } else if (t != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.lastTime;
            int i = MESSAGE_DELAY_TIME;
            if (uptimeMillis - j < ((long) i)) {
                uptimeMillis = ((long) i) + j;
            }
            this.lastTime = uptimeMillis;
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = t;
            this.mHandler.sendMessage(obtainMessage);
        }
    }
}
