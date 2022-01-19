package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.decastrofinalproject.jackenpoyinanotherworld.characters.CharacterRoles;
import com.decastrofinalproject.jackenpoyinanotherworld.characters.Characters;
import com.decastrofinalproject.jackenpoyinanotherworld.characters.Mobs;
import com.decastrofinalproject.jackenpoyinanotherworld.characters.You;

import java.util.Random;

public class Round extends AppCompatActivity {
    private Characters character;
    private Characters[] enemies;
    private SharedPreferenceAccessor sharedPreference;
    private int enemyIndex;
    private int round;
    private int[] enemyWeapons = {R.drawable.rock_enemy, R.drawable.paper_enemy, R.drawable.scissors_enemy};
    private TextView enemyName;
    private ImageView enemyImage;
    private ImageView yourWeapon;
    private ImageView enemyWeapon;
    private ImageView rock;
    ImageView paper;
    ImageView scissors;
    private LinearLayout weaponsContainer;
    private ProgressBar myHp;
    private ProgressBar enemyHp;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        sharedPreference = new SharedPreferenceAccessor(getApplicationContext());
        round = Integer.parseInt(sharedPreference.getData("savedInfo", "round"));
        String side = sharedPreference.getData("savedInfo", "side");
        CharacterRoles characterRoles = new CharacterRoles(side);
        enemies = new Characters[]{new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), characterRoles.getEnemyGeneralForThisRound(round)};
        enemyIndex = 0;
        character = new You(side, round);
        enemyName = findViewById(R.id.enemyHpLbl);
        enemyImage = findViewById(R.id.enemyImg);
        enemyHp = findViewById(R.id.enemyHp);
        myHp = findViewById(R.id.playerHp);
        myHp.setMax(character.getHp());
        myHp.setProgress(character.getHp());
        try{
            setEnemyMaxHp(enemies[enemyIndex].getHp());
        }
        catch (ArrayIndexOutOfBoundsException e){
            sharedPreference.setData("savedInfo", "round", String.valueOf(round+1));
            refresh();
        }


        TextView roundLabel = findViewById(R.id.roundLbl);
        roundLabel.setText("Round " + round);

        yourWeapon = findViewById(R.id.yourWeap);
        enemyWeapon = findViewById(R.id.enemyWeap);
        weaponsContainer = findViewById(R.id.weaponsContainer);
        rock = findViewById(R.id.rock);
        rock.setOnClickListener(view -> determineWinner(R.drawable.rock));
        paper = findViewById(R.id.paper);
        paper.setOnClickListener(view -> determineWinner(R.drawable.paper));
        scissors = findViewById(R.id.scissors);
        scissors.setOnClickListener(view -> determineWinner(R.drawable.scissors));
        setWeaponsVisibility(View.VISIBLE, View.GONE);
    }
    public void setEnemyMaxHp(int maxHp){
        enemyHp.setMax(maxHp);
        enemyHp.setProgress(maxHp);
        enemyImage.setImageResource(enemies[enemyIndex].getCharacterImg());
        enemyName.setText(enemies[enemyIndex].getName().replace("<num>", String.valueOf(enemyIndex + 1)));
    }
    public void setEnemyHpNow(int hp){
        enemies[enemyIndex].setHp(hp);
        enemyHp.setProgress(hp);
        if(hp <= 0){
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(() -> {
                try{
                    enemyIndex++;
                    setEnemyMaxHp(enemies[enemyIndex].getHp());
                }
                catch (ArrayIndexOutOfBoundsException e){
                    sharedPreference.setData("savedInfo", "round", String.valueOf(round+1));
                    refresh();
                }
            }, 1000);

        }
    }
    public void setMyHpNow(int hp){
        character.setHp(hp);
        myHp.setProgress(hp);
        if(hp <= 0){
            Toast.makeText(getApplicationContext(), CenteredToast.centerText("Game over! You lose!"), Toast.LENGTH_LONG).show();
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(() -> {
                Intent home = new Intent(Round.this, HomeActivity.class);
                sharedPreference.setData("savedInfo", "round", "1");
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
            }, 300);
        }
    }
    public void determineWinner(int youWeapon){
        Random rand = new Random();
        Handler handler = new Handler(Looper.getMainLooper());
        int index = rand.nextInt(3);
        enemyWeapon.setImageResource(enemyWeapons[index]);
        yourWeapon.setImageResource(youWeapon);
        Log.d("Your Damage", String.valueOf(character.getDmg()));
        Log.d("Enemy Damage", String.valueOf(enemies[enemyIndex].getDmg()));
        setWeaponsVisibility(View.GONE, View.VISIBLE);
        if(((youWeapon == R.drawable.paper) && (enemyWeapons[index] == R.drawable.paper_enemy)) || ((youWeapon == R.drawable.rock) && (enemyWeapons[index] == R.drawable.rock_enemy)) || ((youWeapon == R.drawable.scissors) && (enemyWeapons[index] == R.drawable.scissors_enemy))){
            Toast.makeText(getApplicationContext(), CenteredToast.centerText("Both weapons repelled. No damage received."), Toast.LENGTH_SHORT).show();
        }
        else if(((youWeapon == R.drawable.scissors) && (enemyWeapons[index] == R.drawable.paper_enemy)) || ((youWeapon == R.drawable.paper) && (enemyWeapons[index] == R.drawable.rock_enemy)) || ((youWeapon == R.drawable.rock) && (enemyWeapons[index] == R.drawable.scissors_enemy))){
            Toast.makeText(getApplicationContext(), CenteredToast.centerText("You repelled " + enemies[enemyIndex].getName().replace("<num>", String.valueOf(enemyIndex + 1)).toLowerCase() +"'s weapon."), Toast.LENGTH_SHORT).show();
            handler.postDelayed(() -> {
                // Do something after 5s = 5000ms
                setEnemyHpNow(enemies[enemyIndex].getHp() - character.getDmg());
            }, 1000);
        }
        else{
            Toast.makeText(getApplicationContext(), CenteredToast.centerText(enemies[enemyIndex].getName().replace("<num>", String.valueOf(enemyIndex + 1)) +" repelled your weapon."), Toast.LENGTH_SHORT).show();
            handler.postDelayed(() -> {
                // Do something after 5s = 5000ms
                setMyHpNow(character.getHp() - enemies[enemyIndex].getDmg());
            }, 1000);
        }
        handler.postDelayed(() -> {
            // Do something after 5s = 5000ms
            setWeaponsVisibility(View.VISIBLE, View.GONE);
        }, 3000);
    }
    public void setWeaponsVisibility(int visibility, int visibility2){
        TextView weaponsLbl = findViewById(R.id.chooseWeaponLbl);
        TextView vsLbl = findViewById(R.id.vsLbl);
        weaponsLbl.setVisibility(visibility);
        rock.setVisibility(visibility);
        paper.setVisibility(visibility);
        scissors.setVisibility(visibility);
        yourWeapon.setVisibility(visibility2);
        enemyWeapon.setVisibility(visibility2);
        vsLbl.setVisibility(visibility2);
    }
    public void refresh(){
        finish();
        overridePendingTransition( 0, 0);
        startActivity(getIntent());
        overridePendingTransition( 0, 0);
    }
}