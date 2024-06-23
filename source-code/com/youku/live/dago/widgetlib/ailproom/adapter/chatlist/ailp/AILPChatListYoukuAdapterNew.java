package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListRecyclerViewAdapter;

/* compiled from: Taobao */
public class AILPChatListYoukuAdapterNew extends AILPChatListYoukuAdapter {
    private static transient /* synthetic */ IpChange $ipChange;

    public AILPChatListYoukuAdapterNew(@NonNull Context context) {
        super(context);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter, com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.AILPChatListYoukuAdapter
    public BaseChatListRecyclerViewAdapter createAdapter(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1869620612")) {
            return new AILPChatListRecyclerViewAdapterNew(context);
        }
        return (BaseChatListRecyclerViewAdapter) ipChange.ipc$dispatch("-1869620612", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078014876")) {
            ipChange.ipc$dispatch("-2078014876", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
    }

    public AILPChatListYoukuAdapterNew(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public AILPChatListYoukuAdapterNew(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }
}
