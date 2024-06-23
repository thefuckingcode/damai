package cn.damai.tetris.component.music.viewholder;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ViewFlipper;
import cn.damai.musicfestival.bean.MusicDispatchBean;
import cn.damai.tetris.component.music.viewholder.MusicFlipHotItemPanel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;
import tb.m42;
import tb.u5;
import tb.uf2;
import tb.xs0;

/* compiled from: Taobao */
public class MusicFlipperPanel {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ANIM_DELAY_TIME = 5000;
    private final ViewGroup a;
    private final ViewFlipper b;
    private final ViewFlipper c;
    private OnHotFlipListener d;
    private Handler e = new Handler();
    private int f = 0;
    private int g = 0;
    private boolean h = true;
    private ValueAnimator i;
    private Runnable j = new Runnable() {
        /* class cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1747474571")) {
                ipChange.ipc$dispatch("1747474571", new Object[]{this});
            } else if (MusicFlipperPanel.this.p()) {
                MusicFlipperPanel.this.n(false);
            }
        }
    };

    /* compiled from: Taobao */
    public interface OnHotFlipListener {
        void onFlipItemClick(MusicDispatchBean musicDispatchBean);

        void onFlipItemExpose(View view, MusicDispatchBean musicDispatchBean);

        void onFlipTo(MusicDispatchBean musicDispatchBean);

        void onTextUiFlipperExpand();
    }

    /* compiled from: Taobao */
    public class a implements MusicFlipHotItemPanel.OnOneFlipperItemListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFlipHotItemPanel.OnOneFlipperItemListener
        public void onIpIconClick(MusicFlipHotItemPanel musicFlipHotItemPanel, MusicDispatchBean musicDispatchBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "748001497")) {
                ipChange.ipc$dispatch("748001497", new Object[]{this, musicFlipHotItemPanel, musicDispatchBean});
                return;
            }
            MusicFlipperPanel.this.e.removeCallbacks(MusicFlipperPanel.this.j);
            boolean p = MusicFlipperPanel.this.p();
            if (!p) {
                MusicFlipperPanel.this.f = 0;
                MusicFlipperPanel.this.d.onTextUiFlipperExpand();
            }
            MusicFlipperPanel.this.n(!p);
            if (MusicFlipperPanel.this.b.getChildCount() == 1 && MusicFlipperPanel.this.p()) {
                MusicFlipperPanel musicFlipperPanel = MusicFlipperPanel.this;
                musicFlipperPanel.q(musicFlipperPanel.j, 3000);
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFlipHotItemPanel.OnOneFlipperItemListener
        public void onItemClick(MusicFlipHotItemPanel musicFlipHotItemPanel, MusicDispatchBean musicDispatchBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1603104742")) {
                ipChange.ipc$dispatch("1603104742", new Object[]{this, musicFlipHotItemPanel, musicDispatchBean});
                return;
            }
            MusicFlipperPanel.this.d.onFlipItemClick(musicDispatchBean);
        }
    }

    /* compiled from: Taobao */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1837114288")) {
                ipChange.ipc$dispatch("-1837114288", new Object[]{this, valueAnimator});
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            MusicFlipperPanel.this.b.getLayoutParams().width = ((Integer) animatedValue).intValue();
            MusicFlipperPanel.this.b.requestLayout();
        }
    }

    public MusicFlipperPanel(ViewGroup viewGroup, ViewFlipper viewFlipper, ViewFlipper viewFlipper2, OnHotFlipListener onHotFlipListener) {
        this.a = viewGroup;
        this.b = viewFlipper;
        viewFlipper.setFlipInterval(5000);
        this.c = viewFlipper2;
        this.d = onHotFlipListener;
        viewFlipper.getInAnimation().setAnimationListener(new u5() {
            /* class cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationEnd(Animation animation) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1405319201")) {
                    ipChange.ipc$dispatch("-1405319201", new Object[]{this, animation});
                    return;
                }
                View currentView = MusicFlipperPanel.this.b.getCurrentView();
                if (currentView != null) {
                    Object tag = currentView.getTag();
                    if (tag instanceof MusicFlipHotItemPanel) {
                        MusicFlipperPanel.this.d.onFlipTo(((MusicFlipHotItemPanel) tag).f);
                        MusicFlipperPanel.g(MusicFlipperPanel.this);
                        if (MusicFlipperPanel.this.f >= MusicFlipperPanel.this.g) {
                            MusicFlipperPanel.this.f = 0;
                            if (MusicFlipperPanel.this.p()) {
                                MusicFlipperPanel musicFlipperPanel = MusicFlipperPanel.this;
                                musicFlipperPanel.q(musicFlipperPanel.j, 1000);
                            }
                        }
                    }
                }
            }

            public void onAnimationStart(Animation animation) {
                Handler handler;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "898146168")) {
                    ipChange.ipc$dispatch("898146168", new Object[]{this, animation});
                    return;
                }
                MusicFlipperPanel.this.c.setDisplayedChild(MusicFlipperPanel.this.b.getDisplayedChild());
                if (MusicFlipperPanel.this.h && (handler = MusicFlipperPanel.this.b.getHandler()) != null) {
                    handler.post(new Runnable() {
                        /* class cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.AnonymousClass2.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1761199805")) {
                                ipChange.ipc$dispatch("1761199805", new Object[]{this});
                                return;
                            }
                            MusicFlipperPanel.this.n(true);
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ int g(MusicFlipperPanel musicFlipperPanel) {
        int i2 = musicFlipperPanel.f;
        musicFlipperPanel.f = i2 + 1;
        return i2;
    }

    private void m(List<MusicDispatchBean> list) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-503452848")) {
            ipChange.ipc$dispatch("-503452848", new Object[]{this, list});
            return;
        }
        this.h = true;
        Handler handler = this.b.getHandler();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.e.removeCallbacksAndMessages(null);
        this.b.stopFlipping();
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
        }
        this.b.removeAllViews();
        this.b.setVisibility(0);
        this.c.removeAllViews();
        int b2 = uf2.b(list);
        this.g = b2;
        this.f = 0;
        ViewGroup viewGroup = this.a;
        if (b2 <= 0) {
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(Runnable runnable, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238069604")) {
            ipChange.ipc$dispatch("238069604", new Object[]{this, runnable, Integer.valueOf(i2)});
            return;
        }
        this.e.postDelayed(runnable, (long) i2);
    }

    public void l(List<MusicDispatchBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139916662")) {
            ipChange.ipc$dispatch("2139916662", new Object[]{this, list});
            return;
        }
        m(list);
        if (!f92.d(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                MusicDispatchBean musicDispatchBean = list.get(i2);
                musicDispatchBean.pos = i2;
                MusicFlipHotItemPanel musicFlipHotItemPanel = new MusicFlipHotItemPanel(this.b, new a());
                musicFlipHotItemPanel.b(musicDispatchBean);
                View d2 = musicFlipHotItemPanel.d();
                this.d.onFlipItemExpose(d2, musicDispatchBean);
                this.b.addView(musicFlipHotItemPanel.e());
                this.c.addView(musicFlipHotItemPanel.c(), -1, -1);
                if (i2 == 0) {
                    d2.measure(View.MeasureSpec.makeMeasureSpec(m42.a(xs0.a(), 220.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(m42.a(xs0.a(), 26.0f), 1073741824));
                    this.b.getLayoutParams().width = d2.getMeasuredWidth();
                    this.b.requestLayout();
                }
            }
            this.d.onFlipTo(((MusicFlipHotItemPanel) this.b.getCurrentView().getTag()).f);
            if (size == 1) {
                q(this.j, 3000);
            } else {
                q(new Runnable() {
                    /* class cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.AnonymousClass4 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1157934056")) {
                            ipChange.ipc$dispatch("1157934056", new Object[]{this});
                        } else if (MusicFlipperPanel.this.b.getChildCount() > 1) {
                            MusicFlipperPanel.this.b.setDisplayedChild(1);
                            MusicFlipperPanel.this.b.startFlipping();
                        }
                    }
                }, 5000);
            }
        }
    }

    public void n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-118699898")) {
            ipChange.ipc$dispatch("-118699898", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.h = z;
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int width = this.b.getWidth();
        ValueAnimator ofInt = ValueAnimator.ofInt(width, z ? this.b.getChildCount() > 0 ? ((MusicFlipHotItemPanel) this.b.getCurrentView().getTag()).d().getMeasuredWidth() : width : 1);
        this.i = ofInt;
        ofInt.setDuration(300L);
        this.i.addUpdateListener(new b());
        this.i.start();
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102387421")) {
            ipChange.ipc$dispatch("-102387421", new Object[]{this});
        } else if (p()) {
            n(false);
        }
    }

    public boolean p() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1812644980")) {
            return this.h;
        }
        return ((Boolean) ipChange.ipc$dispatch("1812644980", new Object[]{this})).booleanValue();
    }
}
