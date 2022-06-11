package com.polovyi.ivan.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PurchaseTransactionProjection {

    String getId();

    BigDecimal getAmount();

    String getPaymentType();

    LocalDate getCreatedAt();

}
