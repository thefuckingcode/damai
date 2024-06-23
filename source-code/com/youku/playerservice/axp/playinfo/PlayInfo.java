package com.youku.playerservice.axp.playinfo;

import android.text.TextUtils;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.player.PlayCostTime;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.constants.TableField;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class PlayInfo {
    private static final String TAG = "PlayInfo";
    public static final int VIDEO_VR_180_3D_LEFT_RIGHT = 5;
    public static final int VIDEO_VR_180_3D_TOP_DOWN = 4;
    public static final int VIDEO_VR_360_2D = 1;
    public static final int VIDEO_VR_360_3D_LEFT_RIGHT = 3;
    public static final int VIDEO_VR_360_3D_TOP_DOWN = 2;
    public static final int VIDEO_VR_NULL = 0;
    private AdInfo mAdInfo;
    private int mCurrentAdIndex = -1;
    private int mDuration;
    private final IVpmFullInfo mFullInfo = new IVpmFullInfo() {
        /* class com.youku.playerservice.axp.playinfo.PlayInfo.AnonymousClass1 */

        @Override // com.youku.vpm.IMonitor
        public double getDouble(String str, double d) {
            return PlayInfo.this.getDouble(str, d);
        }

        @Override // com.youku.vpm.IExt, com.youku.vpm.IMonitor
        public String getString(String str, String str2) {
            return PlayInfo.this.getString(str, str2);
        }

        @Override // com.youku.vpm.IVpmFullInfo
        public Object getTag(String str) {
            return PlayInfo.this.getTag(str);
        }
    };
    private boolean mIsRealVideoStarted;
    private boolean mIsRecycled;
    private PlayCostTime mPlayCostTime;
    private int mPlayIndex;
    private PlayInfoResponse mPlayInfoResponse;
    private PlayItem mPlayItem;
    private PlayParams mPlayParams;
    private PlayDefinition.PlayScene mPlayScene;
    private PlayerConfig mPlayerConfig;
    private int mProgress;
    private Map<String, Object> mTags = new ConcurrentHashMap();

    public PlayInfo(PlayParams playParams, PlayerConfig playerConfig) {
        this.mPlayParams = playParams;
        this.mPlayerConfig = playerConfig;
        this.mPlayCostTime = new PlayCostTime();
        this.mPlayScene = playParams.getPlayScene();
    }

    public AdInfo getAdInfo() {
        return this.mAdInfo;
    }

    public List<BidInfo> getBitInfoByAdType(int i) {
        List<BidInfo> bidInfoListByType;
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null || (bidInfoListByType = adInfo.getBidInfoListByType(i)) == null || bidInfoListByType.size() < this.mCurrentAdIndex) {
            return null;
        }
        return bidInfoListByType;
    }

    public double getDouble(String str, double d) {
        return TextUtils.equals(str, "duration") ? (double) getDuration() : d;
    }

    public int getDuration() {
        PlayItem playItem = this.mPlayItem;
        return (playItem == null || playItem.getDuration() <= this.mDuration) ? this.mDuration : this.mPlayItem.getDuration();
    }

    public PlayCostTime getPlayCostTime() {
        return this.mPlayCostTime;
    }

    public String getPlayId() {
        PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
        if (playInfoResponse != null) {
            return playInfoResponse.getPlayId();
        }
        PlayParams playParams = this.mPlayParams;
        return playParams == null ? "" : playParams.getPlayIdParams() != null ? this.mPlayParams.getPlayIdParams().getPlayId() : this.mPlayParams.getPlayUrlParams() != null ? this.mPlayParams.getPlayUrlParams().getPlayUrl() : "";
    }

    public int getPlayIndex() {
        return this.mPlayIndex;
    }

    public PlayInfoResponse getPlayInfoResponse() {
        return this.mPlayInfoResponse;
    }

    public PlayItem getPlayItem() {
        return this.mPlayItem;
    }

    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    public PlayDefinition.PlayScene getPlayScene() {
        return this.mPlayParams.getPlayScene();
    }

    public PlayDefinition.PlayType getPlayType() {
        return this.mPlayParams.getPlayType();
    }

    public PlayerConfig getPlayerConfig() {
        return this.mPlayerConfig;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getRealPosition(boolean z, int i) {
        boolean z2;
        PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
        if (playInfoResponse == null) {
            return i;
        }
        int i2 = -1;
        List<Point> list = null;
        if (playInfoResponse instanceof PlayInfoUpsResponse) {
            list = ((PlayInfoUpsResponse) playInfoResponse).getCutAdPoints();
        }
        int i3 = 0;
        if (list != null && list.size() > 0) {
            i2 = 0;
            int i4 = -1;
            while (true) {
                if (i2 >= list.size()) {
                    i2 = i4;
                    break;
                }
                double d = list.get(i2).start;
                double d2 = list.get(i2).start + ((double) list.get(i2).al);
                double d3 = (double) i;
                if (d3 >= d && d3 <= d2) {
                    z2 = true;
                    break;
                } else if (d3 < d) {
                    break;
                } else {
                    if (d3 > d2) {
                        i4 = i2;
                    }
                    i2++;
                }
            }
        }
        z2 = false;
        if (i2 > 0 && list != null && list.size() > 0) {
            int i5 = 0;
            while (i3 < i2) {
                i5 += list.get(i3).al;
                i3++;
            }
            i3 = i5;
        }
        return (!z2 || list == null || list.size() <= 0) ? i - i3 : z ? i - ((int) list.get(i2).start) : ((int) list.get(i2).start) - i3;
    }

    public String getString(String str, String str2) {
        if (TextUtils.equals(str, "vid")) {
            if (this.mPlayParams.getPlayType() != PlayDefinition.PlayType.LIVE) {
                return getPlayId();
            }
            PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
            if (playInfoResponse != null) {
                return playInfoResponse.getProperties("vid", (String) null);
            }
        } else if (TextUtils.equals(str, "showId") && this.mPlayParams.getPlayType() == PlayDefinition.PlayType.VOD) {
            PlayInfoResponse playInfoResponse2 = this.mPlayInfoResponse;
            if (playInfoResponse2 != null) {
                return playInfoResponse2.getProperties("showId", (String) null);
            }
            return null;
        }
        if (this.mPlayItem != null) {
            if (TextUtils.equals(str, TableField.FILE_FORMAT)) {
                return this.mPlayItem.getPlayFormat().getStatistics();
            }
            if (TextUtils.equals(str, TableField.VIDEO_FORMAT)) {
                return this.mPlayItem.getVideoFormat();
            }
            if (TextUtils.equals(str, TableField.STREAM_TYPE)) {
                return this.mPlayItem.getStreamType();
            }
            if (TextUtils.equals(str, "playQuality")) {
                return this.mPlayItem.getQuality().toString();
            }
            PlayInfoResponse playInfoResponse3 = this.mPlayInfoResponse;
            if (playInfoResponse3 != null) {
                String properties = playInfoResponse3.getProperties(str, (String) null);
                if (!TextUtils.isEmpty(properties)) {
                    return properties;
                }
            }
        }
        return this.mPlayParams.getString(str, str2);
    }

    public Object getTag(String str) {
        return this.mTags.get(str);
    }

    public int getVRMode() {
        int vrType;
        if (getPlayType() != PlayDefinition.PlayType.VOD) {
            getPlayType();
            PlayDefinition.PlayType playType = PlayDefinition.PlayType.LIVE;
            return 101;
        } else if (getPlayItem() == null || (vrType = ((VodItem) getPlayItem()).getBitStream().getVrType()) == 0) {
            return 101;
        } else {
            if (vrType != 1) {
                return vrType != 2 ? 101 : 102;
            }
            return 103;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    public int getVRType() {
        String str;
        int i;
        int vrType;
        Logger.d(TAG, "getVRType: enter");
        if (getPlayType() != PlayDefinition.PlayType.VOD) {
            getPlayType();
            PlayDefinition.PlayType playType = PlayDefinition.PlayType.LIVE;
            return 0;
        } else if (!isPanorama()) {
            Logger.d(TAG, "getVRType: return after isPanorama");
            return 0;
        } else {
            PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
            if (playInfoResponse == null || playInfoResponse.getUpsInfo() == null || this.mPlayInfoResponse.getUpsInfo().getVideoInfo() == null || TextUtils.isEmpty(this.mPlayInfoResponse.getUpsInfo().getVideoInfo().getVideo().vrType)) {
                Logger.d(TAG, "getVRType ----> is null");
                str = "";
            } else {
                str = this.mPlayInfoResponse.getUpsInfo().getVideoInfo().getVideo().vrType;
                Logger.d(TAG, "getVRType ----> videoInfo :" + str);
            }
            if (getPlayItem() != null) {
                VodItem vodItem = (VodItem) getPlayItem();
                if (!(vodItem == null || vodItem.getBitStream() == null || (vrType = vodItem.getBitStream().getVrType()) == 0)) {
                    if (vrType == 1) {
                        i = 2;
                    } else if (vrType == 2) {
                        i = 1;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (str.equals("1")) {
                            return (i * 10) + 1;
                        }
                        if (str.equals("2")) {
                            return (i * 10) + 2;
                        }
                        if (str.equals("3")) {
                            return (i * 10) + 3;
                        }
                        if (str.equals("4")) {
                            return (i * 10) + 4;
                        }
                        if (str.equals("5")) {
                            return (i * 10) + 5;
                        }
                    }
                }
                i = 0;
                if (!TextUtils.isEmpty(str)) {
                }
            }
            return 0;
        }
    }

    public IVpmFullInfo getVpmFullInfo() {
        return this.mFullInfo;
    }

    public boolean isPanorama() {
        PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
        if (playInfoResponse != null) {
            return "1".equals(playInfoResponse.getProperties("isPanorama", ""));
        }
        return false;
    }

    public boolean isRealVideoStarted() {
        return this.mIsRealVideoStarted;
    }

    public boolean isRecycled() {
        return this.mIsRecycled;
    }

    public void putString(String str, String str2) {
        this.mPlayParams.putString(str, str2);
    }

    public void recycle() {
        this.mIsRecycled = true;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.mAdInfo = adInfo;
    }

    public void setCurrentAdIndex(int i) {
        this.mCurrentAdIndex = i;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setPlayIndex(int i) {
        this.mPlayIndex = this.mPlayIndex;
    }

    public void setPlayInfoResponse(PlayInfoResponse playInfoResponse) {
        this.mPlayInfoResponse = playInfoResponse;
        this.mAdInfo = playInfoResponse.getAdInfo();
    }

    public void setPlayItem(PlayItem playItem) {
        this.mPlayItem = playItem;
    }

    public void setPlayParams(PlayParams playParams) {
        this.mPlayParams = playParams;
    }

    public void setPlayerConfig(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
    }

    public void setProgress(int i) {
        this.mProgress = i;
        this.mPlayCostTime.onPositionUpdate(i);
    }

    public void setRealVideoStarted(boolean z) {
        this.mIsRealVideoStarted = z;
    }

    public void setTag(String str, Object obj) {
        if (obj != null) {
            this.mTags.put(str, obj);
        } else {
            this.mTags.remove(str);
        }
    }
}
