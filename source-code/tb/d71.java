package tb;

import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.a;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.sdk.proto.nano.Preferences;

/* compiled from: Taobao */
public final class d71 implements VrParamsProvider {
    @Override // com.google.vr.cardboard.VrParamsProvider
    public final void close() {
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final CardboardDevice.DeviceParams readDeviceParams() {
        return a.b();
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Phone.PhoneParams readPhoneParams() {
        Phone.PhoneParams e = a.e();
        return e == null ? fq1.a() : e;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Vr$VREvent.SdkConfigurationParams readSdkConfigurationParams(com.google.vr.vrcore.nano.a aVar) {
        return null;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Preferences.UserPrefs readUserPrefs() {
        return null;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final boolean updateUserPrefs(Preferences.UserPrefs userPrefs) {
        return false;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        if (deviceParams == null) {
            return a.f();
        }
        return a.g(deviceParams);
    }
}
