package be.dhofief.farmwatchbackend.repository;

import com.binance.dex.api.client.BinanceDexApi;
import com.binance.dex.api.client.BinanceDexApiRestClient;
import com.binance.dex.api.client.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BinanceDEXSmartChainAccountRepository implements SmartChainAccountRepository {

    private BinanceDexApiRestClient binanceDexApiRestClient;

    @Autowired
    public BinanceDEXSmartChainAccountRepository(
            BinanceDexApiRestClient binanceDexApiRestClient
    ){
        this.binanceDexApiRestClient = binanceDexApiRestClient;
    }

    @Override public Optional<Account> getOne(String address) {
        return Optional.of(
                binanceDexApiRestClient.getAccount(address)
        );
    }
}
