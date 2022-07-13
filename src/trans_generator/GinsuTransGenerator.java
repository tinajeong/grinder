package trans_generator;

import util.CodeUtil;

import java.time.LocalDateTime;

public class GinsuTransGenerator extends TransGenerator {

    LocalDateTime dt = LocalDateTime.of(2021,10,10,12,32,22,3333);
    int paidAmt = 10000;
    int sum = 0;
    int tempIter = 0;
    int paidInCnt = 2;
    String payMethod = "01";
    int methodCnt = 0;

    @Override
    public void act() {
        for (tempIter = 0; tempIter < iterCnt; tempIter++) {
            if (tempIter % 10 == 0) {
                dt = dt.plusDays(1);
            }
            if (methodCnt == 4) methodCnt = 0;
            payMethod = "0" + (methodCnt++ % 4 + 1);
            generateJsonTrans();
        }
    }

    @Override
    public void generateJsonTrans() {
        sum += paidAmt;
        hashMap.put(CodeUtil.trans_date, "" + dt.getYear() + dt.getMonthValue() + (dt.getDayOfMonth() < 10 ? "0" + dt.getDayOfMonth() : dt.getDayOfMonth()));
        hashMap.put(CodeUtil.paid_in_cnt, String.valueOf(paidInCnt++));
        hashMap.put(CodeUtil.pay_method, payMethod);
        hashMap.put(CodeUtil.paid_amt, String.valueOf(paidAmt));

        printJsonTrans(gson.toJson(hashMap));
    }

    @Override
    public void printJsonTrans(String trans) {
        System.out.println(trans);
        System.out.print(",");
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
