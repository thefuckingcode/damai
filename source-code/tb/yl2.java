package tb;

import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.wannasee.bean.TimeLineStyle;
import cn.damai.commonbusiness.wannasee.viewholder.TimeLineDecorate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class yl2 implements TimeLineDecorate {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private TextView c;

    public yl2(View view) {
        View findViewById = view.findViewById(R$id.id_time_line_layout);
        this.b = findViewById.findViewById(R$id.time_line_top);
        this.a = findViewById.findViewById(R$id.time_line_bottom);
        this.c = (TextView) findViewById.findViewById(R$id.time_line_title);
    }

    @Override // cn.damai.commonbusiness.wannasee.viewholder.TimeLineDecorate
    public void setTimeStyle(TimeLineStyle timeLineStyle) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1156582558")) {
            ipChange.ipc$dispatch("1156582558", new Object[]{this, timeLineStyle});
        } else if (timeLineStyle != null) {
            View view = this.b;
            if (timeLineStyle.isFirst) {
                i = 4;
            }
            view.setVisibility(i);
            this.c.setText(timeLineStyle.title);
        }
    }
}
