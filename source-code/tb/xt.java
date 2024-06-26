package tb;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.view.DXNativeTextView;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
public class xt extends DXTextViewWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_CENTER = 4;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_CENTERBOTTOM = 5;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_CENTERTOP = 3;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_LEFTBOTTOM = 2;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_LEFTCENTER = 1;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_LEFTTOP = 0;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_RIGHTBOTTOM = 8;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_RIGHTCENTER = 7;
    public static final int DXDMTEXTVIEW_DMTEXTGRAVITY_RIGHTTOP = 6;
    public static final long DX_DMTEXTVIEW = -2551638064931034405L;
    public static final long DX_DMTEXTVIEW_DMTEXTGRAVITY = 1935062773799059049L;
    public static final long DX_DMTEXTVIEW_FONTNAME = 2639694824232449600L;
    public static final long DX_DMTEXTVIEW_LINESPACE = -1442719518478951523L;
    public static final long DX_DMTEXTVIEW_MINLINES = 5101431237727163475L;
    public static final long USER_DEFINE_PARAM_HASH_CODE = 9999999999L;
    private String v;
    private int w;
    private String x;
    private int y;
    private int z;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1980936190")) {
                return new xt();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("1980936190", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-917114763")) {
            return new xt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-917114763", new Object[]{this, obj});
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337317940")) {
            return ((Integer) ipChange.ipc$dispatch("-1337317940", new Object[]{this, Long.valueOf(j)})).intValue();
        } else if (j == 9999999999L) {
            return -100;
        } else {
            return super.getDefaultValueForIntAttr(j);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode
    public void h(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146018020")) {
            ipChange.ipc$dispatch("-2146018020", new Object[]{this, textView});
            return;
        }
        super.h(textView);
        try {
            textView.setMinLines(this.z);
            int i = this.y;
            if (i > 0) {
                textView.setLineSpacing((float) i, 1.0f);
            }
            bn0.b(textView, this.x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode
    public void o(TextView textView, CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122887002")) {
            ipChange.ipc$dispatch("-122887002", new Object[]{this, textView, charSequence});
        } else if (TextUtils.isEmpty(charSequence)) {
            textView.setText("");
        } else {
            textView.setText(Html.fromHtml(charSequence.toString()));
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953491011")) {
            ipChange.ipc$dispatch("-1953491011", new Object[]{this});
            return;
        }
        super.onBeforeBindChildData();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281521328")) {
            ipChange.ipc$dispatch("-1281521328", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268138001")) {
            ipChange.ipc$dispatch("-268138001", new Object[]{this, dXWidgetNode, Boolean.valueOf(z2)});
            return;
        }
        super.onClone(dXWidgetNode, z2);
        if (dXWidgetNode != null && (dXWidgetNode instanceof xt)) {
            xt xtVar = (xt) dXWidgetNode;
            this.v = xtVar.v;
            this.x = xtVar.x;
            this.y = xtVar.y;
            this.z = xtVar.z;
            this.w = xtVar.w;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1343736168")) {
            return new DXNativeTextView(context);
        }
        return (View) ipChange.ipc$dispatch("1343736168", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-834605847")) {
            ipChange.ipc$dispatch("-834605847", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688843154")) {
            ipChange.ipc$dispatch("688843154", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DXNativeTextView)) {
            try {
                DXNativeTextView dXNativeTextView = (DXNativeTextView) view;
                dXNativeTextView.setMinLines(this.z);
                int i = this.y;
                if (i > 0) {
                    dXNativeTextView.setLineSpacing((float) i, 1.0f);
                }
                if (!TextUtils.isEmpty(this.x)) {
                    bn0.b(dXNativeTextView, this.x);
                }
                dXNativeTextView.setGravity(h10.a(this.w));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040370263")) {
            ipChange.ipc$dispatch("1040370263", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == -1442719518478951523L) {
            this.y = i;
        } else if (j == DX_DMTEXTVIEW_MINLINES) {
            this.z = i;
        } else if (j == DX_DMTEXTVIEW_DMTEXTGRAVITY) {
            this.w = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269215756")) {
            ipChange.ipc$dispatch("-269215756", new Object[]{this, Long.valueOf(j), str});
        } else if (j == 2639694824232449600L) {
            this.x = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
