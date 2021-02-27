package be.dhofief.farmwatchbackend.repository;

import com.binance.dex.api.client.BinanceDexApi;
import com.binance.dex.api.client.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BinanceDexApiSmartChainAccountRepository {

    private BinanceDexApi binanceDexApi;
    private ResponseToOptionalConverter responseToOptionalConverter;

    @Autowired
    public BinanceDexApiSmartChainAccountRepository(
            BinanceDexApi binanceDexApi
    ){
        this.binanceDexApi = binanceDexApi;
    }

    public Optional<Account> getOne(String address){
        return binanceDexApi.getAccount(address).execute().
    }

}
