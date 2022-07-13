package trans_generator;

import util.CodeUtil;

public class TelecomPaidTransGenerator extends TransGenerator{

    int oddTransAmt = -9000;
    int evenTransAmt = 9000;
    long transDate = 1105000000;
    String merchantName = "KG 이니시스";
    String oddTransTitle = "결제 취소";
    String evenTransTitle = "결제";
    int tempIter =0;
    @Override
    public void act() {
        for(tempIter=0;tempIter<iterCnt;tempIter++) {
            generateJsonTrans();
        }
    }

    @Override
    public void generateJsonTrans() {
        hashMap.put(CodeUtil.merchant_name,merchantName);
        hashMap.put(CodeUtil.trans_amt,String.valueOf(getProperTransAmt(tempIter)));
        hashMap.put(CodeUtil.trans_title,getProperTransTitle(tempIter));
        hashMap.put(CodeUtil.trans_date,"2021"+String.valueOf(transDate++));
        printJsonTrans(gson.toJson(hashMap));
    }

    @Override
    public void printJsonTrans(String trans) {
        System.out.println(trans);
        System.out.print(',');
    }

    private String getProperTransTitle(int num) {
        return num%2==0? evenTransTitle : oddTransTitle;
    }

    private int getProperTransAmt(int num) {
        return num%2==0? evenTransAmt : oddTransAmt;
    }
}
