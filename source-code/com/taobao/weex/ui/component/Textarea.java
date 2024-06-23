package com.taobao.weex.ui.component;

import android.text.TextUtils;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXEditText;
import com.taobao.weex.utils.WXUtils;

/* compiled from: Taobao */
public class Textarea extends AbstractEditComponent {
    public static final int DEFAULT_ROWS = 2;
    private int mNumberOfLines = 2;

    public Textarea(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    public void appleStyleAfterCreated(WXEditText wXEditText) {
        super.appleStyleAfterCreated(wXEditText);
        String str = (String) getStyles().get(Constants.Name.ROWS);
        int i = 2;
        try {
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        wXEditText.setLines(i);
        wXEditText.setMinLines(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    public float getMeasureHeight() {
        return getMeasuredLineHeight() * ((float) this.mNumberOfLines);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    public int getVerticalGravity() {
        return 48;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent, com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        if (!str.equals(Constants.Name.ROWS)) {
            return super.setProperty(str, obj);
        }
        Integer integer = WXUtils.getInteger(obj, null);
        if (integer == null) {
            return true;
        }
        setRows(integer.intValue());
        return true;
    }

    @WXComponentProp(name = Constants.Name.ROWS)
    public void setRows(int i) {
        WXEditText wXEditText = (WXEditText) getHostView();
        if (wXEditText != null && i > 0) {
            wXEditText.setLines(i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    public void updateStyleAndAttrs() {
        super.updateStyleAndAttrs();
        Object obj = getAttrs().get(Constants.Name.ROWS);
        if (obj != null) {
            if (obj instanceof String) {
                try {
                    int parseInt = Integer.parseInt((String) obj);
                    if (parseInt > 0) {
                        this.mNumberOfLines = parseInt;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (obj instanceof Integer) {
                this.mNumberOfLines = ((Integer) obj).intValue();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    public void onHostViewInitialized(WXEditText wXEditText) {
        wXEditText.setAllowDisableMovement(false);
        super.onHostViewInitialized(wXEditText);
    }
}
