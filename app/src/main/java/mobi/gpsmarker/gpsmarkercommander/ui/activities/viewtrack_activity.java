package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.CoordinateDTO;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

import static mobi.gpsmarker.gpsmarkercommander.R.layout.activity_viewtrack;

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
        setContentView(activity_viewtrack);
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
                    MarkerViewOptions markerViewOptions = new MarkerViewOptions()
                            .position(new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_lbs().toString().length() - 1)),
                                    Float.valueOf(Float.valueOf(mCoordinateDTO.getDTOLongitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLongitube_device_lbs().length() - 1)))))
                                    .title(mCoordinateDTO.getDTODate_device_lbs());
                    MarkerViewOptions markerViewOptions2 = new MarkerViewOptions()
                            .position(new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_gps().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_gps().toString().length() - 1)),
                                    Float.valueOf(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_gps().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_gps().length() - 1)))))
                            .title(mCoordinateDTO.getDTODate_device_gps());

                    //   .icon(icon);
                    // Customize map with markers, polylines, etc.
                    mapboxMap.addMarker(markerViewOptions);
//                mapboxMap.addMarker(markerViewOptions2);
                } else if (Integer.valueOf(mCoordinateDTO.getDTOgps_device_on()) == 0) {
                    MarkerViewOptions markerViewOptions = new MarkerViewOptions()
                            .position(new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLatitube_device_lbs().toString().length() - 1)),
                                    Float.valueOf(Float.valueOf(mCoordinateDTO.getDTOLongitube_device_lbs().toString().substring(1, mCoordinateDTO.getDTOLongitube_device_lbs().length() - 1)))))
                            .title(mCoordinateDTO.getDTODate_device_lbs());
//                MarkerViewOptions markerViewOptions2 = new MarkerViewOptions()
                    //     .position(new LatLng(53.526712, 49.313307))
                    //        .icon(icon);
                    // Customize map with markers, polylines, etc.
                    mapboxMap.addMarker(markerViewOptions);
//                mapboxMap.addMarker(markerViewOptions2);

                }
            }
        });
    }
    /*            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(MapboxMap mapboxMap) {
                IconFactory iconFactory = IconFactory.getInstance(viewtrack_activity.this);
                Drawable iconDrawable = ContextCompat.getDrawable(viewtrack_activity.this, R.drawable.ic_lbs_25dp);
                Icon icon = iconFactory.fromDrawable(iconDrawable);
                    MarkerViewOptions markerViewOptions = new MarkerViewOptions()
                            .position(new LatLng(Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString()), Float.valueOf(mCoordinateDTO.getDTOLatitube_device_lbs().toString())))
                            .title(mCoordinateDTO.getDTODate_device_lbs());
                MarkerViewOptions markerViewOptions2 = new MarkerViewOptions()
                        .position(new LatLng(53.526712, 49.313307))
                        .icon(icon);
                    // Customize map with markers, polylines, etc.
                    mapboxMap.addMarker(markerViewOptions);
//                mapboxMap.addMarker(markerViewOptions2);*/




        // Add a MapboxMap


/*
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }*/



    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
