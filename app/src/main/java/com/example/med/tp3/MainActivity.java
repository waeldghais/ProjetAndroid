package com.example.med.tp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    protected ListView maListViewPerso;
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText login = (EditText) findViewById(R.id.user_email);
        final EditText pass = (EditText) findViewById(R.id.user_password);
        final Button loginButton = (Button) findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String loginTxt = login.getText().toString();
                final String passTxt = pass.getText().toString();
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

                Matcher m = p.matcher(loginTxt);

                if (!((Matcher) m).matches()) {

                    Toast.makeText(MainActivity.this, R.string.email_format_error,
                            Toast.LENGTH_SHORT).show();
                    return;
                } else if (loginTxt.equals("") || passTxt.equals("")) {
                    Toast.makeText(MainActivity.this,
                            R.string.email_or_password_empty,
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(MainActivity.this, acceil.class);
                    intent.putExtra(EXTRA_LOGIN, login.getText().toString());
                    intent.putExtra(EXTRA_PASSWORD, pass.getText().toString());
                    startActivity(intent);
                }
            }
        });
        maListViewPerso = findViewById(R.id.listviewperso);
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put("titre", "Samsung");
        map.put("img", String.valueOf(R.drawable.samsung));
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre", "Iphone");
        map.put("img", String.valueOf(R.drawable.Iphone));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "HUAWEI");
        map.put("img", String.valueOf(R.drawable.HUAWEI));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Sony");
        map.put("img", String.valueOf(R.drawable.Sony));
        listItem.add(map);
        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItem,
                R.layout.acceil,
                new String[]{"img", "titre"},
                new int[]{R.id.img, R.id.titre});
        maListViewPerso.setAdapter(adapter);
        maListViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // On récupère la "HashMap" contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);

                // On crée une boite de dialogue
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                // On attribue un titre à notre boite de dialogue
                adb.setTitle("Sélection Item");
                // On insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
                adb.setMessage("Votre choix : " + map.get("titre"));
                // On indique que l'on veut le bouton "ok" à notre boite de dialogue
                adb.setPositiveButton("Ok", null);
                // On affiche la boite de dialogue
                adb.show();
                return true;

            }
        });

        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // On récupère la "HashMap" contenant les infos de notre item (titre, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get("titre"), Toast.LENGTH_LONG).show();
            }
        });
    }
}
