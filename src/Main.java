import NumberBaseball.NumberBaseball;
import NumberBaseball.NumberBaseballController;
import NumberBaseball.NumberBaseballApp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        NumberBaseball numberBaseBall = new NumberBaseball();
        NumberBaseballController numberBaseBallController = new NumberBaseballController();
        List<NumberBaseballController> resultList = new ArrayList<>();
        int resultNo = 0;
        numberBaseBallController.setControlStatus("start");

        while(!numberBaseBallController.getControlStatus().equals("3")){
            try{
                numberBaseBallController = NumberBaseballApp.start();
                //몇번째 게임인지 기록하기
                if(numberBaseBallController.getControlStatus().equals("2")){
                    System.out.println("게임기록보기");
                    for (NumberBaseballController baseBallController : resultList) {
                        System.out.print(baseBallController.getResultNo() + "번째 게임 :");
                        System.out.println(" 시도 횟수 - " + baseBallController.getResultTry());
                    }
                }else{
                    numberBaseBallController.setResultNo(resultNo += 1);
                    resultList.add(numberBaseBallController);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}