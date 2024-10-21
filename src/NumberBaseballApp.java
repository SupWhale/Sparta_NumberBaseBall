import java.util.*;

public class NumberBaseballApp {
    public static boolean checkNumberValue(List<Integer> vasd){
        boolean asd;
        Set<Integer> set = new HashSet<Integer>(vasd);
        asd = set.size() == vasd.size();
        return asd;
    }
    public static NumberBaseBallController start() throws Exception{
        NumberBaseBallController numberBaseBallController = new NumberBaseBallController();
        NumberBaseBall numberBaseBall = new NumberBaseBall();
        Scanner scanner = new Scanner(System.in);

        String modeInput = scanner.nextLine();

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        System.out.println("0. 자리수 설정 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
        int diff = 3; //기본값으로 3
        switch(modeInput){
            case "0" -> {
                int i = scanner.nextInt();

                if(i < 6 && i > 2) diff = i;
                else System.out.println("제대로된 숫자를 입력하세요");

                numberBaseBallController.setControllStatus("0");
                return numberBaseBallController;
            }
            case "1" -> {
                numberBaseBall.setAnswer(diff);
                numberBaseBall.getAnswer();
                String skip = scanner.nextLine();
                List<Integer> result = new ArrayList<>();
                result.addFirst(0);
                while(result.getFirst() != diff){
                    System.out.println("");
                    System.out.println("숫자를 입력하세요");

                    String valddd = scanner.nextLine();

                    List<String> valddas = List.of(valddd.split(""));
                    int[] val = valddas.stream().mapToInt(Integer::parseInt).toArray();
                    List<Integer> vasd = Arrays.stream(val).boxed().toList();

                    if(checkNumberValue(vasd)) {
                        result = numberBaseBall.playBaseball(vasd);
                        numberBaseBallController.setResultTry(result.getLast());
                        if(result.getFirst() != 0) {
                            if(result.getFirst() == diff){
                                System.out.print("정답입니다!");
                            }else{
                                System.out.print("스트라이크 : " + result.getFirst());
                            }

                        }
                        if(result.get(1) != 0) System.out.println("볼 : " + result.get(1));
                        if(result.get(2) != 0) System.out.println("아웃 : " + result.get(2));
                    }
                    else {
                        System.out.println("숫자 제대로 입력");
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
