package be.dhofief.farmwatchbackend.config;

import com.binance.dex.api.client.BinanceDexApiClientFactory;
import com.binance.dex.api.client.BinanceDexApiNodeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceDexApiConfig {

    @Bean
    public BinanceDexApiNodeClient binanceDexApiNodeClient() {
        return BinanceDexApiClientFactory.newInstance().newNodeRpcClient();
    }

}
