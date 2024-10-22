import java.util.*;

public class NumberBaseBall {

    private int ball = 0;
    private int strike = 0;
    private int out = 0;
    private List<Integer> answer;
    private int tryNo;
    NumberBaseBall(){

    }

    public void getAnswer(){
        answer.stream().forEach(System.out::print);
        System.out.println();
    }

    public void setAnswer(int setNumber){
        Set<Integer> new_answer = new HashSet<Integer>();
        while(new_answer.size() < setNumber){
            Random ran = new Random();
            new_answer.add(ran.nextInt(1,9));
        }
        this.answer = new_answer.stream().toList();
    }

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
