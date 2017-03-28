package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180SettingsDeviceData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180SettingsDeviceOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180SettingsDeviceReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180.M180SettingsDeviceRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceDTO;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.M180DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ChangeModeTempSignalActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180GeoPointActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ListAlarmActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ListPhonesActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ChangeNameActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingMonitoringServerActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingOperationCellularActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingTempIntervalActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class M180SettingsActivity extends BaseActivity implements View.OnClickListener{

    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DataManager mDataManager;
    private DeviceDTO mDeviceDTO;
    private M180DeviceSettingsDTO mM180DeviceSettingsDTO;
    private List<M180SettingsDeviceRes.Datum> mDevice;
    private EditText mM180_RADUIS_DEVICEEt, mM180_TIME_SEND_MESSAGE_DEVICEEt, mM180_TEMP_IMP_DEVICEEt, mM180_TIME_PARK_DEVICE_hour_Et, mM180_TIME_PARK_DEVICE_minute_Et, mM180_UTC_DEVICEEt, mM180_MIN_BALANCE_DEVICEEt, mM180_USSD_BALANCE_DEVICEEt, mM180_MOVE_DEVICEEt, mM180_SPEED_DEVICEEt, mM180_UNMOVE_DEVICEEt;
    private Spinner mM180_MODE_DEVICESp, mM180_LANGUAGE_DEVICESp, mM180_GPS_URL_DEVICESp, mM180_UNSLEEP_SMS_DEVICESp, mM180_WORRY_CALL_DEVICESp;
    private TextView mM180_NAME_DEVICETv, mListPnonesTv, mAlarmsTv, mTempvalTv, mTempsignalTv, mAddressMoniServerTv, mSettingInternetTv, mM180_POINTTv;
    private SwitchCompat mM180_LBS_DEVICE_ONSw, mM180_BALANCE_DEVICE_ONSw,  mM180_BUTTON_DEVICE_ONSw, mM180_JACK_DEVICE_ONSw, mM180_MOVE_DEVICE_ONSw, mM180_UNMOVE_DEVICE_ONSw, mM180_SPEED_DEVICE_ONSw, mM180_TEMP_DEVICE_ONSw, mM180_TEMP_RELAY_SMS_DEVICESw, mM180_INTERNET_DEVICE_ONSw, mM180_ADTRACK_DEVICE_ONSw, mLinkViewSw;
    private Button mChangeSettingsSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
        setContentView(R.layout.m180_activity_settings);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.settings_ccordinator_container);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_toolbar);
        setupToolbar();
        mChangeSettingsSaveBtn = (Button) findViewById(R.id.change_settinmgs_save_btn);
        mChangeSettingsSaveBtn.setOnClickListener(this);
        mDeviceDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        if (Integer.valueOf(mDataManager.getPreferenceManager().getCurrentDeviceIdType())==1){
            mM180_NAME_DEVICETv = (TextView) findViewById(R.id.name_tv);
            ArrayAdapter<String> mmM180_MODE_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_MODE_STRINGS);
            mmM180_MODE_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_MODE_DEVICESp = (Spinner) findViewById(R.id.mode_sp);
            mM180_MODE_DEVICESp.setAdapter(mmM180_MODE_DEVICESpAdapter);
    //        mModeSp.setPrompt("Режим работы: Сон");
            mM180_MODE_DEVICESp.setSelection(2);
            mM180_MODE_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mM180_LANGUAGE_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_LANG_STRINGS);
            mM180_LANGUAGE_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_LANGUAGE_DEVICESp = (Spinner) findViewById(R.id.lang_sp);
            mM180_LANGUAGE_DEVICESp.setAdapter(mM180_LANGUAGE_DEVICESpAdapter);
   //         mM180_LANGUAGE_DEVICESp.setPrompt("Язык SMS: Авто");
            mM180_LANGUAGE_DEVICESp.setSelection(0);
            mM180_LANGUAGE_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

