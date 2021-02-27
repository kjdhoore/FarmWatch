package be.dhofief.farmwatchbackend.service;

import be.dhofief.farmwatchbackend.repository.SmartChainAccountRepository;
import com.binance.dex.api.client.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SmartChainService {

    private final SmartChainAccountRepository smartChainAccountRepository;

    @Autowired
    public SmartChainService(
            SmartChainAccountRepository smartChainAccountRepository
    ) {
        this.smartChainAccountRepository = smartChainAccountRepository;
    }

    public void doSomething(String address) {
        Optional<Account> account = smartChainAccountRepository.getOne(address);
    }

}
