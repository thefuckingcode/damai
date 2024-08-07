package com.youku.live.livesdk.widgets.container.pager.model;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.widgets.model.template.TemplateModel;
import java.io.Serializable;

/* compiled from: Taobao */
public class SwitchItemModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int _biztype;
    public String _cover;
    public LiveFullInfoData _fullInfoData;
    public JSONObject _fullInfoJson;
    public boolean _isLaifeng;
    public boolean _landscape;
    public String _layout;
    public String _layoutLandscape;
    public TemplateModel _layoutModel;
    public String _layoutPortrait;
    public String _static;
    public String _taskId;
    public LiveInfoModel liveInfo;
    public LiveQuickPlayModel liveQuickPlay;
    public String roomId;
    public UserDataModel userData = new UserDataModel();

    /* compiled from: Taobao */
    public static class UserDataModel implements Serializable {
        public String livePerformanceId;
        public String liveSessionId;
    }

    private UserDataModel getUserData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1293430453")) {
            return (UserDataModel) ipChange.ipc$dispatch("-1293430453", new Object[]{this});
        }
        if (this.userData == null) {
            synchronized (this) {
                if (this.userData == null) {
                    this.userData = new UserDataModel();
                }
            }
        }
        return this.userData;
    }

    public String getLivePerformanceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "829127778")) {
            return getUserData().livePerformanceId;
        }
        return (String) ipChange.ipc$dispatch("829127778", new Object[]{this});
    }

    public String getLiveSessionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2089661512")) {
            return getUserData().liveSessionId;
        }
        return (String) ipChange.ipc$dispatch("2089661512", new Object[]{this});
    }

    public boolean hasLivePerformanceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-583340730")) {
            return !TextUtils.isEmpty(getLivePerformanceId());
        }
        return ((Boolean) ipChange.ipc$dispatch("-583340730", new Object[]{this})).booleanValue();
    }

    public boolean hasLiveSessionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1119070560")) {
            return !TextUtils.isEmpty(getLiveSessionId());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1119070560", new Object[]{this})).booleanValue();
    }

    public void setLivePerformanceId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944152148")) {
            ipChange.ipc$dispatch("944152148", new Object[]{this, str});
            return;
        }
        getUserData().livePerformanceId = str;
    }

    public void setLiveSessionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1513666258")) {
            ipChange.ipc$dispatch("-1513666258", new Object[]{this, str});
            return;
        }
        getUserData().liveSessionId = str;
    }
}
