package tb;

import android.content.Context;
import android.util.Pair;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.share.ShareMenuHelper;
import com.alibaba.pictures.share.common.share.ShareService;
import com.alibaba.pictures.share.common.ui.widget.ShareHelperCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class s92 implements ShareService.ShareActionListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ShareMenuHelper a;
    private ArrayList<ShareHelperCallback> b = new ArrayList<>();

    public s92(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = new ShareMenuHelper(context);
    }

    public final void a(@Nullable ShareHelperCallback shareHelperCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941981301")) {
            ipChange.ipc$dispatch("941981301", new Object[]{this, shareHelperCallback});
        } else if (!(CollectionsKt___CollectionsKt.J(this.b, shareHelperCallback)) && shareHelperCallback != null) {
            this.b.add(shareHelperCallback);
        }
    }

    public final void b(@Nullable ShareHelperCallback shareHelperCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740767868")) {
            ipChange.ipc$dispatch("-740767868", new Object[]{this, shareHelperCallback});
        } else if (CollectionsKt___CollectionsKt.J(this.b, shareHelperCallback)) {
            ArrayList<ShareHelperCallback> arrayList = this.b;
            Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            po2.a(arrayList).remove(shareHelperCallback);
        }
    }

    public final void c(int i, @Nullable ShareContent shareContent, @Nullable Pair<String, Object>[] pairArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524187409")) {
            ipChange.ipc$dispatch("-524187409", new Object[]{this, Integer.valueOf(i), shareContent, pairArr});
            return;
        }
        ShareMenuHelper shareMenuHelper = this.a;
        if (shareMenuHelper != null) {
            shareMenuHelper.j(Integer.valueOf(i), shareContent, pairArr);
        }
    }

    @Override // com.alibaba.pictures.share.common.share.ShareService.ShareActionListener
    public void onComplete(@Nullable ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880559975")) {
            ipChange.ipc$dispatch("1880559975", new Object[]{this, shareChannel});
            return;
        }
        ShareManager.IBitmapManager l = ShareManager.INSTANCE.b().l();
        if (l != null) {
            l.clear();
        }
        if (!this.b.isEmpty()) {
            Iterator<ShareHelperCallback> it = this.b.iterator();
            while (it.hasNext()) {
                ShareHelperCallback next = it.next();
                if (shareChannel != null) {
                    next.shareComplete(Integer.valueOf(shareChannel.value).intValue());
                }
            }
            ShareMenuHelper shareMenuHelper = this.a;
            if (shareMenuHelper != null) {
                shareMenuHelper.q(shareChannel);
            }
        }
    }

    @Override // com.alibaba.pictures.share.common.share.ShareService.ShareActionListener
    public void onException(@Nullable ShareChannel shareChannel, @Nullable ShareException shareException) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1538003729")) {
            ipChange.ipc$dispatch("-1538003729", new Object[]{this, shareChannel, shareException});
            return;
        }
        ShareManager.IBitmapManager l = ShareManager.INSTANCE.b().l();
        if (l != null) {
            l.clear();
        }
        if (!this.b.isEmpty()) {
            Iterator<ShareHelperCallback> it = this.b.iterator();
            while (it.hasNext()) {
                ShareHelperCallback next = it.next();
                if (shareChannel != null) {
                    next.shareException(Integer.valueOf(shareChannel.value).intValue(), shareException);
                }
            }
            ShareMenuHelper shareMenuHelper = this.a;
            if (shareMenuHelper != null) {
                shareMenuHelper.r(shareChannel, shareException);
            }
        }
    }
}
