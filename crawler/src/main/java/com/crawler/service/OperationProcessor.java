package com.crawler.service;

import com.crawler.config.CustomSerdes;
import com.crawler.entity.Operation;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationProcessor {

    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, Operation> messageStream = streamsBuilder
                .stream("operation-topic", Consumed.with(Serdes.String(), CustomSerdes.OperationSerde()));

        messageStream.foreach((k, e) -> System.out.println("Operation received in stream " + e));
    }
}