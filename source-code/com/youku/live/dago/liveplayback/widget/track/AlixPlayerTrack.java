package com.youku.live.dago.liveplayback.widget.track;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import cn.damai.category.category.ui.ShowFragment;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.ITrack;
import com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnNotifyListener;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.live.dago.liveplayback.widget.AlixLivePlayback;
import com.youku.live.dago.liveplayback.widget.BusinessTrack;
import com.youku.live.dago.liveplayback.widget.model.SeiDelay;
import com.youku.live.dago.liveplayback.widget.ut.LaifengVVParams;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.ntpsync.NtpSyncUtils;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.track.OnePlayTrack;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class AlixPlayerTrack extends OnPlayerTrackListener implements OnInfoListener, OnChangeVideoListener, OnVideoStreamListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Quality mAbrGearQuality = Quality.UNKNOWN;
    private BusinessTrack mBusinessTrack;
    private Context mContext;
    private boolean mIsAppear = false;
    private OnNotifyListener mOnNotifyListener = new OnNotifyListener() {
        /* class com.youku.live.dago.liveplayback.widget.track.AlixPlayerTrack.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.alixplugin.OnNotifyListener
        public void onNotify(Intent intent, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1078491031")) {
                ipChange.ipc$dispatch("-1078491031", new Object[]{this, intent, obj});
            } else if ("LFLWDataCenterAHDR".equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra("isAudioHbr");
                if (AlixPlayerTrack.this.mBusinessTrack != null) {
                    AlixPlayerTrack.this.mBusinessTrack.put("isAudioHbr", stringExtra);
                    if ("1".equals(stringExtra)) {
                        AlixPlayerTrack.this.mBusinessTrack.put("useAudioHbr", "1");
                    }
                }
                ITrack track = AlixPlayerTrack.this.mPlayerContainer.getPlayerTrack().getTrack();
                if (track != null) {
                    track.putString("isAudioHbr", stringExtra);
                    if ("1".equals(stringExtra)) {
                        track.putString("useAudioHbr", "1");
                    }
                }
            }
        }
    };
    private AlixLivePlayback.PlaybackVariables mPlaybackVariables;
    private IPlayerContainer mPlayerContainer;
    private String mSdkVersion;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.live.dago.liveplayback.widget.track.AlixPlayerTrack$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[Quality.values().length];
            $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality = iArr;
            iArr[Quality.HD3GP.ordinal()] = 1;
            $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.SD.ordinal()] = 2;
            $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD.ordinal()] = 3;
            $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD2.ordinal()] = 4;
            $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD3.ordinal()] = 5;
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD4K.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public AlixPlayerTrack(AlixPlayerContext alixPlayerContext, IPlayerContainer iPlayerContainer) {
        this.mContext = alixPlayerContext.getContext();
        this.mPlayerContainer = iPlayerContainer;
        iPlayerContainer.getPlayerTrack().addPlayerTrackInfoListener(this);
        iPlayerContainer.addVideoStreamListener(this);
        iPlayerContainer.addChangeVideoListener(this);
        alixPlayerContext.addNotifyListener(this.mOnNotifyListener);
    }

    private void playStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495587729")) {
            ipChange.ipc$dispatch("495587729", new Object[]{this});
        } else if (this.mBusinessTrack != null) {
            int autoAbsGear = getAutoAbsGear();
            if (autoAbsGear != -1) {
                BusinessTrack businessTrack = this.mBusinessTrack;
                businessTrack.put("abrCurrentGear", autoAbsGear + "");
            }
            if (!(this.mPlayerContainer.getVideoStream() == null || this.mPlayerContainer.getVideoStream().getCurAlixVideoItem() == null)) {
                this.mBusinessTrack.put("real_format", this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getStreamType());
            }
            this.mBusinessTrack.reportPlayStart();
        }
    }

    private void updateUtParamsWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398995316")) {
            ipChange.ipc$dispatch("-398995316", new Object[]{this, liveFullInfoData});
        } else if (liveFullInfoData != null) {
            Long l = liveFullInfoData.liveId;
            String valueOf = l != null ? String.valueOf(l) : "";
            Long l2 = liveFullInfoData.screenId;
            if (l2 != null) {
                str = String.valueOf(l2);
            } else {
                str = "";
            }
            String str5 = liveFullInfoData.clientIp;
            if (str5 == null) {
                str5 = "";
            }
            Long l3 = liveFullInfoData.categoryId;
            if (l3 != null) {
                str2 = String.valueOf(l3);
            } else {
                str2 = "";
            }
            Integer num = liveFullInfoData.liveStatus;
            if (num != null) {
                str3 = String.valueOf(num);
            } else {
                str3 = "";
            }
            if (liveFullInfoData.liveStatus != null) {
                str4 = String.valueOf(liveFullInfoData.bizType);
            } else {
                str4 = "";
            }
            HashMap hashMap = new HashMap(16);
            hashMap.put("intrIP", str5);
            hashMap.put("categoryId", str2);
            hashMap.put(ShowFragment.CATEGORYNAME_KEY, "");
            hashMap.put("play_type", str3);
            hashMap.put("isvip_rt", "n");
            hashMap.put("biz_type", str4);
            if (str4.equals("2")) {
                hashMap.put("live_type", "5");
            } else if (str4.equals("3")) {
                hashMap.put("live_type", "4");
            } else if (str4.equals("11")) {
                hashMap.put("live_type", "6");
            } else {
                hashMap.put("live_type", "1");
            }
            hashMap.put("screen_id", str);
            hashMap.put("view", "默认");
            hashMap.put("topic_id", "");
            hashMap.put("outArgs", "");
            hashMap.put("roomid", valueOf);
            hashMap.put("liveid", valueOf);
            hashMap.put("type", OnePlayTrack.PlayType.BEGIN);
            hashMap.put("video_ctype", "UGC");
            hashMap.put("play_decoding", "1");
            BusinessTrack businessTrack = this.mBusinessTrack;
            if (businessTrack != null) {
                businessTrack.putAll(hashMap);
            }
        }
    }

    public void destory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170083019")) {
            ipChange.ipc$dispatch("170083019", new Object[]{this});
            return;
        }
        this.mPlaybackVariables = null;
    }

    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731745387")) {
            ipChange.ipc$dispatch("1731745387", new Object[]{this});
            return;
        }
        this.mIsAppear = true;
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            businessTrack.setAppear(true);
            this.mBusinessTrack.reportPlayStart();
        }
    }

    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102293607")) {
            ipChange.ipc$dispatch("2102293607", new Object[]{this});
            return;
        }
        this.mIsAppear = false;
        if (this.mBusinessTrack != null) {
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (!(iPlayerContainer == null || iPlayerContainer.getPlayerTrack() == null || this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() == null)) {
                BusinessTrack businessTrack = this.mBusinessTrack;
                businessTrack.put("rotateStayTime", this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().getRotateStayTime() + "");
            }
            this.mBusinessTrack.reportPlayEnd();
        }
        if (this.mPlayerContainer.getPlayerTrack() != null) {
            Bundle bundle = new Bundle();
            bundle.putString("from", "live");
            this.mPlayerContainer.getPlayerTrack().onAction("onVVEnd", bundle);
        }
    }

    public int getAutoAbsGear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1752659586")) {
            return ((Integer) ipChange.ipc$dispatch("1752659586", new Object[]{this})).intValue();
        }
        switch (AnonymousClass2.$SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[this.mAbrGearQuality.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return -1;
        }
    }

    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005138991")) {
            ipChange.ipc$dispatch("-2005138991", new Object[]{this, configuration});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            int i = configuration.orientation;
            if (i == 1) {
                businessTrack.put("screenType", "0");
                if (this.mPlaybackVariables.getFirstVideoOrientation() == Orientation.ORIENTATION_PORTAIT) {
                    this.mBusinessTrack.put("direction", "vplayer");
                } else {
                    this.mBusinessTrack.put("direction", "vhplayer");
                }
            } else if (i == 2) {
                businessTrack.put("screenType", "1");
                if (this.mPlaybackVariables.getFirstVideoOrientation() == Orientation.ORIENTATION_LANDSCAPE) {
                    this.mBusinessTrack.put("direction", "fplayer");
                }
            }
        }
    }

    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162090748")) {
            ipChange.ipc$dispatch("162090748", new Object[]{this, activityLifecycleState});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            if (activityLifecycleState == ActivityLifecycleState.STARTED) {
                businessTrack.putHeatArgs("background_mode", "0");
            } else if (activityLifecycleState == ActivityLifecycleState.STOPPED) {
                businessTrack.putHeatArgs("background_mode", "1");
            }
        }
        if (this.mPlayerContainer.getPlayerTrack().getTrack() == null) {
            return;
        }
        if (activityLifecycleState == ActivityLifecycleState.STARTED) {
            this.mPlayerContainer.getPlayerTrack().getTrack().putString("background_mode", "0");
        } else if (activityLifecycleState == ActivityLifecycleState.STOPPED) {
            this.mPlayerContainer.getPlayerTrack().getTrack().putString("background_mode", "1");
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
    public void onChangeVideo(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "888927667")) {
            ipChange.ipc$dispatch("888927667", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            businessTrack.put("changeType", "1");
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
    public void onChangeVideoFinish(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841976108")) {
            ipChange.ipc$dispatch("-1841976108", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataFail(VideoRequestError videoRequestError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246669378")) {
            ipChange.ipc$dispatch("-246669378", new Object[]{this, videoRequestError});
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i;
        String str9;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1937998275")) {
            ipChange.ipc$dispatch("-1937998275", new Object[]{this, youkuVideoInfo});
            return;
        }
        String str10 = "0";
        if (this.mBusinessTrack == null || youkuVideoInfo.getLiveInfo() == null || youkuVideoInfo.getLiveInfo().videoInfo == null) {
            str4 = "2";
            str8 = str10;
            str6 = str8;
            str7 = null;
            str5 = null;
            str3 = null;
            str2 = null;
            str = null;
        } else {
            VideoInfo videoInfo = youkuVideoInfo.getLiveInfo().videoInfo;
            str7 = videoInfo.screenId;
            boolean z = videoInfo.isLaifengPk;
            str5 = z ? "2" : "1";
            if (z) {
                str6 = "1";
            } else {
                str6 = str10;
            }
            str4 = videoInfo.videoFormat;
            if (str4 == null) {
                str4 = "2";
            }
            str3 = videoInfo.protocol;
            str2 = videoInfo.bizType;
            str = videoInfo.pushStreamType;
            LivePlayControl livePlayControl = videoInfo.livePlayControl;
            if (livePlayControl != null) {
                if (livePlayControl.paid) {
                    str9 = "1";
                } else {
                    str9 = str10;
                }
                if (!"mic".equals(livePlayControl.streamMode) || !PushConstants.URI_PACKAGE_NAME.equals(livePlayControl.micMode) || livePlayControl.mcu != 1) {
                    str8 = str10;
                    str10 = str9;
                } else {
                    str10 = str9;
                    str8 = "1";
                }
            } else {
                str8 = str10;
            }
            BypassPlayInfo bypassPlayInfo = youkuVideoInfo.getLiveInfo().bypassPlayInfo;
            if (bypassPlayInfo != null) {
                BusinessTrack businessTrack = this.mBusinessTrack;
                businessTrack.put("videoCode", bypassPlayInfo.h265 + "");
            }
        }
        BusinessTrack businessTrack2 = this.mBusinessTrack;
        if (businessTrack2 != null) {
            businessTrack2.put("screen_id", str7);
            this.mBusinessTrack.put("instanceCount", str5);
            this.mBusinessTrack.put("video_format", str4);
            this.mBusinessTrack.put("protocol", str3);
            this.mBusinessTrack.put("biz_type", str2);
            this.mBusinessTrack.put("pushStreamType", str);
            this.mBusinessTrack.put("isFreeView", str10);
            if ("2".equals(str2)) {
                this.mBusinessTrack.put("live_type", "5");
            } else if ("3".equals(str2)) {
                this.mBusinessTrack.put("live_type", "4");
            } else if ("11".equals(str2)) {
                this.mBusinessTrack.put("live_type", "6");
            } else {
                this.mBusinessTrack.put("live_type", "1");
            }
            this.mBusinessTrack.put("ispk", str6);
            this.mBusinessTrack.put("ismcu", str8);
            AlixVideoItem curAlixVideoItem = this.mPlayerContainer.getVideoStream().getCurAlixVideoItem();
            if (youkuVideoInfo == null || youkuVideoInfo.getLivePlayControl() == null) {
                i = 0;
            } else {
                i = 0;
                for (com.youku.android.liveservice.bean.Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                    if (curAlixVideoItem != null && quality.quality == curAlixVideoItem.getLiveQuality()) {
                        i = quality.bizSwitch.abr;
                    }
                }
                BusinessTrack businessTrack3 = this.mBusinessTrack;
                businessTrack3.put("hbrHit", youkuVideoInfo.getLivePlayControl().hbrHit + "");
            }
            this.mBusinessTrack.remove("abrCurrentGear");
            this.mBusinessTrack.remove("streamGroup");
            if (i > 0) {
                this.mBusinessTrack.put("abrCurrentGear", "-1");
            }
            this.mBusinessTrack.put("real_format", curAlixVideoItem != null ? curAlixVideoItem.getStreamType() : null);
            this.mBusinessTrack.putAll(new LaifengVVParams().getVVCommonParams(this.mContext, str2));
        }
    }

    @Override // com.youku.alixplayer.OnInfoListener
    public void onInfo(int i, int i2, int i3, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901227905")) {
            ipChange.ipc$dispatch("1901227905", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            if (i == 2016) {
                this.mAbrGearQuality = Quality.getQualityByAbrCode(i2);
                int autoAbsGear = getAutoAbsGear();
                if (autoAbsGear != -1) {
                    BusinessTrack businessTrack2 = this.mBusinessTrack;
                    businessTrack2.put("abrCurrentGear", autoAbsGear + "");
                }
            } else if (i == 2017) {
                businessTrack.put("streamGroup", String.valueOf(i2));
                Logger.e("upper live group " + i2);
            } else if (2012 == i) {
                try {
                    long longValue = JSON.parseArray((String) obj).getJSONObject(0).getLong("ext").longValue();
                    SeiDelay seiDelay = new SeiDelay();
                    long offset = NtpSyncUtils.getOffset();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = (currentTimeMillis + offset) - longValue;
                    seiDelay.mDelay = j;
                    seiDelay.ntpOffset = offset;
                    seiDelay.localTimestamp = currentTimeMillis + "";
                    seiDelay.seiTimestamp = String.valueOf(longValue);
                    BusinessTrack businessTrack3 = this.mBusinessTrack;
                    if (businessTrack3 != null) {
                        businessTrack3.setDelay(j);
                        this.mBusinessTrack.setSeiDelay(seiDelay);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    String[] split = ((String) obj).split("=");
                    long parseLong = Long.parseLong(split[1]);
                    SeiDelay seiDelay2 = new SeiDelay();
                    long offset2 = NtpSyncUtils.getOffset();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j2 = (currentTimeMillis2 + offset2) - parseLong;
                    seiDelay2.mDelay = j2;
                    seiDelay2.ntpOffset = offset2;
                    seiDelay2.localTimestamp = currentTimeMillis2 + "";
                    seiDelay2.seiTimestamp = split[1];
                    BusinessTrack businessTrack4 = this.mBusinessTrack;
                    if (businessTrack4 != null) {
                        businessTrack4.setDelay(j2);
                        this.mBusinessTrack.setSeiDelay(seiDelay2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void onLiveFullInfoReady(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849803318")) {
            ipChange.ipc$dispatch("849803318", new Object[]{this, liveFullInfoData});
            return;
        }
        Long l = liveFullInfoData.screenId;
        String valueOf = l != null ? String.valueOf(l) : "";
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            businessTrack.put("screen_id", valueOf);
        }
        updateUtParamsWithLiveFullInfo(liveFullInfoData);
    }

    @Override // com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener
    public void onMonitorPoint(ITrack iTrack, String str, OnPlayerTrackListener.Result result) {
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-302406176")) {
            ipChange.ipc$dispatch("-302406176", new Object[]{this, iTrack, str, result});
            return;
        }
        Map<String, String> dimensions = result.getDimensions();
        Map<String, Double> measures = result.getMeasures();
        if ("onePlay".equals(str)) {
            String str2 = dimensions.get("playType");
            String str3 = dimensions.get(TableField.FILE_FORMAT);
            String str4 = dimensions.get("vvId");
            String str5 = dimensions.get("isCDN");
            String str6 = dimensions.get("decodingType");
            if (this.mBusinessTrack != null && OnePlayTrack.PlayType.BEGIN.equals(str2) && 2.0d == measures.get("beginStage").doubleValue()) {
                this.mBusinessTrack.setFirstPlay(true);
                this.mBusinessTrack.put(TableField.FILE_FORMAT, str3);
                this.mBusinessTrack.put("vvId", str4);
                String str7 = "1";
                this.mBusinessTrack.put("data_source", ConnType.PK_CDN.equalsIgnoreCase(str5) ? str7 : "3");
                BusinessTrack businessTrack = this.mBusinessTrack;
                if (!ConnType.PK_CDN.equalsIgnoreCase(str5)) {
                    str7 = "3";
                }
                businessTrack.put("isp2p", str7);
                this.mBusinessTrack.put("decodingType", str6);
                if (!(measures.get("firstFrameGear") == null || (intValue = measures.get("firstFrameGear").intValue()) == -1)) {
                    BusinessTrack businessTrack2 = this.mBusinessTrack;
                    businessTrack2.put("abrCurrentGear", intValue + "");
                }
                playStart();
            } else if ("end".equals(str2) && this.mBusinessTrack != null) {
                IPlayerContainer iPlayerContainer = this.mPlayerContainer;
                if (!(iPlayerContainer == null || iPlayerContainer.getPlayerTrack() == null || this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() == null)) {
                    BusinessTrack businessTrack3 = this.mBusinessTrack;
                    businessTrack3.put("rotateStayTime", this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().getRotateStayTime() + "");
                }
                this.mBusinessTrack.reportPlayEnd();
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onNewRequest(PlayVideoInfo playVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443883382")) {
            ipChange.ipc$dispatch("443883382", new Object[]{this, playVideoInfo});
            return;
        }
        this.mAbrGearQuality = Quality.UNKNOWN;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener
    public void onNewTrack(ITrack iTrack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629842625")) {
            ipChange.ipc$dispatch("629842625", new Object[]{this, iTrack});
            return;
        }
        PlayVideoInfo playVideoInfo = iTrack.getPlayVideoInfo();
        BusinessTrack businessTrack = new BusinessTrack(this.mContext, playVideoInfo.getLiveId());
        this.mBusinessTrack = businessTrack;
        businessTrack.setAppear(this.mIsAppear);
        this.mBusinessTrack.put("live_container_sdk_version", this.mSdkVersion);
        this.mBusinessTrack.put("playsdk_version", this.mSdkVersion);
        if (playVideoInfo.getFastData() != null) {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "1");
        } else {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "0");
        }
        this.mBusinessTrack.put("timeShift", playVideoInfo.getString("timeShift", "0"));
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825199196")) {
            ipChange.ipc$dispatch("-825199196", new Object[]{this, Boolean.valueOf(z), configuration});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        String str2 = "0";
        if (businessTrack != null) {
            businessTrack.put("smallplayer_au", "1");
            this.mBusinessTrack.put("usePIP", "1");
            BusinessTrack businessTrack2 = this.mBusinessTrack;
            if (z) {
                str = "1";
            } else {
                str = str2;
            }
            businessTrack2.put("isPIP", str);
        }
        if (this.mPlayerContainer.getPlayerTrack().getTrack() != null) {
            this.mPlayerContainer.getPlayerTrack().getTrack().putString("usePIP", "1");
            ITrack track = this.mPlayerContainer.getPlayerTrack().getTrack();
            if (z) {
                str2 = "1";
            }
            track.putString("isPIP", str2);
        }
    }

    public void onPreloadNewTrack(PlayVideoInfo playVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "856676579")) {
            ipChange.ipc$dispatch("856676579", new Object[]{this, playVideoInfo});
            return;
        }
        BusinessTrack businessTrack = new BusinessTrack(this.mContext, playVideoInfo.getLiveId());
        this.mBusinessTrack = businessTrack;
        businessTrack.setAppear(this.mIsAppear);
        this.mBusinessTrack.put("live_container_sdk_version", this.mSdkVersion);
        this.mBusinessTrack.put("playsdk_version", this.mSdkVersion);
        this.mBusinessTrack.put("fromwall", "1");
        if (playVideoInfo.getFastData() != null) {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "1");
        } else {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "0");
        }
        this.mBusinessTrack.put("timeShift", playVideoInfo.getString("timeShift", "0"));
    }

    public void setPlaybackVariables(AlixLivePlayback.PlaybackVariables playbackVariables) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542423785")) {
            ipChange.ipc$dispatch("1542423785", new Object[]{this, playbackVariables});
            return;
        }
        this.mPlaybackVariables = playbackVariables;
    }

    public void setPlayerInfoSB(StringBuilder sb) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864474092")) {
            ipChange.ipc$dispatch("1864474092", new Object[]{this, sb});
            return;
        }
        String sb2 = sb != null ? sb.toString() : "";
        if (this.mBusinessTrack != null && !TextUtils.isEmpty(sb2)) {
            this.mBusinessTrack.put("playerinfo", sb2);
        }
    }

    public void setSdkVersion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448605609")) {
            ipChange.ipc$dispatch("1448605609", new Object[]{this, str});
            return;
        }
        this.mSdkVersion = str;
    }

    public void setShownTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426133141")) {
            ipChange.ipc$dispatch("426133141", new Object[]{this, Long.valueOf(j)});
        } else if (this.mBusinessTrack != null && j > BusinessTrack.shownTime) {
            Logger.d("showntime", "setShownTime:" + String.valueOf(j) + "|" + String.valueOf(BusinessTrack.shownTime));
            BusinessTrack.shownTime = j;
        }
    }

    public void videoStarted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793382789")) {
            ipChange.ipc$dispatch("793382789", new Object[]{this});
        } else if (this.mPlayerContainer.getPlayerTrack() != null && this.mPlayerContainer.getPlayerTrack().getTrack() != null) {
            String string = this.mPlayerContainer.getPlayerTrack().getTrack().getString("liveUrlReplace");
            BusinessTrack businessTrack = this.mBusinessTrack;
            if (businessTrack != null) {
                businessTrack.put("liveUrlReplace", string);
            }
        }
    }
}
