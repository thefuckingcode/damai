package tb;

import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.badge.cache.FileCache;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class m9 {
    private static transient /* synthetic */ IpChange $ipChange;
    private gc1<String, BadgeNodeItem> a = new gc1<>(100);
    private FileCache b = new FileCache();

    private String d(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "382847670")) {
            return n9.b(str);
        }
        return (String) ipChange.ipc$dispatch("382847670", new Object[]{this, str});
    }

    public boolean a(BadgeNodeItem badgeNodeItem) {
        BadgeNodeItem d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275349483")) {
            return ((Boolean) ipChange.ipc$dispatch("-275349483", new Object[]{this, badgeNodeItem})).booleanValue();
        }
        if (badgeNodeItem == null || (d = this.a.d(d(badgeNodeItem.getNodeId()))) == null || d.getVersion() <= badgeNodeItem.getVersion()) {
            return true;
        }
        return false;
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "452173268")) {
            ipChange.ipc$dispatch("452173268", new Object[]{this});
            return;
        }
        this.a.a();
    }

    public BadgeNodeItem c(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1816670980")) {
            return this.a.d(d(str));
        }
        return (BadgeNodeItem) ipChange.ipc$dispatch("1816670980", new Object[]{this, str});
    }

    public BadgeNodeItem e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097257591")) {
            return (BadgeNodeItem) ipChange.ipc$dispatch("2097257591", new Object[]{this, str});
        } else if (str == null) {
            return null;
        } else {
            BadgeNodeItem d = this.a.d(d(str));
            if (d == null) {
                try {
                    d = (BadgeNodeItem) JSON.parseObject(this.b.a(d(str), ""), BadgeNodeItem.class);
                } catch (Throwable th) {
                    v91.b("BadgeCacheManager", th);
                }
                if (d != null) {
                    this.a.e(d(str), d);
                }
            }
            return d;
        }
    }

    public void f(BadgeNodeItem badgeNodeItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1544923977")) {
            ipChange.ipc$dispatch("1544923977", new Object[]{this, badgeNodeItem});
        } else if (badgeNodeItem != null && badgeNodeItem.getNodeId() != null) {
            BadgeNodeItem d = this.a.d(d(badgeNodeItem.getNodeId()));
            if (d == null) {
                try {
                    d = (BadgeNodeItem) JSON.parseObject(this.b.a(d(badgeNodeItem.getNodeId()), ""), BadgeNodeItem.class);
                } catch (Throwable th) {
                    v91.a("BadgeCacheManager", th.getMessage());
                }
            }
            String str = "BUBBLE";
            if ((d == null || d.getCount() == 0) && badgeNodeItem.getCount() > 0) {
                HashMap hashMap = new HashMap();
                if (badgeNodeItem.getStyle() == 1) {
                    str = "POINT";
                } else if (badgeNodeItem.getStyle() != 0) {
                    str = "TEXT";
                }
                hashMap.put("style", str);
                hashMap.put("nodeId", badgeNodeItem.getNodeId());
                r9.a("BadgeNodeShow", hashMap);
            } else if (d != null && d.getCount() > 0 && badgeNodeItem.getCount() == 0) {
                HashMap hashMap2 = new HashMap();
                if (d.getStyle() == 1) {
                    str = "POINT";
                } else if (d.getStyle() != 0) {
                    str = "TEXT";
                }
                hashMap2.put("style", str);
                hashMap2.put("nodeId", d.getNodeId());
                r9.a("BadgeNodeHidden", hashMap2);
            }
            if (d == null || d.getVersion() < badgeNodeItem.getVersion()) {
                this.b.c(d(badgeNodeItem.getNodeId()), JSON.toJSONString(badgeNodeItem));
                this.a.e(d(badgeNodeItem.getNodeId()), badgeNodeItem);
            }
        }
    }
}
