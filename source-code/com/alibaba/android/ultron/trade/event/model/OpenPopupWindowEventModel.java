package com.alibaba.android.ultron.trade.event.model;

import java.io.Serializable;

/* compiled from: Taobao */
public class OpenPopupWindowEventModel implements Serializable {
    Css css;
    Options options;

    /* compiled from: Taobao */
    public static class Css implements Serializable {
        String height = "0.6";
        String maxHeight;
        String minHeight;

        public String getHeight() {
            return this.height;
        }

        public String getMaxHeight() {
            return this.maxHeight;
        }

        public String getMinHeight() {
            return this.minHeight;
        }

        public void setHeight(String str) {
            this.height = str;
        }

        public void setMaxHeight(String str) {
            this.maxHeight = str;
        }

        public void setMinHeight(String str) {
            this.minHeight = str;
        }
    }

    /* compiled from: Taobao */
    public static class Options implements Serializable {
        String needCloseButton = "true";

        public String getNeedCloseButton() {
            return this.needCloseButton;
        }

        public void setNeedCloseButton(String str) {
            this.needCloseButton = str;
        }
    }

    public Css getCss() {
        return this.css;
    }

    public Options getOptions() {
        return this.options;
    }

    public void setCss(Css css2) {
        this.css = css2;
    }

    public void setOptions(Options options2) {
        this.options = options2;
    }
}
