package com.thanhnt.lession5;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Lession5Application {

    public static void main(String[] args) throws MqttException, InterruptedException {
        SpringApplication.run(Lession5Application.class, args);

        String publisherId = UUID.randomUUID().toString();
        //IMqttClient publisher = new MqttClient("tcp://iot.eclipse.org:1883", publisherId);
        IMqttClient publisher = new MqttClient("tcp://broker.hivemq.com:1883", publisherId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        publisher.connect(options);

        CountDownLatch receivedSignal = new CountDownLatch(10);
        publisher.subscribe(EngineTemperatureSensor.TOPIC, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            // ... payload handling omitted
            System.out.println(topic);
            System.out.println(new String(payload));

            receivedSignal.countDown();
        });
        receivedSignal.await(1, TimeUnit.MINUTES);
    }
}
