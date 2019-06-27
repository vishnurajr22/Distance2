package com.app.distance2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app.distance2.directionhelpers.DistanceDuration;
import com.app.distance2.directionhelpers.FetchURL;
import com.app.distance2.directionhelpers.TaskLoadedCallback;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import org.joda.time.DateTime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, TaskLoadedCallback, DistanceDuration {

    private static GoogleMap mMap;
    private Circle mCircle;
    private Marker mMarker;
    LocationManager locationManager;
    List<LatLng> markerpoints;
    private Polyline currentPolyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Log.d("TAG", "onCreate");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        new FetchURL(MainActivity.this).execute("http://192.168.25.197/myweb/jsonMap.php", "driving");
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 20 * 1000, 0, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();
                            int strokeColor = 0xffff0000;
                            int shadeColor = 0x44ff0000;
                            //instantiate the class geocoder>>for the adress from latling
                            Geocoder geocoder = new Geocoder(getApplicationContext());
                            LatLng latLng = new LatLng(latitude, longitude);
                            try {
                                List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 5);
                                String str = addressList.get(0).getLocality();
                                for (int i = 0; i < markerpoints.size(); i++) {
                                    LatLng place = (LatLng) markerpoints.get(i);
                                    CircleOptions circleOptions = new CircleOptions().center(place).radius(100.0).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(2);
                                    Circle circle = mMap.addCircle(circleOptions);
                                    float[] distance = new float[2];


                    Location.distanceBetween(location.getLatitude(), location.getLongitude(),
                            circle.getCenter().latitude, circle.getCenter().longitude, distance);

                    if (distance[0] > circle.getRadius()) {
                        Toast.makeText(getBaseContext(), "Outside, distance from center: " + distance[0] + " radius: " + circle.getRadius(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getBaseContext(), "Inside, distance from center: " + distance[0] + " radius: " + circle.getRadius(), Toast.LENGTH_LONG).show();
                    }
                                }
                                //Toast.makeText(getBaseContext(), "NETWORK  " + "latitude: " + latitude + " longitude: " + longitude + "Locality" + str, Toast.LENGTH_LONG).show();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    });

        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();
                            //instantiate the class geocoder>>for the adress from latling
                            Geocoder geocoder = new Geocoder(getApplicationContext());
                            LatLng latLng = new LatLng(latitude, longitude);
                            try {
                                List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                                String str = addressList.get(0).getLocality();
                                Toast.makeText(getBaseContext(), "GPS  " + "latitude: " + latitude + " longitude: " + longitude + "Locality" + str, Toast.LENGTH_LONG).show();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    });

        }


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        drawMarkerWithCircle(markerpoints);
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Showing / hiding your current location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        // Enable / Disable zooming controls
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Enable / Disable my location button
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        // Enable / Disable Compass icon
        mMap.getUiSettings().setCompassEnabled(true);

        // Enable / Disable Rotate gesture
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        // Enable / Disable zooming functionality
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        try {




//            mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
//                @Override
//                public void onMyLocationChange(Location location) {
//                    float[] distance = new float[2];
//
//
//                    Location.distanceBetween(location.getLatitude(), location.getLongitude(),
//                            mCircle.getCenter().latitude, mCircle.getCenter().longitude, distance);
//
//                    if (distance[0] > mCircle.getRadius()) {
//                        Toast.makeText(getBaseContext(), "Outside, distance from center: " + distance[0] + " radius: " + mCircle.getRadius(), Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(getBaseContext(), "Inside, distance from center: " + distance[0] + " radius: " + mCircle.getRadius(), Toast.LENGTH_LONG).show();
//                    }
//
//                }
//            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawMarkerWithCircle(List lat) {
        double radiusInMeters = 100.0;
        int strokeColor = 0xffff0000;
        int shadeColor = 0x44ff0000;
        for (int i = 0; i < lat.size(); i++) {
            LatLng place = (LatLng) lat.get(i);
            Log.d("TAG", place.toString());




            Geocoder geocoder = new Geocoder(getApplicationContext());
            List<Address> addressList = null;
            try {
                addressList = geocoder.getFromLocation(place.latitude, place.longitude, 5);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = addressList.get(1).getSubLocality();
            MarkerOptions markerOptions = new MarkerOptions().position(place).title(str);
            Drawable circleDrawable = getResources().getDrawable(R.drawable.ic_pin);
            BitmapDescriptor markerIcon = getMarkerIconFromDrawable(circleDrawable);

            markerOptions.icon(markerIcon);

            mMarker = mMap.addMarker(markerOptions);

        }
    }
    private BitmapDescriptor getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //source--palayam
        LatLng thiruvallam = new LatLng(8.502504, 76.948057);
        //dest--kazhakuttam
        LatLng kazhakuttam = new LatLng(8.572996, 76.869863);

        LatLng p1 = new LatLng(8.497830, 76.916932);
        LatLng p2 = new LatLng(8.510097, 76.903591);
        LatLng p3 = new LatLng(8.558097,76.881561);
        markerpoints = new ArrayList<>();


        markerpoints.add(thiruvallam);
        markerpoints.add(kazhakuttam);
        markerpoints.add(p1);
        markerpoints.add(p2);
        markerpoints.add(p3);


    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        /*// Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
        return url;*/

        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Waypoints
        String waypoints = "";
        for (int i = 2; i < markerpoints.size(); i++) {
            LatLng point = (LatLng) markerpoints.get(i);
            if (i == 2)
                waypoints = "waypoints=";
            waypoints += point.latitude + "," + point.longitude + "|";
        }

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor + "&" + waypoints + "&key=" + getString(R.string.google_maps_key);

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        return url;
    }


    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
        currentPolyline.setTag("Distance: "+distance1);
        currentPolyline.setClickable(true);

    }

String distance1;
    @Override
    public void distance(List<HashMap<String, String>> distance, List<HashMap<String, String>> duration) {
        for (int i = 0; i < distance.size(); i++) {
            HashMap<String, String> point = distance.get(i);
            distance1 = (String) point.get("distance");

            if (distance != null) {

                Log.d("TAG", "distance>>>>" + distance1);
            }

        }
        for (int i = 0; i < duration.size(); i++) {
            HashMap<String, String> point = duration.get(i);
            String dura = (String) point.get("duration");

            if (duration != null) {

                Log.d("TAG", "duration>>>>" + dura);
            }

        }


    }
}