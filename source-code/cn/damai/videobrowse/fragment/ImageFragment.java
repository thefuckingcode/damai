package cn.damai.videobrowse.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.view.photoview.PhotoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.zq;

/* compiled from: Taobao */
public class ImageFragment extends LazyLoadFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnImageLongClickListener mOnImageLongClickListener;
    private String mPicUrl;

    /* compiled from: Taobao */
    public interface OnImageLongClickListener {
        void onImageLongClick(String str);
    }

    /* compiled from: Taobao */
    public class a implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public boolean onLongClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-871492044")) {
                return ((Boolean) ipChange.ipc$dispatch("-871492044", new Object[]{this, view})).booleanValue();
            }
            if (ImageFragment.this.mOnImageLongClickListener != null) {
                ImageFragment.this.mOnImageLongClickListener.onImageLongClick(ImageFragment.this.mPicUrl);
            }
            return true;
        }
    }

    public static ImageFragment getInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695503707")) {
            return (ImageFragment) ipChange.ipc$dispatch("1695503707", new Object[]{str});
        }
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("picUrl", str);
        }
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206001644")) {
            ipChange.ipc$dispatch("-1206001644", new Object[]{this});
        }
    }

    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-112643438")) {
            ipChange.ipc$dispatch("-112643438", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792385090")) {
            ipChange.ipc$dispatch("-792385090", new Object[]{this, context});
            return;
        }
        super.onAttach(context);
        try {
            this.mOnImageLongClickListener = (OnImageLongClickListener) context;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1544097087")) {
            ipChange.ipc$dispatch("-1544097087", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mPicUrl = arguments.getString("picUrl");
        }
    }

    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580151331")) {
            return (View) ipChange.ipc$dispatch("1580151331", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        View inflate = layoutInflater.inflate(R$layout.image_browse_item_layout, viewGroup, false);
        PhotoView photoView = (PhotoView) inflate.findViewById(R$id.poster);
        photoView.setOnLongClickListener(new a());
        if (photoView.getTag() instanceof zq) {
            ((zq) photoView.getTag()).cancel();
        }
        DMImageCreator c = cn.damai.common.image.a.b().c(this.mPicUrl);
        int i = R$drawable.damai_image_defalut;
        photoView.setTag(c.i(i).c(i).g(photoView));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821507519")) {
            ipChange.ipc$dispatch("-821507519", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897448379")) {
            ipChange.ipc$dispatch("-1897448379", new Object[]{this});
            return;
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338538398")) {
            ipChange.ipc$dispatch("-1338538398", new Object[]{this});
            return;
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155399443")) {
            ipChange.ipc$dispatch("-1155399443", new Object[]{this});
            return;
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    public int setContentView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1196313477")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1196313477", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    public void stopLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436809786")) {
            ipChange.ipc$dispatch("-436809786", new Object[]{this});
            return;
        }
        super.stopLoad();
    }
}
