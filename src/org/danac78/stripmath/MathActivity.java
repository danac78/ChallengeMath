package org.danac78.stripmath;

import org.danac78.stripmath.support.MathArraySimple;
import org.danac78.stripmath.support.MathEngine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MathActivity extends Activity {

	private MathEngine math;
	private TextView problemTxt;
	private Button plus;
	private Button minus;
	private Button multiply;
	private Button divide;
	protected int difficulty = 1;
	private MathArraySimple problem;
	private Button answerBtn;
	private EditText answerBox;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_math);

		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		multiply = (Button) findViewById(R.id.multiply);
		divide = (Button) findViewById(R.id.divide);
		problemTxt = (TextView) findViewById(R.id.problemTxt);
		answerBtn = (Button) findViewById(R.id.answerBtn);
		answerBox = (EditText) findViewById(R.id.answer);

		math = new MathEngine();

		plus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				setProblem(3);

			}
		});

		minus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setProblem(4);
			}
		});

		multiply.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setProblem(1);
			}
		});

		divide.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setProblem(2);
			}
		});

		answerBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String answer = answerBox.getText().toString();

				if (answer.equals(problem.getAnswer())) {
					problemTxt.setText("Correct");
					difficulty += 1;
				} else {
					problemTxt.setText("Incorrect");
					if (difficulty > 1) {
						difficulty -= 1;
					}
				}

			}
		});

	}
/**
 * Setting up the problem and displaying it on the screen.
 * @param i Declaring what type of problem it is.
 */
	protected void setProblem(int i) {
		problem = math.getMathObj(difficulty, i);
		problemTxt.setText(problem.toString());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_math, menu);
		return true;
	}
}
