package thanhnt.behavioral.observer;

public interface Publisher {
    //methods to register and unregister observers
    void subscribe(Subscriber obj);

    void unsubscribe(Subscriber obj);

    //method to notify observers of change
    void notifySubscriber();

    //method to get updates from subject
    Object getUpdate(Subscriber obj);
}
