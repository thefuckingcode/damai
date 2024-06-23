package com.alibaba.security.biometrics.service.listener;

import android.os.Bundle;
import com.alibaba.security.common.track.model.TrackLog;

/* compiled from: Taobao */
public interface OnLogTrackListener {
    void onLogTrack(TrackLog trackLog);

    void onOldLogRecord(Bundle bundle);
}
