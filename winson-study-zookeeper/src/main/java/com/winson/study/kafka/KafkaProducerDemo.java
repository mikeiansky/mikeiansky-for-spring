package com.winson.study.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author winson
 * @date 2021/7/30
 **/
public class KafkaProducerDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ProducerRecord<String,String> record = new ProducerRecord<String, String>("winson", "from-intellij 2");

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.159.131:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

        Future<RecordMetadata> result1 = producer.send(record);
//        Future<RecordMetadata> result2 = producer.send(record);

        System.out.println("send result1 : " + result1.get());
//        System.out.println("send result2 : " + result2.get());

        System.out.println("main end ... ");


    }

}
