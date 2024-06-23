package com.youku.live.dago.widgetlib.ailpchat;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class MessageListener extends MessageDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    public MessageListener(List<String> list) {
        this.names = list;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.ailpchat.MessageDelegate
    public void dispatchReceiveMessage(ChatMessage chatMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772572530")) {
            ipChange.ipc$dispatch("1772572530", new Object[]{this, chatMessage});
            return;
        }
        super.dispatchReceiveMessage(chatMessage);
    }
}