/*             ArrayAdapter<String> mM180_GPS_URL_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_LINKVIEW_STRINGS);
            mM180_GPS_URL_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_GPS_URL_DEVICESp = (Spinner) findViewById(R.id.linkview_sp);
            mM180_GPS_URL_DEVICESp.setAdapter(mM180_GPS_URL_DEVICESpAdapter);
    //        mM180_GPS_URL_DEVICESp.setPrompt("Вид ссылки: Геокоординаты");
            mM180_GPS_URL_DEVICESp.setSelection(0);
            mM180_GPS_URL_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });*/

            ArrayAdapter<String> mM180_UNSLEEP_SMS_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_ALARM_SMS_STRINGS);
            mM180_UNSLEEP_SMS_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_UNSLEEP_SMS_DEVICESp = (Spinner) findViewById(R.id.sms_sp);
            mM180_UNSLEEP_SMS_DEVICESp.setAdapter(mM180_UNSLEEP_SMS_DEVICESpAdapter);
    //        mM180_LANGUAGE_DEVICESp.setPrompt("Язык SMS: Авто");
            mM180_UNSLEEP_SMS_DEVICESp.setSelection(0);
            mM180_UNSLEEP_SMS_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mCallViewSpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_ALARM_CALL_STRINGS);
            mCallViewSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_WORRY_CALL_DEVICESp = (Spinner) findViewById(R.id.call_sp);
            mM180_WORRY_CALL_DEVICESp.setAdapter(mCallViewSpAdapter);
    //        mM180_GPS_URL_DEVICESp.setPrompt("Вид ссылки: Геокоординаты");
            mM180_WORRY_CALL_DEVICESp.setSelection(0);
            mM180_WORRY_CALL_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            mM180_TIME_PARK_DEVICE_hour_Et = (EditText) findViewById(R.id.park_hour_ed);
            mM180_TIME_PARK_DEVICE_minute_Et = (EditText) findViewById(R.id.park_minute_ed);
            mM180_UTC_DEVICEEt = (EditText) findViewById(R.id.utc_ed);
            mM180_MIN_BALANCE_DEVICEEt = (EditText) findViewById(R.id.minbalance_ed);
            mM180_USSD_BALANCE_DEVICEEt = (EditText) findViewById(R.id.ussdcommand_ed);
            mM180_MOVE_DEVICEEt = (EditText) findViewById(R.id.move_ed);
            mM180_UNMOVE_DEVICEEt = (EditText) findViewById(R.id.unmove_ed);
            mM180_SPEED_DEVICEEt = (EditText) findViewById(R.id.speed_ed);
            mM180_TEMP_IMP_DEVICEEt = (EditText) findViewById(R.id.temprelayimp_ed);
            mM180_TIME_SEND_MESSAGE_DEVICEEt = (EditText) findViewById(R.id.intarvel_send_ed);
            mM180_RADUIS_DEVICEEt = (EditText) findViewById(R.id.distance_ed);
            mM180_LBS_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.lbs_defination_sw);
     //       mLinkViewSw =(SwitchCompat) findViewById(R.id.linkview_sw);
            mListPnonesTv =(TextView) findViewById(R.id.listphones_tv);
            mAlarmsTv =(TextView) findViewById(R.id.alarms_sms_tv);
            mM180_BALANCE_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.balance_sw);
            mM180_BUTTON_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.button_sw);
            mM180_MOVE_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.move_sw);
            mM180_UNMOVE_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.unmove_sw);
            mM180_SPEED_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.speed_sw);
            mM180_JACK_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.jack_sw);
            mM180_TEMP_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.temp_sw);
            mTempvalTv =(TextView) findViewById(R.id.tempval_tv);
            mTempsignalTv =(TextView) findViewById(R.id.tempsignal_tv);
            mM180_TEMP_RELAY_SMS_DEVICESw = (SwitchCompat) findViewById(R.id.temprelaysms_sw);
            mM180_INTERNET_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.activate_internet_sw);
            mSettingInternetTv =(TextView) findViewById(R.id.setting_internet_tv);
            mM180_ADTRACK_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.adaptivetrack_sw);
            mM180_POINTTv =(TextView) findViewById(R.id.point_tv);
            mAddressMoniServerTv =(TextView) findViewById(R.id.address_mon_server_tv);
            mM180_NAME_DEVICETv.setOnClickListener(this);
            mM180_LBS_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }

                }
            });
