package count;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��Ҫ�������⣿");
		int n=sc.nextInt();//n�������n����Ŀ
		for(int i=0;i<n;i++) {
			Maker maker=new Maker();
			maker.makequestion();
			System.out.println(maker.getQuestion().toString());			
//			System.out.println("������𰸣�");
//			int ownresult=sc.nextInt();
//			System.out.println("��ȷ���ǣ�"+maker.getresult());
		}
		
	}

}
class Maker{
	List list=new ArrayList();
	private question Question=new question();
	private randomNum number=new randomNum();
	private CharMaker charMaker=new CharMaker();
	
	//������Ŀ
	void makequestion() {
		this.Question.setNum((int)(Math.random()+1));//����question�࣬�������Ŀ��3-5�����������3-5֮�������
		this.Question.setNumber(this.number.randomNumber(Question.getNum()));//������Ŀ������
		this.Question.setChars(charMaker.makeChar(Question.getNum()));//������Ŀ�������
	}
	
	question getQuestion() {
		int num[]=this.Question.getNumber();
		char[]sign=this.Question.getChars();
		list.add(num[0]);
		list.add(sign[0]);
		list.add(num[1]);
		getresult();
		return Question;		
	}
	
	public void getresult() {
		int result=1;
		if(list.get(1).equals('*')) {
			result=(int)list.get(0)*(int)list.get(2);
		}
		if(list.get(1).equals('+')) {
			result=(int)list.get(0)+(int)list.get(2);
		}
		if(list.get(1).equals('-')) {
			result=(int)list.get(0)-(int)list.get(2);
		}
		if(list.get(1).equals('��')) {
			result=(int)list.get(0)/(int)list.get(2);
		}
		this.Question.setResult(result);
		//return result;
	}
}

//�������������
class randomNum{
	int[] randomNumber(int num) {
		int[] number=new int[num+1];
		for(int i=0;i<num+1;i++) {
			number[i]=(int)(Math.random()*99);//�������0-100������
		}
		return number;
	}
}

//��������������
class CharMaker{
	private char[] box = {'+','-','*','��'};
    char[] makeChar(int nums){
        char[] chars = new char[nums];
        for(int i = 0;i < nums;i++){
            chars[i] = box[(int)(Math.random()*4)];
        }
        return chars;
    }
}

class Result{
	private question Question=new question();
	
	
}
