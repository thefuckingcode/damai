package cn.damai.commonbusiness.qrcode.widget;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import cn.damai.commonbusiness.R$raw;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.mascanengine.MaEngineService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ScanHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private HandlerThread a;
    private Handler b = new Handler(this.a.getLooper());
    private Context c;
    private ScanResultCallbackProducer d;
    private MediaPlayer e;
    private MPaasScanService f;
    private int g;

    /* compiled from: Taobao */
    public interface ScanResultCallbackProducer {
        BQCScanEngine.EngineCallback makeScanResultCallback(ScanType scanType);
    }

    public ScanHandler() {
        HandlerThread handlerThread = new HandlerThread("Scan-Recognized", 10);
        this.a = handlerThread;
        handlerThread.start();
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726665223")) {
            ipChange.ipc$dispatch("-726665223", new Object[]{this});
            return;
        }
        this.a.quit();
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612377998")) {
            ipChange.ipc$dispatch("1612377998", new Object[]{this});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "771328215")) {
                    ipChange.ipc$dispatch("771328215", new Object[]{this});
                    return;
                }
                ScanHandler.this.g = 6;
                ScanHandler.this.f.setScanEnable(false);
            }
        });
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030265175")) {
            ipChange.ipc$dispatch("1030265175", new Object[]{this});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1164355225")) {
                    ipChange.ipc$dispatch("1164355225", new Object[]{this});
                    return;
                }
                ScanHandler.this.g = 4;
                ScanHandler.this.f.setScanEnable(true);
            }
        });
    }

    public void m(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730105759")) {
            ipChange.ipc$dispatch("-730105759", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1360868730")) {
                    ipChange.ipc$dispatch("1360868730", new Object[]{this});
                } else if (ScanHandler.this.d != null) {
                    MaEngineService maEngineService = new MaEngineService();
                    MPaasScanService mPaasScanService = ScanHandler.this.f;
                    ScanType scanType = ScanType.SCAN_MA;
                    mPaasScanService.regScanEngine(scanType.toBqcScanType(), maEngineService.getEngineClazz(), ScanHandler.this.d.makeScanResultCallback(scanType));
                }
            }
        });
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434963272")) {
            ipChange.ipc$dispatch("434963272", new Object[]{this});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "378301205")) {
                    ipChange.ipc$dispatch("378301205", new Object[]{this});
                    return;
                }
                ScanHandler.this.c = null;
                ScanHandler.this.d = null;
                if (ScanHandler.this.e != null) {
                    ScanHandler.this.e.release();
                    ScanHandler.this.e = null;
                }
            }
        });
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197369852")) {
            ipChange.ipc$dispatch("-1197369852", new Object[]{this});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "181787700")) {
                    ipChange.ipc$dispatch("181787700", new Object[]{this});
                    return;
                }
                ScanHandler.this.g = 0;
            }
        });
    }

    public void p(final MPaasScanService mPaasScanService) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966059209")) {
            ipChange.ipc$dispatch("-1966059209", new Object[]{this, mPaasScanService});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1557382235")) {
                    ipChange.ipc$dispatch("1557382235", new Object[]{this});
                    return;
                }
                ScanHandler.this.f = mPaasScanService;
                ScanHandler.this.g = 1;
            }
        });
    }

    public void q(final Context context, final ScanResultCallbackProducer scanResultCallbackProducer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554260206")) {
            ipChange.ipc$dispatch("-554260206", new Object[]{this, context, scanResultCallbackProducer});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-14725805")) {
                    ipChange.ipc$dispatch("-14725805", new Object[]{this});
                    return;
                }
                ScanHandler.this.c = context;
                ScanHandler.this.d = scanResultCallbackProducer;
            }
        });
    }

    public void r(final ScanType scanType, final BQCCameraParam.MaEngineType maEngineType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1370773405")) {
            ipChange.ipc$dispatch("-1370773405", new Object[]{this, scanType, maEngineType});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "967841720")) {
                    ipChange.ipc$dispatch("967841720", new Object[]{this});
                    return;
                }
                ScanHandler.this.g = 5;
                ScanHandler.this.f.setScanType(scanType.toBqcScanType(), maEngineType);
            }
        });
    }

    public void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477346361")) {
            ipChange.ipc$dispatch("-477346361", new Object[]{this});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.ScanHandler.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "574814710")) {
                    ipChange.ipc$dispatch("574814710", new Object[]{this});
                } else if (ScanHandler.this.c != null && ((AudioManager) ScanHandler.this.c.getSystemService("audio")).getStreamVolume(5) != 0) {
                    if (ScanHandler.this.e == null) {
                        ScanHandler scanHandler = ScanHandler.this;
                        scanHandler.e = MediaPlayer.create(scanHandler.c, R$raw.qrcode_completed);
                    }
                    if (ScanHandler.this.e != null) {
                        ScanHandler.this.e.start();
                    }
                }
            }
        });
    }
}
