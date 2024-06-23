package com.youku.alixplayer.state;

import android.text.TextUtils;
import android.util.Log;
import com.youku.alixplayer.EventType;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.IPeriod;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.instances.PlayerQueue;
import com.youku.alixplayer.model.Playlist;
import com.youku.media.arch.instruments.ConfigFetcher;

/* compiled from: Taobao */
public class PlayerStateMachine implements IMediaSource.OnMediaSourceUpdatedListener {
    private static final String TAG = "PlayerStateMachine";
    private Aliplayer mAliplayer;
    private IState mCurrentState = this.mStateIdle;
    private PlayerQueue mPlayerQueue;
    private Playlist mPlaylist;
    private OnStateChangeListener mStateChangeListener;
    private StateError mStateError = new StateError();
    private StateIdle mStateIdle = new StateIdle();
    private StateMidAdPaused mStateMidAdPaused = new StateMidAdPaused();
    private StateMidAdStarted mStateMidAdStarted = new StateMidAdStarted();
    private StatePostAdCompleted mStatePostAdCompleted = new StatePostAdCompleted();
    private StatePostAdPaused mStatePostAdPaused = new StatePostAdPaused();
    private StatePostAdStarted mStatePostAdStarted = new StatePostAdStarted();
    private StatePreAdPaused mStatePreAdPaused = new StatePreAdPaused();
    private StatePreAdStarted mStatePreAdStarted = new StatePreAdStarted();
    private StatePreVipPaused mStatePreVipPaused = new StatePreVipPaused();
    private StatePreVipStarted mStatePreVipStarted = new StatePreVipStarted();
    private StatePrepared mStatePrepared = new StatePrepared();
    private StatePreparing mStatePreparing = new StatePreparing();
    private StateReleased mStateReleased = new StateReleased();
    private StateSourceFailed mStateSourceFailed = new StateSourceFailed();
    private StateSourceGeting mStateSourceGetting = new StateSourceGeting();
    private StateSourceReady mStateSourceReady = new StateSourceReady();
    private StateStarting mStateStarting = new StateStarting();
    private StateStopped mStateStopped = new StateStopped();
    private StateVideoCompleted mStateVideoCompleted = new StateVideoCompleted();
    private StateVideoPaused mStateVideoPaused = new StateVideoPaused();
    private StateVideoStarted mStateVideoStarted = new StateVideoStarted();

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.alixplayer.state.PlayerStateMachine$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$EventType;
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$IAlixPlayer$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(77:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(79:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(81:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(82:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(83:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(85:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|(3:107|108|110)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(87:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110) */
        /* JADX WARNING: Can't wrap try/catch for region: R(88:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110) */
        /* JADX WARNING: Can't wrap try/catch for region: R(90:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110) */
        /* JADX WARNING: Can't wrap try/catch for region: R(92:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110) */
        /* JADX WARNING: Can't wrap try/catch for region: R(93:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0179 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x0183 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x018d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0199 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x010b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0115 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x011f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0129 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0133 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x013d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0147 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0151 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x015b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0165 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x016f */
        static {
            int[] iArr = new int[IAlixPlayer.State.values().length];
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State = iArr;
            try {
                iArr[IAlixPlayer.State.STATE_STARTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_AD_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_RELEASED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_SOURCE_GETTING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_SOURCE_READY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PREPARING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_PAUSED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_AD_PAUSED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_VIP_PAUSED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_MID_AD_PAUSED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_POST_AD_PAUSED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_STARTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_VIP_STARTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_MID_AD_STARTED.ordinal()] = 17;
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_POST_AD_STARTED.ordinal()] = 18;
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_COMPLETED.ordinal()] = 19;
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_SOURCE_FAILED.ordinal()] = 20;
            int[] iArr2 = new int[EventType.values().length];
            $SwitchMap$com$youku$alixplayer$EventType = iArr2;
            iArr2[EventType.SET_DATASOURCE.ordinal()] = 1;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_INFO_READY.ordinal()] = 2;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_INFO_FAILED.ordinal()] = 3;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.PREPARE.ordinal()] = 4;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.START.ordinal()] = 5;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_VIDEO_START.ordinal()] = 6;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_PRE_AD_START.ordinal()] = 7;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_PRE_VIP_START.ordinal()] = 8;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_MID_AD_START.ordinal()] = 9;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_POST_AD_START.ordinal()] = 10;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_VIDEO_COMPLETION.ordinal()] = 11;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_POST_AD_COMPLETION.ordinal()] = 12;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_ERROR.ordinal()] = 13;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.PAUSE.ordinal()] = 14;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.RELEASE.ordinal()] = 15;
            $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_PREPARED.ordinal()] = 16;
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.STOP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private void handleOnError(IAlixPlayer.State state) {
        this.mCurrentState.outerAction();
        StateError stateError = this.mStateError;
        this.mCurrentState = stateError;
        stateError.enterAction(state);
    }

    private void handleOnMidAdStart(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] == 15) {
            this.mCurrentState.outerAction();
            StateMidAdStarted stateMidAdStarted = this.mStateMidAdStarted;
            this.mCurrentState = stateMidAdStarted;
            stateMidAdStarted.enterAction(state);
        }
    }

    private void handleOnPostAdCompleted(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] == 18) {
            this.mCurrentState.outerAction();
            StatePostAdCompleted statePostAdCompleted = this.mStatePostAdCompleted;
            this.mCurrentState = statePostAdCompleted;
            statePostAdCompleted.enterAction(state);
        }
    }

    private void handleOnPostAdStart(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] == 19) {
            this.mCurrentState.outerAction();
            StatePostAdStarted statePostAdStarted = this.mStatePostAdStarted;
            this.mCurrentState = statePostAdStarted;
            statePostAdStarted.enterAction(state);
        }
    }

    private void handleOnPreAdStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 16) {
            this.mCurrentState.outerAction();
            StatePreAdStarted statePreAdStarted = this.mStatePreAdStarted;
            this.mCurrentState = statePreAdStarted;
            statePreAdStarted.enterAction(state);
        }
    }

    private void handleOnPrepared(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] == 9) {
            this.mCurrentState.outerAction();
            StatePrepared statePrepared = this.mStatePrepared;
            this.mCurrentState = statePrepared;
            statePrepared.enterAction(state);
        }
    }

    private void handleOnSourceFailed(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] == 7) {
            this.mCurrentState.outerAction();
            StateSourceFailed stateSourceFailed = this.mStateSourceFailed;
            this.mCurrentState = stateSourceFailed;
            stateSourceFailed.enterAction(state);
        }
    }

    private void handleOnSourceReady(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] == 7) {
            Log.d(TAG, "handleOnSourceReady");
            this.mCurrentState.outerAction();
            StateSourceReady stateSourceReady = this.mStateSourceReady;
            this.mCurrentState = stateSourceReady;
            stateSourceReady.enterAction(state);
        }
    }

    private void handleOnVideoCompleted(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] == 15) {
            this.mCurrentState.outerAction();
            StateVideoCompleted stateVideoCompleted = this.mStateVideoCompleted;
            this.mCurrentState = stateVideoCompleted;
            stateVideoCompleted.enterAction(state);
        }
    }

    private void handleOnVideoStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 16 || i == 17) {
            this.mCurrentState.outerAction();
            StateVideoStarted stateVideoStarted = this.mStateVideoStarted;
            this.mCurrentState = stateVideoStarted;
            stateVideoStarted.enterAction(state);
        }
    }

    private void handlePause(IAlixPlayer.State state) {
        IState iState;
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 3) {
            switch (i) {
                case 15:
                    this.mCurrentState.outerAction();
                    iState = this.mStateVideoPaused;
                    break;
                case 16:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePreVipPaused;
                    break;
                case 17:
                    this.mCurrentState.outerAction();
                    iState = this.mStateMidAdPaused;
                    break;
                case 18:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePostAdPaused;
                    break;
                default:
                    return;
            }
        } else {
            this.mCurrentState.outerAction();
            iState = this.mStatePreAdPaused;
        }
        this.mCurrentState = iState;
        iState.enterAction(state);
    }

    private void handlePreVipStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.mCurrentState.outerAction();
            StatePreVipStarted statePreVipStarted = this.mStatePreVipStarted;
            this.mCurrentState = statePreVipStarted;
            statePreVipStarted.enterAction(state);
        }
    }

    private void handlePrepare(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 5 || i == 8) {
            this.mCurrentState.outerAction();
            this.mCurrentState = this.mStatePreparing;
            PlayerQueue playerQueue = this.mPlayerQueue;
            if (playerQueue == null || playerQueue.getActiveItem() == null || this.mPlayerQueue.getActiveItem().isOnprepared()) {
                this.mStateChangeListener.onStateChange(IAlixPlayer.State.STATE_SOURCE_READY, IAlixPlayer.State.STATE_PREPARING);
                handleEvent(EventType.ON_PREPARED);
                return;
            }
            this.mCurrentState.enterAction(state);
        }
    }

    private void handleRelease(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 4 || i == 7 || i == 20) {
            String config = ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_sourcegetting_handle_stop", "1");
            if (!TextUtils.isEmpty(config) && "1".equals(config)) {
                this.mCurrentState = this.mStateReleased;
                return;
            }
            return;
        }
        this.mCurrentState.outerAction();
        StateReleased stateReleased = this.mStateReleased;
        this.mCurrentState = stateReleased;
        stateReleased.enterAction(state);
    }

    private void handleSetDataSource(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 4 || i == 5 || i == 6) {
            this.mCurrentState.outerAction();
            StateSourceGeting stateSourceGeting = this.mStateSourceGetting;
            this.mCurrentState = stateSourceGeting;
            stateSourceGeting.enterAction(state);
        }
    }

    private void handleStart(IAlixPlayer.State state) {
        IState iState;
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 2) {
            switch (i) {
                case 10:
                    this.mCurrentState.outerAction();
                    iState = this.mStateVideoStarted;
                    break;
                case 11:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePreAdStarted;
                    break;
                case 12:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePreVipStarted;
                    break;
                case 13:
                    this.mCurrentState.outerAction();
                    iState = this.mStateMidAdStarted;
                    break;
                case 14:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePostAdStarted;
                    break;
                default:
                    return;
            }
        } else {
            this.mCurrentState.outerAction();
            iState = this.mStateStarting;
        }
        this.mCurrentState = iState;
        iState.enterAction(state);
    }

    private void handleStop(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 4 || i == 7 || i == 20) {
            String config = ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_sourcegetting_handle_stop", "1");
            if (!TextUtils.isEmpty(config) && "1".equals(config)) {
                this.mCurrentState = this.mStateStopped;
                return;
            }
            return;
        }
        this.mCurrentState.outerAction();
        StateStopped stateStopped = this.mStateStopped;
        this.mCurrentState = stateStopped;
        stateStopped.enterAction(state);
    }

    public IAlixPlayer.State getCurrentState() {
        return this.mCurrentState.getState();
    }

    public Playlist getPlaylist() {
        return this.mPlaylist;
    }

    public void handleEvent(EventType eventType) {
        IAlixPlayer.State state = this.mCurrentState.getState();
        switch (AnonymousClass1.$SwitchMap$com$youku$alixplayer$EventType[eventType.ordinal()]) {
            case 1:
                handleSetDataSource(state);
                break;
            case 2:
                handleOnSourceReady(state);
                break;
            case 3:
                handleOnSourceFailed(state);
                break;
            case 4:
                handlePrepare(state);
                break;
            case 5:
                handleStart(state);
                break;
            case 6:
                handleOnVideoStart(state);
                break;
            case 7:
                handleOnPreAdStart(state);
                break;
            case 8:
                handlePreVipStart(state);
                break;
            case 9:
                handleOnMidAdStart(state);
                break;
            case 10:
                handleOnPostAdStart(state);
                break;
            case 11:
                handleOnVideoCompleted(state);
                break;
            case 12:
                handleOnPostAdCompleted(state);
                break;
            case 13:
                handleOnError(state);
                break;
            case 14:
                handlePause(state);
                break;
            case 15:
                handleRelease(state);
                break;
            case 16:
                handleOnPrepared(state);
                break;
            case 17:
                handleStop(state);
                break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleEvent: event=");
        sb.append(eventType);
        sb.append(",AliPlayer:");
        Aliplayer aliplayer = this.mAliplayer;
        sb.append(aliplayer != null ? aliplayer.toString() : "null");
        sb.append(" SourceState=");
        sb.append(state);
        sb.append(", DestState=");
        sb.append(this.mCurrentState.getState());
        Log.d(TAG, sb.toString());
        if (this.mStateChangeListener != null && this.mCurrentState.getState() != state) {
            this.mStateChangeListener.onStateChange(state, this.mCurrentState.getState());
        }
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPeriodUpdate(int i, IPeriod iPeriod) {
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPlaylistFailed() {
        handleEvent(EventType.ON_INFO_FAILED);
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPlaylistPrepared(IMediaSource iMediaSource, IPlaylist iPlaylist) {
        Log.d(TAG, "onPlaylistPrepared");
        Playlist playlist = (Playlist) iPlaylist;
        this.mPlaylist = playlist;
        this.mStateSourceReady.setPlaylist(playlist);
        if (this.mPlayerQueue.get(iMediaSource.getSourceKey()) == null || !this.mPlayerQueue.get(iMediaSource.getSourceKey()).isOnprepared()) {
            handleEvent(EventType.ON_INFO_READY);
            return;
        }
        iMediaSource.deinit();
        Log.d(TAG, "onPlaylistPrepared: hit preload-aliplayer send source ready");
        this.mCurrentState = this.mStateSourceReady;
        this.mStateChangeListener.onStateChange(IAlixPlayer.State.STATE_SOURCE_GETTING, IAlixPlayer.State.STATE_SOURCE_READY);
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPlaylistUpdate(IPlaylist iPlaylist) {
    }

    public void setAliplayer(Aliplayer aliplayer) {
        this.mAliplayer = aliplayer;
        this.mStateSourceReady.setAliplayer(aliplayer);
        this.mStatePreparing.setAliplayer(aliplayer);
        this.mStateStarting.setAliplayer(aliplayer);
        this.mStateVideoStarted.setAliplayer(aliplayer);
        this.mStatePreVipStarted.setAliplayer(aliplayer);
        this.mStatePreVipPaused.setAliplayer(aliplayer);
        this.mStateVideoPaused.setAliplayer(aliplayer);
        this.mStatePreAdStarted.setAliplayer(aliplayer);
        this.mStatePreAdPaused.setAliplayer(aliplayer);
        this.mStateMidAdStarted.setAliplayer(aliplayer);
        this.mStateMidAdPaused.setAliplayer(aliplayer);
        this.mStatePostAdStarted.setAliplayer(aliplayer);
        this.mStatePostAdPaused.setAliplayer(aliplayer);
        this.mStateReleased.setAliplayer(aliplayer);
        this.mStateStopped.setAliplayer(aliplayer);
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mStateChangeListener = onStateChangeListener;
    }

    public void setPlayerQueue(PlayerQueue playerQueue) {
        this.mPlayerQueue = playerQueue;
    }
}
