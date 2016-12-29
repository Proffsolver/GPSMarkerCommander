package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import mobi.gpsmarker.gpsmarkercommander.R;

import static mobi.gpsmarker.gpsmarkercommander.R.layout.activity_viewtrack;

public class viewtrack_activity extends AppCompatActivity {

    private MapView mapView;
    private MapboxMap mMapboxMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapboxAccountManager.start(this, getString(R.string.access_token));
        setContentView(activity_viewtrack);



        // Create a mapView
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Add a MapboxMap
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
/*                IconFactory iconFactory = IconFactory.getInstance(viewtrack_activity.this);
                Drawable iconDrawable = ContextCompat.getDrawable(viewtrack_activity.this, R.drawable.ic_lbs_25dp);
                Icon icon = iconFactory.fromDrawable(iconDrawable);*/
                MarkerViewOptions markerViewOptions = new MarkerViewOptions()
                        .position(new LatLng(53.530192, 49.313742));
/*                MarkerViewOptions markerViewOptions2 = new MarkerViewOptions()
                        .position(new LatLng(53.526712, 49.313307))
                        .icon(icon);*/
                // Customize map with markers, polylines, etc.
                mapboxMap.addMarker(markerViewOptions);
//                mapboxMap.addMarker(markerViewOptions2);

            }
        });
    }

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
    }
}
