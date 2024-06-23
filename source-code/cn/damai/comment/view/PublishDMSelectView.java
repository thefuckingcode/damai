package cn.damai.comment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.DmInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class PublishDMSelectView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final PublishDMListView dmListView;
    @NotNull
    private final PublishDMTagView dmTagListView;
    @Nullable
    private OnItemClickListener onItemClickListener;
    @Nullable
    private DmInfo selectedDm;
    @Nullable
    private Integer selectedDmIndex;

    /* compiled from: Taobao */
    public static final class a implements OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PublishDMSelectView a;

        a(PublishDMSelectView publishDMSelectView) {
            this.a = publishDMSelectView;
        }

        @Override // cn.damai.comment.view.OnItemClickListener
        public void onItemClick(@NotNull View view, int i, @Nullable DmInfo dmInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1802614363")) {
                ipChange.ipc$dispatch("-1802614363", new Object[]{this, view, Integer.valueOf(i), dmInfo});
                return;
            }
            k21.i(view, "itemView");
            this.a.selectedDm = dmInfo;
            this.a.selectedDmIndex = Integer.valueOf(i);
            this.a.dmTagListView.bindData(dmInfo, i);
            OnItemClickListener onItemClickListener = this.a.getOnItemClickListener();
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, i, dmInfo);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMSelectView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishDMSelectView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void bindData(@Nullable List<DmInfo> list, @Nullable DmInfo dmInfo) {
        ArrayList arrayList;
        T t;
        boolean z;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1658441669")) {
            ipChange.ipc$dispatch("1658441669", new Object[]{this, list, dmInfo});
            return;
        }
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.selectedDm = dmInfo;
        if (dmInfo != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                arrayList = null;
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                T t2 = t;
                if ((t2 != null ? t2.getDmId() : null) == null || !k21.d(t2.getDmId(), dmInfo.getDmId())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                t3.dmTags = dmInfo.dmTags;
                ArrayList<String> arrayList2 = t3.allDmTags;
                if (!(arrayList2 == null || dmInfo.dmTags == null)) {
                    k21.f(arrayList2);
                    ArrayList<String> arrayList3 = dmInfo.dmTags;
                    k21.f(arrayList3);
                    Object[] array = CollectionsKt___CollectionsKt.D0(arrayList2, arrayList3).toArray(new String[0]);
                    k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    List list2 = ArraysKt___ArraysKt.X(array);
                    k21.g(list2, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                    ArrayList<String> arrayList4 = (ArrayList) list2;
                    t3.allDmTags = arrayList4;
                    dmInfo.allDmTags = arrayList4;
                }
                this.selectedDm = t3;
            } else {
                ArrayList<String> arrayList5 = dmInfo.allDmTags;
                if (!(arrayList5 == null || dmInfo.dmTags == null)) {
                    k21.f(arrayList5);
                    ArrayList<String> arrayList6 = dmInfo.dmTags;
                    k21.f(arrayList6);
                    Object[] array2 = CollectionsKt___CollectionsKt.D0(arrayList5, arrayList6).toArray(new String[0]);
                    k21.g(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    List list3 = ArraysKt___ArraysKt.X(array2);
                    k21.g(list3, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                    dmInfo.allDmTags = (ArrayList) list3;
                }
                if (list instanceof ArrayList) {
                    arrayList = (ArrayList) list;
                }
                if (arrayList != null) {
                    arrayList.add(0, dmInfo);
                }
            }
        }
        this.dmListView.bindData(list, this.selectedDm);
        DmInfo dmInfo2 = this.selectedDm;
        if (dmInfo2 != null) {
            i = list.indexOf(dmInfo2);
        }
        if (this.selectedDm != null) {
            this.selectedDmIndex = Integer.valueOf(i);
        }
        this.dmTagListView.bindData(this.selectedDm, i);
    }

    @Nullable
    public final OnItemClickListener getOnItemClickListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "534315241")) {
            return this.onItemClickListener;
        }
        return (OnItemClickListener) ipChange.ipc$dispatch("534315241", new Object[]{this});
    }

    @Nullable
    public final DmInfo getSelectedDm() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-688047231")) {
            return this.selectedDm;
        }
        return (DmInfo) ipChange.ipc$dispatch("-688047231", new Object[]{this});
    }

    @Nullable
    public final Integer getSelectedDmIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-695893146")) {
            return this.selectedDmIndex;
        }
        return (Integer) ipChange.ipc$dispatch("-695893146", new Object[]{this});
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2119983431")) {
            ipChange.ipc$dispatch("2119983431", new Object[]{this, onItemClickListener2});
            return;
        }
        this.onItemClickListener = onItemClickListener2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.publish_dm_select_layout, (ViewGroup) this, true);
        setOrientation(1);
        View findViewById = findViewById(R$id.comment_publish_dm_list);
        k21.h(findViewById, "findViewById(R.id.comment_publish_dm_list)");
        PublishDMListView publishDMListView = (PublishDMListView) findViewById;
        this.dmListView = publishDMListView;
        View findViewById2 = findViewById(R$id.comment_publish_dm_tag_container);
        k21.h(findViewById2, "findViewById(R.id.commen…publish_dm_tag_container)");
        this.dmTagListView = (PublishDMTagView) findViewById2;
        publishDMListView.setItemClickListener(new a(this));
    }
}
