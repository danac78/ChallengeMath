package org.danac78.challengemath;

import org.danac78.challengemath.support.MathEngine;
import org.danac78.challengemath.support.MathSimpleObj;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;
/** Math Activity
 * 
 * @author dana haywood
 *
 */
public class MathActivity extends Activity {

	private static final String GET_PREF = "settings";
	private MathEngine math;
	private TextView problemTxt;
	private Button plus;
	private Button minus;
	private Button multiply;
	private Button divide;
	protected int difficulty = 1;
	private MathSimpleObj problem;
	private Button answerBtn;
	private EditText answerBox;
	private VideoView tutorView;
	private boolean success;
	protected int video = 1;
	protected int videoIndex;
	private SharedPreferences settings;
	private String videoPerson;
	private String uri;
	private Uri finalURI;
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
		tutorView = (VideoView) findViewById(R.id.tutorVideo);
		settings = getSharedPreferences(GET_PREF, 0);
		videoPerson = settings.getString("person", null);
		uri = "android.resource://" + getPackageName() + "/raw/";	
		math = new MathEngine();
				
		finalURI = Uri.parse(setURI(uri,videoPerson,video));  
		setupVideo(finalURI);
		
		
		

		tutorView.setOnPreparedListener(new OnPreparedListener() {

			public void onPrepared(MediaPlayer mp) {
				mp.setLooping(true);
			}

		});
		plus.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setProblem(3);
			}
		});

		minus.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setProblem(4);
			}
		});

		multiply.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setProblem(1);
			}
		});

		divide.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setProblem(2);
			}
		});

		answerBtn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				userAnswer(Integer.parseInt(answerBox.getText().toString()),
						problem.getAnswer());

				if (success) {
					if (video != 1)
						video++;
					
				} else {
					if (video != videoIndex) {
						video--;
					}
				}
				tutorView.stopPlayback();
				finalURI=Uri.parse(setURI(uri,videoPerson,video));
				setupVideo(finalURI);
				
				

			}
		});
	}

	private void setupVideo(Uri finalURI2) {
		tutorView.setVideoURI(finalURI2);
		tutorView.start();
		
	}

	private String setURI(String uri2, String videoPerson2, int video2) {
		return uri2+videoPerson2+video2;
	}

	protected void userAnswer(int userAnswer, int answer) {

		if (userAnswer == answer) {
			problemTxt.setText("Correct");
			success = true;
			if (difficulty != 10) {
				difficulty++;

			}
		} else {
			problemTxt.setText("Sorry, the answer is " + answer);
			success = false;
			if (difficulty != 1) {
				difficulty--;
			}

		}

		answerBox.setText(null);

	}

	/**
	 * Setting up the problem and displaying it on the screen.
	 * 
	 * @param i
	 *            Declaring what type of problem it is.
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
