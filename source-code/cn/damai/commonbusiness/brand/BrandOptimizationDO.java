package cn.damai.commonbusiness.brand;

import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class BrandOptimizationDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TYPE_COMING_PERFORMANCE = "3";
    private static final String TYPE_MOST_HOT = "1";
    private static final String TYPE_NEW_SALE = "2";
    public static final long serialVersionUID = 6813053541929103067L;
    public String city;
    public String cover;
    public String id;
    public String itemName;
    public String lable;
    public boolean local;
    public String schema;
    public String tagUrl;
    public String type;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r0.equals("2") == false) goto L_0x0024;
     */
    private DMLabelType getDMLabelType() {
        IpChange ipChange = $ipChange;
        char c = 1;
        if (AndroidInstantRuntime.support(ipChange, "1883753418")) {
            return (DMLabelType) ipChange.ipc$dispatch("1883753418", new Object[]{this});
        }
        String str = this.type;
        str.hashCode();
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 50:
                break;
            case 51:
                if (str.equals("3")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return DMLabelType.LABEL_TYPE_HIGHEST_HOT;
            case 1:
                return DMLabelType.LABEL_TYPE_NEW_SALE;
            case 2:
                return DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE;
            default:
                return null;
        }
    }

    public void updatePosterView(DMPosterView dMPosterView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408890430")) {
            ipChange.ipc$dispatch("-1408890430", new Object[]{this, dMPosterView});
        } else if (dMPosterView != null) {
            dMPosterView.setImageUrl(this.cover);
            dMPosterView.setCategoryTagName(this.city);
            dMPosterView.setLabelType(getDMLabelType());
        }
    }
}
