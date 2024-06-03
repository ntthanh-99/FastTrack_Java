package thanhnt.behavioral.observer;

public interface Publisher {
    //methods to register and unregister observers
    public void subscribe(Subscriber obj);
    public void unsubscribe(Subscriber obj);

    //method to notify observers of change
    public void notifySubscriber();

    //method to get updates from subject
    public Object getUpdate(Subscriber obj);
}
