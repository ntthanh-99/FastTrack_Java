package thanhnt.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Publisher {
    private final Object MUTEX = new Object();
    private List<Subscriber> publishers;
    private String message;
    private boolean changed;

    public Topic() {
        this.publishers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!publishers.contains(obj)){
                publishers.add(obj);
            }
        }
    }

    @Override
    public void unsubscribe(Subscriber obj) {
        synchronized (MUTEX) {
            publishers.remove(obj);
        }
    }

    @Override
    public void notifySubscriber() {
        List<Subscriber> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.publishers);
            this.changed = false;
        }
        for (Subscriber obj : observersLocal) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Subscriber obj) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.changed = true;
        notifySubscriber();
    }
}
