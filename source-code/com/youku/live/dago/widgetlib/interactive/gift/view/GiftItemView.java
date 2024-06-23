package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dago.widgetlib.interactive.utils.NumUtils;

/* compiled from: Taobao */
public class GiftItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    String giftId;
    TUrlImageView imageViewIcon;
    ImageView mTagIconView;
    Animation scaleAnim;
    TextView textViewFlag;
    TextView textViewLabel;
    TextView textViewName;
    TextView textViewPrice;

    public GiftItemView(Context context) {
        this(context, null);
    }

    private void showScaleAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878861650")) {
            ipChange.ipc$dispatch("-878861650", new Object[]{this});
            return;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.1f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.1f, 1.0f));
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(250L).start();
    }

    public String getGiftId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-950223339")) {
            return this.giftId;
        }
        return (String) ipChange.ipc$dispatch("-950223339", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923672013")) {
            ipChange.ipc$dispatch("-923672013", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
    }

    public void setData(GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236200021")) {
            ipChange.ipc$dispatch("-1236200021", new Object[]{this, giftInfoBean});
            return;
        }
        updateSelectState(giftInfoBean);
        String str = "";
        String fixCoinsShow = !TextUtils.isEmpty(giftInfoBean.coins) ? NumUtils.fixCoinsShow(ParseUtils.parse2Long(giftInfoBean.coins)) : str;
        if (GiftDataManager.getInstance().getUsingLaifengCoin()) {
            this.textViewPrice.setText(getContext().getResources().getString(R.string.dago_pgc_laifeng_send_gift_1, fixCoinsShow));
        } else {
            this.textViewPrice.setText("0".equals(fixCoinsShow) ? "免费" : getContext().getResources().getString(R.string.dago_pgc_send_gift_1, fixCoinsShow));
        }
        TextView textView = this.textViewName;
        if (!TextUtils.isEmpty(giftInfoBean.name)) {
            str = giftInfoBean.name;
        }
        textView.setText(str);
        this.imageViewIcon.setFadeIn(false);
        if (!TextUtils.isEmpty(giftInfoBean.icon) && !TextUtils.equals(giftInfoBean.icon, this.imageViewIcon.getImageUrl())) {
            this.imageViewIcon.setImageUrl(giftInfoBean.icon);
        }
        if (TextUtils.isEmpty(giftInfoBean.tagIcon)) {
            this.mTagIconView.setVisibility(8);
        } else {
            DagoImageLoader.getInstance().showDefault(getContext(), giftInfoBean.tagIcon, this.mTagIconView);
            this.mTagIconView.setVisibility(0);
        }
        if (TextUtils.isEmpty(giftInfoBean.label)) {
            this.textViewLabel.setVisibility(8);
        } else {
            this.textViewLabel.setText(giftInfoBean.label);
            this.textViewLabel.setVisibility(0);
        }
        if (giftInfoBean.isChecked) {
            this.imageViewIcon.postDelayed(new Runnable() {
                /* class com.youku.live.dago.widgetlib.interactive.gift.view.GiftItemView.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "885303572")) {
                        ipChange.ipc$dispatch("885303572", new Object[]{this});
                    }
                }
            }, 300);
        }
    }

    public void updateSelectState(GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527787435")) {
            ipChange.ipc$dispatch("1527787435", new Object[]{this, giftInfoBean});
            return;
        }
        this.giftId = giftInfoBean.id;
        if (giftInfoBean.isChecked) {
            setBackgroundResource(R.drawable.dago_pgc_ykl_gift_item_bg);
            showScaleAnim();
            return;
        }
        setBackground(null);
        this.scaleAnim.cancel();
    }

    public GiftItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_send_gift_item_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.imageViewIcon = (TUrlImageView) findViewById(R.id.id_image_icon);
        this.textViewPrice = (TextView) findViewById(R.id.id_tv_price);
        this.textViewName = (TextView) findViewById(R.id.id_tv_name);
        this.textViewLabel = (TextView) findViewById(R.id.id_tv_label);
        this.textViewFlag = (TextView) findViewById(R.id.id_tv_flag);
        this.mTagIconView = (ImageView) findViewById(R.id.id_iv_tag_icon);
        this.scaleAnim = AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_gift_item_selected_anim);
    }
}
