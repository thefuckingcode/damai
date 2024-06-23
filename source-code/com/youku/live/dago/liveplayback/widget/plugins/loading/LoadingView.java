package com.youku.live.dago.liveplayback.widget.plugins.loading;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
public class LoadingView extends LazyInflatedView {
    private static transient /* synthetic */ IpChange $ipChange;
    private AnimationDrawable mAnimationDrawable;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mHideLoadingRunnable = new Runnable() {
        /* class com.youku.live.dago.liveplayback.widget.plugins.loading.LoadingView.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "368105395")) {
                ipChange.ipc$dispatch("368105395", new Object[]{this});
                return;
            }
            LoadingView.super.hide();
            if (LoadingView.this.mAnimationDrawable != null) {
                LoadingView.this.mAnimationDrawable.stop();
            }
        }
    };
    private Runnable mStartLoadingRunnable = new Runnable() {
        /* class com.youku.live.dago.liveplayback.widget.plugins.loading.LoadingView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "564618900")) {
                ipChange.ipc$dispatch("564618900", new Object[]{this});
                return;
            }
            LoadingView.super.show();
            if (TextUtils.isEmpty(LoadingView.this.mText)) {
                LoadingView.this.mTextView.setVisibility(8);
            } else {
                LoadingView.this.mTextView.setVisibility(0);
                LoadingView.this.mTextView.setText(LoadingView.this.mText);
            }
            LoadingView.this.mAnimationDrawable.start();
        }
    };
    private String mText;
    private TextView mTextView;

    public LoadingView(Context context, ILMLayerManager<ViewGroup> iLMLayerManager, String str) {
        super(context, iLMLayerManager, str, R.layout.dago_loading_view);
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268859804")) {
            ipChange.ipc$dispatch("1268859804", new Object[]{this});
            return;
        }
        this.mHandler.removeCallbacks(this.mStartLoadingRunnable);
        this.mHandler.post(this.mHideLoadingRunnable);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516049394")) {
            ipChange.ipc$dispatch("-516049394", new Object[]{this, view});
            return;
        }
        this.mAnimationDrawable = (AnimationDrawable) ((ImageView) view.findViewById(R.id.iv_loading)).getDrawable();
        this.mTextView = (TextView) view.findViewById(R.id.tv_text);
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1871435775")) {
            ipChange.ipc$dispatch("-1871435775", new Object[]{this});
            return;
        }
        this.mText = null;
        this.mHandler.postDelayed(this.mStartLoadingRunnable, 500);
    }

    public void show(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-886459509")) {
            ipChange.ipc$dispatch("-886459509", new Object[]{this, str});
            return;
        }
        this.mText = str;
        this.mHandler.postDelayed(this.mStartLoadingRunnable, 500);
    }
}
