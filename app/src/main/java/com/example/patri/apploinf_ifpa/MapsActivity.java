package com.example.patri.apploinf_ifpa;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.patri.apploinf_ifpa.R.id.map;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // latitude e longitude dos blocos
        LatLng bloco_c = new LatLng(-1.438254, -48.460413);
        mMap.addMarker(new MarkerOptions().position(bloco_c).title("Análise de Sistemas - Bloco C - Térreo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bloco_c));

        LatLng bloco_e = new LatLng(-1.437855, -48.460616);
        mMap.addMarker(new MarkerOptions().position(bloco_e).title("Telecomunicação - Bloco E - 3ºAndar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bloco_e));

        LatLng bloco_b = new LatLng(-1.438381, -48.460592);
        mMap.addMarker(new MarkerOptions().position(bloco_b).title("Técnico em Designer - Bloco B - 2ºAndar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bloco_b));

        LatLng bloco_v = new LatLng(-1.437556, -48.461418);
        mMap.addMarker(new MarkerOptions().position(bloco_v).title("Pedagogia - Bloco V"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bloco_v));

        LatLng bloco2_v = new LatLng(-1.437629, -48.461492);
        mMap.addMarker(new MarkerOptions().position(bloco2_v).title("Eletrotécnica Industrial - Bloco V"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bloco2_v));


        //Botões do zoom
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

       //CameraPosition cameraPosition = new CameraPosition.Builder().zoom(15).target(currentLocationLatLong).build();
        //mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);



    }

}

   /* private void createNoGpsDialog() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent callGPSSettingIntent = new Intent(
                                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(callGPSSettingIntent);
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog mNoGpsDialog = builder.setMessage("Por favor ative seu GPS para usar esse aplicativo.")
                .setPositiveButton("Ativar", dialogClickListener)
                .create();
        mNoGpsDialog.show();

    }
}

*/
