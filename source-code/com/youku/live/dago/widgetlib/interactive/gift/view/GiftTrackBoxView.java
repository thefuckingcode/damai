package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public class GiftTrackBoxView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = GiftTrackBoxView.class.getSimpleName();
    public static int TYPE_ACTOR_TO_USER = 1;
    public static int TYPE_USER_TO_ACTOR = 0;
    public static int TYPE_USER_TO_USER = 2;
    private int currentNum = 0;
    private ImageView imageViewUserAvatar;
    private boolean isShowed = false;
    private String mAnimTextColor = "#ffd862";
    private String mGiftIconFilePath;
    private GiftTrackBean mGiftTrackBean;
    private ImageView mImageViewGiftEffect;
    private ImageView mImageViewGiftIcon;
    private RelativeLayout mLayoutGift;
    private ImageView mLightDynamicEffect;
    private Animation mScaleAnimation;
    private ImageView mShiningImage;
    private AbsoluteSizeSpan mSizeSpan;
    private SpannableStringBuilder mSpanBuilder;
    private StrokeTextView mTextViewGiftNumber;

    public GiftTrackBoxView(Context context, GiftTrackBean giftTrackBean) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_trackbox_layout, (ViewGroup) this, true);
        this.mGiftTrackBean = giftTrackBean;
        this.mSpanBuilder = new SpannableStringBuilder();
        this.mSizeSpan = new AbsoluteSizeSpan(20, true);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882784846")) {
            ipChange.ipc$dispatch("-882784846", new Object[]{this, context});
            return;
        }
        this.imageViewUserAvatar = (ImageView) findViewById(R.id.imageViewUserAvatar);
        String str = TAG;
        ((ILog) Dsl.getService(ILog.class)).d(str, "mGiftTrackBean URL = " + this.mGiftTrackBean.userIcon);
        UIUtil.setViewRoundedCorner(this.imageViewUserAvatar, UIUtil.dip2px(15));
        DagoImageLoader.getInstance().loadCircle(getContext(), this.mGiftTrackBean.userIcon, new ImageLoadListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackBoxView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-99228133")) {
                    ipChange.ipc$dispatch("-99228133", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2007454461")) {
                    ipChange.ipc$dispatch("-2007454461", new Object[]{this, bitmapDrawable});
                    return;
                }
                GiftTrackBoxView.this.imageViewUserAvatar.setImageDrawable(bitmapDrawable);
            }
        });
        this.imageViewUserAvatar.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackBoxView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1344591690")) {
                    ipChange.ipc$dispatch("1344591690", new Object[]{this, view});
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.textViewUserName);
        TextView textView2 = (TextView) findViewById(R.id.textViewGiftName);
        this.mImageViewGiftEffect = (ImageView) findViewById(R.id.imageViewGiftEffect);
        this.mLayoutGift = (RelativeLayout) findViewById(R.id.layoutGift);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.comboRootView);
        if (TextUtils.isEmpty(this.mGiftTrackBean.userName)) {
            this.mGiftTrackBean.userName = "";
        }
        GiftTrackBean giftTrackBean = this.mGiftTrackBean;
        String str2 = giftTrackBean.userId;
        String str3 = giftTrackBean.anchorId;
        String str4 = giftTrackBean.roomAnchorId;
        ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "User id = " + str2 + "|||   Anchor id= " + str3 + "||||  roomAnchor id = " + str4);
        if (TextUtils.equals(str3, str4)) {
            this.mGiftTrackBean.giftType = TYPE_USER_TO_ACTOR;
            ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "TYPE_USER_TO_ACTOR = " + str3 + AltriaXLaunchTime.SPACE + str4);
        } else if (TextUtils.equals(str2, str4)) {
            this.mGiftTrackBean.giftType = TYPE_ACTOR_TO_USER;
            ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "TYPE_ACTOR_TO_USER");
        } else if (TextUtils.isEmpty(str4) || TextUtils.equals(str2, str4) || TextUtils.equals(str3, str4)) {
            this.mGiftTrackBean.giftType = TYPE_USER_TO_ACTOR;
            ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "TYPE_USER_TO_USER");
        } else {
            this.mGiftTrackBean.giftType = TYPE_USER_TO_USER;
            ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "TYPE_USER_TO_USER");
        }
        SpannableString spannableString = new SpannableString(this.mGiftTrackBean.userName);
        if (!TextUtils.isEmpty(null)) {
            setColorSpan(context, spannableString, "#FF" + ((String) null));
        } else {
            yellowColorSpan(context, spannableString);
        }
        GiftTrackBean giftTrackBean2 = this.mGiftTrackBean;
        int i = giftTrackBean2.giftType;
        if (i == TYPE_USER_TO_ACTOR) {
            textView.setText(spannableString);
            textView2.setText(String.format("赠送%1$s", this.mGiftTrackBean.giftName));
        } else if (i == TYPE_ACTOR_TO_USER) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            yellowColorSpan(context, new SpannableString(this.mGiftTrackBean.anchorName));
            SpannableString spannableString2 = new SpannableString("回赠");
            whiteColorSpan(context, spannableString2);
            spannableStringBuilder.append((CharSequence) this.mGiftTrackBean.userName);
            spannableStringBuilder.append((CharSequence) spannableString2);
            spannableStringBuilder.append((CharSequence) this.mGiftTrackBean.anchorName);
            textView.setText(spannableStringBuilder);
            textView2.setText(this.mGiftTrackBean.giftName);
        } else if (i == TYPE_USER_TO_USER) {
            if (giftTrackBean2.isMulti()) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                yellowColorSpan(context, new SpannableString(this.mGiftTrackBean.anchorName));
                SpannableString spannableString3 = new SpannableString("赠送");
                whiteColorSpan(context, spannableString3);
                spannableStringBuilder2.append((CharSequence) this.mGiftTrackBean.userName);
                spannableStringBuilder2.append((CharSequence) spannableString3);
                spannableStringBuilder2.append((CharSequence) this.mGiftTrackBean.anchorName);
                textView.setText(spannableStringBuilder2);
                textView2.setText(this.mGiftTrackBean.giftName);
            } else {
                textView.setText(spannableString);
                textView2.setText(String.format("赠送%1$s", this.mGiftTrackBean.giftName));
            }
        }
        this.mTextViewGiftNumber = (StrokeTextView) findViewById(R.id.textViewGiftNumber);
        this.mImageViewGiftIcon = (ImageView) findViewById(R.id.imageViewGiftIcon);
        this.mScaleAnimation = AnimationUtils.loadAnimation(context, R.anim.dago_pgc_gift_item_selected_anim);
        DagoImageLoader.getInstance().showDefault(context, this.mGiftTrackBean.giftIcon, this.mImageViewGiftIcon);
        this.mImageViewGiftIcon.startAnimation(this.mScaleAnimation);
        this.mLightDynamicEffect = (ImageView) findViewById(R.id.light_dynamic_effect);
        this.mShiningImage = (ImageView) findViewById(R.id.shining_image);
        DagoImageLoader.getInstance().showDefault(context, "https://gw.alicdn.com/tfs/TB1W0xJm1L2gK0jSZFmXXc7iXXa-72-72.png", this.mShiningImage);
    }

    public static void setAllParentsClip(View view, boolean z) {
        IpChange ipChange = $ipChange;
        ViewGroup viewGroup = view;
        if (AndroidInstantRuntime.support(ipChange, "121283015")) {
            ipChange.ipc$dispatch("121283015", new Object[]{view, Boolean.valueOf(z)});
            return;
        }
        while (viewGroup.getParent() != null && (viewGroup.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            viewGroup2.setClipChildren(z);
            viewGroup2.setClipToPadding(z);
            viewGroup = viewGroup2;
        }
    }

    private void setColorSpan(Context context, SpannableString spannableString, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43235188")) {
            ipChange.ipc$dispatch("43235188", new Object[]{this, context, spannableString, str});
            return;
        }
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str)), 0, spannableString.length(), 17);
        } catch (Exception unused) {
            yellowColorSpan(context, spannableString);
        }
    }

    private void showLightAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934013397")) {
            ipChange.ipc$dispatch("1934013397", new Object[]{this});
        } else if (!this.isShowed) {
            this.isShowed = true;
            ImageView imageView = this.mLightDynamicEffect;
            if (imageView != null) {
                imageView.setVisibility(0);
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_gift_track_dynamic_effect_anim);
                this.mLightDynamicEffect.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackBoxView.AnonymousClass3 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationEnd(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1723983708")) {
                            ipChange.ipc$dispatch("-1723983708", new Object[]{this, animation});
                            return;
                        }
                        GiftTrackBoxView.this.mLightDynamicEffect.setVisibility(8);
                        GiftTrackBoxView.this.mLightDynamicEffect.clearAnimation();
                        GiftTrackBoxView.this.isShowed = false;
                    }

                    public void onAnimationRepeat(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-492325808")) {
                            ipChange.ipc$dispatch("-492325808", new Object[]{this, animation});
                        }
                    }

                    public void onAnimationStart(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-395767043")) {
                            ipChange.ipc$dispatch("-395767043", new Object[]{this, animation});
                        }
                    }
                });
            }
        }
    }

    private void whiteColorSpan(Context context, SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640733053")) {
            ipChange.ipc$dispatch("-640733053", new Object[]{this, context, spannableString});
            return;
        }
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 17);
    }

    private void yellowColorSpan(Context context, SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223087300")) {
            ipChange.ipc$dispatch("1223087300", new Object[]{this, context, spannableString});
            return;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.mAnimTextColor)), 0, spannableString.length(), 17);
    }

    public void cancelScaleAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1873311074")) {
            ipChange.ipc$dispatch("-1873311074", new Object[]{this});
            return;
        }
        this.mImageViewGiftIcon.clearAnimation();
    }

    public ImageView getGiftEffectImageView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "68781998")) {
            return this.mImageViewGiftEffect;
        }
        return (ImageView) ipChange.ipc$dispatch("68781998", new Object[]{this});
    }

    public String getGiftIconFilePath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-67983295")) {
            return this.mGiftIconFilePath;
        }
        return (String) ipChange.ipc$dispatch("-67983295", new Object[]{this});
    }

    public TextView getGiftNumberTextView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1811036270")) {
            return this.mTextViewGiftNumber;
        }
        return (TextView) ipChange.ipc$dispatch("-1811036270", new Object[]{this});
    }

    public ImageView getImageViewGiftIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "33723768")) {
            return this.mImageViewGiftIcon;
        }
        return (ImageView) ipChange.ipc$dispatch("33723768", new Object[]{this});
    }

    public ImageView getLightDynamicEffect() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-298921023")) {
            return this.mLightDynamicEffect;
        }
        return (ImageView) ipChange.ipc$dispatch("-298921023", new Object[]{this});
    }

    public void setGiftIconVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700723647")) {
            ipChange.ipc$dispatch("-700723647", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mImageViewGiftIcon.setVisibility(i);
    }

    public void setGiftNumber(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410906655")) {
            ipChange.ipc$dispatch("1410906655", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mTextViewGiftNumber != null) {
            this.mSpanBuilder.clear();
            this.mSpanBuilder.clearSpans();
            SpannableStringBuilder spannableStringBuilder = this.mSpanBuilder;
            spannableStringBuilder.append((CharSequence) (" x " + i));
            this.mSpanBuilder.setSpan(this.mSizeSpan, 0, 3, 33);
            this.mTextViewGiftNumber.setText(this.mSpanBuilder);
        }
        if (i >= 100) {
            if (this.currentNum < 100) {
                this.currentNum = i;
                this.mLayoutGift.setBackgroundResource(R.drawable.dago_pgc_ykl_gift_trackbox_100_bg);
                showLightAnim();
                this.mShiningImage.setVisibility(0);
            }
        } else if (this.currentNum == 0) {
            this.currentNum = i;
            this.mLayoutGift.setBackgroundResource(R.drawable.dago_pgc_ykl_gift_trackbox_1_bg);
            this.mShiningImage.setVisibility(8);
        }
    }
}
