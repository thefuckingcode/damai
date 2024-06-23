package cn.damai.musicfestival.model;

import android.text.TextUtils;
import cn.damai.tetris.request.TetrisParams;
import cn.damai.tetris.v2.common.ContainerArg;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class MusicFestivalParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    public String comboDamaiCityId = d20.c();
    @JSONField(serialize = false)
    public String outPatternName;
    @JSONField(serialize = false)
    public String outPatternVersion;
    public String pageNum;
    public String pageSize = "15";

    public MusicFestivalParams() {
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1197168640")) {
            return !TextUtils.isEmpty(this.outPatternName) ? this.outPatternName : "festivalHomePage";
        }
        return (String) ipChange.ipc$dispatch("-1197168640", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252219165")) {
            return (String) ipChange.ipc$dispatch("252219165", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.outPatternVersion)) {
            return this.outPatternVersion;
        } else {
            return super.getVersion();
        }
    }

    public MusicFestivalParams(int i) {
        this.pageNum = i + "";
    }

    public MusicFestivalParams(int i, ContainerArg containerArg) {
        this.pageNum = i + "";
        if (containerArg != null) {
            this.outPatternName = containerArg.patternName;
            this.outPatternVersion = containerArg.patternVersion;
        }
    }
}
