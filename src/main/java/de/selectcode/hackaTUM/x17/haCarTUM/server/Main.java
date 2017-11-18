package de.selectcode.hackaTUM.x17.haCarTUM.server;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Web3j web3 = Web3j.build(new HttpService(/* TODO: URL */));
        try {
            final Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();// TODO
            System.out.println("Version " + web3ClientVersion);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
