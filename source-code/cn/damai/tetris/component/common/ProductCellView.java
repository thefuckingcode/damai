package cn.damai.tetris.component.common;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.common.ProductCellContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProductCellView extends AbsView<ProductCellContract.Presenter> implements ProductCellContract.View<ProductCellContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    ImageView img;
    TextView price;
    TextView title;

    public ProductCellView(View view) {
        super(view);
        this.img = (ImageView) view.findViewById(R$id.produce_cell_img);
        this.title = (TextView) view.findViewById(R$id.produce_cell_name);
        this.price = (TextView) view.findViewById(R$id.tv_project_price);
    }

    @Override // cn.damai.tetris.component.common.ProductCellContract.View
    public ImageView getImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-575943159")) {
            return this.img;
        }
        return (ImageView) ipChange.ipc$dispatch("-575943159", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.ProductCellContract.View
    public TextView getPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-616122283")) {
            return this.price;
        }
        return (TextView) ipChange.ipc$dispatch("-616122283", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.ProductCellContract.View
    public TextView getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1156377114")) {
            return this.title;
        }
        return (TextView) ipChange.ipc$dispatch("-1156377114", new Object[]{this});
    }
}
