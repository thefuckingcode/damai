package com.alibaba.pictures.share.common.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/MovieShowShareActivity;", "Lcom/alibaba/pictures/share/common/ui/BaseShareActivity;", "Landroid/os/Bundle;", "savedInstanceState", "Ltb/ur2;", "onCreate", "", "shareChannel", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "getShareInfo", "Lcom/alibaba/pictures/share/common/ui/MovieShowShareActivity$IShareAction;", "iShareAction", "Lcom/alibaba/pictures/share/common/ui/MovieShowShareActivity$IShareAction;", "<init>", "()V", "Companion", "a", "IShareAction", "share_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class MovieShowShareActivity extends BaseShareActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String PARAMS_ISHARE_ACTION = "params_ishare_action";
    private IShareAction iShareAction;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/MovieShowShareActivity$IShareAction;", "Ljava/io/Serializable;", "", "shareChannel", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "getShareInfo", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IShareAction extends Serializable {
        @NotNull
        ShareContent getShareInfo(int i);
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.BaseShareActivity
    @Nullable
    public ShareContent getShareInfo(int i) {
        ShareContent shareInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321736412")) {
            return (ShareContent) ipChange.ipc$dispatch("-1321736412", new Object[]{this, Integer.valueOf(i)});
        }
        IShareAction iShareAction2 = this.iShareAction;
        return (iShareAction2 == null || (shareInfo = iShareAction2.getShareInfo(i)) == null) ? this.shareContent : shareInfo;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.alibaba.pictures.share.common.ui.BaseShareActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904933041")) {
            ipChange.ipc$dispatch("904933041", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        Intent intent = getIntent();
        if (intent != null) {
            IShareAction iShareAction2 = (IShareAction) intent.getSerializableExtra(PARAMS_ISHARE_ACTION);
            this.iShareAction = iShareAction2;
            if (iShareAction2 != null) {
                iShareAction2.getShareInfo(1);
            }
        }
    }
}
