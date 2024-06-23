package com.youku.style.core;

import com.youku.style.vo.StyleValue;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/* compiled from: Taobao */
public class StyleStack<STYLE extends Map> extends Stack<StyleValue<STYLE>> {
    private StyleValue<STYLE> pushWithPriority(StyleValue<STYLE> styleValue) {
        if (isEmpty()) {
            return (StyleValue) super.push((Object) styleValue);
        }
        removeAll(styleValue.getClass());
        if (isEmpty()) {
            return (StyleValue) super.push((Object) styleValue);
        }
        StyleValue<STYLE> styleValue2 = (StyleValue) peek();
        int i = styleValue.priority;
        int i2 = styleValue2.priority;
        if (i > i2) {
            return (StyleValue) super.push((Object) styleValue);
        }
        if (i == i2) {
            super.pop();
            return (StyleValue) super.push((Object) styleValue);
        }
        super.clear();
        super.push((Object) styleValue);
        super.push((Object) styleValue2);
        return styleValue2;
    }

    @Override // java.util.Stack
    public /* bridge */ /* synthetic */ Object push(Object obj) {
        return push((StyleValue) ((StyleValue) obj));
    }

    public void removeAll(Class cls) {
        if (!isEmpty()) {
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next != null && next.getClass() == cls) {
                    it.remove();
                }
            }
        }
    }

    public StyleValue<STYLE> push(StyleValue<STYLE> styleValue) {
        return pushWithPriority(styleValue);
    }
}
