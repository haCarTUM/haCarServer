package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.xml.ws.Endpoint;

/**
 * starts the server
 *
 * @author Matthias Kammueller
 */
public class Server {
    public static void main(String[] argv) {
        InsureDummy company = new InsureDummy();
        HaCarServer implementor = new HaCarServerImpl();
        implementor.setPolicy(company);

        System.out.println("Server is booting ...");
        String address = "http://localhost:9000/HaCarTUM";
        Endpoint.publish(address, implementor);
    }
}
