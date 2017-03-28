package mobi.gpsmarker.gpsmarkercommander.utils;


import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;

public class UserInputChecker implements TextWatcher {
 //   private static final String phonePattern = "^\\+\\d{1,1} \\d{3,3} \\d{3,3}-\\d{2,2}-\\d{2,11}";
    private static final String phonePattern = "^\\+\\d{11,15}";
    private static final String emailPattern = "^[\\w\\.\\-]{3,}@[A-Za-z0-9\\-]{2,}\\.[A-Za-z]{2,3}$";
    private static final String IMEIPattern = "^d{15,15}";

    Context mContext;
    EditText mEditText;
    Button mButton;
    TextInputLayout mLayout;

    public UserInputChecker(Context contex, EditText editText, TextInputLayout layout, Button button) {
      //  mContext = context;
        mContext = contex;
        mEditText = editText;
        mLayout = layout;
        mButton = button;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
/*        String str = s.toString().toLowerCase();
        if (str.contains("http://")) {
            mEditText.setText(str.replace("http://", ""));
        }
        if (str.contains("https://")) {
            mEditText.setText(str.replace("https://", ""));
        }*/
    }

    @Override
    public void afterTextChanged(Editable s) {
        switch (mEditText.getId()) {
            case R.id.user_phone_et:
                checkInputString(phonePattern, s.toString(),mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.user_email_et:
                checkInputString(emailPattern, s.toString(),mContext.getString(R.string.error_input_mail_message));
                break;
            case R.id.device_name_add_et:
                checkInputString(IMEIPattern, s.toString(), mContext.getString(R.string.error_input_IMEI));
                break;
            case R.id.phone_1_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_2_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_3_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_4_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_5_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_6_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_7_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_8_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
            case R.id.phone_9_ed:
                checkInputString(phonePattern, s.toString(), mContext.getString(R.string.error_input_phone_number));
                break;
        }
    }

    private void checkInputString(String patternString, String inputString, String error) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches()) {
            mButton.setEnabled(true);
            mLayout.setError("");
          //  mLayout.setErrorEnabled(false);
        } else {
            mButton.setEnabled(false);
            mLayout.setError(error);
        }
    }
}
