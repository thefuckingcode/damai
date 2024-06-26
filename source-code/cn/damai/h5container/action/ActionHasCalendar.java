package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import tb.xf2;

/* compiled from: Taobao */
public class ActionHasCalendar extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;
    int time_offset = 0;

    public ActionHasCalendar(Context context) {
        super(context);
    }

    private long getTime(WVCallBackContext wVCallBackContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043530490")) {
            return ((Long) ipChange.ipc$dispatch("-1043530490", new Object[]{this, wVCallBackContext, str})).longValue();
        }
        String param = getParam(str);
        if (xf2.j(param)) {
            wVCallBackContext.error(str + " error ");
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(param);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            return date.getTime();
        }
        wVCallBackContext.error(str + " error ");
        return 0;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542642032")) {
            return ((Boolean) ipChange.ipc$dispatch("1542642032", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        long time = getTime(wVCallBackContext, "calendar_start_datetime");
        int i = (time > 0 ? 1 : (time == 0 ? 0 : -1));
        if (i == 0) {
            return true;
        }
        String param = getParam("calendar_title");
        if (xf2.j(param)) {
            wVCallBackContext.error("calendar_title error ");
            return true;
        }
        Context context = this.contextReference;
        if ((context instanceof Activity) && context != null && !TextUtils.isEmpty(param) && i > 0) {
            boolean j = CalendarsResolver.i().j(this.contextReference, param, time);
            WVResult wVResult = new WVResult();
            wVResult.addData("hasAddedRemind", Boolean.valueOf(j));
            wVCallBackContext.success(wVResult);
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "472139806")) {
            return "hasCalendar";
        }
        return (String) ipChange.ipc$dispatch("472139806", new Object[]{this});
    }
}
