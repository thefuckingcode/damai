package com.taobao.weex.utils;

import androidx.annotation.NonNull;
import com.taobao.weex.utils.FunctionParser;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class SingleFunctionParser<V> extends FunctionParser<String, List<V>> {

    /* compiled from: Taobao */
    public interface FlatMapper<V> {
        V map(String str);
    }

    /* compiled from: Taobao */
    public interface NonUniformMapper<V> {
        List<V> map(List<String> list);
    }

    public SingleFunctionParser(@NonNull String str, @NonNull final FlatMapper<V> flatMapper) {
        super(str, new FunctionParser.Mapper<String, List<V>>() {
            /* class com.taobao.weex.utils.SingleFunctionParser.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public Map<String, List<V>> map(String str, List<String> list) {
                HashMap hashMap = new HashMap();
                LinkedList linkedList = new LinkedList();
                for (String str2 : list) {
                    linkedList.add(FlatMapper.this.map(str2));
                }
                hashMap.put(str, linkedList);
                return hashMap;
            }
        });
    }

    public List<V> parse(String str) {
        LinkedHashMap<K, V> parse = parse();
        if (parse.containsKey(str)) {
            return parse.get(str);
        }
        return null;
    }

    public SingleFunctionParser(@NonNull String str, @NonNull final NonUniformMapper<V> nonUniformMapper) {
        super(str, new FunctionParser.Mapper<String, List<V>>() {
            /* class com.taobao.weex.utils.SingleFunctionParser.AnonymousClass2 */

            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public Map<String, List<V>> map(String str, List<String> list) {
                HashMap hashMap = new HashMap();
                hashMap.put(str, NonUniformMapper.this.map(list));
                return hashMap;
            }
        });
    }
}
