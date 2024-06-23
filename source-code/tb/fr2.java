package tb;

import com.alibaba.security.common.track.model.a;
import com.uc.webview.export.extension.UCCore;

/* compiled from: Taobao */
public class fr2 {
    public static final fr2 DATAPARSE = new fr2(4, "dataParse");
    public static final fr2 DRAWVIEW = new fr2(5, "drawView");
    public static final fr2 INIT = new fr2(1, UCCore.LEGACY_EVENT_INIT);
    public static final fr2 LIFECYCLE = new fr2(2, "lifeCycle");
    public static final fr2 NETWORK = new fr2(3, a.c.h);
    public static final fr2 PAGELOAD = new fr2(6, "pageLoad");
    public static final fr2 SUB_BIND_VIEW = new fr2(8, "bindData");
    public static final fr2 SUB_CREATE_VIEW = new fr2(7, "createView");
    private String a;

    fr2(int i, String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }
}
