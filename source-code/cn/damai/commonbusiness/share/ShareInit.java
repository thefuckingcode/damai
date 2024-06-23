package cn.damai.commonbusiness.share;

import android.app.Application;
import android.graphics.Bitmap;
import com.alibaba.pictures.moimage.DownloadImgListener;
import com.alibaba.pictures.moimage.MoImageDownloader;
import com.alibaba.pictures.moimage.MoImageLoadException;
import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class ShareInit {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ShareInit INSTANCE = new ShareInit();

    /* compiled from: Taobao */
    public static final class a implements DownloadImgListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShareManager.IDownloadImage.IDownloadListener a;

        a(ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
            this.a = iDownloadListener;
        }

        /* renamed from: a */
        public void onDownloaded(@Nullable String str, @NotNull Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1067889563")) {
                ipChange.ipc$dispatch("1067889563", new Object[]{this, str, bitmap});
                return;
            }
            k21.i(bitmap, "source");
            this.a.onSuccess(bitmap);
        }

        @Override // com.alibaba.pictures.moimage.DownloadImgListener
        public void onFail(@NotNull MoImageLoadException moImageLoadException, @Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1234604314")) {
                ipChange.ipc$dispatch("1234604314", new Object[]{this, moImageLoadException, str});
                return;
            }
            k21.i(moImageLoadException, "exception");
            this.a.onFailed();
        }
    }

    private ShareInit() {
    }

    public final void a(@Nullable String str, @NotNull ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298826117")) {
            ipChange.ipc$dispatch("298826117", new Object[]{this, str, iDownloadListener});
            return;
        }
        k21.i(iDownloadListener, "iDownloadListener");
        MoImageDownloader.g(MoImageDownloader.a.b(MoImageDownloader.Companion, null, 1, null), str, null, null, 6, null).c(new a(iDownloadListener));
    }

    public final void b(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909395100")) {
            ipChange.ipc$dispatch("1909395100", new Object[]{this, application});
            return;
        }
        k21.i(application, "application");
        ShareManager.INSTANCE.d(application, new ShareInit$init$1(application));
    }
}
