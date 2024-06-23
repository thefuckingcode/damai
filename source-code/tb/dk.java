package tb;

import android.text.TextUtils;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class dk {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_COMMENT_EMPTY = 4;
    public static final int TYPE_COMMENT_MAIN = 0;
    public static final int TYPE_COMMENT_MAIN_COMMENT = 2;
    public static final int TYPE_COMMENT_SUBCOMMENT = 3;
    public static final int TYPE_COMMENT_TITLE = 1;
    public static final int TYPE_VCOMMENT_MAIN = 5;

    public static List<fk> a(CommentsResultBean commentsResultBean) {
        List<CommentsItemBean> data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435743703")) {
            return (List) ipChange.ipc$dispatch("-435743703", new Object[]{commentsResultBean});
        }
        ArrayList arrayList = new ArrayList();
        if (!(commentsResultBean == null || (data = commentsResultBean.getData()) == null || data.size() <= 0)) {
            b(data, arrayList);
        }
        return arrayList;
    }

    private static void b(List<CommentsItemBean> list, List<fk> list2) {
        fk fkVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-248509504")) {
            ipChange.ipc$dispatch("-248509504", new Object[]{list, list2});
            return;
        }
        for (CommentsItemBean commentsItemBean : list) {
            if (TextUtils.isEmpty(commentsItemBean.getHasAppend()) || !"true".equals(commentsItemBean.getHasAppend())) {
                fkVar = new fk(2);
                fkVar.A(1);
            } else {
                fkVar = new fk(3);
                fkVar.A(2);
            }
            fkVar.z(false);
            fkVar.q(commentsItemBean);
            list2.add(fkVar);
        }
    }

    public static List<fk> c(CommentsResultBean commentsResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486330902")) {
            return (List) ipChange.ipc$dispatch("-486330902", new Object[]{commentsResultBean});
        }
        ArrayList arrayList = new ArrayList();
        if (commentsResultBean != null) {
            List<CommentsItemBean> data = commentsResultBean.getData();
            if (data == null || data.size() <= 0) {
                arrayList.add(new fk(4));
            } else {
                fk fkVar = new fk(1);
                fkVar.r("大家说(" + commentsResultBean.getTotal() + jl1.BRACKET_END_STR);
                arrayList.add(fkVar);
                b(data, arrayList);
            }
        }
        return arrayList;
    }
}
