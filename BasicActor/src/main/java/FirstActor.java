import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class FirstActor extends AbstractActor {

    final ActorRef child = getContext().actorOf(Props.create(MyActor.class), "myChild");

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchAny(x -> getSender().tell(x, getSelf())).build();
    }
}
