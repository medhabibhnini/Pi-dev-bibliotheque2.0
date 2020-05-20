/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;

import com.bibliotheque.Entite.Reclamation;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.IOException;

/**
 *
 * @author syrin
 */
public class ServiceReclamation {
    
    public void AddReclamation(Reclamation R) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/addReclamation?idr=" + R.getIdr()+ "&nomr=" + R.getNomr()+ "&sujetr=" + R.getSujetr()+"&idUser=" + ServiceUser.currentUser.getId();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
  
    

   
    
}
