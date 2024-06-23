package com.youku.live.dago.liveplayback.widget.plugins;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public final class PluginAnimationUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int duration = 300;

    /* compiled from: Taobao */
    public interface AnimationActionListener {
        void onAnimationEnd();
    }

    private PluginAnimationUtils() {
    }

    public static int getDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951517487")) {
            return ((Integer) ipChange.ipc$dispatch("-951517487", new Object[0])).intValue();
        }
        return 300;
    }

    public static void pluginBottomHide(View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877667480")) {
            ipChange.ipc$dispatch("-877667480", new Object[]{view, animationActionListener});
        } else if (view.getParent() != null) {
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, (float) ((ViewGroup) view.getParent()).getHeight()).setDuration(300L);
            if (animationActionListener != null) {
                duration2.addListener(new Animator.AnimatorListener() {
                    /* class com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationCancel(Animator animator) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1246403207")) {
                            ipChange.ipc$dispatch("-1246403207", new Object[]{this, animator});
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-638750634")) {
                            ipChange.ipc$dispatch("-638750634", new Object[]{this, animator});
                            return;
                        }
                        animationActionListener.onAnimationEnd();
                    }

                    public void onAnimationRepeat(Animator animator) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1067172408")) {
                            ipChange.ipc$dispatch("1067172408", new Object[]{this, animator});
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1103437777")) {
                            ipChange.ipc$dispatch("-1103437777", new Object[]{this, animator});
                        }
                    }
                });
            }
            duration2.start();
        }
    }

    public static void pluginBottomShow(View view, final AnimationActionListener animationActionListener, float... fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518555310")) {
            ipChange.ipc$dispatch("1518555310", new Object[]{view, animationActionListener, fArr});
            return;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, fArr).setDuration(300L);
        if (animationActionListener != null) {
            duration2.addListener(new Animator.AnimatorListener() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-477233192")) {
                        ipChange.ipc$dispatch("-477233192", new Object[]{this, animator});
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-646509993")) {
                        ipChange.ipc$dispatch("-646509993", new Object[]{this, animator});
                        return;
                    }
                    animationActionListener.onAnimationEnd();
                }

                public void onAnimationRepeat(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1836342423")) {
                        ipChange.ipc$dispatch("1836342423", new Object[]{this, animator});
                    }
                }

                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "29752816")) {
                        ipChange.ipc$dispatch("29752816", new Object[]{this, animator});
                    }
                }
            });
        }
        duration2.start();
    }

    public static void pluginTopHide(View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245310790")) {
            ipChange.ipc$dispatch("245310790", new Object[]{view, animationActionListener});
            return;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, (float) (-view.getHeight())).setDuration(300L);
        if (animationActionListener != null) {
            duration2.addListener(new Animator.AnimatorListener() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "291936823")) {
                        ipChange.ipc$dispatch("291936823", new Object[]{this, animator});
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-654269352")) {
                        ipChange.ipc$dispatch("-654269352", new Object[]{this, animator});
                        return;
                    }
                    animationActionListener.onAnimationEnd();
                }

                public void onAnimationRepeat(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1689454858")) {
                        ipChange.ipc$dispatch("-1689454858", new Object[]{this, animator});
                    }
                }

                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1162943409")) {
                        ipChange.ipc$dispatch("1162943409", new Object[]{this, animator});
                    }
                }
            });
        }
        duration2.start();
    }

    public static void pluginTopShow(View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-689966207")) {
            ipChange.ipc$dispatch("-689966207", new Object[]{view, animationActionListener});
            return;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, 0.0f).setDuration(300L);
        if (animationActionListener != null) {
            duration2.addListener(new Animator.AnimatorListener() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1061106838")) {
                        ipChange.ipc$dispatch("1061106838", new Object[]{this, animator});
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-662028711")) {
                        ipChange.ipc$dispatch("-662028711", new Object[]{this, animator});
                        return;
                    }
                    animationActionListener.onAnimationEnd();
                }

                public void onAnimationRepeat(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-920284843")) {
                        ipChange.ipc$dispatch("-920284843", new Object[]{this, animator});
                    }
                }

                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1998833294")) {
                        ipChange.ipc$dispatch("-1998833294", new Object[]{this, animator});
                    }
                }
            });
        }
        duration2.start();
    }
}
