package com.uc.webview.export.internal.utility;

import com.uc.webview.export.internal.setup.bt;
import java.io.File;
import java.util.Comparator;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class u implements Comparator<bt> {
    u() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(bt btVar, bt btVar2) {
        int i = ((new File((String) btVar2.coreImplModule.first).lastModified() - new File((String) btVar.coreImplModule.first).lastModified()) > 0 ? 1 : ((new File((String) btVar2.coreImplModule.first).lastModified() - new File((String) btVar.coreImplModule.first).lastModified()) == 0 ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i == 0 ? 0 : -1;
    }
}
