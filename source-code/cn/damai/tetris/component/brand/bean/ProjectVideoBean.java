package cn.damai.tetris.component.brand.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ProjectVideoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String backgroundPic;
    private ProjectDO projectDO;
    private VideoDO videoDO;

    public String getBackgroundPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1448622381")) {
            return this.backgroundPic;
        }
        return (String) ipChange.ipc$dispatch("1448622381", new Object[]{this});
    }

    public ProjectDO getProjectDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "579763328")) {
            return this.projectDO;
        }
        return (ProjectDO) ipChange.ipc$dispatch("579763328", new Object[]{this});
    }

    public VideoDO getVideoDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1228539008")) {
            return this.videoDO;
        }
        return (VideoDO) ipChange.ipc$dispatch("1228539008", new Object[]{this});
    }

    public void setBackgroundPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88957161")) {
            ipChange.ipc$dispatch("88957161", new Object[]{this, str});
            return;
        }
        this.backgroundPic = str;
    }

    public void setProjectDO(ProjectDO projectDO2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083741076")) {
            ipChange.ipc$dispatch("-2083741076", new Object[]{this, projectDO2});
            return;
        }
        this.projectDO = projectDO2;
    }

    public void setVideoDO(VideoDO videoDO2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "146233640")) {
            ipChange.ipc$dispatch("146233640", new Object[]{this, videoDO2});
            return;
        }
        this.videoDO = videoDO2;
    }
}
