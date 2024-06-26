package cn.damai.tetris.component.common;

import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.common.ExpandTextContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ExpandTextView extends AbsView<ExpandTextContract.Presenter> implements ExpandTextContract.View<ExpandTextContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    TextView content;
    TextView expBtn;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2051466370")) {
                ipChange.ipc$dispatch("-2051466370", new Object[]{this, view});
            } else if (ExpandTextView.this.content.getLayout().getEllipsisCount(ExpandTextView.this.content.getLineCount() - 1) > 0) {
                ExpandTextView.this.expBtn.setText("收起");
                ExpandTextView.this.content.setMaxLines(Integer.MAX_VALUE);
            } else {
                ExpandTextView.this.expBtn.setText("展开");
                ExpandTextView.this.content.setMaxLines(4);
            }
        }
    }

    public ExpandTextView(View view) {
        super(view);
        this.content = (TextView) view.findViewById(R$id.common_exptext_content);
        TextView textView = (TextView) view.findViewById(R$id.common_exptext_btn);
        this.expBtn = textView;
        textView.setOnClickListener(new a());
    }

    @Override // cn.damai.tetris.component.common.ExpandTextContract.View
    public TextView getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1217730321")) {
            return this.content;
        }
        return (TextView) ipChange.ipc$dispatch("1217730321", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.ExpandTextContract.View
    public TextView getExtBtn() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1985962707")) {
            return this.expBtn;
        }
        return (TextView) ipChange.ipc$dispatch("-1985962707", new Object[]{this});
    }
}