/*            mLinkViewSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mLinkViewSw.setText(getString(R.string.switchon));
                    }else{
                        mLinkViewSw.setText(getString(R.string.switchoff));
                    }

                }
            });*/
            mListPnonesTv.setOnClickListener(this);
            mAlarmsTv.setOnClickListener(this);
            mM180_BALANCE_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_BUTTON_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_JACK_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_MOVE_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_UNMOVE_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_SPEED_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_TEMP_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_TEMP_RELAY_SMS_DEVICESw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchon));
                    }else{
                        mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mTempvalTv.setOnClickListener(this);
            mTempsignalTv.setOnClickListener(this);
            mM180_INTERNET_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mSettingInternetTv.setOnClickListener(this);
            mM180_ADTRACK_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mAddressMoniServerTv.setOnClickListener(this);
            mM180_POINTTv.setOnClickListener(this);
            loadDeviceM180SettingsDataFromInternet();
        }

        if (savedInstanceState == null) {

        } else{

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == ConstantManager.CHANGE_NAME) {
            if (resultCode == RESULT_OK) {
                 mM180_NAME_DEVICETv.setText(data.getStringExtra(ConstantManager.M180_NAME_DEVICE));
                 mDevice.get(45).setNameDevice(data.getStringExtra(ConstantManager.M180_NAME_DEVICE));
                 mM180DeviceSettingsDTO.setDTOName_Device(data.getStringExtra(ConstantManager.M180_NAME_DEVICE));
                 mDevice.get(46).setNameDevice(data.getStringExtra(ConstantManager.M180_NAME_DEVICE_ON));
                 mM180DeviceSettingsDTO.setDTODisp_name_in_sms(Integer.valueOf(data.getStringExtra(ConstantManager.M180_NAME_DEVICE_ON)));
            }
        }
        if (requestCode == ConstantManager.CHANGE_TEMPVAL) {
            if (resultCode == RESULT_OK) {
                mDevice.get(70).setTempDevice1(data.getStringExtra(ConstantManager.M180_TEMP_DEVICE_1));
                mM180DeviceSettingsDTO.setDTOTemp_device_1(String.valueOf(data.getStringExtra(ConstantManager.M180_TEMP_DEVICE_1)));
                mDevice.get(71).setTempDevice2(data.getStringExtra(ConstantManager.M180_TEMP_DEVICE_2));
                mM180DeviceSettingsDTO.setDTOTemp_device_2(String.valueOf(data.getStringExtra(ConstantManager.M180_TEMP_DEVICE_2)));
            }}
        if (requestCode == ConstantManager.CHANGE_ADD_MON_SERV) {
            if (resultCode == RESULT_OK) {
                mDevice.get(84).setUrlServerDevice(data.getStringExtra(ConstantManager.M180_URL_SERVER_DEVICE));
                mM180DeviceSettingsDTO.setDTOUrl_server_device(data.getStringExtra(ConstantManager.M180_URL_SERVER_DEVICE));
                mDevice.get(66).setPortSeverDevice(Integer.valueOf(data.getStringExtra(ConstantManager.M180_PORT_SEVER_DEVICE)));
                mM180DeviceSettingsDTO.setDTOPort_sever_device(Integer.valueOf(data.getStringExtra(ConstantManager.M180_PORT_SEVER_DEVICE)));
            }}
        if (requestCode == ConstantManager.CHANGE_INTERNET) {
            if (resultCode == RESULT_OK) {
                mDevice.get(83).setUrlApnDevice(data.getStringExtra(ConstantManager.M180_URL_APN_DEVICE));
                mM180DeviceSettingsDTO.setDTOUrl_apn_device(data.getStringExtra(ConstantManager.M180_URL_APN_DEVICE));
                mDevice.get(37).setLoginApnDevice(data.getStringExtra(ConstantManager.M180_LOGIN_APN_DEVICE));
                mM180DeviceSettingsDTO.setDTOLogin_apn_device(data.getStringExtra(ConstantManager.M180_LOGIN_APN_DEVICE));
                mDevice.get(47).setPasswordApnDevice(data.getStringExtra(ConstantManager.M180_PASSWORD_APN_DEVICE));
                mM180DeviceSettingsDTO.setDTOPassword_apn_device(data.getStringExtra(ConstantManager.M180_PASSWORD_APN_DEVICE));

            }}
        if (requestCode == ConstantManager.CHANGE_POINT) {
            if (resultCode == RESULT_OK) {
                mDevice.get(40).setLongitubeDevice(String.valueOf(data.getStringExtra(ConstantManager.M180_LONGITUBE_DEVICE)));
                mM180DeviceSettingsDTO.setDTOLongitube_device(String.valueOf(data.getStringExtra(ConstantManager.M180_LONGITUBE_DEVICE)));
                mDevice.get(35).setLatitubeDevice(String.valueOf(data.getStringExtra(ConstantManager.M180_LATITUBE_DEVICE)));
                mM180DeviceSettingsDTO.setDTOLatitube_device(String.valueOf(data.getStringExtra(ConstantManager.M180_LATITUBE_DEVICE)));
                mM180_POINTTv.setText(String.valueOf(data.getStringExtra(ConstantManager.M180_LATITUBE_DEVICE)+"::"+String.valueOf(data.getStringExtra(ConstantManager.M180_LONGITUBE_DEVICE))));
            }}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.name_tv:
                Intent nameSetIntent = new Intent(M180SettingsActivity.this, M180ChangeNameActivity.class);
                nameSetIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(nameSetIntent, 1);
                break;
            case R.id.listphones_tv:
                Intent listPhonesIntent = new Intent(M180SettingsActivity.this, M180ListPhonesActivity.class);
                startActivity(listPhonesIntent);
                break;
            case R.id.alarms_sms_tv:
                Intent listAlarmsIntent = new Intent(M180SettingsActivity.this, M180ListAlarmActivity.class);
                startActivity(listAlarmsIntent);
                break;
            case R.id.tempval_tv:
                Intent setTempIntervalIntent = new Intent(M180SettingsActivity.this, M180SettingTempIntervalActivity.class);
                setTempIntervalIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(setTempIntervalIntent, 4);
                break;
            case R.id.tempsignal_tv:
                Intent chModeTempSignalIntent = new Intent(M180SettingsActivity.this, M180ChangeModeTempSignalActivity.class);
                startActivity(chModeTempSignalIntent);
                break;
            case R.id.address_mon_server_tv:
                Intent addressMoniServerIntent = new Intent(M180SettingsActivity.this, M180SettingMonitoringServerActivity.class);
                addressMoniServerIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(addressMoniServerIntent, 6);
                break;
            case R.id.setting_internet_tv:
                Intent settingInternetIntent = new Intent(M180SettingsActivity.this, M180SettingOperationCellularActivity.class);
                settingInternetIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(settingInternetIntent, 7);
                break;
            case R.id.point_tv:
                Intent geoPointIntent = new Intent(M180SettingsActivity.this, M180GeoPointActivity.class);
                geoPointIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(geoPointIntent, 8);
                break;
