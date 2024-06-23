package cn.damai.user.star;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.homepage.R$id;
import cn.damai.tetris.component.star.bean.StarHeaderData;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;
import tb.wu0;

/* compiled from: Taobao */
public class StarScroller extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    int a = 0;
    View b;
    boolean c;
    Handler d;
    ScrollAlphaListener e;
    StarHeaderData f;
    StarIndexFragment g;
    View.OnClickListener h;
    AttentionView i;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-532380933")) {
                ipChange.ipc$dispatch("-532380933", new Object[]{this, view});
                return;
            }
            StarScroller.this.b.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "746677843")) {
                ipChange.ipc$dispatch("746677843", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            View view = StarScroller.this.b;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements AttentionView.StateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.view.AttentionView.StateListener
        public void onStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-31040423")) {
                ipChange.ipc$dispatch("-31040423", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 1 || i == 2) {
                StarScroller.this.b.setVisibility(8);
                StarScroller.this.i.setStateListener(null);
                StarHeaderData starHeaderData = StarScroller.this.f;
                starHeaderData.followStatus = i;
                StarScroller.this.g.sendMsg(new cn.damai.tetris.core.msg.Message(103, starHeaderData));
            }
        }
    }

    public StarScroller(StarIndexFragment starIndexFragment, ViewGroup viewGroup, ScrollAlphaListener scrollAlphaListener, StarHeaderData starHeaderData, int i2) {
        v50.a(starIndexFragment.getActivity(), 250.0f);
        this.g = starIndexFragment;
        this.e = scrollAlphaListener;
        this.f = starHeaderData;
        b(viewGroup);
    }

    private void b(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906909204")) {
            ipChange.ipc$dispatch("-906909204", new Object[]{this, viewGroup});
            return;
        }
        View findViewById = viewGroup.findViewById(R$id.user_call_follow);
        this.b = findViewById;
        if (findViewById != null) {
            int i2 = R$id.user_call_follow_close;
            if (findViewById.findViewById(i2) != null) {
                this.h = new a();
                this.b.findViewById(i2).setOnClickListener(this.h);
            }
        }
        this.c = false;
        this.d = new b();
        wu0.a(this.g.getActivity(), (ViewGroup) this.b, this.f, 2);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753855539")) {
            ipChange.ipc$dispatch("753855539", new Object[]{this});
            return;
        }
        View view = this.b;
        if (view != null) {
            int i2 = R$id.user_call_follow_close;
            if (view.findViewById(i2) != null) {
                this.b.findViewById(i2).setOnClickListener(null);
                this.h = null;
            }
        }
        AttentionView attentionView = this.i;
        if (attentionView != null) {
            attentionView.cleanAttenList();
            this.i.setStateListener(null);
        }
        this.d.removeMessages(0);
        this.d = null;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036051778")) {
            ipChange.ipc$dispatch("-2036051778", new Object[]{this});
            return;
        }
        this.a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283876102")) {
            ipChange.ipc$dispatch("-283876102", new Object[]{this, recyclerView, Integer.valueOf(i2)});
            return;
        }
        super.onScrollStateChanged(recyclerView, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        ScrollAlphaListener scrollAlphaListener;
        ScrollAlphaListener scrollAlphaListener2;
        AttentionView attentionView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2050109925")) {
            ipChange.ipc$dispatch("2050109925", new Object[]{this, recyclerView, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        super.onScrolled(recyclerView, i2, i3);
        if (this.f != null) {
            int i4 = -1;
            if (recyclerView != null) {
                View childAt = recyclerView.getChildAt(0);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (!(childAt == null || layoutManager == null)) {
                    i4 = layoutManager.getPosition(childAt);
                    if (i4 > 10) {
                        AttentionView attentionView2 = (AttentionView) this.b.findViewById(R$id.attent_view_star_pop);
                        this.i = attentionView2;
                        attentionView2.setInitParams(this.f.id + "", this.f.targetType + "");
                        this.i.setState(this.f.followStatus);
                        if (!this.c && (attentionView = this.i) != null && !attentionView.followed()) {
                            this.b.setVisibility(0);
                            this.i.setVisibility(0);
                            this.c = true;
                            Handler handler = this.d;
                            if (handler != null) {
                                handler.sendEmptyMessageDelayed(0, 6000);
                            }
                            AttentionView attentionView3 = (AttentionView) this.g.getActivity().findViewById(cn.damai.commonbusiness.R$id.attent_view_star);
                            if (attentionView3 != null) {
                                attentionView3.addAttentionView(this.i);
                            }
                            this.i.setStateListener(new c());
                        }
                    } else {
                        this.b.setVisibility(8);
                    }
                }
            }
            this.a -= i3;
            Log.d("xxgetScrollState", " totalDy :" + this.a + " ， position： " + i4);
            int i5 = this.a;
            if ((i5 == 0 || i4 == 0) && (scrollAlphaListener2 = this.e) != null) {
                scrollAlphaListener2.onAlphaChanged(0.0f);
            } else if (i5 < 0 && (scrollAlphaListener = this.e) != null) {
                scrollAlphaListener.onAlphaChanged(1.0f);
            }
        }
    }
}
