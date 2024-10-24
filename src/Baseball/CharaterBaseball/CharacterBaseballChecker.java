package Baseball.CharaterBaseball;

import Baseball.Exception.BadInputException;

import java.util.*;

public class CharacterBaseballChecker {

    public static boolean checkCharacterValue(String checkNumber, int levelDiff) throws Exception{
        try{
            List<Character> toParseCharacterList = parseCharacterList(checkNumber);
            Set<Character> checkSet = new HashSet<Character>(toParseCharacterList);
            return checkSet.size() == toParseCharacterList.size() && checkSet.size() == levelDiff;
        }
        catch (BadInputException e){
            return false;
        }
    }
    public static List<Character> parseCharacterList(String checkCharacter) throws Exception{
            List<Character>charResultList = new ArrayList<Character>();
            for (int i=0; i<checkCharacter.length(); i++) {
                charResultList.add(checkCharacter.charAt(i));
            }
            return charResultList;
    }
}
