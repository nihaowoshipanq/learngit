package count;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Main {
//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("你要做几道题？");
//		int n=sc.nextInt();//n代表输出n道题目
//		for(int i=0;i<n;i++) {
//			Maker maker=new Maker();
//			maker.makequestion();
//			System.out.println(maker.getQuestion().toString());		
//		}
//		
//	}
	//将用户在窗体输入的数字传到Question
	public String readNUM(int n) {
		String result="";
		for(int i=0;i<n;i++) {
			Maker maker=new Maker();
			maker.makequestion();
			result+=maker.getQuestion().toString()+"\n";		
		}
		return result;
	}
}
class Maker{
	List list=new ArrayList();
	private question Question=new question();
	private randomNum number=new randomNum();
	private CharMaker charMaker=new CharMaker();
	
	//制造题目
	void makequestion() {
		this.Question.setNum((int)(Math.random()+1));//调用question类，运算符数目是1个
		this.Question.setChars(charMaker.makeChar(Question.getNum()));//设置题目的运算符
		this.Question.setNumber(this.number.randomNumber(Question.getNum(),this.Question.getChars()));//设置题目的数字
		
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
		String result=null;
		if(list.get(1).equals('*')) {
			result=String.valueOf((int)list.get(0)*(int)list.get(2));
		}
		if(list.get(1).equals('+')) {
			result=String.valueOf((int)list.get(0)+(int)list.get(2));
		}
		if(list.get(1).equals('-')) {
			result=String.valueOf((int)list.get(0)-(int)list.get(2));
		}
		if(list.get(1).equals('÷')) {
			if((int)list.get(0)<(int)list.get(2)) {
				result=String.valueOf(list.get(0))+'/'+String.valueOf(list.get(2));
			}else {
				result=String.valueOf((int)list.get(0)/(int)list.get(2));
			}			
		}
		this.Question.setResult(result);
		//return result;
	}
}

//生成随机数字类

class randomNum{
	int[]  randomNumber(int num, char[] s) {

		int[] number=new int[num+1];
		if(s[0]=='-') {
			while(number[0]<=number[1]) {
				for(int i=0;i<num+1;i++) {
					number[i]=(int)(Math.random()*99);//随机生成0-100的整数
				}
			}
			
		}else {
			for(int i=0;i<num+1;i++) {
				number[i]=(int)(Math.random()*99);//随机生成0-100的整数
			}
		}
		
		return number;
	}
}

//随机制造运算符类
class CharMaker{
	private char[] box = {'+','-','*','÷'};
    char[] makeChar(int nums){
        char[] chars = new char[nums];
        for(int i = 0;i < nums;i++){
            chars[i] = box[(int)(Math.random()*4)];
        }
        return chars;
    }
}

