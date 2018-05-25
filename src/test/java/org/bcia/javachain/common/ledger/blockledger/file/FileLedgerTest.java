/*
 * Copyright Dingxuan. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

		 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.bcia.javachain.common.ledger.blockledger.file;

import com.google.protobuf.ByteString;
import org.bcia.javachain.common.genesis.GenesisBlockFactory;
import org.bcia.javachain.common.ledger.blockledger.ReadWriteBase;
import org.bcia.javachain.common.ledger.blockledger.file.FileLedgerFactory;
import org.bcia.javachain.common.ledger.util.IoUtil;
import org.bcia.javachain.core.ledger.ledgerconfig.LedgerConfig;
import org.bcia.javachain.protos.common.Common;
import org.bcia.javachain.protos.common.Configtx;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * 类描述
 *
 * @author sunzongyu
 * @date 2018/05/24
 * @company Dingxuan
 */
public class FileLedgerTest {
    static final String dir = "/tmp/javachain";
    FileLedgerFactory fileLedgerFactory;
    ReadWriteBase fileLedger;
    @Before
    public void before() throws Exception{
        //重置目录
        System.out.println(deleteDir(new File(dir)));
        //重新生成fileLedgerFactory
        fileLedgerFactory = new FileLedgerFactory(dir);
        //创建file ledger
        fileLedger = fileLedgerFactory.getOrCreate("myGroup");
    }

    @Test
    public void testGetOrCreate() throws Exception{
        Assert.assertNotNull(fileLedger);
        Assert.assertTrue(new File(dir).exists());
        Assert.assertSame(new File(dir).listFiles().length, 2);
        Assert.assertSame(fileLedger.height(), (long) 0);
        Assert.assertEquals(fileLedgerFactory.groupIDs().get(0), "myGroup");
    }

    @Test
    public void testAppend() throws Exception{
        Map<String, File> fileRelativePath;
        GenesisBlockFactory factory = new GenesisBlockFactory(Configtx.ConfigTree.getDefaultInstance());
        Common.Block block = factory.getGenesisBlock("myGroup");
        fileRelativePath = IoUtil.getFileRelativePath(dir);
        Assert.assertSame(fileRelativePath.get("chains/myGroup/blockfile000000").length(), (long) 0);
        fileLedger.append(block);
        fileRelativePath = IoUtil.getFileRelativePath(dir);
        Assert.assertNotSame(fileRelativePath.get("chains/chains/myGroup/blockfile000001").length(), (long) 0);
        byte[] bytes = new byte[1024];
        FileInputStream fis = new FileInputStream(fileRelativePath.get("chains/chains/myGroup/blockfile000001"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int num = 0;
        while((num = fis.read(bytes)) != -1){
            baos.write(bytes, 0, num);
        }
        soutBytes(baos.toByteArray());
    }

    @Test
    public void testHeight() throws Exception{
        Common.Block block;
        Assert.assertSame(fileLedger.height(), (long) 0);
        GenesisBlockFactory factory = new GenesisBlockFactory(Configtx.ConfigTree.getDefaultInstance());
        block = factory.getGenesisBlock("myGroup");
        fileLedger.append(block);
        Assert.assertSame(fileLedger.height(), (long) 1);
        block = Common.Block.newBuilder()
                .setHeader(Common.BlockHeader.newBuilder()
                        .setNumber(1)
                        .build())
                .setMetadata(Common.BlockMetadata.newBuilder()
                        .addMetadata(ByteString.EMPTY)
                        .addMetadata(ByteString.EMPTY)
                        .addMetadata(ByteString.EMPTY)
                        .addMetadata(ByteString.EMPTY)
                        .build())
                .build();
        fileLedger.append(block);
        Assert.assertSame(fileLedger.height(), (long) 2);
    }

    @After
    public void after() throws Exception{}

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    private void soutBytes(byte[] bytes) throws Exception{
        int i = 0;
        for (byte aByte : bytes) {
            i++;
            System.out.print(aByte + "\t");
            if(i > 30){
                System.out.println();
                i = 0;
            }
        }
    }
}