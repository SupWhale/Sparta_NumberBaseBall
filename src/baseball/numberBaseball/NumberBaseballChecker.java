package Baseball.NumberBaseball;

import java.util.*;
import Baseball.Exception.BadInputException;

public class NumberBaseballChecker {

    //입력한 데이터가 올바른 입력값인지 체크한다.
    public static boolean checkNumberValue(String checkNumber, int levelDiff) throws Exception{
        try{
            //우선 체크할 답을 integer 형태로 변환한다.
            List<Integer> toParseIntegerList = parseNumberList(checkNumber);
            Set<Integer> checkSet = new HashSet<Integer>(toParseIntegerList);
            //입력한 답이 서로 다른 숫자일 경우에만 리턴한다.
            return checkSet.size() == toParseIntegerList.size() && checkSet.size() == levelDiff;
        }
        //return 값에 만족 못하는 모든 값은 BadInputException 처리된다.
        catch (BadInputException e){
            return false;
        }
    }
    //단순 String에서 Integer 배열로 변환한다.
    public static List<Integer> parseNumberList(String checkNumber) throws Exception{
            List<String> toStringList = List.of(checkNumber.split(""));
            int[] toIntegerList = toStringList.stream().mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(toIntegerList).boxed().toList();
    }
}
