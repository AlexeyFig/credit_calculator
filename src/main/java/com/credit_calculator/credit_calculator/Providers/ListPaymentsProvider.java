package com.credit_calculator.credit_calculator.Providers;

import com.credit_calculator.credit_calculator.Interfaces.ListPaymentProviderInterface;
import com.credit_calculator.credit_calculator.Interfaces.RoundNumber;
import com.credit_calculator.credit_calculator.data.InputCreditData;
import com.credit_calculator.credit_calculator.data.MonthPaymentData;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListPaymentsProvider implements ListPaymentProviderInterface {

    private final DateTimeFormatter paymentDateFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
    private final RoundNumber roundNumber = (x) -> x = Math.round(x * 100.0)/100.0;


    public List<MonthPaymentData> generateListMonthPayments(InputCreditData inputCreditData){

        List<MonthPaymentData> listMonthPayments = new ArrayList<>();

        LocalDate paymentDate = LocalDate.now();
        double percentRate = generatePercentRate(inputCreditData.getPercentRate());
        double sumOfDept = inputCreditData.getCreditSum();
        double generatedMonthPayment = generateMonthPayment(inputCreditData, percentRate);

        for (int i=1; i <= inputCreditData.getMonthAmount(); i++){
            paymentDate = paymentDate.plusMonths(1);
            MonthPaymentData newMontPaymentInformation = generateMontPaymentInformation(i,paymentDate,percentRate,sumOfDept
                    ,generatedMonthPayment);
            listMonthPayments.add(newMontPaymentInformation);
            sumOfDept -= newMontPaymentInformation.getBodyPayment();

        }

        return listMonthPayments;

    }

    private double generatePercentRate(double percentRate){
        return percentRate/100/12;
    }

    private double generateMonthPayment(InputCreditData inputcreditData, Double percentRate){
        return roundNumber.round(inputcreditData.getCreditSum() * percentRate /
                (1-Math.pow((1+percentRate),-inputcreditData.getMonthAmount())));
    }

    private MonthPaymentData generateMontPaymentInformation(int numberOfPayment, LocalDate paymentDate, double percentRate,
                                                     double sumOfDept, double generatedMonthPayment){

        String generatedPaymentDate =  generatePaymentDate(paymentDate);

        double percentPayment = generatePercentPayment(sumOfDept,percentRate);
        double bodyPayment = generateBodyPayment(generatedMonthPayment, percentPayment);
        double generatedSumOfDept = generateSumOfDept(bodyPayment, sumOfDept);

        return new MonthPaymentData(
                numberOfPayment,
                generatedPaymentDate ,
                bodyPayment,
                percentPayment,
                generatedSumOfDept,
                generatedMonthPayment
        );

    }

    private double generatePercentPayment(double sumOfDebt, double percentRate){
        return roundNumber.round(sumOfDebt * percentRate);
    }

    private double generateBodyPayment(double monthPayment, double percentPayment){
        return roundNumber.round(monthPayment - percentPayment);
    }

    private double generateSumOfDept(double bodyPayment, double currentSumOfDept){
        return roundNumber.round(currentSumOfDept - bodyPayment);
    }

    private String generatePaymentDate(LocalDate date){
        return paymentDateFormatter.format(date);
    }






}
