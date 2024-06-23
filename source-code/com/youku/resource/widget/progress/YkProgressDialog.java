package com.youku.resource.widget.progress;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import com.youku.resource.R;
import com.youku.resource.widget.progress.IYkProgessProvider;

/* compiled from: Taobao */
public class YkProgressDialog extends Dialog {
    private boolean mAutoDismiss = false;
    private IYkProgessProvider.ProgressListener mInnerListener = new IYkProgessProvider.ProgressListener() {
        /* class com.youku.resource.widget.progress.YkProgressDialog.AnonymousClass1 */

        @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
        public void onComplete() {
            if (YkProgressDialog.this.mProgressBar != null) {
                YkProgressDialog.this.mProgressBar.setProgress(100);
            }
            if (YkProgressDialog.this.mAutoDismiss) {
                YkProgressDialog.this.dismiss();
            }
        }

        @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
        public void onFailed(String str) {
            YkProgressDialog.this.dismiss();
        }

        @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
        public void updateProgress(int i) {
            if (YkProgressDialog.this.mProgressBar != null) {
                YkProgressDialog.this.mProgressBar.setProgress(i);
            }
        }
    };
    private DownloadProgressBar mProgressBar;
    private IYkProgessProvider mYkProgressListener;

    public YkProgressDialog(@NonNull Context context) {
        super(context);
    }

    public static YkProgressDialog create(Context context, boolean z, IYkProgessProvider iYkProgessProvider) {
        return new YkProgressDialog(context, iYkProgessProvider, z);
    }

    private void initContentView() {
        setContentView(R.layout.ykdialog_download_progress);
        this.mProgressBar = (DownloadProgressBar) findViewById(R.id.downloadProgressBar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(17);
        window.setWindowAnimations(R.style.yk_CenterDialog);
        window.setDimAmount(0.3f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initContentView();
    }

    public void start() {
        IYkProgessProvider iYkProgessProvider = this.mYkProgressListener;
        if (iYkProgessProvider != null) {
            iYkProgessProvider.start(this.mInnerListener);
        }
    }

    public YkProgressDialog(@NonNull Context context, IYkProgessProvider iYkProgessProvider, boolean z) {
        super(context);
        this.mYkProgressListener = iYkProgessProvider;
        this.mAutoDismiss = z;
        start();
    }
}
