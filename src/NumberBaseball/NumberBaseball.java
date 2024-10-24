package NumberBaseball;

import java.util.*;

public class NumberBaseball {

    private int ball = 0;
    private int strike = 0;
    private int out = 0;
    private List<Integer> answer;
    private int tryNo;
    public NumberBaseball(){

    }
    
    //디버깅용 프린트문
    public void getAnswer(){
        answer.forEach(System.out::print);
        System.out.println();
    }
    
    //게임을 시작할때 정답을 설정한다.
    public void setAnswer(int setNumber){
        Set<Integer> new_answer = new HashSet<Integer>();
        while(new_answer.size() < setNumber){
            Random ran = new Random();
            new_answer.add(ran.nextInt(1,9));
        }
        this.answer = new_answer.stream().toList();
    }
    
    //숫자야구 시작
    public List<Integer> playBaseball(List<Integer> swing){
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
