package com.alient.onearch.adapter.widget.indicator;

import androidx.annotation.AnimatorRes;
import androidx.annotation.DrawableRes;
import com.alient.onearch.adapter.R;

/* compiled from: Taobao */
public class Config {
    @AnimatorRes
    int animatorResId = R.animator.indicator_scale;
    @AnimatorRes
    int animatorReverseResId = 0;
    boolean autoSize;
    @DrawableRes
    int backgroundResId = R.drawable.indicator_white_dot;
    int gravity = 17;
    int height = -1;
    int margin = -1;
    int orientation = 0;
    @DrawableRes
    int unselectedBackgroundId;
    int width = -1;

    /* compiled from: Taobao */
    public static class Builder {
        private final Config mConfig = new Config();

        public Builder animator(@AnimatorRes int i) {
            this.mConfig.animatorResId = i;
            return this;
        }

        public Builder animatorReverse(@AnimatorRes int i) {
            this.mConfig.animatorReverseResId = i;
            return this;
        }

        public Config build() {
            return this.mConfig;
        }

        public Builder drawable(@DrawableRes int i) {
            this.mConfig.backgroundResId = i;
            return this;
        }

        public Builder drawableUnselected(@DrawableRes int i) {
            this.mConfig.unselectedBackgroundId = i;
            return this;
        }

        public Builder gravity(int i) {
            this.mConfig.gravity = i;
            return this;
        }

        public Builder height(int i) {
            this.mConfig.height = i;
            return this;
        }

        public Builder margin(int i) {
            this.mConfig.margin = i;
            return this;
        }

        public Builder orientation(int i) {
            this.mConfig.orientation = i;
            return this;
        }

        public Builder width(int i) {
            this.mConfig.width = i;
            return this;
        }
    }

    Config() {
    }
}
