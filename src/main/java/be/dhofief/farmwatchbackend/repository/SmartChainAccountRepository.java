package be.dhofief.farmwatchbackend.repository;

import com.binance.dex.api.client.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface SmartChainAccountRepository {

    Optional<Account> getOne(String address);

}
