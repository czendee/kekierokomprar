package com.youtochi.qtienditas;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MiMapaUnNuevoTiendaActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

        private GoogleMap mMap;


    public String cualUsuarioSoy;
    public String cualInfoProductoSoy;
    public String cualProductoIDSoy;
    public String cualPrecioSoy;
    public String cualImagenSoy;

    public String mapaLat;
    public String mapaLon;

    public String cualRobotId;
    public String cualRobotName;
    public String cualRobotTipo;
    public String cualRobotManada;
    public String cualRobotLon;
    public String cualRobotLat;
    public String cualRobotRentacosto;
    public String cualRobotRentatiempo;
    public String cualRobotImage;






    LatLng dondeEstoyLatLon;


    //to hide/show buttons
     FloatingActionButton  fabArriba;
    FloatingActionButton  fabAbajo;
    FloatingActionButton  fabIzq;
    FloatingActionButton  fabDer;
     FloatingActionButton fabPlay;

    int playing;

    private Marker mRobot01;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mi_mapa_un_nuevo_tienda);

            Bundle extras = getIntent().getExtras();
//this flag indicates ig the user has press the pay button and he is playing or not
            playing=0;//initially, not playing
            cualUsuarioSoy="ninguno";
            System.out.println("Detalle robot  ProdId:" );

            if (extras != null) {
                System.out.println("Detalle robot  ProdId  step 2:" );
                cualUsuarioSoy = extras.getString("cual_usuario");


                cualInfoProductoSoy =extras.getString("cual_infoproducto");
                cualProductoIDSoy= extras.getString("cual_productoID");
                cualPrecioSoy=  extras.getString("cual_precio");
                cualImagenSoy=  extras.getString("cual_imagen");


                mapaLon=  extras.getString("cual_lugarlon");//los paso la anterior screen main
                mapaLat=  extras.getString("cual_lugarlat");//los paso la anterior screen main


                cualRobotId=extras.getString("cual_robot_id");
                cualRobotName=extras.getString("cual_robot_name");
                cualRobotTipo=extras.getString("cual_robot_tipo");
                cualRobotManada=extras.getString("cual_robot_manada");
                cualRobotRentacosto=extras.getString("cual_robot_rentacosto");
                cualRobotRentatiempo=extras.getString("cual_robot_rentatiempo");
                cualRobotImage=extras.getString("cual_robot_image");
                cualRobotLat=extras.getString("cual_robot_lat");
                cualRobotLon=extras.getString("cual_robot_lon");

                System.out.println("Detalle robot  ProdId  step 3 a:"+cualInfoProductoSoy+" b:"+ cualProductoIDSoy+ " c:"+cualPrecioSoy +" d:"+cualImagenSoy);
                int valorImagenInt=0;
                try{
                    valorImagenInt = Integer.parseInt(cualImagenSoy);
                }catch(Exception e){

                }
/*
                System.out.println("Detalle robot  ProdId  step 3:"+ valorImagenInt);
                EditText textitoName =(EditText) findViewById(R.id.productoName);
                textitoName.setText(cualInfoProductoSoy);
                EditText textitoID =(EditText) findViewById(R.id.productoID);
                textitoID.setText(cualProductoIDSoy);
                EditText textitoMes =(EditText) findViewById(R.id.productoPrecio);
                textitoMes.setText(cualPrecioSoy);
                if(valorImagenInt>0) {
                    ImageView imagenV = (ImageView) findViewById(R.id.productoImagen);

                    imagenV.setImageResource(valorImagenInt);

                }
*/
                System.out.println("Detalle robot  ProdId  step 6:");
            }//if extras




            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

