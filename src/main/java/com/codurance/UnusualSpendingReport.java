package com.codurance;

import com.codurance.email.EmailSender;

public class UnusualSpendingReport {

    private final PaymentsRepository paymentsRepository;
    private final EmailSender emailSender;

    public UnusualSpendingReport(PaymentsRepository paymentsRepository, EmailSender emailSender) {

        this.paymentsRepository = paymentsRepository;
        this.emailSender = emailSender;
    }

    public void sendReport() {

    }
}
