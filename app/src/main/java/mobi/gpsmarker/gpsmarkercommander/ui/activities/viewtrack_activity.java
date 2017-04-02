package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.CoordinateDTO;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class viewtrack_activity extends AppCompatActivity {

    private MapView mapView;
    private MapboxMap mMapboxMap;
    private Toolbar mToolbar;
    private CoordinateDTO mCoordinateDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCoordinateDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        MapboxAccountManager.start(this, getString(R.string.access_token));
        setContentView(R.layout.activity_viewtrack);
        mToolbar = (Toolbar) findViewById(R.id.map_toolbar);
        setupToolbar();
        // Create a mapView
        mapView = (MapView) findViewById(R.id.mapview);
        int i =Integer.valueOf(mCoordinateDTO.getDTOgps_device_on());
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                if ((Integer.valueOf(mCoordinateDTO.getDTOlbs_device_on()) == 1) && Integer.valueOf(mCoordinateDTO.getDTOgps_device_on()) == 1) {
                    MarkerViewOptions markerViewOptionsGPS = new MarkerViewOptions()
                            .position(new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_lbs().toString().length() - 1)),
                                    Float.valueOf(Float.valueOf(mCoordinateDTO.getDTOLongitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLongitube_device_lbs().length() - 1)))))
                                    .title(mCoordinateDTO.getDTODate_device_lbs())
                                .snippet(mCoordinateDTO.getDTODate_device_lbs());
                    MarkerViewOptions markerViewOptionsLBS = new MarkerViewOptions()
                            .position(new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_gps().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_gps().toString().length() - 1)),
                                    Float.valueOf(mCoordinateDTO.getDTOLatitube_device_gps().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_gps().length() - 1))))
                            .title(mCoordinateDTO.getDTODate_device_gps())
                            .snippet(mCoordinateDTO.getDTODate_device_gps());
                    mapboxMap.addMarker(markerViewOptionsGPS);
                    mapboxMap.addMarker(markerViewOptionsLBS);
                    LatLng cordiante = new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_lbs().toString().length() - 1)),
                            Float.valueOf(mCoordinateDTO.getDTOLongitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLongitube_device_lbs().length() - 1)));
                    CameraPosition position = new CameraPosition.Builder()
                            .target(cordiante) // Sets the new camera position
                            .zoom(10) // Sets the zoom
                            .bearing(180) // Rotate the camera
                            .tilt(30)
                            .build();
                    mapboxMap.animateCamera(CameraUpdateFactory
                            .newCameraPosition(position), 7000);
//                mapboxMap.addMarker(markerViewOptions2);
                } else if (Integer.valueOf(mCoordinateDTO.getDTOgps_device_on()) == 0) {
                    MarkerViewOptions markerViewOptions = new MarkerViewOptions()
                            .position(new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_lbs().toString().length() - 1)),
                                    Float.valueOf(mCoordinateDTO.getDTOLongitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLongitube_device_lbs().length() - 1))))
                            .title(mCoordinateDTO.getDTODate_device_lbs())
                            .snippet(mCoordinateDTO.getDTODate_device_lbs());
                    mapboxMap.addMarker(markerViewOptions);
                    LatLng cordiante = new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_lbs().toString().length() - 1)),
                            Float.valueOf(mCoordinateDTO.getDTOLongitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLongitube_device_lbs().length() - 1)));
                    CameraPosition position = new CameraPosition.Builder()
                            .target(cordiante) // Sets the new camera position
                            .zoom(10) // Sets the zoom
                            .bearing(180) // Rotate the camera
                            .tilt(30)
                            .build();
                    mapboxMap.animateCamera(CameraUpdateFactory
                            .newCameraPosition(position), 7000);
                }
            }
        });
    }


    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
