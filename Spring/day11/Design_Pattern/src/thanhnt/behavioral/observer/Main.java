package thanhnt.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        // create subject
        Topic topic = new Topic();

        // create observers
        Subscriber obj1 = new MyTopicSubscriber("Obj1");
        Subscriber obj2 = new MyTopicSubscriber("Obj2");
        Subscriber obj3 = new MyTopicSubscriber("Obj3");

        // register observers to the subject
        topic.subscribe(obj1);
        topic.subscribe(obj2);
        topic.subscribe(obj3);

        // attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        // check if any update is available
        obj1.update();

        //now send message to subject
        topic.postMessage("New Message");
    }
}
