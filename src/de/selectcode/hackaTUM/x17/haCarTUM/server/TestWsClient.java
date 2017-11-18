package de.selectcode.hackaTUM.x17.haCarTUM.server;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * demo client
 */
public class TestWsClient
{
   public static void main( final String[] args ) throws Throwable
   {
      String url = "http://localhost:9000/HaCarTUM";
      Service service = Service.create(
            new URL( url + "?wsdl" ),
            new QName( "http://serverAPI/", "HalloWeltImplService" ) );
      HaCarServer haCarServer = service.getPort( HaCarServer.class );
      System.out.println( "\n" + haCarServer.addCustomer( "Terror Hitler Ficken" ) );
   }
}