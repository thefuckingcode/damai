package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.i;

@f(a = 7)
/* compiled from: Taobao */
public class AudioSettingComponent extends a {
    public boolean d;
    public AudioManager e;
    private SoundBroadCastReceiver f;

    /* compiled from: Taobao */
    public class SoundBroadCastReceiver extends BroadcastReceiver {
        public SoundBroadCastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int d = AudioSettingComponent.this.d();
            AudioSettingComponent.this.d = d == 0;
            ((MediaSystemComponent) e.a(MediaSystemComponent.class)).a(AudioSettingComponent.this.d);
        }
    }

    private boolean e() {
        return this.d;
    }

    private void f() {
        try {
            this.e.setRingerMode(2);
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean b() {
        if (this.f != null) {
            try {
                i.a(this.c).a(this.f);
            } catch (Throwable unused) {
            }
            this.f = null;
        }
        return super.b();
    }

    public final int d() {
        try {
            AudioManager audioManager = this.e;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        this.e = (AudioManager) activity.getSystemService("audio");
        int d2 = d();
        boolean z = this.b.soundOn;
        this.d = true;
        if (d2 == 0) {
            this.d = true;
        } else if (z) {
            this.d = false;
        }
        activity.setVolumeControlStream(3);
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a() {
        if (this.f == null) {
            this.f = new SoundBroadCastReceiver();
            i.a(this.c).a(this.f, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        }
        return super.a();
    }

    private void a(boolean z) {
        this.d = z;
    }

    private void a(Activity activity) {
        int d2 = d();
        boolean z = this.b.soundOn;
        this.d = true;
        if (d2 == 0) {
            this.d = true;
        } else if (z) {
            this.d = false;
        }
        activity.setVolumeControlStream(3);
    }
}
