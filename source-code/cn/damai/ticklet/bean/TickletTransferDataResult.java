package cn.damai.ticklet.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.xf2;

/* compiled from: Taobao */
public class TickletTransferDataResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ALLOW_TRANSFER_SATAE = "1";
    public static final String NO_ALLOW_TRANSFER_SATAE = "0";
    private static final long serialVersionUID = 1;
    public String alipaySwitch;
    public ArrayList<TickletTransferManagerListExtra> alreadyTransferList;
    public ArrayList<TickletTransferManagerListExtra> canTransferList;
    public ArrayList<TickletTransferManagerListExtra> ongoingTransferList;
    public String performId;
    public String performName;
    public String projectImage;
    public String projectName;
    public String serverTimestamp;
    public Tips transferProtocolTips;
    public String transferState;
    public Tips transferTips;
    public int transferableNum;
    public String wechatSwitch;

    public boolean isAlreadyNotEmptyList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1794520050")) {
            return xf2.e(this.alreadyTransferList) > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1794520050", new Object[]{this})).booleanValue();
    }

    public boolean isCanTransferNotEmptyList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "896978859")) {
            return xf2.e(this.canTransferList) > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("896978859", new Object[]{this})).booleanValue();
    }

    public boolean isNotEmptyList() {
        Tips tips;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155989220")) {
            return ((Boolean) ipChange.ipc$dispatch("-1155989220", new Object[]{this})).booleanValue();
        }
        if ((!"1".equals(this.transferState) || (!isCanTransferNotEmptyList() && !isRunningNotEmptyList() && !isAlreadyNotEmptyList() && ((tips = this.transferTips) == null || TextUtils.isEmpty(tips.getText())))) && !"0".equals(this.transferState)) {
            return false;
        }
        return true;
    }

    public boolean isRunningNotEmptyList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "11668423")) {
            return xf2.e(this.ongoingTransferList) > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("11668423", new Object[]{this})).booleanValue();
    }
}
