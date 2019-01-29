package com.youtochi.qtienditas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//import com.google.android.gms.maps.model.BitmapDescriptor;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/**
 * Created by 813743 on 26/03/2017.
 */
public class ListaHistorial extends ArrayAdapter{

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    private List<DataDescriptorHistorial> itemList;

    public ListaHistorial(Activity context, String[] web, Integer[] imageId, List<DataDescriptorHistorial> itemList){
        super(context,R.layout.lista_singlehistorial,web);
        this.context= context;
        this.web = web;
        this.imageId=imageId;
        this.itemList = itemList;
    }

    public int getCount() {
        if (itemList != null)
            return itemList.size();
        return 0;
    }
    public DataDescriptorHistorial getItem(int position) {
        if (itemList != null)
            return itemList.get(position);
        return null;
    }
    public long getItemId(int position) {
        if (itemList != null)

            return itemList.get(position).hashCode();
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflador= context.getLayoutInflater();
        View rowView=inflador.inflate(R.layout.lista_singlehistorial,null,true);

        TextView txtTitle =(TextView) rowView.findViewById(R.id.txthistorial);
        ImageView imagenV= (ImageView) rowView.findViewById(R.id.imghistorial);
        //txtTitle.setText(web[position]);

        System.out.println("ListaRobot getView paso 3:"+position);
        DataDescriptorHistorial c = itemList.get(position);
        if(c!=null && c.getName()!=null ) {
            txtTitle.setText(c.getName());
        }else {
            txtTitle.setText("rosita");
        }
        System.out.println("Lista DataDescriptorTienda ListaRobot paso 1"+position);


//        imagenV.setImageResource(imageId[position]);;

//        imagenV.setImageResource(imageId[0]);;//imagen de robot posicion 1

        //change the icon for the robot, based on the type of robot
        if(c.getTipo()!=null && c.getTipo().equals("conosmoviles")){
            imagenV.setImageResource(R.mipmap.typeconosmoviles_small);


        }else if(c.getTipo()!=null && c.getTipo().equals("muchasbolas")){
            imagenV.setImageResource(R.mipmap.type_muchasbolas_small);

        }else if(c.getTipo()!=null && c.getTipo().equals("bolaAcuavia")){
            imagenV.setImageResource(R.mipmap.type_bola_acuavia_small);

        }else if(c.getTipo()!=null && c.getTipo().equals("bolasganaderas")){
            imagenV.setImageResource(R.mipmap.type_muchasbolas_vaquero_small);
        }else{
//            imagenV.setImageResource(imageId[0]);;
            imagenV.setImageResource(R.mipmap.ic_kekiko01_01_small);;
        }


/* para prueba carlos z nov 21
        Button btnTitle =(Button) rowView.findViewById(R.id.btnHistorial);
        btnTitle.setHint(position+"");//this value is used later when user clicks on the button, hint position value
*/
        return rowView;

    }

    public List<DataDescriptorHistorial> getItemList() {
        return itemList;
    }

    public void setItemList(List<DataDescriptorHistorial> itemList) {
        this.itemList = itemList;
    }
}
