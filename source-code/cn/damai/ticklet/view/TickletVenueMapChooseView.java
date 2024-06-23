package cn.damai.ticklet.view;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.view.TickletAnimWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.v50;

/* compiled from: Taobao */
public class TickletVenueMapChooseView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    private LinearLayout llMapappView;
    private LinearLayout llTranspant;
    View partent;
    private TextView tvTitle;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TickletAnimWindow.ICustomDialogEventListener a;

        a(TickletVenueMapChooseView tickletVenueMapChooseView, TickletAnimWindow.ICustomDialogEventListener iCustomDialogEventListener) {
            this.a = iCustomDialogEventListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1616899580")) {
                ipChange.ipc$dispatch("-1616899580", new Object[]{this, view});
                return;
            }
            this.a.dialogItemEvent(view);
        }
    }

    public TickletVenueMapChooseView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333402351")) {
            ipChange.ipc$dispatch("-1333402351", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_venue_map_choose_view, this);
        this.partent = inflate;
        this.llMapappView = (LinearLayout) inflate.findViewById(R$id.ticklet_venue_ll_mapapp_content);
        this.llTranspant = (LinearLayout) this.partent.findViewById(R$id.ll_transpant);
        this.tvTitle = (TextView) this.partent.findViewById(R$id.ticklet_venue_tv_mapapp_title);
        this.tvTitle.setLayoutParams(new LinearLayout.LayoutParams(DisplayMetrics.getwidthPixels(v50.b(this.context)) - 300, -2));
    }

    public void initData(List<ResolveInfo> list, TickletAnimWindow.ICustomDialogEventListener iCustomDialogEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169740899")) {
            ipChange.ipc$dispatch("-169740899", new Object[]{this, list, iCustomDialogEventListener});
            return;
        }
        this.llMapappView.removeAllViews();
        if (!(list == null || list.isEmpty() || this.context == null)) {
            for (ResolveInfo resolveInfo : list) {
                TextView textView = new TextView(this.context);
                textView.setText(resolveInfo.activityInfo.loadLabel(this.context.getPackageManager()).toString());
                textView.setTextColor(this.context.getResources().getColor(R$color.ticklet_color_1c77ec));
                textView.setTextSize(1, 16.0f);
                textView.setGravity(17);
                textView.setPadding(5, 30, 5, 10);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, 0, 0, 30);
                textView.setTag(resolveInfo.activityInfo.packageName);
                textView.setOnClickListener(new a(this, iCustomDialogEventListener));
                this.llMapappView.addView(textView, layoutParams);
            }
        }
    }

    public TickletVenueMapChooseView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletVenueMapChooseView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        setGravity(16);
        initView();
    }
}
