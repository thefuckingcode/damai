package cn.damai.projectfiltercopy.model;

import cn.damai.projectfiltercopy.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class CategoryNewT extends GetTFromModel<CategoryDataAssembler> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryNewT(@NotNull FilterModel filterModel) {
        super(filterModel);
        k21.i(filterModel, "model");
    }

    @Override // cn.damai.projectfiltercopy.model.GetTFromModel
    @NotNull
    public CategoryDataAssembler getT(@NotNull Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567616738")) {
            return (CategoryDataAssembler) ipChange.ipc$dispatch("1567616738", new Object[]{this, type});
        }
        k21.i(type, "type");
        CategoryDataAssembler categoryDataAssembler = this.mModel.mCatAssembler;
        k21.h(categoryDataAssembler, "mModel.mCatAssembler");
        return categoryDataAssembler;
    }
}
