package com.taobao.android.dinamic;

import android.text.TextUtils;
import com.taobao.android.dinamic.constructor.DCheckBoxConstructor;
import com.taobao.android.dinamic.constructor.DCountDownTimerConstructor;
import com.taobao.android.dinamic.constructor.DFrameLayoutConstructor;
import com.taobao.android.dinamic.constructor.DHorizontalScrollLayoutConstructor;
import com.taobao.android.dinamic.constructor.DImageViewConstructor;
import com.taobao.android.dinamic.constructor.DLinearLayoutConstructor;
import com.taobao.android.dinamic.constructor.DLoopLinearLayoutConstructor;
import com.taobao.android.dinamic.constructor.DSwitchConstructor;
import com.taobao.android.dinamic.constructor.DTextInputConstructor;
import com.taobao.android.dinamic.constructor.DTextViewConstructor;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.exception.DinamicException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.o70;
import tb.w0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class DinamicViewHelper implements Serializable {
    private static Map<String, w0> eventHandlers = new HashMap();
    private static Map<String, DinamicViewAdvancedConstructor> viewConstructors = new HashMap();

    static {
        viewConstructors.put(o70.D_VIEW, new DinamicViewAdvancedConstructor());
        viewConstructors.put(o70.D_TEXT_VIEW, new DTextViewConstructor());
        viewConstructors.put(o70.D_IMAGE_VIEW, new DImageViewConstructor());
        viewConstructors.put(o70.D_FRAME_LAYOUT, new DFrameLayoutConstructor());
        viewConstructors.put(o70.D_LINEAR_LAYOUT, new DLinearLayoutConstructor());
        viewConstructors.put(o70.D_HORIZONTAL_SCROLL_LAYOUT, new DHorizontalScrollLayoutConstructor());
        viewConstructors.put(o70.D_COUNT_DOWN_TIMER_VIEW, new DCountDownTimerConstructor());
        viewConstructors.put(o70.D_LOOP_LINEAR_LAYOUT, new DLoopLinearLayoutConstructor());
        viewConstructors.put(o70.D_TEXT_INPUT, new DTextInputConstructor());
        viewConstructors.put("DCheckBox", new DCheckBoxConstructor());
        viewConstructors.put("DSwitch", new DSwitchConstructor());
    }

    DinamicViewHelper() {
    }

    static DinamicEventHandler getEventHandler(String str) {
        return eventHandlers.get(str);
    }

    static DinamicViewAdvancedConstructor getViewConstructor(String str) {
        return viewConstructors.get(str);
    }

    static void registerEventHandler(String str, w0 w0Var) throws DinamicException {
        if (TextUtils.isEmpty(str) || w0Var == null) {
            throw new DinamicException("registerEventHandler failed, eventIdentify or handler is null");
        } else if (eventHandlers.get(str) == null) {
            eventHandlers.put(str, w0Var);
        } else {
            throw new DinamicException("registerEventHandler failed, eventHander already register by current identify:" + str);
        }
    }

    static void registerReplaceEventHandler(String str, w0 w0Var) throws DinamicException {
        if (TextUtils.isEmpty(str) || w0Var == null) {
            throw new DinamicException("registerEventHandler failed, eventIdentify or handler is null");
        }
        eventHandlers.put(str, w0Var);
    }

    static void registerReplaceViewConstructor(String str, DinamicViewAdvancedConstructor dinamicViewAdvancedConstructor) throws DinamicException {
        if (TextUtils.isEmpty(str) || dinamicViewAdvancedConstructor == null) {
            throw new DinamicException("viewIdentify or assistant is null");
        }
        viewConstructors.put(str, dinamicViewAdvancedConstructor);
    }

    static void registerViewConstructor(String str, DinamicViewAdvancedConstructor dinamicViewAdvancedConstructor) throws DinamicException {
        if (TextUtils.isEmpty(str) || dinamicViewAdvancedConstructor == null) {
            throw new DinamicException("viewIdentify or assistant is null");
        } else if (viewConstructors.get(str) == null) {
            viewConstructors.put(str, dinamicViewAdvancedConstructor);
        } else {
            throw new DinamicException("assistant already registed by current identify:" + str);
        }
    }
}
