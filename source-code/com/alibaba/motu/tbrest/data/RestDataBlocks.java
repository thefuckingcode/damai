package com.alibaba.motu.tbrest.data;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class RestDataBlocks {
    private static final char SPLIT = 1;
    private static final String TAG = "RestDataBlocks";
    private Map<String, RestDataBlock> blockMap = new HashMap();

    /* compiled from: Taobao */
    public static class RestDataBlock {
        private final String appKey;
        private int contextCount = 0;
        private final Map<String, StringBuilder> map = new HashMap();
        private int size = 0;
        private final String url;

        public RestDataBlock(String str, String str2) {
            this.appKey = str;
            this.url = str2;
        }

        public void appendData(String str, String str2) {
            if (str == null || str2 == null) {
                throw new IllegalArgumentException();
            }
            StringBuilder sb = this.map.get(str);
            if (sb == null) {
                this.map.put(str, new StringBuilder(str2));
            } else {
                sb.append(RestDataBlocks.SPLIT);
                sb.append(str2);
            }
            this.size += str2.length();
            this.contextCount++;
        }

        public Map<String, String> data() {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, StringBuilder> entry : this.map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
            return hashMap;
        }

        public int dataSize() {
            return this.size;
        }

        public String getAppKey() {
            return this.appKey;
        }

        public int getContextCount() {
            return this.contextCount;
        }

        public String getUrl() {
            return this.url;
        }

        public int size() {
            return this.map.size();
        }
    }

    public void clear() {
        this.blockMap.clear();
    }

    public RestDataBlock createBlockIfNotExist(String str, String str2) {
        String str3 = str + str2;
        RestDataBlock restDataBlock = this.blockMap.get(str3);
        if (restDataBlock != null) {
            return restDataBlock;
        }
        RestDataBlock restDataBlock2 = new RestDataBlock(str, str2);
        this.blockMap.put(str3, restDataBlock2);
        return restDataBlock2;
    }

    public Map<String, RestDataBlock> getAll() {
        return this.blockMap;
    }

    public RestDataBlock removeBlockIfExist(String str, String str2) {
        return this.blockMap.remove(str + str2);
    }

    public int size() {
        return this.blockMap.size();
    }
}
