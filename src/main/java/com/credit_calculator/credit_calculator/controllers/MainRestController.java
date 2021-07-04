package com.credit_calculator.credit_calculator.controllers;




import com.credit_calculator.credit_calculator.Interfaces.ListPaymentProviderInterface;
import com.credit_calculator.credit_calculator.Providers.ListPaymentsProvider;
import com.credit_calculator.credit_calculator.data.MonthPaymentData;
import com.credit_calculator.credit_calculator.data.InputCreditData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class MainRestController {

    @Autowired
    private ListPaymentProviderInterface listPaymentsProvider;

    @RequestMapping(
            value = "/calculateCredit",
            method = RequestMethod.POST)
    @ResponseBody
    public List<MonthPaymentData> main(@RequestBody InputCreditData inputCreditData) throws Exception {
          return listPaymentsProvider.generateListMonthPayments(inputCreditData);
    }

}