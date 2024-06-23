package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.AnimationsContainer;
import com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;

/* compiled from: Taobao */
public class GiftTrackView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = GiftTrackView.class.getSimpleName();
    public static int TYPE_ACTOR_TO_USER = 1;
    public static int TYPE_USER_TO_ACTOR = 0;
    public static int TYPE_USER_TO_USER = 2;
    private int currentBgResId = R.drawable.dago_pgc_gift_track_a_bg;
    private boolean isAnimationRunning = false;
    private ImageView mBackAnimImage;
    private ImageView mFrontAnimImage;
    private GiftTrackBean mGiftTrackBean;
    private ImageView mImageViewGiftIcon;
    private int mNumber = 0;
    private TextPaint mTextPaint;
    private TextView mTextViewGiftNumber;

    public GiftTrackView(Context context, boolean z, GiftTrackBean giftTrackBean) {
        super(context);
        this.mGiftTrackBean = giftTrackBean;
        initView(context, z);
    }

    private void initPaint(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319369448")) {
            ipChange.ipc$dispatch("319369448", new Object[]{this, context});
            return;
        }
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize((float) DensityUtil.dip2px(context, 11.0f));
        this.mTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    }

    private void initView(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809107539")) {
            ipChange.ipc$dispatch("1809107539", new Object[]{this, context, Boolean.valueOf(z)});
            return;
        }
        setClipChildren(false);
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_track_item, (ViewGroup) this, true);
        initPaint(context);
        ImageView imageView = (ImageView) findViewById(R.id.iv_user_avatar);
        TextView textView = (TextView) findViewById(R.id.tv_gift_name);
        this.mBackAnimImage = (ImageView) findViewById(R.id.back_anim);
        this.mFrontAnimImage = (ImageView) findViewById(R.id.front_anim);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.combo_root_view);
        GiftTrackBean giftTrackBean = this.mGiftTrackBean;
        String str = giftTrackBean.userName;
        String str2 = giftTrackBean.anchorName;
        String str3 = giftTrackBean.giftName;
        ((TextView) findViewById(R.id.tv_user_name)).setText(str);
        if (TextUtils.isEmpty(this.mGiftTrackBean.anchorId)) {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            textView.setText(String.format(context.getString(R.string.dago_pgc_gift_box_send_to), str3));
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str2);
            yellowColorSpan(context, spannableString);
            SpannableString spannableString2 = new SpannableString("送给");
            whiteColorSpan(context, spannableString2);
            spannableStringBuilder.append((CharSequence) spannableString2);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) str3);
            textView.setText(spannableStringBuilder);
        }
        this.mTextViewGiftNumber = (TextView) findViewById(R.id.tv_gift_number);
        TextPaint textPaint = this.mTextPaint;
        this.mTextViewGiftNumber.setWidth((int) (textPaint.measureText(" x" + this.mGiftTrackBean.giftNum) + 10.0f));
        this.mImageViewGiftIcon = (ImageView) findViewById(R.id.iv_gift_icon);
        DagoImageLoader.getInstance().showCircle(getContext(), this.mGiftTrackBean.userIcon, imageView, R.drawable.dago_pgc_ykl_gift_track_bg);
        DagoImageLoader.getInstance().showDefault(getContext(), this.mGiftTrackBean.giftIcon, this.mImageViewGiftIcon);
        this.mImageViewGiftIcon.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_track_gift_icon_anim));
    }

    private void whiteColorSpan(Context context, SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469340658")) {
            ipChange.ipc$dispatch("1469340658", new Object[]{this, context, spannableString});
        }
    }

    private void yellowColorSpan(Context context, SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084104395")) {
            ipChange.ipc$dispatch("-2084104395", new Object[]{this, context, spannableString});
            return;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffd862")), 0, spannableString.length(), 17);
    }

    public ImageView getBackAnimImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2053247871")) {
            return this.mBackAnimImage;
        }
        return (ImageView) ipChange.ipc$dispatch("-2053247871", new Object[]{this});
    }

    public ImageView getFrontAnimImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1389879193")) {
            return this.mFrontAnimImage;
        }
        return (ImageView) ipChange.ipc$dispatch("1389879193", new Object[]{this});
    }

    public TextView getGiftNumberTextView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1783001087")) {
            return this.mTextViewGiftNumber;
        }
        return (TextView) ipChange.ipc$dispatch("-1783001087", new Object[]{this});
    }

    public ImageView getImageViewGiftIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "61758951")) {
            return this.mImageViewGiftIcon;
        }
        return (ImageView) ipChange.ipc$dispatch("61758951", new Object[]{this});
    }

    public int getNumber() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "738279458")) {
            return this.mNumber;
        }
        return ((Integer) ipChange.ipc$dispatch("738279458", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969004817")) {
            ipChange.ipc$dispatch("1969004817", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        clearAnimation();
        TextView textView = this.mTextViewGiftNumber;
        if (textView != null) {
            textView.clearAnimation();
        }
        ImageView imageView = this.mImageViewGiftIcon;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void setGiftNumber(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319816592")) {
            ipChange.ipc$dispatch("319816592", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mNumber = i;
        TextView textView = this.mTextViewGiftNumber;
        if (textView != null) {
            textView.setText(" x" + i);
        }
    }

    public void startTrackBgAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362995139")) {
            ipChange.ipc$dispatch("-362995139", new Object[]{this});
        } else if (isShown() && !this.isAnimationRunning) {
            this.isAnimationRunning = true;
            final FramesSequenceAnimation createProgressDialogAnim = AnimationsContainer.getInstance(getContext()).createProgressDialogAnim(this.mFrontAnimImage);
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, -0.97f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation.setDuration(1000);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, -1.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation2.setDuration(1500);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackView.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1636789485")) {
                        ipChange.ipc$dispatch("-1636789485", new Object[]{this, animation});
                        return;
                    }
                    GiftTrackView.this.mBackAnimImage.setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1344442495")) {
                        ipChange.ipc$dispatch("-1344442495", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1793502636")) {
                        ipChange.ipc$dispatch("1793502636", new Object[]{this, animation});
                        return;
                    }
                    GiftTrackView.this.mBackAnimImage.setVisibility(0);
                    GiftTrackView.this.mFrontAnimImage.startAnimation(translateAnimation);
                }
            });
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackView.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-943396780")) {
                        ipChange.ipc$dispatch("-943396780", new Object[]{this, animation});
                        return;
                    }
                    FramesSequenceAnimation framesSequenceAnimation = createProgressDialogAnim;
                    if (framesSequenceAnimation != null) {
                        framesSequenceAnimation.start();
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1019905696")) {
                        ipChange.ipc$dispatch("1019905696", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1871006035")) {
                        ipChange.ipc$dispatch("-1871006035", new Object[]{this, animation});
                        return;
                    }
                    GiftTrackView.this.mFrontAnimImage.setVisibility(0);
                }
            });
            createProgressDialogAnim.setOnAnimStopListener(new FramesSequenceAnimation.OnAnimationListener() {
                /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackView.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation.OnAnimationListener
                public void onAnimationEnd() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-448877547")) {
                        ipChange.ipc$dispatch("-448877547", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation.OnAnimationListener
                public void onAnimationStart() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2064614510")) {
                        ipChange.ipc$dispatch("2064614510", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.FramesSequenceAnimation.OnAnimationListener
                public void onAnimationStop() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1306076104")) {
                        ipChange.ipc$dispatch("-1306076104", new Object[]{this});
                        return;
                    }
                    GiftTrackView.this.mFrontAnimImage.setVisibility(8);
                    GiftTrackView.this.mBackAnimImage.setVisibility(8);
                    GiftTrackView.this.isAnimationRunning = false;
                }
            });
            this.mBackAnimImage.startAnimation(translateAnimation2);
        }
    }

    public void updateBg(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951797621")) {
            ipChange.ipc$dispatch("1951797621", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (10 <= i && i < 50) {
            int i3 = this.currentBgResId;
            int i4 = R.drawable.dago_pgc_gift_track_a_bg;
            if (i3 != i4) {
                this.currentBgResId = i4;
                this.mBackAnimImage.setImageResource(i4);
            }
        } else if (50 <= i && i < 100) {
            int i5 = this.currentBgResId;
            int i6 = R.drawable.dago_pgc_gift_track_b_bg;
            if (i5 != i6) {
                this.currentBgResId = i6;
                this.mBackAnimImage.setImageResource(i6);
            }
        } else if (i >= 100 && this.currentBgResId != (i2 = R.drawable.dago_pgc_gift_track_c_bg)) {
            this.currentBgResId = i2;
            this.mBackAnimImage.setImageResource(i2);
        }
        if (i >= 10) {
            startTrackBgAnim();
        }
    }
}
