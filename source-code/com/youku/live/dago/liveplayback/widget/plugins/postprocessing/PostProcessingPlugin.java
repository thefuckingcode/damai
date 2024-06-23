package com.youku.live.dago.liveplayback.widget.plugins.postprocessing;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Taobao */
public class PostProcessingPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "PostProcessing-Plugin";
    private HashSet<String> lastPPFilters = new HashSet<>();
    private IPlayer mPlayer;
    private IAlixPlayer.State mState = IAlixPlayer.State.STATE_IDLE;
    private YoukuVideoInfo mYoukuVideoInfo;
    private ArrayList<String> processingNamespaces2 = new ArrayList<>();

    public PostProcessingPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.processingNamespaces2.add("pp_sharp");
        this.processingNamespaces2.add("pp_color_filter");
        this.processingNamespaces2.add("pp_color_space_correct");
        this.processingNamespaces2.add("pp_hdr");
        this.processingNamespaces2.add("pp_audio_enhancement");
        this.processingNamespaces2.add("pp_hdr10");
        this.processingNamespaces2.add("pp_deband");
        this.mAttachToParent = true;
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1284235634")) {
                    ipChange.ipc$dispatch("1284235634", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "812195057")) {
                    ipChange.ipc$dispatch("812195057", new Object[]{this, youkuVideoInfo});
                    return;
                }
                PostProcessingPlugin.this.mYoukuVideoInfo = youkuVideoInfo;
                PostProcessingPlugin.this.onGetVideoInfoSuccess();
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1100890582")) {
                    ipChange.ipc$dispatch("-1100890582", new Object[]{this, playVideoInfo});
                }
            }
        });
        IPlayer player = alixPlayerContext.getPlayerContainer().getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(new OnStateChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1969512452")) {
                    ipChange.ipc$dispatch("1969512452", new Object[]{this, state, state2});
                    return;
                }
                PostProcessingPlugin.this.mState = state2;
                if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    PostProcessingPlugin.this.onRealVideoStart();
                }
            }
        });
        this.mPlayer.addOnInfoListener(new OnInfoListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnInfoListener
            public void onInfo(int i, int i2, int i3, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1945148555")) {
                    ipChange.ipc$dispatch("1945148555", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
                    return;
                }
                PostProcessingPlugin.this.onPlayerInfo(i, i2, i3, obj);
            }
        });
        alixPlayerContext.getPlayerContainer().addChangeVideoListener(new OnChangeVideoListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideo(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "478387292")) {
                    ipChange.ipc$dispatch("478387292", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideoFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1410807861")) {
                    ipChange.ipc$dispatch("-1410807861", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    PostProcessingPlugin.this.onQualityChangeSuccess();
                }
            }
        });
    }

    private void closePostProcess2(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494850458")) {
            ipChange.ipc$dispatch("-494850458", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (Logger.DEBUG) {
            Logger.d(TAG, "close2 " + i);
        }
        if (i == 0) {
            if (Logger.DEBUG) {
                Logger.d(TAG, "close2 wrong filter");
            }
        } else if (this.mPlayer != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "0");
            int filter = this.mPlayer.setFilter(i, hashMap);
            TLogUtil.loge(TAG, "close2  filter = " + i + "  with params = " + hashMap + " , result = " + filter);
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    private void doPostProcessByPlayControl(com.youku.android.liveservice.bean.BypassPlayInfo r5, java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 265
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.doPostProcessByPlayControl(com.youku.android.liveservice.bean.BypassPlayInfo, java.lang.String):void");
    }

    private void doPostProcessing2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772033582")) {
            ipChange.ipc$dispatch("1772033582", new Object[]{this, str});
            return;
        }
        doPostProcessing2(str, PostProcessingConfigManager2.getCurrentPPTypeId(this.mPlayer.getVideoStream().getCurAlixVideoItem().getStreamType()));
    }

    private void masterPostProcess2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670177591")) {
            ipChange.ipc$dispatch("670177591", new Object[]{this, str});
            return;
        }
        YoukuVideoInfo youkuVideoInfo = this.mYoukuVideoInfo;
        if (youkuVideoInfo != null) {
            int playControlPostProcessMode = PostProcessingConfigManager2.getPlayControlPostProcessMode(youkuVideoInfo.getBypassPlayInfo());
            if (playControlPostProcessMode == 1) {
                Iterator<String> it = this.processingNamespaces2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (PostProcessingConfigManager2.isPPMasterEnable(next)) {
                        doPostProcessing2(next, PostProcessingConfigManager2.getCurrentPPTypeId(str));
                    } else {
                        closePostProcess2(PostProcessingConfigManager2.getPPFilterType(next));
                    }
                }
            } else if (playControlPostProcessMode == 2) {
                doPostProcessByPlayControl(this.mYoukuVideoInfo.getBypassPlayInfo(), str);
            }
        }
    }

    private void noneMasterPostProcess2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505545685")) {
            ipChange.ipc$dispatch("1505545685", new Object[]{this});
            return;
        }
        YoukuVideoInfo youkuVideoInfo = this.mYoukuVideoInfo;
        if (youkuVideoInfo != null) {
            int playControlPostProcessMode = PostProcessingConfigManager2.getPlayControlPostProcessMode(youkuVideoInfo.getBypassPlayInfo());
            if (playControlPostProcessMode == 1) {
                try {
                    Iterator<String> it = this.processingNamespaces2.iterator();
                    while (it.hasNext()) {
                        doPostProcessing2(it.next());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (playControlPostProcessMode == 2) {
                doPostProcessByPlayControl(this.mYoukuVideoInfo.getBypassPlayInfo(), this.mPlayer.getVideoStream().getCurAlixVideoItem().getStreamType());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onGetVideoInfoSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1296956825")) {
            ipChange.ipc$dispatch("-1296956825", new Object[]{this});
        } else if (this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            noneMasterPostProcess2();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onPlayerInfo(int i, int i2, int i3, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367463675")) {
            ipChange.ipc$dispatch("1367463675", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onQualityChangeSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294483295")) {
            ipChange.ipc$dispatch("1294483295", new Object[]{this});
            return;
        }
        noneMasterPostProcess2();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "779133646")) {
            ipChange.ipc$dispatch("779133646", new Object[]{this});
            return;
        }
        noneMasterPostProcess2();
    }

    private void openPostProcess2(int i, PPConfigItem pPConfigItem, PPConfigItem pPConfigItem2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430855106")) {
            ipChange.ipc$dispatch("-1430855106", new Object[]{this, Integer.valueOf(i), pPConfigItem, pPConfigItem2});
            return;
        }
        if (Logger.DEBUG) {
            Logger.d(TAG, "open2 " + i);
        }
        if (i == 0) {
            if (Logger.DEBUG) {
                Logger.d(TAG, "open2 wrong filter");
            }
        } else if (this.mPlayer != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", pPConfigItem2 != null ? pPConfigItem2.algorithm : pPConfigItem.algorithm);
            if (pPConfigItem != null && !TextUtils.isEmpty(pPConfigItem.extend)) {
                hashMap.put("extend", pPConfigItem.extend);
            }
            if (pPConfigItem2 != null && !TextUtils.isEmpty(pPConfigItem2.extend)) {
                hashMap.put("ups_extend", pPConfigItem2.extend);
            }
            int filter = this.mPlayer.setFilter(i, hashMap);
            TLogUtil.loge(TAG, " open2  filter = " + i + "  with params = " + hashMap + " , result = " + filter);
        }
    }

    private int openPostProcessByPlayControl(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107280418")) {
            return ((Integer) ipChange.ipc$dispatch("-1107280418", new Object[]{this, jSONObject})).intValue();
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingAlgorithm"))) {
            hashMap.put("type", jSONObject.getString("appPostProcessingAlgorithm"));
        }
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingDefaultExtend"))) {
            hashMap.put("extend", jSONObject.getString("appPostProcessingDefaultExtend"));
        }
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingExtend"))) {
            hashMap.put("ups_extend", jSONObject.getString("appPostProcessingExtend"));
        }
        String string = jSONObject.getString("appPostProcessingType");
        int filter = this.mPlayer.setFilter(Integer.parseInt(string), hashMap);
        TLogUtil.loge(TAG, "openPostProcessByPlayControl  filter = " + string + "  with params = " + hashMap + " , result = " + filter);
        return filter;
    }

    private void doPostProcessing2(String str, String str2) {
        PPConfigItem pPConfigItem;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-72855432")) {
            ipChange.ipc$dispatch("-72855432", new Object[]{this, str, str2});
            return;
        }
        PPConfigItem pPConfigItem2 = null;
        if (TextUtils.isEmpty(str2) || !PostProcessingConfigManager2.isPostProcessingEnable(this.mPlayerContext.getContext(), str)) {
            pPConfigItem = null;
        } else {
            i = PostProcessingConfigManager2.getPPFilterType(str);
            pPConfigItem2 = PostProcessingConfigManager2.getPPConfigItemByTypeId(str, str2);
            pPConfigItem = PostProcessingConfigManager2.getPPConfigItemByLiveControl(str, this.mYoukuVideoInfo.getBypassPlayInfo(), str2);
        }
        String pPMode = PostProcessingConfigManager2.getPPMode(pPConfigItem2, pPConfigItem);
        if ("1".equals(pPMode)) {
            openPostProcess2(i, pPConfigItem2, pPConfigItem);
        } else if (!"2".equals(pPMode)) {
            closePostProcess2(i);
        }
    }
}
