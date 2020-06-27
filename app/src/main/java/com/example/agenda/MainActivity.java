package com.example.agenda;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Student;

public class MainActivity extends AppCompatActivity {

    private final Student[] students = new Student[]{
            new Student("Jasmin", "Martinez", "La Jungla, Manoguayabo, Santo Domingo Oeste", "Licenciada en Lenguas Modernas", "04/12/2000", "Femenino",  R.drawable.jmartinez),
            new Student("Luis", "Peña", "Cristo Rey, Distrito Nacional", "Ing. Sistemas Informaticos", "12/11/1988", "Masculino",  R.drawable.lpena),
            new Student("Jose", "Matos", "Las Piña, Los Alcarrizos, Santo Domingo Oeste", "Ing. en Redes", "22/08/1997", "Masculino",  R.drawable.jose),
            new Student("Yesenia", "Medrano", "Llave Publica, Los Alcarrizos, Santo Domingo Oeste", "Ing. Industrial", "09/03/1995", "Femenino",  R.drawable.ymedrano),
            new Student("Ivanis", "Medrano", "Los Mina, Santo Domingo Este", "Ing. Electrico", "08/05/1992", "Masculino",  R.drawable.imedrano),
            new Student("Freiner", "Sención", "Brisas del Norte, Santo Domingo Norte", "Ing. Mecatronica", "17/10/1993", "Masculino",  R.drawable.fsencion)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<HashMap<String, String>> aList = new ArrayList<>();

        for (int i = 0; i < getStudents().length; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("listview_title", getStudents()[i].getName() + " "+ getStudents()[i].getLastName());
            hm.put("listview_image", Integer.toString(getStudents()[i].getProfileImg()));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_layout, from, to);
        final ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = getStudents()[position];
                Intent i = new Intent(MainActivity.this, DetailActivity.class);

                i.putExtra("name",student.getName());
                i.putExtra("lastName",student.getLastName());
                i.putExtra("career",student.getCareer());
                i.putExtra("birthDate",student.getBirthDate());
                i.putExtra("address",student.getAddress());
                i.putExtra("profileImg",student.getProfileImg());
                i.putExtra("gender",student.getGender());

                startActivity(i);
            }
        });
    }

    public Student[] getStudents() {
        return students;
    }
}
