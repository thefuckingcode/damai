package com.taobao.slide.accs;

import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.slide.api.SlideLoad;
import tb.o22;

/* compiled from: Taobao */
public class SlideAccsService extends TaoBaseService {
    public static final String SERVICEID = "slider";

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        try {
            o22.g("SlideAccsService onData ", "serviseId", str, "userId", str2, Constants.KEY_DATA_ID, str3);
            if ("slider".equals(str) && bArr != null && bArr.length > 0) {
                SlideLoad.h().i(new String(bArr));
            }
        } catch (Throwable th) {
            o22.g("SlideAccsService", "onData", th);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }
}
