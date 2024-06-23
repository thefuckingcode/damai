package com.alibaba.yymidservice.popup.popupcenter.ut;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\t\u001a\u00020\b2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J4\u0010\n\u001a\u00020\b2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J<\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/alibaba/yymidservice/popup/popupcenter/ut/UTHelperPopupCallback;", "", "Ljava/util/HashMap;", "", "map", "", "Lcom/alibaba/fastjson/JSONObject;", "action", "Ltb/ur2;", "confirmUt", "closeUt", "", "duration", "exposureUt", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface UTHelperPopupCallback {
    void closeUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map);

    void confirmUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map);

    void exposureUt(long j, @Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map);
}
