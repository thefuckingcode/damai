package com.youku.uplayer;

import androidx.annotation.Keep;
import com.youku.player.util.c;

@Keep
/* compiled from: Taobao */
public abstract class AudioCallback {
    public static final int AUDIO_CALLBACK_MSGID_AUDIO_BUFFER = 1;
    public static final int AUDIO_CALLBACK_MSGID_AUDIO_NO = 0;
    public static final int AUDIO_CALLBACK_MSGID_AUDIO_VOLUME = 2;
    public int mMsgID = 0;

    public AudioCallback(int i) {
        c.a("AudioCallback msgId: " + i);
        this.mMsgID = i;
    }

    public void onUpdate(byte[] bArr, int i, int i2, float f) {
    }
}
