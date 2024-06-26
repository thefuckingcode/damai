package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.trade.R$id;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class it1 extends a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View e;
    private b f;
    private jg2 g;

    public it1(Activity activity, long j, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j, view, onHeadClickListener);
        this.e = view.findViewById(R$id.book_header_show_time_ui);
        this.f = new b(activity, j, view, onHeadClickListener);
        this.g = new jg2(activity, j, view, onHeadClickListener);
    }

    private String h(StaticData staticData) {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1984805199")) {
            return (String) ipChange.ipc$dispatch("1984805199", new Object[]{this, staticData});
        }
        if (staticData == null || staticData.getItemBase() == null || staticData.getItemBase().getItemPics() == null || staticData.getItemBase().getItemPics().getItemPicList() == null || staticData.getItemBase().getItemPics().getItemPicList().isEmpty() || (picInfo = staticData.getItemBase().getItemPics().getItemPicList().get(0)) == null) {
            return "";
        }
        return picInfo.getPicUrl();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-944310143")) {
            return R$id.project_book_header;
        }
        return ((Integer) ipChange.ipc$dispatch("-944310143", new Object[]{this})).intValue();
    }

    public void d(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908407603")) {
            ipChange.ipc$dispatch("-908407603", new Object[]{this, staticData});
            return;
        }
        if (!(staticData == null || staticData.getItemBase() == null)) {
            e(h(staticData), staticData.getItemBase().getItemName());
        }
        f(staticData);
        g(staticData);
    }

    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485108765")) {
            ipChange.ipc$dispatch("1485108765", new Object[]{this, str, str2});
            return;
        }
        b bVar = this.f;
        if (bVar != null) {
            bVar.g(str, str2);
        }
    }

    public void f(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159555089")) {
            ipChange.ipc$dispatch("159555089", new Object[]{this, staticData});
            return;
        }
        View findViewById = this.e.findViewById(R$id.show_time_arrow);
        TextView textView = (TextView) this.e.findViewById(R$id.project_detail_perform_time_tv);
        findViewById.setVisibility(8);
        ((TextView) this.e.findViewById(R$id.project_detail_perform_duration_tv)).setVisibility(8);
        this.e.setOnClickListener(null);
        if (staticData == null || staticData.getItemBase() == null) {
            this.e.setVisibility(8);
            return;
        }
        String showTime = staticData.getItemBase().getShowTime();
        if (!TextUtils.isEmpty(showTime)) {
            textView.setText(showTime);
            this.e.setVisibility(0);
            return;
        }
        this.e.setVisibility(8);
    }

    public void g(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067769634")) {
            ipChange.ipc$dispatch("-2067769634", new Object[]{this, staticData});
            return;
        }
        this.g.d(staticData);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240600134")) {
            ipChange.ipc$dispatch("-1240600134", new Object[]{this, view});
        } else if (view.getId() == this.e.getId()) {
            this.d.onShowTimeClick();
        }
    }
}
