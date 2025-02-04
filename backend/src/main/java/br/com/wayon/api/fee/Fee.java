package br.com.wayon.api.fee;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Fee {

    private BigDecimal totalAmount;
    private BigDecimal fixedAmount;
    private BigDecimal percentage;
    private final DecimalFormat df = new DecimalFormat("0.00");

    public void calculate(LocalDate transferDate, Instant schedulingDate, BigDecimal transactionAmount) {

        LocalDate localScheduleDate = schedulingDate.atZone(ZoneId.systemDefault()).toLocalDate();

        long transferDays = ChronoUnit.DAYS.between(localScheduleDate, transferDate);

        if (transferDate.isBefore(localScheduleDate)) {
            throw new PastTransferDateException("Não é permitido agendar uma transferência para uma data passada.");
        }

        if (transferDays == 0) {
            this.fixedAmount = new BigDecimal("3.00");
            this.percentage = new BigDecimal("0.025");
        } else if (transferDays >= 1 && transferDays <= 10) {
            this.fixedAmount = new BigDecimal("12.00");
            this.percentage = BigDecimal.ZERO;
        } else if (transferDays >= 11 && transferDays <= 20) {
            this.fixedAmount = BigDecimal.ZERO;
            this.percentage = new BigDecimal("0.082");
        } else if (transferDays >= 21 && transferDays <= 30) {
            this.fixedAmount = BigDecimal.ZERO;
            this.percentage = new BigDecimal("0.069");
        } else if (transferDays >= 31 && transferDays <= 40) {
            this.fixedAmount = BigDecimal.ZERO;
            this.percentage = new BigDecimal("0.047");
        } else if (transferDays >= 41 && transferDays <= 50) {
            this.fixedAmount = BigDecimal.ZERO;
            this.percentage = new BigDecimal("0.017");
        } else {
            throw new TransferDateInvalidException("Data de transferência fora do intervalo permitido.");
        }

        this.totalAmount = fixedAmount.add(transactionAmount.multiply(percentage));
        String formattedAmount = df.format(this.totalAmount).replace(",", ".");
        this.totalAmount = new BigDecimal(formattedAmount);
    }


    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }
}
