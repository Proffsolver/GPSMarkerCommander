package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListPhonesData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListPhonesOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListPhonesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180DeviceListPhonesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class M180ListPhonesActivity extends BaseActivity implements View.OnClickListener{

    private SwitchCompat mPhone1_Sw, mPhone2_Sw, mPhone3_Sw, mPhone4_Sw, mPhone5_Sw, mPhone6_Sw, mPhone7_Sw, mPhone8_Sw, mPhone9_Sw;
    private EditText mPhone1_Et, mPhone2_Et, mPhone3_Et, mPhone4_Et, mPhone5_Et, mPhone6_Et, mPhone7_Et, mPhone8_Et, mPhone9_Et;
    private Button mPhonesSaveBtn;
    private Toolbar mToolbar;
    private DataManager mDataManager;
    private List<M180DeviceListPhonesRes.Datum> mDeviceListPhones;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
        setContentView(R.layout.m180_activity_list_phones);
        mToolbar = (Toolbar) findViewById(R.id.M180_list_phones_toolbar);
        setupToolbar();
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.device_list_phones_coordinator_layout);



        mPhonesSaveBtn = (Button) findViewById(R.id.phones_save_btn);
        mPhonesSaveBtn.setOnClickListener(this);

  /*       mPhone2_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone2_Et, (TextInputLayout) findViewById(R.id.phone_2_til), mPhonesSaveBtn));
        mPhone3_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone3_Et, (TextInputLayout) findViewById(R.id.phone_3_til), mPhonesSaveBtn));
        mPhone4_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone4_Et, (TextInputLayout) findViewById(R.id.phone_4_til), mPhonesSaveBtn));
        mPhone5_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone5_Et, (TextInputLayout) findViewById(R.id.phone_5_til), mPhonesSaveBtn));
        mPhone6_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone6_Et, (TextInputLayout) findViewById(R.id.phone_6_til), mPhonesSaveBtn));
        mPhone7_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone7_Et, (TextInputLayout) findViewById(R.id.phone_7_til), mPhonesSaveBtn));
        mPhone8_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone8_Et, (TextInputLayout) findViewById(R.id.phone_8_til), mPhonesSaveBtn));
        mPhone9_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone9_Et, (TextInputLayout) findViewById(R.id.phone_9_til), mPhonesSaveBtn));*/
        loadListPhonesFromInternet();
    }

    public void onClick(View v) {

        saveListPhonesFromInternet();
        finish();
    }
    //TODO Сделать проверку введенных телефонов
 /*   private void checkInputPhone(){
        UserInputChecker(getBaseContext(), mPhone2_Et, (TextInputLayout),mPhonesSaveBtn);
    }*/

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadListPhonesFromInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180DeviceListPhonesRes> call = mDataManager.getM180DeviceListPhones(
                    new M180GetDeviceListPhonesReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new M180GetDeviceListPhonesOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180GetDeviceListPhonesData(
                                            ConstantManager.M180_PHONE_1_DEVICE, //11
                                            ConstantManager.M180_PHONE_1_DEVICE_ON,
                                            ConstantManager.M180_PHONE_2_DEVICE,
                                            ConstantManager.M180_PHONE_2_DEVICE_ON,
                                            ConstantManager.M180_PHONE_3_DEVICE, //15
                                            ConstantManager.M180_PHONE_3_DEVICE_ON,
                                            ConstantManager.M180_PHONE_4_DEVICE,
                                            ConstantManager.M180_PHONE_4_DEVICE_ON,
                                            ConstantManager.M180_PHONE_5_DEVICE,
                                            ConstantManager.M180_PHONE_5_DEVICE_ON, //20
                                            ConstantManager.M180_PHONE_6_DEVICE,
                                            ConstantManager.M180_PHONE_6_DEVICE_ON,
                                            ConstantManager.M180_PHONE_7_DEVICE,
                                            ConstantManager.M180_PHONE_7_DEVICE_ON,
                                            ConstantManager.M180_PHONE_8_DEVICE, //25
                                            ConstantManager.M180_PHONE_8_DEVICE_ON,
                                            ConstantManager.M180_PHONE_9_DEVICE,
                                            ConstantManager.M180_PHONE_9_DEVICE_ON))));
            call.enqueue(new Callback<M180DeviceListPhonesRes>() {
                @Override
                public void onResponse(Call<M180DeviceListPhonesRes> call, Response<M180DeviceListPhonesRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            mDeviceListPhones = response.body().getData();        mPhone1_Et = (EditText) findViewById(R.id.phone_1_ed);
                            mPhone1_Et.setText(mDeviceListPhones.get(0).getPhone1Device());

                            mPhone1_Sw = (SwitchCompat) findViewById(R.id.phone_1_sw);
                            mPhone1_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone1_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone1_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });
                            if (Integer.valueOf(mDeviceListPhones.get(1).getPhone1DeviceOn())==1){
                                mPhone1_Sw.setText(getString(R.string.switchon));
                                mPhone1_Sw.setChecked(TRUE);
                            }else{
                                mPhone1_Sw.setText(getString(R.string.switchoff));
                                mPhone1_Sw.setChecked(FALSE);
                            }

                            mPhone2_Et = (EditText) findViewById(R.id.phone_2_ed);
                            mPhone2_Et.setText(mDeviceListPhones.get(2).getPhone1Device());

                            mPhone2_Sw = (SwitchCompat) findViewById(R.id.phone_2_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(3).getPhone1DeviceOn())==1){
                                mPhone2_Sw.setText(getString(R.string.switchon));
                                mPhone2_Sw.setChecked(TRUE);
                            }else{
                                mPhone2_Sw.setText(getString(R.string.switchoff));
                                mPhone2_Sw.setChecked(FALSE);
                            }
                            mPhone2_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone2_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone2_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mPhone3_Et = (EditText) findViewById(R.id.phone_3_ed);
                            mPhone3_Et.setText(mDeviceListPhones.get(4).getPhone1Device());

                            mPhone3_Sw = (SwitchCompat) findViewById(R.id.phone_3_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(5).getPhone1DeviceOn())==1){
                                mPhone3_Sw.setText(getString(R.string.switchon));
                                mPhone3_Sw.setChecked(TRUE);
                            }else{
                                mPhone3_Sw.setText(getString(R.string.switchoff));
                                mPhone3_Sw.setChecked(FALSE);
                            }
                            mPhone3_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone3_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone3_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mPhone4_Et = (EditText) findViewById(R.id.phone_4_ed);
                            mPhone4_Et.setText(mDeviceListPhones.get(6).getPhone1Device());

                            mPhone4_Sw = (SwitchCompat) findViewById(R.id.phone_4_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(7).getPhone1DeviceOn())==1){
                                mPhone4_Sw.setText(getString(R.string.switchon));
                                mPhone4_Sw.setChecked(TRUE);
                            }else{
                                mPhone4_Sw.setText(getString(R.string.switchoff));
                                mPhone4_Sw.setChecked(FALSE);
                            }
                            mPhone4_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone4_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone4_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mPhone5_Et = (EditText) findViewById(R.id.phone_5_ed);
                            mPhone5_Et.setText(mDeviceListPhones.get(8).getPhone1Device());

                            mPhone5_Sw = (SwitchCompat) findViewById(R.id.phone_5_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(9).getPhone1DeviceOn())==1){
                                mPhone5_Sw.setText(getString(R.string.switchon));
                                mPhone5_Sw.setChecked(TRUE);
                            }else{
                                mPhone5_Sw.setText(getString(R.string.switchoff));
                                mPhone5_Sw.setChecked(FALSE);
                            }
                            mPhone5_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone5_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone5_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mPhone6_Et = (EditText) findViewById(R.id.phone_6_ed);
                            mPhone6_Et.setText(mDeviceListPhones.get(10).getPhone1Device());

                            mPhone6_Sw = (SwitchCompat) findViewById(R.id.phone_6_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(11).getPhone1DeviceOn())==1){
                                mPhone6_Sw.setText(getString(R.string.switchon));
                                mPhone6_Sw.setChecked(TRUE);
                            }else{
                                mPhone6_Sw.setText(getString(R.string.switchoff));
                                mPhone6_Sw.setChecked(FALSE);
                            }
                            mPhone6_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone6_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone6_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mPhone7_Et = (EditText) findViewById(R.id.phone_7_ed);
                            mPhone7_Et.setText(mDeviceListPhones.get(12).getPhone1Device());

                            mPhone7_Sw = (SwitchCompat) findViewById(R.id.phone_7_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(13).getPhone1DeviceOn())==1){
                                mPhone7_Sw.setText(getString(R.string.switchon));
                                mPhone7_Sw.setChecked(TRUE);
                            }else{
                                mPhone7_Sw.setText(getString(R.string.switchoff));
                                mPhone7_Sw.setChecked(FALSE);
                            }
                            mPhone7_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone7_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone7_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mPhone8_Et = (EditText) findViewById(R.id.phone_8_ed);
                            mPhone8_Et.setText(mDeviceListPhones.get(14).getPhone1Device());

                            mPhone8_Sw = (SwitchCompat) findViewById(R.id.phone_8_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(15).getPhone1DeviceOn())==1){
                                mPhone8_Sw.setText(getString(R.string.switchon));
                                mPhone8_Sw.setChecked(TRUE);
                            }else{
                                mPhone8_Sw.setText(getString(R.string.switchoff));
                                mPhone8_Sw.setChecked(FALSE);
                            }
                            mPhone8_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone8_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone8_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mPhone9_Et = (EditText) findViewById(R.id.phone_9_ed);
                            mPhone9_Et.setText(mDeviceListPhones.get(16).getPhone1Device());

                            mPhone9_Sw = (SwitchCompat) findViewById(R.id.phone_9_sw);
                            if (Integer.valueOf(mDeviceListPhones.get(17).getPhone1DeviceOn())==1){
                                mPhone9_Sw.setText(getString(R.string.switchon));
                                mPhone9_Sw.setChecked(TRUE);
                            }else{
                                mPhone9_Sw.setText(getString(R.string.switchoff));
                                mPhone9_Sw.setChecked(FALSE);
                            }
                            mPhonesSaveBtn = (Button) findViewById(R.id.phones_save_btn);
                            mPhone9_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mPhone9_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mPhone9_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            }
                            );        //mPhone1_Et.addTextChangedListener(new UserInputChecker(getBaseContext(), mPhone1_Et, (TextInputLayout) findViewById(R.id.phone_1_til), mPhonesSaveBtn));
                        } else {
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(), ConstantManager.GET_DEVICES_DATA));
                        }
                    } else if (response.code() == 404) {
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }
                @Override
                public void onFailure(Call<M180DeviceListPhonesRes> call, Throwable t) {

                }
            });
        }else{
                showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
            }
        }

    private void saveListPhonesFromInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setDeviceListPhones(
                    new M180GetDeviceListPhonesReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180GetDeviceListPhonesOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180GetDeviceListPhonesData(
                                            String.valueOf(mPhone1_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone1_Sw)),
                                            String.valueOf(mPhone2_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone2_Sw)),
                                            String.valueOf(mPhone3_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone3_Sw)),
                                            String.valueOf(mPhone4_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone4_Sw)),
                                            String.valueOf(mPhone5_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone5_Sw)),
                                            String.valueOf(mPhone6_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone6_Sw)),
                                            String.valueOf(mPhone7_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone7_Sw)),
                                            String.valueOf(mPhone8_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone8_Sw)),
                                            String.valueOf(mPhone9_Et.getText().toString()),
                                            String.valueOf(checkerSW(mPhone9_Sw))))));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_DEVICE_DATA));
                        } else {
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(), ConstantManager.SET_DEVICE_DATA));
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
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message,Snackbar.LENGTH_LONG).show();
    }

    private int checkerSW(SwitchCompat sw){
        int iCh;
        if(sw.isChecked()){
            iCh=1;
        }
        else{
            iCh=0;
        }
        return iCh;
    }
}
