package in.chandramouligoru.passcodeapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

public class PasscodeActivity extends AppCompatActivity {

    @Bind(R.id.super_layout)
    View mView;

    @Bind(R.id.text)
    TextView mTextView;

    @Bind(R.id.radioButton1)
    RadioButton mRadioButton1;

    @Bind(R.id.radioButton2)
    RadioButton mRadioButton2;

    @Bind(R.id.radioButton3)
    RadioButton mRadioButton3;

    @Bind(R.id.radioButton4)
    RadioButton mRadioButton4;

    @Bind(R.id.secret)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
//        mView.requestFocus();
//        showSoftKeyboard(mView);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                handleRadioButtonsVisibility(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Intent intent = new Intent(PasscodeActivity.this, ShowCodeActivity.class);
                    intent.putExtra(ShowCodeActivity.INTENT_ARG_PASSCODE, mEditText.getText().toString());
                    PasscodeActivity.this.startActivity(intent);
                    return true;
                } else
                    return false;
            }
        });
    }

    private void handleRadioButtonsVisibility(int count) {
        switch (count) {
            case 0:
                mRadioButton1.setChecked(false);
                mRadioButton2.setChecked(false);
                mRadioButton3.setChecked(false);
                mRadioButton4.setChecked(false);
                break;
            case 1:
                mRadioButton1.setChecked(true);
                mRadioButton2.setChecked(false);
                mRadioButton3.setChecked(false);
                mRadioButton4.setChecked(false);
                break;
            case 2:
                mRadioButton1.setChecked(true);
                mRadioButton2.setChecked(true);
                mRadioButton3.setChecked(false);
                mRadioButton4.setChecked(false);
                break;
            case 3:
                mRadioButton1.setChecked(true);
                mRadioButton2.setChecked(true);
                mRadioButton3.setChecked(true);
                mRadioButton4.setChecked(false);
                break;
            case 4:
                mRadioButton1.setChecked(true);
                mRadioButton2.setChecked(true);
                mRadioButton3.setChecked(true);
                mRadioButton4.setChecked(true);
                break;
        }

    }

    public void showSoftKeyboard(View view) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }
}
