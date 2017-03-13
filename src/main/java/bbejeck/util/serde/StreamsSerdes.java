package bbejeck.util.serde;

import bbejeck.collectors.FixedSizePriorityQueue;
import bbejeck.model.CompanyStockVolume;
import bbejeck.model.Purchase;
import bbejeck.model.PurchasePattern;
import bbejeck.model.RewardAccumulator;
import bbejeck.model.StockTickerData;
import bbejeck.model.StockTransaction;
import bbejeck.util.serializer.JsonDeserializer;
import bbejeck.util.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;


public class StreamsSerdes {

    public static Serde<PurchasePattern> PurchasePatternSerde() {
             return new PurchasePatternsSerde();
    }

    public static Serde<RewardAccumulator> RewardAccumulatorSerde() {
        return new RewardAccumulatorSerde();
    }

    public static Serde<Purchase> PurchaseSerde() {
        return new PurchaseSerde();
    }

    public static Serde<StockTickerData> StockTickerSerde() {
        return  new StockTickerSerde();
    }

    public static Serde<StockTransaction> StockTransactionSerde() {
        return new StockTransactionSerde();
    }

    public static Serde<FixedSizePriorityQueue> FixedSizePriorityQueueSerde() {
        return new FixedSizePriorityQueueSerde();
    }

    public static Serde<CompanyStockVolume>  CompanyStockVolumSerde() {
        return new CompanyStockVolumeSerde();
    }


    public static final class PurchasePatternsSerde extends WrapperSerde<PurchasePattern> {
        public PurchasePatternsSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(PurchasePattern.class));
        }
    }

    public static final class RewardAccumulatorSerde extends WrapperSerde<RewardAccumulator> {
        public RewardAccumulatorSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(RewardAccumulator.class));
        }
    }

    public static final class PurchaseSerde extends WrapperSerde<Purchase> {
        public PurchaseSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(Purchase.class));
        }
    }

    public static final class StockTickerSerde extends WrapperSerde<StockTickerData> {
        public StockTickerSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(StockTickerData.class));
        }
    }

    public static final class StockTransactionSerde extends WrapperSerde<StockTransaction> {
        public StockTransactionSerde(){
            super(new JsonSerializer<>(), new JsonDeserializer<>(StockTransaction.class));
        }
    }

    public static final class FixedSizePriorityQueueSerde extends WrapperSerde<FixedSizePriorityQueue> {
        public FixedSizePriorityQueueSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(FixedSizePriorityQueue.class));
        }
    }

    public static final class CompanyStockVolumeSerde extends WrapperSerde<CompanyStockVolume> {
        public CompanyStockVolumeSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(CompanyStockVolume.class));
        }
    }

    private static class WrapperSerde<T> implements Serde<T> {

        private JsonSerializer<T> serializer;
        private JsonDeserializer<T> deserializer;

         WrapperSerde(JsonSerializer<T> serializer, JsonDeserializer<T> deserializer) {
            this.serializer = serializer;
            this.deserializer = deserializer;
        }

        @Override
        public void configure(Map<String, ?> map, boolean b) {

        }

        @Override
        public void close() {

        }

        @Override
        public Serializer<T> serializer() {
           return serializer;
        }

        @Override
        public Deserializer<T> deserializer() {
           return deserializer;
        }
    }
}
