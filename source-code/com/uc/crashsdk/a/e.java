package com.uc.crashsdk.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.user.open.core.exception.RpcException;
import com.uc.crashsdk.a;
import com.uc.crashsdk.b;
import com.uc.crashsdk.f;
import com.youku.alixplayer.util.PlaybackParamKey;

/* compiled from: Taobao */
public class e implements Runnable {
    static final /* synthetic */ boolean a = true;
    private final int b;
    private final Object[] c;

    public e(int i) {
        this.b = i;
        this.c = null;
    }

    public final boolean a() {
        int i = this.b;
        if (i == 451 || i == 452) {
            return com.uc.crashsdk.e.b(i, this.c);
        }
        switch (i) {
            case 351:
            case 352:
            case 353:
            case PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH /*{ENCODED_INT: 354}*/:
                return h.b(i, this.c);
            default:
                switch (i) {
                    case 751:
                    case 752:
                    case 753:
                    case 754:
                    case 755:
                    case 756:
                        return f.a(i, this.c);
                    default:
                        a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (a) {
                            return false;
                        }
                        throw new AssertionError();
                }
        }
    }

    public void run() {
        int i = this.b;
        if (i == 10) {
            f.a(i, this.c);
        } else if (i == 500) {
            d.a(i);
        } else if (i == 700) {
            f.b(i);
        } else if (i == 800) {
            g.a(i);
        } else if (i == 201 || i == 202) {
            a.a(i);
        } else {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                    b.a(i);
                    return;
                default:
                    switch (i) {
                        case 301:
                        case 302:
                        case 303:
                            h.a(i, this.c);
                            return;
                        default:
                            switch (i) {
                                case 401:
                                case 402:
                                case 403:
                                    break;
                                default:
                                    switch (i) {
                                        case 405:
                                        case 406:
                                        case 407:
                                        case RpcException.ErrorCode.API_UNAUTHORIZED:
                                        case 409:
                                        case 410:
                                        case 411:
                                        case 412:
                                        case 413:
                                        case 414:
                                        case 415:
                                        case TypedValues.Cycle.TYPE_PATH_ROTATE:
                                            break;
                                        default:
                                            a.d("crashsdk", "Unknown async runnable: " + toString());
                                            if (!a) {
                                                throw new AssertionError();
                                            }
                                            return;
                                    }
                            }
                            com.uc.crashsdk.e.a(i, this.c);
                            return;
                    }
            }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.b;
    }

    public e(int i, Object[] objArr) {
        this.b = i;
        this.c = objArr;
    }
}
