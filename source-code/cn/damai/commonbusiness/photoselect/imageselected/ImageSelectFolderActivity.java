package cn.damai.commonbusiness.photoselect.imageselected;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.photoselect.imageselected.adapter.FolderAdapter;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.ne2;
import tb.sm0;
import tb.xf2;

/* compiled from: Taobao */
public class ImageSelectFolderActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ArrayList<sm0> mTFolders;
    private ArrayList<sm0> mFolders;
    private ArrayList<Image> mSelectedImages;
    private RecyclerView rvFolder;
    private View status_bar_gap;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-559629556")) {
                ipChange.ipc$dispatch("-559629556", new Object[]{this, view});
                return;
            }
            ImageSelectFolderActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements FolderAdapter.OnFolderSelectListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.FolderAdapter.OnFolderSelectListener
        public int OnFolderSelect(sm0 sm0) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1607043897")) {
                return ImageSelectFolderActivity.this.covert(sm0.c());
            }
            return ((Integer) ipChange.ipc$dispatch("-1607043897", new Object[]{this, sm0})).intValue();
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.FolderAdapter.OnFolderSelectListener
        public void OnFolderSelect(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "292400400")) {
                ipChange.ipc$dispatch("292400400", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("position", i);
            ImageSelectFolderActivity.this.setResult(-1, intent);
            ImageSelectFolderActivity.this.finish();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int covert(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107928334")) {
            return ((Integer) ipChange.ipc$dispatch("2107928334", new Object[]{this, str})).intValue();
        }
        ArrayList<Image> arrayList = this.mSelectedImages;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        if (getResources().getString(R$string.damai_all_image).equals(str)) {
            return this.mSelectedImages.size();
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mSelectedImages.size(); i2++) {
            String folderName = ImageModel.getFolderName(this.mSelectedImages.get(i2).getPath());
            if (xf2.i(folderName) && folderName.equals(str)) {
                i++;
            }
        }
        return i;
    }

    private void initFolderList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252962702")) {
            ipChange.ipc$dispatch("-1252962702", new Object[]{this});
            return;
        }
        this.rvFolder.setVisibility(0);
        ArrayList<sm0> arrayList = this.mFolders;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.rvFolder.setLayoutManager(new LinearLayoutManager(this));
            FolderAdapter folderAdapter = new FolderAdapter(this, this.mFolders);
            folderAdapter.d(new b());
            this.rvFolder.setAdapter(folderAdapter);
        }
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219188522")) {
            ipChange.ipc$dispatch("219188522", new Object[]{this});
            return;
        }
        findViewById(R$id.btn_back).setOnClickListener(new a());
    }

    public static void openActivity(Activity activity, int i, ArrayList<Image> arrayList, ArrayList<sm0> arrayList2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737606172")) {
            ipChange.ipc$dispatch("737606172", new Object[]{activity, Integer.valueOf(i), arrayList, arrayList2});
            return;
        }
        mTFolders = arrayList2;
        Intent intent = new Intent(activity, ImageSelectFolderActivity.class);
        intent.putParcelableArrayListExtra("selected", arrayList);
        activity.startActivityForResult(intent, i);
    }

    private void setStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952174680")) {
            ipChange.ipc$dispatch("952174680", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.status_bar_gap;
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                this.status_bar_gap.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            View view2 = this.status_bar_gap;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623531722")) {
            ipChange.ipc$dispatch("-1623531722", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "952920308")) {
            return R$layout.activity_image_folder_select;
        }
        return ((Integer) ipChange.ipc$dispatch("952920308", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1908727047")) {
            ipChange.ipc$dispatch("1908727047", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411857412")) {
            ipChange.ipc$dispatch("411857412", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345808359")) {
            ipChange.ipc$dispatch("-345808359", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477079679")) {
            ipChange.ipc$dispatch("-1477079679", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        removeHeadTitleView();
        this.status_bar_gap = findViewById(R$id.title_bar_space_view);
        this.rvFolder = (RecyclerView) findViewById(R$id.rv_folder);
        setStatusBarColor();
        this.mFolders = mTFolders;
        mTFolders = null;
        if (getIntent() != null) {
            this.mSelectedImages = getIntent().getParcelableArrayListExtra("selected");
        }
        initListener();
        initFolderList();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143689674")) {
            ipChange.ipc$dispatch("-1143689674", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124698337")) {
            ipChange.ipc$dispatch("-124698337", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-590769048")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("-590769048", new Object[]{this});
    }
}
