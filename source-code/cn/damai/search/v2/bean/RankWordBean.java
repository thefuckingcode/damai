package cn.damai.search.v2.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.homepage.R$drawable;
import cn.damai.search.bean.IRankWordBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class RankWordBean implements IRankWordBean, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public int index;
    public String keyword;
    public String tagType;
    public String trend;
    public String type;
    public String url;

    private boolean isEquals(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2047072386")) {
            return TextUtils.equals(str, str2);
        }
        return ((Boolean) ipChange.ipc$dispatch("2047072386", new Object[]{this, str, str2})).booleanValue();
    }

    @Override // cn.damai.search.bean.IRankWordBean
    public String getRankWord() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1545143989")) {
            return this.keyword;
        }
        return (String) ipChange.ipc$dispatch("1545143989", new Object[]{this});
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r0.equals("1") == false) goto L_0x002e;
     */
    @Override // cn.damai.search.bean.IRankWordBean
    @Nullable
    public String getTag4Ut() {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1252607240")) {
            return (String) ipChange.ipc$dispatch("-1252607240", new Object[]{this});
        } else if (TextUtils.isEmpty(this.tagType)) {
            return null;
        } else {
            String str = this.tagType;
            str.hashCode();
            switch (str.hashCode()) {
                case 49:
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
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
                    return "新";
                case 1:
                    return "热";
                case 2:
                    return "爆";
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r0.equals("3") != false) goto L_0x004f;
     */
    public int getTagDrawableRid() {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "-465057377")) {
            return ((Integer) ipChange.ipc$dispatch("-465057377", new Object[]{this})).intValue();
        } else if (TextUtils.isEmpty(this.tagType)) {
            return R$drawable.icon_new;
        } else {
            String str = this.tagType;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                return R$drawable.icon_bao;
            }
            if (c != 1) {
                return R$drawable.icon_new;
            }
            return R$drawable.icon_hot;
        }
    }

    @Override // cn.damai.search.bean.IRankWordBean
    public String getTrend4Ut() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-954642283")) {
            return (String) ipChange.ipc$dispatch("-954642283", new Object[]{this});
        } else if (TextUtils.isEmpty(this.trend)) {
            return "-99";
        } else {
            return this.trend;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (r0.equals("1") != false) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    public int getTrendDrawableRid() {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "-803078302")) {
            return ((Integer) ipChange.ipc$dispatch("-803078302", new Object[]{this})).intValue();
        } else if (TextUtils.isEmpty(this.trend)) {
            return R$drawable.trend_normal;
        } else {
            String str = this.trend;
            int hashCode = str.hashCode();
            if (hashCode != 48) {
                if (hashCode != 49) {
                    if (hashCode == 1444 && str.equals("-1")) {
                        c = 1;
                        if (c == 0) {
                            return R$drawable.trend_up;
                        }
                        if (c != 1) {
                            return R$drawable.trend_normal;
                        }
                        return R$drawable.trend_down;
                    }
                }
            } else if (str.equals("0")) {
                c = 2;
                if (c == 0) {
                }
            }
            c = 65535;
            if (c == 0) {
            }
        }
    }

    @Override // cn.damai.search.bean.IRankWordBean
    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2118751385")) {
            return this.type;
        }
        return (String) ipChange.ipc$dispatch("2118751385", new Object[]{this});
    }

    public boolean isShowTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1128264808")) {
            return isEquals(this.tagType, "1") || isEquals(this.tagType, "2") || isEquals(this.tagType, "3");
        }
        return ((Boolean) ipChange.ipc$dispatch("1128264808", new Object[]{this})).booleanValue();
    }

    public boolean isShowTrend() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-152485563")) {
            return isEquals(this.trend, "-1") || isEquals(this.trend, "1") || isEquals(this.trend, "0");
        }
        return ((Boolean) ipChange.ipc$dispatch("-152485563", new Object[]{this})).booleanValue();
    }
}
