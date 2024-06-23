package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.c$a;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b23 extends y23 {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i, Intent intent) {
        if (4103 != i && 4098 != i && 4108 != i) {
            return null;
        }
        BaseMode b = b(intent, i);
        x03.a(context, c$a.b, (DataMessage) b);
        return b;
    }

    public BaseMode b(Intent intent, int i) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(c23.f(intent.getStringExtra("messageID")));
            dataMessage.setTaskID(c23.f(intent.getStringExtra(TLogEventConst.PARAM_TASK_ID)));
            dataMessage.setGlobalId(c23.f(intent.getStringExtra("globalID")));
            dataMessage.setAppPackage(c23.f(intent.getStringExtra("appPackage")));
            dataMessage.setTitle(c23.f(intent.getStringExtra("title")));
            dataMessage.setContent(c23.f(intent.getStringExtra("content")));
            dataMessage.setDescription(c23.f(intent.getStringExtra(SocialConstants.PARAM_COMMENT)));
            String f = c23.f(intent.getStringExtra("notifyID"));
            int i2 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(f) ? 0 : Integer.parseInt(f));
            dataMessage.setMiniProgramPkg(c23.f(intent.getStringExtra("miniProgramPkg")));
            dataMessage.setMessageType(i);
            dataMessage.setEventId(c23.f(intent.getStringExtra("eventId")));
            dataMessage.setStatisticsExtra(c23.f(intent.getStringExtra("statistics_extra")));
            String f2 = c23.f(intent.getStringExtra("data_extra"));
            dataMessage.setDataExtra(f2);
            String c = c(f2);
            if (!TextUtils.isEmpty(c)) {
                i2 = Integer.parseInt(c);
            }
            dataMessage.setMsgCommand(i2);
            dataMessage.setBalanceTime(c23.f(intent.getStringExtra("balanceTime")));
            dataMessage.setStartDate(c23.f(intent.getStringExtra("startDate")));
            dataMessage.setEndDate(c23.f(intent.getStringExtra("endDate")));
            dataMessage.setTimeRanges(c23.f(intent.getStringExtra("timeRanges")));
            dataMessage.setRule(c23.f(intent.getStringExtra("rule")));
            dataMessage.setForcedDelivery(c23.f(intent.getStringExtra("forcedDelivery")));
            dataMessage.setDistinctContent(c23.f(intent.getStringExtra("distinctBycontent")));
            dataMessage.setAppId(c23.f(intent.getStringExtra("appID")));
            return dataMessage;
        } catch (Exception e) {
            w33.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("msg_command");
        } catch (JSONException e) {
            w33.a(e.getMessage());
            return "";
        }
    }
}
