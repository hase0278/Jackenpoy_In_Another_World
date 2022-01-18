package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.decastrofinalproject.jackenpoyinanotherworld.characters.Character;
import com.decastrofinalproject.jackenpoyinanotherworld.characters.CharacterRoles;
import com.decastrofinalproject.jackenpoyinanotherworld.characters.Characters;
import com.decastrofinalproject.jackenpoyinanotherworld.characters.Mobs;
import com.decastrofinalproject.jackenpoyinanotherworld.characters.You;

public class Round extends AppCompatActivity {
    private Characters character;
    private Characters[] enemies;
    private int enemyIndex;
    private TextView enemyName;
    ImageView enemyImage;
    ProgressBar myHp;
    ProgressBar enemyHp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        SharedPreferenceAccessor sharedPreference = new SharedPreferenceAccessor(getApplicationContext());
        int round = Integer.valueOf(sharedPreference.getData("savedInfo", "round"));
        String side = sharedPreference.getData("savedInfo", "side");
        CharacterRoles characterRoles = new CharacterRoles(side);
        enemies = new Characters[]{new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), new Mobs(side, round), characterRoles.getEnemyGeneralForThisRound(round)};
        enemyIndex = 0;
        character = new You(side, round);
        enemyHp = findViewById(R.id.enemyHp);
        myHp = findViewById(R.id.playerHp);
        myHp.setMax(character.getHp());
        myHp.setProgress(character.getHp());
        try{
            setEnemyMaxHp(enemies[enemyIndex].getHp());
        }
        catch (ArrayIndexOutOfBoundsException e){
            sharedPreference.setData("savedInfo", "round", String.valueOf(round+1));
        }


        TextView roundLabel = findViewById(R.id.roundLbl);
        roundLabel.setText("Round " + round);
        enemyName = findViewById(R.id.enemyHpLbl);
        enemyImage = findViewById(R.id.enemyImg);
        enemyImage.setImageResource(enemies[enemyIndex].getCharacterImg());
        enemyName.setText(enemies[enemyIndex].getName());
        ImageView yourWeapon = findViewById(R.id.yourWeapon);
        ImageView enemyWeapon = findViewById(R.id.enemyWeapon);
        LinearLayout weaponsContainer = findViewById(R.id.weaponsContainer);
        weaponsContainer.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if(i == View.VISIBLE){
                    yourWeapon.setVisibility(View.GONE);
                    enemyWeapon.setVisibility(View.GONE);
                }
                else if(i == View.INVISIBLE || i == View.GONE){
                    yourWeapon.setVisibility(View.VISIBLE);
                    enemyWeapon.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    public void setEnemyMaxHp(int maxHp){
        enemyHp.setMax(maxHp);
        enemyHp.setProgress(maxHp);
    }
    public void setEnemyHpNow(int hp){
        enemyHp.setProgress(hp);
    }
}