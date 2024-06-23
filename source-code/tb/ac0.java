package tb;

import android.view.View;
import android.widget.ImageView;
import cn.damai.commonbusiness.R$id;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ac0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private ImageView b;
    private DMPosterView c;
    private final int d = n42.a(xs0.a(), 115.0f);
    private final int e = n42.a(xs0.a(), 86.0f);

    public ac0(View view) {
        View findViewById = view.findViewById(R$id.drama_poster_ui);
        this.a = findViewById;
        this.c = (DMPosterView) findViewById.findViewById(R$id.drama_poster);
        DMCategroyTagView dMCategroyTagView = (DMCategroyTagView) this.a.findViewById(R$id.right_top_category_tag);
        this.b = (ImageView) this.a.findViewById(R$id.left_bottom_img_tag);
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361665107")) {
            ipChange.ipc$dispatch("-361665107", new Object[]{this, str});
            return;
        }
        this.c.setImageUrlForWebp(str, this.e, this.d);
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1393448401")) {
            ipChange.ipc$dispatch("-1393448401", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 0) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.b.setImageResource(i);
        }
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390867222")) {
            ipChange.ipc$dispatch("-1390867222", new Object[]{this, str});
            return;
        }
        this.c.setCategoryTagName(str);
    }

    public void d(double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740278088")) {
            ipChange.ipc$dispatch("-740278088", new Object[]{this, Double.valueOf(d2)});
            return;
        }
        this.c.setScoreStar(d2, true);
    }
}
