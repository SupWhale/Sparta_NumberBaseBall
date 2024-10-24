package Baseball.CharaterBaseball;

import java.util.*;

public class CharacterBaseball {

    private int ball = 0;
    private int strike = 0;
    private int out = 0;
    private List<Character> answer;
    private int tryNo;
    public CharacterBaseball(){

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
        //해당 객체의 스트라이크, 볼, 아웃 값 초기화
        this.strike = 0;
        this.ball = 0;
        this.out = 0;

        for(int i=0; i<swing.size(); i++) {
            //위치값과 값이 동일하면 스트라이크에 +1
            if(answer.get(i) == swing.get(i)) this.strike += 1;
            //위치 상관없이 값이 동일한게 있다면 볼에 +1
            else if(answer.contains(swing.get(i))) this.ball += 1;
        }
        if(strike == 0 && ball == 0){
            //스트라이크와 볼이 0이라면 아웃은 1이된다.(아웃처리)
            this.out = 1;
        }
        //정답이든 오답이든 시도횟수를 추가한다.
        this.tryNo += 1;
        //결과를 반환해줄 result 리스트 생성
        List<Integer> result = new ArrayList<Integer>();
        //차례대로 스트라이크, 볼, 아웃, 시도횟수를 삽입한다.
        result.add(this.strike);
        result.add(this.ball);
        result.add(this.out);
        result.add(this.tryNo);
        return result;
    }
}
