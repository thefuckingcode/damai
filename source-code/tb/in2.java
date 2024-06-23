package tb;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.DamaiConstants;
import cn.damai.issue.tool.IssueConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class in2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long a(Bundle bundle) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1671487491")) {
            return ((Long) ipChange.ipc$dispatch("1671487491", new Object[]{bundle})).longValue();
        }
        String b = b(bundle);
        if (TextUtils.isEmpty(b) || (obj = bundle.get(b)) == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Long.parseLong((String) obj);
            }
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            return 0;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String b(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527246066")) {
            return (String) ipChange.ipc$dispatch("1527246066", new Object[]{bundle});
        } else if (bundle.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
            return DamaiConstants.PUSH_MSG_SUMMARY;
        } else {
            if (bundle.containsKey(IssueConstants.ProjectID)) {
                return IssueConstants.ProjectID;
            }
            if (bundle.containsKey("projectId")) {
                return "projectId";
            }
            if (bundle.containsKey("id")) {
                return "id";
            }
            if (bundle.containsKey("itemId")) {
                return "itemId";
            }
            return "";
        }
    }
}
