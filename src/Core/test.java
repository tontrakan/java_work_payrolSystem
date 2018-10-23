/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import com.chilkatsoft.*;
public class test {
    
    static{
        try {
            System.loadLibrary("chilkat");
            
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }
   
    public static void main(String[] args) {
        boolean s;
        CkFileAccess fac = new CkFileAccess();
        String token = fac.readEntireTextFile("/lib/sa-project-token.json","utf-8");
        if(fac.get_LastMethodSuccess()!=true){
        
            System.out.println(fac.lastErrorText());
            return;
            
        }
         CkAuthGoogle gAuth = new CkAuthGoogle();
    gAuth.put_JsonKey(token);

    //  Choose a scope.
    //  The scope could be "https://www.googleapis.com/auth/firebase.database"
    //  or a space-delimited list of scopes:
    //  "https://www.googleapis.com/auth/firebase.database https://www.googleapis.com/auth/userinfo.email"

    gAuth.put_Scope("https://www.googleapis.com/auth/firebase.database https://www.googleapis.com/auth/userinfo.email");

    //  Request an access token that is valid for this many seconds.
    gAuth.put_ExpireNumSeconds(3600);

    //  If the application is requesting delegated access:
    //  The email address of the user for which the application is requesting delegated access,
    //  then set the email address here. (Otherwise leave it empty.)
    gAuth.put_SubEmailAddress("");

    //  Connect to www.googleapis.com using TLS (TLS 1.2 is the default.)
    //  The Chilkat socket object is used so that the connection can be established
    //  through proxies or an SSH tunnel if desired.
    CkSocket tlsSock = new CkSocket();
    boolean success = tlsSock.Connect("www.googleapis.com",443,true,5000);
    if (success != true) {
        System.out.println(tlsSock.lastErrorText());
        return;
        }

    //  Send the request to obtain the access token.
    success = gAuth.ObtainAccessToken(tlsSock);
    if (success != true) {
        System.out.println(gAuth.lastErrorText());
        return;
        }

    //  Examine the access token:
    System.out.println("Firebase Access Token: " + gAuth.accessToken());

    //  Save the token to a file (or wherever desired).  This token is valid for 1 hour.
    fac.WriteEntireTextFile("qa_data/tokens/firebaseToken.txt",gAuth.accessToken(),"utf-8",false);
    }
}
