package com.alient.onearch.adapter.state;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.State;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

public final class StateViewManager {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DEFAULT_STATE_VIEW_CREATOR;
    private static final Lazy instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, StateViewManager$Companion$instance$2.INSTANCE);
    private final Map<String, IStateViewDelegate> stateViewDelegates = new LinkedHashMap();

    public static final class Companion {
        private Companion() {
        }

        public final StateViewManager getInstance() {
            Lazy lazy = StateViewManager.instance$delegate;
            Companion companion = StateViewManager.Companion;
            return (StateViewManager) lazy.getValue();
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public interface IStateFeature {

        public static final class DefaultImpls {
            public static /* synthetic */ void showErrorView$default(IStateFeature iStateFeature, Activity activity, String str, String str2, IStateViewListener iStateViewListener, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        str = null;
                    }
                    if ((i & 4) != 0) {
                        str2 = null;
                    }
                    if ((i & 8) != 0) {
                        iStateViewListener = null;
                    }
                    iStateFeature.showErrorView(activity, str, str2, iStateViewListener);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorView");
            }

            public static /* synthetic */ void showLoadingDialog$default(IStateFeature iStateFeature, Activity activity, String str, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        str = null;
                    }
                    if ((i & 4) != 0) {
                        z = true;
                    }
                    iStateFeature.showLoadingDialog(activity, str, z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingDialog");
            }
        }

        void hideErrorView(@Nullable Activity activity);

        void hideLoadingDialog(@Nullable Activity activity);

        void showErrorView(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable IStateViewListener iStateViewListener);

        void showLoadingDialog(@Nullable Activity activity, @Nullable String str, boolean z);

        void showToast(@NotNull String str);
    }

    public interface IStateViewDelegate extends IStateFeature {
        @Nullable
        RefreshInternal createLoadingFooterView(@Nullable Activity activity);

        @Nullable
        RefreshInternal createLoadingHeaderView(@Nullable Activity activity);

        @Nullable
        IStateView createStateView(@NotNull Context context, @NotNull ViewGroup viewGroup, @NotNull State state, @Nullable IStateViewListener iStateViewListener);
    }

    public interface IStateViewListener {
        void onRefreshClick();

        void onReportClick();
    }

    public final IStateViewDelegate getStateViewDelegate(String str) {
        k21.i(str, "pageName");
        IStateViewDelegate iStateViewDelegate = this.stateViewDelegates.get(str);
        return iStateViewDelegate != null ? iStateViewDelegate : this.stateViewDelegates.get(KEY_DEFAULT_STATE_VIEW_CREATOR);
    }

    public final void register(String str, IStateViewDelegate iStateViewDelegate) {
        k21.i(str, "pageName");
        k21.i(iStateViewDelegate, "stateViewDelegate");
        this.stateViewDelegates.put(str, iStateViewDelegate);
    }

    public final void register(IStateViewDelegate iStateViewDelegate) {
        k21.i(iStateViewDelegate, "stateViewDelegate");
        this.stateViewDelegates.put(KEY_DEFAULT_STATE_VIEW_CREATOR, iStateViewDelegate);
    }
}
