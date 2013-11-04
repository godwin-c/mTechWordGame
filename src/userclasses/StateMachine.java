/**
 * Your application code goes here
 */
package userclasses;

import com.codename1.io.Storage;
import generated.StateMachineBase;
import com.codename1.ui.*;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.*;
//import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.codename1.util.StringUtil;
import java.io.InputStream;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import com.mtechcomm.wordgame.CompScore;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

    Vector<String> allWords = new Vector<String>();
    String tempWord;
    String string;
    int point = 10;
    int token = 0;
    int time = 20;
    int count = 0;
    int length = 4;
    int level = 1;
    UITimer ui;
    String currentDate;
    Vector<String> letter4 = new Vector<String>();
    Vector<String> tempLetter = new Vector<String>();
    Vector<Hashtable> vect = new Vector<Hashtable>();
    Hashtable h = new Hashtable(), h1 = new Hashtable(), h2 = new Hashtable(), h3 = new Hashtable(), h4 = new Hashtable();
    CompScore cs; //new CompScore(currentDate, token);

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    /**
     * this method should be used to initialize variables instead of the
     * constructor/class scope to avoid race conditions
     */
    @Override
    protected void initVars(Resources res) {
    }

    @Override
    protected boolean processBackground(Form f) {
        return super.processBackground(f); //To change body of generated methods, choose Tools | Templates.

    }

    public void prln(String string) {
        System.out.println(string);
    }
