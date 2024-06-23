package com.alibaba.android.ultron.trade.extplugin;

import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import java.util.Map;

/* compiled from: Taobao */
public interface IExtInfoGetter {
    Map<String, ISubscriber> getSubscribers();
}
