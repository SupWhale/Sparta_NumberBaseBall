package CharaterBaseball;

import java.util.*;

public class CharaterBaseball {

    private int ball = 0;
    private int strike = 0;
    private int out = 0;
    private List<Character> answer;
    private int tryNo;
    public CharaterBaseball(){

    }
    
    //디버깅용 프린트문
    public void getAnswer(){
        answer.forEach(System.out::print);
        System.out.println();
    }
    
    //게임을 시작할때 정답을 설정한다.
    public void setAnswer(int setNumber){
        Set<Character> new_answer = new HashSet<Character>();
        while(new_answer.size() < setNumber){
            Random ran = new Random();
            char a = (char) ran.nextInt(65,90);
            new_answer.add(a);
        }
        this.answer = new_answer.stream().toList();
    }
    
    //문자야구 시작
    public List<Integer> playBaseball(List<Character> swing){
        this.strike = 0;
        this.ball = 0;
        this.out = 0;
        for(int i=0; i<swing.size(); i++) {
            if(answer.get(i) == swing.get(i)) this.strike += 1;
            else if(answer.contains(swing.get(i))) this.ball += 1;
        }
        if(strike == 0 && ball == 0){
            this.out = 1;
        }
        this.tryNo += 1;
        List<Integer> result = new ArrayList<Integer>();
        result.add(this.strike);
        result.add(this.ball);
        result.add(this.out);
        result.add(this.tryNo);
        return result;
    }
}
