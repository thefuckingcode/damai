package com.taomai.android.h5container.api.base;

import androidx.fragment.app.Fragment;
import com.youku.arch.v3.event.Subject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/fragment/app/Fragment;", "invoke", "()Landroidx/fragment/app/Fragment;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TaoMaiApiPlugin$fragment$2 extends Lambda implements Function0<Fragment> {
    final /* synthetic */ TaoMaiApiPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaoMaiApiPlugin$fragment$2(TaoMaiApiPlugin taoMaiApiPlugin) {
        super(0);
        this.this$0 = taoMaiApiPlugin;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Fragment invoke() {
        Object jsObject = this.this$0.mWebView.getJsObject(Subject.FRAGMENT);
        if (!(jsObject instanceof Fragment)) {
            jsObject = null;
        }
        return (Fragment) jsObject;
    }
}
