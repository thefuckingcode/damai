package cn.damai.search.component.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class SearchScriptCouponBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<String> highlightWord;
    @Nullable
    private String priceLow;
    @Nullable
    private String projectId;
    @Nullable
    private String projectName;
    @Nullable
    private String projectPic;
    @Nullable
    private String schema;
    @Nullable
    private ArrayList<String> scriptNameList;
    private final long serialVersionUID = 1;
    @Nullable
    private String storeName;

    @Nullable
    public final String buildDesc() {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "2087274780")) {
            return (String) ipChange.ipc$dispatch("2087274780", new Object[]{this});
        }
        ArrayList<String> arrayList = this.scriptNameList;
        if (arrayList == null || arrayList.isEmpty()) {
            return this.storeName;
        }
        ArrayList<String> arrayList2 = this.scriptNameList;
        if (!(arrayList2 == null || (str = arrayList2.get(0)) == null)) {
            String str3 = this.storeName;
            if (!(str3 == null || str3.length() == 0)) {
                z = false;
            }
            if (z) {
                str2 = (char) 12298 + str + (char) 12299;
            } else {
                StringBuilder sb = new StringBuilder((char) 12298 + str + (char) 12299);
                sb.append("/ ");
                sb.append(this.storeName);
                str2 = sb.toString();
                k21.h(str2, "{\n                String….toString()\n            }");
            }
            if (str2 != null) {
                return str2;
            }
        }
        return this.storeName;
    }

    @Nullable
    public final ArrayList<String> getHighlightWord() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-800313383")) {
            return this.highlightWord;
        }
        return (ArrayList) ipChange.ipc$dispatch("-800313383", new Object[]{this});
    }

    @Nullable
    public final String getPriceLow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1492208578")) {
            return this.priceLow;
        }
        return (String) ipChange.ipc$dispatch("-1492208578", new Object[]{this});
    }

    @Nullable
    public final String getProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-466642377")) {
            return this.projectId;
        }
        return (String) ipChange.ipc$dispatch("-466642377", new Object[]{this});
    }

    @Nullable
    public final String getProjectName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1695842457")) {
            return this.projectName;
        }
        return (String) ipChange.ipc$dispatch("-1695842457", new Object[]{this});
    }

    @Nullable
    public final String getProjectPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1768006236")) {
            return this.projectPic;
        }
        return (String) ipChange.ipc$dispatch("-1768006236", new Object[]{this});
    }

    @Nullable
    public final String getSchema() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "836658068")) {
            return this.schema;
        }
        return (String) ipChange.ipc$dispatch("836658068", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getScriptNameList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-547668749")) {
            return this.scriptNameList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-547668749", new Object[]{this});
    }

    @Nullable
    public final String getStoreName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "438569775")) {
            return this.storeName;
        }
        return (String) ipChange.ipc$dispatch("438569775", new Object[]{this});
    }

    public final void setHighlightWord(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008815615")) {
            ipChange.ipc$dispatch("2008815615", new Object[]{this, arrayList});
            return;
        }
        this.highlightWord = arrayList;
    }

    public final void setPriceLow(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103846496")) {
            ipChange.ipc$dispatch("1103846496", new Object[]{this, str});
            return;
        }
        this.priceLow = str;
    }

    public final void setProjectId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748750623")) {
            ipChange.ipc$dispatch("748750623", new Object[]{this, str});
            return;
        }
        this.projectId = str;
    }

    public final void setProjectName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "963507439")) {
            ipChange.ipc$dispatch("963507439", new Object[]{this, str});
            return;
        }
        this.projectName = str;
    }

    public final void setProjectPic(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083501894")) {
            ipChange.ipc$dispatch("-1083501894", new Object[]{this, str});
            return;
        }
        this.projectPic = str;
    }

    public final void setSchema(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228495670")) {
            ipChange.ipc$dispatch("-1228495670", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public final void setScriptNameList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861313091")) {
            ipChange.ipc$dispatch("-861313091", new Object[]{this, arrayList});
            return;
        }
        this.scriptNameList = arrayList;
    }

    public final void setStoreName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254443737")) {
            ipChange.ipc$dispatch("-1254443737", new Object[]{this, str});
            return;
        }
        this.storeName = str;
    }
}
