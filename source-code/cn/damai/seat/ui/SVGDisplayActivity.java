package cn.damai.seat.ui;

import android.graphics.drawable.PictureDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.view.SVGDisplayView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.b01;
import tb.kl1;
import tb.vz0;

/* compiled from: Taobao */
public class SVGDisplayActivity extends BaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String REQUEST_SVG_URL = "svg_display_url";
    private TextView mDetailInfoTv;
    private SVGRequest mRequest;
    private PictureDrawable mSVGPicture;
    private RelativeLayout mSvgView;
    private TextView mTipTv;
    private List<String> mUnrecognizedCommandList;

    /* compiled from: Taobao */
    public class a implements RequestListener<ImageData, vz0> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void onSuccess(kl1<vz0> kl1, ImageData imageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1081960720")) {
                ipChange.ipc$dispatch("-1081960720", new Object[]{this, kl1, imageData});
                return;
            }
            SVGDisplayActivity.this.stopProgressDialog();
            BaseSVG svg = imageData.getSVG();
            SVGDisplayActivity.this.mSVGPicture = svg.getDrawable();
            SVGDisplayActivity.this.mUnrecognizedCommandList = svg.getUnrecognizedCommandList();
            SVGDisplayActivity.this.showSVGImage();
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
        public void onFail(kl1<vz0> kl1, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1437010874")) {
                ipChange.ipc$dispatch("-1437010874", new Object[]{this, kl1, str, str2});
                return;
            }
            SVGDisplayActivity.this.stopProgressDialog();
            ToastUtil a2 = ToastUtil.a();
            SVGDisplayActivity sVGDisplayActivity = SVGDisplayActivity.this;
            a2.j(sVGDisplayActivity, "code=" + str + "_msg=" + str2);
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509207332")) {
            ipChange.ipc$dispatch("-1509207332", new Object[]{this});
            return;
        }
        loadSVGData(getIntent().getStringExtra(REQUEST_SVG_URL));
    }

    private void loadSVGData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1193868982")) {
            ipChange.ipc$dispatch("1193868982", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            startProgressDialog();
            SVGRequest sVGRequest = new SVGRequest(new b01(false, str, -1, true, false, null));
            this.mRequest = sVGRequest;
            sVGRequest.d(new a());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSVGImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764108162")) {
            ipChange.ipc$dispatch("764108162", new Object[]{this});
            return;
        }
        List<String> list = this.mUnrecognizedCommandList;
        if (list == null || list.isEmpty()) {
            this.mTipTv.setText("未发现无法识别的标签!");
        } else {
            this.mTipTv.setText("发现无法识别的标签! (点击查看详情)");
            String str = "无法识别的标签:\n";
            for (int i = 0; i < this.mUnrecognizedCommandList.size(); i++) {
                str = str + this.mUnrecognizedCommandList.get(i) + "、";
            }
            if (str.length() > 1) {
                str = str.substring(0, str.length() - 1);
            }
            this.mDetailInfoTv.setText(str);
        }
        SVGDisplayView sVGDisplayView = new SVGDisplayView(this);
        sVGDisplayView.setPictureData(this.mSVGPicture);
        sVGDisplayView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mSvgView.addView(sVGDisplayView);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351930594")) {
            ipChange.ipc$dispatch("-351930594", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-618921972")) {
            return R$layout.activity_svg_displayer;
        }
        return ((Integer) ipChange.ipc$dispatch("-618921972", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1699914524")) {
            ipChange.ipc$dispatch("1699914524", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796792833")) {
            ipChange.ipc$dispatch("1796792833", new Object[]{this});
            return;
        }
        this.mSvgView = (RelativeLayout) findViewById(R$id.svg_view);
        TextView textView = (TextView) findViewById(R$id.tv_tips);
        this.mTipTv = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.mDetailInfoTv = (TextView) findViewById(R$id.tv_detail_info);
        initData();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739896743")) {
            ipChange.ipc$dispatch("739896743", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() != R$id.tv_tips) {
            return;
        }
        if (this.mDetailInfoTv.getVisibility() == 8) {
            this.mDetailInfoTv.setVisibility(0);
            this.mTipTv.setText("无法识别的标签详情 (点击收起)");
            return;
        }
        this.mDetailInfoTv.setVisibility(8);
        this.mTipTv.setText("发现无法识别的标签! (点击查看详情)");
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205277209")) {
            ipChange.ipc$dispatch("1205277209", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1592336000")) {
            return "SVG Displayer";
        }
        return (String) ipChange.ipc$dispatch("-1592336000", new Object[]{this});
    }
}
