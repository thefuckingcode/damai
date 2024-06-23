package com.alibaba.motu.tbrest.rest;

import android.content.Context;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.data.RestData;
import com.alibaba.motu.tbrest.data.RestDataBlocks;
import com.alibaba.motu.tbrest.data.RestDataQueue;
import com.alibaba.motu.tbrest.data.RestOrangeConfigure;
import com.alibaba.motu.tbrest.logger.LoggerAdapter;
import com.alibaba.motu.tbrest.request.BizRequest;
import com.alibaba.motu.tbrest.rest.RestSender;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class RestBlockHandler {
    private static final String TAG = "RestBlockHandler";
    private static final Executor dataThread = Executors.newSingleThreadExecutor();
    private final RestOrangeConfigure configure = RestOrangeConfigure.instance();
    private final RestDataBlocks dataBlocks = new RestDataBlocks();
    private int failedCount = 0;
    private final Random random = new Random();
    private final RestSender restSender = new RestSender();
    private final RestDataQueue<RestData> retryDataQueue = new RestDataQueue<>(100);
    private int succeedCount = 0;

    RestBlockHandler() {
    }

    private boolean isNeedUpdate(int i) {
        return this.random.nextFloat() < this.configure.getSampleByEventID(String.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onSendFailed(final RestData restData) {
        dataThread.execute(new Runnable() {
            /* class com.alibaba.motu.tbrest.rest.RestBlockHandler.AnonymousClass3 */

            public void run() {
                RestData restData = (RestData) RestBlockHandler.this.retryDataQueue.push(restData);
                if (restData != null) {
                    int count = restData.getCount();
                    RestBlockHandler.this.failedCount += count;
                    LoggerAdapter.log("fail", "totalCount", Integer.valueOf(RestBlockHandler.this.failedCount), "currentCount", Integer.valueOf(count));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onSendSucceed(final RestData restData) {
        dataThread.execute(new Runnable() {
            /* class com.alibaba.motu.tbrest.rest.RestBlockHandler.AnonymousClass4 */

            public void run() {
                int count = restData.getCount();
                RestBlockHandler.this.succeedCount += count;
                LoggerAdapter.log("success", "totalCount", Integer.valueOf(RestBlockHandler.this.succeedCount), "currentCount", Integer.valueOf(count));
                RestData restData = (RestData) RestBlockHandler.this.retryDataQueue.poll();
                if (restData != null) {
                    RestBlockHandler.this.restSender.sendRestDataAsync(restData, new RestSender.Callback() {
                        /* class com.alibaba.motu.tbrest.rest.RestBlockHandler.AnonymousClass4.AnonymousClass1 */

                        @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                        public void onFailed(RestData restData) {
                            RestBlockHandler.this.onSendFailed(restData);
                        }

                        @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                        public void onSuccess(RestData restData) {
                            RestBlockHandler.this.onSendSucceed(restData);
                        }
                    });
                }
            }
        });
    }

    private byte[] packageRequest(String str, Context context, Map<String, String> map) {
        try {
            return BizRequest.getPackRequest(str, context, map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendDataBlock(RestDataBlocks.RestDataBlock restDataBlock, Context context) {
        byte[] packageRequest = packageRequest(restDataBlock.getAppKey(), context, restDataBlock.data());
        if (packageRequest != null) {
            this.restSender.sendRestDataAsync(new RestData(restDataBlock.getAppKey(), restDataBlock.getUrl(), restDataBlock.getContextCount(), packageRequest), new RestSender.Callback() {
                /* class com.alibaba.motu.tbrest.rest.RestBlockHandler.AnonymousClass2 */

                @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                public void onFailed(RestData restData) {
                    RestBlockHandler.this.onSendFailed(restData);
                }

                @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                public void onSuccess(RestData restData) {
                    RestBlockHandler.this.onSendSucceed(restData);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void sendAllCacheData() {
        dataThread.execute(new Runnable() {
            /* class com.alibaba.motu.tbrest.rest.RestBlockHandler.AnonymousClass5 */

            public void run() {
                for (RestDataBlocks.RestDataBlock restDataBlock : RestBlockHandler.this.dataBlocks.getAll().values()) {
                    RestBlockHandler.this.sendDataBlock(restDataBlock, SendService.getInstance().context);
                }
                RestBlockHandler.this.dataBlocks.clear();
            }
        });
    }

    public boolean sendAsyncInfo(final int i, final String str, final Context context, final String str2, final String str3) {
        if (!isNeedUpdate(i)) {
            return false;
        }
        dataThread.execute(new Runnable() {
            /* class com.alibaba.motu.tbrest.rest.RestBlockHandler.AnonymousClass1 */

            public void run() {
                RestDataBlocks.RestDataBlock createBlockIfNotExist = RestBlockHandler.this.dataBlocks.createBlockIfNotExist(str, str2);
                createBlockIfNotExist.appendData(String.valueOf(i), str3);
                if (createBlockIfNotExist.dataSize() >= RestBlockHandler.this.configure.getDataSize() || createBlockIfNotExist.getContextCount() >= RestBlockHandler.this.configure.getMessageCount()) {
                    RestBlockHandler.this.sendDataBlock(createBlockIfNotExist, context);
                    RestBlockHandler.this.dataBlocks.removeBlockIfExist(str, str2);
                }
            }
        });
        return true;
    }
}
