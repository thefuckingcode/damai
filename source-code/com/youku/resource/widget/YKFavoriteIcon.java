package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.youku.middlewareservice.provider.youku.YoukuDeviceInfoProviderProxy;
import com.youku.resource.R;
import com.youku.resource.utils.Utils;

/* compiled from: Taobao */
public class YKFavoriteIcon extends FrameLayout {
    private boolean animate;
    private boolean clicked;
    private LottieAnimationView lottieAnimationView;

    public YKFavoriteIcon(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.lottieAnimationView = (LottieAnimationView) LayoutInflater.from(context).inflate(R.layout.resource_yk_fav_icon, (ViewGroup) this, true).findViewById(R.id.favorite_icon);
        if (Utils.isDebug(context) || YoukuDeviceInfoProviderProxy.getDeviceScore() > 80) {
            this.animate = true;
        } else {
            this.animate = false;
        }
    }

    public void changeState() {
        if (this.animate) {
            if (this.clicked) {
                this.lottieAnimationView.setImageAssetsFolder("images");
                this.lottieAnimationView.setAnimation(Utils.getFavCancelIconPath(), LottieAnimationView.CacheStrategy.Strong);
                this.lottieAnimationView.playAnimation();
                this.clicked = false;
                return;
            }
            this.lottieAnimationView.setImageAssetsFolder("images");
            this.lottieAnimationView.setAnimation(Utils.getFavConfirmIconPath(), LottieAnimationView.CacheStrategy.Strong);
            this.lottieAnimationView.playAnimation();
            this.clicked = true;
        } else if (this.clicked) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_cancel);
            this.clicked = false;
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_confirm);
            this.clicked = true;
        }
    }

    public void setInitState(boolean z) {
        if (z) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_confirm);
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_cancel);
        }
        this.clicked = z;
    }

    public YKFavoriteIcon(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
