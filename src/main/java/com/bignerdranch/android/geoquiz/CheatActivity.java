package com.bignerdranch.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE =
        "com.bignerdranch.android.geoquiz." +
            "answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN=
        "com.bignerdranch.android.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private TextView mAnsertTextView;
    private Button mShowAnswerButton;

    public static Intent newIntent(Context packageContext,
                                   boolean answerIsTrue){
        Intent intent = new Intent(packageContext,CheatActivity.
        class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return intent;
    }
//    解析结果intent
    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,
            false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,
            false);
        mAnsertTextView = (TextView) findViewById(R.id.show_answer_button);
        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnsertTextView.setText(R.string.true_button);
                }else {
                    mAnsertTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });
    }
//    设置结果值
    private void setAnswerShownResult(boolean isAnswerShown)
    {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }
}
