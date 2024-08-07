package cn.damai.common.app.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.common.app.widget.DMProgressDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.br;
import tb.ni2;

/* compiled from: Taobao */
public abstract class BaseFragment<T extends a, E extends BaseModel> extends Fragment implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CONMENTS_REQUEST = 5001;
    public static final int FINISH_ACTIVITY = 1000;
    public static final int FINISH_REQUEST = 2000;
    public static final int LOGIN_REQUEST = 3000;
    public static final int ORDER_PAY_ERROR = 1001;
    public static final int TIXING_REQUEST = 6001;
    public static final int VERCODERESULT = 4000;
    private boolean isLazyLoaded = false;
    private boolean isViewCreated = false;
    public br mDMMessage;
    public E mModel;
    public T mPresenter;
    public DMProgressDialog progressDialog;
    protected View rootView;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(BaseFragment baseFragment) {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2021816121")) {
                ipChange.ipc$dispatch("2021816121", new Object[]{this, dialogInterface});
            }
        }
    }

    private void checkLazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1120880291")) {
            ipChange.ipc$dispatch("1120880291", new Object[]{this});
        } else if (!this.isLazyLoaded && this.isViewCreated && getUserVisibleHint()) {
            this.isLazyLoaded = true;
            lazyLoad();
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutResource();

    public abstract void initPresenter();

    /* access modifiers changed from: protected */
    public abstract void initView();

    public boolean isLazyLoaded() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-158524634")) {
            return this.isLazyLoaded;
        }
        return ((Boolean) ipChange.ipc$dispatch("-158524634", new Object[]{this})).booleanValue();
    }

    public boolean isViewCreated() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1756839440")) {
            return this.isViewCreated;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1756839440", new Object[]{this})).booleanValue();
    }

    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476672171")) {
            ipChange.ipc$dispatch("1476672171", new Object[]{this});
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342101382")) {
            return (View) ipChange.ipc$dispatch("-342101382", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(getLayoutResource(), viewGroup, false);
        }
        this.mDMMessage = new br();
        this.mPresenter = (T) ((a) ni2.a(this, 0));
        this.mModel = (E) ((BaseModel) ni2.a(this, 1));
        T t = this.mPresenter;
        if (t != null) {
            t.mContext = getActivity();
            this.mPresenter.setMessageCenter(this.mDMMessage);
        }
        initPresenter();
        initView();
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309612325")) {
            ipChange.ipc$dispatch("309612325", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        this.isLazyLoaded = false;
        super.onDestroyView();
        stopProgressDialog();
        T t = this.mPresenter;
        if (t != null) {
            t.onDestroy();
        }
        br brVar = this.mDMMessage;
        if (brVar != null) {
            brVar.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234106339")) {
            ipChange.ipc$dispatch("1234106339", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        checkLazyLoad();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436490907")) {
            ipChange.ipc$dispatch("436490907", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        checkLazyLoad();
    }

    public void startActivity(Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898537833")) {
            ipChange.ipc$dispatch("1898537833", new Object[]{this, cls});
            return;
        }
        startActivity(cls, (Bundle) null);
    }

    public void startActivityForResult(Class<?> cls, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565721866")) {
            ipChange.ipc$dispatch("-1565721866", new Object[]{this, cls, Integer.valueOf(i)});
            return;
        }
        startActivityForResult(cls, (Bundle) null, i);
    }

    public void startProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005589326")) {
            ipChange.ipc$dispatch("1005589326", new Object[]{this});
        } else if (getActivity() != null && !getActivity().isFinishing()) {
            if (this.progressDialog == null) {
                DMProgressDialog a2 = new DMProgressDialog(getActivity()).a();
                this.progressDialog = a2;
                a2.setOnDismissListener(new a(this));
            }
            if (isAdded() && !this.progressDialog.isShowing()) {
                this.progressDialog.show();
            }
        }
    }

    public void stopProgressDialog() {
        DMProgressDialog dMProgressDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893327986")) {
            ipChange.ipc$dispatch("-893327986", new Object[]{this});
        } else if (getActivity() != null && !getActivity().isFinishing() && (dMProgressDialog = this.progressDialog) != null) {
            dMProgressDialog.dismiss();
            this.progressDialog = null;
        }
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074218187")) {
            ipChange.ipc$dispatch("2074218187", new Object[]{this, cls, bundle});
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060618788")) {
            ipChange.ipc$dispatch("-1060618788", new Object[]{this, cls, bundle, Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, i);
    }
}
