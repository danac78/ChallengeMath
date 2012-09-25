package org.danac78.stripmath.support;

import java.util.Random;

public class MathEngine {

	private Random random = new Random();;
	private MathArraySimple mathObjSimple;

	public MathEngine() {

	}

	public MathArraySimple getMathObj(int difficulty, int problemType) {

		mathObjSimple = new MathArraySimple();

		mathObjSimple.setA(random.nextInt(difficulty));
		mathObjSimple.setB(random.nextInt(difficulty));
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
