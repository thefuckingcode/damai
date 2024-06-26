package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.view.CountDownText;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Map;

/* compiled from: Taobao */
public class WXCountDown extends WXComponent {
    private CountDownText mCountDown;

    public WXCountDown(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private int getFontSize(String str) {
        int i = WXUtils.getInt(str);
        if (i <= 0) {
            return 32;
        }
        return i;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        if (getHostView() != null) {
            this.mCountDown.destroy();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public View initComponentHostView(@NonNull Context context) {
        CountDownText countDownText = new CountDownText(getContext());
        this.mCountDown = countDownText;
        return countDownText.getView();
    }

    @WXComponentProp(name = "countdownTime")
    public void setCountdownTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mCountDown.setTime(str);
        }
    }

    @WXComponentProp(name = "fontSize")
    public void setFontSize(String str) {
        float f;
        int fontSize = getFontSize(str);
        if (fontSize > 0) {
            if (WXEnvironment.sDefaultWidth > WXViewUtils.getScreenWidth()) {
                f = WXViewUtils.getRealPxByWidth((float) (fontSize - 3));
            } else {
                f = WXViewUtils.getRealPxByWidth((float) (fontSize - 2));
            }
            this.mCountDown.setFontSize(0, (int) f);
        }
    }

    @WXComponentProp(name = "formatterValue")
    public void setFormatterValue(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mCountDown.setDateFormat(str);
        }
    }

    @WXComponentProp(name = "textColor")
    public void setTextColor(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            this.mCountDown.setCountDownTextColor(str);
        }
    }

    @WXComponentProp(name = "timeColor")
    public void setTimeColor(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            this.mCountDown.setTimeColor(str);
        }
    }

    @WXComponentProp(name = "timeFontSize")
    public void setTimeFontSize(String str) {
        float f;
        int fontSize = getFontSize(str);
        if (fontSize > 0) {
            if (WXEnvironment.sDefaultWidth > WXViewUtils.getScreenWidth()) {
                f = WXViewUtils.getRealPxByWidth((float) (fontSize - 3));
            } else {
                f = WXViewUtils.getRealPxByWidth((float) (fontSize - 2));
            }
            this.mCountDown.setTimeFontSize(0, (int) f);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(Map map) {
        super.updateProperties(map);
        this.mCountDown.start();
    }
}
