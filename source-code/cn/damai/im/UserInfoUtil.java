package cn.damai.im;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.model.UserVipBean;
import cn.damai.im.request.PersonalInfoRequest;
import cn.damai.login.LoginManager;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.gr;
import tb.xs0;

/* compiled from: Taobao */
public class UserInfoUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String USER_VIP_PREFIX = "user_vip_info_prefix";

    /* compiled from: Taobao */
    public interface OnUserInfoListener {
        void onFailed(String str, String str2);

        void onSuccess(UserData userData);
    }

    /* compiled from: Taobao */
    public static class PersonalInfoResult implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<PersonalInfoResult> CREATOR = new a();
        private String result;

        /* compiled from: Taobao */
        public class a implements Parcelable.Creator<PersonalInfoResult> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            /* renamed from: a */
            public PersonalInfoResult createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "193090747")) {
                    return new PersonalInfoResult(parcel);
                }
                return (PersonalInfoResult) ipChange.ipc$dispatch("193090747", new Object[]{this, parcel});
            }

            /* renamed from: b */
            public PersonalInfoResult[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-737924144")) {
                    return new PersonalInfoResult[i];
                }
                return (PersonalInfoResult[]) ipChange.ipc$dispatch("-737924144", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public PersonalInfoResult() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1532227855")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("1532227855", new Object[]{this})).intValue();
        }

        public String getResult() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1782836950")) {
                return this.result;
            }
            return (String) ipChange.ipc$dispatch("-1782836950", new Object[]{this});
        }

        public void setResult(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-828462604")) {
                ipChange.ipc$dispatch("-828462604", new Object[]{this, str});
                return;
            }
            this.result = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "889500572")) {
                ipChange.ipc$dispatch("889500572", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.result);
        }

        protected PersonalInfoResult(Parcel parcel) {
            this.result = parcel.readString();
        }
    }

    public static UserData a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400039427")) {
            return (UserData) ipChange.ipc$dispatch("-400039427", new Object[0]);
        }
        try {
            return (UserData) JSON.parseObject(d20.f(), UserData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void b(PersonalInfoRequest personalInfoRequest, final OnUserInfoListener onUserInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586104921")) {
            ipChange.ipc$dispatch("-586104921", new Object[]{personalInfoRequest, onUserInfoListener});
            return;
        }
        Context applicationContext = xs0.a().getApplicationContext();
        if (!LoginManager.k().q()) {
            c(applicationContext);
        } else {
            personalInfoRequest.request(new DMMtopRequestListener<UserData>(UserData.class) {
                /* class cn.damai.im.UserInfoUtil.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1208257572")) {
                        ipChange.ipc$dispatch("1208257572", new Object[]{this, str, str2});
                        return;
                    }
                    OnUserInfoListener onUserInfoListener = onUserInfoListener;
                    if (onUserInfoListener != null) {
                        onUserInfoListener.onFailed(str, str2);
                    }
                }

                public void onSuccess(UserData userData) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1169768412")) {
                        ipChange.ipc$dispatch("-1169768412", new Object[]{this, userData});
                    } else if (userData != null) {
                        OnUserInfoListener onUserInfoListener = onUserInfoListener;
                        if (onUserInfoListener != null) {
                            onUserInfoListener.onSuccess(userData);
                        }
                    } else {
                        OnUserInfoListener onUserInfoListener2 = onUserInfoListener;
                        if (onUserInfoListener2 != null) {
                            onUserInfoListener2.onFailed("", "");
                        }
                    }
                }
            });
        }
    }

    private static void c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579084825")) {
            ipChange.ipc$dispatch("-1579084825", new Object[]{context});
            return;
        }
        DMNav.from(context).toUri(gr.f());
    }

    public static void d(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103260512")) {
            ipChange.ipc$dispatch("1103260512", new Object[]{userData});
            return;
        }
        d20.j0(JSON.toJSONString(userData));
    }

    public static void e(UserVipBean userVipBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10349294")) {
            ipChange.ipc$dispatch("-10349294", new Object[]{userVipBean});
            return;
        }
        String E = d20.E();
        if (!TextUtils.isEmpty(E)) {
            String jSONString = userVipBean != null ? JSON.toJSONString(userVipBean) : "";
            d20.T(USER_VIP_PREFIX + E, jSONString);
        }
    }
}
