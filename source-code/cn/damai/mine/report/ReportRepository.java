package cn.damai.mine.report;

import android.content.Context;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.homepage.R$array;
import cn.damai.mine.report.bean.ReportReason;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.xz1;

/* compiled from: Taobao */
public class ReportRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ReportRepository a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1755007997") ? (ReportRepository) ipChange.ipc$dispatch("-1755007997", new Object[0]) : new ReportRepository();
    }

    public List<ReportReason> b(Context context) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "963579")) {
            return (List) ipChange.ipc$dispatch("963579", new Object[]{this, context});
        }
        ArrayList arrayList = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(R$array.report_type_string);
        while (i < stringArray.length) {
            ReportReason reportReason = new ReportReason();
            reportReason.reasonStr = stringArray[i];
            i++;
            reportReason.reasonType = i;
            arrayList.add(reportReason);
        }
        return arrayList;
    }

    public void c(String str, int i, int i2, int i3, String str2, String str3, final xz1 xz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239245587")) {
            ipChange.ipc$dispatch("-239245587", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, xz1});
            return;
        }
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.extraInfo = str3;
        reportRequest.reason = str2;
        reportRequest.reasonType = i3;
        reportRequest.targetId = str;
        reportRequest.targetType = i2;
        reportRequest.type = i;
        reportRequest.request(new DMMtopRequestListener<ReportResponse>(ReportResponse.class) {
            /* class cn.damai.mine.report.ReportRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-975303303")) {
                    ipChange.ipc$dispatch("-975303303", new Object[]{this, str, str2});
                    return;
                }
                xz1.a(str, str2);
            }

            public void onSuccess(ReportResponse reportResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2127509454")) {
                    ipChange.ipc$dispatch("2127509454", new Object[]{this, reportResponse});
                    return;
                }
                xz1.b(reportResponse);
            }
        });
    }
}