/*            case R.id.change_settinmgs_save_btn:
       //TODO: сделать передачу, что надо обновить адаптер
        Intent intent = new Intent();
        intent.putExtra(ConstantManager.M180_URL_APN_DEVICE, mApnEt.getText().toString());
        intent.putExtra(ConstantManager.M180_LOGIN_APN_DEVICE, mOcLoginEt.getText().toString());
        intent.putExtra(ConstantManager.M180_PASSWORD_APN_DEVICE, mOcPassEt.getText().toString());
        setResult(RESULT_OK, intent);
                saveDeviceM180SettingsDataToInternet();
                break;*/
/*            case R.id.go_set_control_tv:
                Intent goSetControlIntent = new Intent(M180SettingsActivity.this, control_activity.class);
                goSetControlIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivity(goSetControlIntent);
                break;
            case R.id.go_track_tv:
                Intent goTrackIntent = new Intent(M180SettingsActivity.this, viewtrack_activity.class);
                goTrackIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivity(goTrackIntent);
                break;*/
        }
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();
        switch (id) {
            case R.id.action_remove:
                deleteDevice();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void deleteDevice(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.deviceDelete(new DeviceDeleteReq(ConstantManager.JSON_METHODS[ConstantManager.DEVICE_DELETE], new DeviceDeleteOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDeviceDTO.getDTOIdDevice())));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.DEVICE_DELETE));
                         }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.DEVICE_DELETE));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Неверный логин или пароль!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }
                @Override
                public void onFailure(Call<UserAccoutActionRes> call, Throwable t) {
                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void loadDeviceM180SettingsDataFromInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180SettingsDeviceRes> call = mDataManager.getM180SettingsDeviceFromNetwork(
                    new M180SettingsDeviceReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                    new M180SettingsDeviceOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                    new M180SettingsDeviceData(
                                    ConstantManager.M180_MODE_DEVICE, //0
                                    ConstantManager.M180_LANGUAGE_DEVICE, //1
                                    ConstantManager.M180_NAME_DEVICE, //2
                                    ConstantManager.M180_NAME_DEVICE_ON, //3
                                    ConstantManager.M180_GPS_URL_DEVICE, //4
                                    ConstantManager.M180_GPS_DEVICE_ON, //5
                                    ConstantManager.M180_UNSLEEP_SMS_DEVICE, //6
                                    ConstantManager.M180_WORRY_CALL_DEVICE, //7
                                    ConstantManager.M180_TIME_PARK_DEVICE, //8
                                    ConstantManager.M180_UTC_DEVICE, //9
                                    ConstantManager.M180_LBS_DEVICE_ON,  //10
                                    ConstantManager.M180_BALANCE_DEVICE_ON, //48
                                    ConstantManager.M180_MIN_BALANCE_DEVICE, //49
                                    ConstantManager.M180_USSD_BALANCE_DEVICE, //50
                                    ConstantManager.M180_BUTTON_DEVICE_ON, //51
                                    ConstantManager.M180_MOVE_DEVICE, //52
                                    ConstantManager.M180_MOVE_DEVICE_ON,
                                    ConstantManager.M180_UNMOVE_DEVICE, //54
                                    ConstantManager.M180_UNMOVE_DEVICE_ON,
                                    ConstantManager.M180_SPEED_DEVICE, //56
                                    ConstantManager.M180_SPEED_DEVICE_ON,
                                    ConstantManager.M180_JACK_DEVICE_ON, 
                                    ConstantManager.M180_TEMP_DEVICE_ON, //59
                                    ConstantManager.M180_TEMP_DEVICE_1, //60
                                    ConstantManager.M180_TEMP_DEVICE_2,  //61
                                    ConstantManager.M180_TEMP_RELAY_SMS_DEVICE, //63
                                    ConstantManager.M180_TEMP_IMP_DEVICE, 
                                    ConstantManager.M180_INTERNET_DEVICE_ON, //65
                                    ConstantManager.M180_URL_SERVER_DEVICE, //66
                                    ConstantManager.M180_PORT_SEVER_DEVICE,//67
                                    ConstantManager.M180_URL_APN_DEVICE, //68
                                    ConstantManager.M180_LOGIN_APN_DEVICE,//69
                                    ConstantManager.M180_PASSWORD_APN_DEVICE, //70
                                    ConstantManager.M180_TIME_SEND_MESSAGE_DEVICE, //71
                                    ConstantManager.M180_ADTRACK_DEVICE_ON, //72
                                    ConstantManager.M180_DATE_DEVICE_DATA, //73
                                    ConstantManager.M180_BATTERY_DEVICE, //74
                                    ConstantManager.M180_LONGITUBE_DEVICE_GPS,//75
                                    ConstantManager.M180_LATITUBE_DEVICE_GPS, //76
                                    ConstantManager.M180_DATE_DEVICE_GPS,//77
                                    ConstantManager.M180_COUNT_DEVICE_GPS, //78
                                    ConstantManager.M180_LONGITUBE_DEVICE_LBS,//79
                                    ConstantManager.M180_LATITUBE_DEVICE_LBS, //80
                                    ConstantManager.M180_DATE_DEVICE_LBS,//81
                                    ConstantManager.M180_COUNT_DEVICE_LBS, //82
                                    ConstantManager.M180_BALANCE_DEVICE,//83
                                    ConstantManager.M180_TEMP_DEVICE, //84
                                    ConstantManager.M180_LONGITUBE_DEVICE,//85
                                    ConstantManager.M180_LATITUBE_DEVICE, //86
                                    ConstantManager.M180_RADUIS_DEVICE))));
            call.enqueue(new Callback<M180SettingsDeviceRes>() {
                @Override
                public void onResponse(Call<M180SettingsDeviceRes> call, Response<M180SettingsDeviceRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            mDevice = response.body().getData();
                            mM180_MODE_DEVICESp.setSelection(mDevice.get(42).getLanguageDevice());
                            mM180_LANGUAGE_DEVICESp.setSelection(mDevice.get(32).getLanguageDevice());
                            mM180_NAME_DEVICETv.setText("Имя: "+mDevice.get(45).getNameDevice());
                   //         mM180_GPS_URL_DEVICESp.setSelection(mDevice.get(29).getGpsUrlDevice());
                            mM180_UNSLEEP_SMS_DEVICESp.setSelection(mDevice.get(82).getUnsleepSmsDevice());
                            mM180_WORRY_CALL_DEVICESp.setSelection(mDevice.get(87).getWorryCallDevice());
                            mM180_TIME_PARK_DEVICE_hour_Et.setText(mDevice.get(77).getTimeParkDevice().substring(0,mDevice.get(77).getTimeParkDevice().indexOf(":")));

                            mM180_TIME_PARK_DEVICE_minute_Et.setText(mDevice.get(77).getTimeParkDevice().substring(mDevice.get(77).getTimeParkDevice().indexOf(":")));
                            mM180_UTC_DEVICEEt.setText(mDevice.get(86).getUtcDevice());
                            if (Integer.valueOf(mDevice.get(36).getLbsDeviceOn())==1){
                                mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_LBS_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_LBS_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(mDevice.get(20).getBalanceDeviceOn())==1){
                                mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_BALANCE_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_BALANCE_DEVICE_ONSw.setChecked(FALSE);
                            }
                            mM180_MIN_BALANCE_DEVICEEt.setText(mDevice.get(41).getMinBalanceDevice());

/*                            mM180_USSD_BALANCE_DEVICEEt.setText(mDevice.get(85).getUssdBalanceDevice());*/
                            if (Integer.valueOf(mDevice.get(22).getButtonDeviceOn())==1){
                                mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_BUTTON_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_BUTTON_DEVICE_ONSw.setChecked(FALSE);
                            }
                            mM180_MOVE_DEVICEEt.setText(Integer.toString(mDevice.get(43).getMoveDevice()));
                            if (Integer.valueOf(mDevice.get(44).getMoveDeviceOn())==1){
                                mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_MOVE_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_MOVE_DEVICE_ONSw.setChecked(FALSE);
                            }
                            mM180_UNMOVE_DEVICEEt.setText(Integer.toString(mDevice.get(80).getUnmoveDevice()));
                            if (Integer.valueOf(mDevice.get(79).getUnmoveDeviceOn())==1){
                                mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_UNMOVE_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_UNMOVE_DEVICE_ONSw.setChecked(FALSE);
                            }
                            mM180_SPEED_DEVICEEt.setText(Integer.toString(mDevice.get(68).getSpeedDevice()));
                            if (Integer.valueOf(mDevice.get(69).getSpeedDeviceOn())==1){
                                mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_SPEED_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_SPEED_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(mDevice.get(31).getJackDeviceOn())==1){
                                mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_JACK_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_JACK_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(mDevice.get(73).getTempDeviceOn())==1){
                                mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_TEMP_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_TEMP_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(mDevice.get(75).getTempRelaySmsDevice())==1){
                                mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchon));
                                mM180_TEMP_RELAY_SMS_DEVICESw.setChecked(TRUE);
                            }else{
                                mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchoff));
                                mM180_TEMP_RELAY_SMS_DEVICESw.setChecked(FALSE);
                            }
                            mM180_TEMP_IMP_DEVICEEt.setText(Integer.toString(mDevice.get(74).getTempImpDevice()));
                            if (Integer.valueOf(mDevice.get(30).getInternetDeviceOn())==1){
                                mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_INTERNET_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_INTERNET_DEVICE_ONSw.setChecked(FALSE);
                            }
                            mM180_TIME_SEND_MESSAGE_DEVICEEt.setText(Integer.toString(mDevice.get(78).getTimeSendMessageDevice()));
                            if (Integer.valueOf(mDevice.get(0).getAdtrackDeviceOn())==1){
                                mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_ADTRACK_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_ADTRACK_DEVICE_ONSw.setChecked(FALSE);
                            }
                            mM180_RADUIS_DEVICEEt.setText(Integer.toString(mDevice.get(56).getRadiusDevice()));
                            mM180_POINTTv.setText(mDevice.get(2).getLatitubeDevice()+"::"+mDevice.get(2).getLongitubeDevice());
                            mM180DeviceSettingsDTO = new M180DeviceSettingsDTO(
                                    mDevice.get(45).getNameDevice(), mDevice.get(46).getNameDeviceOn(),
                                    mDevice.get(70).getTempDevice1(), mDevice.get(71).getTempDevice2(),
                                    mDevice.get(84).getUrlServerDevice(), mDevice.get(66).getPortSeverDevice(),
                                    mDevice.get(83).getUrlApnDevice(), mDevice.get(37).getLoginApnDevice(),
                                    mDevice.get(47).getPasswordApnDevice(), mDevice.get(25).getDateDeviceData(),
                                    mDevice.get(21).getBatteryDevice(), /*mDevice.get(38).getLongitubeDeviceGps(),
                                    mDevice.get(33).getLatitubeDeviceGps(), mDevice.get(25).getDateDeviceGps(),
                                    mDevice.get(23).getCountDeviceGps(), mDevice.get(39).getLongitubeDeviceLbs(),
                                    mDevice.get(34).getLatitubeDeviceLbs(), mDevice.get(27).getDateDeviceLbs(),
                                    mDevice.get(24).getCountDeviceLbs(), */mDevice.get(19).getBalanceDevice(),
                                    mDevice.get(72).getTempDevice(), mDevice.get(40).getLongitubeDevice(),
                                    mDevice.get(35).getLatitubeDevice(), mDevice.get(67).getRadiusDevice());}
                        else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }
                @Override
                public void onFailure(Call<M180SettingsDeviceRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

   /* private void saveDeviceM180SettingsDataToInternet() {
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setM180SettingsDevice(
                    new M180SettingsDeviceReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180SettingsDeviceOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180SettingsDeviceData(
                                            String.valueOf(mDevice.get(42).getLanguageDevice()),
                                            String.valueOf(mDevice.get(32).getLanguageDevice()),
                                            String.valueOf(mDevice.get(45).getNameDevice()),
                                            String.valueOf(mDevice.get(46).getNameDeviceOn()),
                                            String.valueOf(mDevice.get(29).getGpsUrlDevice()),
                                            String.valueOf(mDevice.get(28).getGpsDeviceOn()),
                                            String.valueOf(mDevice.get(82).getUnsleepSmsDevice()),
                                            String.valueOf(mDevice.get(87).getWorryCallDevice()),
                                            String.valueOf(mDevice.get(77).getTimeParkDevice()),
                                            String.valueOf(mDevice.get(86).getUtcDevice()),
                                            String.valueOf(mDevice.get(36).getLbsDeviceOn()),
                                            String.valueOf(mDevice.get(81).getUnsleepAlarmDevice()),
                                            String.valueOf(mDevice.get(1).getAlarm1Device()),
                                            String.valueOf(mDevice.get(2).getAlarm1DeviceOn()),
                                            String.valueOf(mDevice.get(3).getAlarm2Device()),
                                            String.valueOf(mDevice.get(4).getAlarm2DeviceOn()),
                                            String.valueOf(mDevice.get(5).getAlarm3Device()),
                                            String.valueOf(mDevice.get(6).getAlarm3DeviceOn()),
                                            String.valueOf(mDevice.get(7).getAlarm4Device()),
                                            String.valueOf(mDevice.get(8).getAlarm4DeviceOn()),
                                            String.valueOf(mDevice.get(9).getAlarm5Device()),
                                            String.valueOf(mDevice.get(10).getAlarm5DeviceOn()),
                                            String.valueOf(mDevice.get(11).getAlarm6Device()),
                                            String.valueOf(mDevice.get(12).getAlarm6DeviceOn()),
                                            String.valueOf(mDevice.get(13).getAlarm7Device()),
                                            String.valueOf(mDevice.get(14).getAlarm7DeviceOn()),
                                            String.valueOf(mDevice.get(15).getAlarm8Device()),
                                            String.valueOf(mDevice.get(16).getAlarm8DeviceOn()),
                                            String.valueOf(mDevice.get(17).getAlarm9Device()),
                                            String.valueOf(mDevice.get(18).getAlarm9DeviceOn()),
                                            String.valueOf(mDevice.get(20).getBalanceDeviceOn()),
                                            String.valueOf(mDevice.get(41).getMinBalanceDevice()),
                                            String.valueOf(mDevice.get(85).getUssdBalanceDevice()),
                                            String.valueOf(mDevice.get(22).getButtonDeviceOn()),
                                            String.valueOf(mDevice.get(43).getMoveDevice()),
                                            String.valueOf(mDevice.get(44).getMoveDeviceOn()),
                                            String.valueOf(mDevice.get(80).getUnmoveDevice()),
                                            String.valueOf(mDevice.get(79).getUnmoveDeviceOn()),
                                            String.valueOf(mDevice.get(68).getSpeedDevice()),
                                            String.valueOf(mDevice.get(69).getSpeedDeviceOn()),
                                            String.valueOf(mDevice.get(31).getJackDeviceOn()),
                                            String.valueOf(mDevice.get(73).getTempDeviceOn()),
                                            String.valueOf(mDevice.get(70).getTempDevice1()),
                                            String.valueOf(mDevice.get(71).getTempDevice2()),
                                            String.valueOf(mDevice.get(75).getTempRelayDevice()),
                                            String.valueOf(mDevice.get(75).getTempRelaySmsDevice()),
                                            String.valueOf(mDevice.get(74).getTempImpDevice()),
                                            String.valueOf(mDevice.get(30).getInternetDeviceOn()),
                                            String.valueOf(mDevice.get(84).getUrlServerDevice()),
                                            String.valueOf(mDevice.get(66).getPortSeverDevice()),
                                            String.valueOf(mDevice.get(83).getUrlApnDevice()),
                                            String.valueOf(mDevice.get(37).getLoginApnDevice()),
                                            String.valueOf(mDevice.get(47).getPasswordApnDevice()),
                                            String.valueOf(mDevice.get(78).getTimeSendMessageDevice()),
                                            String.valueOf(mDevice.get(25).getDateDeviceData()),
                                            String.valueOf(mDevice.get(21).getBatteryDevice()),
                                            String.valueOf(mDevice.get(38).getLongitubeDeviceGps()),
                                            String.valueOf(mDevice.get(33).getLatitubeDeviceGps()),
                                            String.valueOf(mDevice.get(25).getDateDeviceGps()),
                                            String.valueOf(mDevice.get(23).getCountDeviceGps()),
                                            String.valueOf(mDevice.get(39).getLongitubeDeviceLbs()),
                                            String.valueOf(mDevice.get(34).getLatitubeDeviceLbs()),
                                            String.valueOf(mDevice.get(27).getDateDeviceLbs()),
                                            String.valueOf(mDevice.get(24).getCountDeviceLbs()),
                                            String.valueOf(mDevice.get(19).getBalanceDevice()),
                                            String.valueOf(mDevice.get(72).getTempDevice()),
                                            String.valueOf(mDevice.get(40).getLongitubeDevice()),
                                            String.valueOf(mDevice.get(35).getLatitubeDevice()),
                                            String.valueOf(mDevice.get(56).getRadiusDevice())))));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_DEVICE_DATA));
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_DEVICE_DATA));
                        }

                    } else if (response.code() == 404) {
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }

                @Override
                public void onFailure(Call<UserAccoutActionRes> call, Throwable t) {

                }
            });
        } else {
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }*/
}
