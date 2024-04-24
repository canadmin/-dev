import com.example.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentEndpoint {
        private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

        private PaymentRepository paymentRepository;

        @Autowired
        public PaymentEndpoint(PaymentRepository paymentRepository) {
            this.paymentRepository = paymentRepository;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCostAmountByRequest")
        @ResponsePayload
        public GetCostAmountResponse GetCostAmount(@RequestPayload GetCostAmountByRequest request){
            GetCostAmountResponse response= new GetCostAmountResponse();
            response.setCostAmount(paymentRepository.findCalculateCost(request.getTransactionAmount()));
            return response;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPaymentRequest")
        @ResponsePayload
        public GetPaymentResponse GetTransactionStatus(@RequestPayload GetPaymentRequest request){
            GetPaymentResponse response= new GetPaymentResponse();
            response.setTransactionStatus(paymentRepository.findGetTransactionStatus(request.getTransactionReference()));
            return response;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPaymentStatusRequest")
        @ResponsePayload
        public GetPaymentStatusResponse GetTransactionStatus(@RequestPayload GetPaymentStatusRequest request){
            GetPaymentStatusResponse response= new GetPaymentStatusResponse();
            response.setPaymentStatus(paymentRepository.findRetrieveTransactionStatus(request.getTransactionReference()));
            return response;
        }
    }
