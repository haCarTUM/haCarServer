package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * starts the server
 *
 * @author Matthias Kammueller
 */
@WebService()
public class HelloWorld {
    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        System.out.println(result);
        return result;
    }

    public static void main(String[] argv) {
        Object implementor = new HaCarServerImpl();
        String address = "http://localhost:9000/HaCarTUM";
        Endpoint.publish(address, implementor);
    }
}
