package com.example.mentalcountingg.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mentalcountingg.R;
import com.example.mentalcountingg.models.ResVide;
import com.example.mentalcountingg.services.Operation;
import com.example.mentalcountingg.models.ResFaux;
import com.example.mentalcountingg.services.Verification;



public class ActivityGame extends AppCompatActivity {


    private Button menu;
    private Button scores;

    private int res;
    private EditText text;
    private TextView calculText;
    private TextView incorrectText;
    private TextView correctText;
    private CharSequence textCalcul;




    private Operation op = new Operation();
    private Verification verif = new Verification();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        text = findViewById(R.id.operation);
        calculText = findViewById(R.id.calcul_text);
        correctText = findViewById(R.id.bon);
        incorrectText = findViewById(R.id.faux);

        textCalcul = this.calculText.getText();


        calculFunction();
        Button submitButton = findViewById(R.id.valider);
        submitButton.setOnClickListener(view -> submitFunction());

        Button newButton = findViewById(R.id.new_op);
        newButton.setOnClickListener(view -> nouvelleOperation());


        menu= (Button) findViewById(R.id.Menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        scores= (Button) findViewById(R.id.Scores);
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_scores();
            }
        });
    }



    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public void openActivity_scores(){
        Intent intent = new Intent(this, Activity_scores.class);
        startActivity(intent);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id = item.getItemId();

        if (id == R.id.scores) {
            Intent intent = new Intent(this, Activity_scores.class);
            startActivity(intent);
            return false;
        }
        if (id == R.id.jeu) {
            Intent intent = new Intent(this, ActivityGame.class);
            startActivity(intent);
            return false;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }






    private void calculFunction(){
        res = op.Aleatoire();
        boolean calcul = op.CorrectOpe();
        if (calcul) {
            int nb1 = op.getnb1();
            String operateur = op.getOperateur();
            int nb2 = op.getnb2();
            String affichage = getString(R.string.operation_template, nb1, operateur, nb2);
            this.calculText.setText(textCalcul + affichage);
        }
    }

    void submitFunction() {
        try {
            int valeur;
            String value = text.getText().toString();
            valeur = Integer.parseInt(value);

            verif.Verification(valeur, res);
            correctText.setVisibility(View.VISIBLE);
            findViewById(R.id.calcul_text);

        } catch (ResFaux resultatFaux) {
            incorrectText.setVisibility(View.VISIBLE);
            resultatFaux.printStackTrace();
            int reponse = verif.getCorrectRes();
            String rep = Integer.toString(reponse);
            this.incorrectText.setText(rep);

        } catch (ResVide resultatVide) {

        }
    }


    private void nouvelleOperation(){
        correctText.setVisibility(View.INVISIBLE);
        incorrectText.setVisibility(View.INVISIBLE);
        calculFunction();
        Button submitButton = findViewById(R.id.new_op);
        submitButton.setVisibility(View.VISIBLE);
    }

}