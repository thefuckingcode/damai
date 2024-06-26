package com.youku.live.dago.widgetlib.util;

import android.os.Parcelable;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class FastJsonTools {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> T deserialize(String str, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1229537314")) {
            return (T) ipChange.ipc$dispatch("1229537314", new Object[]{str, cls});
        }
        try {
            if (!Serializable.class.isAssignableFrom(cls)) {
                if (!Parcelable.class.isAssignableFrom(cls)) {
                    Log.e("FastJsonTools", cls.getName() + " haven't implement Serializable or Parcelable.");
                    throw new IllegalArgumentException(cls.getName() + " must be implement Serializable or Parcelable.");
                }
            }
            return (T) JSON.parseObject(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T deserializeAny(String str, TypeReference<T> typeReference) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-122599867")) {
            return (T) JSON.parseObject(str, typeReference, new Feature[0]);
        }
        return (T) ipChange.ipc$dispatch("-122599867", new Object[]{str, typeReference});
    }

    public static <T> List<T> deserializeList(String str, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1161508409")) {
            return (List) ipChange.ipc$dispatch("1161508409", new Object[]{str, cls});
        } else if (str == null || !str.startsWith(jl1.ARRAY_START_STR)) {
            return null;
        } else {
            if (Serializable.class.isAssignableFrom(cls) || Parcelable.class.isAssignableFrom(cls)) {
                return JSON.parseArray(str, cls);
            }
            Log.e("FastJsonTools", cls.getName() + " haven't implement Serializable or Parcelable.");
            try {
                throw new IllegalArgumentException(cls.getName() + " must be implement Serializable or Parcelable.");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static <T> String serialize(T t) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1632788994")) {
            return JSON.toJSONString(t);
        }
        return (String) ipChange.ipc$dispatch("1632788994", new Object[]{t});
    }
}
