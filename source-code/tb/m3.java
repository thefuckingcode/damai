package tb;

import android.content.Context;
import cn.damai.tetris.R$styleable;
import cn.damai.tetris.v2.adpater.VBaseAdapter;
import cn.damai.tetris.v2.adpater.VDefaultAdapter;
import cn.damai.tetris.v2.creator.ICreator;
import cn.damai.tetris.v2.helper.StaggeredLayoutHelper;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.alibaba.android.vlayout.layout.b;
import com.alibaba.android.vlayout.layout.c;
import com.alibaba.android.vlayout.layout.h;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class m3 implements ICreator<VBaseAdapter, Map<String, Object>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;

    public m3(Context context) {
        this.a = context;
    }

    private VBaseAdapter b(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        int i = 2;
        if (AndroidInstantRuntime.support(ipChange, "-1360091678")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1360091678", new Object[]{this, map});
        }
        if (map.get("span") != null && (map.get("span") instanceof Integer)) {
            i = ((Integer) map.get("span")).intValue();
        }
        List list = (List) map.get("data");
        b bVar = new b(i);
        h(bVar, map);
        i(bVar, map);
        g(bVar, map);
        bVar.setAutoExpand(false);
        return new VDefaultAdapter(this.a).h(bVar).f(list).g(list.size());
    }

    private VBaseAdapter c(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318378019")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("318378019", new Object[]{this, map});
        }
        List list = (List) map.get("data");
        c cVar = new c();
        i(cVar, map);
        g(cVar, map);
        return new VDefaultAdapter(this.a).h(cVar).f(list).g(list.size());
    }

    private VBaseAdapter d(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027159456")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1027159456", new Object[]{this, map});
        }
        h hVar = new h();
        i(hVar, map);
        g(hVar, map);
        return new VDefaultAdapter(this.a).h(hVar).f((List) map.get("data")).g(1);
    }

    private VBaseAdapter e(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        int i = 2;
        if (AndroidInstantRuntime.support(ipChange, "1655868756")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1655868756", new Object[]{this, map});
        }
        if (map.get("span") != null && (map.get("span") instanceof Integer)) {
            i = ((Integer) map.get("span")).intValue();
        }
        StaggeredLayoutHelper staggeredLayoutHelper = new StaggeredLayoutHelper(i);
        i(staggeredLayoutHelper, map);
        g(staggeredLayoutHelper, map);
        h(staggeredLayoutHelper, map);
        staggeredLayoutHelper.g(f(this.a, map, "marginGap"));
        List list = (List) map.get("data");
        return new VDefaultAdapter(this.a).h(staggeredLayoutHelper).f(list).g(list.size());
    }

    private void g(BaseLayoutHelper baseLayoutHelper, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812706090")) {
            ipChange.ipc$dispatch("1812706090", new Object[]{this, baseLayoutHelper, map});
        } else if (map.containsKey("bgColor")) {
            baseLayoutHelper.setBgColor(((Integer) map.get("bgColor")).intValue());
        }
    }

    private void h(BaseLayoutHelper baseLayoutHelper, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1297370627")) {
            ipChange.ipc$dispatch("1297370627", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        Context context = this.a;
        if (context != null) {
            int f = f(context, map, Constants.H_GAP);
            if (f == 0) {
                f = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_gapH, 0);
            }
            boolean z = baseLayoutHelper instanceof b;
            if (z) {
                ((b) baseLayoutHelper).setHGap(f);
            } else if (baseLayoutHelper instanceof StaggeredLayoutHelper) {
                ((StaggeredLayoutHelper) baseLayoutHelper).setHGap(f);
            }
            int f2 = f(this.a, map, Constants.V_GAP);
            if (f2 == 0) {
                f2 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_gapV, 0);
            }
            if (z) {
                ((b) baseLayoutHelper).setVGap(f2);
            } else if (baseLayoutHelper instanceof StaggeredLayoutHelper) {
                ((StaggeredLayoutHelper) baseLayoutHelper).setVGap(f2);
            }
        }
    }

    private void i(BaseLayoutHelper baseLayoutHelper, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677991333")) {
            ipChange.ipc$dispatch("-677991333", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        Context context = this.a;
        if (context != null) {
            int f = f(context, map, Constants.Name.MARGIN_LEFT);
            if (f == 0) {
                f = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginLeft, 0);
            }
            baseLayoutHelper.setMarginLeft(f);
            int f2 = f(this.a, map, Constants.Name.MARGIN_RIGHT);
            if (f2 == 0) {
                f2 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginRight, 0);
            }
            baseLayoutHelper.setMarginRight(f2);
            int f3 = f(this.a, map, Constants.Name.MARGIN_TOP);
            if (f3 == 0) {
                f3 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginTop, 0);
            }
            baseLayoutHelper.setMarginTop(f3);
            int f4 = f(this.a, map, Constants.Name.MARGIN_BOTTOM);
            if (f4 == 0) {
                f4 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginBottom, 0);
            }
            baseLayoutHelper.setMarginBottom(f4);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r0.equals("grid") == false) goto L_0x0029;
     */
    /* renamed from: a */
    public VBaseAdapter create(vl<Map<String, Object>> vlVar) {
        VBaseAdapter vBaseAdapter;
        IpChange ipChange = $ipChange;
        char c = 2;
        if (AndroidInstantRuntime.support(ipChange, "-1188206935")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1188206935", new Object[]{this, vlVar});
        }
        String c2 = vlVar.c();
        c2.hashCode();
        switch (c2.hashCode()) {
            case -1102672091:
                if (c2.equals("linear")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -892259863:
                if (c2.equals("sticky")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3181382:
                break;
            case 1839260940:
                if (c2.equals("staggered")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                vBaseAdapter = c(vlVar.b());
                break;
            case 1:
                List list = (List) vlVar.b().get("data");
                StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
                i(stickyLayoutHelper, vlVar.b());
                g(stickyLayoutHelper, vlVar.b());
                vBaseAdapter = new VDefaultAdapter(this.a).h(stickyLayoutHelper).f(list).g(list.size());
                break;
            case 2:
                vBaseAdapter = b(vlVar.b());
                break;
            case 3:
                vBaseAdapter = e(vlVar.b());
                break;
            default:
                vBaseAdapter = d(vlVar.b());
                break;
        }
        vBaseAdapter.i(vlVar.a());
        return vBaseAdapter;
    }

    public int f(Context context, Map map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483664520")) {
            return ((Integer) ipChange.ipc$dispatch("-1483664520", new Object[]{this, context, map, str})).intValue();
        } else if (map.containsKey(str)) {
            return yj2.a(context, (float) ((Integer) map.get(str)).intValue());
        } else {
            return 0;
        }
    }
}
