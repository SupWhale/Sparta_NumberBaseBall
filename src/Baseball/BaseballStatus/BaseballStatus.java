package Baseball.BaseballStatus;

public class BaseballStatus {
    private String Status;
    private int resultTry;
    private int resultNo;


    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getTryResult() {
        return resultTry;
    }

    public void setTryResult(int resultTry) {
        this.resultTry = resultTry;
    }

    public int getResultNo() {
        return resultNo;
    }

    public void setResultNo(int resultNo) {
        this.resultNo = resultNo;
    }
}