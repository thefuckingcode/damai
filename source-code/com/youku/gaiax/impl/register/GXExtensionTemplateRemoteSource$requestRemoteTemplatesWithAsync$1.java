package com.youku.gaiax.impl.register;

import com.youku.gaiax.impl.utils.ExceptionUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionTemplateRemoteSource$requestRemoteTemplatesWithAsync$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ String $templatesId;
    final /* synthetic */ GXExtensionTemplateRemoteSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GXExtensionTemplateRemoteSource$requestRemoteTemplatesWithAsync$1(GXExtensionTemplateRemoteSource gXExtensionTemplateRemoteSource, String str) {
        super(0);
        this.this$0 = gXExtensionTemplateRemoteSource;
        this.$templatesId = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        try {
            this.this$0.requestTemplates(this.$templatesId);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
        }
    }
}
