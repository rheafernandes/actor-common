package org.sunbird.actors;

import akka.actor.ActorSelection;
import org.sunbird.actor.core.BaseActor;
import org.sunbird.actor.router.ActorConfig;
import org.sunbird.common.models.util.ProjectLogger;
import org.sunbird.common.request.Request;

@ActorConfig(
        tasks = {"sendNames"},
        asyncTasks = {}
)
public class NameSender extends BaseActor {
    public void onReceive(Request request) throws Throwable {
        System.out.println("AYee");
        ProjectLogger.log("Received name");
//        if(request.getOperation().equals("sendNames"))
            sendNames(request);
    }

    private void sendNames(Request actorMessage) {
        ActorSelection selection = getContext().actorSelection("akka.tcp://SunbirdMWSystem@10.0.1.154:8088/user/RequestRouter/*/HelloGreeter");
        ProjectLogger.log("PrintName task hit");
        System.out.println("Testing");
        selection.tell(actorMessage, getSelf());
    }
}
