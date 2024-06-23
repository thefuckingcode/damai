package cn.damai.tetris.component.ip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VolumeChangeObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnVolumeChangeListener a;
    private AudioManager b;

    /* compiled from: Taobao */
    public interface OnVolumeChangeListener {
        void onVolumeChange(int i);
    }

    /* compiled from: Taobao */
    public static class VolumeReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;
        private VolumeChangeObserver a;

        private boolean a(Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1255494273")) {
                return ((Boolean) ipChange.ipc$dispatch("1255494273", new Object[]{this, intent})).booleanValue();
            } else if (intent.getAction() == null || !intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3) {
                return false;
            } else {
                return true;
            }
        }

        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1835687142")) {
                ipChange.ipc$dispatch("1835687142", new Object[]{this, context, intent});
                return;
            }
            VolumeChangeObserver volumeChangeObserver = this.a;
            if (volumeChangeObserver != null && volumeChangeObserver != null && volumeChangeObserver.a != null && a(intent)) {
                this.a.a.onVolumeChange(this.a.b());
            }
        }
    }

    public VolumeChangeObserver(Context context) {
        this.b = (AudioManager) context.getSystemService("audio");
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1945171250")) {
            return this.b.getStreamVolume(3);
        }
        return ((Integer) ipChange.ipc$dispatch("-1945171250", new Object[]{this})).intValue();
    }
}
