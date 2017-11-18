package de.selectcode.hackaTUM.x17.haCarTUM.server.ether;

import de.selectcode.hackaTUM.x17.haCarTUM.server.ether.contracts.PayHowYouDriveInsurance;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ManagedTransaction;

import java.math.BigInteger;

public class EthereumAdapter {

    private static EthereumAdapter instance;
    private final Credentials creds;
    private Web3j web = Web3j.build(new HttpService("https://rinkeby.infura.io/IU8iPEXDIjDgnNsZVZVM"));

    private EthereumAdapter() {
        creds = WalletUtils.loadCredentials();
    }

    public static EthereumAdapter getIntance() {
        if (instance == null)
            instance = new EthereumAdapter();
        return instance;
    }

    public String deployContract(long payment, String carAddress, String costumerAddress, long bonus, long max) throws Exception {
        PayHowYouDriveInsurance contract = PayHowYouDriveInsurance.deploy(web, creds, ManagedTransaction.GAS_PRICE,
                BigInteger.valueOf(999999), BigInteger.valueOf(payment), costumerAddress, carAddress, BigInteger.valueOf(bonus),
                BigInteger.valueOf(max)).send();

        return contract.getContractAddress();
    }
}
