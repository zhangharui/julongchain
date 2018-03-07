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
package org.bcia.javachain.core.smartcontract.shim.intfs;

import org.bcia.javachain.core.smartcontract.shim.impl.Response;

/**
 * 智能合约接口
 *
 * @author sunianle
 * @date 2018/2/28
 * @company Dingxuan
 */
public interface ISmartContract {
    /**
     * Called during an instantiate transaction after the container has been
     * established, allowing the chaincode to initialize its internal data.
     */
    public Response init(ISmartContractStub stub);

    /**
     * Called for every Invoke transaction. The chaincode may change its state
     * variables.
     */
    public Response invoke(ISmartContractStub stub);

    /**
     * 获取智能合约ＩＤ
     * @return  智能合约ＩＤ
     */
    public String getSmartContractID();

    /**
     * 获取智能合约的描述
     * @return  智能合约的描述
     */
    public String getSmartContractDescription();
}