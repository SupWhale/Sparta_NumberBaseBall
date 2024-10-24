import baseball.BaseballApp;
import baseball.baseballStatus.BaseballStatus;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BaseballStatus baseballStatus = new BaseballStatus();
        List<BaseballStatus> resultList = new ArrayList<>();
        int resultNo = 0;
        int inputLevel = 3;
        baseballStatus.setStatus("start");

        while(!baseballStatus.getStatus().equals("4")){
            try{
                baseballStatus = BaseballApp.start(inputLevel);
                
                //게임 난이도 수정하기
                if(baseballStatus.getStatus().equals("0")){
                    inputLevel = baseballStatus.getInputLevel();
                }
                //몇번째 게임인지 기록하기
                else if(baseballStatus.getStatus().equals("3")){
                    System.out.println("게임기록보기");
                    for (BaseballStatus baseBallController : resultList) {
                        System.out.print(baseBallController.getGameType() + " | ");
                        System.out.print(baseBallController.getResultNo() + "번째 게임 :");
                        System.out.println(" 시도 횟수 - " + baseBallController.getResultTry());
                    }
                }else{
                    baseballStatus.setResultNo(resultNo += 1);
                    resultList.add(baseballStatus);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}