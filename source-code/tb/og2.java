package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PerformSeatImageBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class og2 extends a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView e;
    private final TextView f;
    private final View g;
    private final View h;
    private final View i;
    private final View j;
    private final TextView k;
    private DMIconFontTextView l;
    private final TextView m;
    private final View n;

    public og2(Activity activity, long j2, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j2, view, onHeadClickListener);
        this.n = view.findViewById(R$id.venue_ui);
        this.e = (TextView) view.findViewById(R$id.venue_name);
        this.f = (TextView) view.findViewById(R$id.venue_address);
        this.g = view.findViewById(R$id.with_seat_pic_ui);
        this.h = view.findViewById(R$id.venue_map_ui);
        this.m = (TextView) view.findViewById(R$id.venue_distance_tv);
        View findViewById = view.findViewById(R$id.extra_ui);
        this.i = findViewById;
        this.j = findViewById.findViewById(R$id.extra_none_seat_icon);
        this.k = (TextView) findViewById.findViewById(R$id.show_count_tv);
        this.l = (DMIconFontTextView) findViewById.findViewById(R$id.show_count_icon);
    }

    private boolean e(ProjectStaticItemBaseBean projectStaticItemBaseBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667544176")) {
            return ((Boolean) ipChange.ipc$dispatch("-667544176", new Object[]{this, projectStaticItemBaseBean})).booleanValue();
        } else if (projectStaticItemBaseBean == null) {
            return false;
        } else {
            ArrayList<PerformSeatImageBean> arrayList = projectStaticItemBaseBean.performSeatImages;
            if (arrayList != null && arrayList.size() > 0) {
                return false;
            }
            return xf2.e(projectStaticItemBaseBean.getListSeatImg()) > 0 && projectStaticItemBaseBean.isHasNoneSeatImg();
        }
    }

    private boolean f(ProjectStaticItemBaseBean projectStaticItemBaseBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2061529410")) {
            return ((Boolean) ipChange.ipc$dispatch("-2061529410", new Object[]{this, projectStaticItemBaseBean})).booleanValue();
        } else if (projectStaticItemBaseBean == null) {
            return false;
        } else {
            ArrayList<PerformSeatImageBean> arrayList = projectStaticItemBaseBean.performSeatImages;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return xf2.e(projectStaticItemBaseBean.getListSeatImg()) > 0 && !projectStaticItemBaseBean.isHasNoneSeatImg();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1346049879")) {
            return R$id.header_venue_ui;
        }
        return ((Integer) ipChange.ipc$dispatch("1346049879", new Object[]{this})).intValue();
    }

    public void d(ProjectStaticDataBean projectStaticDataBean, ProjectStaticItemBaseBean projectStaticItemBaseBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "990719188")) {
            ipChange.ipc$dispatch("990719188", new Object[]{this, projectStaticDataBean, projectStaticItemBaseBean});
        } else if (projectStaticDataBean == null || projectStaticDataBean.getVenue() == null) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.n.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            VenueBean venue = projectStaticDataBean.getVenue();
            String venueName = venue.getVenueName();
            if (TextUtils.isEmpty(venueName) || venueName.contains(bk2.b(this.a, R$string.damai_projectdetail_tbd))) {
                venueName = b(R$string.venue_undetermined);
            }
            String a = vt1.a(this.a, venueName, venue.getVenueCityName());
            String venueAddr = venue.getVenueAddr();
            String distance = (!n81.b(this.a) || TextUtils.isEmpty(venue.getDistance())) ? "- -" : venue.getDistance();
            this.e.setText(a);
            ln2.r().j2(this.e, String.valueOf(this.b));
            c(this.f, venueAddr);
            this.g.setVisibility(8);
            this.j.setVisibility(8);
            if (projectStaticItemBaseBean != null) {
                if (f(projectStaticItemBaseBean)) {
                    this.g.setVisibility(0);
                    ln2.r().c2(this.g, String.valueOf(projectStaticItemBaseBean.getItemId()));
                }
                if (e(projectStaticItemBaseBean)) {
                    this.j.setVisibility(0);
                }
            }
            boolean notMainLandProject = venue.notMainLandProject();
            if (!TextUtils.isEmpty(venueAddr) && !notMainLandProject) {
                z = false;
            }
            this.h.setVisibility(z ? 8 : 0);
            c(this.m, distance);
            String str = venue.showCountText;
            TextUtils.isEmpty(str);
            this.i.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                this.l.setVisibility(8);
                this.k.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText(str);
            }
            ln2.r().t2(this.n, String.valueOf(this.b), str);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250536284")) {
            ipChange.ipc$dispatch("-250536284", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == this.n.getId()) {
            this.d.onVenueNameClick();
        } else if (id == this.h.getId()) {
            this.d.onVenueMapIconClick();
        } else if (id == this.g.getId()) {
            this.d.onSeatIconClick();
        }
    }
}
