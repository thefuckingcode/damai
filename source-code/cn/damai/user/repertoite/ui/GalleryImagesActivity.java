package cn.damai.user.repertoite.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.repertoite.adapter.RepertoireDetailsGalleryAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class GalleryImagesActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String IMAGES = "images";
    public static final String LOCATION = "location";
    private RepertoireDetailsGalleryAdapter adapter;
    private int browserType;
    private TextView cursor;
    private int location;
    private ImageButton mBackView;
    private ArrayList<String> mImageUrls;
    private View posterLayout;
    private ViewPager viewer;

    private void initPosterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505752170")) {
            ipChange.ipc$dispatch("1505752170", new Object[]{this});
            return;
        }
        this.posterLayout.setVisibility(0);
        TextView textView = (TextView) findViewById(R$id.location);
        this.cursor = textView;
        textView.setText((this.location + 1) + "/" + this.mImageUrls.size());
        this.viewer = (ViewPager) findViewById(R$id.poster_viewer);
        RepertoireDetailsGalleryAdapter repertoireDetailsGalleryAdapter = new RepertoireDetailsGalleryAdapter(this, this.mImageUrls);
        this.adapter = repertoireDetailsGalleryAdapter;
        this.viewer.setAdapter(repertoireDetailsGalleryAdapter);
        this.viewer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.user.repertoite.ui.GalleryImagesActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "451843176")) {
                    ipChange.ipc$dispatch("451843176", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "299108615")) {
                    ipChange.ipc$dispatch("299108615", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2042538573")) {
                    ipChange.ipc$dispatch("-2042538573", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TextView textView = GalleryImagesActivity.this.cursor;
                textView.setText((i + 1) + "/" + GalleryImagesActivity.this.mImageUrls.size());
            }
        });
        this.viewer.setCurrentItem(this.location);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948424916")) {
            ipChange.ipc$dispatch("1948424916", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1418289814")) {
            return R$layout.repertoire_details_gallery_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("1418289814", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844687451")) {
            ipChange.ipc$dispatch("-844687451", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955353894")) {
            ipChange.ipc$dispatch("955353894", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "894933943")) {
            ipChange.ipc$dispatch("894933943", new Object[]{this});
            return;
        }
        hideBaseLayout();
        Intent intent = getIntent();
        this.mImageUrls = intent.getStringArrayListExtra("images");
        this.location = intent.getIntExtra("location", 0);
        ArrayList<String> arrayList = this.mImageUrls;
        if (arrayList == null || arrayList.size() == 0) {
            finish();
            return;
        }
        ImageButton imageButton = (ImageButton) findViewById(R$id.back);
        this.mBackView = imageButton;
        imageButton.setOnClickListener(this);
        this.posterLayout = findViewById(R$id.poster_gallery);
        initPosterView();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057168349")) {
            ipChange.ipc$dispatch("2057168349", new Object[]{this, view});
            return;
        }
        if (view.getId() == R$id.back) {
            finish();
        }
        super.onClick(view);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397863124")) {
            ipChange.ipc$dispatch("397863124", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340671169")) {
            ipChange.ipc$dispatch("340671169", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "112724618")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("112724618", new Object[]{this});
    }
}
