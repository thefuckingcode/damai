package com.youku.live.messagechannel.engine;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.messagechannel.channel.MCChannel;
import com.youku.live.messagechannel.channel.MCChannelInfo;
import com.youku.live.messagechannel.connection.Connector.AccsH5Connector;
import com.youku.live.messagechannel.utils.AppFrontBackHelper;
import com.youku.live.messagechannel.utils.HttpUtils;
import com.youku.live.messagechannel.utils.MyLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
public class MCEngine {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Map<Long, MCEngine> engineManager = new HashMap();
    private static MCEngineConfig overallMCEngineConfig = new MCEngineConfig();
    private final String TAG;
    private final long appId;
    private final Application application;
    private Map<String, MCChannel> channels;
    private MCEngineConfig mcEngineConfig;

    private MCEngine(Application application2, long j) {
        Mtop mtop;
        this.TAG = getClass().getName();
        this.channels = new ConcurrentHashMap();
        this.application = application2;
        this.appId = j;
        this.mcEngineConfig = overallMCEngineConfig;
        MyLog.setContext(application2);
        AppFrontBackHelper.getInstance().start(application2);
        MCEngineConfig mCEngineConfig = this.mcEngineConfig;
        if (mCEngineConfig == null || (mtop = mCEngineConfig.mtopInstance) == null) {
            HttpUtils.initMtop(Mtop.instance(Mtop.Id.INNER, application2.getApplicationContext()));
        } else {
            HttpUtils.initMtop(mtop);
        }
        AccsH5Connector.setApplication(application2);
    }

    public static void config(MCEngineConfig mCEngineConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436023426")) {
            ipChange.ipc$dispatch("436023426", new Object[]{mCEngineConfig});
            return;
        }
        overallMCEngineConfig = mCEngineConfig;
    }

    @Deprecated
    public static MCEngine getInstance(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123107757")) {
            return (MCEngine) ipChange.ipc$dispatch("-123107757", new Object[]{Long.valueOf(j)});
        } else if (j <= 0) {
            return null;
        } else {
            if (!engineManager.containsKey(Long.valueOf(j))) {
                synchronized (MCEngine.class) {
                    if (!engineManager.containsKey(Long.valueOf(j))) {
                        engineManager.put(Long.valueOf(j), new MCEngine(j));
                    }
                }
            }
            return engineManager.get(Long.valueOf(j));
        }
    }

    @Deprecated
    public MCChannel createChannel(Context context, String str) {
        Mtop mtop;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255331871")) {
            return (MCChannel) ipChange.ipc$dispatch("-1255331871", new Object[]{this, context, str});
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        MyLog.setContext(context.getApplicationContext());
        if (context.getApplicationContext() instanceof Application) {
            AppFrontBackHelper.getInstance().start((Application) context.getApplicationContext());
            AccsH5Connector.setApplication((Application) context.getApplicationContext());
        }
        MCEngineConfig mCEngineConfig = this.mcEngineConfig;
        if (mCEngineConfig == null || (mtop = mCEngineConfig.mtopInstance) == null) {
            HttpUtils.initMtop(Mtop.instance(Mtop.Id.INNER, context.getApplicationContext()));
        } else {
            HttpUtils.initMtop(mtop);
        }
        if (!this.channels.containsKey(str)) {
            synchronized (this) {
                if (!this.channels.containsKey(str)) {
                    this.channels.put(str, new MCChannel(context.getApplicationContext(), this.appId, str));
                }
            }
        }
        return this.channels.get(str);
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338975886")) {
            ipChange.ipc$dispatch("-338975886", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.channels.size(); i++) {
            this.channels.get(Integer.valueOf(i)).close();
        }
        this.channels.clear();
        engineManager.remove(Long.valueOf(this.appId));
        String str = this.TAG;
        MyLog.d(str, "Engine destroy success, appId:" + this.appId);
    }

    public void destroyChannel(MCChannel mCChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1979869585")) {
            ipChange.ipc$dispatch("-1979869585", new Object[]{this, mCChannel});
        } else if (mCChannel != null) {
            destroyChannel(mCChannel.getChannelId());
        }
    }

    public void destroyChannel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321218657")) {
            ipChange.ipc$dispatch("-321218657", new Object[]{this, str});
            return;
        }
        MCChannel remove = this.channels.remove(str);
        if (remove != null) {
            remove.close();
        }
    }

    public static MCEngine getInstance(Application application2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357295414")) {
            return (MCEngine) ipChange.ipc$dispatch("1357295414", new Object[]{application2, Long.valueOf(j)});
        } else if (application2 == null || j <= 0) {
            return null;
        } else {
            if (!engineManager.containsKey(Long.valueOf(j))) {
                synchronized (MCEngine.class) {
                    if (!engineManager.containsKey(Long.valueOf(j))) {
                        engineManager.put(Long.valueOf(j), new MCEngine(application2, j));
                    }
                }
            }
            return engineManager.get(Long.valueOf(j));
        }
    }

    private MCEngine(long j) {
        this.TAG = getClass().getName();
        this.channels = new ConcurrentHashMap();
        this.application = null;
        this.appId = j;
        this.mcEngineConfig = overallMCEngineConfig;
    }

    @Deprecated
    public MCChannel createChannel(Context context, MCChannelInfo mCChannelInfo) {
        Mtop mtop;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598887559")) {
            return (MCChannel) ipChange.ipc$dispatch("598887559", new Object[]{this, context, mCChannelInfo});
        }
        if (context == null || mCChannelInfo == null || mCChannelInfo.appId != this.appId || TextUtils.isEmpty(mCChannelInfo.channelId)) {
            return null;
        }
        MyLog.setContext(context.getApplicationContext());
        if (context.getApplicationContext() instanceof Application) {
            AppFrontBackHelper.getInstance().start((Application) context.getApplicationContext());
            AccsH5Connector.setApplication((Application) context.getApplicationContext());
        }
        MCEngineConfig mCEngineConfig = this.mcEngineConfig;
        if (mCEngineConfig == null || (mtop = mCEngineConfig.mtopInstance) == null) {
            HttpUtils.initMtop(Mtop.instance(Mtop.Id.INNER, context.getApplicationContext()));
        } else {
            HttpUtils.initMtop(mtop);
        }
        String str = mCChannelInfo.channelId;
        if (!this.channels.containsKey(str)) {
            synchronized (this) {
                if (!this.channels.containsKey(str)) {
                    this.channels.put(str, new MCChannel(context.getApplicationContext(), mCChannelInfo));
                }
            }
        }
        return this.channels.get(str);
    }

    public MCChannel createChannel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430625603")) {
            return (MCChannel) ipChange.ipc$dispatch("1430625603", new Object[]{this, str});
        } else if (this.application == null || TextUtils.isEmpty(str)) {
            return null;
        } else {
            if (!this.channels.containsKey(str)) {
                synchronized (this) {
                    if (!this.channels.containsKey(str)) {
                        this.channels.put(str, new MCChannel(this.application, this.appId, str));
                    }
                }
            }
            return this.channels.get(str);
        }
    }
}
