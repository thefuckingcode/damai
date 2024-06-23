package cn.damai.search.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.search.bean.SearchResultBean;

/* compiled from: Taobao */
public interface SearchResultContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getSearchList(String str, String str2, int i, String str3, String str4);
    }

    /* compiled from: Taobao */
    public interface View extends BaseView {
        void error(String str, String str2, String str3, String str4, int i);

        void returnSearchList(SearchResultBean searchResultBean, String str);
    }
}
