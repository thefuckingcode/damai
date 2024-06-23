package cn.damai.wxapi.sinamodel;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class StatusList {
    private static transient /* synthetic */ IpChange $ipChange;
    public Object[] advertises;
    public boolean hasvisible;
    public String next_cursor;
    public String previous_cursor;
    public ArrayList<Status> statusList;
    public Status statuses;
    public int total_number;

    public static StatusList parse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1270469195")) {
            return (StatusList) ipChange.ipc$dispatch("-1270469195", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            StatusList statusList2 = new StatusList();
            try {
                JSONObject jSONObject = new JSONObject(str);
                statusList2.hasvisible = jSONObject.optBoolean("hasvisible", false);
                statusList2.previous_cursor = jSONObject.optString("previous_cursor", "0");
                statusList2.next_cursor = jSONObject.optString("next_cursor", "0");
                statusList2.total_number = jSONObject.optInt("total_number", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("statuses");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    statusList2.statusList = new ArrayList<>(length);
                    for (int i = 0; i < length; i++) {
                        statusList2.statusList.add(Status.parse(optJSONArray.getJSONObject(i)));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return statusList2;
        }
    }
}
