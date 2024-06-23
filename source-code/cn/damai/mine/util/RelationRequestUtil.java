package cn.damai.mine.util;

import android.content.Context;
import android.content.DialogInterface;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.login.LoginManager;
import cn.damai.mine.relationship.fragment.RelationBaseFragment;
import cn.damai.mine.relationship.net.RelationItemRequest;
import cn.damai.mine.relationship.net.RelationItemResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import tb.yd1;

/* compiled from: Taobao */
public class RelationRequestUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    RelationRequestInter a;

    /* compiled from: Taobao */
    public interface RelationRequestInter {
        void fail(String str, String str2);

        void success(int i, int i2);
    }

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(RelationRequestUtil relationRequestUtil) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834101709")) {
                ipChange.ipc$dispatch("-1834101709", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;

        b(Context context, int i, String str, String str2, int i2, String str3) {
            this.a = context;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = i2;
            this.f = str3;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-864520686")) {
                ipChange.ipc$dispatch("-864520686", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            RelationRequestUtil.this.b(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public RelationRequestUtil(RelationRequestInter relationRequestInter) {
        this.a = relationRequestInter;
    }

    public void a(Context context, int i, String str, String str2, int i2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829541124")) {
            ipChange.ipc$dispatch("1829541124", new Object[]{this, context, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
        } else if (i != 0) {
            try {
                DMDialog dMDialog = new DMDialog(context);
                dMDialog.o(false).q("确认不再关注TA了？");
                dMDialog.i("取消", new a(this));
                dMDialog.n(PurchaseConstants.CONFIRM, new b(context, i, str, str2, i2, str3)).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            b(context, i, str, str2, i2, str3);
        }
    }

    public void b(final Context context, final int i, String str, String str2, final int i2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643898587")) {
            ipChange.ipc$dispatch("1643898587", new Object[]{this, context, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
        } else if (LoginManager.k().q()) {
            if (context != null && (context instanceof DamaiBaseActivity)) {
                ((DamaiBaseActivity) context).startProgressDialog();
            }
            String str4 = "1";
            String str5 = "0";
            if ("fans".equals(str3)) {
                c e = c.e();
                yd1 x = yd1.x();
                if (i != 0) {
                    str4 = str5;
                }
                e.x(x.b0(yd1.FANS_LIST_PAGE, i2, str4, ""));
            } else if ("wantsee".equals(str3)) {
                c e2 = c.e();
                yd1 x2 = yd1.x();
                if (i != 0) {
                    str4 = str5;
                }
                e2.x(x2.c0(i2, str4));
            } else if ("brand".equals(str3)) {
                c e3 = c.e();
                yd1 x3 = yd1.x();
                if (i != 0) {
                    str4 = str5;
                }
                e3.x(x3.b0(yd1.FOLLOW_LIST_PAGE, i2, str4, str5));
            } else if ("star".equals(str3)) {
                c e4 = c.e();
                yd1 x4 = yd1.x();
                if (i == 0) {
                    str5 = str4;
                }
                e4.x(x4.b0(yd1.FOLLOW_LIST_PAGE, i2, str5, str4));
            } else if (RelationBaseFragment.RELATION_TYPE_KIND_COSTOMER.equals(str3)) {
                c e5 = c.e();
                yd1 x5 = yd1.x();
                if (i != 0) {
                    str4 = str5;
                }
                e5.x(x5.b0(yd1.FOLLOW_LIST_PAGE, i2, str4, "2"));
            }
            RelationItemRequest relationItemRequest = new RelationItemRequest();
            if (i == 0) {
                relationItemRequest.operateType = 1;
            } else if (i == 1) {
                relationItemRequest.operateType = 0;
            } else if (i == 2) {
                relationItemRequest.operateType = 0;
            }
            relationItemRequest.targetId = str;
            relationItemRequest.targetType = str2;
            relationItemRequest.request(new DMMtopRequestListener<RelationItemResponse>(RelationItemResponse.class) {
                /* class cn.damai.mine.util.RelationRequestUtil.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1426192676")) {
                        ipChange.ipc$dispatch("1426192676", new Object[]{this, str, str2});
                        return;
                    }
                    Context context = context;
                    if (context != null && (context instanceof DamaiBaseActivity)) {
                        ((DamaiBaseActivity) context).stopProgressDialog();
                    }
                    RelationRequestUtil.this.a.fail(str, str2);
                }

                public void onSuccess(RelationItemResponse relationItemResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-231485072")) {
                        ipChange.ipc$dispatch("-231485072", new Object[]{this, relationItemResponse});
                        return;
                    }
                    Context context = context;
                    if (context != null && (context instanceof DamaiBaseActivity)) {
                        ((DamaiBaseActivity) context).stopProgressDialog();
                    }
                    RelationRequestUtil.this.a.success(i2, relationItemResponse.status);
                    if (i == 0) {
                        ToastUtil.i("关注成功");
                    } else {
                        ToastUtil.i("取消关注成功");
                    }
                }
            });
        } else {
            LoginManager.k().v(context);
        }
    }
}
