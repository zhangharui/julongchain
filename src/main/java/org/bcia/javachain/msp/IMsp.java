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
package org.bcia.javachain.msp;

import org.bcia.javachain.msp.entity.IdentityIdentifier;
import org.bcia.javachain.protos.common.MspPrincipal;
import org.bcia.javachain.protos.msp.MspConfigPackage;

/**
 * @author zhangmingyang
 * @Date: 2018/3/8
 * @company Dingxuan
 */
public interface IMsp extends IIdentityDeserializer{
    public void setup(MspConfigPackage.MSPConfig config);

    public int getVersion();

    /**
     * const常量,之后需要确认
     */
     int getType();

     String getIdentifier();

     ISigningIdentity getSigningIdentity(IdentityIdentifier identityIdentifier);

     ISigningIdentity getDefaultSigningIdentity();

     byte[][] getTLSRootCerts();

     byte[][] getTLSIntermediateCerts();

     void validate(IIdentity id);

     void satisfiesPrincipal(IIdentity id, MspPrincipal.MSPPrincipal principal);
}
