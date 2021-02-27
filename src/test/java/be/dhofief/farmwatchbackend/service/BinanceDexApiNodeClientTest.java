package be.dhofief.farmwatchbackend.service;

import be.dhofief.farmwatchbackend.config.BinanceDexApiConfig;
import com.binance.dex.api.client.BinanceDexApiNodeClient;
import com.binance.dex.api.client.domain.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BinanceDexApiConfig.class)
@ActiveProfiles("private")
@Disabled
class BinanceDexApiNodeClientTest {

    private static final String INVALID = "invalid";

    @Autowired
    private BinanceDexApiNodeClient binanceDexApiNodeClient;

    @Value("${binance.account.address}")
    private String accountAddress;
    @Value("${binance.account.accountnumber}")
    private Integer accountNumber;
    @Value("${binance.account.sequence}")
    private Long accountSequence;

    @Test
    public void binanceRestApi_isReachable() {
        Account account = binanceDexApiNodeClient.getAccount(INVALID);
        assertThat(account).isNull();
    }

    @Test
    public void binanceRestApi_returnsAccounts() {
        Account account = binanceDexApiNodeClient.getAccount(accountAddress);
        assertThat(account.getAccountNumber()).isEqualTo(accountNumber);
        assertThat(account.getAddress()).isEqualTo(accountAddress);
        assertThat(account.getSequence()).isEqualTo(accountSequence);
    }

}