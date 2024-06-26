package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.FilterGroupBean;
import cn.damai.projectfiltercopy.bean.FilterItemBean;
import cn.damai.projectfiltercopy.bean.Type;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class li0 extends cn.damai.projectfiltercopy.floatview.a<HashMap<String, List<FilterBean>>> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final View d;
    private FilterItemBean e;
    private boolean f = false;
    private ViewGroup g;
    private HashMap<String, List<a>> h = new HashMap<>();
    private HashMap<String, List<a>> i = new HashMap<>();
    private HashMap<String, FilterGroupBean> j = new HashMap<>();
    private View k;
    private long l;

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        public final String a;
        public final FilterBean b;
        public final TextView c;
        public final int d;
        public boolean e = false;

        public a(String str, FilterBean filterBean, TextView textView, int i) {
            this.a = str;
            this.b = filterBean;
            this.c = textView;
            this.d = i;
        }

        public void a(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-703031877")) {
                ipChange.ipc$dispatch("-703031877", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.e = z;
            this.c.setSelected(z);
            this.c.setTextColor(z ? mg0.C_FF2869 : mg0.C_333333);
        }
    }

    public li0(Context context, FilterItemBean filterItemBean) {
        super(context);
        this.e = filterItemBean;
        View inflate = LayoutInflater.from(context).inflate(R$layout.copy_item_filter_filter_float, (ViewGroup) null);
        this.d = inflate;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.g = (ViewGroup) inflate.findViewById(R$id.item_filter_container);
        View findViewById = inflate.findViewById(R$id.item_filter_reset);
        this.k = inflate.findViewById(R$id.item_filter_confirm);
        findViewById.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    private void a(String str, a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022607650")) {
            ipChange.ipc$dispatch("1022607650", new Object[]{this, str, aVar});
            return;
        }
        List<a> list = this.h.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.h.put(str, list);
        }
        list.add(aVar);
        aVar.a(true);
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760069225")) {
            ipChange.ipc$dispatch("1760069225", new Object[]{this});
            return;
        }
        for (String str : this.h.keySet()) {
            List<a> list = this.h.get(str);
            if (!e92.d(list)) {
                for (a aVar : list) {
                    aVar.a(false);
                }
            }
        }
        this.h.clear();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613323822")) {
            ipChange.ipc$dispatch("-1613323822", new Object[]{this});
        } else if (!this.f) {
            this.f = true;
            List<FilterGroupBean> list = null;
            FilterItemBean filterItemBean = this.e;
            if (filterItemBean != null) {
                list = filterItemBean.selection;
            }
            if (!e92.d(list)) {
                for (FilterGroupBean filterGroupBean : list) {
                    if (filterGroupBean.isValid()) {
                        ArrayList arrayList = new ArrayList();
                        this.i.put(filterGroupBean.option, arrayList);
                        this.j.put(filterGroupBean.option, filterGroupBean);
                        View inflate = LayoutInflater.from(this.a).inflate(R$layout.copy_item_filter_one_filter_container, this.g, false);
                        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R$id.item_filter_flex);
                        ((TextView) inflate.findViewById(R$id.item_filter_flex_title)).setText(filterGroupBean.name);
                        List<FilterBean> list2 = filterGroupBean.lineItem;
                        int size = list2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            FilterBean filterBean = list2.get(i2);
                            View inflate2 = LayoutInflater.from(this.a).inflate(R$layout.copy_item_filter_one_filter_item, viewGroup, false);
                            TextView textView = (TextView) inflate2.findViewById(R$id.item_filter_text);
                            textView.setText(filterBean.name);
                            textView.setSelected(false);
                            a aVar = new a(filterGroupBean.option, filterBean, textView, i2);
                            arrayList.add(aVar);
                            inflate2.setTag(aVar);
                            inflate2.setOnClickListener(this);
                            viewGroup.addView(inflate2, -2, -2);
                        }
                        this.g.addView(inflate, -1, -2);
                    }
                }
            }
        }
    }

    private HashMap<String, List<FilterBean>> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353681173")) {
            return (HashMap) ipChange.ipc$dispatch("-1353681173", new Object[]{this});
        }
        HashMap<String, List<FilterBean>> hashMap = new HashMap<>();
        for (String str : this.h.keySet()) {
            List<a> list = this.h.get(str);
            if (!e92.d(list)) {
                ArrayList arrayList = new ArrayList();
                hashMap.put(str, arrayList);
                for (a aVar : list) {
                    arrayList.add(aVar.b);
                }
            }
        }
        return hashMap;
    }

    private void e(String str, a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54878132")) {
            ipChange.ipc$dispatch("54878132", new Object[]{this, str, aVar});
            return;
        }
        List<a> list = this.h.get(str);
        if (!e92.d(list)) {
            list.remove(aVar);
        }
        aVar.a(false);
    }

    /* renamed from: f */
    public void show(@Nullable HashMap<String, List<FilterBean>> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857400276")) {
            ipChange.ipc$dispatch("857400276", new Object[]{this, hashMap});
            return;
        }
        this.l = System.currentTimeMillis();
        c();
        b();
        if (!(hashMap == null || e92.e(hashMap))) {
            for (String str : hashMap.keySet()) {
                List<FilterBean> list = hashMap.get(str);
                List<a> list2 = this.i.get(str);
                if (!e92.d(list) && !e92.d(list2)) {
                    for (a aVar : list2) {
                        if (list.contains(aVar.b)) {
                            a(str, aVar);
                        }
                    }
                }
            }
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "703473490")) {
            return Type.FILTER;
        }
        return (Type) ipChange.ipc$dispatch("703473490", new Object[]{this});
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1766140299")) {
            return this.d;
        }
        return (View) ipChange.ipc$dispatch("-1766140299", new Object[]{this});
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-704855270")) {
            ipChange.ipc$dispatch("-704855270", new Object[]{this});
            return;
        }
        getFilterUt().u(this.k, System.currentTimeMillis() - this.l);
    }

    public void onClick(View view) {
        a aVar;
        String str;
        FilterGroupBean filterGroupBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119177293")) {
            ipChange.ipc$dispatch("1119177293", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.item_filter_confirm) {
            FilterData filterData = new FilterData();
            filterData.mFilterMap = d();
            getListener().onFloatCall(getType(), filterData);
            getFilterUt().j("confirm");
        } else if (id == R$id.item_filter_reset) {
            getFilterUt().j("reset");
            b();
        } else if (id == R$id.item_filter_one_item_id) {
            Object tag = view.getTag();
            if ((tag instanceof a) && (filterGroupBean = this.j.get((str = (aVar = (a) tag).a))) != null) {
                if (aVar.e) {
                    e(str, aVar);
                } else {
                    if (filterGroupBean.isSingleSelected) {
                        List<a> list = this.h.get(str);
                        if (!e92.d(list)) {
                            for (a aVar2 : list) {
                                aVar2.a(false);
                            }
                            list.clear();
                        }
                    }
                    a(str, aVar);
                }
                getFilterUt().k(aVar.b, aVar.d);
            }
        }
    }
}
