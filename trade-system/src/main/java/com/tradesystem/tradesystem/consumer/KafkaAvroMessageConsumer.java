package com.tradesystem.tradesystem.consumer;

import com.google.gson.Gson;
import com.tradesystem.tradesystem.model.TradeStorePayload;
import com.tradesystem.tradesystem.util.AvroDeserializer;
import com.tradesystems.feeder.schema.TradeStore;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaAvroMessageConsumer {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value(value = "${kafka.feed.topic.name}")
    private String topicName;

    //@Autowired
    private Map<String, Object>  props;

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    @Value(value = "${kafka.feed.topic.userName}")
    private String userName;

    @KafkaListener(topics = "${kafka.feed.topic.name}", groupId = "${kafka.feed.topic.userName}-consumer")
    //public void listen(@Payload TradeStore message) {
    public void listen(String message) {
    //public void listen(ConsumerRecord<String, GenericRecord> record){
        log.info("Topic Name =" +topicName);
        //log.info("Listener value = %s%n", (TradeStore)record.value());
        log.info("Received Messasge in group : {}", message);
        try{
            Gson gson = new Gson();
            TradeStorePayload payload = gson.fromJson(message,TradeStorePayload.class);
            log.info("payload " + payload);
        }catch (Exception exception){
            log.error("Error while parsing " +exception);
        }
    }

    @PostConstruct
    public void init(){
        /*props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        System.out.println("User Name " +userName);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, userName + "-consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);*/
        //consume();
    }

    public void consume() {
        props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        System.out.println("User Name " +userName);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, userName + "-consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        //props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("%s [%d] offset=%d, key=%s, value=\"%s\"\n",
                        record.topic(), record.partition(),
                        record.offset(), record.key(), record.value());
            }
        }
    }
}
