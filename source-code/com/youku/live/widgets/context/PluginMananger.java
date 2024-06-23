package com.youku.live.widgets.context;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IPluginMananger;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
public class PluginMananger implements IDestroyable, IPluginMananger {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, Queue<IPlugin>> cache;
    private volatile boolean destroyed = false;

    private Map<String, Queue<IPlugin>> getCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104795125")) {
            return (Map) ipChange.ipc$dispatch("104795125", new Object[]{this});
        }
        if (this.cache == null) {
            synchronized (this) {
                if (this.cache == null) {
                    this.cache = new ConcurrentHashMap();
                }
            }
        }
        return this.cache;
    }

    private Queue<IPlugin> getElements(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581885413")) {
            return (Queue) ipChange.ipc$dispatch("-1581885413", new Object[]{this, str});
        }
        Map<String, Queue<IPlugin>> cache2 = getCache();
        Queue<IPlugin> queue = cache2.get(str);
        if (queue != null) {
            return queue;
        }
        synchronized (this) {
            if (cache2.get(str) == null) {
                cache2.put(str, new ConcurrentLinkedQueue());
            }
        }
        return cache2.get(str);
    }

    @Override // com.youku.live.widgets.protocol.IPluginMananger
    public IPlugin createPlugin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130959332")) {
            return (IPlugin) ipChange.ipc$dispatch("2130959332", new Object[]{this, str});
        } else if (!this.destroyed && !TextUtils.isEmpty(str)) {
            return getElements(str).poll();
        } else {
            return null;
        }
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630633788")) {
            ipChange.ipc$dispatch("-630633788", new Object[]{this});
            return;
        }
        this.destroyed = true;
        Map<String, Queue<IPlugin>> cache2 = getCache();
        if (cache2 != null) {
            for (Map.Entry<String, Queue<IPlugin>> entry : cache2.entrySet()) {
                Queue<IPlugin> value = entry.getValue();
                if (value != null) {
                    for (IPlugin iPlugin : value) {
                        if (iPlugin instanceof BasePlugin) {
                            BasePlugin basePlugin = (BasePlugin) iPlugin;
                            basePlugin.mRecycled = false;
                            basePlugin.destroyImp();
                        }
                    }
                    value.clear();
                }
            }
            cache2.clear();
        }
    }

    @Override // com.youku.live.widgets.protocol.IPluginMananger
    public boolean releaseInstance(IPlugin iPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-600511601")) {
            return ((Boolean) ipChange.ipc$dispatch("-600511601", new Object[]{this, iPlugin})).booleanValue();
        } else if (this.destroyed || !(iPlugin instanceof BasePlugin)) {
            return false;
        } else {
            String str = ((BasePlugin) iPlugin).name;
            if (str != null) {
                getElements(str).add(iPlugin);
            } else {
                iPlugin.destroy();
            }
            return true;
        }
    }
}
