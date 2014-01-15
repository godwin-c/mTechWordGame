/**
 * Your application code goes here
 */
package userclasses;

import com.codename1.io.Storage;
import generated.StateMachineBase;
import com.codename1.ui.*;
import com.codename1.ui.events.*;
//import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.codename1.util.StringUtil;
import java.io.InputStream;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;
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
    //int level = 1;
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
        int k = 0;
        for (int j = 0; j < allWords.size(); j++) {
            String word = allWords.elementAt(j).toString();
            if (word.trim().length() == l) {
                //letter4 = word;
                letter4.add(k, word.trim());
                k++;
            }
        }
        //System.out.println("letter 4 :" + letter4);
    }

    public void timerSeller(final Form f) {
        findTimeLabel(f).setText(String.valueOf(time));
        ui = new UITimer(new Runnable() {
            public void run() {
                --time;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                System.out.println(time);
                //f.revalidate();
                if (time < 0) {
                    ui.cancel();
                    time = 20;
                    Dialog.show("Oops!!", "Time up", "Ok", null);
                    findTimeLabel(f).setText(String.valueOf(time));
                    count++;
                    token -= 10;
                    findTokenLabel(f).setText("" + token);

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
                    findContainer4(f).removeAll();
                    findDisplayField(f).setText("");
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
                        // b.setUIID("NewButton");
                        //prln(tempWord);
                        b.setText(tempLetter.elementAt(l)); //tempWord.substring(l, l + 1));//charAt(i));
                        findContainer4(f).addComponent(b);
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                findDisplayField(f).setText(findDisplayField(f).getText() + b.getText());
                                b.setEnabled(false);
                            }
                        });
                        f.revalidate();
                    }     // prln("" + letter4);
                    //timerSeller(f);

                    prln("letter4 " + letter4.size());
                    timerSeller(f);
                } else {
                    findTimeLabel(f).setText(String.valueOf(time));
                }
            }
        });
        ui.schedule(1000, true, f);

    }

    @Override
    protected void beforePlayForm(final Form f) {
        timerSeller(f);
        final Command[] cmds = new Command[2];
        cmds[0] = new Command("Yes") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (Storage.getInstance().exists("highScore")) {
                    vect = new Vector<Hashtable>();
                    vect = (Vector<Hashtable>) Storage.getInstance().readObject("highScore");
                } else {
                    vect = new Vector<Hashtable>();
                }
                Vector temp = new Vector();
                Vector<Hashtable> temp2 = new Vector<Hashtable>();

                h = new Hashtable();
                h.put("token", String.valueOf(token));
                h.put("date", getCurrentDate());
                System.out.println("Is it adding hashtable h? : " + h);
                vect.add(h);

                for (int i = 0; i < vect.size(); i++) {
                    Hashtable hash = vect.elementAt(i);
                    String s = (String) hash.get("token");
                    temp.add(Integer.parseInt(s));

                }
                System.out.println("unsorted : " + temp);
                Collections.sort(temp);
                System.out.println("sorted list : " + temp);

                for (int j = 0; j < temp.size(); j++) {
                    String ikl = String.valueOf(temp.elementAt(j));

                    for (int i = 0; i < vect.size(); i++) {
                        Hashtable hk = new Hashtable();
                        Hashtable hash = (Hashtable) vect.elementAt(i);
                        String s = (String) hash.get("token");
                        System.out.println("ikl and s are respectively " + ikl + " and " + s);
                        if (Integer.parseInt(s) == Integer.parseInt(ikl)) {

                            hk.put("date", (String) hash.get("date"));
                            hk.put("token", (String) hash.get("token"));
                            System.out.println("hk: " + hk);
                            temp2.add(hk);

                        } else {
                            System.out.println("It could not get hk : ");
                        }
                    }
                }
                // System.out.println("Temp2 size : " + temp2.size());
                //Storage.getInstance().writeObject("highScore", temp2);
                System.out.println("Temp 2 : " + temp2);
                Vector<Hashtable> temp3 = new Vector<Hashtable>();

                if (temp2.size() > 5) {
                    for (int i = temp2.size() - 1; i > temp2.size() - 6; i--) {
                        temp3.add(temp2.elementAt(i));
                    }
                    //Storage.getInstance().writeObject("highScore", temp3);
                } else {
                    for (int i = temp2.size() - 1; i >= 0; i--) {
                        temp3.add(temp2.elementAt(i));
                    }

                }
                Storage.getInstance().writeObject("highScore", temp3);


                vect.clear();
//                    //Storage.getInstance().writeObject("", c);
//                } else {
//                    h = new Hashtable();
//
//                    h.put("token", String.valueOf(token));
//                    h.put("date", getCurrentDate());
//                    vect.add(h);
//                    Storage.getInstance().writeObject("highScore", vect);
//
//                }
                //Dialog.show(":)", "You have completed the game", "Start over", null);
                length = 4;
                count = 0;
                // level = 1;
                point = 10;
                token = 0;
                checkLength(length);
                //======================================================
                Display.getInstance().exitApplication();
            }
        };
        cmds[1] = new Command("No") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((Display.getInstance().getCurrent()) instanceof Dialog) {
                    ((Dialog) Display.getInstance().getCurrent()).dispose();

                }
            }
        };


        f.addCommand(new Command("Exit") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                TextArea text = new TextArea();
                text.setText("Are you sure you want exit?");
                text.setEditable(false);
                //super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                Dialog.show("Hurray!!!", text, cmds);
            }
        });
        findTimeLabel(f).setText(String.valueOf(time));
        //========================================================
        // prln(String.valueOf("size "+allWords.size()));
        //  timerSeller(f);

        findTokenLabel(f).setText("" + token);
        checkLength(length);
        Random rand = new Random();
        int n = rand.nextInt(letter4.size());
        tempWord = "";
        tempWord = letter4.elementAt(n).trim();
        prln(tempWord);
        if (tempLetter != null) {
            tempLetter.clear();
        }

        for (int letter = 0; letter < tempWord.length(); letter++) {
            tempLetter.add(String.valueOf(tempWord.charAt(letter)));
        }
        Collections.shuffle(tempLetter);

        for (int l = 0; l < tempWord.length(); l++) {
            final Button b = new Button();
            //prln(tempWord);
            //b.setUIID("NewButton");
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

        f.setBackCommand(new Command("Back") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                tempLetter.clear();
                back();
            }
        });

    }

    @Override
    protected void beforeMenuForm(final Form f) {
//        if(letter4!=null){
//            letter4.clear();
//            tempWord=null;
//        }
        // Storage.getInstance().clearStorage();
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

        Command exit = new Command("Exit") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                Display.getInstance().exitApplication();
            }
        };
        f.addCommand(exit);

