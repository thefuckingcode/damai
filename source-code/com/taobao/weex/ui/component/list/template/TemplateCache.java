package com.taobao.weex.ui.component.list.template;

import com.taobao.weex.ui.component.list.WXCell;
import java.util.concurrent.ConcurrentLinkedQueue;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TemplateCache {
    ConcurrentLinkedQueue<WXCell> cells = new ConcurrentLinkedQueue<>();
    boolean isLoadIng = false;

    TemplateCache() {
    }
}
