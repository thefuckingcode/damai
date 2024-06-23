package cn.damai.tetris.component.drama.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.f92;
import tb.lk1;

/* compiled from: Taobao */
public class DramaV1Bean implements IDramaBean, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String briefIntroduction;
    public List<String> citys;
    public boolean focus;
    public String id;
    public int indexInTab;
    public String ipvuv;
    public String itemScore;
    public String itemStar;
    public String pic;
    public String subType;
    public int tabIndex;
    public List<String> tags;
    public String tempLabelName;
    public String title;

    public static String getContactStr(List<String> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2057066313")) {
            return getContactStr(list, " | ");
        }
        return (String) ipChange.ipc$dispatch("2057066313", new Object[]{list});
    }

    @Override // cn.damai.tetris.component.drama.bean.IDramaBean
    public String getDramaId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-456780657")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("-456780657", new Object[]{this});
    }

    public long getIpvuvValue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1918646038")) {
            return lk1.k(this.ipvuv, -1);
        }
        return ((Long) ipChange.ipc$dispatch("-1918646038", new Object[]{this})).longValue();
    }

    public double getScoreValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290531226")) {
            return ((Double) ipChange.ipc$dispatch("-1290531226", new Object[]{this})).doubleValue();
        } else if (TextUtils.isEmpty(this.itemScore)) {
            return -1.0d;
        } else {
            try {
                return Double.parseDouble(this.itemScore);
            } catch (Exception e) {
                e.printStackTrace();
                return -1.0d;
            }
        }
    }

    public boolean isMusicIpType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "232732437")) {
            return TextUtils.equals("音乐节", this.subType);
        }
        return ((Boolean) ipChange.ipc$dispatch("232732437", new Object[]{this})).booleanValue();
    }

    public static String getContactStr(List<String> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584007041")) {
            return (String) ipChange.ipc$dispatch("-584007041", new Object[]{list, str});
        } else if (f92.d(list)) {
            return null;
        } else {
            if (list.size() == 1) {
                return list.get(0);
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            int size = list.size();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < size) {
                String str2 = list.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                    if (!(i == size + -1)) {
                        sb.append(str);
                    }
                }
                i++;
            }
            return sb.toString();
        }
    }
}
