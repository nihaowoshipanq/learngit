package count;

import java.util.Arrays;

public class question {
	private int num;//�������Ŀ
	private int number[]=new int[num+1];//������������������
	private char chars[]=new char[num];//��������������
	private int result=1;
	//���췽��
	question() {
		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int[] getNumber() {
		return number;
	}
	public void setNumber(int[] number) {
		this.number = number;
	}
	public char[] getChars() {
		return chars;
	}
	public void setChars(char[] chars) {
		this.chars = chars;
	}
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	@Override
	//���������
	public String toString() {
		Object[] box = new Object[num*2+4];
        box[num*2+1] = '=';
        box[num*2+2] = result;
        box[num*2+3] = "\r\n";
        for(int i = 0; i < num*2+1;i=i+2){
            box[i] = number[i/2];
        }
        for(int i = 1; i < num*2;i=i+2){
            box[i] = chars[i/2];
        }
        return Arrays.toString(box).replace('[',' ').replace(']',' ').replace(',',' ');
    }
	
//	public String Result() {
//		Object[] box = new Object[num*2+4];
//        box[num*2+1] = '=';
//        box[num*2+2] = result;
//        box[num*2+3] = "\r\n";
//        for(int i = 0; i < num*2+1;i=i+2){
//            box[i] = number[i/2];
//        }
//        for(int i = 1; i < num*2;i=i+2){
//            box[i] = chars[i/2];
//        }
//        return Arrays.toString(box).replace('[',' ').replace(']',' ').replace(',',' ');
//	}

}
