package baseball.baseballStatus;

public class BaseballStatus {
    private String status;
    private String gameType;
    private int resultTry;
    private int resultNo;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResultTry() {
        return resultTry;
    }

    public void setResultTry(int resultTry) {
        this.resultTry = resultTry;
    }

    public int getResultNo() {
        return resultNo;
    }

    public void setResultNo(int resultNo) {
        this.resultNo = resultNo;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
}
