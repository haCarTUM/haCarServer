package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.jws.*;

/**
 * Server Interface
 */
@WebService
public interface HaCarServer {
    public String addCustomer(@WebParam(name = "user") String user);
}