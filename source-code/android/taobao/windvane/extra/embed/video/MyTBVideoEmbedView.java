package android.taobao.windvane.extra.embed.video;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.avplayer.DWAspectRatio;
import com.taobao.avplayer.DWInstanceType;
import com.taobao.avplayer.IDWVideoLifecycleListener;
import com.taobao.avplayer.IDWVideoLoopCompleteListener;
import com.taobao.avplayer.TBDWInstance;
import com.taobao.avplayer.TBHighPerformanceDWInstance;
import com.taobao.avplayer.common.IDWMutedChangeListener;
import com.taobao.avplayer.common.IDWRootViewClickListener;
import com.taobao.avplayer.interactivelifecycle.frontcover.model.DWFrontCover;
import com.taobao.avplayer.interactivelifecycle.frontcover.model.DWFrontCoverBean;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.EmbedViewConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class MyTBVideoEmbedView extends BaseEmbedView implements IDWVideoLifecycleListener, IDWVideoLoopCompleteListener, IDWMutedChangeListener, IDWRootViewClickListener {
    private static String ERROR = "error";
    private static String FINISH = "finish";
    private static final String FULL_SCREEN_MODE = "fullScreen";
    private static String LANDSCAPE = "landscape";
    private static String METADATA = "meta";
    private static String MUTEDCHANGE = "mutedChange";
    public static final String NAME = "wvvideo";
    private static final String NORMAL_SCREEN_MODE = "inlineScreen";
    private static String PAUSED = "paused";
    private static String PLAYING = "playing";
    private static String PREPARED = "prepared";
    private static String SCREENMODECHANGE = "screenModeChange";
    private static final String SMALL_SCREEN_MODE = "smallScreen";
    private static final String VALUE_FALSE = "false";
    private static final long VALUE_LONG = -1;
    private static final String VALUE_TRUE = "true";
    private static String VIDEOEND = "end";
    private boolean isCompleted = false;
    private DWAspectRatio mAspectRatio;
    private boolean mAutoPlay;
    private boolean mBackCoverDisPlay;
    private FrameLayout mComponentHostView = null;
    private String mContentId = null;
    private String mContentMode = null;
    private Context mContext;
    private boolean mControlsViewHidden;
    private int mCurrentTime = 0;
    private DWInstanceType mDWInstanceType = null;
    private String mFrom = null;
    private boolean mGestureViewHidden;
    private boolean mHasDisappear;
    private boolean mHasPlay = false;
    private int mHeight = 0;
    private TBHighPerformanceDWInstance mHigDWInstance;
    private boolean mInit;
    private long mInteractiveId;
    private boolean mIsVideoLoop;
    private boolean mLandscape = false;
    private boolean mLoadingHidden;
    private boolean mMiniProgressViewHidden;
    private boolean mMuted = false;
    private boolean mNeedAD = true;
    private boolean mNeedFirstPlayUT = true;
    private boolean mNetworkErrorViewHidden;
    private String mPlayControl = null;
    private boolean mPlayErrorViewHidden;
    private String mPlayerScene = null;
    private boolean mPlayingIconHidden;
    private ImageView.ScaleType mPosterScaleType;
    private String mPreload = null;
    private boolean mResume = false;
    private String mScreenMode;
    private boolean mShowInteractive = false;
    private boolean mShownMuteBtn;
    private String mSrc = null;
    private boolean mStarted = false;
    private TBDWInstance mTBDWInstance;
    private String mThumbnailSrc = null;
    private boolean mToastViewHidden;
    private long mUserId;
    private int mVideoDuration = 0;
    private String mVideoId = null;
    private String mVideoSource = null;
    private int mWidth = 0;
    private HashMap<String, String> utParams;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum EmbedProperties {
        playerScene {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPlayerScene(String.valueOf(obj), z);
                return true;
            }
        },
        instanceType {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setDWInstanceType(String.valueOf(obj), z);
                return true;
            }
        },
        src {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setSrc(String.valueOf(obj), z);
                return true;
            }
        },
        loop {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setIsVideoLoop(toBoolean(obj), z);
                return true;
            }
        },
        autoplay {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setAutoPlay(toBoolean(obj), z);
                return true;
            }
        },
        thumbnailSrc {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setThumbnailSrc(String.valueOf(obj), z);
                return true;
            }
        },
        poster {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setThumbnailSrc(String.valueOf(obj), z);
                return true;
            }
        },
        interactiveHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setInteractiveHidden(toBoolean(obj), z);
                return true;
            }
        },
        contentId {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setContentId(String.valueOf(obj), z);
                return true;
            }
        },
        backCoverDisplay {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setBackCoverDisPlay(toBoolean(obj), z);
                return true;
            }
        },
        muted {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setMuted(toBoolean(obj), z);
                return true;
            }
        },
        preload {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPreLoad(String.valueOf(obj), z);
                return true;
            }
        },
        videoSource {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setVideoSource(String.valueOf(obj), z);
                return true;
            }
        },
        videoId {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setVideoId(String.valueOf(obj), z);
                return true;
            }
        },
        from {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setFrom(String.valueOf(obj), z);
                return true;
            }
        },
        utParams {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setUtParams(new HashMap<>(), z);
                return true;
            }
        },
        playControl {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPlayControl(String.valueOf(obj), z);
                return true;
            }
        },
        contentMode {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setContentMode(String.valueOf(obj), z);
                return true;
            }
        },
        interactiveId {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setInteractiveId(toLong(obj), z);
                return true;
            }
        },
        userId {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setUserId(toLong(obj), z);
                return true;
            }
        },
        miniProgressViewHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setMiniProgressViewHidden(toBoolean(obj), z);
                return true;
            }
        },
        networkErrorViewHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setNetworkErrorViewHidden(toBoolean(obj), z);
                return true;
            }
        },
        toastViewHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setToastViewHidden(toBoolean(obj), z);
                return true;
            }
        },
        playingIconHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPlayingIconHidden(toBoolean(obj), z);
                return true;
            }
        },
        gestureViewHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setGestureViewHidden(toBoolean(obj), z);
                return true;
            }
        },
        controlsViewHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setControlsViewHidden(toBoolean(obj), z);
                return true;
            }
        },
        loadingHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setLoadingHidden(toBoolean(obj), z);
                return true;
            }
        },
        playErrorViewHidden {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPlayErrorViewHidden(toBoolean(obj), z);
                return true;
            }
        },
        setWidth {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setWidth((int) toLong(obj), true);
                }
                return true;
            }
        },
        setHeight {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setHeight((int) toLong(obj), true);
                }
                return true;
            }
        },
        shownMuteBtn {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setShownMuteBtn(toBoolean(obj), z);
                return true;
            }
        };

        public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
            return (obj == null || myTBVideoEmbedView == null) ? false : true;
        }

        public boolean toBoolean(Object obj) {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            String valueOf = String.valueOf(obj);
            return "true".equals(valueOf) || "1".equals(valueOf);
        }

        public long toLong(Object obj) {
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            try {
                return Long.parseLong(String.valueOf(obj));
            } catch (Throwable unused) {
                return -1;
            }
        }
    }

    /* compiled from: Taobao */
    private enum JSMethod {
        getCurrentTime {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext == null) {
                    return false;
                }
                int currentPosition = myTBVideoEmbedView.getCurrentPosition();
                wVCallBackContext.success("" + (((float) currentPosition) / 1000.0f));
                return true;
            }
        },
        setCurrentTime {
            /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                boolean z;
                JSONObject parseObject;
                if (!TextUtils.isEmpty(str) && (parseObject = JSON.parseObject(str)) != null) {
                    try {
                        int parseInt = Integer.parseInt(parseObject.getString("time")) * 1000;
                        if (myTBVideoEmbedView.mTBDWInstance != null) {
                            myTBVideoEmbedView.mTBDWInstance.seekTo(parseInt);
                        } else if (myTBVideoEmbedView.mHigDWInstance != null) {
                            myTBVideoEmbedView.mHigDWInstance.seekTo(parseInt);
                        }
                        z = true;
                    } catch (Throwable unused) {
                    }
                    if (wVCallBackContext != null) {
                        if (z) {
                            wVCallBackContext.success();
                        } else {
                            wVCallBackContext.error();
                        }
                    }
                    return true;
                }
                z = false;
                if (wVCallBackContext != null) {
                }
                return true;
            }
        },
        getDuration {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success(String.valueOf(((float) myTBVideoEmbedView.mVideoDuration) / 1000.0f));
                return true;
            }
        },
        getMuted {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success(String.valueOf(myTBVideoEmbedView.isMute()));
                return true;
            }
        },
        setMuted {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
                    return true;
                }
                myTBVideoEmbedView.mute(Boolean.TRUE.equals(parseObject.getBoolean("muted")));
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        setScreenMode {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                Object obj;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null || (obj = parseObject.get("screenMode")) == null) {
                    return false;
                }
                myTBVideoEmbedView.setScreenMode(String.valueOf(obj), true);
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
                return true;
            }
        },
        getScreenMode {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success(myTBVideoEmbedView.mScreenMode);
                return true;
            }
        },
        play {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                myTBVideoEmbedView.play();
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        pause {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (myTBVideoEmbedView.mTBDWInstance != null) {
                    myTBVideoEmbedView.mTBDWInstance.pauseVideo();
                } else if (myTBVideoEmbedView.mHigDWInstance != null) {
                    myTBVideoEmbedView.mHigDWInstance.pauseVideo();
                }
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        setInstanceMode {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                Object obj;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null || (obj = parseObject.get("instanceMode")) == null) {
                    return false;
                }
                myTBVideoEmbedView.setDWInstanceType(String.valueOf(obj), true);
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
                return true;
            }
        },
        updateEmbedProperty {
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                EmbedProperties embedProperties;
                if (myTBVideoEmbedView == null || TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
                    return false;
                }
                Object obj = parseObject.get("key");
                Object obj2 = parseObject.get("value");
                if (obj == null || obj2 == null) {
                    return false;
                }
                try {
                    embedProperties = EmbedProperties.valueOf(String.valueOf(obj));
                } catch (Throwable unused) {
                    embedProperties = null;
                }
                if (embedProperties == null) {
                    return false;
                }
                embedProperties.setValue(myTBVideoEmbedView, obj2, true);
                return true;
            }
        };

        public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
            return false;
        }
    }

    private void destroyInner() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            boolean z = this.mHasPlay;
            if (!z) {
                z = tBDWInstance.adIsPlaying();
            }
            this.mHasPlay = z;
            if (this.mTBDWInstance.isFullScreen()) {
                ViewGroup view = this.mTBDWInstance.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
                this.mTBDWInstance.toggleScreen();
            }
            FrameLayout frameLayout = this.mComponentHostView;
            if (frameLayout != null) {
                frameLayout.removeView(this.mTBDWInstance.getView());
            }
            this.mTBDWInstance.setVideoLifecycleListener((IDWVideoLifecycleListener) null);
            this.mTBDWInstance.destroy();
            this.mTBDWInstance = null;
            return;
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            FrameLayout frameLayout2 = this.mComponentHostView;
            if (frameLayout2 != null) {
                frameLayout2.removeView(tBHighPerformanceDWInstance.getView());
            }
            this.mHigDWInstance.setVideoLifecycleListener((IDWVideoLifecycleListener) null);
            this.mHigDWInstance.destroy();
            this.mHigDWInstance = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireEvent(String str, String str2) {
        EmbedViewEvent.firevent(this.webView, this.id, str, str2);
    }

    private View genVideoView() {
        boolean z;
        View view;
        if ("highPerformance".equals(this.mPlayerScene)) {
            view = initHighInstance();
            z = true;
        } else {
            view = initNormalInstance();
            z = false;
        }
        this.mInit = true;
        if (this.mComponentHostView == null) {
            this.mComponentHostView = new FrameLayout(this.mContext) {
                /* class android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public void onSizeChanged(int i, int i2, int i3, int i4) {
                    super.onSizeChanged(i, i2, i3, i4);
                    if (i4 != i3 || i4 != 0) {
                        if (MyTBVideoEmbedView.this.mHeight != i2 || MyTBVideoEmbedView.this.mWidth != i) {
                            MyTBVideoEmbedView.this.mHeight = i2;
                            MyTBVideoEmbedView.this.mWidth = i;
                            if (MyTBVideoEmbedView.this.mTBDWInstance != null) {
                                MyTBVideoEmbedView.this.mTBDWInstance.setFrame(i, i2);
                            } else if (MyTBVideoEmbedView.this.mHigDWInstance != null) {
                                MyTBVideoEmbedView.this.mHigDWInstance.setFrame(i, i2);
                            }
                        }
                    }
                }
            };
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        this.mComponentHostView.addView(view);
        if (this.mAutoPlay) {
            if (z) {
                this.mHigDWInstance.start();
            } else {
                this.mTBDWInstance.start();
            }
            fireEvent(PLAYING, "");
        }
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.AnonymousClass2 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                MyTBVideoEmbedView.this.fireEvent("click", "");
                return false;
            }
        });
        return this.mComponentHostView;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getCurrentPosition() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            return tBDWInstance.getCurrentPosition();
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            return tBHighPerformanceDWInstance.getCurrentPosition();
        }
        return 0;
    }

    private View initHighInstance() {
        TBHighPerformanceDWInstance.TBBuilder tBBuilder = new TBHighPerformanceDWInstance.TBBuilder((Activity) this.mContext);
        tBBuilder.setBizCode(this.mFrom);
        tBBuilder.setContentId(this.mContentId);
        tBBuilder.setUserId(this.mUserId);
        tBBuilder.setVideoUrl(this.mSrc);
        tBBuilder.setMute(this.mMuted);
        tBBuilder.setUTParams(this.utParams);
        tBBuilder.setWidth(this.mWidth);
        tBBuilder.setVideoId(this.mVideoId);
        tBBuilder.setVideoSource(this.mVideoSource);
        tBBuilder.setHeight(this.mHeight);
        tBBuilder.setVideoLoop(this.mIsVideoLoop);
        DWAspectRatio dWAspectRatio = this.mAspectRatio;
        if (dWAspectRatio != null) {
            tBBuilder.setVideoAspectRatio(dWAspectRatio);
        }
        tBBuilder.setDWInstanceType(DWInstanceType.PIC);
        this.mHigDWInstance = tBBuilder.create();
        if (!TextUtils.isEmpty(this.mThumbnailSrc)) {
            TUrlImageView tUrlImageView = new TUrlImageView(this.mContext);
            ImageView.ScaleType scaleType = this.mPosterScaleType;
            if (scaleType != null) {
                tUrlImageView.setScaleType(scaleType);
            }
            tUrlImageView.asyncSetImageUrl(this.mThumbnailSrc);
            this.mHigDWInstance.setPicImageView(tUrlImageView);
        }
        this.mHigDWInstance.setVideoLifecycleListener(this);
        if (this.mIsVideoLoop) {
            this.mHigDWInstance.setIVideoLoopCompleteListener(this);
        }
        this.mHigDWInstance.setRootViewClickListener(this);
        this.mHigDWInstance.setIDWMutedChangeListener(this);
        if (this.mAutoPlay || (this.mResume && this.mStarted)) {
            this.mHigDWInstance.setInstanceType(DWInstanceType.VIDEO);
            this.mStarted = true;
            this.mNeedFirstPlayUT = false;
            this.mHigDWInstance.start();
        } else if (METADATA.equals(this.mPreload)) {
            this.mHigDWInstance.setInstanceType(DWInstanceType.VIDEO);
            this.mHigDWInstance.asyncPrepareVideo();
        }
        return this.mHigDWInstance.getView();
    }

    private View initNormalInstance() {
        TBDWInstance.TBBuilder tBBuilder = new TBDWInstance.TBBuilder((Activity) this.mContext);
        tBBuilder.setVideoUrl(this.mSrc);
        if (!TextUtils.isEmpty(this.mPlayerScene)) {
            tBBuilder.setScene(this.mPlayerScene);
        }
        DWInstanceType dWInstanceType = this.mDWInstanceType;
        if (dWInstanceType != null) {
            tBBuilder.setDWInstanceType(dWInstanceType);
        }
        tBBuilder.setVideoLoop(this.mIsVideoLoop);
        tBBuilder.setMute(this.mMuted);
        if (!TextUtils.isEmpty(this.mContentId)) {
            tBBuilder.setContentId(this.mContentId);
        }
        tBBuilder.setNeedBackCover(this.mBackCoverDisPlay);
        tBBuilder.setVideoSource(this.mVideoSource);
        tBBuilder.setVideoId(this.mVideoId);
        tBBuilder.setBizCode(this.mFrom);
        tBBuilder.setUTParams(this.utParams);
        if (this.mUserId != -1) {
            tBBuilder.setInteractiveId(this.mInteractiveId);
        }
        long j = this.mUserId;
        if (j != -1) {
            tBBuilder.setUserId(j);
        }
        if (!TextUtils.isEmpty(this.mThumbnailSrc)) {
            tBBuilder.setNeedFrontCover(true);
            DWFrontCover dWFrontCover = new DWFrontCover();
            DWFrontCoverBean dWFrontCoverBean = new DWFrontCoverBean(0L, (String) null, this.mThumbnailSrc);
            dWFrontCoverBean.setScaleType(this.mPosterScaleType);
            dWFrontCover.setFrontCoverView(dWFrontCoverBean);
            tBBuilder.setFrontCoverData(dWFrontCover);
        }
        tBBuilder.setMiniProgressAnchorShown(this.mMiniProgressViewHidden);
        tBBuilder.hiddenNetworkErrorView(this.mNetworkErrorViewHidden);
        tBBuilder.hiddenToastView(this.mToastViewHidden);
        tBBuilder.hiddenPlayingIcon(this.mPlayingIconHidden);
        tBBuilder.hiddenGestureView(this.mGestureViewHidden);
        tBBuilder.hiddenLoading(this.mLoadingHidden);
        tBBuilder.hiddenPlayErrorView(this.mPlayErrorViewHidden);
        tBBuilder.setMuteDisplay(this.mShownMuteBtn);
        tBBuilder.setWidth(this.mWidth);
        tBBuilder.setHeight(this.mHeight);
        TBDWInstance create = tBBuilder.create();
        this.mTBDWInstance = create;
        create.setVideoLifecycleListener(this);
        this.mTBDWInstance.setIDWMutedChangeListener(this);
        this.mTBDWInstance.hideCloseView();
        this.mTBDWInstance.hideController();
        return this.mTBDWInstance.getView();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isMute() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        return tBDWInstance != null ? tBDWInstance.isMute() : this.mHigDWInstance.isMute();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mute(boolean z) {
        this.mMuted = z;
        if (this.mInit && !this.mHasDisappear) {
            TBDWInstance tBDWInstance = this.mTBDWInstance;
            if (tBDWInstance != null) {
                tBDWInstance.mute(z);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.mute(z);
            }
        }
    }

    private void parseParam() {
        setWidth(this.params.mWidth, false);
        setHeight(this.params.mHeight, false);
        EmbedProperties[] values = EmbedProperties.values();
        for (EmbedProperties embedProperties : values) {
            embedProperties.setValue(this, this.params.mObjectParam.get(embedProperties.name()), false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void play() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance == null) {
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.setInstanceType(DWInstanceType.VIDEO);
                if (this.mHigDWInstance.getVideoState() == 0 || this.mHigDWInstance.getVideoState() == 5 || this.mHigDWInstance.getVideoState() == 8 || this.mHigDWInstance.getVideoState() == 4) {
                    this.mStarted = true;
                    this.mNeedFirstPlayUT = false;
                    this.mHigDWInstance.start();
                    return;
                }
                this.mHigDWInstance.playVideo();
            }
        } else if (tBDWInstance.getVideoState() == 0 || this.mTBDWInstance.getVideoState() == 5 || this.mTBDWInstance.getVideoState() == 8 || this.mTBDWInstance.getVideoState() == 4) {
            this.mStarted = true;
            this.mTBDWInstance.start();
        } else {
            this.mTBDWInstance.playVideo();
        }
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
        Map map;
        EmbedViewConfig embedViewConfig = this.params;
        if (embedViewConfig == null || (map = embedViewConfig.mObjectParam) == null || map.isEmpty()) {
            return null;
        }
        this.mContext = context;
        parseParam();
        return genVideoView();
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public String getViewType() {
        return NAME;
    }

    public boolean hook() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        Log.e("dyy", str);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onAttachedToWebView() {
        super.onAttachedToWebView();
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        super.onDestroy();
        destroyInner();
        this.mInit = false;
        this.mContext = null;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDetachedFromWebView() {
        super.onDetachedFromWebView();
    }

    public void onLoopCompletion() {
    }

    public void onMutedChange(boolean z) {
        fireEvent(MUTEDCHANGE, z ? "true" : "false");
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

    public void onVideoClose() {
    }

    public void onVideoComplete() {
        this.mNeedAD = true;
        this.isCompleted = true;
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            tBDWInstance.needAD(true);
        }
        this.mHasPlay = false;
        this.mCurrentTime = 0;
        fireEvent(FINISH, "");
        fireEvent(VIDEOEND, "");
    }

    public void onVideoError(Object obj, int i, int i2) {
        fireEvent(ERROR, "");
    }

    public void onVideoFullScreen() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            tBDWInstance.mute(false);
            this.mLandscape = true;
            this.mTBDWInstance.showOrHideInteractive(true);
            this.mTBDWInstance.showTopEventView();
            this.mTBDWInstance.showGoodsListView();
            fireEvent(SCREENMODECHANGE, FULL_SCREEN_MODE);
            HashMap hashMap = new HashMap(1);
            hashMap.put("landscape", Boolean.TRUE);
            fireEvent(LANDSCAPE, JSON.toJSONString(hashMap));
            this.mScreenMode = FULL_SCREEN_MODE;
        }
    }

    public void onVideoInfo(Object obj, int i, int i2) {
    }

    public void onVideoNormalScreen() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            this.mLandscape = false;
            tBDWInstance.mute(this.mMuted);
            this.mTBDWInstance.showOrHideInteractive(this.mShowInteractive);
            this.mTBDWInstance.hideGoodsListView();
            this.mTBDWInstance.hideTopEventView();
            fireEvent(SCREENMODECHANGE, SMALL_SCREEN_MODE);
            HashMap hashMap = new HashMap(1);
            hashMap.put("landscape", Boolean.FALSE);
            fireEvent(LANDSCAPE, JSON.toJSONString(hashMap));
            this.mScreenMode = SMALL_SCREEN_MODE;
        }
    }

    public void onVideoPause(boolean z) {
        fireEvent(PAUSED, "");
    }

    public void onVideoPlay() {
        this.isCompleted = false;
        fireEvent(PLAYING, "");
    }

    public void onVideoPrepared(Object obj) {
        this.isCompleted = false;
        fireEvent(PREPARED, "");
    }

    public void onVideoProgressChanged(int i, int i2, int i3) {
        this.mCurrentTime = i;
        if (this.mVideoDuration == 0) {
            this.mVideoDuration = i3;
        }
    }

    public void onVideoSeekTo(int i) {
    }

    public void onVideoStart() {
        TBDWInstance tBDWInstance;
        this.mNeedAD = false;
        this.mStarted = true;
        this.isCompleted = false;
        if (!this.mResume || this.mHasPlay || (tBDWInstance = this.mTBDWInstance) == null) {
            this.mHasPlay = true;
            int i = this.mCurrentTime;
            if (i > 0) {
                TBDWInstance tBDWInstance2 = this.mTBDWInstance;
                if (tBDWInstance2 != null) {
                    tBDWInstance2.seekTo(i);
                    return;
                }
                TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
                if (tBHighPerformanceDWInstance != null) {
                    tBHighPerformanceDWInstance.seekTo(i);
                    return;
                }
                return;
            }
            return;
        }
        tBDWInstance.pauseVideo();
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnVisibilityChangedListener
    public void onVisibilityChanged(int i) {
        super.onVisibilityChanged(i);
    }

    public void setAutoPlay(boolean z, boolean z2) {
        this.mAutoPlay = z;
    }

    public void setBackCoverDisPlay(boolean z, boolean z2) {
        this.mBackCoverDisPlay = z;
    }

    public void setContentId(String str, boolean z) {
        this.mContentId = str;
    }

    public void setContentMode(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1362001767:
                    if (str.equals("aspectFit")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3143043:
                    if (str.equals("fill")) {
                        c = 1;
                        break;
                    }
                    break;
                case 727618043:
                    if (str.equals("aspectFill")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.mAspectRatio = DWAspectRatio.DW_FIT_CENTER;
                    this.mPosterScaleType = ImageView.ScaleType.FIT_CENTER;
                    break;
                case 1:
                    this.mAspectRatio = DWAspectRatio.DW_FIT_X_Y;
                    this.mPosterScaleType = ImageView.ScaleType.FIT_XY;
                    break;
                case 2:
                    this.mAspectRatio = DWAspectRatio.DW_CENTER_CROP;
                    this.mPosterScaleType = ImageView.ScaleType.CENTER_CROP;
                    break;
            }
        }
        this.mContentMode = str;
    }

    public void setControlsViewHidden(boolean z, boolean z2) {
        this.mControlsViewHidden = z;
    }

    public void setDWInstanceType(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            DWInstanceType[] values = DWInstanceType.values();
            for (DWInstanceType dWInstanceType : values) {
                if (dWInstanceType != null && str.equals(dWInstanceType.getValue())) {
                    this.mDWInstanceType = dWInstanceType;
                }
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null && z) {
                tBHighPerformanceDWInstance.setInstanceType(DWInstanceType.VIDEO.equals(this.mDWInstanceType) ? DWInstanceType.VIDEO : DWInstanceType.PIC);
            }
        }
    }

    public void setFrom(String str, boolean z) {
        this.mFrom = str;
    }

    public void setGestureViewHidden(boolean z, boolean z2) {
        this.mGestureViewHidden = z;
    }

    public void setHeight(int i, boolean z) {
        this.mHeight = i;
        if (z) {
            TBDWInstance tBDWInstance = this.mTBDWInstance;
            if (tBDWInstance != null) {
                tBDWInstance.setFrame(this.mWidth, i);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.setFrame(this.mWidth, i);
            }
        }
    }

    public void setInteractiveHidden(boolean z, boolean z2) {
        TBDWInstance tBDWInstance;
        boolean z3 = !z;
        this.mShowInteractive = z3;
        if (this.mInit && !this.mHasDisappear && (tBDWInstance = this.mTBDWInstance) != null) {
            tBDWInstance.showOrHideInteractive(z3);
        }
    }

    public void setInteractiveId(long j, boolean z) {
        this.mInteractiveId = j;
    }

    public void setIsVideoLoop(boolean z, boolean z2) {
        this.mIsVideoLoop = z;
    }

    public void setLoadingHidden(boolean z, boolean z2) {
        this.mLoadingHidden = z;
    }

    public void setMiniProgressViewHidden(boolean z, boolean z2) {
        this.mMiniProgressViewHidden = z;
    }

    public void setMuted(boolean z, boolean z2) {
        TBDWInstance tBDWInstance;
        this.mMuted = z;
        if (z2 && (tBDWInstance = this.mTBDWInstance) != null) {
            tBDWInstance.mute(z);
        }
    }

    public void setNetworkErrorViewHidden(boolean z, boolean z2) {
        this.mNetworkErrorViewHidden = z;
    }

    public void setPlayControl(String str, boolean z) {
        this.mPlayControl = str;
        if (z && this.mTBDWInstance != null) {
            this.mHasPlay = true;
            if (Constants.Value.PLAY.equals(str)) {
                if (this.mTBDWInstance.getVideoState() == 0 || this.mTBDWInstance.getVideoState() == 5 || this.mTBDWInstance.getVideoState() == 8 || this.mTBDWInstance.getVideoState() == 4) {
                    this.mStarted = true;
                    this.mTBDWInstance.start();
                    return;
                }
                this.mTBDWInstance.playVideo();
            } else if ("pause".equals(str)) {
                this.mTBDWInstance.pauseVideo();
            }
        }
    }

    public void setPlayErrorViewHidden(boolean z, boolean z2) {
        this.mPlayErrorViewHidden = z;
    }

    public void setPlayerScene(String str, boolean z) {
        this.mPlayerScene = str;
    }

    public void setPlayingIconHidden(boolean z, boolean z2) {
        this.mPlayingIconHidden = z;
    }

    public void setPreLoad(String str, boolean z) {
        this.mPreload = str;
    }

    public void setScreenMode(String str, boolean z) {
        this.mScreenMode = str;
        if (z && !TextUtils.isEmpty(str) && this.mTBDWInstance != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -883285933:
                    if (str.equals(SMALL_SCREEN_MODE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -806066213:
                    if (str.equals(FULL_SCREEN_MODE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 370161765:
                    if (str.equals(NORMAL_SCREEN_MODE)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (!this.mTBDWInstance.isFullScreen() && !this.mTBDWInstance.isSmallWindow()) {
                        this.mTBDWInstance.toSmall();
                        return;
                    }
                    return;
                case 1:
                    if (!this.mTBDWInstance.isFullScreen()) {
                        this.mTBDWInstance.toggleScreen();
                        return;
                    }
                    return;
                case 2:
                    if (this.mTBDWInstance.isFullScreen()) {
                        this.mTBDWInstance.toggleScreen();
                        return;
                    } else if (this.mTBDWInstance.isSmallWindow()) {
                        this.mTBDWInstance.toNormal();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setShownMuteBtn(boolean z, boolean z2) {
        this.mShownMuteBtn = z;
    }

    public void setSrc(String str, boolean z) {
        this.mSrc = str;
    }

    public void setThumbnailSrc(String str, boolean z) {
        this.mThumbnailSrc = str;
    }

    public void setToastViewHidden(boolean z, boolean z2) {
        this.mToastViewHidden = z;
    }

    public void setUserId(long j, boolean z) {
        this.mUserId = j;
    }

    public void setUtParams(HashMap<String, String> hashMap, boolean z) {
        this.utParams = hashMap;
    }

    public void setVideoId(String str, boolean z) {
        this.mVideoId = str;
    }

    public void setVideoSource(String str, boolean z) {
        this.mVideoSource = str;
    }

    public void setWidth(int i, boolean z) {
        this.mWidth = i;
        if (z) {
            TBDWInstance tBDWInstance = this.mTBDWInstance;
            if (tBDWInstance != null) {
                tBDWInstance.setFrame(i, this.mHeight);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.setFrame(i, this.mHeight);
            }
        }
    }
}
