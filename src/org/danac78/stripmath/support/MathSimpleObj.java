package org.danac78.stripmath.support;

public class MathSimpleObj {
	private int A;
	private int B;
	private int answer;


	
	@Override
	public String toString() {
		return ""+A+" "+sign+" "+B+" =";
	}
	private String sign;
	
	public int getA() {
		return A;
	}
	public void setA(int a) {
		A = a;
	}
	public int getB() {
		return B;
	}
	public void setB(int b) {
		B = b;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
}
