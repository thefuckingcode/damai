package cn.damai.ticklet.broadcast;

import android.os.Handler;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.ticklet.bean.QueryPerformListResultEntryData;
import cn.damai.ticklet.manager.DataHelper;
import cn.damai.ticklet.net.TickletPreloadRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.time.DateUtils;
import tb.gl2;
import tb.vl2;

/* compiled from: Taobao */
public class TicketSyncHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    public static void c(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "89306902")) {
            ipChange.ipc$dispatch("89306902", new Object[]{str});
            return;
        }
        TickletPreloadRequest tickletPreloadRequest = new TickletPreloadRequest();
        AnonymousClass2 r1 = new DMMtopRequestListener<QueryPerformListResultEntryData>(QueryPerformListResultEntryData.class) {
            /* class cn.damai.ticklet.broadcast.TicketSyncHelper.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1516116561")) {
                    ipChange.ipc$dispatch("1516116561", new Object[]{this, str, str2});
                    return;
                }
                TicketSyncHelper.e(str, "预加载接口来源：" + str + " " + str2);
            }

            public void onSuccess(QueryPerformListResultEntryData queryPerformListResultEntryData) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-16503008")) {
                    ipChange.ipc$dispatch("-16503008", new Object[]{this, queryPerformListResultEntryData});
                    return;
                }
                DataHelper.getInstance().saveOrUpdatePerformTables(queryPerformListResultEntryData.getUserPerformVOList(), gl2.a);
            }
        };
        tickletPreloadRequest.showLoginUI(false);
        tickletPreloadRequest.request(r1);
    }

    private static void d(Boolean bool, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774070395")) {
            ipChange.ipc$dispatch("1774070395", new Object[]{bool, str});
        } else if (bool.booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.ticklet.broadcast.TicketSyncHelper.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1527378170")) {
                        ipChange.ipc$dispatch("-1527378170", new Object[]{this});
                        return;
                    }
                    TicketSyncHelper.c(str);
                }
            }, DateUtils.MILLIS_PER_MINUTE);
        } else {
            c(str);
        }
    }

    /* access modifiers changed from: private */
    public static void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652917367")) {
            ipChange.ipc$dispatch("1652917367", new Object[]{str, str2});
            return;
        }
        vl2.d(vl2.f(vl2.TICKLET_PRELOAD_NETWORK_ERROR_MSG, "mtop.damai.wireless.ticklet2.performs.preload", str, str2, null), vl2.TICKLET_PRELOAD_NETWORK_ERROR_CODE, str, vl2.TICKLET_PRELOAD_NETWORK_ERROR_MSG);
    }

    public static void f(Boolean bool, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111117854")) {
            ipChange.ipc$dispatch("-2111117854", new Object[]{bool, str});
            return;
        }
        d(bool, str);
    }
}
