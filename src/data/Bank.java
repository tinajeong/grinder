package data;

public class Bank {
    String bankName;
    String apiCode;
    String bankSeq; // 채번용. API의 seq와 다름 
    String response;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getBankSeq() {
        return bankSeq;
    }

    public void setBankSeq(String bankSeq) {
        this.bankSeq = bankSeq;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "bankName='" + bankName + '\'' +
                ", apiCode='" + apiCode + '\'' +
                ", bankSeq='" + bankSeq + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
