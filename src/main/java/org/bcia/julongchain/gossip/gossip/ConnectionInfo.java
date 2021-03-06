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
package org.bcia.julongchain.gossip.gossip;

/**
 * class description
 *
 * @author wanliangbing
 * @date 18-7-24
 * @company Dingxuan
 */
public class ConnectionInfo {

    private byte[] pkiID;
    private AuthInfo auth;
    private byte[] nodeIdentity;
    private String endpoint;

    public byte[] getPkiID() {
        return pkiID;
    }

    public void setPkiID(byte[] pkiID) {
        this.pkiID = pkiID;
    }

    public AuthInfo getAuth() {
        return auth;
    }

    public void setAuth(AuthInfo auth) {
        this.auth = auth;
    }

    public byte[] getNodeIdentity() {
        return nodeIdentity;
    }

    public void setNodeIdentity(byte[] nodeIdentity) {
        this.nodeIdentity = nodeIdentity;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
