package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.scoreview.DXCommentScoreView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class it extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMCOMMENTSCOREVIEW_DMCOMMENTSCOREVIEW = 7907214141380749325L;
    public static final long DXDMCOMMENTSCOREVIEW_ISSHOWGRADIENT = -3535179027797932103L;
    public static final long DXDMCOMMENTSCOREVIEW_ISSHOWSCORE = -4936115174600481660L;
    public static final long DXDMCOMMENTSCOREVIEW_ITEMSCORE = -5480591197713763148L;
    public static final long DXDMCOMMENTSCOREVIEW_ITEMSTAR = 3528824679597546065L;
    private boolean a = true;
    private boolean b = true;
    private String c;
    private String d;

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1697896770")) {
            return new it();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("1697896770", new Object[]{this, obj});
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221904929")) {
            return ((Integer) ipChange.ipc$dispatch("-221904929", new Object[]{this, Long.valueOf(j)})).intValue();
        } else if (j == DXDMCOMMENTSCOREVIEW_ISSHOWGRADIENT || j == DXDMCOMMENTSCOREVIEW_ISSHOWSCORE) {
            return 1;
        } else {
            return super.getDefaultValueForIntAttr(j);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957085219")) {
            ipChange.ipc$dispatch("1957085219", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344417148")) {
            ipChange.ipc$dispatch("1344417148", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof it)) {
            super.onClone(dXWidgetNode, z);
            it itVar = (it) dXWidgetNode;
            this.a = itVar.a;
            this.b = itVar.b;
            this.c = itVar.c;
            this.d = itVar.d;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-630002635")) {
            return new DXCommentScoreView(context);
        }
        return (View) ipChange.ipc$dispatch("-630002635", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1663595544")) {
            ipChange.ipc$dispatch("-1663595544", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1336708918")) {
            ipChange.ipc$dispatch("1336708918", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-367517595")) {
            ipChange.ipc$dispatch("-367517595", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DXCommentScoreView)) {
            DXCommentScoreView dXCommentScoreView = (DXCommentScoreView) view;
            if (!xf2.j(this.c)) {
                try {
                    dXCommentScoreView.updateView(Double.parseDouble(this.c));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "188862372")) {
            ipChange.ipc$dispatch("188862372", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == DXDMCOMMENTSCOREVIEW_ISSHOWGRADIENT) {
            if (i == 0) {
                z = false;
            }
            this.a = z;
        } else if (j == DXDMCOMMENTSCOREVIEW_ISSHOWSCORE) {
            if (i == 0) {
                z = false;
            }
            this.b = z;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1853912257")) {
            ipChange.ipc$dispatch("1853912257", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMCOMMENTSCOREVIEW_ITEMSCORE) {
            this.c = str;
        } else if (j == DXDMCOMMENTSCOREVIEW_ITEMSTAR) {
            this.d = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
