package Baseball;

import Baseball.BaseballStatus.BaseballStatus;
import Baseball.CharaterBaseball.CharaterBaseball;
import Baseball.CharaterBaseball.CharacterBaseballChecker;
import Baseball.NumberBaseball.NumberBaseball;
import Baseball.NumberBaseball.NumberBaseballChecker;

import java.util.*;

public class BaseballApp {
    public static BaseballStatus start() throws Exception{
        BaseballStatus baseBallStatus = new BaseballStatus();
        NumberBaseball numberBaseBall = new NumberBaseball();
        CharaterBaseball charaterBaseball = new CharaterBaseball();
        Scanner scanner = new Scanner(System.in);

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        System.out.println("0. 자리수 설정 1. 숫자야구 게임 시작하기 2. 문자야구 게임 시작하기  3. 게임 기록 보기  4. 종료하기");

        String modeInput = scanner.nextLine();

        int levelDiff = 3; //기본값으로 3

        switch(modeInput){
            case "0" -> {
                int checkLevelDiff = scanner.nextInt();

                if(checkLevelDiff < 6 && checkLevelDiff > 2) levelDiff = checkLevelDiff;
                else System.out.println("제대로된 숫자를 입력하세요");

                baseBallStatus.setControlStatus("0");
                return baseBallStatus;
            }
            case "1" -> {
                numberBaseBall.setAnswer(levelDiff);
                numberBaseBall.getAnswer();
                //result의 구조는 아래과 같다
                //0 : 스트라이크 개수, 1: 볼 개수, 2: 아웃 여부, 3: 시도 횟수
                //result 초기화
                List<Integer> result = new ArrayList<>();
                result.addFirst(0);

                while(result.getFirst() != levelDiff){
                    System.out.println("숫자를 입력하세요");
                    String tryAnswer = scanner.nextLine();

                    if(NumberBaseballChecker.checkNumberValue(tryAnswer, levelDiff)) {
                        result = numberBaseBall.playBaseball(NumberBaseballChecker.parseNumberList(tryAnswer));
                        baseBallStatus.setResultTry(result.getLast());

                        //스트라이크, 볼 , 아웃이 값이 있을때만 표기하도록한다.
                        if(result.getFirst() != 0) {
                            if(result.getFirst() == levelDiff){
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
                baseBallStatus.setControlStatus("1");
                return baseBallStatus;
            }
            case "2" -> {
                charaterBaseball.setAnswer(levelDiff);
                charaterBaseball.getAnswer();
                //result의 구조는 아래과 같다
                //0 : 스트라이크 개수, 1: 볼 개수, 2: 아웃 여부, 3: 시도 횟수
                //result 초기화
                List<Integer> result = new ArrayList<>();
                result.addFirst(0);

                while(result.getFirst() != levelDiff){
                    System.out.println("문자를 입력하세요");
                    String tryAnswer = scanner.nextLine();

                    if(CharacterBaseballChecker.checkCharacterValue(tryAnswer, levelDiff)) {
                        result = charaterBaseball.playBaseball(CharacterBaseballChecker.parseCharacterList(tryAnswer));
                        baseBallStatus.setResultTry(result.getLast());

                        //스트라이크, 볼 , 아웃이 값이 있을때만 표기하도록한다.
                        if(result.getFirst() != 0) {
                            if(result.getFirst() == levelDiff){
                                System.out.println("정답입니다!");
                            }else{
                                System.out.println("스트라이크 : " + result.getFirst());
                            }
                        }
                        if(result.get(1) != 0) System.out.println("볼 : " + result.get(1));
                        if(result.get(2) != 0) System.out.println("아웃!");
                    }
                    else {
                        System.out.println("문자를 제대로 입력해주세요");
                    }
                }
                baseBallStatus.setControlStatus("1");
                return baseBallStatus;
            }
            case "3" -> {
                baseBallStatus.setControlStatus("2");
                return baseBallStatus;
            }
            case "4" -> {
                baseBallStatus.setControlStatus("3");
                return baseBallStatus;
            }
            default -> {
                return baseBallStatus;
            }
        }
    }

}
