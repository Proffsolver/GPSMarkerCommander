package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class M180SettingOperationCellularActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private EditText mApnEt, mOcLoginEt, mOcPassEt;
    private Button mSetOperationCellularEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_setting_operation_cellular);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        mOcLoginEt = (EditText) findViewById(R.id.setting_temp_interval_t1_ed);
        mOcPassEt = (EditText)findViewById(R.id.oc_password_ed);
        mApnEt = (EditText)findViewById(R.id.apn_ed);
        mSetOperationCellularEt = (Button) findViewById(R.id.set_operation_cellular_ed);

        mApnEt.setText(mDeviceSettingsDTO.getDTOUrl_apn_device());
        mOcLoginEt.setText(mDeviceSettingsDTO.getDTOLogin_apn_device());
        mOcPassEt.setText(mDeviceSettingsDTO.getDTOPassword_apn_device());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_operation_cellular_ed:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }

}
