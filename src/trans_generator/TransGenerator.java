package trans_generator;

import com.google.gson.Gson;

import java.util.HashMap;

public abstract class TransGenerator {
    Gson gson = new Gson();
    HashMap<String,String> hashMap = new HashMap();
    int iterCnt = 50;

    public void act(){
        for(int i=0;i<iterCnt;i++) {
            generateJsonTrans();
        }
    }

    public void generateJsonTrans(){

    }

    public void printJsonTrans(String trans){
        System.out.println(trans);
    }

    public int getIterCnt() {
        return iterCnt;
    }

    public void setIterCnt(int iterCnt) {
        this.iterCnt = iterCnt;
    }
}
