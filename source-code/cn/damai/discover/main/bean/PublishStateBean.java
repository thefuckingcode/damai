package cn.damai.discover.main.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashSet;

/* compiled from: Taobao */
public class PublishStateBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_SHOW_PRIVILEGE_AND_PENDING_VALUATION = "3";
    public static final String TYPE_SHOW_PUBLISH_HAS_PENDING_VALUATION = "2";
    public static final String TYPE_SHOW_PUBLISH_PRIVILEGE = "1";
    public String appPublishHint;
    public String headerImage;
    public String publishType;
    public String themeId;
    public String themeName;

    private HashSet<String> getTypeCanShowPublish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1153315258")) {
            return (HashSet) ipChange.ipc$dispatch("1153315258", new Object[]{this});
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        return hashSet;
    }

    public boolean hasPendingValuation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "303429999")) {
            return TextUtils.equals("2", this.publishType);
        }
        return ((Boolean) ipChange.ipc$dispatch("303429999", new Object[]{this})).booleanValue();
    }

    public boolean hasPublishPrivilege() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-190707145")) {
            return TextUtils.equals("1", this.publishType);
        }
        return ((Boolean) ipChange.ipc$dispatch("-190707145", new Object[]{this})).booleanValue();
    }

    public boolean isNeedShowPublishBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459595")) {
            return ((Boolean) ipChange.ipc$dispatch("-1459595", new Object[]{this})).booleanValue();
        } else if (!TextUtils.isEmpty(this.publishType)) {
            return getTypeCanShowPublish().contains(this.publishType);
        } else {
            return false;
        }
    }
}
