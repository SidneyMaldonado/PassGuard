package com.devapp.mal.passguard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<DadosAcesso> dados;
    private ListView listview;
    private DadosAcessoDao da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listview = (ListView) findViewById(R.id.listview);
        da = new DadosAcessoDao(this);
        dados =  da.buscarRegistros();
        ArrayAdapter<DadosAcesso> adapter = new ArrayAdapter<DadosAcesso>(this, android.R.layout.simple_list_item_1, dados);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              DadosAcesso da = dados.get(position);
              atualizar(da);


            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void InserirRegistro(View view){
        Intent intent = new Intent(this, DadosActivity.class);
        DadosAcesso da = new DadosAcesso();
        da.setId(0);
        intent.putExtra("DadosAcesso", da);
        startActivity(intent);
    }

    public void atualizar(DadosAcesso da){
        Intent intent = new Intent(this, DadosActivity.class);
        intent.putExtra("DadosAcesso", da);
        startActivity(intent);
    }


    public void onResume(View view){
        super.onResume();
        DadosAcessoDao da = new DadosAcessoDao(this);
        dados =  da.buscarRegistros();
        ArrayAdapter<DadosAcesso> adapter = new ArrayAdapter<DadosAcesso>(this, android.R.layout.simple_list_item_1, dados);
        listview.setAdapter(adapter);
        listview.invalidateViews();
    }
}
