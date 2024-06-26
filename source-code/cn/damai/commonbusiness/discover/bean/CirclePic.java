package cn.damai.commonbusiness.discover.bean;

import android.text.TextUtils;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class CirclePic implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String pic;
    public VideoInfo videoInfo;

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "136547078")) {
            return (String) ipChange.ipc$dispatch("136547078", new Object[]{this});
        } else if (isUseVideoPic()) {
            return this.videoInfo.coverUrl;
        } else {
            return this.pic;
        }
    }

    public boolean isUseVideoPic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751414157")) {
            return ((Boolean) ipChange.ipc$dispatch("751414157", new Object[]{this})).booleanValue();
        }
        VideoInfo videoInfo2 = this.videoInfo;
        return videoInfo2 != null && !TextUtils.isEmpty(videoInfo2.coverUrl);
    }
}
