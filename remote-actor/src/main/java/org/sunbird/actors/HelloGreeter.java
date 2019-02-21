package org.sunbird.actors;

import org.sunbird.actor.core.BaseActor;
import org.sunbird.actor.router.ActorConfig;
import org.sunbird.common.models.util.ProjectLogger;
import org.sunbird.common.request.Request;

@ActorConfig(
        tasks = {"printName"},
        asyncTasks = {}
)
public class HelloGreeter extends BaseActor {

    public void onReceive(Request request) throws Throwable {
        ProjectLogger.log("Recieved name");
        printName(request);
    }

    private void printName(Request actorMessage) {
        ProjectLogger.log("PrintName task hit");
        System.out.println("Hello "+ actorMessage.getRequest().get("name"));
    }
}
