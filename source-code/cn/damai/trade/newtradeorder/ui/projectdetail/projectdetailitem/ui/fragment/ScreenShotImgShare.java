package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.luban.Luban;
import cn.damai.common.image.luban.OnCompressListener;
import cn.damai.common.image.luban.OnRenameListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.ProjectItemDetailAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectHeaderPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBrandAndArtistMultiViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBrandSingleViewHolder;
import cn.damai.wxapi.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.d20;
import tb.gu1;
import tb.hp1;
import tb.l01;
import tb.lp1;
import tb.n42;
import tb.ne2;
import tb.s71;
import tb.ta;
import tb.ts0;
import tb.v50;
import tb.vv2;

/* compiled from: Taobao */
public class ScreenShotImgShare {
    private static transient /* synthetic */ IpChange $ipChange;
    long a;
    private Activity b;

    /* compiled from: Taobao */
    public class a implements OnCompressListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ View b;
        final /* synthetic */ Activity c;

        a(String str, View view, Activity activity) {
            this.a = str;
            this.b = view;
            this.c = activity;
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onError(Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1333311079")) {
                ipChange.ipc$dispatch("1333311079", new Object[]{this, th});
                return;
            }
            ToastUtil.a().e(this.c, "图片生成失败");
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onStart() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1528819276")) {
                ipChange.ipc$dispatch("-1528819276", new Object[]{this});
            }
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onSuccess(File file) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "816883306")) {
                ipChange.ipc$dispatch("816883306", new Object[]{this, file});
                return;
            }
            String absolutePath = file.getAbsolutePath();
            Bundle bundle = new Bundle();
            bundle.putString("imageModeUrl", absolutePath);
            bundle.putString("producturl", this.a);
            ShareManager.E().P(ScreenShotImgShare.this.g(), bundle, this.b);
        }
    }

    /* compiled from: Taobao */
    public class b implements OnRenameListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(ScreenShotImgShare screenShotImgShare) {
        }

        @Override // cn.damai.common.image.luban.OnRenameListener
        public String rename(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1614802304")) {
                return "dm_share_tmp.png";
            }
            return (String) ipChange.ipc$dispatch("1614802304", new Object[]{this, str});
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        c(ScreenShotImgShare screenShotImgShare, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-967493343")) {
                ipChange.ipc$dispatch("-967493343", new Object[]{this, view});
                return;
            }
            this.a.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScrollView a;
        final /* synthetic */ View b;
        final /* synthetic */ FrameLayout c;
        final /* synthetic */ String d;
        final /* synthetic */ long e;

        d(ScrollView scrollView, View view, FrameLayout frameLayout, String str, long j) {
            this.a = scrollView;
            this.b = view;
            this.c = frameLayout;
            this.d = str;
            this.e = j;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1184653017")) {
                ipChange.ipc$dispatch("-1184653017", new Object[]{this, view});
                return;
            }
            Bitmap f2 = ScreenShotImgShare.this.f(this.a, this.b);
            ScreenShotImgShare screenShotImgShare = ScreenShotImgShare.this;
            screenShotImgShare.k(screenShotImgShare.g(), f2, this.c, this.d);
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.E());
            hashMap.put("item_id", this.e + "");
            cn.damai.common.user.c.e().x(new a.b().i(ta.PROJECT_PAGE).f("screenshot").l("share").g(false).j(hashMap));
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "926637352")) {
                ipChange.ipc$dispatch("926637352", new Object[]{this, view});
            } else if (!LoginManager.k().q()) {
                LoginManager.k().x(ScreenShotImgShare.this.g(), new Intent(), 10001);
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("screenshot_info", ScreenShotDetector.k().l());
                DMNav.from(ScreenShotImgShare.this.g()).withExtras(bundle).toUri(NavUri.b("feedback_list"));
            }
        }
    }

    private Bitmap d(Bitmap bitmap, Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-341905450")) {
            return (Bitmap) ipChange.ipc$dispatch("-341905450", new Object[]{this, bitmap, bitmap2});
        }
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(bitmap.getWidth(), bitmap2.getWidth()), bitmap.getHeight() + bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, (float) bitmap.getHeight(), (Paint) null);
        return createBitmap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(LinearLayout linearLayout, int i, View view, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493519534")) {
            ipChange.ipc$dispatch("-493519534", new Object[]{this, linearLayout, Integer.valueOf(i), view, Integer.valueOf(i2)});
            return;
        }
        DisplayMetrics b2 = n42.b(g());
        Bitmap createBitmap = Bitmap.createBitmap(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2), i, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        ImageView imageView = (ImageView) linearLayout.findViewById(i2);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = (int) ((((float) (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2) - n42.a(g(), 94.0f))) / ((float) createBitmap.getWidth())) * ((float) createBitmap.getHeight()));
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(createBitmap);
        view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Bitmap f(ScrollView scrollView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34938699")) {
            return (Bitmap) ipChange.ipc$dispatch("-34938699", new Object[]{this, scrollView, view});
        }
        Bitmap s = GenerateImageUtil.s(scrollView);
        int i = R$id.detail_screenshot_conent_top;
        Bitmap createBitmap = Bitmap.createBitmap(view.findViewById(i).getWidth(), n42.a(g(), 66.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.findViewById(i).setBackground(h().getDrawable(R$drawable.detail_screenshot_title_bg_noradius));
        view.findViewById(i).draw(canvas);
        view.findViewById(i).setBackground(h().getDrawable(R$drawable.detail_screenshot_title_bg));
        return d(createBitmap, s);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Activity g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2081625989")) {
            return this.b;
        }
        return (Activity) ipChange.ipc$dispatch("2081625989", new Object[]{this});
    }

    private Resources h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "463762340")) {
            return g().getResources();
        }
        return (Resources) ipChange.ipc$dispatch("463762340", new Object[]{this});
    }

    public void i(final Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679936391")) {
            ipChange.ipc$dispatch("-1679936391", new Object[]{this, bitmap});
            return;
        }
        hp1.b(g(), false, lp1.STORAGE, "才能保存图片～", new OnGrantListener() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.askpermission.OnGrantListener
            public void onGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1143528505")) {
                    ipChange.ipc$dispatch("1143528505", new Object[]{this});
                    return;
                }
                ts0.b().a(new Runnable() {
                    /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass12.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1352262595")) {
                            ipChange.ipc$dispatch("-1352262595", new Object[]{this});
                            return;
                        }
                        AnonymousClass12 r0 = AnonymousClass12.this;
                        if (bitmap != null) {
                            String saveBitmapToDcimDir = ShareUtil.saveBitmapToDcimDir(ScreenShotImgShare.this.g(), bitmap);
                            if (!TextUtils.isEmpty(saveBitmapToDcimDir)) {
                                ScreenShotImgShare.this.g().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(saveBitmapToDcimDir))));
                                ScreenShotImgShare.this.g().runOnUiThread(new Runnable() {
                                    /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass12.AnonymousClass1.AnonymousClass1 */
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    public void run() {
                                        IpChange ipChange = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange, "-802963312")) {
                                            ipChange.ipc$dispatch("-802963312", new Object[]{this});
                                            return;
                                        }
                                        ToastUtil.a().e(ScreenShotImgShare.this.g(), "保存成功");
                                    }
                                });
                                return;
                            }
                            ScreenShotImgShare.this.g().runOnUiThread(new Runnable() {
                                /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass12.AnonymousClass1.AnonymousClass2 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-999476817")) {
                                        ipChange.ipc$dispatch("-999476817", new Object[]{this});
                                        return;
                                    }
                                    ToastUtil.a().e(ScreenShotImgShare.this.g(), "保存失败");
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public PopupWindow j(final long j, ProjectDetailDataBean projectDetailDataBean, RankInfo rankInfo, FrameLayout frameLayout, ProjectItemDetailAdapter projectItemDetailAdapter, vv2 vv2, Activity activity) {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733533254")) {
            return (PopupWindow) ipChange.ipc$dispatch("1733533254", new Object[]{this, Long.valueOf(j), projectDetailDataBean, rankInfo, frameLayout, projectItemDetailAdapter, vv2, activity});
        }
        this.b = activity;
        PopupWindow popupWindow = new PopupWindow(g());
        View inflate = LayoutInflater.from(g()).inflate(R$layout.layout_detail_screenshot_parent, (ViewGroup) null);
        DisplayMetrics b2 = n42.b(g());
        popupWindow.setWidth(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2));
        final int a2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(b2) + ne2.a(g());
        popupWindow.setHeight(a2);
        popupWindow.setClippingEnabled(false);
        popupWindow.setContentView(inflate);
        popupWindow.setBackgroundDrawable(new ColorDrawable(1711276032));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onDismiss() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-508231440")) {
                    ipChange.ipc$dispatch("-508231440", new Object[]{this});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", d20.E());
                hashMap.put("item_id", j + "");
                cn.damai.common.user.c.e().C("share", "screenshot", ta.PROJECT_PAGE, "1.0", System.currentTimeMillis() - ScreenShotImgShare.this.a, hashMap, 2201);
            }
        });
        inflate.setOnClickListener(new c(this, popupWindow));
        int i = R$id.detail_screenshot_conent;
        ViewGroup.LayoutParams layoutParams = inflate.findViewById(i).getLayoutParams();
        layoutParams.height = a2 - n42.a(g(), 154.0f);
        inflate.findViewById(i).setLayoutParams(layoutParams);
        inflate.postInvalidate();
        final ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.screenshot_share_content_scroll);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.screenshot_share_content_ll);
        final View findViewById = popupWindow.getContentView().findViewById(R$id.project_header);
        findViewById.setClickable(false);
        final View view2 = inflate;
        ProjectHeaderPanel projectHeaderPanel = new ProjectHeaderPanel(g(), j, popupWindow.getContentView(), null);
        projectHeaderPanel.w(false);
        projectHeaderPanel.o(projectDetailDataBean, rankInfo);
        findViewById.findViewById(R$id.header_base_uill).setBackground(h().getDrawable(R$drawable.bg_white));
        findViewById.setPadding(findViewById.getPaddingLeft(), 0, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        findViewById.findViewById(R$id.header_service_etc_ui).setVisibility(8);
        findViewById.findViewById(R$id.project_header_video).setVisibility(8);
        findViewById.findViewById(R$id.irc_tour).setVisibility(8);
        popupWindow.showAtLocation(frameLayout, 17, 0, 0);
        findViewById.post(new Runnable() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-829707058")) {
                    ipChange.ipc$dispatch("-829707058", new Object[]{this});
                    return;
                }
                ScreenShotImgShare.this.a = System.currentTimeMillis();
                ScreenShotImgShare.this.e(linearLayout, findViewById.getHeight() == 0 ? n42.a(ScreenShotImgShare.this.g(), 460.0f) : findViewById.getHeight(), findViewById, R$id.screenshot_share_content_img);
            }
        });
        if (projectItemDetailAdapter != null && projectItemDetailAdapter.getItemCount() > 0) {
            int i2 = 0;
            while (i2 < projectItemDetailAdapter.getItemCount()) {
                int itemViewType = projectItemDetailAdapter.getItemViewType(i2);
                ProjectDataHolder projectDataHolder = projectItemDetailAdapter.b().get(i2);
                if (itemViewType == 11) {
                    view = view2;
                    List<HtmlParserManager.a> shrinkConvertedItem = projectDataHolder.getShrinkConvertedItem();
                    if (shrinkConvertedItem != null && shrinkConvertedItem.size() != 0) {
                        Iterator<HtmlParserManager.a> it = shrinkConvertedItem.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            HtmlParserManager.a next = it.next();
                            if (next != null && next.e() == 1) {
                                linearLayout.findViewById(R$id.screenshot_share_content_gap).setVisibility(0);
                                linearLayout.findViewById(R$id.screenshot_share_content_title_info).setVisibility(0);
                                int i3 = R$id.screenshot_share_content_info;
                                ((TextView) linearLayout.findViewById(i3)).setVisibility(0);
                                ((TextView) linearLayout.findViewById(i3)).setText(next.a());
                                break;
                            }
                        }
                    } else {
                        return popupWindow;
                    }
                } else if (itemViewType == 31) {
                    view = view2;
                    final ProjectBrandAndArtistMultiViewHolder projectBrandAndArtistMultiViewHolder = new ProjectBrandAndArtistMultiViewHolder(g(), linearLayout);
                    ((ViewGroup) view).addView(projectBrandAndArtistMultiViewHolder.itemView);
                    projectBrandAndArtistMultiViewHolder.b(projectDataHolder);
                    if (projectDataHolder != null && !s71.a(projectDataHolder.brandAndArtistsList)) {
                        projectBrandAndArtistMultiViewHolder.itemView.postDelayed(new Runnable() {
                            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass5 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1222734068")) {
                                    ipChange.ipc$dispatch("-1222734068", new Object[]{this});
                                    return;
                                }
                                linearLayout.findViewById(R$id.screenshot_share_content_gap).setVisibility(0);
                                linearLayout.findViewById(R$id.screenshot_share_content_title_artisit).setVisibility(0);
                                ScreenShotImgShare screenShotImgShare = ScreenShotImgShare.this;
                                screenShotImgShare.e(linearLayout, n42.a(screenShotImgShare.g(), 98.0f), projectBrandAndArtistMultiViewHolder.itemView, R$id.screenshot_share_content_img_artisit);
                            }
                        }, 200);
                    }
                } else if (itemViewType != 33) {
                    view = view2;
                } else {
                    final ProjectBrandSingleViewHolder projectBrandSingleViewHolder = new ProjectBrandSingleViewHolder(g(), linearLayout);
                    view = view2;
                    ((ViewGroup) view).addView(projectBrandSingleViewHolder.itemView);
                    if (!(projectDataHolder == null || projectDataHolder.brandOrArtists == null || vv2 == null)) {
                        projectBrandSingleViewHolder.a(projectDataHolder, vv2);
                        projectBrandSingleViewHolder.itemView.postDelayed(new Runnable() {
                            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass4 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1026220563")) {
                                    ipChange.ipc$dispatch("-1026220563", new Object[]{this});
                                    return;
                                }
                                ImageView imageView = (ImageView) projectBrandSingleViewHolder.itemView.findViewById(R$id.brandip_top_imgbg_cover);
                                if (imageView != null) {
                                    imageView.setImageDrawable(new ColorDrawable(-31940));
                                }
                                linearLayout.findViewById(R$id.screenshot_share_content_gap).setVisibility(0);
                                linearLayout.findViewById(R$id.screenshot_share_content_title_brand).setVisibility(0);
                                ScreenShotImgShare screenShotImgShare = ScreenShotImgShare.this;
                                screenShotImgShare.e(linearLayout, n42.a(screenShotImgShare.g(), 98.0f), projectBrandSingleViewHolder.itemView, R$id.screenshot_share_content_imgbrand);
                            }
                        }, 100);
                    }
                }
                i2++;
                view2 = view;
            }
        }
        linearLayout.postDelayed(new Runnable() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1419247573")) {
                    ipChange.ipc$dispatch("-1419247573", new Object[]{this});
                    return;
                }
                int a = a2 - n42.a(ScreenShotImgShare.this.g(), 344.0f);
                int height = view2.findViewById(R$id.screenshot_share_content_ll).getHeight();
                if (height <= a) {
                    a = height;
                }
                View view = view2;
                int i = R$id.screenshot_share_content_scroll_parent;
                ViewGroup.LayoutParams layoutParams = view.findViewById(i).getLayoutParams();
                layoutParams.height = a;
                view2.findViewById(i).setLayoutParams(layoutParams);
                view2.postInvalidate();
            }
        }, 200);
        String str = gu1.productUrl + j + "&from=appshare";
        ((ImageView) linearLayout.findViewById(R$id.screenshot_share_content_qrcode_img)).setImageBitmap(QrcodeUtil.a(v50.a(g(), 40.0f), str));
        view2.postDelayed(new Runnable() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$7$a */
            /* compiled from: Taobao */
            public class a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$7$a$a  reason: collision with other inner class name */
                /* compiled from: Taobao */
                public class C0054a implements OnGrantListener {
                    private static transient /* synthetic */ IpChange $ipChange;

                    C0054a() {
                    }

                    @Override // cn.damai.common.askpermission.OnGrantListener
                    public void onGranted() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "405390143")) {
                            ipChange.ipc$dispatch("405390143", new Object[]{this});
                            return;
                        }
                        AnonymousClass7 r0 = AnonymousClass7.this;
                        ScreenShotImgShare.this.i(ScreenShotImgShare.this.f(scrollView, view2));
                        HashMap hashMap = new HashMap();
                        hashMap.put("usercode", d20.E());
                        hashMap.put("item_id", j + "");
                        cn.damai.common.user.c.e().x(new a.b().i(ta.PROJECT_PAGE).f("screenshot").l("save").g(false).j(hashMap));
                    }
                }

                a() {
                }

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1189786957")) {
                        ipChange.ipc$dispatch("-1189786957", new Object[]{this, view});
                        return;
                    }
                    hp1.b(ScreenShotImgShare.this.g(), false, lp1.STORAGE, "才能保存图片～", new C0054a());
                }
            }

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1615761078")) {
                    ipChange.ipc$dispatch("-1615761078", new Object[]{this});
                    return;
                }
                a aVar = new a();
                view2.findViewById(R$id.detail_screenshot_content_save1).setOnClickListener(aVar);
                view2.findViewById(R$id.detail_screenshot_content_save2).setOnClickListener(aVar);
            }
        }, 100);
        view2.findViewById(R$id.screenshot_share_action).setOnClickListener(new d(scrollView, view2, frameLayout, str, j));
        view2.findViewById(R$id.screenshot_feedback_action).setOnClickListener(new e());
        return popupWindow;
    }

    public void k(Activity activity, Bitmap bitmap, View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146330337")) {
            ipChange.ipc$dispatch("1146330337", new Object[]{this, activity, bitmap, view, str});
            return;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(l01.e(activity)));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            Luban.l(activity).k(l01.e(activity)).n(l01.d(activity)).m(new b(this)).l(new a(str, view, activity)).j();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
