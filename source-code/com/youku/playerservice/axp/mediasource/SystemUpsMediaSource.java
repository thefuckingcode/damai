package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.xadsdk.base.model.BidInfo;
import com.ut.device.UTDevice;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.instances.System.model.SystemPeriod;
import com.youku.alixplayer.instances.System.model.SystemPlayList;
import com.youku.alixplayer.instances.System.model.SystemSource;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.dof.DoFConfigManager;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.StreamSegItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.mediasource.BaseMediaSource;
import com.youku.playerservice.axp.player.ErrorCode;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.upsplayer.module.PreVideoSegs;
import com.youku.vpm.constants.TableField;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class SystemUpsMediaSource extends BaseMediaSource {
    protected Context mContext;
    protected PlayInfo mPlayInfo;
    protected PlayerConfig mPlayerConfig;

    public SystemUpsMediaSource(Context context, PlayInfo playInfo) {
        this.mContext = context;
        this.mPlayInfo = playInfo;
        this.mPlayerConfig = playInfo.getPlayerConfig();
    }

    private void switchDataSource(SystemPeriod systemPeriod) {
        for (int i = 0; i < this.mPlayList.getPeriodList().size(); i++) {
            if (((SystemPeriod) this.mPlayList.getPeriodList().get(i)).getType() == 0) {
                changePeriod(i, systemPeriod);
            }
        }
        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
        TLogUtil.flowLog(sessionId, "切换播放地址 ups");
        printPlaylist(sessionId, this.mPlayList);
    }

    public String appendUrlParams(String str, String str2) {
        if (!str.contains("http://") && !str.contains("https://")) {
            return str;
        }
        if (str.contains("?")) {
            return str + "&" + str2;
        }
        return str + "?" + str2;
    }

    public SystemPeriod buildPlaylistByAdInfo() {
        List<BidInfo> bitInfoByAdType = this.mPlayInfo.getBitInfoByAdType(7);
        if (bitInfoByAdType == null || bitInfoByAdType.size() <= 0) {
            return null;
        }
        SystemPeriod systemPeriod = new SystemPeriod();
        systemPeriod.setType(1);
        systemPeriod.setMixedCodec(true);
        HashMap hashMap = new HashMap();
        hashMap.put("player_source", "1");
        systemPeriod.setHeader(hashMap);
        for (BidInfo bidInfo : bitInfoByAdType) {
            if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                String trim = !TextUtils.isEmpty(bidInfo.getCreativePath()) ? bidInfo.getCreativePath().trim() : appendUrlParams(bidInfo.getCreativeUrl().trim(), "ykVideoShowType=2");
                if (TextUtils.isEmpty(trim)) {
                    TLogUtil.flowLog(this.mPlayInfo.getPlayParams().getSessionId(), "广告url为空");
                } else {
                    systemPeriod.addSource(new SystemSource(trim, (double) bidInfo.getDuration()));
                }
            }
        }
        return systemPeriod;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01af  */
    public SystemPeriod buildPlaylistByBitStream(BitStream bitStream) {
        boolean z;
        boolean isSupport;
        Quality quality;
        long startTime;
        String string = this.mPlayerConfig.getString(TableField.PLAYER_SOURCE);
        int i = 0;
        if (!TextUtils.isEmpty(string) && TextUtils.isDigitsOnly(string)) {
            float parseFloat = Float.parseFloat(string);
            if (parseFloat >= 2.0f && parseFloat < 4.0f) {
                z = true;
                HashMap hashMap = new HashMap();
                String str = "0";
                hashMap.put("datasource_live_type", str);
                hashMap.put("isUseNewHostStrategy", "1");
                hashMap.put("resolution_level", String.valueOf(bitStream.getQuality()));
                Codec codec = bitStream.getCodec();
                Codec codec2 = Codec.H265;
                hashMap.put("source codec type", codec != codec2 ? "2" : "1");
                isSupport = this.mPlayerConfig.isSupport("hardwareDecode");
                if (z) {
                    if (bitStream.getCodec() == codec2) {
                        isSupport = !"SW".equals(ConfigFetcher.getInstance().getConfig("player_feed_config", "decode_mode_265", "HW"));
                    } else if ("SW".equals(ConfigFetcher.getInstance().getConfig("player_feed_config", "decode_mode_264", "SW"))) {
                        isSupport = false;
                    }
                }
                if (isSupport) {
                    str = "1";
                }
                hashMap.put("source force hardware decode", str);
                hashMap.put("utdid_str", UTDevice.getUtdid(this.mContext));
                if (!TextUtils.isEmpty(string)) {
                    if ("2".equals(string) || "2.1".equals(string) || "2.2".equals(string) || "2.3".equals(string) || "3.1".equals(string)) {
                        hashMap.put("feed source mode", "2");
                    } else {
                        hashMap.put("feed source mode", "1");
                    }
                }
                if (bitStream.getDrmKey() != null) {
                    hashMap.put("source drm key", bitStream.getDrmKey());
                }
                if (bitStream.getDrmType() != null) {
                    hashMap.put("source drm type", bitStream.getDrmType());
                }
                if (bitStream.getDrmLicenseUri() != null) {
                    hashMap.put("drm_license_url", bitStream.getDrmLicenseUri());
                }
                if (this.mPlayerConfig.getPositionFrequency() >= 100) {
                    hashMap.put("uplayer_position_fresh_frequency", String.valueOf(this.mPlayerConfig.getPositionFrequency() * 1000));
                }
                if (!TextUtils.isEmpty(bitStream.getDofConfigFile())) {
                    String dofConfigFile = bitStream.getDofConfigFile();
                    String string2 = bitStream.getString(dofConfigFile, null);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = DoFConfigManager.getFilePath(this.mContext, dofConfigFile);
                    }
                    if (TextUtils.isEmpty(string2) || !new File(string2).exists()) {
                        BaseMediaSource.OnMediaSourceListener onMediaSourceListener = this.mOnMediaSourceListener;
                        if (onMediaSourceListener != null) {
                            onMediaSourceListener.onPlaylistFailed(ErrorCode.DOF_CFG_ERR);
                        }
                        return null;
                    }
                    bitStream.putString(dofConfigFile, string2);
                    hashMap.put("sixdof_cfg_path", string2);
                }
                quality = bitStream.getQuality();
                String m3u8Url = bitStream.getM3u8Url();
                SystemPeriod systemPeriod = new SystemPeriod();
                systemPeriod.setHeader(hashMap);
                systemPeriod.setType(0);
                startTime = this.mPlayInfo.getPlayParams().getStartTime();
                if (startTime < 0) {
                    startTime = 0;
                }
                systemPeriod.setStartTime(startTime);
                this.mPlayInfo.getPlayParams().getPlayScene();
                PlayDefinition.PlayScene playScene = PlayDefinition.PlayScene.SHORT_VIDEO;
                if (quality != Quality.AUTO) {
                    systemPeriod.addSource(new SystemSource(m3u8Url, (double) (((float) bitStream.getDuration()) / 1000.0f)));
                    return systemPeriod;
                }
                if (bitStream.getPlayFormat() == PlayDefinition.PlayFormat.HLS) {
                    systemPeriod.addSource(new SystemSource(m3u8Url, (double) (((float) bitStream.getDuration()) / 1000.0f)));
                } else {
                    List<StreamSegItem> streamSegList = bitStream.getStreamSegList();
                    systemPeriod.setMixedCodec(false);
                    while (streamSegList != null && i < streamSegList.size()) {
                        StreamSegItem streamSegItem = streamSegList.get(i);
                        String url = streamSegItem.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            BaseMediaSource.OnMediaSourceListener onMediaSourceListener2 = this.mOnMediaSourceListener;
                            if (onMediaSourceListener2 != null) {
                                onMediaSourceListener2.onPlaylistFailed(28001);
                            }
                            return null;
                        }
                        systemPeriod.addSource(new SystemSource(url, (double) (streamSegItem.getDuration() / 1000.0f)));
                        i++;
                    }
                }
                return systemPeriod;
            }
        }
        z = false;
        HashMap hashMap2 = new HashMap();
        String str2 = "0";
        hashMap2.put("datasource_live_type", str2);
        hashMap2.put("isUseNewHostStrategy", "1");
        hashMap2.put("resolution_level", String.valueOf(bitStream.getQuality()));
        Codec codec3 = bitStream.getCodec();
        Codec codec22 = Codec.H265;
        hashMap2.put("source codec type", codec3 != codec22 ? "2" : "1");
        isSupport = this.mPlayerConfig.isSupport("hardwareDecode");
        if (z) {
        }
        if (isSupport) {
        }
        hashMap2.put("source force hardware decode", str2);
        hashMap2.put("utdid_str", UTDevice.getUtdid(this.mContext));
        if (!TextUtils.isEmpty(string)) {
        }
        if (bitStream.getDrmKey() != null) {
        }
        if (bitStream.getDrmType() != null) {
        }
        if (bitStream.getDrmLicenseUri() != null) {
        }
        if (this.mPlayerConfig.getPositionFrequency() >= 100) {
        }
        if (!TextUtils.isEmpty(bitStream.getDofConfigFile())) {
        }
        quality = bitStream.getQuality();
        String m3u8Url2 = bitStream.getM3u8Url();
        SystemPeriod systemPeriod2 = new SystemPeriod();
        systemPeriod2.setHeader(hashMap2);
        systemPeriod2.setType(0);
        startTime = this.mPlayInfo.getPlayParams().getStartTime();
        if (startTime < 0) {
        }
        systemPeriod2.setStartTime(startTime);
        this.mPlayInfo.getPlayParams().getPlayScene();
        PlayDefinition.PlayScene playScene2 = PlayDefinition.PlayScene.SHORT_VIDEO;
        if (quality != Quality.AUTO) {
        }
    }

    public SystemPeriod buildPreVideo() {
        PreVideoSegs preVideoSegs;
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo == null || playInfo.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream.length <= 0 || (preVideoSegs = this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream[0].segs[0]) == null || TextUtils.isEmpty(preVideoSegs.cdn_url)) {
            return null;
        }
        SystemPeriod systemPeriod = new SystemPeriod();
        systemPeriod.setType(2);
        systemPeriod.setStartTime(0);
        systemPeriod.addSource(new SystemSource(appendUrlParams(preVideoSegs.cdn_url.trim(), "ykVideoShowType=3")));
        return systemPeriod;
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource
    public PlayInfo getPlayInfo() {
        return this.mPlayInfo;
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        PlayInfo playInfo = this.mPlayInfo;
        return playInfo != null ? playInfo.getPlayId() : "";
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        VodItem vodItem = (VodItem) this.mPlayInfo.getPlayItem();
        Log.d("AndroidXPlayer", "preparePlaylist: vod item: " + vodItem);
        BitStream bitStream = vodItem.getBitStream();
        Log.d("AndroidXPlayer", "preparePlaylist: bit stream: " + bitStream);
        SystemPeriod buildPlaylistByBitStream = buildPlaylistByBitStream(bitStream);
        Log.d("AndroidXPlayer", "preparePlaylist: period: " + buildPlaylistByBitStream);
        if (buildPlaylistByBitStream != null) {
            this.mPlayList = new SystemPlayList();
            SystemPeriod buildPlaylistByAdInfo = buildPlaylistByAdInfo();
            if (buildPlaylistByAdInfo != null) {
                this.mPlayList.addPeriod(buildPlaylistByAdInfo);
            }
            SystemPeriod buildPreVideo = buildPreVideo();
            if (buildPreVideo != null) {
                this.mPlayList.addPeriod(buildPreVideo);
            }
            this.mPlayList.addPeriod(buildPlaylistByBitStream);
            String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
            TLogUtil.flowLog(sessionId, "设置播放地址 ups");
            printPlaylist(sessionId, this.mPlayList);
            notifyPlaylistPrepared(this.mPlayList);
            return;
        }
        Log.e("AndroidXPlayer", "preparePlaylist prepare failed!");
        notifyPlaylistFailed();
    }

    /* access modifiers changed from: protected */
    public void printPlaylist(String str, IPlaylist iPlaylist) {
        List periodList = iPlaylist.getPeriodList();
        for (int i = 0; i < periodList.size(); i++) {
            SystemPeriod systemPeriod = (SystemPeriod) periodList.get(i);
            TLogUtil.flowLog(str, "period index=" + i + " type=" + systemPeriod.getType() + StringUtils.LF);
            StringBuilder sb = new StringBuilder();
            sb.append("header:");
            sb.append(systemPeriod.getAllHeaders());
            sb.append(StringUtils.LF);
            TLogUtil.flowLog(str, sb.toString());
            List<SystemSource> sourceList = systemPeriod.getSourceList();
            for (int i2 = 0; i2 < sourceList.size(); i2++) {
                TLogUtil.flowLog(str, "source index=" + i2 + " " + sourceList.get(i2) + StringUtils.LF);
            }
        }
    }

    public int switchDataSource(VodItem vodItem, long j) {
        if (this.mPlayList == null) {
            TLogUtil.flowLog(vodItem.getPlayParams().getSessionId(), "切换清晰度的时候没有Playlist");
            return 404;
        }
        BitStream bitStream = vodItem.getBitStream();
        String drmKey = bitStream.getDrmKey();
        SystemPeriod buildPlaylistByBitStream = buildPlaylistByBitStream(bitStream);
        buildPlaylistByBitStream.setStartTime(j);
        buildPlaylistByBitStream.setDrmKey(drmKey);
        switchDataSource(buildPlaylistByBitStream);
        return 0;
    }

    @Override // com.youku.alixplayer.IMediaSourceExt, com.youku.alixplayer.BaseMediaSource
    public boolean useRaphaelPlayer() {
        return false;
    }
}
