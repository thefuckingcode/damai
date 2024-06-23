package tb;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.alibaba.pictures.moimage.MoImageLoadException;
import com.alibaba.pictures.moimage.MoImageView;
import com.alibaba.pictures.moimage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wp1;

/* compiled from: Taobao */
public class xp1<T extends wp1> implements IPhenixListener<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ObjectAnimator a;
    private WeakReference<ImageView> b;
    private String c;
    @Nullable
    private final ImageView d;
    @Nullable
    private final pe1 e;
    @Nullable
    private final MoImageView.SimpleRequestListener f;
    @Nullable
    private final String g;

    public xp1(@Nullable ImageView imageView, @Nullable pe1 pe1, @Nullable MoImageView.SimpleRequestListener simpleRequestListener, @Nullable String str) {
        this.d = imageView;
        this.e = pe1;
        this.f = simpleRequestListener;
        this.g = str;
        this.b = new WeakReference<>(imageView);
        this.c = pe1 != null ? pe1.l() : null;
    }

    public boolean a(@NotNull ug2 ug2, boolean z) {
        ImageView imageView;
        pe1 pe1;
        Bitmap bitmap;
        pe1 pe12;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-95022333")) {
            return ((Boolean) ipChange.ipc$dispatch("-95022333", new Object[]{this, ug2, Boolean.valueOf(z)})).booleanValue();
        }
        k21.i(ug2, "event");
        me1 me1 = me1.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("PhenixImageViewTarget:applySuccessEvent: ");
        sb.append(this.g);
        sb.append(" ,viewState-w-h=");
        pe1 pe13 = this.e;
        ObjectAnimator objectAnimator = null;
        sb.append(pe13 != null ? Integer.valueOf(pe13.d()) : null);
        sb.append('-');
        pe1 pe14 = this.e;
        sb.append(pe14 != null ? Integer.valueOf(pe14.c()) : null);
        sb.append(",view-w-h=");
        ImageView imageView2 = this.d;
        sb.append(imageView2 != null ? Integer.valueOf(imageView2.getWidth()) : null);
        sb.append('-');
        ImageView imageView3 = this.d;
        sb.append(imageView3 != null ? Integer.valueOf(imageView3.getHeight()) : null);
        me1.a(sb.toString());
        WeakReference<ImageView> weakReference = this.b;
        if (!(weakReference == null || (imageView = weakReference.get()) == null)) {
            pe1 pe15 = this.e;
            if (!(pe15 == null || pe15.p() == 0)) {
                imageView.setBackground(null);
            }
            Object tag = imageView.getTag(R$id.moimage_target_uri);
            if (!(tag instanceof String)) {
                tag = null;
            }
            String str = (String) tag;
            String str2 = ug2.b() + this.c;
            if (str2 == null || str == null || !(!k21.d(str2, str))) {
                BitmapDrawable f2 = ug2.f();
                if (f2 == null || f2.getIntrinsicHeight() != 1 || f2.getIntrinsicWidth() != 1 || (pe12 = this.e) == null || !pe12.o() || this.e.n() == 0) {
                    MoImageView.SimpleRequestListener simpleRequestListener = this.f;
                    if (simpleRequestListener != null) {
                        if (f2 == null || (bitmap = f2.getBitmap()) == null) {
                            bitmap = f2;
                        }
                        if (simpleRequestListener.onResourceReady(bitmap, this.g)) {
                            me1.e("PhenixImageViewTarget:applySuccessEvent:cusRequestListener return true,finish progress " + this.g);
                            return true;
                        }
                    }
                    if (f2 != null) {
                        pe1 pe16 = this.e;
                        if (k21.d(pe16 != null ? pe16.f() : null, Boolean.TRUE)) {
                            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) (!(f2 instanceof AnimatedImageDrawable) ? null : f2);
                            if (animatedImageDrawable != null) {
                                animatedImageDrawable.x();
                            }
                        }
                        if (ne1.INSTANCE.b() || (pe1 = this.e) == null || pe1.g() <= 0) {
                            z2 = true;
                        }
                        if (z2) {
                            imageView.setImageDrawable(f2);
                        } else {
                            ObjectAnimator objectAnimator2 = this.a;
                            if (objectAnimator2 == null) {
                                ObjectAnimator ofInt = ObjectAnimator.ofInt(imageView, "alpha", 0, 255);
                                if (ofInt != null) {
                                    ofInt.setInterpolator(new AccelerateInterpolator());
                                    pe1 pe17 = this.e;
                                    ofInt.setDuration(pe17 != null ? (long) pe17.g() : 300);
                                    ur2 ur2 = ur2.INSTANCE;
                                    objectAnimator = ofInt;
                                }
                                this.a = objectAnimator;
                                if (objectAnimator != null) {
                                    objectAnimator.start();
                                }
                            } else if (objectAnimator2 != null) {
                                if (!objectAnimator2.isRunning()) {
                                    objectAnimator = objectAnimator2;
                                }
                                if (objectAnimator != null) {
                                    objectAnimator.start();
                                }
                            }
                            imageView.setImageDrawable(f2);
                        }
                        return true;
                    }
                    me1.f("PhenixImageViewTarget", "resultDrawable=null,callbackUrlFeature=" + str2 + ", target=" + this.g);
                } else {
                    ImageView imageView4 = this.d;
                    if (imageView4 != null) {
                        imageView4.setImageResource(this.e.n());
                    }
                    return true;
                }
            } else {
                me1.e("PhenixImageViewTarget:applySuccessEvent:callback url not match target url, callbackUrlFeature=" + str2 + ", currentViewTargetPathFeature=" + str);
                return true;
            }
        }
        return false;
    }

    @Override // com.taobao.phenix.intf.event.IPhenixListener
    public boolean onHappen(@Nullable T t) {
        ImageView imageView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081556223")) {
            return ((Boolean) ipChange.ipc$dispatch("-2081556223", new Object[]{this, t})).booleanValue();
        }
        WeakReference<ImageView> weakReference = this.b;
        if (!(weakReference == null || (imageView = weakReference.get()) == null)) {
            if (t instanceof qg0) {
                me1 me1 = me1.INSTANCE;
                me1.a("PhenixImageViewTarget:onHappen-FailPhenixEvent: " + this.g);
                MoImageLoadException moImageLoadException = new MoImageLoadException("phenix load url fail");
                moImageLoadException.setTag(t);
                MoImageView.SimpleRequestListener simpleRequestListener = this.f;
                if (simpleRequestListener != null && simpleRequestListener.onLoadFailed(moImageLoadException, this.g)) {
                    return true;
                }
                pe1 pe1 = this.e;
                if (!(pe1 == null || pe1.p() == 0)) {
                    imageView.setBackground(null);
                }
                pe1 pe12 = this.e;
                if (!(pe12 == null || pe12.n() == 0)) {
                    if (imageView instanceof MoImageView) {
                        ((MoImageView) imageView).setLocalDrawable(Integer.valueOf(this.e.n()));
                    } else {
                        imageView.setImageResource(this.e.n());
                    }
                }
                return true;
            } else if (t instanceof fc1) {
                me1.INSTANCE.a("PhenixImageViewTarget:onHappen-cacheMiss");
                return false;
            } else if (t instanceof ug2) {
                ug2 ug2 = (ug2) t;
                return a(ug2, ug2.h());
            }
        }
        return false;
    }
}