/*            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.mapafab01);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.controla_robot_remotamente, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            */

            /*este se oculto psra que se despliegue el play
            FloatingActionButton fabmap = (FloatingActionButton) findViewById(R.id.mapafab02);
            fabmap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.regresar_a_lista_robots, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    //ir a screen de mapa
                    Intent i = new Intent(MiMapaDetalleUnRobotActivity.this, DespliegaDetalleRobotActivity.class);
                    i.putExtra("cual_usuario", cualUsuarioSoy );
                    i.putExtra("cual_infoproducto", cualInfoProductoSoy );
                    i.putExtra("cual_productoID", cualProductoIDSoy );
                    i.putExtra("cual_precio", cualPrecioSoy );
                    i.putExtra("cual_imagen", cualImagenSoy );

                    i.putExtra("cual_usuario", cualUsuarioSoy );
                    i.putExtra("cual_robot_id", cualRobotId );
                    i.putExtra("cual_robot_name", cualRobotName);
                    i.putExtra("cual_robot_tipo", cualRobotTipo );
                    i.putExtra("cual_robot_manada", cualRobotManada );
                    i.putExtra("cual_robot_lon", cualRobotLon );
                    i.putExtra("cual_robot_lat", cualRobotLat );
                    i.putExtra("cual_robot_rentacosto", cualRobotRentacosto );
                    i.putExtra("cual_robot_rentatiempo", cualRobotRentatiempo );

                    i.putExtra("cual_robot_imagen", cualRobotImage );
                    i.putExtra("cual_lugarlat", cualRobotLat );
                    i.putExtra("cual_lugarlon", cualRobotLon );

                    startActivity(i);
                }
            });

*/
            fabArriba = (FloatingActionButton) findViewById(R.id.mapafabArriba);//button Arriba
            fabArriba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.conecta_robot_remoto, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();



                }
            });

            fabAbajo = (FloatingActionButton) findViewById(R.id.mapafabAbajo);//button Arriba
            fabAbajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.conecta_robot_remoto, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();



                }
            });

            fabIzq = (FloatingActionButton) findViewById(R.id.mapafabIzq);//button Arriba
            fabIzq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.conecta_robot_remoto, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();



                }
            });

            fabDer = (FloatingActionButton) findViewById(R.id.mapafabDer);//button Arriba
            fabDer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.conecta_robot_remoto, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();



                }
            });
//initially the buttons will be hide
            fabArriba.hide();
            fabAbajo.hide();
            fabIzq.hide();
            fabDer.hide();

//initially set the buttons to be images rows
            fabArriba.setImageResource(R.mipmap.arriba);
            fabAbajo.setImageResource(R.mipmap.abajo);
            fabIzq.setImageResource(R.mipmap.izquierda);
            fabDer.setImageResource(R.mipmap.derecha);

 /*START:this button does not exist in NewEdit
            fabPlay = (FloatingActionButton) findViewById(R.id.mapafab04);//button Play
            fabPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Snackbar.make(view,R.string.conecta_robot_remoto, Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();


                    if(playing==0){//not playing before, now it will play
                        fabPlay.setImageResource(R.drawable.cast_ic_mini_controller_pause);
                        playing=1;//initially, not playing
                        fabArriba.show();
                        fabAbajo.show();
                        fabIzq.show();
                        fabDer.show();

                    }else{//playing before, now it will not play
                        fabPlay.setImageResource(R.drawable.ic_media_play);
                        playing=0;//initially, not playing
                        fabArriba.hide();
                        fabAbajo.hide();
                        fabIzq.hide();
                        fabDer.hide();
                    }



                }
            });
END:this button does not exist in NewEdit
*/
 /*START:this button does not exist in NewEdit
            FloatingActionButton fab05 = (FloatingActionButton) findViewById(R.id.mapafab05);
            fab05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.controla_robot_via_persicope, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
END:this button does not exist in NewEdit
*/

//button Points: display the button with Text on it
            FloatingActionButton fabPoints = (FloatingActionButton) findViewById(R.id.mapafabTopCenter);
            fabPoints.setImageBitmap(textAsBitmap("23", 10, Color.WHITE));
            fabPoints.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.conecta_robot_remoto, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });



            //button Points: display the button with Text on it
            FloatingActionButton fabMoneys = (FloatingActionButton) findViewById(R.id.mapafabTopDinero);
            fabMoneys.setImageBitmap(textAsBitmap("$10.50", 10, Color.WHITE));
            fabMoneys.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,R.string.conecta_robot_remoto, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        int a=9;

        }


        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            //add listener when a user clicks on the map, to get the location lat and lon

            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                @Override
                public void onMapClick(LatLng point) {

                    if(cualInfoProductoSoy!=null) {
                        if (cualInfoProductoSoy.equals("nuevo")) {
                            Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(getResources().getResourceName(R.drawable.common_full_open_on_phone), "drawable", getPackageName()));
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, 38, 38, false);

/*                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(point.latitude, point.longitude))
                            .anchor(0.5f, 0.1f)
                            .title("la nueva posicion")
                            .snippet("siii")
                            .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)));
*/
                            mRobot01.setPosition(new LatLng(point.latitude, point.longitude));
                            mapaLat=  point.latitude+"";
                            mapaLon=  point.longitude+"";

                        }
                    }

                }
            });

            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(-34, 151);

            LatLng mexicoCity = new LatLng(19.429, -99.146);

            //gps position passed as paramter, will set the center of the map: start
            System.out.println("zooooom onMapReady 1" );
            if(mapaLon!=null && mapaLat!=null){
                System.out.println("zooooom onMapReady 2" );
                dondeEstoyLatLon=new LatLng( Double.valueOf( mapaLat),Double.valueOf( mapaLon));
            }else{
                System.out.println("zooooom onMapReady 3" );
                dondeEstoyLatLon=mexicoCity;
            }
            System.out.println("zooooom onMapReady 4" );
           //gps position passed as paramter, will set the center of the map: end

