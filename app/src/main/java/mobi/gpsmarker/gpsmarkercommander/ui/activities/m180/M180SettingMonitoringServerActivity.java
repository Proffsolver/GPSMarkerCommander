package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.M180DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class M180SettingMonitoringServerActivity extends BaseActivity implements View.OnClickListener{

    private M180DeviceSettingsDTO mM180DeviceSettingsDTO;
    private EditText mUrlMoniServerEt, mPortMoniServerEt;
    private Button mSetOperationCellularEt;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_setting_monitoring_server);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_moni_server_toolbar);
        setupToolbar();
        mM180DeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_SETTINGS_KEY));
        mUrlMoniServerEt = (EditText) findViewById(R.id.set_url_monitoring_server_ed);
        mPortMoniServerEt = (EditText)findViewById(R.id.set_port_monitoring_server_ed);
        mSetOperationCellularEt = (Button) findViewById(R.id.set_mon_server_btn);
        mSetOperationCellularEt.setOnClickListener(this);
        mUrlMoniServerEt.setText(mM180DeviceSettingsDTO.getDTOUrl_server_device());
        mPortMoniServerEt.setText(Integer.toString(mM180DeviceSettingsDTO.getDTOPort_sever_device()));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra(ConstantManager.M180_URL_SERVER_DEVICE, mUrlMoniServerEt.getText().toString());
        intent.putExtra(ConstantManager.M180_PORT_SEVER_DEVICE, mPortMoniServerEt.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
