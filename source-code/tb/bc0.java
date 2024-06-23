package tb;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.discover.content.bean.TwoTuple;
import cn.damai.discover.content.net.IpInfoWrap;
import cn.damai.discover.content.ui.viewholder.CityProjectListPanel;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.musicfestival.model.MusicPageNav;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class bc0 extends ym2<TwoTuple<String, IpInfoWrap>> implements OnItemBindListener<ContentTour.ContentRelatedTourListItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundImageView d;
    private TextView e;
    private TextView f;
    private View g;
    private TextView h;
    private CityProjectListPanel i;
    private View j;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DramaV1Bean a;

        a(DramaV1Bean dramaV1Bean) {
            this.a = dramaV1Bean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            int i = 1;
            if (AndroidInstantRuntime.support(ipChange, "834808328")) {
                ipChange.ipc$dispatch("834808328", new Object[]{this, view});
            } else if (bc0.this.a != null) {
                DramaV1Bean dramaV1Bean = this.a;
                String str = dramaV1Bean.id;
                if (dramaV1Bean.isMusicIpType()) {
                    MusicPageNav.openH5MusicIpPage(bc0.this.a, str);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(RepertoireDetailFragment.REPERTOIREID, str);
                    DMNav.from(bc0.this.a).withExtras(bundle).toUri(NavUri.b(wz1.REPERTOITE));
                    i = 0;
                }
                c.e().x(bc0.this.getLiveUt().A(i, str));
            }
        }
    }

    public bc0(Context context) {
        super(context);
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-786255240")) {
            return R$layout.item_content_detail_drama_relate;
        }
        return ((Integer) ipChange.ipc$dispatch("-786255240", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76975035")) {
            ipChange.ipc$dispatch("-76975035", new Object[]{this});
            return;
        }
        this.j = this.b.findViewById(R$id.card_ui);
        this.d = (RoundImageView) this.b.findViewById(R$id.drama_pic);
        this.e = (TextView) this.b.findViewById(R$id.drama_title);
        this.f = (TextView) this.b.findViewById(R$id.drama_desc);
        this.g = this.b.findViewById(R$id.drama_score_ui);
        this.h = (TextView) this.b.findViewById(R$id.drama_score);
        this.i = new CityProjectListPanel(this.b, this);
        this.d.setBorder(1, Color.parseColor("#1A000000"));
    }

    /* renamed from: d */
    public void exposeItem(View view, ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2058055571")) {
            ipChange.ipc$dispatch("-2058055571", new Object[]{this, view, contentRelatedTourListItem, Integer.valueOf(i2)});
        }
    }

    public void e(TwoTuple<String, IpInfoWrap> twoTuple) {
        S s;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-30379190")) {
            ipChange.ipc$dispatch("-30379190", new Object[]{this, twoTuple});
        } else if (twoTuple == null || (s = twoTuple.second) == null) {
            c(false);
        } else {
            S s2 = s;
            DramaV1Bean dramaV1Bean = s2.ipInfo;
            if (dramaV1Bean != null) {
                this.j.setVisibility(0);
                this.e.setText(dramaV1Bean.title);
                this.f.setText(dramaV1Bean.briefIntroduction);
                if (dramaV1Bean.getScoreValue() > 0.0d) {
                    this.g.setVisibility(0);
                    this.h.setText(dramaV1Bean.itemScore);
                } else {
                    this.g.setVisibility(8);
                }
                DMImageCreator f2 = cn.damai.common.image.a.b().f(dramaV1Bean.pic, n42.a(xs0.a(), 48.0f), n42.a(xs0.a(), 64.0f));
                int i2 = R$drawable.uikit_default_image_bg_gradient;
                f2.i(i2).c(i2).g(this.d);
                this.j.setOnClickListener(new a(dramaV1Bean));
            } else {
                this.j.setVisibility(8);
            }
            CityProjectListPanel cityProjectListPanel = this.i;
            ArrayList<ContentTour.ContentRelatedTourListItem> arrayList = s2.relateItem;
            if (dramaV1Bean != null) {
                z = true;
            }
            cityProjectListPanel.b(arrayList, z);
            c(true);
        }
    }

    /* renamed from: f */
    public void onItemClick(ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238491096")) {
            ipChange.ipc$dispatch("238491096", new Object[]{this, contentRelatedTourListItem, Integer.valueOf(i2)});
        } else if (this.a != null) {
            c.e().x(getLiveUt().L(contentRelatedTourListItem.itemId, i2));
            Bundle bundle = new Bundle();
            bundle.putString("id", contentRelatedTourListItem.itemId);
            tb2.a(this.a, contentRelatedTourListItem.schema, bundle);
        }
    }
}
