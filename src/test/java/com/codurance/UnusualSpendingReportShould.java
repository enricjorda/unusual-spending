package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class UnusualSpendingReportShould {

    @Test
    void filter_over_expenses_by_category () {

        PaymentsRepository paymentsRepository = mock(PaymentsRepository.class);
        MonthRange monthRange = new MonthRange(2, 3);
        ArrayList<Payment> payments = new ArrayList<Payment>();
        payments.add(new Payment(10, "bought on Tesco", "groceries", 3));
        when(paymentsRepository.fetchMonths(203,monthRange)).thenReturn(payments);
        OverExpenseParser overExpenseParser = mock(OverExpenseParser.class);
        UnusualSpending unusualSpending = new UnusualSpending(paymentsRepository,overExpenseParser);

        unusualSpending.sendReport();

        ArrayList <OverExpenses> expensesByCategory = new ArrayList<OverExpenses>();
        expensesByCategory.add(new OverExpenses(203, "groceries"));
        verify(overExpenseParser).sendExpenses(expensesByCategory);
    }


}
