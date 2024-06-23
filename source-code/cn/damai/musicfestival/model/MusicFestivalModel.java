package cn.damai.musicfestival.model;

import android.text.TextUtils;
import android.util.Pair;
import cn.damai.musicfestival.bean.AtmosphereBean;
import cn.damai.musicfestival.bean.AtmosphereShell;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.componentplugin.OnBizListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.f92;
import tb.oz0;
import tb.s41;
import tb.vz2;
import tb.wj2;
import tb.xs0;

/* compiled from: Taobao */
public class MusicFestivalModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private ContainerArg mArg;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private AtmosphereBean getAtmosphere(BaseResponse baseResponse) {
        AtmosphereShell atmosphereShell;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397779872")) {
            return (AtmosphereBean) ipChange.ipc$dispatch("1397779872", new Object[]{this, baseResponse});
        }
        if (baseResponse != null) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            if (!f92.d(arrayList)) {
                Iterator<BaseLayer> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    List<BaseSection> sections = it.next().getSections();
                    if (!f92.d(sections)) {
                        for (BaseSection baseSection : sections) {
                            if (TextUtils.equals(wj2.MUSIC_FESTIVAL_MAP_COMPONENT_ID, baseSection.getComponentId())) {
                                NodeData item = baseSection.getItem();
                                if (!(item == null || (atmosphereShell = (AtmosphereShell) s41.d(item, AtmosphereShell.class)) == null)) {
                                    return atmosphereShell.atmosphere;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d A[SYNTHETIC, Splitter:B:37:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077 A[SYNTHETIC, Splitter:B:42:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0083 A[SYNTHETIC, Splitter:B:49:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008d A[SYNTHETIC, Splitter:B:54:0x008d] */
    public static String read(int i) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120354269")) {
            return (String) ipChange.ipc$dispatch("-2120354269", new Object[]{Integer.valueOf(i)});
        }
        try {
            inputStream = xs0.a().getResources().openRawResource(i);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str = new String(byteArrayOutputStream.toByteArray());
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return str;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                byteArrayOutputStream = null;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            inputStream = null;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }

    public void load(final OnBizListener<Pair<BaseResponse, AtmosphereBean>> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863717757")) {
            ipChange.ipc$dispatch("1863717757", new Object[]{this, onBizListener});
            return;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(new MusicFestivalParams(1, this.mArg));
        TetrisRequest.overrideParams(tetrisRequest, this.mArg);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) {
            /* class cn.damai.musicfestival.model.MusicFestivalModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1390363844")) {
                    ipChange.ipc$dispatch("-1390363844", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onFail(str, str2);
                if (!oz0.b().c(str) && MusicFestivalModel.this.mArg != null) {
                    vz2.d("mtop.damai.mec.aristotle.get", str, "首屏加载失败:" + str2 + " " + MusicFestivalModel.this.mArg.patternName + " " + MusicFestivalModel.this.mArg.patternVersion);
                }
            }

            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1453616254")) {
                    ipChange.ipc$dispatch("-1453616254", new Object[]{this, baseResponse});
                    return;
                }
                onBizListener.onSuccess(new Pair(baseResponse, MusicFestivalModel.this.getAtmosphere(baseResponse)));
            }
        });
    }

    public void setArg(ContainerArg containerArg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338339466")) {
            ipChange.ipc$dispatch("-1338339466", new Object[]{this, containerArg});
            return;
        }
        this.mArg = containerArg;
    }
}