//     Image lbI = fetchResourceFile().getImage("mtechlogo2.png");
//     findLabel(f).setIcon(lbI.scaledWidth(Display.getInstance().getDisplayWidth() / 3));
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

            //allWords = StringUtil.tokenizeString(sb.toString().toLowerCase(), "\n");
            allWords = (Vector<String>) StringUtil.tokenize(sb.toString().toLowerCase(), "\n");
            prln(String.valueOf(allWords.size()));
            //return sb.toString();
        } catch (Exception e) {
        }

//        while (is.read()) {
//            Object object = i.next();
//            
//        }
    }

    private void checkAnswer(final Form f) {
        boolean found = false;
        for (int i = 0; i < allWords.size(); i++) {
            string = (String) allWords.elementAt(i);
            // System.out.println("String to be tested :"+string);
            // System.out.println("String typed : "+findDisplayField(c).getText());
            if (string.equals(findDisplayField(f).getText().trim())) {
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
            point *= findDisplayField(f).getText().length();
            token += point;
            if (findDisplayField(f).getText().length() == tempWord.length()) {
                token += 10;
                System.out.println("10 tokens have been added");
                Dialog.show(":)", "Correct", "Ok", null);
            } else {
                Dialog.show(":)", "Correct but '" + tempWord + "' would have earned you more points", "Ok", null);
            }
            System.out.println("points = " + point + " and token is " + token);
            findTokenLabel(f).setText("" + token);

//            ui.cancel();
            //time = 20;
            //  timerSeller(f);
            System.out.println("Time cancelled");
            point = 10;
        } else {
            Dialog.show(":(", "Wrong. Try '" + tempWord + "' next time", "Ok", null);
            //ui.cancel();
            //time = 20;
            // timerSeller(f);
            System.out.println("Time cancelledd");
            token -= 10;
            findTokenLabel(f).setText("" + token);
        }
        count++;
        System.out.println("You have used " + count + " words");
        if (count == 3) {
            Dialog.show(":)", "You have completed this stage", "Continue", null);
            letter4.clear();
            count = 0;
            length++;
            checkLength(length);
            System.out.println("Using lengh equals " + length);

        }
        if (length == 9) {
            if (Storage.getInstance().exists("highScore")) {
                vect = new Vector<Hashtable>();
                vect = (Vector<Hashtable>) Storage.getInstance().readObject("highScore");
            } else {
                vect = new Vector<Hashtable>();
            }
            Vector temp = new Vector();
            Vector<Hashtable> temp2 = new Vector<Hashtable>();

            h = new Hashtable();
            h.put("token", String.valueOf(token));
            h.put("date", getCurrentDate());
            System.out.println("Is it adding hashtable h? : " + h);
            vect.add(h);

            for (int i = 0; i < vect.size(); i++) {
                Hashtable hash = vect.elementAt(i);
                String s = (String) hash.get("token");
                temp.add(Integer.parseInt(s));

            }
            System.out.println("unsorted : " + temp);
            Collections.sort(temp);
            System.out.println("sorted list : " + temp);

            for (int j = 0; j < temp.size(); j++) {
                String ikl = String.valueOf(temp.elementAt(j));

                for (int i = 0; i < vect.size(); i++) {
                    Hashtable hk = new Hashtable();
                    Hashtable hash = (Hashtable) vect.elementAt(i);
                    String s = (String) hash.get("token");
                    System.out.println("ikl and s are respectively " + ikl + " and " + s);
                    if (Integer.parseInt(s) == Integer.parseInt(ikl)) {

                        hk.put("date", (String) hash.get("date"));
                        hk.put("token", (String) hash.get("token"));
                        System.out.println("hk: " + hk);
                        temp2.add(hk);

                    } else {
                        System.out.println("It could not get hk : ");
                    }
                }
            }
            // System.out.println("Temp2 size : " + temp2.size());
            //Storage.getInstance().writeObject("highScore", temp2);
            System.out.println("Temp 2 : " + temp2);
            Vector<Hashtable> temp3 = new Vector<Hashtable>();

            if (temp2.size() > 5) {
                for (int i = temp2.size() - 1; i > temp2.size() - 6; i--) {
                    temp3.add(temp2.elementAt(i));
                }
                //Storage.getInstance().writeObject("highScore", temp3);
            } else {
                for (int i = temp2.size() - 1; i >= 0; i--) {
                    temp3.add(temp2.elementAt(i));
                }

            }
            Storage.getInstance().writeObject("highScore", temp3);


            vect.clear();
//                    //Storage.getInstance().writeObject("", c);
//                } else {
//                    h = new Hashtable();
//
//                    h.put("token", String.valueOf(token));
//                    h.put("date", getCurrentDate());
//                    vect.add(h);
//                    Storage.getInstance().writeObject("highScore", vect);
//
//                }
            Dialog.show(":)", "You have completed the game", "Start over", null);
            length = 4;
            count = 0;
            // level = 1;
            point = 10;
            token = 0;
            checkLength(length);

        }
        tempLetter.clear();
        findContainer4(f).removeAll();
        findDisplayField(f).setText("");
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
            // b.setUIID("NewButton");
            // prln(tempWord);
            b.setText(tempLetter.elementAt(l)); //tempWord.substring(l, l + 1));//charAt(i));
            findContainer4(f).addComponent(b);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    findDisplayField(f).setText(findDisplayField(f).getText() + b.getText());
                    b.setEnabled(false);
                }
            });
        }     // prln("" + letter4);
        f.revalidate();
    }

    @Override
    protected void onPlayForm_CheckButtonAction(final Component c, ActionEvent event) {
        ui.cancel();
        time = 20;
        checkAnswer(c.getComponentForm());
        timerSeller(c.getComponentForm());
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
            if (Dialog.show(":)", "You have completed the game, Start over?", "yes", "no") ) {
                length = 4;
                count = 0;
                checkLength(length);
            } else {
                back();
            }
            //;

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
            // b.setUIID("NewButton");
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
                f.addComponent(addHighScore(i, "" + string1.get("date"), "" + string1.get("token")));

            }
        }

        f.addComponent(b);
    }

    public Container addHighScore(int j, String date, String score) {
        Resources res = fetchResourceFile();
        final Container c = createContainer(res, "scoreRenderer");
        findCountLabel(c).setText(String.valueOf(j + 1));
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
//    @Override
//    protected boolean allowBackTo(String formName) {
//        return false;//To change body of generated methods, choose Tools | Templates.
//    }
}
