package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

/* compiled from: Taobao */
public class Cache {
    Pools.Pool<ArrayRow> arrayRowPool = new Pools.SimplePool(256);
    SolverVariable[] mIndexedVariables = new SolverVariable[32];
    Pools.Pool<ArrayRow> optimizedArrayRowPool = new Pools.SimplePool(256);
    Pools.Pool<SolverVariable> solverVariablePool = new Pools.SimplePool(256);
}
