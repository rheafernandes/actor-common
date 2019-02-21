package org.sunbird; /**
 * @author Rhea Fernandes
 */
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.FromConfig;
import org.sunbird.actor.service.BaseMWService;
import org.sunbird.actor.service.SunbirdMWService;
import org.sunbird.actors.NameSender;
import org.sunbird.common.request.Request;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SunbirdMWService.init();
        Request newRequest = new Request();
        newRequest.setOperation("sendNames");
        Map request = new HashMap<String,Object>();
        request.put("name","Rhea");
        newRequest.setRequest(request);
        SunbirdMWService.tellToRequestRouter(newRequest, ActorRef.noSender());
    }
}
