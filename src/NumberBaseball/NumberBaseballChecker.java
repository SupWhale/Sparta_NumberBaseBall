package NumberBaseball;

import java.util.*;
import Exception.BadInputException;

public class NumberBaseballChecker {

    public static boolean checkNumberValue(String checkNumber, int Level_Diff) throws Exception{
        try{
            List<Integer> toParseIntegerList = parseNumberList(checkNumber);
            Set<Integer> checkSet = new HashSet<Integer>(toParseIntegerList);
            return checkSet.size() == toParseIntegerList.size() && checkSet.size() == Level_Diff;
        }
        catch (BadInputException e){
            return false;
        }
    }
    public static List<Integer> parseNumberList(String checkNumber) throws Exception{
            List<String> toStringList = List.of(checkNumber.split(""));
            int[] val = toStringList.stream().mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(val).boxed().toList();
    }
}
