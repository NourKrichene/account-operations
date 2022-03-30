package com.crawler.config;

import com.crawler.entity.Operation;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public final class CustomSerdes {
    private CustomSerdes() {
    }

    public static Serde<Operation> OperationSerde() {
        JsonSerializer<Operation> serializer = new JsonSerializer<>();
        JsonDeserializer<Operation> deserializer = new JsonDeserializer<>(Operation.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }
}