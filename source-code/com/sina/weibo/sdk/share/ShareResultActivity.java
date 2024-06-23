package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: Taobao */
public class ShareResultActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
            } else if (intent.getIntExtra("start_flag", -1) != 1002) {
                finish();
            } else {
                String action = intent.getAction();
                if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(action)) {
                    intent.setClassName(this, "com.sina.weibo.sdk.share.ShareTransActivity");
                } else if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY".equals(action)) {
                    intent.setClassName(this, "com.sina.weibo.sdk.share.ShareStoryActivity");
                }
                startActivity(intent);
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
