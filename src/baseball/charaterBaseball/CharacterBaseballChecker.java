package baseball.charaterBaseball;

import baseball.exception.BadInputException;

import java.util.*;

public class CharacterBaseballChecker {

    //입력한 데이터가 올바른 입력값인지 체크한다.
    public static boolean checkCharacterValue(String checkNumber, int levelDiff) throws Exception{
        try{
            //입력한 답이 Character로 변환시킨다.
            List<Character> toParseCharacterList = parseCharacterList(checkNumber);
            Set<Character> checkSet = new HashSet<Character>(toParseCharacterList);
            return checkSet.size() == toParseCharacterList.size() && checkSet.size() == levelDiff;
        }
        //return 값에 만족 못하는 모든 값은 BadInputException 처리된다.
        catch (BadInputException e){
            return false;
        }
    }
    //단순 String에서 Chracter 배열로 변환한다.
    public static List<Character> parseCharacterList(String checkCharacter) throws Exception{
            List<Character>charResultList = new ArrayList<Character>();
            for (int i=0; i<checkCharacter.length(); i++) {
                charResultList.add(checkCharacter.charAt(i));
            }
            return charResultList;
    }
}
