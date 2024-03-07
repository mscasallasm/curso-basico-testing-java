package org.platzi.javatest.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);

}
