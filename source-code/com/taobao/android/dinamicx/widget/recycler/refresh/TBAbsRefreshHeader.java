package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;

/* compiled from: Taobao */
public abstract class TBAbsRefreshHeader extends RelativeLayout {
    protected TBSwipeRefreshLayout.OnPullRefreshListener mPullRefreshListener;
    protected RefreshState mState = RefreshState.NONE;

    /* compiled from: Taobao */
    public enum RefreshHeaderStyle {
        NORMAL,
        DARK
    }

    /* compiled from: Taobao */
    public enum RefreshState {
        NONE,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        PREPARE_TO_SECOND_FLOOR,
        SECOND_FLOOR_START,
        SECOND_FLOOR_END;

        public String toString() {
            switch (a.a[ordinal()]) {
                case 1:
                    return "NONE";
                case 2:
                    return "PULL_TO_REFRESH";
                case 3:
                    return "RELEASE_TO_REFRESH";
                case 4:
                    return "REFRESHING";
                case 5:
                    return "PREPARE_TO_SECOND_FLOOR";
                case 6:
                    return "SECOND_FLOOR_START";
                case 7:
                    return "SECOND_FLOOR_END";
                default:
                    return "";
            }
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            iArr[RefreshState.NONE.ordinal()] = 1;
            a[RefreshState.PULL_TO_REFRESH.ordinal()] = 2;
            a[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            a[RefreshState.REFRESHING.ordinal()] = 4;
            a[RefreshState.PREPARE_TO_SECOND_FLOOR.ordinal()] = 5;
            a[RefreshState.SECOND_FLOOR_START.ordinal()] = 6;
            try {
                a[RefreshState.SECOND_FLOOR_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public TBAbsRefreshHeader(Context context) {
        super(context);
    }

    public abstract void changeToState(RefreshState refreshState);

    public RefreshState getCurrentState() {
        return this.mState;
    }

    public abstract View getRefreshView();

    public abstract View getSecondFloorView();

    public abstract void setProgress(float f);

    public void setPullRefreshListener(TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener) {
        this.mPullRefreshListener = onPullRefreshListener;
    }

    public abstract void setRefreshAnimation(String[] strArr, @Nullable String str);

    public abstract void setRefreshTipColor(@ColorInt int i);

    public abstract void setRefreshTips(String[] strArr);

    public abstract void setSecondFloorView(View view);

    public void switchStyle(RefreshHeaderStyle refreshHeaderStyle) {
    }
}
