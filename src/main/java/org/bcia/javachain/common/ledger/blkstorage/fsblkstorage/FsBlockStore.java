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
package org.bcia.javachain.common.ledger.blkstorage.fsblkstorage;

import org.bcia.javachain.common.exception.LedgerException;
import org.bcia.javachain.common.ledger.ResultsIterator;
import org.bcia.javachain.common.ledger.blkstorage.BlockStore;
import org.bcia.javachain.common.ledger.blkstorage.IndexConfig;
import org.bcia.javachain.common.ledger.util.DBProvider;
import org.bcia.javachain.common.ledger.util.leveldbhelper.LevelDBHandle;
import org.bcia.javachain.common.ledger.util.leveldbhelper.LevelDbProvider;
import org.bcia.javachain.core.ledger.BlockAndPvtData;
import org.bcia.javachain.protos.common.Common;
import org.bcia.javachain.protos.common.Ledger;
import org.bcia.javachain.protos.node.TransactionPackage;

/**
 * 区块文件系统
 *
 * @author sunzongyu
 * @date 2018/4/19
 * @company Dingxuan
 */
public class FsBlockStore implements BlockStore {

    private String id;
    private Conf conf;
    private BlockfileMgr blockfileMgr;

    public static FsBlockStore newFsBlockStore(String id,
                                               Conf conf,
                                               IndexConfig indexConfig,
                                               DBProvider dbHandle) throws LedgerException {
        FsBlockStore fsBlockStore = new FsBlockStore();
        BlockfileMgr mgr = BlockfileMgr.newBlockfileMgr(id, conf, indexConfig, dbHandle);
        fsBlockStore.setId(id);
        fsBlockStore.setConf(conf);
        fsBlockStore.setBlockfileMgr(mgr);
        return fsBlockStore;
    }

    @Override
    public void addBlock(Common.Block block) throws LedgerException {
        blockfileMgr.addBlock(block);
    }

    @Override
    public Ledger.BlockchainInfo getBlockchainInfo() throws LedgerException {
        return blockfileMgr.getBlockchainInfo();
    }

    @Override
    public ResultsIterator retrieveBlocks(long startBlockNumber) throws LedgerException {
        return blockfileMgr.retrieveBlocks(startBlockNumber);
    }

    @Override
    public Common.Block retrieveBlockByHash(byte[] blockHash) throws LedgerException {
        return blockfileMgr.retrieveBlockByHash(blockHash);
    }

    @Override
    public Common.Block retrieveBlockByNumber(Long blockNum) throws LedgerException {
        return blockfileMgr.retrieveBlockByNumber(blockNum);
    }

    @Override
    public Common.Envelope retrieveTxByID(String txID) throws LedgerException {
        return blockfileMgr.retrieveTransactionByID(txID);
    }

    @Override
    public Common.Envelope retrieveTxByBlockNumTranNum(Long blockNum, Long tranNum) throws LedgerException {
        return blockfileMgr.retrieveTransactionByBlockNumTranNum(blockNum, tranNum);
    }

    @Override
    public Common.Block retrieveBlockByTxID(String txID) throws LedgerException {
        return blockfileMgr.retrieveBlockByTxID(txID);
    }

    @Override
    public TransactionPackage.TxValidationCode retrieveTxValidationCodeByTxID(String txID) throws LedgerException {
        return blockfileMgr.retrieveTxValidationCodeByTxID(txID);
    }

    ResultsIterator RetrieveBlocks(Long startNum) {
        return null;
    }

    Common.Block RetrieveBlockByHash(byte[] blockHash) {
        return null;
    }

    Common.Block RetrieveBlockByNumber(Long blockNum) {
        return null;
    }

    Common.Envelope RetrieveTxByID(String txID) {
        return null;
    }

    Common.Envelope RetrieveTxByBlockNumTranNum(Long blockNum, Long tranNum) {
        return null;
    }

    Common.Block RetrieveBlockByTxID(String txID) {
        return null;
    }

    TransactionPackage.TxValidationCode RetrieveTxValidationCodeByTxID(String txID) {
        return null;
    }

    @Override
    public void shutdown() {
        blockfileMgr.close();
    }

    @Override
    public void commitWithPvtData(BlockAndPvtData blockAndPvtData) throws LedgerException {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Conf getConf() {
        return conf;
    }

    public void setConf(Conf conf) {
        this.conf = conf;
    }

    public BlockfileMgr getBlockfileMgr() {
        return blockfileMgr;
    }

    public void setBlockfileMgr(BlockfileMgr blockfileMgr) {
        this.blockfileMgr = blockfileMgr;
    }
}
