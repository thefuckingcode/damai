package cn.damai.uikit.refresh.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import tb.gd2;
import tb.s50;

/* compiled from: Taobao */
public final class SimpleHeader extends InternalAbstract implements RefreshHeader {
    private static transient /* synthetic */ IpChange $ipChange;
    private PullToRefreshHeaderView headerView;
    private int mBackgroundColor;
    private int mPaddingBottom;
    private int mPaddingTop;
    private RefreshKernel mRefreshKernel;
    private String pullDownToRefreshText;
    private String refreshingText;
    private String releaseToRefreshText;
    private String releaseToTwoLevelText;
    private TextView title;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            a[RefreshState.ReleaseToTwoLevel.ordinal()] = 3;
            try {
                a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public SimpleHeader(Context context) {
        this(context, null);
        this.mSpinnerStyle = gd2.Translate;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257726881")) {
            ipChange.ipc$dispatch("1257726881", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.headerView.onRelease();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25642504")) {
            return ((Integer) ipChange.ipc$dispatch("-25642504", new Object[]{this, refreshLayout, Boolean.valueOf(z)})).intValue();
        }
        this.headerView.onRelease();
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073873461")) {
            ipChange.ipc$dispatch("-2073873461", new Object[]{this, refreshKernel, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRefreshKernel = refreshKernel;
        refreshKernel.requestDrawBackgroundFor(this, this.mBackgroundColor);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1158616065")) {
            ipChange.ipc$dispatch("-1158616065", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.mPaddingTop, getPaddingRight(), this.mPaddingBottom);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718917560")) {
            ipChange.ipc$dispatch("1718917560", new Object[]{this, Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.headerView.onMove(false, false, i);
        super.onMoving(z, f, i, i2, i3);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848355995")) {
            ipChange.ipc$dispatch("-848355995", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359382839")) {
            ipChange.ipc$dispatch("-359382839", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.headerView.onStart(false, i, 0);
        this.headerView.onRefresh();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532686873")) {
            ipChange.ipc$dispatch("-532686873", new Object[]{this, refreshLayout, refreshState, refreshState2});
            return;
        }
        int i = a.a[refreshState2.ordinal()];
        if (i == 1) {
            this.headerView.onRefresh();
            this.title.setText(this.pullDownToRefreshText);
        } else if (i == 2) {
            this.headerView.onRefresh();
            this.title.setText(this.releaseToRefreshText);
        } else if (i == 3) {
            this.headerView.onComplete();
            this.title.setText(this.releaseToTwoLevelText);
        } else if (i == 4) {
            this.title.setText(this.refreshingText);
        }
    }

    public void setBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1273312842")) {
            ipChange.ipc$dispatch("1273312842", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBackgroundColor = i;
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestDrawBackgroundFor(this, i);
        }
    }

    public void setPullDownToRefreshText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772512206")) {
            ipChange.ipc$dispatch("-772512206", new Object[]{this, str});
            return;
        }
        this.pullDownToRefreshText = str;
    }

    public void setRefreshingText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147048110")) {
            ipChange.ipc$dispatch("-1147048110", new Object[]{this, str});
            return;
        }
        this.refreshingText = str;
    }

    public void setReleaseToRefreshText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "909973984")) {
            ipChange.ipc$dispatch("909973984", new Object[]{this, str});
            return;
        }
        this.releaseToRefreshText = str;
    }

    public void setReleaseToTwoLevelText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289439023")) {
            ipChange.ipc$dispatch("-1289439023", new Object[]{this, str});
            return;
        }
        this.releaseToTwoLevelText = str;
    }

    public SimpleHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mBackgroundColor = 16777215;
        this.mPaddingTop = 10;
        this.mPaddingBottom = 10;
        this.mSpinnerStyle = gd2.Translate;
        View.inflate(context, R$layout.simple_refresh_header, this);
        this.headerView = (PullToRefreshHeaderView) findViewById(R$id.header_view);
        this.title = (TextView) findViewById(R$id.title);
        this.headerView.getLayoutParams().height = s50.a(context, 50.0f) + this.headerView.getStatusHeight();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a2 = s50.a(context, (float) this.mPaddingTop);
                this.mPaddingTop = a2;
                int paddingRight = getPaddingRight();
                int a3 = s50.a(context, (float) this.mPaddingBottom);
                this.mPaddingBottom = a3;
                setPadding(paddingLeft, a2, paddingRight, a3);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int a4 = s50.a(context, (float) this.mPaddingTop);
                this.mPaddingTop = a4;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.mPaddingBottom = paddingBottom;
                setPadding(paddingLeft2, a4, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mPaddingTop = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a5 = s50.a(context, (float) this.mPaddingBottom);
            this.mPaddingBottom = a5;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a5);
        } else {
            this.mPaddingTop = getPaddingTop();
            this.mPaddingBottom = getPaddingBottom();
        }
        this.headerView.onReset();
    }
}
