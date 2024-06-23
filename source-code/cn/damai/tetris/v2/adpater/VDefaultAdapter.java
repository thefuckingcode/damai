package cn.damai.tetris.v2.adpater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.tetris.R$id;
import cn.damai.tetris.R$layout;
import cn.damai.tetris.core.ConnerStyle;
import cn.damai.tetris.core.config.ComponentConfig;
import cn.damai.tetris.gaiax.GaiaXTemplateInfo;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.gs0;
import tb.jl1;
import tb.n91;
import tb.o80;
import tb.vj;
import tb.vr0;
import tb.wl;
import tb.xz;
import tb.yj2;

/* compiled from: Taobao */
public class VDefaultAdapter<T extends ISection> extends VBaseAdapter<T, VBaseViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1999345923")) {
                ipChange.ipc$dispatch("-1999345923", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            VDefaultAdapter vDefaultAdapter = VDefaultAdapter.this;
            bundle.putString("info", vDefaultAdapter.p(vDefaultAdapter.d));
            Class<?> cls = null;
            try {
                cls = Class.forName("cn.damai.appinfo.bundle.activity.defect.ShowInfoActivity");
            } catch (ClassNotFoundException e) {
                n91.a("addTestMarker", e.getMessage());
            }
            if (cls != null) {
                Intent intent = new Intent(VDefaultAdapter.this.a, cls);
                intent.putExtras(bundle);
                VDefaultAdapter.this.a.startActivity(intent);
            }
        }
    }

    public VDefaultAdapter(Context context) {
        super(context);
    }

    private void l(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578615762")) {
            ipChange.ipc$dispatch("-1578615762", new Object[]{this, viewGroup});
            return;
        }
        ConnerStyle connerStyle = ((gs0) getData().get(0)).getStyleInfo().getConnerStyle();
        String b = vj.b(connerStyle.borderRadiusForeColor);
        String b2 = vj.b(connerStyle.borderRadiusBgColor);
        if (b == null || b2 == null) {
            b = "#ffffff";
            b2 = "#1d1d2f";
        }
        viewGroup.findViewById(R$id.tetris_layer_gap_bg).setBackgroundColor(Color.parseColor(b2));
        float a2 = (float) yj2.a(this.a, 12.0f);
        float[] fArr = {a2, a2, a2, a2, 0.0f, 0.0f, 0.0f, 0.0f};
        int parseColor = Color.parseColor(b);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadii(fArr);
        viewGroup.findViewById(R$id.tetris_layer_gap_radius).setBackground(gradientDrawable);
    }

    private ViewGroup m(@NonNull ViewGroup viewGroup, int i, View view, ViewGroup viewGroup2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452868054")) {
            return (ViewGroup) ipChange.ipc$dispatch("-452868054", new Object[]{this, viewGroup, Integer.valueOf(i), view, viewGroup2});
        }
        TextView textView = null;
        Pair<String, ComponentConfig> pair = wl.c(this.a).e().get(i);
        if (pair != null) {
            textView = new TextView(this.a);
            textView.setText("id:" + ((String) pair.first));
            textView.setTextColor(this.a.getResources().getColor(17170454));
            textView.setTextSize(14.0f);
            textView.setPadding(20, 0, 0, 0);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            DXTemplateItem e = o80.e(i);
            if (e != null) {
                textView = new TextView(this.a);
                textView.setText("dx:" + e.name + jl1.BRACKET_START_STR + e.version + jl1.BRACKET_END_STR);
                textView.setTextColor(this.a.getResources().getColor(17170454));
                textView.setTextSize(14.0f);
                textView.setPadding(20, 0, 0, 0);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
        }
        List<T> list = this.d;
        if (list != null && list.size() > 0) {
            textView.setOnClickListener(new a());
        }
        if (textView != null) {
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(this.a).inflate(R$layout.layout_tetris_gap, viewGroup, false);
                viewGroup3.addView(view, 0);
                viewGroup2 = viewGroup3;
            }
            viewGroup2.addView(textView);
        }
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return viewGroup2;
    }

    private boolean n() {
        SharedPreferences sharedPreferences;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "391307791")) {
            return ((Boolean) ipChange.ipc$dispatch("391307791", new Object[]{this})).booleanValue();
        }
        return r(this.a) && (sharedPreferences = this.a.getSharedPreferences("popcorn", 0)) != null && sharedPreferences.getBoolean("showTetrisId", false);
    }

    private VBaseViewHolder o(@NonNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "384371195")) {
            return new VDefaultGenericGaiaXViewHolder(LayoutInflater.from(this.a).inflate(R$layout.tetris_core_gaia_container, viewGroup, false), this.b);
        }
        return (VBaseViewHolder) ipChange.ipc$dispatch("384371195", new Object[]{this, viewGroup});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String p(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-658453485")) {
            return (String) ipChange.ipc$dispatch("-658453485", new Object[]{this, list});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            if (t instanceof gs0) {
                sb.append("坑位信息:");
                sb.append(((gs0) t).toString());
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }

    private ViewGroup q(@NonNull ViewGroup viewGroup, View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123724737")) {
            return (ViewGroup) ipChange.ipc$dispatch("-2123724737", new Object[]{this, viewGroup, view, Integer.valueOf(i)});
        }
        ViewGroup viewGroup2 = null;
        if (s()) {
            viewGroup2 = (ViewGroup) LayoutInflater.from(this.a).inflate(R$layout.layout_tetris_gap, viewGroup, false);
            viewGroup2.addView(view, 0);
            try {
                l(viewGroup2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!n()) {
            return viewGroup2;
        }
        try {
            return m(viewGroup, i, view, viewGroup2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return viewGroup2;
        }
    }

    private boolean r(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1022453962")) {
            return (context.getApplicationInfo().flags & 2) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1022453962", new Object[]{this, context})).booleanValue();
    }

    private boolean s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546246599")) {
            return ((Boolean) ipChange.ipc$dispatch("546246599", new Object[]{this})).booleanValue();
        }
        if (getData() != null && (getData().get(0) instanceof gs0)) {
            gs0 gs0 = (gs0) getData().get(0);
            return (gs0.getStyleInfo() == null || gs0.getStyleInfo().getConnerStyle() == null || !gs0.getStyleInfo().getConnerStyle().fillet) ? false : true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555105620")) {
            return ((Integer) ipChange.ipc$dispatch("-555105620", new Object[]{this})).intValue();
        }
        List<T> list = this.d;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.e;
    }

    @NonNull
    /* renamed from: t */
    public VBaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        VBaseViewHolder vBaseViewHolder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "469199830")) {
            return (VBaseViewHolder) ipChange.ipc$dispatch("469199830", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        n91.a("VDefaultAdapter", "onCreateViewHolder for viewType : " + i);
        GaiaXTemplateInfo a2 = vr0.a(i);
        DXTemplateItem e = o80.e(i);
        DinamicXEngine dXEngine = this.b.getDXEngine();
        if (dXEngine != null && e != null) {
            xz<DXRootView> f = dXEngine.f(this.a, e);
            ViewGroup q = q(viewGroup, f.a, i);
            if (q == null) {
                return new VDinamicXViewHolder(this.b, f.a, e);
            }
            vBaseViewHolder = new VDinamicXViewHolder(this.b, q, e);
        } else if (a2 != null) {
            return o(viewGroup);
        } else {
            ComponentConfig a3 = wl.c(this.a).a(i);
            if (a3 == null) {
                n91.a("VDefaultAdapter", "No Config for viewType : " + i);
                return new VDefaultViewHolder(this.b, new View(this.a), null);
            }
            View inflate = LayoutInflater.from(this.a).inflate(this.a.getResources().getIdentifier(a3.layoutXml, "layout", this.a.getPackageName()), viewGroup, false);
            ViewGroup q2 = q(viewGroup, inflate, i);
            n91.a("KEY_STYLE_INFO", i + " , : " + q2);
            if (q2 == null) {
                return new VDefaultViewHolder(c(), inflate, a3);
            }
            vBaseViewHolder = new VDefaultViewHolder(c(), q2, a3);
        }
        return vBaseViewHolder;
    }
}
