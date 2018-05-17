/**
 * Copyright DingXuan. All Rights Reserved.
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
package org.bcia.javachain.consenter.common.multigroup;

import org.bcia.javachain.common.configtx.IValidator;
import org.bcia.javachain.common.groupconfig.IGroupConfigBundle;
import org.bcia.javachain.common.ledger.blockledger.Reader;
import org.bcia.javachain.common.ledger.blockledger.Writer;
import org.bcia.javachain.common.localmsp.ILocalSigner;
import org.bcia.javachain.consenter.consensus.IReceiver;
import org.bcia.javachain.protos.common.Configtx;

/**
 * @author zhangmingyang
 * @Date: 2018/5/10
 * @company Dingxuan
 */
public interface IBlockWriterSupport extends ILocalSigner,IValidator,Reader,Writer {
    void update(IGroupConfigBundle iGroupConfigBundle);
    IGroupConfigBundle createBundle(String groupId, Configtx.Config config);
}
