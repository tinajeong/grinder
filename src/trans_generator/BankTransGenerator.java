package trans_generator;

import com.google.gson.Gson;

import java.util.HashMap;

public class BankTransGenerator {
    long startTransDtime = 1001000000;
    String transNo = "";
    String transType ="02";
    String transClass = "출금";
    String currencyCode = "";
    int transAmt = 100;
    int balanceAmt = 11999986;
    int paidInCnt = 0;
    String transMemo = "1원 테스트";
    private static final String year = "2022";
    int iterCount = 10;

    private Gson gson = new Gson();
    private HashMap<String,String> hashMap = new HashMap();
    public BankTransGenerator() {
    }

    public BankTransGenerator(int iterCount) {
        this.iterCount = iterCount;
    }

    public BankTransGenerator(long startTransDtime) {
        this.startTransDtime = startTransDtime;
    }

    public void act() {
        for(int i=0;i<iterCount;i++) {
            generateJsonTrans();
        }
    }
    private void generateJsonTrans() {

        hashMap.put("trans_dtime",year+startTransDtime);
        startTransDtime+=100;
        hashMap.put("trans_no",transNo);
        hashMap.put("trans_type",transType);
        hashMap.put("trans_class",transClass);
        hashMap.put("currency_code",currencyCode);
        hashMap.put("trans_amt","1");
        hashMap.put("balance_amt",""+balanceAmt--);
//        hashMap.put("paid_in_cnt","");
        hashMap.put("trans_memo",transMemo);

        printJsonTrans(gson.toJson(hashMap));

    }
    private void printJsonTrans(String trans) {
        System.out.println(trans);
        System.out.print(",");
    }

    public int getIterCount() {
        return iterCount;
    }

    public void setIterCount(int iterCount) {
        this.iterCount = iterCount;
    }

    public long getStartTransDtime() {
        return startTransDtime;
    }

    public void setStartTransDtime(long startTransDtime) {
        this.startTransDtime = startTransDtime;
    }
}
