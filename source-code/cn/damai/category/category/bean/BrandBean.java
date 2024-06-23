package cn.damai.category.category.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class BrandBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 7089511813257803149L;
    public int cardIndex;
    public String categoryName;
    public String cityName;
    public String guideSubCategoryName;
    public String id;
    public boolean isVideoSupport;
    public double itemScore = 0.0d;
    public int itemStar = -1;
    public String liveStartTime;
    public int liveStatus;
    public String name;
    public int position;
    public String priceLow;
    public String schema;
    public BrandStatusBean showStatus;
    public String showTag;
    public String verticalPic;
    public int viewType = 8;

    public String getCategoryNameCompat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124102823")) {
            return (String) ipChange.ipc$dispatch("124102823", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.guideSubCategoryName)) {
            return this.guideSubCategoryName;
        } else {
            return this.categoryName;
        }
    }
}
