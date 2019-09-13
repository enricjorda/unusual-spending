package com.codurance;

import com.codurance.email.EmailData;
import com.codurance.email.EmailSender;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class EmailForMonthAcceptanceTest {

    @Test
    void should_receive_an_email_with_the_unusual_expenses_of_the_month() {
        EmailSender emailSender = mock(EmailSender.class);
        PaymentsRepository paymentsRepository = mock(PaymentsRepository.class);

        MonthRange monthRange = new MonthRange(2, 3);
        when(paymentsRepository.fetchMonths(203,monthRange)).thenReturn(getMockedPaymentsForMonth3And2());

        UnusualSpendingReport unusualSpendingReport = new UnusualSpendingReport(paymentsRepository,emailSender);
        unusualSpendingReport.sendReport();

        EmailData emailData = getEmailExpectedData();
        verify(emailSender).send(emailData);
    }

    private ArrayList<Payment> getMockedPaymentsForMonth3And2() {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        payments.add(new Payment(148, "bought on Tesco", "groceries", 3));
        payments.add(new Payment(928, "flight to Brazil", "travel", 3));
        return payments;
    }

    private EmailData getEmailExpectedData() {
        EmailData emailData = new EmailData();
        emailData.setSubject("Unusual spending of $1076 detected!");
        emailData.setBody("Hello card user!\n" +
                "\n" +
                "We have detected unusually high spending on your card in these categories:\n" +
                "\n" +
                "* You spent $148 on groceries\n" +
                "* You spent $928 on travel\n" +
                "\n" +
                "Love,\n" +
                "\n" +
                "The Credit Card Company");
        return emailData;
    }

}
