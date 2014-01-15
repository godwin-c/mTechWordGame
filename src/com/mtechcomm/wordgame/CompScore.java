/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtechcomm.wordgame;

import java.util.Collections;

/**
 *
 * @author LANREWAJU
 */
public class CompScore implements Comparable<CompScore> {

    private int score;
    private String date;

    public int compareTo(CompScore score) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return score.score > this.score ? 1 : score.score < this.score ? -1 : 0;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    public CompScore(String date, int score) {
        this.date = date;
        this.score = score;
    }

    public String getScores() {

        return this.date + " - " + this.score;
    }

    public static void main(String args[]) {
        CompScore cs = new CompScore("20131031", 8);

       // System.out.println("" + cs.getScores());

        //System.out.println("" + cs.compareTo(new CompScore("", 8)));
        //Collections.sort(null, args);
        switch (cs.compareTo(new CompScore("56735378", 9))) {
            case 1:
                System.out.println("greater");
                break;
            case -1:
                System.out.println("lesser");
                break;
            case 0:
                System.out.println("equal");
                break;
        }
    }
}
