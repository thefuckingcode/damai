package com.taobao.weex.devtools.inspector.elements.android;

import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.android.FragmentCompatUtil;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ViewGroupDescriptor extends AbstractChainedDescriptor<ViewGroup> {
    private final Map<View, Object> mViewToElementMap = Collections.synchronizedMap(new WeakHashMap());

    private Object getElement(View view, Object obj) {
        return obj == this ? view : ((WeakReference) obj).get();
    }

    private Object getElementForView(ViewGroup viewGroup, View view) {
        Object obj = this.mViewToElementMap.get(view);
        if (obj != null) {
            Object element = getElement(view, obj);
            if (element != null && view.getParent() == viewGroup) {
                return element;
            }
            this.mViewToElementMap.remove(view);
        }
        Object findFragmentForView = FragmentCompatUtil.findFragmentForView(view);
        if (findFragmentForView == null || FragmentCompatUtil.isDialogFragment(findFragmentForView)) {
            this.mViewToElementMap.put(view, this);
            return view;
        }
        this.mViewToElementMap.put(view, new WeakReference(findFragmentForView));
        return findFragmentForView;
    }

    private boolean isChildVisible(View view) {
        return !(view instanceof DocumentHiddenView);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.taobao.weex.devtools.common.Accumulator] */
    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public /* bridge */ /* synthetic */ void onGetChildren(ViewGroup viewGroup, Accumulator accumulator) {
        onGetChildren(viewGroup, (Accumulator<Object>) accumulator);
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(ViewGroup viewGroup, Accumulator<Object> accumulator) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (isChildVisible(childAt)) {
                accumulator.store(getElementForView(viewGroup, childAt));
            }
        }
    }
}
