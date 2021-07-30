package com.winson.study.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Serializable;
import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author winson
 * @date 2021/7/30
 **/
public class KafkaConsumerDemo {

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.159.131:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, StringDeserializer.class);

//        Stream.of(properties.keySet()).forEach(System.out::println);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        TopicPartition topicPartition = new TopicPartition("winson", 0);
        consumer.assign(Collections.singletonList(topicPartition));
//        consumer.beginningOffsets(Collections.singletonList(topicPartition));
//        consumer.seek(topicPartition, 0);
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));

        for (ConsumerRecord<String, String> record : records) {
            System.out.println("===== start ====== ");
            System.out.println("topic ==> " + record.topic());
            System.out.println("key ==> " + record.key());
            System.out.println("value ==> " + record.value());
            long time = record.timestamp();
            System.out.println("all str ==> " + new Date(time));
            System.out.println("time : " + time);
            System.out.println("now  : " + System.currentTimeMillis());
            System.out.println("=====  end  =====");
        }

        System.out.println("main end");
    }

}
