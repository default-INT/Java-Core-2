package by.gstu.models.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Account {
    private String number;
    private double money;

    private Collection<Operation> operations;

    {
        operations = new ArrayList<>();
    }

    public Account(String number) {
        this.number = number;
    }

    public Account(String number, double money) {
        this.number = number;
        depositMoney(money);
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public void depositMoney(double sum) {
        money += sum;
        operations.add(new AdmissionOperation(sum));
    }

    public boolean cashWithdrawal(double sum) {
        if (money >= sum) {
            money -= sum;
            operations.add(new WithdrawalOperation(sum));
            return true;
        }
        return false;
    }

    public boolean commitPayment(double sum) {
        if (money >= sum) {
            money -= sum;
            operations.add(new PaymentOperation(sum));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        operations.forEach(o -> stringBuilder.append(o.toString()).append("\n"));
        return "Номер счёта: " + number + "\n" +
                "Баланс: " + money + "\n" +
                "Список платежей:\n" + stringBuilder.toString();
    }

    private abstract static class Operation {
        protected Date dateOperation;
        protected double sum;

        public Operation() {
            dateOperation = new Date();
        }

        public Operation(double sum) {
            dateOperation = new Date();
            this.sum = sum;
        }

        public Operation(Date date) {
            dateOperation = date;
        }

        public Operation(Date dateOperation, double sum) {
            this.dateOperation = dateOperation;
            this.sum = sum;
        }

        public Date getDateOperation() {
            return dateOperation;
        }
        public void setDateOperation(Date dateOperation) {
            this.dateOperation = dateOperation;
        }
        public double getSum() {
            return sum;
        }
        public void setSum(double sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return new SimpleDateFormat("yyyy-MM-dd | HH:mm:ss | ").format(dateOperation);
        }
    }

    private class WithdrawalOperation extends Operation {

        public WithdrawalOperation() {
            super();
        }

        public WithdrawalOperation(double sum) {
            super(sum);
        }

        public WithdrawalOperation(Date date) {
            super(date);
        }

        public WithdrawalOperation(Date dateOperation, double sum) {
            super(dateOperation, sum);
        }

        @Override
        public String toString() {
            return super.toString() + String.format("снятие со счёта %.2f р.", sum);
        }
    }

    private class PaymentOperation extends Operation {

        public PaymentOperation() {
        }

        public PaymentOperation(double sum) {
            super(sum);
        }

        public PaymentOperation(Date date) {
            super(date);
        }

        public PaymentOperation(Date dateOperation, double sum) {
            super(dateOperation, sum);
        }

        @Override
        public String toString() {
            return super.toString() + String.format("совершён платёж на сумму: %.2f р.", sum);
        }
    }

    private class AdmissionOperation extends Operation {

        public AdmissionOperation() {
        }

        public AdmissionOperation(double sum) {
            super(sum);
        }

        public AdmissionOperation(Date date) {
            super(date);
        }

        public AdmissionOperation(Date dateOperation, double sum) {
            super(dateOperation, sum);
        }

        @Override
        public String toString() {
            return super.toString() + String.format("зачислина сумма: %.2f р.", sum);
        }
    }
}
