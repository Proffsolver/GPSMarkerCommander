package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class M180SettingMonitoringServerActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private EditText mUrlMoniServerEt, mPortMoniServerEt;
    private Button mSetOperationCellularEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_setting_monitoring_server);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        mUrlMoniServerEt = (EditText) findViewById(R.id.set_url_monitoring_server_ed);
        mPortMoniServerEt = (EditText)findViewById(R.id.set_port_monitoring_server_ed);
        mSetOperationCellularEt = (Button) findViewById(R.id.set_mon_server_btn);

        mUrlMoniServerEt.setText(mDeviceSettingsDTO.getDTOUrl_server_device());
        mPortMoniServerEt.setText(mDeviceSettingsDTO.getDTOPort_sever_device());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_mon_server_btn:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }

}
