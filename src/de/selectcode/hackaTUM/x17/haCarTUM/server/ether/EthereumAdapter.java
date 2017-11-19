package de.selectcode.hackaTUM.x17.haCarTUM.server.ether;

import de.selectcode.hackaTUM.x17.haCarTUM.server.ether.contracts.PayHowYouDriveInsurance;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.io.IOException;
import java.math.BigInteger;

public class EthereumAdapter {

    private static EthereumAdapter instance;
    private Credentials creds = null;
    private Web3j web = Web3j.build(new HttpService("https://rinkeby.infura.io/IU8iPEXDIjDgnNsZVZVM"));

    private EthereumAdapter() {
        try {
            creds = WalletUtils.loadCredentials("asdf", "C:\\Users\\matth\\hackatum\\haCarServer\\src\\de\\selectcode\\hackaTUM\\x17\\haCarTUM\\resources\\UTC--2017-11-18T15-55-20.685969800Z--90b17e30f7f4d92597a7719a0b17906502317d0a");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
    }


    public static EthereumAdapter getInstance() {
        if (instance == null)
            instance = new EthereumAdapter();
        return instance;
    }

    /**
     * Creates a new contract and deploys it to the blockchain
     *
     * @param payment
     * @param carAddress
     * @param costumerAddress
     * @param bonus
     * @param max
     * @return The contracts address
     * @throws Exception
     */
    public Contract deployContract(long payment, String carAddress, String costumerAddress, long bonus, long max) throws Exception {
        PayHowYouDriveInsurance contract = PayHowYouDriveInsurance.deploy(web, creds, ManagedTransaction.GAS_PRICE,
                BigInteger.valueOf(999999), BigInteger.valueOf(payment), costumerAddress, carAddress, BigInteger.valueOf(bonus),
                BigInteger.valueOf(max)).send();

        return contract;
    }
}
