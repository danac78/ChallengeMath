package org.danac78.challengemath.support;

import java.util.Random;

public class MathEngine {

	private Random random = new Random();;
	private MathSimpleObj mathObjSimple;
	private int multDivAdd=0;

	public MathEngine() {

	}

	public MathSimpleObj getMathObj(int difficulty, int problemType) {

		mathObjSimple = new MathSimpleObj();
		if(difficulty > 2)
		{
			multDivAdd = 2;
		}
		mathObjSimple.setA(random.nextInt(difficulty*10)+multDivAdd);
		mathObjSimple.setB(random.nextInt(difficulty*10)+multDivAdd);
		
		switch (problemType) {
		case 1:
			mathObjSimple
					.setAnswer(mathObjSimple.getA() * mathObjSimple.getB());
			mathObjSimple.setSign("*");
		case 2:
			mathObjSimple
					.setAnswer(mathObjSimple.getA() / mathObjSimple.getB());
			mathObjSimple.setSign("/");
		case 3:
			mathObjSimple
					.setAnswer(mathObjSimple.getA() + mathObjSimple.getB());
			mathObjSimple.setSign("+");
			break;
		case 4:
			mathObjSimple
					.setAnswer(mathObjSimple.getA() - mathObjSimple.getB());
			mathObjSimple.setSign("-");

		}

		return mathObjSimple;
	}
}
