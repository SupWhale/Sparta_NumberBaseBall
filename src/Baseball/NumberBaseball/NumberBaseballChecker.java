package Baseball.NumberBaseball;

import java.util.*;
import Baseball.Exception.BadInputException;

public class NumberBaseballChecker {

    public static boolean checkNumberValue(String checkNumber, int levelDiff) throws Exception{
        try{
            List<Integer> toParseIntegerList = parseNumberList(checkNumber);
            Set<Integer> checkSet = new HashSet<Integer>(toParseIntegerList);
            return checkSet.size() == toParseIntegerList.size() && checkSet.size() == levelDiff;
        }
        catch (BadInputException e){
            return false;
        }
    }
    public static List<Integer> parseNumberList(String checkNumber) throws Exception{
            List<String> toStringList = List.of(checkNumber.split(""));
            int[] toIntegerList = toStringList.stream().mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(toIntegerList).boxed().toList();
    }
}
