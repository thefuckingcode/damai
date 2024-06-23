package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class jg2 extends a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final View e;
    private final TextView f;
    private final TextView g;
    private final View h;
    private final TextView i;

    public jg2(Activity activity, long j, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j, view, onHeadClickListener);
        this.e = view.findViewById(R$id.venue_ui);
        this.f = (TextView) view.findViewById(R$id.venue_name);
        this.g = (TextView) view.findViewById(R$id.venue_address);
        view.findViewById(R$id.extra_ui).setVisibility(8);
        view.findViewById(R$id.with_seat_pic_ui).setVisibility(8);
        this.h = view.findViewById(R$id.venue_map_ui);
        this.i = (TextView) view.findViewById(R$id.venue_distance_tv);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "460897550")) {
            return R$id.header_venue_ui;
        }
        return ((Integer) ipChange.ipc$dispatch("460897550", new Object[]{this})).intValue();
    }

    public void d(StaticData staticData) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-841100486")) {
            ipChange.ipc$dispatch("-841100486", new Object[]{this, staticData});
        } else if (staticData == null || staticData.getVenue() == null) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.e.setOnClickListener(this);
            this.h.setOnClickListener(this);
            VenueBean venue = staticData.getVenue();
            String venueName = venue.getVenueName();
            if (TextUtils.isEmpty(venueName) || venueName.contains(bk2.b(this.a, R$string.damai_projectdetail_tbd))) {
                venueName = b(R$string.venue_undetermined);
            }
            String a = vt1.a(this.a, venueName, venue.getVenueCityName());
            String venueAddr = venue.getVenueAddr();
            String distance = n81.b(this.a) ? venue.getDistance() : "";
            this.f.setText(a);
            c(this.g, venueAddr);
            boolean notMainLandProject = venue.notMainLandProject();
            if (!TextUtils.isEmpty(venueAddr) && !notMainLandProject) {
                z = false;
            }
            View view = this.h;
            if (z) {
                i2 = 8;
            }
            view.setVisibility(i2);
            c(this.i, distance);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037561933")) {
            ipChange.ipc$dispatch("2037561933", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == this.e.getId()) {
            this.d.onVenueNameClick();
        } else if (id == this.h.getId()) {
            this.d.onVenueMapIconClick();
        }
    }
}
