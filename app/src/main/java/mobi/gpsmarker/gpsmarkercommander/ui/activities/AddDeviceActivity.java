package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceAddOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceAddReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import mobi.gpsmarker.gpsmarkercommander.utils.UserInputChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDeviceActivity extends BaseActivity implements View.OnClickListener  {

    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private EditText mDeviceNameEt, mDeviceIMEIEt;
    private DrawerLayout mNavigationDrawer;
    private DataManager mDataManager;
    private Spinner mSpinner;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
        mToolbar = (Toolbar) findViewById(R.id.add_device_toolbar);
        setupToolbar();
        mDataManager = DataManager.getInstance();
        mDeviceNameEt = (EditText) findViewById(R.id.device_name_add_et);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.add_dev_coordinator_container);
        mDeviceIMEIEt = (EditText) findViewById(R.id.device_imei_add_et);

        ArrayAdapter<String> mAdapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.DEVICE_TYPE_STRINGS);
        mAdapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner = (Spinner) findViewById(R.id.device_type_add_sp);
        mSpinner.setAdapter(mAdapterSpinner);
        mSpinner.setSelection(0);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        mButton = (Button) findViewById(R.id.device_add_btn);
        mButton.setOnClickListener(this);
        mDeviceIMEIEt.addTextChangedListener(new UserInputChecker(getBaseContext(), mDeviceIMEIEt, (TextInputLayout) findViewById(R.id.device_imei_til), mButton));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.device_add_btn:
                addDevice();
                break;
        }
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void addDevice(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.newDeviceAdd(new DeviceAddReq(ConstantManager.JSON_METHODS[ConstantManager.DEVICE_REGISTRATION], new DeviceAddOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), Integer.toString(mSpinner.getSelectedItemPosition()+1), mDeviceIMEIEt.getText().toString(), mDeviceNameEt.getText().toString())));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.DEVICE_REGISTRATION));
                            AddDeviceActivity.this.finish();
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.DEVICE_REGISTRATION));
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

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
