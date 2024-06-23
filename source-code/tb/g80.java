package tb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.view.DLoopLinearLayout;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class g80 {
    public static View a(Context context, View view, ew2 ew2, x70 x70) {
        z70 c = h80.c(view);
        DinamicViewAdvancedConstructor d = b.d(c.a);
        if (d == null) {
            x70.e().b().a(r70.ERROR_CODE_VIEW_NOT_FOUND, c.a);
            return null;
        }
        View initializeViewWithModule = d.initializeViewWithModule(c.a, context, null, x70);
        if (initializeViewWithModule == null) {
            x70.e().b().a(r70.ERROR_CODE_VIEW_NOT_FOUND, c.a);
            return null;
        }
        if ((initializeViewWithModule instanceof DLoopLinearLayout) && (view instanceof DLoopLinearLayout)) {
            ((DLoopLinearLayout) initializeViewWithModule).setTemplateViews(((DLoopLinearLayout) view).cloneTemplateViews());
        }
        d.applyDefaultProperty(initializeViewWithModule);
        initializeViewWithModule.setTag(c80.PROPERTY_KEY, c);
        if (!c.c.isEmpty() || !c.d.isEmpty()) {
            ew2.a().add(initializeViewWithModule);
        }
        ArrayList<String> arrayList = new ArrayList<>(20);
        arrayList.addAll(c.b.keySet());
        d.bindDataImpl(initializeViewWithModule, c.b, arrayList, x70);
        return initializeViewWithModule;
    }

    public static View b(String str, Context context, AttributeSet attributeSet, x70 x70) {
        DinamicViewAdvancedConstructor d = b.d(str);
        if (d == null) {
            x70.e().b().a(r70.ERROR_CODE_VIEW_NOT_FOUND, str);
            return null;
        }
        View initializeViewWithModule = d.initializeViewWithModule(str, context, attributeSet, x70);
        if (initializeViewWithModule == null) {
            x70.e().b().a(r70.ERROR_CODE_VIEW_NOT_FOUND, str);
            return null;
        }
        z70 handleAttributeSet = d.handleAttributeSet(attributeSet);
        d.applyDefaultProperty(initializeViewWithModule, handleAttributeSet.b, x70);
        if (!handleAttributeSet.c.isEmpty() || !handleAttributeSet.d.isEmpty()) {
            x70.e().a().add(initializeViewWithModule);
        }
        handleAttributeSet.a = str;
        initializeViewWithModule.setTag(c80.PROPERTY_KEY, handleAttributeSet);
        ArrayList<String> arrayList = new ArrayList<>(20);
        arrayList.addAll(handleAttributeSet.b.keySet());
        d.bindDataImpl(initializeViewWithModule, handleAttributeSet.b, arrayList, x70);
        return initializeViewWithModule;
    }
}
