package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class M180GeoPointActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private EditText mPointLongEt, mPointLantEt;
    private Button mPointSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_geo_point);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        mPointLantEt = (EditText) findViewById(R.id.point_lant_ed);
        mPointLongEt = (EditText)findViewById(R.id.point_long_ed);
        mPointSaveBtn = (Button) findViewById(R.id.point_save_btn);

        mPointLantEt.setText(mDeviceSettingsDTO.getDTOLatitube_device());
        mPointLantEt.setText(mDeviceSettingsDTO.getDTOLongitube_device());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.point_save_btn:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }
}
