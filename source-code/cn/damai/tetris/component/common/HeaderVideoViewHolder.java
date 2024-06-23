package cn.damai.tetris.component.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.home.adapter.HeaderVideoAdapter;
import cn.damai.tetris.component.home.bean.ArtistHeadBean;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.component.home.viewholder.VideoViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;
import tb.mv2;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class HeaderVideoViewHolder extends VideoViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    ObjectAnimator animator2 = new ObjectAnimator();
    ObjectAnimator animatorUser = new ObjectAnimator();
    int userIndex = 1;

    /* compiled from: Taobao */
    public class a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a = false;
        final /* synthetic */ List b;

        a(List list) {
            this.b = list;
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-566923554")) {
                ipChange.ipc$dispatch("-566923554", new Object[]{this, animator});
                return;
            }
            this.a = true;
            Log.d("animationx", " ===== 1 cancel : " + this.a);
            ObjectAnimator objectAnimator = HeaderVideoViewHolder.this.animator2;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-253794031")) {
                ipChange.ipc$dispatch("-253794031", new Object[]{this, animator});
                return;
            }
            Log.d("animationx", " ===== 1 end : " + this.a);
            if (!this.a) {
                ArtistHeadBean artistHeadBean = (ArtistHeadBean) f92.b(this.b, HeaderVideoViewHolder.this.userIndex);
                if (artistHeadBean != null) {
                    ((TextView) ((VideoViewHolder) HeaderVideoViewHolder.this).userAvatar.findViewById(R$id.user_head_single_name)).setText(artistHeadBean.name);
                    HeaderVideoViewHolder headerVideoViewHolder = HeaderVideoViewHolder.this;
                    headerVideoViewHolder.loadHead(artistHeadBean.headPic, (ImageView) ((VideoViewHolder) headerVideoViewHolder).userAvatar.findViewById(R$id.user_head_single)).f();
                }
                HeaderVideoViewHolder headerVideoViewHolder2 = HeaderVideoViewHolder.this;
                int i = headerVideoViewHolder2.userIndex + 1;
                headerVideoViewHolder2.userIndex = i;
                if (i >= this.b.size()) {
                    HeaderVideoViewHolder.this.userIndex = 0;
                }
                HeaderVideoViewHolder.this.animator2.start();
            }
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1746652061")) {
                ipChange.ipc$dispatch("1746652061", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-527329750")) {
                ipChange.ipc$dispatch("-527329750", new Object[]{this, animator});
                return;
            }
            this.a = false;
            Log.d("animationx", " ===== 1 start : " + this.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a = false;

        b() {
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "202246461")) {
                ipChange.ipc$dispatch("202246461", new Object[]{this, animator});
                return;
            }
            this.a = true;
            Log.d("animationx", " ===== 2 cancel : ");
            HeaderVideoViewHolder.this.animatorUser.cancel();
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-261553390")) {
                ipChange.ipc$dispatch("-261553390", new Object[]{this, animator});
                return;
            }
            Log.d("animationx", " ===== 2 end : " + this.a);
            if (!this.a) {
                HeaderVideoViewHolder.this.animatorUser.setStartDelay(3000);
                HeaderVideoViewHolder.this.animatorUser.start();
            }
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1779145220")) {
                ipChange.ipc$dispatch("-1779145220", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "605860843")) {
                ipChange.ipc$dispatch("605860843", new Object[]{this, animator});
                return;
            }
            this.a = false;
            Log.d("animationx", " ===== 2 start : " + this.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        c(HeaderVideoViewHolder headerVideoViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "193376675")) {
                ipChange.ipc$dispatch("193376675", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    public HeaderVideoViewHolder(View view) {
        super(view);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DMImageCreator loadHead(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844676403")) {
            return (DMImageCreator) ipChange.ipc$dispatch("844676403", new Object[]{this, str, imageView});
        }
        int a2 = n42.a(xs0.a(), 35.0f);
        imageView.setImageBitmap(null);
        return cn.damai.common.image.a.b().f(str, a2, a2).n(new c(this, imageView));
    }

    private void rotateOnYCoordinate(View view, List<ArtistHeadBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638220499")) {
            ipChange.ipc$dispatch("-1638220499", new Object[]{this, view, list});
            return;
        }
        Log.d("animationx", " ===== rotateOnYCoordinate : " + this.mIndex);
        ObjectAnimator objectAnimator = this.animatorUser;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.animator2.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotationY", 0.0f, 90.0f);
        this.animatorUser = ofFloat;
        ofFloat.setDuration(500L);
        this.animatorUser.addListener(new a(list));
        this.animatorUser.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotationY", -90.0f, 0.0f);
        this.animator2 = ofFloat2;
        ofFloat2.setDuration(500L);
        this.animator2.addListener(new b());
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder
    public void fixVideoHeight() {
        View findViewById;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1258182800")) {
            ipChange.ipc$dispatch("1258182800", new Object[]{this});
            return;
        }
        int a2 = (n42.a(xs0.a(), 270.0f) - mv2.c()) - n42.a(xs0.a(), 9.0f);
        if (a2 >= 0) {
            i = a2;
        }
        View view = this.itemView;
        if (view != null && (findViewById = view.findViewById(R$id.homepage_video_cover)) != null && findViewById.getLayoutParams() != null) {
            findViewById.getLayoutParams().height = i;
            findViewById.requestLayout();
        }
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder
    public void getVideoAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130720003")) {
            ipChange.ipc$dispatch("2130720003", new Object[]{this});
            return;
        }
        this.mAdapter = new HeaderVideoAdapter();
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder
    public void initUserHeaderPic(HomePageVideoBean.HomePageVideoItem homePageVideoItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1670819353")) {
            ipChange.ipc$dispatch("1670819353", new Object[]{this, homePageVideoItem});
        } else if (this.userAvatar != null && homePageVideoItem != null) {
            List<ArtistHeadBean> list = homePageVideoItem.artistVOS;
            ArtistHeadBean artistHeadBean = (ArtistHeadBean) f92.b(list, 0);
            if (artistHeadBean != null) {
                this.userAvatar.setVisibility(0);
                this.userAvatar.setClickable(true);
                ((TextView) this.userAvatar.findViewById(R$id.user_head_single_name)).setText(artistHeadBean.name);
                loadHead(artistHeadBean.headPic, (ImageView) this.userAvatar.findViewById(R$id.user_head_single)).f();
                if (list.size() > 1) {
                    this.userIndex = 1;
                    rotateOnYCoordinate(this.userAvatar, list);
                    return;
                }
                this.userAvatar.setVisibility(8);
                ObjectAnimator objectAnimator = this.animatorUser;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                    this.animator2.cancel();
                }
                this.userAvatar.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.userAvatar, "rotationY", 0.0f);
                ofFloat.setDuration(1L);
                ofFloat.start();
                return;
            }
            this.userAvatar.setVisibility(8);
            ObjectAnimator objectAnimator2 = this.animatorUser;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
                this.animator2.cancel();
            }
        }
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder, cn.damai.tetris.mvp.CommonViewHolder
    public void setMessage(int i, Object obj) {
        ObjectAnimator objectAnimator;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882670937")) {
            ipChange.ipc$dispatch("-882670937", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        super.setMessage(i, obj);
        if (i == 11004 && (objectAnimator = this.animatorUser) != null) {
            objectAnimator.cancel();
            this.animator2.cancel();
        }
    }
}
