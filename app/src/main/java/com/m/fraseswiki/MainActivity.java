package com.m.fraseswiki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener{

    private String felicidad = "felicidad";
    Spinner spinner_buscar;
    Button btnbuscar;
    EditText et_busqueda;
    String opcion = "Temas";

    //INICIO MENU DESPLEGABLE
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yogafacil.net/privacidad.html"));
                startActivity(browserIntent);
                return true;
            case R.id.item2:
                Intent intrating = new Intent(this, RatingActivity.class);
                startActivity(intrating);
                return true;
            default:
                return false;
        }
    }
    //FIN MENU DESPLEGABLE



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //con esto evito que me lnce el teclado al abrir
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //SPINNER
        spinner_buscar= (Spinner) findViewById(R.id.spinner_buscar);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.criterio_busca, android.R.layout.simple_spinner_item);
        spinner_buscar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String opcion = spinner_buscar.getSelectedItem().toString();


                Toast.makeText(getApplicationContext(), "Seleccionado: " + opcion, Toast.LENGTH_SHORT).show();

                if (opcion.equals("Temas")){
                    btnbuscar = (Button) findViewById(R.id.btnBuscar);

                    btnbuscar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, TemasActivity.class);
                            EditText et_busqueda;
                            et_busqueda = (EditText)findViewById(R.id.editText);
                            String termino= et_busqueda.getText().toString();
                            intent.putExtra("palabra", termino);

                            startActivity(intent);
                        }
                    });
                }else if(opcion.equals("Autores")) {

                    btnbuscar = (Button) findViewById(R.id.btnBuscar);

                    btnbuscar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, AutoresActivity.class);
                            EditText et_busqueda;
                            et_busqueda = (EditText)findViewById(R.id.editText);
                            String termino= et_busqueda.getText().toString();
                            intent.putExtra("palabra", termino);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //LOS 9 ELEMENTOS

        LinearLayout opcion1 = findViewById(R.id.layFelicidad);
            opcion1.setOnClickListener(this);

            LinearLayout opcion2 = findViewById(R.id.layAmistad);
            opcion2.setOnClickListener(this);

            LinearLayout opcion3 = findViewById(R.id.layCanciones);
            opcion3.setOnClickListener(this);

            LinearLayout opcion4 = findViewById(R.id.layAmor);
            opcion4.setOnClickListener(this);

            LinearLayout opcion5 = findViewById(R.id.layEsperanza);
            opcion5.setOnClickListener(this);

            LinearLayout opcion6 = findViewById(R.id.layMotivacion);
            opcion6.setOnClickListener(this);

            LinearLayout opcion7 = findViewById(R.id.layReflexion);
            opcion7.setOnClickListener(this);

            LinearLayout opcion8 = findViewById(R.id.laySuenos);
            opcion8.setOnClickListener(this);

            LinearLayout opcion9 = findViewById(R.id.layMusica);
            opcion9.setOnClickListener(this);

            //con esto evito que me lnce el teclado al abrir
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.layFelicidad:
                    Intent int1 = new Intent(this, TemasActivity.class);
                    String felicidad = "felicidad";
                    int1.putExtra("palabra", felicidad);
                    startActivity(int1);
                    break;

                case R.id.layAmistad:
                    Intent int2 = new Intent(this, TemasActivity.class);
                    String amistad = "amistad";
                    int2.putExtra("palabra", amistad);
                    startActivity(int2);
                    break;

                case R.id.layCanciones:
                    Intent int3 = new Intent(this, TemasActivity.class);
                    int autor = 1288;
                    int3.putExtra("palabra", autor);
                    startActivity(int3);
                    break;

                case R.id.layAmor:
                    Intent int4 = new Intent(this, TemasActivity.class);
                    String amor = "amor";
                    int4.putExtra("palabra", amor);
                    startActivity(int4);
                    break;

                case R.id.layEsperanza:
                    Intent int5 = new Intent(this, TemasActivity.class);
                    String esperanza = "esperanza";
                    int5.putExtra("palabra", esperanza);
                    startActivity(int5);
                    break;

                case R.id.layMotivacion:
                    Intent int6 = new Intent(this, TemasActivity.class);
                    String motivacion = "motivacion";
                    int6.putExtra("palabra", motivacion);
                    startActivity(int6);
                    break;

                case R.id.layReflexion:
                    Intent int7 = new Intent(this, TemasActivity.class);
                    String reflexion = "reflexion";
                    int7.putExtra("palabra", reflexion);
                    startActivity(int7);
                    break;

                case R.id.laySuenos:
                    Intent int8 = new Intent(this, TemasActivity.class);
                    String suenos = "sueños";
                    int8.putExtra("palabra", suenos);
                    startActivity(int8);
                    break;

                case R.id.layMusica:
                    Intent int9 = new Intent(this, TemasActivity.class);
                    String musica = "musica";
                    int9.putExtra("palabra", musica);
                    startActivity(int9);
                    break;
            }
        }
        //FIN LOS 9 ELEMENTOS

}