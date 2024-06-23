package cn.damai.homepage.ui.dynamicx.preview;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.n;
import com.taobao.android.preview.DXTemplatePreviewActivity;
import tb.pt;

/* compiled from: Taobao */
public class HomeDinamicXPreview implements DXTemplatePreviewActivity.DXPreviewInterface {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.android.preview.DXTemplatePreviewActivity.DXPreviewInterface
    public void previewEngineDidInitialized(n nVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820565282")) {
            ipChange.ipc$dispatch("-820565282", new Object[]{this, nVar});
            return;
        }
        nVar.m(pt.DX_DMHOMETAGVIEW, new pt.a());
    }
}
