package cn.damai.discover.main.request;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import java.util.Set;
import tb.f92;

/* compiled from: Taobao */
public class BatchFollowRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String operateType;
    public String targets;

    public BatchFollowRequest(boolean z, Map<String, String> map) {
        this.operateType = z ? "1" : "0";
        if (!f92.f(map)) {
            Set<String> keySet = map.keySet();
            StringBuilder sb = new StringBuilder();
            for (String str : keySet) {
                String[] trySplitValue = trySplitValue(map.get(str));
                if (trySplitValue != null && trySplitValue.length > 0) {
                    for (String str2 : trySplitValue) {
                        sb.append(str);
                        sb.append(":");
                        sb.append(str2);
                        sb.append(",");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            this.targets = sb.toString();
        }
    }

    private String[] trySplitValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211891419")) {
            return (String[]) ipChange.ipc$dispatch("-211891419", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            return str.split(",");
        } else {
            return null;
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1767182717")) {
            return "mtop.damai.wireless.follow.relation.update.batch";
        }
        return (String) ipChange.ipc$dispatch("-1767182717", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-54806518")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-54806518", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "85435910")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("85435910", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "400554006")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("400554006", new Object[]{this});
    }
}
