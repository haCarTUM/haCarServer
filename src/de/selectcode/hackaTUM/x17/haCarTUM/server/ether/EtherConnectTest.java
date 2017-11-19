package de.selectcode.hackaTUM.x17.haCarTUM.server.ether;

import de.selectcode.hackaTUM.x17.haCarTUM.server.ether.contracts.PayHowYouDriveInsurance;
import org.web3j.tx.Contract;

import java.math.BigInteger;

public class EtherConnectTest {
    public static void main(String[] args) {

        try {
            PayHowYouDriveInsurance contract = (PayHowYouDriveInsurance) EthereumAdapter.getInstance().deployContract(900000000, "0x01114f4Bda09ED6c6715CF0BAf606B5bCE1Dc96a", "0x90b17e30f7f4d92597a7719a0b17906502317d0a", 100, Long.MAX_VALUE);
            System.out.println("Contract deployed successfully. Address:");
            System.out.println(contract.getContractAddress());
            contract.buy(BigInteger.valueOf(900000000)).send();
            System.out.println("Balance is now: "+contract.getBalance().send());
            contract.setDrivingLevel(BigInteger.ONE).send();
            System.out.println("Customer now gets "+contract.bonus().send());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
