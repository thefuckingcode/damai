package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class f extends e {
    /* access modifiers changed from: protected */
    @Override // com.huawei.hms.core.aidl.e
    public List<Object> a(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        int i = bundle.getInt("_list_size_");
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = bundle.get("_list_item_" + i2);
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (!(obj instanceof Bundle)) {
                continue;
            } else {
                Bundle bundle2 = (Bundle) obj;
                int i3 = bundle2.getInt("_val_type_", -1);
                if (i3 == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                } else if (i3 == 0) {
                    arrayList.add(a(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                } else {
                    throw new InstantiationException("Unknown type can not be supported");
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.huawei.hms.core.aidl.e
    public void a(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i = 0; i < list.size(); i++) {
            a("_list_item_" + i, list.get(i), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
