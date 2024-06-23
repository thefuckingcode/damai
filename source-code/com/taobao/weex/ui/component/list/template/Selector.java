package com.taobao.weex.ui.component.list.template;

import android.text.TextUtils;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.list.WXCell;
import java.util.List;

/* compiled from: Taobao */
public class Selector {
    public static void closest(WXComponent wXComponent, String str, List<WXComponent> list) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.replaceAll("\\[|]", "").split("=");
            if (split.length > 0) {
                String str2 = split[0];
                String str3 = null;
                if (split.length > 1) {
                    str3 = split[1].trim();
                }
                closestByAttrs(wXComponent, str2, str3, list);
            }
        }
    }

    private static void closestByAttrs(WXComponent wXComponent, String str, String str2, List<WXComponent> list) {
        if (matchAttrs(wXComponent, str, str2)) {
            list.add(wXComponent);
        }
        if (!(wXComponent instanceof WXCell) && !(wXComponent instanceof WXRecyclerTemplateList)) {
            queryElementAllByAttrs(wXComponent.getParent(), str, str2, list);
        }
    }

    private static boolean matchAttrs(WXComponent wXComponent, String str, String str2) {
        if (wXComponent.isWaste() || !wXComponent.getAttrs().containsKey(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        Object obj = wXComponent.getAttrs().get(str);
        if (obj == null) {
            return false;
        }
        return str2.equals(obj.toString());
    }

    public static void queryElementAll(WXComponent wXComponent, String str, List<WXComponent> list) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.replaceAll("\\[|]", "").split("=");
            if (split.length > 0) {
                String str2 = split[0];
                String str3 = null;
                if (split.length > 1) {
                    str3 = split[1].trim();
                }
                if (wXComponent instanceof WXVContainer) {
                    WXVContainer wXVContainer = (WXVContainer) wXComponent;
                    for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                        queryElementAllByAttrs(wXVContainer.getChild(i), str2, str3, list);
                    }
                }
            }
        }
    }

    private static void queryElementAllByAttrs(WXComponent wXComponent, String str, String str2, List<WXComponent> list) {
        if (matchAttrs(wXComponent, str, str2)) {
            list.add(wXComponent);
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                queryElementAllByAttrs(wXVContainer.getChild(i), str, str2, list);
            }
        }
    }
}