//        BitmapDescriptor bmd=BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory. .HUE_AZURE);

            BitmapDescriptor bmd= BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);

            //19.4294359!4d-99.1469533
            if(cualInfoProductoSoy!=null){
                if(cualInfoProductoSoy.equals("nuevo")){
                    mRobot01=  mMap.addMarker(
                            new MarkerOptions().position(dondeEstoyLatLon).title("Ahora:DISPONIBLE - CDMX Centro MEXICO - Tipo: (MuchasBolas)").snippet(" Renta por:(5mins) Renta $:(Gratis) Manada:(No) Transmite Periscope:(No)")
                    );
                    mRobot01.setIcon(bmd);
                }else{
                    mRobot01= mMap.addMarker(
                            new MarkerOptions().position(dondeEstoyLatLon).title("Ahora:DISPONIBLE - "+cualRobotName+" - Tipo: ("+cualRobotTipo+")").snippet(" Renta por:("+cualRobotRentatiempo+"mins) Renta $:(Gratis) Manada:("+cualRobotManada+") Transmite Periscope:(no)")
                    );
                    mRobot01.setIcon(bmd);
                }
            }else{
                mRobot01=mMap.addMarker(
                        new MarkerOptions().position(mexicoCity).title("Ahora:DISPONIBLE - CDMX Centro MEXICO - Tipo: (MuchasBolas)").snippet(" Renta por:(5mins) Renta $:(Gratis) Manada:(No) Transmite Periscope:(No)")
                );
                mRobot01.setIcon(bmd);
            }



            //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(mexicoCity));

            System.out.println("zooooom original" +mMap.getMaxZoomLevel());
  //set the center of the map:start
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mexicoCity,mMap.getMaxZoomLevel()-1));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dondeEstoyLatLon,mMap.getMaxZoomLevel()-1));
    //set the center of the map:end
            System.out.println("zooooom menos" );
            mMap.setBuildingsEnabled(true);



/*

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(19.429, -98.146))
                    .title("San Francisco")
                    .snippet("Population: 776733"))
                    .setIcon(bmd);
*/
            // Set a listener for marker click.
            mMap.setOnMarkerClickListener(MiMapaUnNuevoTiendaActivity.this);


        }

    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        //ir a screen de mapa
        Intent i = new Intent(MiMapaUnNuevoTiendaActivity.this, EditNewDetalleTiendaActivity.class);
        i.putExtra("cual_usuario", cualUsuarioSoy );
        i.putExtra("cual_infoproducto", cualInfoProductoSoy );
        i.putExtra("cual_productoID", cualProductoIDSoy );
        i.putExtra("cual_precio", cualPrecioSoy );
        i.putExtra("cual_imagen", cualImagenSoy );

        i.putExtra("cual_usuario", cualUsuarioSoy );
        i.putExtra("cual_robot_id", cualRobotId );
        i.putExtra("cual_robot_name", cualRobotName);
        i.putExtra("cual_robot_tipo", cualRobotTipo );
        i.putExtra("cual_robot_manada", cualRobotManada );
//        i.putExtra("cual_robot_lon", cualRobotLon );
        i.putExtra("cual_robot_lon", mapaLon );  //lon  obtained with the clicks

//        i.putExtra("cual_robot_lat", cualRobotLat );
        i.putExtra("cual_robot_lat", mapaLat );//lat  obtained with the clicks
        i.putExtra("cual_robot_rentacosto", cualRobotRentacosto );
        i.putExtra("cual_robot_rentatiempo", cualRobotRentatiempo );

        i.putExtra("cual_robot_imagen", cualRobotImage );
        i.putExtra("cual_lugarlat", cualRobotLat );
        i.putExtra("cual_lugarlon", cualRobotLon );

        startActivity(i);
        return true;
    }
    //method to convert your text to image
    public static Bitmap textAsBitmap(String text, float textSize, int textColor) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        float baseline = -paint.ascent(); // ascent() is negative
        int width = (int) (paint.measureText(text) + 0.0f); // round
        int height = (int) (baseline + paint.descent() + 0.0f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(image);
        canvas.drawText(text, 0, baseline, paint);
        return image;
    }
}
