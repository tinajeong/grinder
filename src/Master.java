import trans_generator.*;

public class Master {
    public static void main(String[] args) {
        switch (args[0]) {
            case "bank" :
                generateBankTrans();
                break;
            case "irp":
                generateIrpTrans();
                break;
            case "telecom" :
                generateTelecomPaidTrans();
                break;
            case "insu":
                generateInsuTrans();
                break;
            case "ginsu":
                generateGinsuTrans();
                break;
            default :
                System.out.println(args[0] +" is not supported");
        }
    }

    static void generateBankTrans() {
        BankTransGenerator bankTransGenerator = new BankTransGenerator((long)1201000000);
        bankTransGenerator.setIterCount(10);
        bankTransGenerator.act();

        bankTransGenerator.setStartTransDtime((long)1224010014);
        bankTransGenerator.setIterCount(3);
        bankTransGenerator.act();

    }

    static void generateIrpTrans() {
        IrpTransGenerator irpTransGenerator = new IrpTransGenerator();
        irpTransGenerator.setIterCnt(100);
        irpTransGenerator.act();
    }

    static void generateTelecomPaidTrans() {
        TelecomPaidTransGenerator telecomPaidTransGenerator = new TelecomPaidTransGenerator();
        telecomPaidTransGenerator.setIterCnt(100);
        telecomPaidTransGenerator.act();
    }

    static void generateInsuTrans() {
        InsuTransGenerator insuTransGenerator = new InsuTransGenerator();
        insuTransGenerator.setIterCnt(100);
        insuTransGenerator.act();
    }

    static void generateGinsuTrans() {
        GinsuTransGenerator ginsuTransGenerator = new GinsuTransGenerator();
        ginsuTransGenerator.setIterCnt(100);
        ginsuTransGenerator.act();
        System.out.println(ginsuTransGenerator.getSum());
    }
}
