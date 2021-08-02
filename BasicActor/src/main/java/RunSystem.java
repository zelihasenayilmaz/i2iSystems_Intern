import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.dsl.Creators;

public class RunSystem {
    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("BasiActorSystem");
        ActorRef myActor = system.actorOf(Props.create(MyActor.class));
        ActorRef firstActor = system.actorOf(Props.create(FirstActor.class));

        myActor.tell("MyActor Message", Actor.noSender());
        firstActor.tell("MyActor to FirstActor", myActor);
        firstActor.tell("FirstActor Message", Actor.noSender());

        system.terminate();
    }
}
