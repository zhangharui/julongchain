package org.bcia.javachain.core.endorser;

import org.bcia.javachain.BaseJunit4Test;
import org.bcia.javachain.common.exception.NodeException;
import org.bcia.javachain.common.resourceconfig.ISmartContractDefinition;
import org.bcia.javachain.protos.node.ProposalPackage;
import org.bcia.javachain.protos.node.ProposalResponsePackage;
import org.bcia.javachain.protos.node.SmartContractEventPackage;
import org.bcia.javachain.protos.node.Smartcontract;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 对象
 *
 * @author zhouhui
 * @date 2018/3/29
 * @company Dingxuan
 */
public class EndorserTest extends BaseJunit4Test {
    @Autowired
    private Endorser endorser;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void processProposal() {
    }

    @Test
    public void getEndorserSupport() {
    }

    @Test
    public void setEndorserSupport() {
    }

    @Test
    public void endorseProposal() throws NodeException {
        String groupId = "mygroup";
        String txId = "txId1";
        ProposalPackage.Proposal proposal = ProposalPackage.Proposal.newBuilder().build();
        ProposalPackage.SignedProposal signedProposal = ProposalPackage.SignedProposal.newBuilder().build();
        Smartcontract.SmartContractID.Builder smartContractIDBuilder = Smartcontract.SmartContractID.newBuilder();
        ProposalResponsePackage.Response response = ProposalResponsePackage.Response.newBuilder().build();
        SmartContractEventPackage.SmartContractEvent event = SmartContractEventPackage.SmartContractEvent.newBuilder
                ().build();
        byte[] simulateResults = new byte[]{0, 1, 2};
        byte[] visibility = new byte[]{3, 4, 5};
        ISmartContractDefinition smartContractDefinition = new MockSmartContractDefinition();

        endorser.endorseProposal(groupId, txId, signedProposal, proposal, smartContractIDBuilder, response,
                simulateResults, event, visibility, smartContractDefinition);
    }
}