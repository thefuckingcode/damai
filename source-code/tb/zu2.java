package tb;

import cn.damai.category.venue.bean.VenueQueryResponse;
import cn.damai.category.venue.request.VenuesGetRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class zu2 extends c20 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a(int i, int i2, String str, String str2, String str3, int i3, DMMtopRequestListener<VenueQueryResponse> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481327716")) {
            ipChange.ipc$dispatch("-481327716", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), dMMtopRequestListener});
            return;
        }
        VenuesGetRequest venuesGetRequest = new VenuesGetRequest();
        venuesGetRequest.pageSize = i2;
        venuesGetRequest.pageNum = i;
        venuesGetRequest.cityId = str;
        venuesGetRequest.id = str3;
        venuesGetRequest.sortType = i3;
        if (!(str2 == null || d20.p() == null || !d20.p().contains(str2))) {
            venuesGetRequest.longitude = Double.valueOf(d20.o());
            venuesGetRequest.latitude = Double.valueOf(d20.n());
        }
        venuesGetRequest.request(dMMtopRequestListener);
    }
}
