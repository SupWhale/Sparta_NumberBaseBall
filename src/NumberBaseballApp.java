import java.util.*;

public class NumberBaseballApp {
    public static NumberBaseBallController start() throws Exception{
        NumberBaseBallController numberBaseBallController = new NumberBaseBallController();
        NumberBaseBall numberBaseBall = new NumberBaseBall();
        Scanner scanner = new Scanner(System.in);

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        System.out.println("0. 자리수 설정 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");

        String modeInput = scanner.nextLine();

        int Level_Diff = 3; //기본값으로 3

        switch(modeInput){
            case "0" -> {
                int Check_Level_Diff = scanner.nextInt();

                if(Check_Level_Diff < 6 && Check_Level_Diff > 2) Level_Diff = Check_Level_Diff;
                else System.out.println("제대로된 숫자를 입력하세요");

                numberBaseBallController.setControllStatus("0");
                return numberBaseBallController;
            }
            case "1" -> {
                numberBaseBall.setAnswer(Level_Diff);
                numberBaseBall.getAnswer();
                //result의 구조는 아래과 같다
                //0 : 스트라이크 개수, 1: 볼 개수, 2: 아웃 여부, 3: 시도 횟수
                //result 초기화
                List<Integer> result = new ArrayList<>();
                result.addFirst(0);

                while(result.getFirst() != Level_Diff){
                    System.out.println("숫자를 입력하세요");
                    String tryAnswer = scanner.nextLine();

                    if(NumberBaseballChecker.checkNumberValue(tryAnswer, Level_Diff)) {
                        result = numberBaseBall.playBaseball(NumberBaseballChecker.parseNumberList(tryAnswer));
                        numberBaseBallController.setResultTry(result.getLast());
                        
                        //스트라이크, 볼 , 아웃이 값이 있을때만 표기하도록한다.
                        if(result.getFirst() != 0) {
                            if(result.getFirst() == Level_Diff){
                                System.out.println("정답입니다!");
                            }else{
                                System.out.println("스트라이크 : " + result.getFirst());
                            }
                        }
                        if(result.get(1) != 0) System.out.println("볼 : " + result.get(1));
                        if(result.get(2) != 0) System.out.println("아웃!");
                    }
                    else {
                        System.out.println("숫자 제대로 입력해주세요");
                    }
                }
                numberBaseBallController.setControllStatus("1");
                return numberBaseBallController;
            }
            case "2" -> {
                numberBaseBallController.setControllStatus("2");
                return numberBaseBallController;
            }
            case "3" -> {
                numberBaseBallController.setControllStatus("3");
                return numberBaseBallController;
            }
            default -> {
                return numberBaseBallController;
            }
        }
    }

}
