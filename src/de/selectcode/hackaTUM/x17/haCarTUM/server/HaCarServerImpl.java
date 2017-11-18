package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.jws.WebService;

@WebService( endpointInterface= "de.selectcode.hackaTUM.x17.haCarTUM.server.HaCarServer")
public class HaCarServerImpl implements HaCarServer
{
   public String addCustomer(String user) {
      return "Welcome to haCarTUM, " + user;
   }
}