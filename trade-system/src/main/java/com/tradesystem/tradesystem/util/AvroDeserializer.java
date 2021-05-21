package com.tradesystem.tradesystem.util;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

public class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    protected final Class<T> targetType;


    public AvroDeserializer(Class<T> targetType) {

        this.targetType = targetType;
    }

    @Override
    public void configure(Map configs, boolean isKey) {
        // do nothing
    }

    @Override
    public T deserialize(String topic, byte[] bytes) {
        T returnObject = null;

        try {

            if (bytes != null) {
                Schema  schema = new Schema.Parser().parse(AvroDeserializer.class.getResourceAsStream("/trade-schema.avsc"));
                DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
                System.out.println("Schema "+targetType.newInstance().getSchema());
                DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(targetType.newInstance().getSchema());
                //DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
                Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
                returnObject = (T) datumReader.read(null, decoder);
                //returnObject = (T) reader.read(null, decoder);
                log.info("deserialized data='{}'", returnObject.toString());
            }
        } catch (Exception e) {
            log.error("Unable to Deserialize bytes[] ", e);
        }

        return returnObject;
    }

    @Override
    public void close() {
        // do nothing
    }
}
