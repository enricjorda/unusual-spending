package com.codurance;

import com.codurance.email.EmailSender;

public class UnusualSpending {

    private final PaymentsRepository paymentsRepository;
    private final OverExpenseParser overExpenseParser;

    public UnusualSpending(PaymentsRepository paymentsRepository, OverExpenseParser overExpenseParser) {

        this.paymentsRepository = paymentsRepository;
        this.overExpenseParser = overExpenseParser;
    }

    public void sendReport() {
    }
}