//    @Override
//    protected void beforeSplashScreen(Form f) {
//    
//    }

    @Override
    protected void onMenuForm_PlayButtonAction(Component c, ActionEvent event) {
        printFile();
        showForm("playForm", null);


    }

    public void checkLength(int l) {
        for (int j = 0; j < allWords.size(); j++) {
            String word = allWords.elementAt(j).toString();
            int k = 0;
            if (word.trim().length() == l) {
                //letter4 = word;
                letter4.add(k, word.trim());
                k++;
            }
        }
        System.out.println("letter 4 :" + letter4);
    }

    @Override
    protected void beforePlayForm(final Form f) {
        findTimeLabel(f).setText(String.valueOf(time));
        //========================================================
        // prln(String.valueOf("size "+allWords.size()));
        ui = new UITimer(new Runnable() {
            public void run() {
                --time;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                findTimeLabel(f).setText(String.valueOf(time));
                // System.out.println(time);
                //f.revalidate();
                if (time <= 0) {
                }
            }
        });
        // ui.schedule(1000, true, f);
        time = 20;
        findTokenLabel(f).setText("" + token);
        checkLength(length);

        Random rand = new Random();
        int n = rand.nextInt(letter4.size());
        tempWord = letter4.elementAt(n).trim();
        prln(tempWord);
        for (int letter = 0; letter < tempWord.length(); letter++) {
            tempLetter.add(String.valueOf(tempWord.charAt(letter)));
        }
        Collections.shuffle(tempLetter);

        for (int l = 0; l < tempWord.length(); l++) {
            final Button b = new Button();
            //prln(tempWord);
            b.setText(tempLetter.elementAt(l)); //tempWord.substring(l, l + 1));//charAt(i));
            findContainer4(f).addComponent(b);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    findDisplayField(f).setText(findDisplayField(f).getText() + b.getText());
                    b.setEnabled(false);
                }
            });
        }     // prln("" + letter4);
        prln("letter4 " + letter4.size());

    }

    @Override
    protected void beforeMenuForm(final Form f) {
        //Storage.getInstance().clearStorage();
        Display.getInstance().lockOrientation(true);
        //f.setTransitionInAnimator(CommonTransitions.createSlide(0, true, 2000));
        f.revalidate();
        Container c4 = findContainer(f);
        //h.put("token", 0);

        for (int iter = 0; iter < c4.getComponentCount(); iter++) {
            Component current = c4.getComponentAt(iter);
            if (iter % 2 == 0) {
                current.setX(-current.getWidth());
            } else {
                current.setX(current.getWidth());
            }
        }
        c4.setShouldCalcPreferredSize(true);
        c4.animateLayout(2000);
    }

    private void printFile() {
        InputStream is = Display.getInstance().getResourceAsStream(this.getClass(), "/wordlist.txt");
        StringBuilder sb = new StringBuilder();

        try {
            int chars;
            while ((chars = is.read()) != -1) {
                sb.append((char) chars);

            }
            // allWords.add(  sb.toString().split("\n"));

            allWords = StringUtil.tokenizeString(sb.toString().toLowerCase(), "\n");

            prln(String.valueOf(allWords.size()));
            //return sb.toString();
        } catch (Exception e) {
        }

//        while (is.read()) {
//            Object object = i.next();
//            
//        }
    }

    @Override
    protected void onPlayForm_CheckButtonAction(final Component c, ActionEvent event) {

        boolean found = false;
        for (int i = 0; i < allWords.size(); i++) {
            string = (String) allWords.elementAt(i);
            // System.out.println("String to be tested :"+string);
            // System.out.println("String typed : "+findDisplayField(c).getText());
            if (string.equals(findDisplayField(c).getText().trim())) {
                found = true;
                //Dialog.show(":)", "Correct", "Ok", null);
                break;
            } else {
                found = false;
                // Dialog.show(":(", "Wrong", "Ok", null);
            }
        }
        System.out.println(found);
        if (found) {
            point *= findDisplayField(c).getText().length();
            token += point;
            if (findDisplayField(c).getText().length() == tempWord.length()) {

                token += 10;
                System.out.println("10 tokens have been added");
            }
            System.out.println("points = " + point + " and token is " + token);
            findTokenLabel(c).setText("" + token);
            Dialog.show(":)", "Correct", "Ok", null);

            point = 10;
        } else {
            Dialog.show(":(", "Wrong", "Ok", null);
            token -= 10;
            findTokenLabel(c).setText("" + token);
        }
        time = 20;
        count++;
        prln(tempWord);
        System.out.println("You have used " + count + " words");
        if (count == 3) {

            System.out.println("You have successfully completed stage 1");
            if (Storage.getInstance().exists("highScore")) {

                vect = (Vector<Hashtable>) Storage.getInstance().readObject("highScore");

            } else {
                vect = new Vector<Hashtable>();
            }

            if (vect.size() > 0) {
                for (int i = 0; i < vect.size(); i++) {
                    Hashtable hash = vect.elementAt(i);
                    //cs = new CompScore(getCurrentDate(), token);
                    cs = new CompScore((String) hash.get("date"), Integer.parseInt((String) hash.get("token")));
                    //switch (cs.compareTo(new CompScore((String)hash.get("date"), Integer.parseInt((String)hash.get("token"))))) {
                    switch (cs.compareTo(new CompScore(getCurrentDate(), token))) {
                        case 1:
                            System.out.println(token + " compared to " + (String) hash.get("token"));
                            h.put("token", String.valueOf(token));
                            h.put("date", getCurrentDate());
                            vect.add(h);
                            System.out.println("greater");
                            break;
                        case -1:
                            System.out.println(token + " compared to " + (String) hash.get("token"));
                            System.out.println("lesser");
                            break;
                        case 0:
                            System.out.println(token + " compared to " + (String) hash.get("token"));
                            System.out.println("equal");
                            break;
                    }
                }
            } else {
                h = new Hashtable();

                h.put("token", String.valueOf(token));
                h.put("date", getCurrentDate());
                vect.add(h);
            }


            Storage.getInstance().writeObject("highScore", vect);
            System.out.println("" + h);
            Dialog.show(":)", "You have completed this stage", "Continue", null);
            letter4.clear();
            count++;
            length++;
            level++;
            checkLength(length);
            count = 0;
        }
        if (length == 9) {

            Dialog.show(":)", "You have completed the game", "Start over", null);
            length = 4;
            count = 0;
            level = 1;
            checkLength(length);
        }
        tempLetter.clear();
        findContainer4(c.getComponentForm()).removeAll();
        findDisplayField(c).setText("");
        //showForm("playForm", null);
        Random rand = new Random();
        int n = rand.nextInt(letter4.size());
        tempWord = letter4.elementAt(n);
        for (int letter = 0; letter < tempWord.length(); letter++) {
            tempLetter.add(String.valueOf(tempWord.charAt(letter)));
        }
        Collections.shuffle(tempLetter);

        for (int l = 0; l < tempWord.length(); l++) {
            final Button b = new Button();
            // prln(tempWord);
            b.setText(tempLetter.elementAt(l)); //tempWord.substring(l, l + 1));//charAt(i));
            findContainer4(c.getComponentForm()).addComponent(b);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    findDisplayField(c.getComponentForm()).setText(findDisplayField(c.getComponentForm()).getText() + b.getText());
                    b.setEnabled(false);
                }
            });
        }     // prln("" + letter4);
        c.getComponentForm().revalidate();

    }

    @Override
    protected void onPlayForm_ClearButtonAction(Component c, ActionEvent event) {
        findDisplayField(c).setText("");
        //int i = findContainer4(c.getComponentForm()).getComponentCount();
        for (int j = 0; j < findContainer4(c.getComponentForm()).getComponentCount(); j++) {
            if (!findContainer4(c.getComponentForm()).getComponentAt(j).isEnabled()) {
                findContainer4(c.getComponentForm()).getComponentAt(j).setEnabled(true);
            }
        }
    }

    @Override
    protected void onPlayForm_NewButtonAction(final Component c, ActionEvent event) {
        count++;
        token -= 5;
        findTokenLabel(c).setText("" + token);

        if (count == 3) {
            System.out.println("You have successfully completed stage 1");
            Dialog.show(":)", "You have completed this stage", "Continue", null);
            letter4.clear();
            count++;
            length++;
            checkLength(length);
            count = 0;
        }
        if (length == 9) {
            Dialog.show(":)", "You have completed the game", "Start over", null);
            length = 4;
            count = 0;
            checkLength(length);
        }
        tempLetter.clear();
        findContainer4(c.getComponentForm()).removeAll();
        findDisplayField(c.getComponentForm()).setText("");
        //showForm("playForm", null);

        //checkLength(length);

        Random rand = new Random();
        int n = rand.nextInt(letter4.size());
        tempWord = letter4.elementAt(n).trim();
        prln(tempWord);
        for (int letter = 0; letter < tempWord.length(); letter++) {
            tempLetter.add(String.valueOf(tempWord.charAt(letter)));
        }
        Collections.shuffle(tempLetter);
        prln(tempLetter.toString());
        for (int l = 0; l < tempWord.length(); l++) {
            final Button b = new Button();
            //prln(tempWord);
            b.setText(tempLetter.elementAt(l)); //tempWord.substring(l, l + 1));//charAt(i));
            findContainer4(c.getComponentForm()).addComponent(b);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    findDisplayField(c.getComponentForm()).setText(findDisplayField(c.getComponentForm()).getText() + b.getText());
                    b.setEnabled(false);
                }
            });
        }     // prln("" + letter4);
        c.getComponentForm().revalidate();
        prln("letter4 " + letter4.size());


    }

    /**
     * This is the method I use in getting the system current date and time
     */
    private String getCurrentDate() {


        java.util.Calendar cal = java.util.Calendar.getInstance();
        //plus 1 for month cos java starts January at 0 for Gregorian calendar...see doc for Calendar.MONTH
        currentDate = String.valueOf(cal.get(java.util.Calendar.DAY_OF_MONTH)) + ":" + String.valueOf(cal.get(java.util.Calendar.MONTH) + 1) + ":" + String.valueOf(cal.get(java.util.Calendar.YEAR));
        //String currentDate = String.valueOf(cal.get(java.util.Calendar.DAY_OF_MONTH)) + String.valueOf(cal.get(java.util.Calendar.MONTH) + 1) + String.valueOf(cal.get(java.util.Calendar.YEAR));
        System.out.println("" + currentDate);
//        int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
//        int min = cal.get(java.util.Calendar.MINUTE);
//        int sec = cal.get(java.util.Calendar.SECOND);
//        int millsec = cal.get(java.util.Calendar.MILLISECOND);

        // String currentTime = String.valueOf(hour) + ":" + String.valueOf(min) + ":" + String.valueOf(sec) + "." + String.valueOf(millsec);


        return currentDate; //+ " " + currentTime;

    }

    @Override
    protected void onMenuForm_InstrButtonAction(Component c, ActionEvent event) {
    }

    @Override
    protected void beforeHighScores(Form f) {
        vect = (Vector<Hashtable>) Storage.getInstance().readObject("highScore");
//        Dialog.show("High scores", getCurrentDate() + " - " + h.get("token").toString(), "OK", null);
//        getCurrentDate();
        // ;
        Button b = new Button("Close");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ((Dialog) Display.getInstance().getCurrent()).dispose();
            }
        });

        if (vect != null) {
            for (int i = 0; i < vect.size(); i++) {

                Hashtable string1 = vect.elementAt(i);
                f.addComponent(addHighScore("" + i, "" + string1.get("date"), "" + string1.get("token")));

            }
        }

        f.addComponent(b);
    }

    public Container addHighScore(String j, String date, String score) {
        Resources res = fetchResourceFile();
        final Container c = createContainer(res, "scoreRenderer");
        findCountLabel(c).setText(String.valueOf(j));
        findDateLabel(c).setText(date);
        findPointLabel(c).setText(score);
//        List l = new List();
//        for(int i=0;i<vect.size();i++){
//            l.addItem(vect.elementAt(i));
//        }
//        c.addComponent(l);
        return c;
    }

    public void getScores() {
        vect = (Vector<Hashtable>) Storage.getInstance().readObject("highScore");
        //vect.add(getCurrentDate() + " - " + h.get("token").toString());
        // Dialog.show("High scores", getCurrentDate() + " - " + h.get("token").toString(), "OK", null);
        getCurrentDate();


    }

    @Override
    protected void onMenuForm_ScoresButtonAction(Component c, ActionEvent event) {
        showForm("HighScores", null);
    }
}
