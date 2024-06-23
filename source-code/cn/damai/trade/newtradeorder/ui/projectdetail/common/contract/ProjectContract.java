package cn.damai.trade.newtradeorder.ui.projectdetail.common.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectSwitchIdDataBean;

/* compiled from: Taobao */
public interface ProjectContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void retrieveOldProjectItemId(String str);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void onRetrieveOldProjectIdError(String str, String str2);

        void onRetrieveOldProjectIdSuccess(ProjectSwitchIdDataBean.ProjectSwitchIdResultBean projectSwitchIdResultBean);
    }
}
