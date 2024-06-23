package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class SearchTipViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TIP_LOAD_CUSTOM_CONTENT = 7;
    public static final int TIP_LOAD_MORE = 6;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_tips_content));
    private View b = this.itemView.findViewById(R$id.line);
    private SearchDataHolder c;
    private OnLoadMoreClick d;

    /* compiled from: Taobao */
    public interface OnLoadMoreClick {
        void onLoadMoreBtnClick(@Nullable List<SearchDataHolder> list);
    }

    public SearchTipViewHolder(Context context, LayoutInflater layoutInflater, OnLoadMoreClick onLoadMoreClick) {
        super(layoutInflater.inflate(R$layout.search_list_nodata, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.d = onLoadMoreClick;
    }

    public void a(SearchDataHolder searchDataHolder) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1175906353")) {
            ipChange.ipc$dispatch("1175906353", new Object[]{this, searchDataHolder});
        } else if (searchDataHolder != null) {
            this.c = searchDataHolder;
            int i2 = searchDataHolder.mTipType;
            String str = searchDataHolder.mArtistName;
            boolean z = searchDataHolder.isVisableLine;
            switch (i2) {
                case 1:
                    TextView textView = this.a;
                    textView.setText("没找到“" + str + "”的相关演出(-.-)");
                    break;
                case 2:
                    TextView textView2 = this.a;
                    textView2.setText("“" + str + "”相关演出只有这么多啦(-.-)");
                    break;
                case 3:
                    TextView textView3 = this.a;
                    textView3.setText("没找到近期开演的“" + str + "”(-.-)");
                    break;
                case 4:
                    TextView textView4 = this.a;
                    textView4.setText("哎呀！麦麦没有找到与“" + str + "”的相关演出(-.-)");
                    break;
                case 5:
                    TextView textView5 = this.a;
                    textView5.setText("以下项目可使用“" + str + "”优惠券哦(^з^)-☆");
                    break;
                case 6:
                    this.a.setText("展开更多");
                    break;
                case 7:
                    if (!TextUtils.isEmpty(str)) {
                        this.a.setText(str);
                        break;
                    }
                    break;
            }
            if (i2 == 6) {
                this.a.setTextColor(Color.parseColor("#30AEFF"));
                this.itemView.setOnClickListener(this);
            } else {
                this.a.setTextColor(Color.parseColor("#9C9CA5"));
                this.itemView.setOnClickListener(null);
            }
            View view = this.b;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void onClick(View view) {
        SearchDataHolder searchDataHolder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961910787")) {
            ipChange.ipc$dispatch("1961910787", new Object[]{this, view});
        } else if (this.d != null && (searchDataHolder = this.c) != null) {
            List<SearchDataHolder> list = searchDataHolder.foldProjectList;
            if (searchDataHolder.isProjectEnded && !f92.d(list)) {
                this.c.mTipType = 2;
            }
            this.c.foldProjectList = null;
            this.d.onLoadMoreBtnClick(list);
        }
    }
}
