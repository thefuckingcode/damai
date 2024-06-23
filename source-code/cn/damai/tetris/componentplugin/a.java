package cn.damai.tetris.componentplugin;

import cn.damai.tetris.component.drama.bean.FilterMainBean;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import cn.damai.tetris.component.drama.viewholder.FilterViewHolder;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.br;
import tb.w9;

@Deprecated
/* compiled from: Taobao */
public class a {
    public static final int TYPE_BIND_ITEM_DATA = 2050;
    public static final int TYPE_CALENDAR_CLICK = 2051;
    public static final int TYPE_MAIN_CLICK = 2048;
    public static final int TYPE_TAG_CLICK = 2049;
    public FilterMainBean a;
    public FilterTagBean b;
    public FilterViewHolder c;
    public int d;

    /* renamed from: cn.damai.tetris.componentplugin.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0052a implements FilterViewHolder.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private w9 a;

        public C0052a(w9 w9Var) {
            this.a = w9Var;
        }

        private void a(int i, a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1130292901")) {
                ipChange.ipc$dispatch("-1130292901", new Object[]{this, Integer.valueOf(i), aVar});
                return;
            }
            w9 w9Var = this.a;
            if (w9Var != null) {
                br.c(w9Var.a(), new Message(i, aVar));
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemClickListener
        public void onCalendarClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2117668542")) {
                ipChange.ipc$dispatch("2117668542", new Object[]{this});
                return;
            }
            a(2051, new a());
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemClickListener
        public void onMainTabClick(FilterMainBean filterMainBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-631415069")) {
                ipChange.ipc$dispatch("-631415069", new Object[]{this, filterMainBean, Integer.valueOf(i)});
                return;
            }
            a(2048, new a(filterMainBean, i));
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemClickListener
        public void onTagClick(FilterTagBean filterTagBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "315994984")) {
                ipChange.ipc$dispatch("315994984", new Object[]{this, filterTagBean, Integer.valueOf(i)});
                return;
            }
            a(a.TYPE_TAG_CLICK, new a(filterTagBean, i));
        }
    }

    public a() {
    }

    public a(FilterViewHolder filterViewHolder) {
        this.c = filterViewHolder;
    }

    public a(FilterMainBean filterMainBean, int i) {
        this.a = filterMainBean;
        this.d = i;
    }

    public a(FilterTagBean filterTagBean, int i) {
        this.b = filterTagBean;
        this.d = i;
    }
}
