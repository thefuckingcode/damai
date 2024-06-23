package cn.damai.launcher.splash.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.splash.model.bean.AdCacheResult;
import cn.damai.launcher.splash.model.bean.AdFileResult;
import cn.damai.launcher.splash.model.listener.OnAdFetchListener;
import cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener;
import cn.damai.launcher.splash.model.listener.OnAdXFlushProcessor;
import cn.damai.launcher.utils.SplashSchemaUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.g91;
import tb.s41;

/* compiled from: Taobao */
public class AdLoader implements OnAdFetchListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "AdLoader";
    private AtomicBoolean isDispatchedFail = new AtomicBoolean(false);
    private boolean isNeedUpdateUi = false;
    private Context mContext;
    @Nullable
    private OnAdSetUpUiListener mListener;
    private OnAdXFlushProcessor mXFlushProcessor;

    public AdLoader(Context context, @Nullable OnAdSetUpUiListener onAdSetUpUiListener) {
        this.mListener = onAdSetUpUiListener;
        this.mContext = context;
    }

    private void loadImg(String str, final OnBizListener<Drawable> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-83336992")) {
            ipChange.ipc$dispatch("-83336992", new Object[]{this, str, onBizListener});
            return;
        }
        a.b().c(str).n(new DMImageCreator.DMImageSuccListener() {
            /* class cn.damai.launcher.splash.model.AdLoader.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1090795507")) {
                    ipChange.ipc$dispatch("1090795507", new Object[]{this, eVar});
                    return;
                }
                Drawable drawable = eVar.a;
                if (drawable != null) {
                    onBizListener.onBizSuccess(drawable);
                } else {
                    onBizListener.onBizFail("-1", "drawable none");
                }
            }
        }).e(new DMImageCreator.DMImageFailListener() {
            /* class cn.damai.launcher.splash.model.AdLoader.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public void onFail(DMImageCreator.d dVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1454630110")) {
                    ipChange.ipc$dispatch("1454630110", new Object[]{this, dVar});
                    return;
                }
                OnBizListener onBizListener = onBizListener;
                onBizListener.onBizFail(dVar.a + "", "DMImageLoader.onFail");
            }
        }).f();
    }

    public static void log(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624124541")) {
            ipChange.ipc$dispatch("-624124541", new Object[]{str});
            return;
        }
        g91.f(TAG, str);
    }

    public void autoFetch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444491902")) {
            ipChange.ipc$dispatch("-444491902", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isNeedUpdateUi = z;
        new AdFetcher(this).doAdFetch();
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchPhaseFail(int i, String str, String str2) {
        OnAdSetUpUiListener onAdSetUpUiListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1596301766")) {
            ipChange.ipc$dispatch("1596301766", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        log("fetch phase fail: why:" + i + " reason:" + AdConstant.code2String(i) + " code:" + str + " msg:" + str2);
        OnAdXFlushProcessor onAdXFlushProcessor = this.mXFlushProcessor;
        if (onAdXFlushProcessor != null) {
            onAdXFlushProcessor.dispatchAdFetchPhaseFail(i, str, str2);
        }
        if (AdConstant.isCodeNeedClearCache(i)) {
            AdBitmapResTool.applySpSplashResString(this.mContext, "");
        }
        if (this.isNeedUpdateUi && this.isDispatchedFail.compareAndSet(false, true) && (onAdSetUpUiListener = this.mListener) != null) {
            onAdSetUpUiListener.dispatchNoneAdAction(i, str, str2);
        }
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchSuccess(@NonNull File file, @NonNull final SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035569614")) {
            ipChange.ipc$dispatch("-1035569614", new Object[]{this, file, splashResponse});
            return;
        }
        log("fetch success endTime:" + splashResponse.getEndTime() + " now:" + System.currentTimeMillis() + " " + splashResponse.getPic() + "");
        if (TextUtils.isEmpty(splashResponse.getSchema()) || SplashSchemaUtil.a(splashResponse.getSchema())) {
            splashResponse.setAdSupportUseCache(false);
            splashResponse.setEndTime(null);
        }
        OnAdXFlushProcessor onAdXFlushProcessor = this.mXFlushProcessor;
        if (onAdXFlushProcessor != null) {
            onAdXFlushProcessor.dispatchAdFetchSuccess(file, splashResponse);
        }
        AdBitmapResTool.applySpSplashResString(this.mContext, s41.e(splashResponse));
        if (this.isNeedUpdateUi && !this.isDispatchedFail.get()) {
            loadImg(file.getAbsolutePath(), new OnBizListener<Drawable>() {
                /* class cn.damai.launcher.splash.model.AdLoader.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
                public void onBizFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1158218895")) {
                        ipChange.ipc$dispatch("1158218895", new Object[]{this, str, str2});
                        return;
                    }
                    AdLoader.this.dispatchAdFetchPhaseFail(4, str, str2);
                }

                public void onBizSuccess(Drawable drawable) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-15333166")) {
                        ipChange.ipc$dispatch("-15333166", new Object[]{this, drawable});
                    } else if (AdLoader.this.mListener != null) {
                        AdLoader.this.mListener.dispatchShowAdAction(false, drawable, splashResponse);
                    }
                }
            });
        }
    }

    public AdCacheResult isShouldUseCacheAd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195056404")) {
            return (AdCacheResult) ipChange.ipc$dispatch("-1195056404", new Object[]{this});
        }
        SplashResponse spCacheSplashRes = AdBitmapResTool.getSpCacheSplashRes(this.mContext);
        if (spCacheSplashRes == null || !spCacheSplashRes.isPicUrlValid() || spCacheSplashRes.isAdEndTimeOverCurrentTime()) {
            return AdCacheResult.noneCacheAd();
        }
        if (!spCacheSplashRes.isAdSupportUseCache()) {
            return AdCacheResult.noneCacheAd();
        }
        if (!TextUtils.equals(spCacheSplashRes.getDiffCityId(), AdBitmapResTool.getCityId(this.mContext))) {
            return AdCacheResult.noneCacheAd();
        }
        AdFileResult isHasCacheAdFile = AdFile.isHasCacheAdFile(this.mContext, spCacheSplashRes.getPic());
        if (isHasCacheAdFile.isHasCacheAdFile) {
            return new AdCacheResult(true, spCacheSplashRes, isHasCacheAdFile.cacheAdFile);
        }
        return AdCacheResult.noneCacheAd();
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972277275")) {
            ipChange.ipc$dispatch("1972277275", new Object[]{this});
            return;
        }
        final AdCacheResult isShouldUseCacheAd = isShouldUseCacheAd();
        boolean z = isShouldUseCacheAd.isUseCache;
        this.mXFlushProcessor = new OnAdXFlushProcessor(z);
        if (z) {
            loadImg(isShouldUseCacheAd.adCacheFile.getAbsolutePath(), new OnBizListener<Drawable>() {
                /* class cn.damai.launcher.splash.model.AdLoader.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
                public void onBizFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1149291150")) {
                        ipChange.ipc$dispatch("-1149291150", new Object[]{this, str, str2});
                        return;
                    }
                    AdLoader.this.autoFetch(true);
                }

                public void onBizSuccess(Drawable drawable) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2095511281")) {
                        ipChange.ipc$dispatch("-2095511281", new Object[]{this, drawable});
                        return;
                    }
                    if (AdLoader.this.mListener != null) {
                        AdLoader.this.mListener.dispatchShowAdAction(true, drawable, isShouldUseCacheAd.cacheRes);
                    }
                    AdLoader.log("use cache 快速上屏 ");
                    AdLoader.this.autoFetch(false);
                }
            });
            return;
        }
        log("none use cache 开始异步加载 ");
        autoFetch(true);
    }
}
