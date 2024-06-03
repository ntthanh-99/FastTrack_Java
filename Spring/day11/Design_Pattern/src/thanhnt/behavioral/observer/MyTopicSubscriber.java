package thanhnt.behavioral.observer;

public class MyTopicSubscriber implements Subscriber {
    private String name;
    private Publisher topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }

    @Override
    public void setSubject(Publisher topic) {
        this.topic = topic;
    }
}
