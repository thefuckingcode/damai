package com.alient.onearch.adapter;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.pictures.ut.IUTPageOperation;
import com.alibaba.pictures.ut.MovieShowUTHelper;
import com.uc.webview.export.media.MessageID;
import com.youku.arch.v3.page.GenericActivity;
import java.util.Arrays;
import java.util.Properties;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.u02;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b4\u00105J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\u0011\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013J/\u0010\u0019\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0017\"\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013J\u0010\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!J\u0010\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0013J\u0010\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&J\b\u0010)\u001a\u00020\u000fH\u0016J\n\u0010*\u001a\u0004\u0018\u00010&H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/alient/onearch/adapter/BaseActivity;", "Lcom/youku/arch/v3/page/GenericActivity;", "Lcom/alibaba/pictures/responsive/page/IResponsivePage;", "Lcom/alibaba/pictures/ut/IUTPageOperation;", "Landroid/os/Bundle;", "savedInstanceState", "Ltb/ur2;", "onCreate", "onResume", MessageID.onPause, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "responsiveLayoutState", "", "responsiveLayoutStateChanged", "onResponsiveLayout", "onDestroy", "", "getPageSPM", "getUTPageName", "controlName", "", "kvs", "onUTButtonClick", "(Ljava/lang/String;[Ljava/lang/String;)V", "key", "querySavedPageProperty", "enable", "setUTPageEnable", "spmPageName", "setUTPageName", "Landroid/app/Activity;", "activity", "startExpoTrack", "spm", "updateSPM", "Ljava/util/Properties;", "properties", "updateUTPageProperties", "enableUTReport", "getUTPageData", "Lcom/alibaba/pictures/ut/MovieShowUTHelper;", "utHelper", "Lcom/alibaba/pictures/ut/MovieShowUTHelper;", "utPageName", "Ljava/lang/String;", "getUtPageName", "()Ljava/lang/String;", "setUtPageName", "(Ljava/lang/String;)V", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public abstract class BaseActivity extends GenericActivity implements IResponsivePage, IUTPageOperation {
    private u02 responsiveActivityStateManager;
    private MovieShowUTHelper utHelper;
    @Nullable
    private String utPageName;

    public boolean enableUTReport() {
        return false;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String getPageSPM() {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            return movieShowUTHelper.getPageSPM();
        }
        return null;
    }

    @Nullable
    public Properties getUTPageData() {
        return null;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String getUTPageName() {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            return movieShowUTHelper.getUTPageName();
        }
        return null;
    }

    @Nullable
    public String getUtPageName() {
        return this.utPageName;
    }

    @Override // com.youku.arch.v3.page.GenericActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        k21.i(configuration, "newConfig");
        u02 u02 = this.responsiveActivityStateManager;
        if (u02 == null) {
            k21.A("responsiveActivityStateManager");
        }
        u02.c(configuration);
        super.onConfigurationChanged(configuration);
        u02 u022 = this.responsiveActivityStateManager;
        if (u022 == null) {
            k21.A("responsiveActivityStateManager");
        }
        u022.e(configuration);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.responsiveActivityStateManager = new u02(this, this);
        if (enableUTReport()) {
            String utPageName2 = getUtPageName();
            if (!(utPageName2 == null || utPageName2.length() == 0)) {
                MovieShowUTHelper movieShowUTHelper = new MovieShowUTHelper(this);
                movieShowUTHelper.setUTPageName(getUtPageName());
                movieShowUTHelper.setUTPageEnable(true);
                movieShowUTHelper.startExpoTrack(this);
                ur2 ur2 = ur2.INSTANCE;
                this.utHelper = movieShowUTHelper;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        u02 u02 = this.responsiveActivityStateManager;
        if (u02 == null) {
            k21.A("responsiveActivityStateManager");
        }
        u02.d();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.i();
        }
    }

    @Override // com.alibaba.pictures.responsive.page.IResponsivePage
    public void onResponsiveLayout(@Nullable Configuration configuration, int i, boolean z) {
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        MovieShowUTHelper movieShowUTHelper;
        super.onResume();
        if (enableUTReport() && (movieShowUTHelper = this.utHelper) != null) {
            movieShowUTHelper.h();
            movieShowUTHelper.updateUTPageProperties(getUTPageData());
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void onUTButtonClick(@Nullable String str, @NotNull String... strArr) {
        k21.i(strArr, "kvs");
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.onUTButtonClick(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String querySavedPageProperty(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            return movieShowUTHelper.querySavedPageProperty(str);
        }
        return null;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void setUTPageEnable(boolean z) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.setUTPageEnable(z);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void setUTPageName(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.setUTPageName(str);
        }
    }

    public void setUtPageName(@Nullable String str) {
        this.utPageName = str;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void startExpoTrack(@Nullable Activity activity) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.startExpoTrack(activity);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void updateSPM(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.updateSPM(str);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void updateUTPageProperties(@Nullable Properties properties) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.updateUTPageProperties(properties);
        }
    }
}
