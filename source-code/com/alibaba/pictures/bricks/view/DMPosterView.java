package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$styleable;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.u50;
import tb.wf2;

/* compiled from: Taobao */
public class DMPosterView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View borderView;
    private DMDiscountLabel discountLabel;
    private RoundImageView imageView;
    private RoundImageView imageViewMask;
    private DMLabelView labelView;
    private LiveRoomView mLiveRoomView;
    private ScoreStarPosterView scoreStarView;
    private int scoreType;
    private DMCategroyTagView tagView;
    private ImageView videoIcon;

    /* compiled from: Taobao */
    public class a implements IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alient.oneservice.image.IImageSuccListener
        public void onSuccess(SuccessEvent successEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1522707501")) {
                ipChange.ipc$dispatch("-1522707501", new Object[]{this, successEvent});
                return;
            }
            DMPosterView.this.imageView.setImageDrawable(successEvent.drawable);
            DMPosterView.this.setPlaceholder(0);
        }
    }

    /* compiled from: Taobao */
    public class b implements IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alient.oneservice.image.IImageFailListener
        public void onFail(FailEvent failEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1798897706")) {
                ipChange.ipc$dispatch("-1798897706", new Object[]{this, failEvent});
                return;
            }
            DMPosterView.this.imageView.setImageDrawable(null);
            DMPosterView.this.setPlaceholder(R$drawable.bricks_uikit_default_image_bg_gradient);
        }
    }

    public DMPosterView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219639776")) {
            ipChange.ipc$dispatch("-1219639776", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DMPosterView);
        this.scoreType = obtainStyledAttributes.getInt(R$styleable.DMPosterView_scoretype, 0);
        obtainStyledAttributes.recycle();
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420543583")) {
            ipChange.ipc$dispatch("1420543583", new Object[]{this, context});
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RoundImageView roundImageView = new RoundImageView(context);
        this.imageView = roundImageView;
        roundImageView.setType(1);
        this.imageView.setBorderRadius(6);
        this.imageView.setBackgroundResource(R$drawable.bricks_uikit_default_image_bg_gradient);
        RoundImageView roundImageView2 = new RoundImageView(context);
        this.imageViewMask = roundImageView2;
        roundImageView2.setType(1);
        this.imageViewMask.setBorderRadius(6);
        this.imageViewMask.setBackgroundResource(R$drawable.bricks_uikit_default_image_bg_mask_gradient);
        this.imageViewMask.setVisibility(8);
        u50 u50 = u50.INSTANCE;
        int a2 = u50.a(context, 0.5f);
        layoutParams.leftMargin = a2;
        layoutParams.topMargin = a2;
        layoutParams.rightMargin = a2;
        layoutParams.bottomMargin = a2;
        addView(this.imageView, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.borderView = new View(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) u50.b(context, 6));
        gradientDrawable.setStroke(a2, Color.parseColor("#1A000000"));
        if (Build.VERSION.SDK_INT >= 16) {
            this.borderView.setBackground(gradientDrawable);
        } else {
            this.borderView.setBackgroundDrawable(gradientDrawable);
        }
        addView(this.borderView, layoutParams2);
        DMDiscountLabel dMDiscountLabel = new DMDiscountLabel(context);
        this.discountLabel = dMDiscountLabel;
        dMDiscountLabel.setVisibility(8);
        addView(this.discountLabel);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.rightMargin = u50.b(context, 3);
        layoutParams3.topMargin = u50.b(context, 3);
        layoutParams3.gravity = 5;
        DMCategroyTagView dMCategroyTagView = new DMCategroyTagView(context);
        this.tagView = dMCategroyTagView;
        dMCategroyTagView.setVisibility(8);
        addView(this.tagView, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.rightMargin = u50.b(context, 3);
        layoutParams4.topMargin = u50.b(context, 3);
        layoutParams4.gravity = 5;
        LiveRoomView liveRoomView = new LiveRoomView(context);
        this.mLiveRoomView = liveRoomView;
        liveRoomView.setVisibility(8);
        addView(this.mLiveRoomView, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 80;
        layoutParams5.rightMargin = u50.b(context, 14);
        DMLabelView dMLabelView = new DMLabelView(context);
        this.labelView = dMLabelView;
        dMLabelView.setVisibility(8);
        this.labelView.setLabelTextSize(9.0f);
        this.labelView.setPaddingLeft(u50.b(context, 3));
        this.labelView.setPaddingRight(u50.b(context, 3));
        this.labelView.setLabelHeight(u50.b(context, 14));
        addView(this.labelView, layoutParams5);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams6.gravity = 80;
        if (this.scoreType == 0) {
            this.scoreStarView = new ScoreStarPosterView(context);
        } else {
            this.scoreStarView = new PosterScoreCateView(context);
        }
        this.scoreStarView.setVisibility(8);
        addView(this.scoreStarView, layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(u50.b(context, 16), u50.b(context, 16));
        layoutParams7.gravity = 85;
        layoutParams7.rightMargin = u50.b(context, 2);
        layoutParams7.bottomMargin = u50.b(context, 2);
        ImageView imageView2 = new ImageView(context);
        this.videoIcon = imageView2;
        imageView2.setImageResource(R$drawable.bricks_feed_video_icon);
        this.videoIcon.setVisibility(8);
        addView(this.videoIcon, layoutParams7);
        addView(this.imageViewMask, layoutParams);
    }

    public RoundImageView getImageView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "43572589")) {
            return this.imageView;
        }
        return (RoundImageView) ipChange.ipc$dispatch("43572589", new Object[]{this});
    }

    public DMLabelView getLabelView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "848298720")) {
            return this.labelView;
        }
        return (DMLabelView) ipChange.ipc$dispatch("848298720", new Object[]{this});
    }

    public void setBorderRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1573985129")) {
            ipChange.ipc$dispatch("-1573985129", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RoundImageView roundImageView = this.imageView;
        if (roundImageView != null) {
            roundImageView.setBorderRadius(i);
        }
    }

    public void setBorderVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445439593")) {
            ipChange.ipc$dispatch("-1445439593", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.borderView;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setCategoryMargin(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509445634")) {
            ipChange.ipc$dispatch("-1509445634", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        if (this.tagView != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            u50 u50 = u50.INSTANCE;
            layoutParams.topMargin = u50.a(getContext(), f);
            layoutParams.rightMargin = u50.a(getContext(), f2);
            layoutParams.gravity = 5;
            this.tagView.setLayoutParams(layoutParams);
        }
        if (this.mLiveRoomView != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            u50 u502 = u50.INSTANCE;
            layoutParams2.topMargin = u502.a(getContext(), f);
            layoutParams2.rightMargin = u502.a(getContext(), f2);
            layoutParams2.gravity = 5;
            this.mLiveRoomView.setLayoutParams(layoutParams2);
        }
    }

    public void setCategoryTagName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894212611")) {
            ipChange.ipc$dispatch("1894212611", new Object[]{this, str});
        } else if (this.tagView != null) {
            if (!wf2.INSTANCE.c(str)) {
                LiveRoomView liveRoomView = this.mLiveRoomView;
                if (liveRoomView == null || liveRoomView.getVisibility() != 0) {
                    this.tagView.setTagName(str);
                    this.tagView.setVisibility(0);
                    return;
                }
                this.tagView.setVisibility(8);
                return;
            }
            this.tagView.setVisibility(8);
        }
    }

    public void setCategoryTagType(DMCategroyTagView.DMCategroyTagType dMCategroyTagType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368011370")) {
            ipChange.ipc$dispatch("1368011370", new Object[]{this, dMCategroyTagType});
            return;
        }
        DMCategroyTagView dMCategroyTagView = this.tagView;
        if (dMCategroyTagView != null) {
            dMCategroyTagView.setTagType(dMCategroyTagType);
        }
    }

    public void setDiscountText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276631418")) {
            ipChange.ipc$dispatch("-1276631418", new Object[]{this, str});
            return;
        }
        DMDiscountLabel dMDiscountLabel = this.discountLabel;
        if (dMDiscountLabel != null) {
            dMDiscountLabel.setVisibility(0);
            this.discountLabel.setDiscount(str);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-90242600")) {
            ipChange.ipc$dispatch("-90242600", new Object[]{this, bitmap});
        } else if (this.imageView != null && bitmap != null && !bitmap.isRecycled()) {
            this.imageView.setImageBitmap(bitmap);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004475157")) {
            ipChange.ipc$dispatch("-2004475157", new Object[]{this, drawable});
            return;
        }
        RoundImageView roundImageView = this.imageView;
        if (roundImageView != null && drawable != null) {
            roundImageView.setImageDrawable(drawable);
        }
    }

    public void setImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772506432")) {
            ipChange.ipc$dispatch("-772506432", new Object[]{this, str});
        } else if (this.imageView != null) {
            ImageLoaderProviderProxy.getProxy().loadinto(str, this.imageView);
        }
    }

    public void setImageUrlForWebp(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585029465")) {
            ipChange.ipc$dispatch("1585029465", new Object[]{this, str});
        } else if (this.imageView != null) {
            setImageUrlForWebp(str, -1, -1);
        }
    }

    public void setImageViewMaskVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "87099041")) {
            ipChange.ipc$dispatch("87099041", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RoundImageView roundImageView = this.imageViewMask;
        if (roundImageView != null && roundImageView.getVisibility() != i) {
            this.imageViewMask.setVisibility(i);
        }
    }

    public void setLabelType(DMLabelType dMLabelType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1362379852")) {
            ipChange.ipc$dispatch("1362379852", new Object[]{this, dMLabelType});
        } else if (this.labelView != null) {
            ScoreStarPosterView scoreStarPosterView = this.scoreStarView;
            if (scoreStarPosterView != null && scoreStarPosterView.getVisibility() == 0) {
                this.labelView.setVisibility(8);
            } else if (dMLabelType == null || TextUtils.isEmpty(dMLabelType.labelName)) {
                this.labelView.setVisibility(8);
            } else {
                this.labelView.setLabelTypeName(dMLabelType);
                this.labelView.setVisibility(0);
            }
        }
    }

    public void setLiveRoom(boolean z, LiveRoomView.DMLiveRoomType dMLiveRoomType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1163263888")) {
            ipChange.ipc$dispatch("1163263888", new Object[]{this, Boolean.valueOf(z), dMLiveRoomType});
            return;
        }
        LiveRoomView liveRoomView = this.mLiveRoomView;
        if (liveRoomView != null) {
            if (!z) {
                liveRoomView.setVisibility(8);
                return;
            }
            if (this.tagView.getVisibility() == 0) {
                this.tagView.setVisibility(8);
            }
            this.mLiveRoomView.setLiveType(dMLiveRoomType);
            this.mLiveRoomView.setVisibility(0);
        }
    }

    public void setPlaceholder(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89900234")) {
            ipChange.ipc$dispatch("-89900234", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RoundImageView roundImageView = this.imageView;
        if (roundImageView != null) {
            roundImageView.setBackgroundResource(i);
        }
    }

    public void setScoreAndCate(double d, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802930578")) {
            ipChange.ipc$dispatch("1802930578", new Object[]{this, Double.valueOf(d), str});
        } else if (this.scoreStarView != null) {
            if (this.labelView.getVisibility() == 0) {
                this.labelView.setVisibility(8);
            }
            ScoreStarPosterView scoreStarPosterView = this.scoreStarView;
            if (scoreStarPosterView instanceof PosterScoreCateView) {
                ((PosterScoreCateView) scoreStarPosterView).updateView(d, str);
                this.scoreStarView.setVisibility(0);
            }
        }
    }

    public void setScoreStar(double d, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1460873390")) {
            ipChange.ipc$dispatch("-1460873390", new Object[]{this, Double.valueOf(d), Boolean.valueOf(z)});
            return;
        }
        ScoreStarPosterView scoreStarPosterView = this.scoreStarView;
        if (scoreStarPosterView != null) {
            if (d <= 0.0d) {
                scoreStarPosterView.setVisibility(8);
                return;
            }
            if (this.labelView.getVisibility() == 0) {
                this.labelView.setVisibility(8);
            }
            this.scoreStarView.updateView(d, z);
            this.scoreStarView.setVisibility(0);
        }
    }

    public void setScoreStarMargin(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132704594")) {
            ipChange.ipc$dispatch("-2132704594", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        ScoreStarPosterView scoreStarPosterView = this.scoreStarView;
        if (scoreStarPosterView != null) {
            scoreStarPosterView.setScoreStarMargin(f, f2);
        }
    }

    public void setVideoIconSize(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1532847211")) {
            ipChange.ipc$dispatch("1532847211", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        } else if (this.videoIcon != null) {
            u50 u50 = u50.INSTANCE;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(u50.a(getContext(), f), u50.a(getContext(), f));
            layoutParams.gravity = 85;
            layoutParams.rightMargin = u50.a(getContext(), f2);
            layoutParams.bottomMargin = u50.a(getContext(), f2);
            this.videoIcon.setLayoutParams(layoutParams);
        }
    }

    public void setVideoIconVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768584439")) {
            ipChange.ipc$dispatch("-768584439", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView2 = this.videoIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(i);
        }
    }

    public DMPosterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMPosterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(context, attributeSet);
        initView(context);
    }

    public void setImageUrlForWebp(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1499132039")) {
            ipChange.ipc$dispatch("-1499132039", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.imageView != null) {
            ImageLoaderProviderProxy.getProxy().load(str, new a(), new b());
        }
    }

    public void setScoreStar(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294052414")) {
            ipChange.ipc$dispatch("-1294052414", new Object[]{this, Double.valueOf(d)});
            return;
        }
        ScoreStarPosterView scoreStarPosterView = this.scoreStarView;
        if (scoreStarPosterView != null) {
            if (d <= 0.0d) {
                scoreStarPosterView.setVisibility(8);
                return;
            }
            if (this.labelView.getVisibility() == 0) {
                this.labelView.setVisibility(8);
            }
            this.scoreStarView.updateView(d);
            this.scoreStarView.setVisibility(0);
        }
    }

    public void setVideoIconSize(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "273649845")) {
            ipChange.ipc$dispatch("273649845", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
        } else if (this.videoIcon != null) {
            u50 u50 = u50.INSTANCE;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(u50.a(getContext(), f), u50.a(getContext(), f));
            layoutParams.gravity = 85;
            layoutParams.rightMargin = u50.a(getContext(), f2);
            layoutParams.bottomMargin = u50.a(getContext(), f3);
            this.videoIcon.setLayoutParams(layoutParams);
        }
    }
}
