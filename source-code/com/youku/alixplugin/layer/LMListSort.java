package com.youku.alixplugin.layer;

import com.tencent.open.SocialConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
public class LMListSort<E> {
    public void Sort(List<E> list, final String str, final String str2) {
        Collections.sort(list, new Comparator<E>() {
            /* class com.youku.alixplugin.layer.LMListSort.AnonymousClass1 */

            @Override // java.util.Comparator
            public int compare(E e, E e2) {
                int i;
                try {
                    Method method = e.getClass().getMethod(str, null);
                    Method method2 = e2.getClass().getMethod(str, null);
                    String str = str2;
                    if (str == null || !SocialConstants.PARAM_APP_DESC.equals(str)) {
                        i = method.invoke(e, null).toString().compareTo(method2.invoke(e2, null).toString());
                    } else {
                        i = method2.invoke(e2, null).toString().compareTo(method.invoke(e, null).toString());
                    }
                    return i;
                } catch (NoSuchMethodException e3) {
                    LMUtilLog.debugLog(LMListSort.class, "NoSuchMethodException " + e3);
                    return 0;
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return 0;
                } catch (IllegalAccessException e5) {
                    e5.printStackTrace();
                    return 0;
                } catch (InvocationTargetException e6) {
                    e6.printStackTrace();
                    return 0;
                }
            }
        });
    }
}
