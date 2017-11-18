package de.selectcode.hackaTUM.x17.haCarTUM.server;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Main {
    public static void main(String[] args) {
        Web3j web3j = Web3j.build(new HttpService(/* TODO: URL */));
        web3j.ethAccounts(); // TODO
    }
}
