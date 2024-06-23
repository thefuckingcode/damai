package com.youku.live.dago.liveplayback.widget.plugins.dmmulti;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
public class DMMultiView extends LazyInflatedView implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View mBtnGoback;
    private ImageView mBtnScreenChange;
    private TextView mDescTv;
    private MultiGridView mGridView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private DMMultiViewPlugin mPresenter;

    public DMMultiView(AlixPlayerContext alixPlayerContext, ILMLayerManager<ViewGroup> iLMLayerManager, String str) {
        super(alixPlayerContext.getContext(), iLMLayerManager, str, R.layout.dm_multi_view_plugin);
    }

    private void runOnUiThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250947686")) {
            ipChange.ipc$dispatch("-250947686", new Object[]{this, runnable});
        } else if (Thread.currentThread() == this.mHandler.getLooper().getThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    public DMMultiViewPlugin getPresenter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1335369943")) {
            return this.mPresenter;
        }
        return (DMMultiViewPlugin) ipChange.ipc$dispatch("-1335369943", new Object[]{this});
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1158500412")) {
            ipChange.ipc$dispatch("-1158500412", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2062130774")) {
                    ipChange.ipc$dispatch("-2062130774", new Object[]{this});
                    return;
                }
                DMMultiView.super.hide();
            }
        });
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803079305")) {
            ipChange.ipc$dispatch("-803079305", new Object[]{this, view});
        } else if (view == this.mBtnScreenChange) {
            this.mPresenter.onScreenChange();
        } else if (view == this.mBtnGoback) {
            this.mPresenter.onGoBack();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788773433")) {
            ipChange.ipc$dispatch("-788773433", new Object[]{this, configuration});
        } else if (isInflated()) {
            this.mBtnScreenChange.setImageResource(configuration.orientation == 2 ? R.drawable.dago_multi_smallscreen : R.drawable.dago_multi_fullscreen);
            double[] wHFor16bi9 = MultiGridViewUtil.getWHFor16bi9(this.mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) wHFor16bi9[0], (int) wHFor16bi9[1]);
            layoutParams.gravity = 17;
            this.mGridView.setLayoutParams(layoutParams);
            this.mGridView.requestLayout();
            this.mGridView.invalidate();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248384458")) {
            ipChange.ipc$dispatch("-1248384458", new Object[]{this, view});
            return;
        }
        this.mDescTv = (TextView) view.findViewById(R.id.tv_desc);
        View findViewById = view.findViewById(R.id.btn_multi_goback);
        this.mBtnGoback = findViewById;
        findViewById.setOnClickListener(this);
        this.mGridView = (MultiGridView) view.findViewById(R.id.gridview);
        double[] wHFor16bi9 = MultiGridViewUtil.getWHFor16bi9(this.mContext);
        this.mGridView.setLayoutParams(new FrameLayout.LayoutParams((int) wHFor16bi9[0], (int) wHFor16bi9[1]));
        this.mGridView.requestLayout();
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_screen_change);
        this.mBtnScreenChange = imageView;
        imageView.setOnClickListener(this);
    }

    public void setPresenter(DMMultiViewPlugin dMMultiViewPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877983685")) {
            ipChange.ipc$dispatch("877983685", new Object[]{this, dMMultiViewPlugin});
            return;
        }
        this.mPresenter = dMMultiViewPlugin;
    }

    public void show(final GridViewBean gridViewBean, final MultiGridViewClickListener multiGridViewClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526622172")) {
            ipChange.ipc$dispatch("1526622172", new Object[]{this, gridViewBean, multiGridViewClickListener});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1669103764")) {
                    ipChange.ipc$dispatch("-1669103764", new Object[]{this});
                    return;
                }
                DMMultiView.this.show();
                DMMultiView.this.mDescTv.setVisibility(0);
                DMMultiView.this.mBtnGoback.setVisibility(8);
                DMMultiView.this.mGridView.setGridViewData(gridViewBean, multiGridViewClickListener);
            }
        });
    }

    public void showError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154212263")) {
            ipChange.ipc$dispatch("-154212263", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1865617269")) {
                    ipChange.ipc$dispatch("-1865617269", new Object[]{this});
                    return;
                }
                DMMultiView.this.show();
                DMMultiView.this.mDescTv.setVisibility(8);
                DMMultiView.this.mBtnGoback.setVisibility(0);
            }
        });
    }
}
