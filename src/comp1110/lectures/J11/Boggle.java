package comp1110.lectures.J11;

import comp1110.lectures.A01.ArrayList;
import comp1110.lectures.A01.TestArrayOnly;

import java.util.Arrays;
import java.util.Random;

/**
 * Generates a string representing a randomly-generated Boggle dice roll.
 */
public class Boggle {
    static String[] dice = {"AJBBOO", "AFFPSK", "ANEAGE", "APSHCO", "QNUMHI", "ZNHRLN", "TDSTYI", "TTWOOA", "TLRYET", "TUMIOC", "EDVLRY", "EDRLXI", "EEGNHW", "EIOTSS", "ERHTWV", "EENUSI"};

    static final int ROW_LENGTH = 4;

    public static void main(String[] args) {
        StringBuilder targetString = new StringBuilder();
        boolean[] alreadyUsed = new boolean[dice.length];
        System.out.println(Arrays.toString(alreadyUsed));

        for(int index = 0; index < dice.length; index++){
            Random newrand = new Random();
            int nextDice = newrand.nextInt(16);
            while(alreadyUsed[nextDice]){
                nextDice = newrand.nextInt(16);
            }

            Random anotherRand = new Random();
            int charNum = anotherRand.nextInt(6);
            char nextChar = dice[nextDice].charAt(charNum);
            targetString.append(nextChar);
            if(index % ROW_LENGTH == 3){
                targetString.append('\n');
            }

            alreadyUsed[nextDice] = true;

        }

        System.out.println(targetString.toString());
    }
}


/*
StringBuilder result = new StringBuilder();
        Random rand = new Random();
        boolean[] alreadyUsed = new boolean[dice.length];
        System.out.println(Arrays.toString(alreadyUsed));
        for (int i = 0; i < 16; i++) {
            int dieNumber = rand.nextInt(16);
            while (alreadyUsed[dieNumber]) {
                dieNumber = rand.nextInt(16); // keep trying random numbers until find a die that has not been used
                //dieNumber = (dieNumber + 1) % dice.length; // check the next die
            }

            int face = rand.nextInt(6);
            char faceChar = dice[dieNumber].charAt(face);
            result.append(faceChar);
            if (i % ROW_LENGTH == ROW_LENGTH - 1) result.append('\n');
            alreadyUsed[dieNumber] = true;
        }

        System.out.println(result.toString());
 */