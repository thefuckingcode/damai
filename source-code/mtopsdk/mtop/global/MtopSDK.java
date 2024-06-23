package mtopsdk.mtop.global;

import mtopsdk.mtop.intf.Mtop;

@Deprecated
/* compiled from: Taobao */
public class MtopSDK {
    @Deprecated
    public static void checkMtopSDKInit() {
        Mtop.instance(null).checkMtopSDKInit();
    }

    @Deprecated
    public static void setLogSwitch(boolean z) {
        Mtop.instance(null).logSwitch(z);
    }
}
