package cn.damai.tetris.component.common;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.common.ProductCellContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import tb.ob;
import tb.w9;
import tb.wk;

/* compiled from: Taobao */
public class ProductCellPresenter extends BasePresenter<ProductCellContract.Model, ProductCellContract.View, BaseSection> implements ProductCellContract.Presenter<ProductCellContract.Model, ProductCellContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1660547831")) {
                ipChange.ipc$dispatch("-1660547831", new Object[]{this, view});
                return;
            }
            if (!TextUtils.isEmpty(((ProductCellContract.Model) ProductCellPresenter.this.getModel()).getSchema())) {
                DMNav.from(((BasePresenter) ProductCellPresenter.this).mContext.getActivity()).toUri(((ProductCellContract.Model) ProductCellPresenter.this.getModel()).getSchema());
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, ((ProductCellContract.Model) ProductCellPresenter.this.getModel()).getId());
                bundle.putString("projectName", ((ProductCellContract.Model) ProductCellPresenter.this.getModel()).getName());
                bundle.putString("projectImage", ((ProductCellContract.Model) ProductCellPresenter.this.getModel()).getBgImg());
                DMNav.from(((BasePresenter) ProductCellPresenter.this).mContext.getActivity()).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
            }
            Map<String, String> argsMap = ProductCellPresenter.this.mTrackInfo.getArgsMap();
            argsMap.put("item_id", ((ProductCellContract.Model) ProductCellPresenter.this.getModel()).getId());
            ProductCellPresenter.this.userTrackClick("item", argsMap, true);
        }
    }

    public ProductCellPresenter(ProductCellView productCellView, String str, w9 w9Var) {
        super(productCellView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751999432")) {
            ipChange.ipc$dispatch("1751999432", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(ProductCellContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1435128007")) {
            ipChange.ipc$dispatch("-1435128007", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        cn.damai.uikit.image.a.a().loadinto(model.getBgImg(), ((ProductCellContract.View) getView()).getImg());
        ob.a(((ProductCellContract.View) getView()).getTitle(), ((ProductCellContract.Model) getModel()).getName());
        ob.a(((ProductCellContract.View) getView()).getPrice(), ((ProductCellContract.Model) getModel()).getPriceLow());
        userTrackExpose(((ProductCellContract.View) getView()).getTitle(), "item");
        ((ProductCellContract.View) getView()).getRootView().setOnClickListener(new a());
    }
}
