package cn.damai.tetris.component.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class AccountBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String additionDescription;
    private String headPic;
    private String id;
    private String name;
    private String schema;
    private String type;

    public String getAdditionDescription() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1468925352")) {
            return this.additionDescription;
        }
        return (String) ipChange.ipc$dispatch("-1468925352", new Object[]{this});
    }

    public String getHeadPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1329463554")) {
            return this.headPic;
        }
        return (String) ipChange.ipc$dispatch("1329463554", new Object[]{this});
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2072505703")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("-2072505703", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1257727817")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("1257727817", new Object[]{this});
    }

    public String getSchema() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1421142687")) {
            return this.schema;
        }
        return (String) ipChange.ipc$dispatch("1421142687", new Object[]{this});
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1153937800")) {
            return this.type;
        }
        return (String) ipChange.ipc$dispatch("-1153937800", new Object[]{this});
    }

    public void setAdditionDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-912323554")) {
            ipChange.ipc$dispatch("-912323554", new Object[]{this, str});
            return;
        }
        this.additionDescription = str;
    }

    public void setHeadPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942410932")) {
            ipChange.ipc$dispatch("942410932", new Object[]{this, str});
            return;
        }
        this.headPic = str;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981815195")) {
            ipChange.ipc$dispatch("-981815195", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "42099893")) {
            ipChange.ipc$dispatch("42099893", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289341665")) {
            ipChange.ipc$dispatch("-289341665", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705090202")) {
            ipChange.ipc$dispatch("-1705090202", new Object[]{this, str});
            return;
        }
        this.type = str;
    }
}
