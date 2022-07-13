package trans_generator;

import util.CodeUtil;

import java.time.LocalDateTime;

public class InsuTransGenerator extends TransGenerator{


    LocalDateTime dt = LocalDateTime.now();
    int transDate = 20211108;
    String transAppliedMonth = String.valueOf(dt.getYear())+dt.getMonthValue();
    int paidAmt = 10000;
    int tempIter =0;
    int paidInCnt = 1;
    String payMethod = "01";
    int methodCnt = 0;

    @Override
    public void act() {
       for(tempIter =0;tempIter<iterCnt;tempIter++) {
           if(tempIter%10==0) transDate++;
           dt = dt.plusMonths(1);
           transAppliedMonth = getTransAppliedMonth();
           if(methodCnt==4) methodCnt =0;
           payMethod = "0"+(methodCnt++%4+1);
           generateJsonTrans();
       }
    }

    @Override
    public void generateJsonTrans() {
        hashMap.put(CodeUtil.trans_date,String.valueOf(transDate));
        hashMap.put(CodeUtil.trans_applied_month,transAppliedMonth);
        hashMap.put(CodeUtil.paid_in_cnt,String.valueOf(paidInCnt++));
        hashMap.put(CodeUtil.pay_method,payMethod);
        hashMap.put(CodeUtil.paid_amt,String.valueOf(paidAmt));

        printJsonTrans(gson.toJson(hashMap));
    }

    @Override
    public void printJsonTrans(String trans) {
        System.out.println(trans);
        System.out.print(",");
    }

    @Override
    public int getIterCnt() {
        return super.getIterCnt();
    }

    @Override
    public void setIterCnt(int iterCnt) {
        super.setIterCnt(iterCnt);
    }

    private String getTransAppliedMonth() {
        dt = dt.plusMonths(1);
        return String.valueOf(dt.getYear())+(dt.getMonthValue()<10? "0"+dt.getMonthValue():dt.getMonthValue());
    }
}
