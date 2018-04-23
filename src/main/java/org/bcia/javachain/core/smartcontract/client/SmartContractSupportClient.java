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
package org.bcia.javachain.core.smartcontract.client;

import org.bcia.javachain.common.log.JavaChainLog;
import org.bcia.javachain.common.log.JavaChainLogFactory;
import org.bcia.javachain.common.util.CommConstant;
import org.bcia.javachain.core.smartcontract.shim.ISmartContractStub;
import org.bcia.javachain.core.smartcontract.shim.SmartContractBase;
import org.bcia.javachain.core.ssc.cssc.CSSC;
import org.bcia.javachain.core.ssc.essc.ESSC;
import org.bcia.javachain.core.ssc.lssc.LSSC;
import org.bcia.javachain.core.ssc.qssc.QSSC;
import org.bcia.javachain.core.ssc.vssc.VSSC;

/**
 * 类描述
 *
 * @author wanliangbing
 * @date 2018/4/17
 * @company Dingxuan
 */
public class SmartContractSupportClient extends SmartContractBase{

    private static JavaChainLog logger = JavaChainLogFactory.getLog(SmartContractSupportClient.class);

    @Override
    public SmartContractResponse init(ISmartContractStub stub) {
        logger.info("init");
        return newSuccessResponse();
    }

    @Override
    public SmartContractResponse invoke(ISmartContractStub stub) {
        logger.info("invoke");
        return newSuccessResponse();
    }

    @Override
    public String getSmartContractStrDescription() {
        return null;
    }

    public static void main(String[] args) {


        String[] bytes = new String[]{"", ""};

        new Thread() {
            @Override
            public void run() {
                bytes[0] = "-iMySmartContract1";
                SmartContractSupportClient client = new SmartContractSupportClient();
                client.start(bytes);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    bytes[0] = CommConstant.LSSC;
                    LSSC sc = new LSSC();
                    sc.start(bytes);
                } catch(Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    bytes[0] = CommConstant.ESSC;
                    ESSC sc = new ESSC();
                    sc.start(bytes);
                } catch(Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    bytes[0] = CommConstant.CSSC;
                    CSSC sc = new CSSC();
                    sc.start(bytes);
                } catch(Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    bytes[0] = CommConstant.QSSC;
                    QSSC sc = new QSSC();
                    sc.start(bytes);
                } catch(Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    bytes[0] = CommConstant.VSSC;
                    VSSC sc = new VSSC();
                    sc.start(bytes);
                } catch(Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }.start();



    }

}