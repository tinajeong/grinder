package trans_generator;

import util.CodeUtil;

public class IrpTransGenerator extends TransGenerator{

    String transDtime = "20211104";
    int transNo = 1;
    String transType ="01";
    int transAmt = 100;

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void generateJsonTrans() {
        hashMap.put(CodeUtil.trans_dtime,transDtime);
        hashMap.put(CodeUtil.trans_no,String.valueOf(++transNo));
        hashMap.put(CodeUtil.trans_type,transType);
        hashMap.put(CodeUtil.trans_amt,String.valueOf(transAmt));

        printJsonTrans(gson.toJson(hashMap));
    }

    @Override
    public void printJsonTrans(String trans) {
        System.out.println(trans);
        System.out.print(",");
    }
}
