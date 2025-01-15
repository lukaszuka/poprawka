package com.example.zad_4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView[] diceViews;           ///deklaracja zmiennych
    private TextView rollResultText, gameScoreText, rollCountText;
    private Button rollButton, resetButton;
    private int gameScore = 0;
    private int rollCount = 0;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja widoków
        diceViews = new TextView[] {    //moja zmienna jest tabelą i szuka poprzez id i wrzuca do tabeli
                findViewById(R.id.dice1), findViewById(R.id.dice2),
                findViewById(R.id.dice3), findViewById(R.id.dice4), findViewById(R.id.dice5)
        };
        rollResultText = findViewById(R.id.rollResultText); //przypisanie do zmiennych activity main poprzez id
        gameScoreText = findViewById(R.id.gameScoreText);
        rollCountText = findViewById(R.id.rollCountText);
        rollButton = findViewById(R.id.rollButton);
        resetButton = findViewById(R.id.resetButton);

        rollButton.setOnClickListener(v -> rollDice());
        resetButton.setOnClickListener(v -> resetGame());
    }

    private void rollDice() {
        int[] diceResults = new int[5]; //jaki będzie rozmiar 1-6 bo zaczyna się od zera
        int rollScore = 0;

        for (int i = 0; i < 5; i++) {
            diceResults[i] = random.nextInt(6) + 1;//inaczyej zaczeło by od zera dlatego będzie od 1 do 6
            rollScore += diceResults[i]; //zapisuje ile wyrzuciło oczekwszystkich
        }

        displayDiceResults(diceResults);
        updateScore(rollScore);
        updateRollCount();
    }

    private void resetGame() {
        for (TextView diceView : diceViews) {
            diceView.setText("?");//jak wyświetla coś innego niż liczbe ustawia znak zapytania
        }
        rollResultText.setText("Wynik tego losowania: 0");
        gameScoreText.setText("Wynik gry: 0");
        rollCountText.setText("Liczba rzutów: 0");
        gameScore = 0; // ustawwia winik gry na zero
        rollCount = 0;
    }

    private void updateScore(int newScore) {
        gameScore += newScore;
        gameScoreText.setText("Wynik gry: " + gameScore);
        rollResultText.setText("Wynik tego losowania: " + newScore);
    }

    private void updateRollCount() {
        rollCount++;
        rollCountText.setText("Liczba rzutów: " + rollCount);
    }

    private void displayDiceResults(int[] diceResults) { //pokazuje wynik na kościach poprzez pętle for
        for (int i = 0; i < diceResults.length; i++) {
            diceViews[i].setText(String.valueOf(diceResults[i]));
        }
    }
}