package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class M180ChangeModeTempSignalActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private TextView mModeTemp1Et, mModeTemp2Et, mModeTemp3Et, mModeTemp4Et;
    private ImageView mModeTemp1Img, mModeTemp2Img, mModeTemp3Img, mModeTemp4Img;
    private Button mChTempModeSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_change_mode_temp_signal);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        mModeTemp1Et = (TextView) findViewById(R.id.mode_temp_1_tv);
        mModeTemp2Et = (TextView) findViewById(R.id.mode_temp_2_tv);
        mModeTemp3Et = (TextView) findViewById(R.id.mode_temp_3_tv);
        mModeTemp4Et = (TextView) findViewById(R.id.mode_temp_4_tv);
        mModeTemp1Img = (ImageView) findViewById(R.id.mode_temp_1_iv);
        mModeTemp2Img = (ImageView) findViewById(R.id.mode_temp_2_iv);
        mModeTemp3Img = (ImageView) findViewById(R.id.mode_temp_3_iv);
        mModeTemp4Img = (ImageView) findViewById(R.id.mode_temp_4_iv);
        mChTempModeSaveBtn = (Button) findViewById(R.id.ch_temp_mode_save_btn);
        switch (Integer.valueOf(mDeviceSettingsDTO.getDTOTemp_relay_device())) {
            case 1:
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                break;
            case 2:
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                break;
            case 3:
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                break;
            case 4:
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mode_temp_1_tv:
                // TODO: Сделать переключалку
                break;
            case R.id.mode_temp_2_tv:

                break;
            case R.id.mode_temp_3_tv:

                break;
            case R.id.mode_temp_4_tv:

                break;
            case R.id.mode_temp_1_iv:

                break;
            case R.id.mode_temp_2_iv:

                break;
            case R.id.mode_temp_3_iv:

                break;
            case R.id.mode_temp_4_iv:

                break;
            case R.id.point_save_btn:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }

}
