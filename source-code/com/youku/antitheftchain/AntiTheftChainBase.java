package com.youku.antitheftchain;

import com.youku.antitheftchain.encrypt.EncryptAbility;
import com.youku.antitheftchain.encrypt.EncryptAbilityImpl;
import com.youku.antitheftchain.interfaces.AntiTheftChain;

/* compiled from: Taobao */
public abstract class AntiTheftChainBase implements AntiTheftChain {
    protected EncryptAbility encryptAbility = new EncryptAbilityImpl();
}
