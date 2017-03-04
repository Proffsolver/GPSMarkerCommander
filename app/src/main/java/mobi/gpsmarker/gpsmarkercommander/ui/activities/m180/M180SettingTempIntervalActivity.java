package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class M180SettingTempIntervalActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private EditText mTempInterval1Et, mTempInterval2Et;
    private Button mTempIntervalSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_setting_temp_interval);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        mTempInterval1Et = (EditText) findViewById(R.id.setting_temp_interval_t1_ed);
        mTempInterval2Et = (EditText)findViewById(R.id.setting_temp_interval_t2_ed);
        mTempIntervalSaveBtn = (Button) findViewById(R.id.temp_interval_save_btn);

        mTempInterval1Et.setText(mDeviceSettingsDTO.getDTOTemp_device_1());
        mTempInterval2Et.setText(mDeviceSettingsDTO.getDTOTemp_device_2());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.temp_interval_save_btn:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }


}
