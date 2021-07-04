package com.credit_calculator.credit_calculator.Interfaces;

import com.credit_calculator.credit_calculator.data.InputCreditData;
import com.credit_calculator.credit_calculator.data.MonthPaymentData;

import java.util.List;

public interface ListPaymentProviderInterface {
   public List<MonthPaymentData> generateListMonthPayments(InputCreditData T);
}
