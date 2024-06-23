package cn.damai.tetris.component.home.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.i42;
import tb.s50;
import tb.ug2;

/* compiled from: Taobao */
public class ScrollSkipLinearView extends TabLottieLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
    IPhenixListener listener;
    private float mLineWidth = 0.0f;
    private Paint mPaint;
    private int mScrollX = 0;
    public int mSelectIndex = -1;
    private TextView mSelectTv;
    private float mStartX;
    private int mStartY = 0;
    private float mStopX;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        a(ScrollSkipLinearView scrollSkipLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "223521201")) {
                ipChange.ipc$dispatch("223521201", new Object[]{this, view});
                return;
            }
            this.a.onClick(view);
        }
    }

    /* compiled from: Taobao */
    public class b implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        b(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "825153516")) {
                ipChange.ipc$dispatch("825153516", new Object[]{this, aVar});
                return;
            }
            this.a.setComposition(aVar);
            this.a.playAnimation();
        }
    }

    /* compiled from: Taobao */
    public class c implements LottieListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        c(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // com.airbnb.lottie.LottieListener
        public void onResult(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "309022466")) {
                ipChange.ipc$dispatch("309022466", new Object[]{this, obj});
                return;
            }
            this.a.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class d implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        d(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1915419418")) {
                ipChange.ipc$dispatch("-1915419418", new Object[]{this, dVar});
                return;
            }
            this.a.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class e implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        e(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1241461243")) {
                ipChange.ipc$dispatch("1241461243", new Object[]{this, eVar});
            } else if (eVar != null && (drawable = eVar.a) != null) {
                this.a.setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements IPhenixListener<ug2> {
        private static transient /* synthetic */ IpChange $ipChange;

        f(ScrollSkipLinearView scrollSkipLinearView) {
        }

        /* renamed from: a */
        public boolean onHappen(ug2 ug2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1620939696")) {
                return ((Boolean) ipChange.ipc$dispatch("-1620939696", new Object[]{this, ug2})).booleanValue();
            }
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) ug2.f();
            animatedImageDrawable.w();
            animatedImageDrawable.v(1);
            return false;
        }
    }

    public ScrollSkipLinearView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private String getHashString(MessageDigest messageDigest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409574058")) {
            return (String) ipChange.ipc$dispatch("1409574058", new Object[]{this, messageDigest});
        }
        StringBuilder sb = new StringBuilder();
        byte[] digest = messageDigest.digest();
        for (byte b2 : digest) {
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString(b2 & 15));
        }
        return sb.toString();
    }

    private String getMD5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760378133")) {
            return (String) ipChange.ipc$dispatch("-1760378133", new Object[]{this, str});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes(Charset.forName("UTF-8")));
            return getHashString(instance);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.component.home.widget.TabLinearView, cn.damai.tetris.component.home.widget.TabLottieLinearView
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970099518")) {
            ipChange.ipc$dispatch("1970099518", new Object[]{this});
            return;
        }
        this.listener = new f(this);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.component.home.widget.TabLinearView, cn.damai.tetris.component.home.widget.TabLottieLinearView
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924216491")) {
            ipChange.ipc$dispatch("-1924216491", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView, cn.damai.tetris.component.home.widget.TabLottieLinearView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1968258910")) {
            ipChange.ipc$dispatch("1968258910", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSelectIndex = i;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i2);
            TextView textView = (TextView) viewGroup.findViewById(R$id.tv_name);
            ImageView imageView = (ImageView) viewGroup.findViewById(R$id.iv_line);
            if (i == i2) {
                textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                textView.setTextSize(1, (float) this.mDaSize);
                textView.setPadding(0, 0, 0, s50.a(getContext(), 1.0f));
                imageView.setVisibility(0);
                TUrlImageView tUrlImageView = (TUrlImageView) imageView;
                tUrlImageView.setImageUrl(i42.p("tab_indicator_anim.png"));
                tUrlImageView.succListener(this.listener);
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                textView.setTextSize(1, (float) this.mXiaoSize);
                textView.setPadding(0, s50.a(getContext(), 2.0f), 0, 0);
                imageView.setVisibility(4);
                ((TUrlImageView) imageView).setImageUrl("");
            }
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView, cn.damai.tetris.component.home.widget.TabLottieLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935063595")) {
            ipChange.ipc$dispatch("935063595", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.homepage_anchor_index_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_name);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    textView.setTextSize(1, (float) this.mXiaoSize);
                    inflate.setTag(scrollTitleBean);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams.gravity = 16;
                    inflate.setPadding(dip2px((float) (this.mSpace / 2)), 0, dip2px((float) (this.mSpace / 2)), 0);
                    inflate.setLayoutParams(layoutParams);
                    inflate.setOnClickListener(new a(this, onClickListener));
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R$id.lottie_view);
                    if (!TextUtils.isEmpty(scrollTitleBean.picUrl) || !TextUtils.isEmpty(scrollTitleBean.picJson)) {
                        lottieAnimationView.setVisibility(0);
                        if (!TextUtils.isEmpty(scrollTitleBean.picJson)) {
                            String str = scrollTitleBean.picJson;
                            LottieTask<com.airbnb.lottie.a> m = com.airbnb.lottie.b.m(str, getMD5(str));
                            m.f(new b(this, lottieAnimationView));
                            m.e(new c(this, lottieAnimationView));
                        } else if (!TextUtils.isEmpty(scrollTitleBean.picUrl)) {
                            cn.damai.common.image.a.b().h(this.mContext).c(scrollTitleBean.picUrl).n(new e(this, lottieAnimationView)).e(new d(this, lottieAnimationView)).f();
                        }
                    } else {
                        lottieAnimationView.setVisibility(8);
                    }
                    addView(inflate);
                }
            }
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView, cn.damai.tetris.component.home.widget.TabLottieLinearView
    public void startAnim(int i, float f2, float f3, float f4, float f5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "142618879")) {
            ipChange.ipc$dispatch("142618879", new Object[]{this, Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)});
        }
    }

    public ScrollSkipLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }
}
