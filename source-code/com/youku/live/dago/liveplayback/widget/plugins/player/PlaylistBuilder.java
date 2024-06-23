package com.youku.live.dago.liveplayback.widget.plugins.player;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.device.UTDevice;
import com.youku.alixplayer.model.LivePeriod;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.IPlaylistBuilder;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Codec;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.ups.data.StreamSegItem;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplayer.util.NativeMap;
import com.youku.android.liveservice.bean.BizType;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.android.liveservice.utils.DrmManager;
import com.youku.live.dago.liveplayback.ConfigUtils;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.plugin.p2p.P2pManager;
import com.youku.live.plugin.p2p.PcdnType;
import java.util.List;

/* compiled from: Taobao */
public class PlaylistBuilder implements IPlaylistBuilder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private PlayerConfig mPlayerConfig;

    public PlaylistBuilder(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
    }

    private String appendUrlParams(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1359613030")) {
            return (String) ipChange.ipc$dispatch("-1359613030", new Object[]{this, str, str2});
        } else if (!str.contains("http://") && !str.contains("https://")) {
            return str;
        } else {
            if (str.contains("?")) {
                return str + "&" + str2;
            }
            return str + "?" + str2;
        }
    }

    private static boolean enablePursue(Context context, BizType bizType) {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949418449")) {
            return ((Boolean) ipChange.ipc$dispatch("-1949418449", new Object[]{context, bizType})).booleanValue();
        }
        String apsConfig = Utils.getApsConfig(context, "live_mediasource_config", "enable_pursue", "");
        if (!TextUtils.isEmpty(apsConfig) && (split = apsConfig.split(",")) != null) {
            for (String str : split) {
                boolean equalsIgnoreCase = str.equalsIgnoreCase(bizType.getValue());
                boolean equalsIgnoreCase2 = str.equalsIgnoreCase(bizType.getDescription());
                if (equalsIgnoreCase || equalsIgnoreCase2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.youku.alixplayer.opensdk.IPlaylistBuilder
    public Period buildPlaylistByBitStream(PlayVideoInfo playVideoInfo, BitStream bitStream, int i) throws RuntimeException {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1966061846")) {
            return (Period) ipChange.ipc$dispatch("-1966061846", new Object[]{this, playVideoInfo, bitStream, Integer.valueOf(i)});
        }
        NativeMap nativeMap = new NativeMap();
        String str = "0";
        nativeMap.put("datasource_live_type", str);
        nativeMap.put("resolution_level", String.valueOf(bitStream.getQuality()));
        nativeMap.put("source codec type", bitStream.getCodec() == Codec.H265 ? "2" : "1");
        if (this.mPlayerConfig.isUseHardwareDecode()) {
            str = "1";
        }
        nativeMap.put("source force hardware decode", str);
        nativeMap.put("utdid_str", UTDevice.getUtdid(this.mContext));
        if (bitStream.getDrmKey() != null) {
            nativeMap.put("source drm key", bitStream.getDrmKey());
        }
        if (bitStream.getDrmType() != null) {
            nativeMap.put("source drm type", bitStream.getDrmType());
        }
        if (bitStream.getDrmLicenseUri() != null) {
            nativeMap.put("drm_license_url", bitStream.getDrmLicenseUri());
        }
        Quality quality = bitStream.getQuality();
        String m3u8Text = bitStream.getM3u8Text();
        String m3u8Url = bitStream.getM3u8Url();
        Period period = new Period();
        period.setHeader(nativeMap);
        period.setType(0);
        if (quality == Quality.AUTO) {
            period.setStartTime((long) i);
            period.addSource(new Source(m3u8Text, (double) (((float) bitStream.getLength()) / 1000.0f)));
            return period;
        }
        if ("1".equals(bitStream.getFileFormat())) {
            period.setStartTime((long) i);
            period.addSource(new Source(m3u8Url, (double) (((float) bitStream.getLength()) / 1000.0f)));
        } else {
            List<StreamSegItem> streamSegList = bitStream.getStreamSegList();
            period.setMixedCodec(false);
            period.setStartTime((long) i);
            while (streamSegList != null && i2 < streamSegList.size()) {
                StreamSegItem streamSegItem = streamSegList.get(i2);
                period.addSource(new Source(streamSegItem.getCDNUrl(), (double) streamSegItem.getVideoLength()));
                i2++;
            }
        }
        return period;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b8  */
    @Override // com.youku.alixplayer.opensdk.IPlaylistBuilder
    public Period buildPlaylistByLiveInfo(PlayVideoInfo playVideoInfo, LiveInfo liveInfo) throws RuntimeException {
        String str;
        String str2;
        String str3;
        BypassPlayInfo bypassPlayInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391112176")) {
            return (Period) ipChange.ipc$dispatch("-391112176", new Object[]{this, playVideoInfo, liveInfo});
        }
        LivePeriod livePeriod = new LivePeriod();
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("datasource_live_type", "1");
        if (ConfigUtils.enableNoSurfacePlay() && (((bypassPlayInfo = liveInfo.bypassPlayInfo) != null && bypassPlayInfo.h265 == 1 && !TextUtils.isEmpty(bypassPlayInfo.h265PlayUrl)) || this.mPlayerConfig.isUseHardwareDecode())) {
            nativeMap.put("no_need_surface", "1");
        }
        if (ConfigUtils.enableInteractSEI(playVideoInfo.getVid())) {
            nativeMap.put("enable get laifeng live sei info", "1");
            nativeMap.put("get_sei_interval_ms", String.valueOf(ConfigUtils.getSEIInterval()));
        } else if (ConfigUtils.enableDelaySEI(playVideoInfo.getVid())) {
            nativeMap.put("enable get edu live sei info", "1");
        }
        nativeMap.put("utdid_str", UTDevice.getUtdid(this.mContext));
        String monitor = playVideoInfo.getMonitor("seidecode", "0");
        if (monitor != null && monitor.equals("1")) {
            nativeMap.put("enable mcu exchange image", "1");
        }
        if (liveInfo.getQuality() != null) {
            if (liveInfo.bypassPlayInfo.drmType != 0) {
                String str4 = DrmManager.getR1() + "," + liveInfo.bypassPlayInfo.encryptRServer + "," + liveInfo.bypassPlayInfo.copyrightKey;
                livePeriod.setDrmKey(str4);
                nativeMap.put("source drm key", str4);
                nativeMap.put("source drm type", "copyrightDRM");
            }
            boolean z = liveInfo.getQuality().h265 == 1 || liveInfo.getQuality().h265 == 2;
            if (this.mPlayerConfig.isUseHardwareDecode()) {
                str = "1";
            } else {
                str = "0";
            }
            if ("HW".equals(Utils.getApsConfig("live_player_config", "decode_mode", "SW"))) {
                str = "1";
            }
            String str5 = "2";
            if ("1".equals(playVideoInfo.getString("timeShift"))) {
                String string = playVideoInfo.getString("timeShiftPoint");
                if (!z || TextUtils.isEmpty(liveInfo.getQuality().h265TSUrl)) {
                    if (!TextUtils.isEmpty(liveInfo.getQuality().h264TSUrl)) {
                        str2 = appendUrlParams(liveInfo.getQuality().h264TSUrl, "lhs_start=" + string);
                        str5 = "1";
                        if (TextUtils.isEmpty(str2)) {
                            TLogUtil.playLog("url is null");
                            return null;
                        }
                        nativeMap.put("source codec type", str5);
                        nativeMap.put("source force hardware decode", str);
                        FileFormat fileFormat = liveInfo.getFileFormat();
                        if (fileFormat == FileFormat.RTP) {
                            nativeMap.put("datasource_live_type", "3");
                        } else if (fileFormat == FileFormat.LHLS) {
                            nativeMap.put("datasource_live_type", "4");
                        } else if (fileFormat == FileFormat.ARTP) {
                            nativeMap.put("artp_so_path", this.mContext.getApplicationInfo().nativeLibraryDir);
                        }
                        VideoInfo videoInfo = liveInfo.videoInfo;
                        if (videoInfo == null || !enablePursue(this.mContext, videoInfo.getBizType())) {
                            nativeMap.put("pursue_video_frame_type", "0");
                        } else {
                            nativeMap.put("pursue_video_frame_type", "1");
                        }
                        if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && (fileFormat == FileFormat.HLS || fileFormat == FileFormat.LHLS)) {
                            P2pManager.Result pcdnUrl = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.LIVE, str2);
                            if (!"10000".equals(pcdnUrl.errorCode)) {
                                TLogUtil.playLog("p2pCode=" + pcdnUrl.errorCode);
                            } else if (!TextUtils.isEmpty(pcdnUrl.finalUrl)) {
                                str2 = pcdnUrl.finalUrl;
                            }
                            playVideoInfo.putString("p2pCode", pcdnUrl.errorCode);
                        }
                        livePeriod.addSource(new Source(str2));
                        livePeriod.setHeader(nativeMap);
                    }
                    str5 = "1";
                    str2 = null;
                    if (TextUtils.isEmpty(str2)) {
                    }
                } else {
                    str3 = appendUrlParams(liveInfo.getQuality().h265TSUrl, "lhs_start=" + string);
                }
            } else if (!z || TextUtils.isEmpty(liveInfo.getQuality().h265PlayUrl)) {
                if (!TextUtils.isEmpty(liveInfo.getQuality().h264PlayUrl)) {
                    str2 = liveInfo.getQuality().h264PlayUrl;
                    str5 = "1";
                    if (TextUtils.isEmpty(str2)) {
                    }
                }
                str5 = "1";
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
            } else {
                str3 = liveInfo.getQuality().h265PlayUrl;
            }
            str2 = str3;
            str = "1";
            if (TextUtils.isEmpty(str2)) {
            }
        } else {
            String url = liveInfo.getUrl();
            Logger.d("PlaylistBuilde", "laifeng:playurl=" + url);
            if (liveInfo.getFileFormat() == FileFormat.RTP) {
                nativeMap.put("datasource_live_type", "3");
            } else if (liveInfo.getFileFormat() == FileFormat.ARTP) {
                nativeMap.put("artp_so_path", this.mContext.getApplicationInfo().nativeLibraryDir);
            }
            nativeMap.put("player_source", "3");
            if (TextUtils.isEmpty(url)) {
                TLogUtil.playLog("url is null");
                return null;
            }
            livePeriod.addSource(new Source(url));
            livePeriod.setHeader(nativeMap);
        }
        return livePeriod;
    }
}
