package com.youku.resource.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* compiled from: Taobao */
public class YKSmartRefreshFooter extends InternalAbstract implements RefreshFooter {
    private static final int FINISH_DURATION_ON_FAIL = 500;
    private int footerColor;
    private YKPageFooter mFooter;
    private boolean mNoMoreData;
    private String noMoreTextStr;

    /* renamed from: com.youku.resource.widget.YKSmartRefreshFooter$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            iArr[RefreshState.Loading.ordinal()] = 1;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.LoadReleased.ordinal()] = 2;
        }
    }

    public YKSmartRefreshFooter(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void initFooterView() {
        YKPageFooter yKPageFooter = new YKPageFooter(getContext());
        this.mFooter = yKPageFooter;
        yKPageFooter.setNoMoreText(this.noMoreTextStr);
        addView(this.mFooter);
        this.mFooter.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i = this.footerColor;
        if (i != Integer.MAX_VALUE) {
            this.mFooter.setFooterColor(i);
        } else {
            this.mFooter.resetFooterColor();
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        if (this.mNoMoreData) {
            return 0;
        }
        if (this.mFooter == null) {
            initFooterView();
        }
        YKPageFooter yKPageFooter = this.mFooter;
        if (yKPageFooter != null) {
            yKPageFooter.setState(z ? 1 : 2);
        }
        if (z) {
            return 0;
        }
        return 500;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        if (!this.mNoMoreData) {
            int i = AnonymousClass1.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
            if (i == 1 || i == 2) {
                if (this.mFooter == null) {
                    initFooterView();
                }
                this.mFooter.setState(0);
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean setNoMoreData(boolean z) {
        if (this.mNoMoreData != z) {
            this.mNoMoreData = z;
            if (this.mFooter == null) {
                initFooterView();
            }
            if (z) {
                this.mFooter.setState(3);
            } else {
                this.mFooter.setState(1);
            }
        }
        return true;
    }

    public void setNoMoreTextId(@StringRes int i) {
        try {
            setNoMoreTextStr(getResources().getString(i));
        } catch (Exception unused) {
        }
    }

    public void setNoMoreTextStr(String str) {
        this.noMoreTextStr = str;
        YKPageFooter yKPageFooter = this.mFooter;
        if (yKPageFooter != null) {
            yKPageFooter.setNoMoreText(str);
        }
    }

    public void setStyleColor(String str) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            setStyleColor(i);
        }
        i = Integer.MAX_VALUE;
        setStyleColor(i);
    }

    public YKSmartRefreshFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YKSmartRefreshFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.footerColor = Integer.MAX_VALUE;
        this.noMoreTextStr = YKPageFooter.REFRESH_FOOTER_NOTHING;
    }

    public void setStyleColor(int i) {
        this.footerColor = i;
        YKPageFooter yKPageFooter = this.mFooter;
        if (yKPageFooter == null) {
            return;
        }
        if (i != Integer.MAX_VALUE) {
            yKPageFooter.setFooterColor(i);
        } else {
            yKPageFooter.resetFooterColor();
        }
    }
}
