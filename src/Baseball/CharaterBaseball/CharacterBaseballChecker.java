package Baseball.CharaterBaseball;

import Baseball.Exception.BadInputException;

import java.util.*;

public class CharacterBaseballChecker {

    public static boolean checkCharacterValue(String checkNumber, int Level_Diff) throws Exception{
        try{
            List<Character> toParseCharacterList = parseCharacterList(checkNumber);
            Set<Character> checkSet = new HashSet<Character>(toParseCharacterList);
            return checkSet.size() == toParseCharacterList.size() && checkSet.size() == Level_Diff;
        }
        catch (BadInputException e){
            return false;
        }
    }
    public static List<Character> parseCharacterList(String checkCharacter) throws Exception{
            List<Character>charResult = new ArrayList<Character>();
            for (int i=0; i<checkCharacter.length(); i++) {
                charResult.add(checkCharacter.charAt(i));
            }
            return charResult;
    }
}
