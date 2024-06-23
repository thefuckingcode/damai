package com.alient.onearch.adapter.loader;

import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()Ljava/lang/Object;", "com/alient/onearch/adapter/loader/BasePageLoader$handleLoadSuccess$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BasePageLoader$handleLoadSuccess$$inlined$apply$lambda$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ IResponse $response$inlined;
    final /* synthetic */ IContext $this_apply;
    final /* synthetic */ BasePageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasePageLoader$handleLoadSuccess$$inlined$apply$lambda$1(IContext iContext, BasePageLoader basePageLoader, IResponse iResponse, int i) {
        super(0);
        this.$this_apply = iContext;
        this.this$0 = basePageLoader;
        this.$response$inlined = iResponse;
        this.$index$inlined = i;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Object invoke() {
        try {
            JSONObject jsonObject = this.$response$inlined.getJsonObject();
            if (jsonObject == null) {
                return null;
            }
            BasePageLoader basePageLoader = this.this$0;
            Node parseNode = basePageLoader.parseNode(basePageLoader.findRootDataNode(jsonObject));
            this.$this_apply.setActivityValue(this.this$0.parseActivityValue(parseNode.getData()));
            int i = this.$index$inlined;
            if (i > 1) {
                this.this$0.handleLoadMore(parseNode, i);
            } else {
                this.this$0.handleFirstLoad(parseNode, i);
            }
            this.this$0.setLoadingPage(0);
            this.this$0.handleLoadFinish(this.$response$inlined, true, this.$index$inlined);
            return jsonObject;
        } catch (Exception unused) {
            this.this$0.handleLoadFinish(this.$response$inlined, false, this.$index$inlined);
            return ur2.INSTANCE;
        }
    }
}
