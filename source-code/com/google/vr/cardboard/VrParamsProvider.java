package com.google.vr.cardboard;

import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.sdk.proto.nano.Preferences;
import com.google.vr.vrcore.nano.a;

/* compiled from: Taobao */
public interface VrParamsProvider {
    void close();

    CardboardDevice.DeviceParams readDeviceParams();

    Phone.PhoneParams readPhoneParams();

    Vr$VREvent.SdkConfigurationParams readSdkConfigurationParams(a aVar);

    Preferences.UserPrefs readUserPrefs();

    boolean updateUserPrefs(Preferences.UserPrefs userPrefs);

    boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams);
}
