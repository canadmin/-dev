import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentRepository {

    public BigDecimal findCalculateCost(BigDecimal transactionAmount) {
        return BigDecimal.valueOf(10);
    }

    public String findGetTransactionStatus(String transactionReference) {
        return "SUCCESS";
    }

    public String findRetrieveTransactionStatus(String transactionReference) {
        return "SUCCESS";
    }
}