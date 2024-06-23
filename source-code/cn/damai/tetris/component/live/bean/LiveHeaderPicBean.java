package cn.damai.tetris.component.live.bean;

import android.text.TextUtils;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.uikit.scrollsky.BarrageBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class LiveHeaderPicBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 5601537497842716085L;
    public List<BarrageBean> barrage;
    public String contentCount;
    public String ipvuv;
    public String themeId;
    public String themeName;
    public String[] themePic;
    public VideoInfo videoInfo;

    public boolean isShowVideoIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618351084")) {
            return ((Boolean) ipChange.ipc$dispatch("618351084", new Object[]{this})).booleanValue();
        }
        VideoInfo videoInfo2 = this.videoInfo;
        return videoInfo2 != null && !TextUtils.isEmpty(videoInfo2.url) && !TextUtils.isEmpty(this.videoInfo.coverUrl);
    }
}
