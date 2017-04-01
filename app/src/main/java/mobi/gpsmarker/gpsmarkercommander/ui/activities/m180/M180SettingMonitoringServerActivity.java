package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingMonitoringServerData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingMonitoringServerOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingMonitoringServerReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingMonitoringServerRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M180SettingMonitoringServerActivity extends BaseActivity implements View.OnClickListener{


    private EditText mUrlMoniServerEt, mPortMoniServerEt;
    private Button mSetOperationCellularEt;

    private Toolbar mToolbar;

    private CoordinatorLayout mCoordinatorLayout;
    private DataManager mDataManager;
    private List<M180SettingMonitoringServerRes.Datum> mSettingMonitoringServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_setting_monitoring_server);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_moni_server_toolbar);
        setupToolbar();
        mDataManager = DataManager.getInstance();
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.set_moni_ccordinator_container);
        mUrlMoniServerEt = (EditText) findViewById(R.id.set_url_monitoring_server_ed);
        mPortMoniServerEt = (EditText)findViewById(R.id.set_port_monitoring_server_ed);
        mSetOperationCellularEt = (Button) findViewById(R.id.set_mon_server_btn);
        mSetOperationCellularEt.setOnClickListener(this);
        loadSettingMonitoringServerFromInternet();

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

    private void loadSettingMonitoringServerFromInternet(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180SettingMonitoringServerRes> call = mDataManager.getSettingMonitoringServer(
                    new M180SettingMonitoringServerReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new M180SettingMonitoringServerOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180SettingMonitoringServerData(
                                            ConstantManager.M180_URL_APN_DEVICE,
                                            ConstantManager.M180_LOGIN_APN_DEVICE))));
            call.enqueue(new Callback<M180SettingMonitoringServerRes>() {
                @Override
                public void onResponse(Call<M180SettingMonitoringServerRes> call, Response<M180SettingMonitoringServerRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            mSettingMonitoringServer = response.body().getData();
                            mUrlMoniServerEt.setText(mSettingMonitoringServer.get(1).getUrlServerDevice());
                            mPortMoniServerEt.setText(Integer.toString(mSettingMonitoringServer.get(0).getPortSeverDevice()));

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
                public void onFailure(Call<M180SettingMonitoringServerRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void saveSettingMonitoringServerToInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setSettingMonitoringServer(
                    new M180SettingMonitoringServerReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180SettingMonitoringServerOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180SettingMonitoringServerData(
                                            mPortMoniServerEt.getText().toString(),
                                            mUrlMoniServerEt.getText().toString()))));
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


}
