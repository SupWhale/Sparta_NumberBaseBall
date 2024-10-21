import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        NumberBaseBall numberBaseBall = new NumberBaseBall();
        NumberBaseBallController numberBaseBallController = new NumberBaseBallController();
        List<NumberBaseBallController> resultList = new ArrayList<>();
        int resultNo = 0;
        numberBaseBallController.setControllStatus("start");

        while(!numberBaseBallController.getControllStatus().equals("3")){
            try{
                numberBaseBallController = NumberBaseballApp.start();
                numberBaseBallController.setResultNo(resultNo += 1);
                System.out.println("시도횟수: " + numberBaseBallController.getResultTry());
                System.out.println(resultNo);
                if(numberBaseBallController.getControllStatus().equals("2")){
                    System.out.println("게임기록보기");
                    for (NumberBaseBallController baseBallController : resultList) {
                        System.out.print(baseBallController.getResultTry() + "번째 게임 :");
                        System.out.println(" 시도 횟수 - " + baseBallController.getResultNo());
                    }
                }
                resultList.add(numberBaseBallController);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}