package de.selectcode.hackaTUM.x17.haCarTUM.server.ether;

import de.selectcode.hackaTUM.x17.haCarTUM.server.ether.contracts.PayHowYouDriveInsurance;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ManagedTransaction;

import java.math.BigInteger;

public class EtherConnectTest {
    public static void main(String[] args) {
        Web3j web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/IU8iPEXDIjDgnNsZVZVM"));

        Credentials creds = null;
        try {
            creds = WalletUtils.loadCredentials("asdf", "baum");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
