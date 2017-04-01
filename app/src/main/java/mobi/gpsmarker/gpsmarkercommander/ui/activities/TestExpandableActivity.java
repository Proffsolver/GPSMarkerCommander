package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180StatusRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceData;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.CoordinateDTO;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesAdapter;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesExpListAdapter;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class TestExpandableActivity extends AppCompatActivity {


    private static final String TAG = ConstantManager.TAG_PREFIX+"Main Activity";
    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private int mDrawerStart=0;
    private FloatingActionButton mFab;
    private DataManager mDataManager;
    private NavigationView mNavigationView;
    private TextView mHeaderEmail, mHeaderMobile;
    private Spinner mSpinner;
    private List<GetDevicesRes.Device> mDevices;
    private DevicesAdapter mDevicesAdapter;
    private RecyclerView mRecyclerView;
    private CoordinateDTO mCoordinateDTO;
    private DevicesAdapter.CustomClickListener mCustomClickListener;
    private ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_expandable);
        Log.d(TAG, "OnCreate");
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        //mHeaderImage = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.image_header);
        mDataManager = DataManager.getInstance();
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_ccordinator_container);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
    //    loadDeviceDataNetwork();
        ExpandableListView listView = (ExpandableListView)findViewById(R.id.exListView);

        //Создаем набор данных для адаптера
/*        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        ArrayList<String> children1 = new ArrayList<String>();
        ArrayList<String> children2 = new ArrayList<String>();
        children1.add("Child_1");
        groups.add(children1);
        children2.add("Child_1");
        children2.add("Child_2");
        children2.add("Child_3");
        groups.add(children2);
        //Создаем адаптер и передаем context и список с данными
        DevicesExpListAdapter adapter = new DevicesExpListAdapter(getApplicationContext(), groups);
        listView.setAdapter(adapter);*/
        setupToolbar();

    }

    private void loadDeviceDataNetwork(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<GetDevicesRes> call = mDataManager.getDevicesFromNetwork(new GetDevicesReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES], new GetDevicesOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken())));
            call.enqueue(new Callback<GetDevicesRes>() {
                @Override
                public void onResponse(Call<GetDevicesRes> call, Response<GetDevicesRes> response) {
                    if (response.code() == 200){
                        mDevices = response.body().getDevices();
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES));
                            ArrayList<DeviceData> deviceData = new ArrayList<DeviceData>();
                            ArrayList<String> children = new ArrayList<String>();
                            ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
                            for (int i = 0 ; i<mDevices.size(); i++){
                                children.add(mDevices.get(i).getIdDevice());
                                groups.add(children);
                                ArrayList forStatus = new ArrayList(loadCurrentCoordinateSyncFromInternet(mDevices.get(i).getIdDevice()));
                                deviceData.set(i, new DeviceData(mDevices.get(i).getIdDevice(),
                                        mDevices.get(i).getIdDeviceType(),
                                        mDevices.get(i).getNameDevice(),
                                        mDevices.get(i).getImeiDevice(),
                                        forStatus.get(0).toString(),
                                        forStatus.get(1).toString(),
                                        forStatus.get(2).toString(),
                                        forStatus.get(3).toString(),
                                        forStatus.get(4).toString(),
                                        forStatus.get(5).toString()));
                            }
                            DevicesExpListAdapter adapter = new DevicesExpListAdapter(getApplicationContext(), groups, deviceData);
                            listView.setAdapter(adapter);
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES));

                        }
                    } else if (response.code() == 404){
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }

                @Override
                public void onFailure(Call<GetDevicesRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }


    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message,Snackbar.LENGTH_LONG).show();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerStart == 1){
            mDrawerStart = 0;
            mNavigationDrawer.closeDrawer(GravityCompat.START);
        } else {super.onBackPressed();}
    }


    private ArrayList loadCurrentCoordinateSyncFromInternet(String currentDeviceID){
        ArrayList forStatus = new ArrayList();
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180StatusRes> call = mDataManager.getM180Status(
                    new M180StatusReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new M180StatusOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), currentDeviceID,
                                    new M180StatusData(ConstantManager.M180_BATTERY_DEVICE,
                                            ConstantManager.M180_BALANCE_DEVICE,
                                            ConstantManager.M180_COUNT_DEVICE_GPS,
                                            ConstantManager.M180_COUNT_DEVICE_LBS,
                                            ConstantManager.M180_DATE_DEVICE_DATA,
                                            ConstantManager.M180_TEMP_DEVICE))));
            try {
                Response<M180StatusRes> mStatus = call.execute();
                for (int i=0; i<mStatus.body().getData().size(); i++){forStatus.add(i,"0");}
                for (int i=0; i<mStatus.body().getData().size(); i++){
                    if (mStatus.body().getData().get(i).getBalanceDevice()!=null){
                        forStatus.set(0,mStatus.body().getData().get(i).getBalanceDevice());
                    }
                    if (mStatus.body().getData().get(i).getBatteryDevice()!=null){
                        forStatus.set(1,mStatus.body().getData().get(i).getBatteryDevice());
                    }
                    if (mStatus.body().getData().get(i).getCountDeviceGps()!=null){
                        forStatus.set(2,mStatus.body().getData().get(i).getCountDeviceGps());
                    }
                    if (mStatus.body().getData().get(i).getCountDeviceLbs()!=null){
                        forStatus.set(3,mStatus.body().getData().get(i).getCountDeviceLbs());
                    }
                    if (mStatus.body().getData().get(i).getDateDeviceData()!=null){
                        forStatus.set(4, mStatus.body().getData().get(i).getDateDeviceData());
                    }
                    if (mStatus.body().getData().get(i).getTempDevice()!=null){
                        forStatus.set(5,mStatus.body().getData().get(i).getTempDevice());
                    }
                }
                mCoordinateDTO = new CoordinateDTO(forStatus.get(0).toString(),forStatus.get(1).toString(),forStatus.get(2).toString(),forStatus.get(3).toString(),forStatus.get(4).toString(),forStatus.get(5).toString(),Integer.valueOf(forStatus.get(6).toString()),Integer.valueOf(forStatus.get(7).toString()));
            } catch (IOException e) {
            }
        }
        return forStatus;
    }


}
