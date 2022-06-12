package com.polovyi.ivan.projection;

import java.time.LocalDate;

public interface PurchaseTransactionProjection {

    String getId();

    String getPaymentType();

    LocalDate getCreatedAt();

}
