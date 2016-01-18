package in.chandramouligoru.passcodeapplication;

import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShowCodeActivity extends AppCompatActivity {

    public static final String INTENT_ARG_PASSCODE = "intent_arg_passcode";

    @Bind(R.id.show_code)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_code);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        mTextView.setText(getIntent().getStringExtra(INTENT_ARG_PASSCODE));
    }
}
