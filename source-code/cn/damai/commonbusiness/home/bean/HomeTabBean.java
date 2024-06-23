package cn.damai.commonbusiness.home.bean;

import android.text.TextUtils;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.s41;

/* compiled from: Taobao */
public class HomeTabBean extends ScrollTitleBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -7339062201853406814L;
    public String args;
    public String categoryId;
    public int distance;
    public String groupId;
    public HomeHeaderBg homeHeaderBg;
    public int isShowFilter;
    public String patternName;
    public String patternVersion;
    public String spmb;
    public int type;

    /* compiled from: Taobao */
    public static class Args implements Serializable {
        public String categoryId;
        public String groupId;
    }

    public JSONObject getObjArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139339021")) {
            return (JSONObject) ipChange.ipc$dispatch("2139339021", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.args)) {
            return JSON.parseObject(this.args);
        } else {
            return null;
        }
    }

    public Args parseArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442329475")) {
            return (Args) ipChange.ipc$dispatch("442329475", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.args)) {
            return (Args) s41.a(this.args, Args.class);
        } else {
            return new Args();
        }
    }
}
