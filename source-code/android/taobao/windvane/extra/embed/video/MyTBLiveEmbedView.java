package android.taobao.windvane.extra.embed.video;

import android.content.Context;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.mediaplay.MediaPlayCenter;
import com.taobao.mediaplay.MediaPlayScreenType;
import com.taobao.mediaplay.MediaType;
import com.taobao.mediaplay.player.IMediaPlayLifecycleListener;
import com.taobao.mediaplay.player.MediaAspectRatio;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: Taobao */
public class MyTBLiveEmbedView extends BaseEmbedView implements IMediaPlayLifecycleListener {
    private static final String Event_State = "changeState";
    private static final String Event_error = "error";
    private static String FIRST_FRAME = "2006";
    private static String LOADING = "2007";
    public static final String NAME = "wvlivevideo";
    private static String PAUSED = "2005";
    private static String PLAYING = "2004";
    private boolean mAutoPlay = false;
    private String mBizCode = null;
    private FrameLayout mComponentHostView = null;
    private Context mContext;
    private String mFeedId = null;
    private int mHeight = 0;
    private MediaPlayCenter mMediaPlayCenter;
    private MediaType mMediaType = MediaType.LIVE;
    private boolean mMuted = false;
    private MediaAspectRatio mObjectFit = MediaAspectRatio.DW_CENTER_CROP;
    private int mScenarioType = 0;
    private String mSrc = null;
    private String mSubBizCode = null;
    boolean mUsePlayerManager = false;
    private int mWidth = 0;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum EmbedProperties {
        src {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setSrc(String.valueOf(obj));
                return true;
            }
        },
        muted {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setMuted(Boolean.parseBoolean(String.valueOf(obj)), z);
                return true;
            }
        },
        autoplay {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setAutoPlay(Boolean.parseBoolean(String.valueOf(obj)));
                return true;
            }
        },
        scenarioType {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                int i = 0;
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                try {
                    i = Integer.valueOf(String.valueOf(obj)).intValue();
                } catch (Throwable unused) {
                }
                myTBLiveEmbedView.setScenarioType(i);
                return true;
            }
        },
        objectFit {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setObjectFit(String.valueOf(obj));
                return true;
            }
        },
        bizCode {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setBizCode(String.valueOf(obj));
                return true;
            }
        },
        subBizCode {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setSubBizCode(String.valueOf(obj));
                return true;
            }
        },
        feedId {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setFeedId(String.valueOf(obj));
                return true;
            }
        },
        usePlayerManager {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.EmbedProperties
            public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBLiveEmbedView, obj, z)) {
                    return false;
                }
                myTBLiveEmbedView.setUsePlayerManager(Boolean.parseBoolean(obj.toString()));
                return true;
            }
        };

        public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
            return (obj == null || myTBLiveEmbedView == null) ? false : true;
        }
    }

    /* compiled from: Taobao */
    private enum JSMethod {
        setMuted {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
                    return true;
                }
                myTBLiveEmbedView.mute(Boolean.TRUE.equals(parseObject.getBoolean("muted")));
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        play {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (!super.doSomething(myTBLiveEmbedView, str, wVCallBackContext) && wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
                myTBLiveEmbedView.play();
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        pause {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (!super.doSomething(myTBLiveEmbedView, str, wVCallBackContext) && wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
                myTBLiveEmbedView.pause();
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        seekTo {
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                if (!super.doSomething(myTBLiveEmbedView, str, wVCallBackContext) && wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
                boolean z = false;
                if (!TextUtils.isEmpty(str) && (parseObject = JSON.parseObject(str)) != null) {
                    try {
                        myTBLiveEmbedView.seekTo(Integer.parseInt(parseObject.getString("time")) * 1000);
                        z = true;
                    } catch (Throwable unused) {
                    }
                }
                if (z && wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
                return true;
            }
        };

        public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
            return !TextUtils.isEmpty(str) && wVCallBackContext != null;
        }
    }

    private synchronized void destroyInner() {
        if (this.mMediaPlayCenter != null) {
            try {
                log("Embed Video destroy");
                this.mMediaPlayCenter.release();
                this.mMediaPlayCenter.destroy();
                this.mMediaPlayCenter = null;
            } catch (Throwable unused) {
            }
        }
    }

    private void fireEvent(String str, Object obj) {
        log("firent " + str + ":" + String.valueOf(obj));
        HashMap hashMap = new HashMap(1);
        hashMap.put("code", obj);
        EmbedViewEvent.firevent(this.webView, this.id, str, JSON.toJSONString(hashMap));
    }

    private View genVideoView() {
        if (this.mComponentHostView == null) {
            this.mComponentHostView = new FrameLayout(this.mContext) {
                /* class android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public void onSizeChanged(int i, int i2, int i3, int i4) {
                    super.onSizeChanged(i, i2, i3, i4);
                }
            };
        }
        MediaPlayCenter mediaPlayCenter = new MediaPlayCenter(this.mContext);
        this.mMediaPlayCenter = mediaPlayCenter;
        mediaPlayCenter.setMediaUrl(this.mSrc);
        this.mMediaPlayCenter.setScenarioType(this.mScenarioType);
        this.mMediaPlayCenter.setMediaType(this.mMediaType);
        this.mMediaPlayCenter.setMute(this.mMuted);
        MediaAspectRatio mediaAspectRatio = this.mObjectFit;
        if (mediaAspectRatio != null) {
            this.mMediaPlayCenter.setMediaAspectRatio(mediaAspectRatio);
        }
        if (!TextUtils.isEmpty(this.mBizCode)) {
            this.mMediaPlayCenter.setBusinessId(this.mBizCode);
        }
        if (!TextUtils.isEmpty(this.mSubBizCode)) {
            this.mMediaPlayCenter.setBizCode(this.mSubBizCode);
        }
        if (!TextUtils.isEmpty(this.mFeedId)) {
            this.mMediaPlayCenter.setMediaId(this.mFeedId);
        }
        this.mMediaPlayCenter.setConfigGroup("MediaLive");
        this.mMediaPlayCenter.hideController();
        this.mMediaPlayCenter.setNeedPlayControlView(false);
        this.mMediaPlayCenter.setMediaLifecycleListener(this);
        this.mMediaPlayCenter.setPlayerType(3);
        this.mMediaPlayCenter.setup();
        this.mComponentHostView.addView(this.mMediaPlayCenter.getView(), this.mWidth, this.mHeight);
        if (this.mAutoPlay) {
            fireEvent(Event_State, LOADING);
            this.mMediaPlayCenter.start();
        }
        log("init EmbedLive View");
        return this.mComponentHostView;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mute(boolean z) {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter != null) {
            mediaPlayCenter.mute(z);
        }
    }

    private void parseParam() {
        setWidth(this.params.mWidth, false);
        setHeight(this.params.mHeight, false);
        EmbedProperties[] values = EmbedProperties.values();
        for (EmbedProperties embedProperties : values) {
            Object obj = this.params.mObjectParam.get(embedProperties.name());
            if (obj != null) {
                embedProperties.setValue(this, obj, false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pause() {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter != null) {
            if (this.mScenarioType < 2) {
                mediaPlayCenter.release();
                fireEvent(Event_State, PAUSED);
                return;
            }
            mediaPlayCenter.pause();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void play() {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter != null) {
            if (this.mScenarioType < 2) {
                mediaPlayCenter.setup();
                fireEvent(Event_State, 2007);
            }
            this.mMediaPlayCenter.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void seekTo(int i) {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter != null) {
            mediaPlayCenter.seekTo(i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
    }

    private void setHeight(int i, boolean z) {
        this.mHeight = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setMuted(boolean z, boolean z2) {
        MediaPlayCenter mediaPlayCenter;
        this.mMuted = z;
        if (z2 && (mediaPlayCenter = this.mMediaPlayCenter) != null) {
            mediaPlayCenter.setMute(z);
            this.mMediaPlayCenter.mute(z);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSrc(String str) {
        this.mSrc = str;
    }

    private void setWidth(int i, boolean z) {
        this.mWidth = i;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        JSMethod jSMethod;
        try {
            jSMethod = JSMethod.valueOf(str);
        } catch (Throwable unused) {
            jSMethod = null;
        }
        if (jSMethod != null) {
            return jSMethod.doSomething(this, str2, wVCallBackContext);
        }
        return super.execute(str, str2, wVCallBackContext);
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public View generateView(Context context) {
        this.mContext = context;
        parseParam();
        return genVideoView();
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public String getViewType() {
        return NAME;
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        Log.d(NAME, str);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        super.onDestroy();
        destroyInner();
    }

    public void onMediaClose() {
    }

    public void onMediaComplete() {
    }

    public void onMediaError(IMediaPlayer iMediaPlayer, int i, int i2) {
        fireEvent("error", Integer.valueOf((-400 <= i || i <= -500) ? (-500 < i || i <= -600) ? i == -5 ? 1008 : (i == -10006 || i == -10000) ? 3002 : 1023 : 1111 : 1110));
    }

    public void onMediaInfo(IMediaPlayer iMediaPlayer, long j, long j2, long j3, Object obj) {
        if (j == 3) {
            fireEvent(Event_State, FIRST_FRAME);
        }
    }

    public void onMediaPause(boolean z) {
        fireEvent(Event_State, PAUSED);
    }

    public void onMediaPlay() {
        fireEvent(Event_State, PLAYING);
    }

    public void onMediaPrepared(IMediaPlayer iMediaPlayer) {
    }

    public void onMediaProgressChanged(int i, int i2, int i3) {
    }

    public void onMediaScreenChanged(MediaPlayScreenType mediaPlayScreenType) {
    }

    public void onMediaSeekTo(int i) {
    }

    public void onMediaStart() {
        fireEvent(Event_State, PLAYING);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnParamChangedListener
    public void onParamChanged(String[] strArr, String[] strArr2) {
        EmbedProperties embedProperties;
        super.onParamChanged(strArr, strArr2);
        if (strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            String str = strArr[0];
            String str2 = strArr2[0];
            try {
                embedProperties = EmbedProperties.valueOf(str);
            } catch (Throwable unused) {
                embedProperties = null;
            }
            if (embedProperties != null) {
                log("onParamChanged key:" + str + " Value : " + String.valueOf(str2));
                embedProperties.setValue(this, str2, true);
            }
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onPause() {
        super.onPause();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onResume() {
        super.onResume();
    }

    public void setBizCode(String str) {
        this.mBizCode = str;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setObjectFit(String str) {
        if (TextUtils.equals(str, "fill")) {
            this.mObjectFit = MediaAspectRatio.DW_CENTER_CROP;
        } else {
            this.mObjectFit = MediaAspectRatio.DW_FIT_CENTER;
        }
    }

    public void setScenarioType(int i) {
        this.mScenarioType = i;
    }

    public void setSubBizCode(String str) {
        this.mSubBizCode = str;
    }

    public void setUsePlayerManager(boolean z) {
        this.mUsePlayerManager = z;
    }
}
