package cn.damai.trade.newtradeorder.ui.projectdetail.venuemap;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenueContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VenuePresenter extends VenueContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenueContract.Presenter
    public void retrieveVenueDetailInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702924191")) {
            ipChange.ipc$dispatch("1702924191", new Object[]{this, str});
            return;
        }
        VenueMapRequest venueMapRequest = new VenueMapRequest();
        venueMapRequest.venueId = str;
        venueMapRequest.request(new DMMtopRequestListener<Venue>(Venue.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenuePresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1155764519")) {
                    ipChange.ipc$dispatch("1155764519", new Object[]{this, str, str2});
                    return;
                }
                VenuePresenter.this.mView.onRetrieveVenueInfoError(str, str2);
            }

            public void onSuccess(Venue venue) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "643934915")) {
                    ipChange.ipc$dispatch("643934915", new Object[]{this, venue});
                } else if (venue != null) {
                    VenuePresenter.this.mView.onRetrieveVenueInfoSuccess(venue);
                }
            }
        });
    }
}
