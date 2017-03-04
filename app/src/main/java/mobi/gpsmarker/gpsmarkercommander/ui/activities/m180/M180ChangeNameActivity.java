package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class M180ChangeNameActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private SwitchCompat mDispNameInSmsSw;
    private EditText mChangeNameEt;
    private Button mChangeNameSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_change_name);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        mDispNameInSmsSw = (SwitchCompat) findViewById(R.id.disp_name_in_sms_sw);
        mChangeNameEt = (EditText)findViewById(R.id.change_name_ed);
        mChangeNameSaveBtn = (Button) findViewById(R.id.change_name_save_btn);

        mChangeNameEt.setText(mDeviceSettingsDTO.getDTOName_Device());

        if (Integer.valueOf(mDeviceSettingsDTO.getDTODisp_name_in_sms())==1){
            mDispNameInSmsSw.setText("Отображать");
            mDispNameInSmsSw.setChecked(TRUE);
        }else{
            mDispNameInSmsSw.setText("Скрывать");
            mDispNameInSmsSw.setChecked(FALSE);
        }
        mDispNameInSmsSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mDispNameInSmsSw.setText("Отображать");
                }else{
                    mDispNameInSmsSw.setText("Скрывать");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_name_save_btn:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }
}
