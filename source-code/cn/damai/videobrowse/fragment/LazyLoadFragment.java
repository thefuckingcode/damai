package cn.damai.videobrowse.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class LazyLoadFragment extends Fragment {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final String TAG = "LazyLoadFragment";
    protected boolean isInit = false;
    protected boolean isLoad = false;
    private View view;

    private void isCanLoadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757898779")) {
            ipChange.ipc$dispatch("757898779", new Object[]{this});
        } else if (this.isInit) {
            if (getUserVisibleHint()) {
                lazyLoad();
                this.isLoad = true;
                return;
            }
            stopLoad();
        }
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1669295452")) {
            return (T) getContentView().findViewById(i);
        }
        return (T) ((View) ipChange.ipc$dispatch("1669295452", new Object[]{this, Integer.valueOf(i)}));
    }

    /* access modifiers changed from: protected */
    public View getContentView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1343569395")) {
            return this.view;
        }
        return (View) ipChange.ipc$dispatch("1343569395", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public abstract void lazyLoad();

    /* access modifiers changed from: protected */
    public void onActivityCreated() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918117559")) {
            ipChange.ipc$dispatch("1918117559", new Object[]{this});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539902787")) {
            ipChange.ipc$dispatch("-539902787", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        onActivityCreated();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1192426098")) {
            return (View) ipChange.ipc$dispatch("-1192426098", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        View inflate = layoutInflater.inflate(setContentView(), viewGroup, false);
        this.view = inflate;
        this.isInit = true;
        onCreateView(inflate);
        return this.view;
    }

    /* access modifiers changed from: protected */
    public void onCreateView(View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506171321")) {
            ipChange.ipc$dispatch("1506171321", new Object[]{this, view2});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24285807")) {
            ipChange.ipc$dispatch("-24285807", new Object[]{this});
            return;
        }
        super.onDestroyView();
        this.isInit = false;
        this.isLoad = false;
    }

    /* access modifiers changed from: protected */
    public abstract int setContentView();

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460320775")) {
            ipChange.ipc$dispatch("460320775", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        isCanLoadData();
    }

    /* access modifiers changed from: protected */
    public void showToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-668205423")) {
            ipChange.ipc$dispatch("-668205423", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            Toast.makeText(getContext(), str, 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void stopLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705542257")) {
            ipChange.ipc$dispatch("705542257", new Object[]{this});
        }
    }
}
