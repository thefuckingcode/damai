package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: Taobao */
public class HelperReference extends ConstraintReference implements Facade {
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences = new ArrayList<>();
    protected final State mState;
    final State.Helper mType;

    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.mState = state;
        this.mType = helper;
    }

    public HelperReference add(Object... objArr) {
        Collections.addAll(this.mReferences, objArr);
        return this;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference, androidx.constraintlayout.core.state.ConstraintReference
    public void apply() {
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference, androidx.constraintlayout.core.state.ConstraintReference
    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }
}
