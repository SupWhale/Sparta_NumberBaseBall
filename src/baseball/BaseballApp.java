package baseball;

import baseball.baseballStatus.BaseballStatus;
import baseball.charaterBaseball.CharacterBaseball;
import baseball.charaterBaseball.CharacterBaseballChecker;
import baseball.numberBaseball.NumberBaseball;
import baseball.numberBaseball.NumberBaseballChecker;

import java.util.*;

public class BaseballApp {

    public static void resultPrint(List<Integer> result, int levelDiff){
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

    public static BaseballStatus start(int inputLevel) throws Exception{
        BaseballStatus baseBallStatus = new BaseballStatus();
        NumberBaseball numberBaseBall = new NumberBaseball();
        CharacterBaseball characterBaseball = new CharacterBaseball();
        Scanner scanner = new Scanner(System.in);

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        System.out.println("0. 자리수 설정 1. 숫자야구 게임 시작하기 2. 문자야구 게임 시작하기  3. 게임 기록 보기  4. 종료하기");
        
        //메뉴를 고를 변수
        String modeInput = scanner.nextLine();

        int levelDiff = inputLevel; //난이도 값, 기본값으로 3이 주어진다.

        switch(modeInput){
            //난이도 설정
            case "0" -> {
                System.out.println("설정할 자릿수를 입력해주세요");
                int checkLevelDiff = scanner.nextInt();
                //자릿수를 3~5만 입력할 수 있게 한다.
                if(checkLevelDiff < 6 && checkLevelDiff > 2){
                    levelDiff = checkLevelDiff;
                    System.out.println("난이도 변경이 완료되었습니다!");
                }
                else System.out.println("제대로된 숫자를 입력하세요");

                baseBallStatus.setStatus("0");
                baseBallStatus.setInputLevel(levelDiff);
                return baseBallStatus;
            }
            //숫자 야구 
            case "1" -> {
                numberBaseBall.setAnswer(levelDiff);
                //result의 구조는 아래과 같다
                //0 : 스트라이크 개수, 1: 볼 개수, 2: 아웃 여부, 3: 시도 횟수
                //result 초기화
                List<Integer> result = new ArrayList<>();
                result.addFirst(0);

                //스트라이크가 설정한 난이도수에 도달할때 까지 계속 반복한다.
                while(result.getFirst() != levelDiff){
                    System.out.println("숫자를 입력하세요");
                    String tryAnswer = scanner.nextLine();
                    //올바른 값이 들어갔는지 체크
                    if(NumberBaseballChecker.checkNumberValue(tryAnswer, levelDiff)) {
                        //올바른 값이라면 비교할 수 있도록 Integer 리스트로 파싱한다.
                        result = numberBaseBall.playBaseball(NumberBaseballChecker.parseNumberList(tryAnswer));
                        baseBallStatus.setResultTry(result.getLast());
                        //결과값을 출력한다.
                        resultPrint(result, levelDiff);
                    }
                    else {
                        System.out.println("숫자 제대로 입력해주세요");
                    }
                }
                baseBallStatus.setStatus("1");
                baseBallStatus.setGameType("숫자야구");
                return baseBallStatus;
            }
            // 문자 야구
            case "2" -> {
                characterBaseball.setAnswer(levelDiff);
                //result의 구조는 아래과 같다
                //0 : 스트라이크 개수, 1: 볼 개수, 2: 아웃 여부, 3: 시도 횟수
                //result 초기화
                List<Integer> result = new ArrayList<>();
                result.addFirst(0);

                //스트라이크가 설정한 난이도수에 도달할때 까지 계속 반복한다.
                while(result.getFirst() != levelDiff){
                    System.out.println("문자를 입력하세요");
                    String tryAnswer = scanner.nextLine();
                    //올바른 값이 들어갔는지 체크
                    if(CharacterBaseballChecker.checkCharacterValue(tryAnswer, levelDiff)) {
                        //올바른 값이라면 비교할 수 있도록 Character 리스트로 파싱한다.
                        result = characterBaseball.playBaseball(CharacterBaseballChecker.parseCharacterList(tryAnswer));
                        baseBallStatus.setResultTry(result.getLast());
                        //결과값을 출력한다.
                        resultPrint(result, levelDiff);
                    }
                    else {
                        System.out.println("문자를 제대로 입력해주세요");
                    }
                }
                baseBallStatus.setStatus("2");
                baseBallStatus.setGameType("문자야구");
                return baseBallStatus;
            }
            //게임 기록 살펴보기
            case "3" -> {
                baseBallStatus.setStatus("3");
                return baseBallStatus;
            }
            //게임 종료하기
            case "4" -> {
                baseBallStatus.setStatus("4");
                return baseBallStatus;
            }
            default -> {
                return baseBallStatus;
            }
        }
    }

}
