/**
 * Copyright Dingxuan. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bcia.javachain.core.ssc.essc;

import org.bcia.javachain.core.smartcontract.shim.impl.Response;
import org.bcia.javachain.core.smartcontract.shim.intfs.ISmartContractStub;
import org.bcia.javachain.core.ssc.SystemSmartContractBase;

/**
 * 背书系统智能合约　Endorse System Smart Contract,ESSC
 *
 * @author sunianle
 * @date 3/5/18
 * @company Dingxuan
 */
public class ESSC  extends SystemSmartContractBase {

    @Override
    public Response init(ISmartContractStub stub) {
        return null;
    }

    @Override
    public Response invoke(ISmartContractStub stub) {
        return null;
    }

    @Override
    public String getSmartContractDescription() {
        return null;
    }

    @Override
    public String getSSCName() {
        return null;
    }

    @Override
    public String getSSCPath() {
        return null;
    }

    @Override
    public byte[][] getInitArgs() {
        return new byte[0][];
    }

    @Override
    public boolean isInvokableExternal() {
        return false;
    }

    @Override
    public boolean isInvokaleSC2SC() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}