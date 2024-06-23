package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListRecyclerViewAdapter;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Map;

/* compiled from: Taobao */
public class AILPChatListYoukuAdapter extends BaseChatListAdapter<AILPChatBean> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "YKLChatListYoukuAdapter";
    private AILPChatListProtocol.INewMsgTipStyle mStyle;

    public AILPChatListYoukuAdapter(@NonNull Context context) {
        this(context, null);
    }

    private int dp2px(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090279388")) {
            return ((Integer) ipChange.ipc$dispatch("1090279388", new Object[]{this, context, Integer.valueOf(i)})).intValue();
        }
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void setTipStyle(View view, AILPChatListProtocol.INewMsgTipStyle iNewMsgTipStyle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467849711")) {
            ipChange.ipc$dispatch("467849711", new Object[]{this, view, iNewMsgTipStyle});
            return;
        }
        ((TextView) view.findViewById(R.id.portrait_newmsg_tip_text)).setTextColor(iNewMsgTipStyle.getTipTextColor());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dp2px(getContext(), 40));
        gradientDrawable.setStroke(dp2px(getContext(), 2), iNewMsgTipStyle.getTipBorderColor());
        gradientDrawable.setColor(iNewMsgTipStyle.getTipBgColor());
        view.findViewById(R.id.tips_root).setBackground(gradientDrawable);
        ((ImageView) view.findViewById(R.id.tip_arrow_icon)).setColorFilter(iNewMsgTipStyle.getTipTextColor());
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter
    public BaseChatListRecyclerViewAdapter createAdapter(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-399863322")) {
            return new AILPChatListRecyclerViewAdapter(context);
        }
        return (BaseChatListRecyclerViewAdapter) ipChange.ipc$dispatch("-399863322", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter
    public RecyclerView getChatRecyclerView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1214862511")) {
            return (RecyclerView) findViewById(R.id.portrait_chat_recyclerview);
        }
        return (RecyclerView) ipChange.ipc$dispatch("-1214862511", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter
    public TextView getNewMessageTextView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1575535647")) {
            return (TextView) findViewById(R.id.portrait_newmsg_tip_text);
        }
        return (TextView) ipChange.ipc$dispatch("-1575535647", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter
    public View getNewMessageTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "47603817")) {
            return findViewById(R.id.portrait_chat_newmsg_tip);
        }
        return (View) ipChange.ipc$dispatch("47603817", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter
    public View inflateLayout(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1041798207")) {
            return LayoutInflater.from(context).inflate(R.layout.dago_pgc_ailp_chat_list, this);
        }
        return (View) ipChange.ipc$dispatch("1041798207", new Object[]{this, context});
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public synchronized void insert(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1761673744")) {
            ipChange.ipc$dispatch("1761673744", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei", "insert");
        addMessage(new AILPChatBean(map));
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public synchronized void mergeLastMessage(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277046320")) {
            ipChange.ipc$dispatch("-277046320", new Object[]{this, map});
            return;
        }
        updateLastMessage(new AILPChatBean(map));
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public void setMaskLayer(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2075010207")) {
            ipChange.ipc$dispatch("2075010207", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.topMaskHeightScale = 0.0f;
        } else {
            try {
                this.topMaskHeightScale = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                this.topMaskHeightScale = 0.0f;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            this.topMaskStartAlpha = 0.0f;
            return;
        }
        try {
            this.topMaskStartAlpha = Float.parseFloat(str2);
        } catch (NumberFormatException unused2) {
            this.topMaskStartAlpha = 0.0f;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol
    public void setNewMsgTipStyle(AILPChatListProtocol.INewMsgTipStyle iNewMsgTipStyle) {
        AILPChatListProtocol.INewMsgTipStyle iNewMsgTipStyle2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341395364")) {
            ipChange.ipc$dispatch("341395364", new Object[]{this, iNewMsgTipStyle});
            return;
        }
        this.mStyle = iNewMsgTipStyle;
        View findViewById = findViewById(R.id.portrait_chat_newmsg_tip);
        if (findViewById != null && (iNewMsgTipStyle2 = this.mStyle) != null) {
            setTipStyle(findViewById, iNewMsgTipStyle2);
        }
    }

    public AILPChatListYoukuAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AILPChatListYoukuAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
