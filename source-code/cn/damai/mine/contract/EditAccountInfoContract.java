package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.mine.bean.ProfileInfo;
import cn.damai.mine.param.SaveUserRequest;

/* compiled from: Taobao */
public interface EditAccountInfoContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void saveProfileInfo(SaveUserRequest saveUserRequest);
    }

    /* compiled from: Taobao */
    public interface View extends BaseView {
        void returnProfileInfo(ProfileInfo profileInfo);

        void returnProfileInfoFalse(String str, String str2);

        void returnSaveUserProfile(ProfileInfo profileInfo);

        void returnSaveUserProfileFalse(String str, String str2);
    }
}
