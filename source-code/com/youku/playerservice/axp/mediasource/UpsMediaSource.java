package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.util.NativeMap;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.Status;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.player.init.PlayerSuperSolutionMananger;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.definition.FirstSliceCode;
import com.youku.playerservice.axp.dof.DoFConfigManager;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.CacheBitStream;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.SliceItem;
import com.youku.playerservice.axp.item.StreamSegItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.mediasource.BaseMediaSource;
import com.youku.playerservice.axp.p2p.P2pManager;
import com.youku.playerservice.axp.p2p.PcdnType;
import com.youku.playerservice.axp.player.ErrorCode;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.PlaylistUtil;
import com.youku.playerservice.axp.utils.SystemUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.upsplayer.module.Fs;
import com.youku.upsplayer.module.PreVideoSegs;
import com.youku.vpm.constants.TableField;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class UpsMediaSource extends AxpMediaSource {
    private static final String TAG = "UpsMediaSource";

    public UpsMediaSource(Context context, PlayInfo playInfo) {
        super(context, playInfo);
    }

    private boolean buildDofHeader(NativeMap nativeMap, BitStream bitStream, PlayInfoUpsResponse playInfoUpsResponse) {
        String str;
        String str2;
        String config = ConfigFetcher.getInstance().getConfig("fvv_config", "spe_stream_max_buffer_size", "-1");
        if (!"-1".equalsIgnoreCase(config)) {
            nativeMap.put("spe_stream_max_buffer_size", config);
            Logger.d(TAG, "builder 6dof header [spe_stream_max_buffer_size] = [" + config + jl1.ARRAY_END_STR);
        }
        boolean z = false;
        if (bitStream.getQuality() == Quality.AUTO) {
            for (BitStream bitStream2 : playInfoUpsResponse.getBitStreamList()) {
                String dofConfigFile = bitStream2.getDofConfigFile();
                if (!TextUtils.isEmpty(dofConfigFile)) {
                    String filePath = DoFConfigManager.getFilePath(this.mContext, dofConfigFile);
                    bitStream.putString("hasDof", "1");
                    if (TextUtils.isEmpty(filePath) || !new File(filePath).exists()) {
                        z = true;
                    } else {
                        bitStream.putString(dofConfigFile, filePath);
                        if (bitStream2.getStreamType().contains("hls5hd_6dof_")) {
                            nativeMap.put("sixdof_hd_config", filePath);
                            nativeMap.put("sixdof_hd_width", bitStream2.getWidth() + "");
                            str = bitStream2.getHeight() + "";
                            str2 = "sixdof_hd_height";
                        } else if (bitStream2.getStreamType().contains("hls5hd2_6dof_")) {
                            nativeMap.put("sixdof_hd2_config", filePath);
                            nativeMap.put("sixdof_hd2_width", bitStream2.getWidth() + "");
                            str = bitStream2.getHeight() + "";
                            str2 = "sixdof_hd2_height";
                        }
                        nativeMap.put(str2, str);
                    }
                }
            }
            return !z;
        }
        String dofConfigFile2 = bitStream.getDofConfigFile();
        if (!TextUtils.isEmpty(dofConfigFile2)) {
            bitStream.putString("hasDof", "1");
            String filePath2 = DoFConfigManager.getFilePath(this.mContext, dofConfigFile2);
            if (TextUtils.isEmpty(filePath2) || !new File(filePath2).exists()) {
                z = true;
            } else {
                bitStream.putString(dofConfigFile2, filePath2);
                nativeMap.put("sixdof_cfg_path", filePath2);
            }
        }
        return !z;
    }

    private void buildFsSlice(Period period, BitStream bitStream, PlayInfoUpsResponse playInfoUpsResponse, long j, String str, String str2, boolean z) {
        String str3;
        PlayInfo playInfo;
        PlayInfo playInfo2;
        String str4;
        if ("1".equals(str) && Constants.Value.PLAY.equals(str2)) {
            Fs fs = bitStream.getFs();
            if (fs != null) {
                if (Math.abs(j - fs.slice_pos) > ((long) (Integer.parseInt(ConfigFetcher.getInstance().getConfig("axp_fs_slice_config", "history_position_gap_slice", "15")) * 1000))) {
                    playInfo2 = this.mPlayInfo;
                    str4 = "-2";
                } else if (z) {
                    playInfo2 = this.mPlayInfo;
                    str4 = "-1";
                } else if (playInfoUpsResponse.hasVideoFeature(Point.FVV_TIPS)) {
                    playInfo2 = this.mPlayInfo;
                    str4 = FirstSliceCode.FVV;
                } else {
                    if (fs.slice_pos == 0) {
                        this.mPlayInfo.putString(TableField.USE_FIRST_SLICE, "0");
                    } else {
                        this.mPlayInfo.putString(TableField.USE_FIRST_SLICE, "1");
                    }
                    if (ApsUtil.enableVodSliceDown()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(CacheManager.SLICE_ID, fs.sequence_num + "");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(fs.slice_url);
                        String preloadKey = CacheManager.getInstance().getPreloadKey();
                        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
                        TLogUtil.flowLog(sessionId, "首分片网络预下载 slice_id=" + fs.sequence_num + " url=" + fs.slice_url);
                        CacheManager.getInstance().preloadMediaSourceWithUrls(preloadKey, this.mContext, arrayList, hashMap, null);
                    }
                    String drmKey = bitStream.getDrmKey();
                    if (!"copyrightDRM".equalsIgnoreCase(fs.drm_type)) {
                        drmKey = "NULL";
                    }
                    period.addHeader("start ts parameters", PlaylistUtil.constructTsParams(fs.slice_pos, fs.sequence_num.longValue(), fs.slice_size, fs.slice_duration / 1000, fs.discontinue_num.longValue(), fs.stream_type, ((long) bitStream.getDuration()) * 1000, drmKey));
                    period.addHeader("player_source", "5");
                    period.addSource(new Source(fs.slice_url, ((double) fs.slice_duration) / 1000.0d));
                    period.setMediaType(0);
                    return;
                }
                playInfo2.putString(TableField.USE_FIRST_SLICE, str4);
                return;
            }
            if (bitStream.getFsError() != null) {
                playInfo = this.mPlayInfo;
                str3 = bitStream.getFsError().code;
            } else {
                playInfo = this.mPlayInfo;
                str3 = FirstSliceCode.FS_NULL;
            }
            playInfo.putString(TableField.USE_FIRST_SLICE, str3);
        }
    }

    private void buildPlayerSource(NativeMap nativeMap, BitStream bitStream, PlayInfo playInfo) {
        int i = 10;
        if (!(bitStream.getQuality() == Quality.HD3_HBR || bitStream.getQuality() == Quality.AUTO)) {
            i = 0;
        }
        if ("5".equals(this.mPlayerConfig.getString(TableField.PLAYER_SOURCE))) {
            nativeMap.put("player_source", "8");
        }
        if (i > 0) {
            nativeMap.put("player_source", i + "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x029f  */
    private Period buildPlaylistByBitStream(BitStream bitStream, boolean z, String str) {
        String str2;
        String string = this.mPlayerConfig.getString(TableField.PLAYER_SOURCE);
        PlayParams playParams = this.mPlayInfo.getPlayParams();
        boolean isFeed = PlayerUtil.isFeed(string);
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("datasource_live_type", "0");
        nativeMap.put("isUseNewHostStrategy", "1");
        nativeMap.put("resolution_level", String.valueOf(bitStream.getQuality()));
        Codec codec = bitStream.getCodec();
        Codec codec2 = Codec.H265;
        String str3 = "2";
        nativeMap.put("source codec type", codec == codec2 ? str3 : "1");
        if (this.mPlayInfo.isPanorama()) {
            nativeMap.put("videoPanorama", "1");
        } else {
            nativeMap.put("videoPanorama", "0");
        }
        nativeMap.put("adPanorama", "0");
        boolean isSupport = this.mPlayerConfig.isSupport("hardwareDecode");
        boolean z2 = true;
        if (isFeed) {
            if (bitStream.getCodec() == codec2) {
                isSupport = !"SW".equals(ConfigFetcher.getInstance().getConfig("player_feed_config", "decode_mode_265", "HW"));
            } else if ("SW".equals(ConfigFetcher.getInstance().getConfig("player_feed_config", "decode_mode_264", "SW"))) {
                isSupport = false;
            }
        }
        if (this.mPlayInfo.isPanorama()) {
            isSupport = false;
        }
        nativeMap.put("source force hardware decode", isSupport ? "1" : "0");
        nativeMap.put("utdid_str", UTDevice.getUtdid(this.mContext));
        setSuperResolutionParamsForHeader(nativeMap, isSupport, bitStream, playParams);
        if (playParams.getPlayScene() == PlayDefinition.PlayScene.SHORT_VIDEO) {
            String playerSourceConfigThreeSecond = ApsUtil.getPlayerSourceConfigThreeSecond();
            if (!TextUtils.isEmpty(playerSourceConfigThreeSecond)) {
                String[] split = playerSourceConfigThreeSecond.split(";");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str4 = split[i];
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(str4) && str4.equals(string)) {
                        break;
                    }
                    i++;
                }
                if (!z2) {
                    nativeMap.put("feed source mode", str3);
                } else {
                    nativeMap.put("feed source mode", "1");
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        nativeMap.put("fmp4_in_hls", bitStream.getString("fmp4_in_hls", "0"));
        if (bitStream.getDrmKey() != null) {
            nativeMap.put("source drm key", bitStream.getDrmKey());
        }
        if (bitStream.getDrmType() != null) {
            nativeMap.put("source drm type", bitStream.getDrmType());
        }
        if (bitStream.getDrmLicenseUri() != null) {
            nativeMap.put("drm_license_url", bitStream.getDrmLicenseUri());
        }
        if (this.mPlayerConfig.getPositionFrequency() >= 100) {
            nativeMap.put("uplayer_position_fresh_frequency", String.valueOf(this.mPlayerConfig.getPositionFrequency() * 1000));
        }
        if ("5".equals(string)) {
            str2 = "8";
        } else {
            if (bitStream.getQuality() == Quality.AUTO) {
                nativeMap.put("player_source", "10");
            } else if (bitStream.getQuality() == Quality.HD3_HBR) {
                str2 = "9";
            } else if ("true".equals(playParams.getString("isInteractiveVideoMaterial", "false"))) {
                str2 = "7";
            } else if ("pugv".equals(playParams.getString("playMode", ""))) {
                str2 = "11";
            }
            if (bitStream instanceof CacheBitStream) {
                str3 = "0";
            } else if (((CacheBitStream) bitStream).getDownloadType() == CacheBitStream.DownloadType.DOWNLOADING) {
                nativeMap.put("player_source", "4");
            } else {
                nativeMap.put("player_source", str3);
                str3 = "1";
            }
            nativeMap.put("datasource_local_type", str3);
            if (this.mPlayInfo.getPlayInfoResponse() != null) {
                PlayInfoUpsResponse playInfoUpsResponse = (PlayInfoUpsResponse) this.mPlayInfo.getPlayInfoResponse();
                if (playInfoUpsResponse.hasVideoFeature(Point.FVV_TIPS) && !buildDofHeader(nativeMap, bitStream, playInfoUpsResponse)) {
                    notifyError(ErrorCode.DOF_CFG_ERR);
                    return null;
                }
            }
            PlayInfo playInfo = this.mPlayInfo;
            if (!(playInfo == null || playInfo.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getController() == null)) {
                int i2 = this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getController().dof_degrade_mode;
                nativeMap.put("dof_degrade_mode", String.valueOf(i2));
                Logger.d(TAG, "axp_player-service: dof_degrade_mode = " + String.valueOf(i2));
            }
            nativeMap.put("dump_file_path", this.mContext.getApplicationContext().getExternalCacheDir() + "/dumpVideo");
            boolean equals = "1".equals(ConfigFetcher.getInstance().getConfig("player_strategy", "video_dump_always", "0"));
            if ("1".equals(playParams.getString("dumpVideo")) || equals) {
                nativeMap.put("enable_dump_size", ConfigFetcher.getInstance().getConfig("player_strategy", "enable_dump_size", "10"));
                nativeMap.put("video_dump_vid", this.mPlayInfo.getPlayId());
            }
            SliceItem sliceItem = bitStream.getSliceItem();
            if (!bitStream.onlyHasSliceItem()) {
                nativeMap.put("start ts parameters", PlaylistUtil.constructTsParams(sliceItem.getStartPos(), (long) ((int) sliceItem.getTsDurSeconds()), bitStream.getStreamType(), (long) bitStream.getDuration(), ""));
                Period period = PlaylistUtil.getPeriod(sliceItem);
                period.setHeader(nativeMap);
                return period;
            }
            bitStream.getQuality();
            String m3u8Url = bitStream.getM3u8Url();
            PlayInfoUpsResponse playInfoUpsResponse2 = (PlayInfoUpsResponse) this.mPlayInfo.getPlayInfoResponse();
            long j = 0;
            long realStartTime = playInfoUpsResponse2 != null ? playInfoUpsResponse2.getRealStartTime(this.mPlayInfo) : 0;
            if (realStartTime >= 0) {
                j = realStartTime;
            }
            Period period2 = new Period();
            period2.setHeader(nativeMap);
            period2.setType(0);
            TLogUtil.flowLog(playParams.getSessionId(), "startTime=" + j);
            period2.setStartTime(j);
            String str5 = this.mPlayInfo.getPlayParams().getPlayScene() == PlayDefinition.PlayScene.SHORT_VIDEO ? "feed" : null;
            if (bitStream.getPlayFormat() == PlayDefinition.PlayFormat.HLS) {
                buildFsSlice(period2, bitStream, playInfoUpsResponse2, j, string, str, z);
                if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
                    P2pManager.Result pcdnUrl = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.VOD, m3u8Url, str5);
                    if (!"10000".equals(pcdnUrl.errorCode)) {
                        TLogUtil.playLog("p2pCode=" + pcdnUrl.errorCode);
                    } else if (!TextUtils.isEmpty(pcdnUrl.finalUrl)) {
                        m3u8Url = pcdnUrl.finalUrl;
                    }
                    this.mPlayInfo.getPlayParams().putString("p2pCode", pcdnUrl.errorCode);
                }
                float duration = ((float) bitStream.getDuration()) / 1000.0f;
                if (TextUtils.isEmpty(m3u8Url)) {
                    notifyError(ErrorCode.URL_IS_NULL);
                    return null;
                }
                period2.addSource(new Source(m3u8Url, (double) duration));
            } else {
                List<StreamSegItem> streamSegList = bitStream.getStreamSegList();
                int i3 = 0;
                period2.setMixedCodec(false);
                while (streamSegList != null && i3 < streamSegList.size()) {
                    StreamSegItem streamSegItem = streamSegList.get(i3);
                    String url = streamSegItem.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        BaseMediaSource.OnMediaSourceListener onMediaSourceListener = this.mOnMediaSourceListener;
                        if (onMediaSourceListener == null) {
                            return null;
                        }
                        onMediaSourceListener.onPlaylistFailed(ErrorCode.URL_IS_NULL);
                        return null;
                    }
                    float duration2 = streamSegItem.getDuration() / 1000.0f;
                    if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
                        P2pManager.Result pcdnUrl2 = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.VOD, url, str5);
                        if (!"10000".equals(pcdnUrl2.errorCode)) {
                            TLogUtil.playLog("p2pCode=" + pcdnUrl2.errorCode);
                        } else if (!TextUtils.isEmpty(pcdnUrl2.finalUrl)) {
                            url = pcdnUrl2.finalUrl;
                        }
                        this.mPlayInfo.getPlayParams().putString("p2pCode", pcdnUrl2.errorCode);
                    }
                    period2.addSource(new Source(url, (double) duration2));
                    i3++;
                }
            }
            return period2;
        }
        nativeMap.put("player_source", str2);
        if (bitStream instanceof CacheBitStream) {
        }
        nativeMap.put("datasource_local_type", str3);
        if (this.mPlayInfo.getPlayInfoResponse() != null) {
        }
        PlayInfo playInfo2 = this.mPlayInfo;
        int i22 = this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getController().dof_degrade_mode;
        nativeMap.put("dof_degrade_mode", String.valueOf(i22));
        Logger.d(TAG, "axp_player-service: dof_degrade_mode = " + String.valueOf(i22));
        nativeMap.put("dump_file_path", this.mContext.getApplicationContext().getExternalCacheDir() + "/dumpVideo");
        boolean equals2 = "1".equals(ConfigFetcher.getInstance().getConfig("player_strategy", "video_dump_always", "0"));
        nativeMap.put("enable_dump_size", ConfigFetcher.getInstance().getConfig("player_strategy", "enable_dump_size", "10"));
        nativeMap.put("video_dump_vid", this.mPlayInfo.getPlayId());
        SliceItem sliceItem2 = bitStream.getSliceItem();
        if (!bitStream.onlyHasSliceItem()) {
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }

    private void setSuperResolutionParamsForHeader(NativeMap nativeMap, boolean z, BitStream bitStream, PlayParams playParams) {
        String str;
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && ApsUtil.enableAxpSuperResolution() && z) {
            boolean supportSRDeivce = supportSRDeivce(this.mContext);
            boolean supportSuperResolutionCurrentQuality = supportSuperResolutionCurrentQuality(bitStream);
            boolean superResolutionFilesIsExists = superResolutionFilesIsExists();
            boolean z2 = true;
            String str2 = "-1";
            if (!(playParams == null || playParams.getString("superResolution") == null || !playParams.getString("superResolution").equals(str2))) {
                z2 = false;
            }
            if (supportSRDeivce && supportSuperResolutionCurrentQuality && superResolutionFilesIsExists && z2) {
                str2 = "1";
            }
            String str3 = "";
            if (str2.equals("1")) {
                String path = this.mContext.getFilesDir().getPath();
                str3 = path + "/solid-" + getVersionName(this.mContext);
                str = path + "/YKSRConfig/YKSRFiles";
            } else {
                str = str3;
            }
            nativeMap.put("cvfilter_run_mode", str2);
            nativeMap.put("cvfilter_so_path", str3);
            nativeMap.put("cvfilter_config_path", str);
        }
    }

    public static boolean supportSRDeivce(Context context) {
        String cpuName = Utils.getCpuName(context);
        String hiAiVersion = SystemUtil.getHiAiVersion();
        return (cpuName.equals("kirin9000") || cpuName.equals("kirin9000E") || cpuName.equals("kirin990") || cpuName.equals("kirin990E")) ? hiAiVersion.compareTo("100.320.010.045") >= 0 : cpuName.equals("kirin980") && hiAiVersion.compareTo("100.210.010.010") >= 0;
    }

    private void switchDataSource(Period period) {
        for (int i = 0; i < this.mPlayList.getPeriodList().size(); i++) {
            if (((Period) this.mPlayList.getPeriodList().get(i)).getType() == 0) {
                changePeriod(i, period);
            }
        }
        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
        TLogUtil.flowLog(sessionId, "切换播放地址 ups");
        printPlaylist(sessionId, this.mPlayList);
    }

    public Period buildPreVideo() {
        PreVideoSegs preVideoSegs;
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo == null || playInfo.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream.length <= 0 || (preVideoSegs = this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream[0].segs[0]) == null || TextUtils.isEmpty(preVideoSegs.cdn_url)) {
            return null;
        }
        Period period = new Period();
        period.setType(2);
        period.setStartTime(0);
        String appendUrlParams = appendUrlParams(preVideoSegs.cdn_url.trim(), "ykVideoShowType=3");
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            appendUrlParams = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.VOD, appendUrlParams, null).finalUrl;
        }
        if (!TextUtils.isEmpty(appendUrlParams)) {
            period.addSource(new Source(appendUrlParams));
        }
        if (period.getSourceList().size() == 0) {
            return null;
        }
        return period;
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        PlayInfo playInfo = this.mPlayInfo;
        return playInfo != null ? playInfo.getPlayId() : "";
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        super.preparePlaylist();
        Period buildPlaylistByAdInfo = buildPlaylistByAdInfo();
        if (buildPlaylistByAdInfo != null) {
            this.mPlayList.addPeriod(buildPlaylistByAdInfo);
        }
        Period buildPreVideo = buildPreVideo();
        if (buildPreVideo != null) {
            this.mPlayList.addPeriod(buildPreVideo);
        }
        Period buildPlaylistByBitStream = buildPlaylistByBitStream(((VodItem) this.mPlayInfo.getPlayItem()).getBitStream(), (buildPlaylistByAdInfo == null && buildPreVideo == null) ? false : true, Constants.Value.PLAY);
        if (buildPlaylistByBitStream != null) {
            this.mPlayList.addPeriod(buildPlaylistByBitStream);
            String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
            TLogUtil.flowLog(sessionId, "设置播放地址 ups");
            printPlaylist(sessionId, this.mPlayList);
            notifyPlaylistPrepared(this.mPlayList);
            return;
        }
        notifyPlaylistFailed();
    }

    /* access modifiers changed from: package-private */
    public boolean superResolutionConfigFilesIsExists() {
        PlayerSuperSolutionMananger.getInstance();
        return PlayerSuperSolutionMananger.isSRConfigFilesReady();
    }

    /* access modifiers changed from: package-private */
    public boolean superResolutionFilesIsExists() {
        return superResolutionConfigFilesIsExists() && superResolutionSOFilesIsExists();
    }

    /* access modifiers changed from: package-private */
    public boolean superResolutionSOFilesIsExists() {
        try {
            SolidRequest solidRequest = new SolidRequest();
            solidRequest.name = "SuperResolution";
            return SolidServer.checkSoGroupStatus(solidRequest) == Status.DOWNLOADED;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean supportSuperResolutionCurrentQuality(BitStream bitStream) {
        Quality quality = bitStream.getQuality();
        return quality == Quality.HD || quality == Quality.SD || quality == Quality.HD3GP;
    }

    public int switchDataSource(VodItem vodItem, long j) {
        if (this.mPlayList == null) {
            TLogUtil.flowLog(vodItem.getPlayParams().getSessionId(), "切换清晰度的时候没有Playlist");
            return 404;
        }
        BitStream bitStream = vodItem.getBitStream();
        String drmKey = bitStream.getDrmKey();
        Period buildPlaylistByBitStream = buildPlaylistByBitStream(bitStream, false, "switch");
        buildPlaylistByBitStream.setStartTime(j);
        buildPlaylistByBitStream.setDrmKey(drmKey);
        switchDataSource(buildPlaylistByBitStream);
        return 0;
    }
}
