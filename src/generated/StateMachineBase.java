/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Dialog", com.codename1.ui.Dialog.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "MenuForm";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Dialog", com.codename1.ui.Dialog.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "MenuForm");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Container findContainer4(Component root) {
        return (com.codename1.ui.Container)findByName("Container4", root);
    }

    public com.codename1.ui.Container findContainer4() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer3(Component root) {
        return (com.codename1.ui.Container)findByName("Container3", root);
    }

    public com.codename1.ui.Container findContainer3() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findTokenLabel(Component root) {
        return (com.codename1.ui.Label)findByName("tokenLabel", root);
    }

    public com.codename1.ui.Label findTokenLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("tokenLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("tokenLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findWordLabel(Component root) {
        return (com.codename1.ui.Label)findByName("wordLabel", root);
    }

    public com.codename1.ui.Label findWordLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("wordLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("wordLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer6(Component root) {
        return (com.codename1.ui.Container)findByName("Container6", root);
    }

    public com.codename1.ui.Container findContainer6() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer5(Component root) {
        return (com.codename1.ui.Container)findByName("Container5", root);
    }

    public com.codename1.ui.Container findContainer5() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findPointLabel(Component root) {
        return (com.codename1.ui.Label)findByName("pointLabel", root);
    }

    public com.codename1.ui.Label findPointLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("pointLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("pointLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findTimeLabel(Component root) {
        return (com.codename1.ui.Label)findByName("timeLabel", root);
    }

    public com.codename1.ui.Label findTimeLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("timeLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("timeLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findCheckButton(Component root) {
        return (com.codename1.ui.Button)findByName("checkButton", root);
    }

    public com.codename1.ui.Button findCheckButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("checkButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("checkButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findCountLabel(Component root) {
        return (com.codename1.ui.Label)findByName("countLabel", root);
    }

    public com.codename1.ui.Label findCountLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("countLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("countLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findDisplayField(Component root) {
        return (com.codename1.ui.TextField)findByName("displayField", root);
    }

    public com.codename1.ui.TextField findDisplayField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("displayField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("displayField", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findClearButton(Component root) {
        return (com.codename1.ui.Button)findByName("clearButton", root);
    }

    public com.codename1.ui.Button findClearButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("clearButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("clearButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findPlayButton(Component root) {
        return (com.codename1.ui.Button)findByName("playButton", root);
    }

    public com.codename1.ui.Button findPlayButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("playButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("playButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findScoresButton(Component root) {
        return (com.codename1.ui.Button)findByName("scoresButton", root);
    }

    public com.codename1.ui.Button findScoresButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("scoresButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("scoresButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findNewButton(Component root) {
        return (com.codename1.ui.Button)findByName("newButton", root);
    }

    public com.codename1.ui.Button findNewButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("newButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("newButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findSplashLabel(Component root) {
        return (com.codename1.ui.Label)findByName("splashLabel", root);
    }

    public com.codename1.ui.Label findSplashLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("splashLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("splashLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findDateLabel(Component root) {
        return (com.codename1.ui.Label)findByName("dateLabel", root);
    }

    public com.codename1.ui.Label findDateLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("dateLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("dateLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findInstrButton(Component root) {
        return (com.codename1.ui.Button)findByName("instrButton", root);
    }

    public com.codename1.ui.Button findInstrButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("instrButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("instrButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("scoreRenderer".equals(f.getName())) {
            exitScoreRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MenuForm".equals(f.getName())) {
            exitMenuForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("playForm".equals(f.getName())) {
            exitPlayForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("splashScreen".equals(f.getName())) {
            exitSplashScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("HighScores".equals(f.getName())) {
            exitHighScores(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitScoreRenderer(Form f) {
    }


    protected void exitMenuForm(Form f) {
    }


    protected void exitMain(Form f) {
    }


    protected void exitPlayForm(Form f) {
    }


    protected void exitSplashScreen(Form f) {
    }


    protected void exitHighScores(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("scoreRenderer".equals(f.getName())) {
            beforeScoreRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MenuForm".equals(f.getName())) {
            beforeMenuForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("playForm".equals(f.getName())) {
            beforePlayForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("splashScreen".equals(f.getName())) {
            beforeSplashScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("HighScores".equals(f.getName())) {
            beforeHighScores(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeScoreRenderer(Form f) {
    }


    protected void beforeMenuForm(Form f) {
    }


    protected void beforeMain(Form f) {
    }


    protected void beforePlayForm(Form f) {
    }


    protected void beforeSplashScreen(Form f) {
    }


    protected void beforeHighScores(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("scoreRenderer".equals(c.getName())) {
            beforeContainerScoreRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MenuForm".equals(c.getName())) {
            beforeContainerMenuForm(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("playForm".equals(c.getName())) {
            beforeContainerPlayForm(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("splashScreen".equals(c.getName())) {
            beforeContainerSplashScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("HighScores".equals(c.getName())) {
            beforeContainerHighScores(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerScoreRenderer(Container c) {
    }


    protected void beforeContainerMenuForm(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }


    protected void beforeContainerPlayForm(Container c) {
    }


    protected void beforeContainerSplashScreen(Container c) {
    }


    protected void beforeContainerHighScores(Container c) {
    }

    protected void postShow(Form f) {
        if("scoreRenderer".equals(f.getName())) {
            postScoreRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MenuForm".equals(f.getName())) {
            postMenuForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("playForm".equals(f.getName())) {
            postPlayForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("splashScreen".equals(f.getName())) {
            postSplashScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("HighScores".equals(f.getName())) {
            postHighScores(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postScoreRenderer(Form f) {
    }


    protected void postMenuForm(Form f) {
    }


    protected void postMain(Form f) {
    }


    protected void postPlayForm(Form f) {
    }


    protected void postSplashScreen(Form f) {
    }


    protected void postHighScores(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("scoreRenderer".equals(c.getName())) {
            postContainerScoreRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MenuForm".equals(c.getName())) {
            postContainerMenuForm(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("playForm".equals(c.getName())) {
            postContainerPlayForm(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("splashScreen".equals(c.getName())) {
            postContainerSplashScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("HighScores".equals(c.getName())) {
            postContainerHighScores(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerScoreRenderer(Container c) {
    }


    protected void postContainerMenuForm(Container c) {
    }


    protected void postContainerMain(Container c) {
    }


    protected void postContainerPlayForm(Container c) {
    }


    protected void postContainerSplashScreen(Container c) {
    }


    protected void postContainerHighScores(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("scoreRenderer".equals(rootName)) {
            onCreateScoreRenderer();
            aboutToShowThisContainer = null;
            return;
        }

        if("MenuForm".equals(rootName)) {
            onCreateMenuForm();
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

        if("playForm".equals(rootName)) {
            onCreatePlayForm();
            aboutToShowThisContainer = null;
            return;
        }

        if("splashScreen".equals(rootName)) {
            onCreateSplashScreen();
            aboutToShowThisContainer = null;
            return;
        }

        if("HighScores".equals(rootName)) {
            onCreateHighScores();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateScoreRenderer() {
    }


    protected void onCreateMenuForm() {
    }


    protected void onCreateMain() {
    }


    protected void onCreatePlayForm() {
    }


    protected void onCreateSplashScreen() {
    }


    protected void onCreateHighScores() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("scoreRenderer".equals(f.getName())) {
            getStateScoreRenderer(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("MenuForm".equals(f.getName())) {
            getStateMenuForm(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("playForm".equals(f.getName())) {
            getStatePlayForm(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("splashScreen".equals(f.getName())) {
            getStateSplashScreen(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("HighScores".equals(f.getName())) {
            getStateHighScores(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateScoreRenderer(Form f, Hashtable h) {
    }


    protected void getStateMenuForm(Form f, Hashtable h) {
    }


    protected void getStateMain(Form f, Hashtable h) {
    }


    protected void getStatePlayForm(Form f, Hashtable h) {
    }


    protected void getStateSplashScreen(Form f, Hashtable h) {
    }


    protected void getStateHighScores(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("scoreRenderer".equals(f.getName())) {
            setStateScoreRenderer(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("MenuForm".equals(f.getName())) {
            setStateMenuForm(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("playForm".equals(f.getName())) {
            setStatePlayForm(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("splashScreen".equals(f.getName())) {
            setStateSplashScreen(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("HighScores".equals(f.getName())) {
            setStateHighScores(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateScoreRenderer(Form f, Hashtable state) {
    }


    protected void setStateMenuForm(Form f, Hashtable state) {
    }


    protected void setStateMain(Form f, Hashtable state) {
    }


    protected void setStatePlayForm(Form f, Hashtable state) {
    }


    protected void setStateSplashScreen(Form f, Hashtable state) {
    }


    protected void setStateHighScores(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("MenuForm")) {
            if("playButton".equals(c.getName())) {
                onMenuForm_PlayButtonAction(c, event);
                return;
            }
            if("instrButton".equals(c.getName())) {
                onMenuForm_InstrButtonAction(c, event);
                return;
            }
            if("scoresButton".equals(c.getName())) {
                onMenuForm_ScoresButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("playForm")) {
            if("displayField".equals(c.getName())) {
                onPlayForm_DisplayFieldAction(c, event);
                return;
            }
            if("checkButton".equals(c.getName())) {
                onPlayForm_CheckButtonAction(c, event);
                return;
            }
            if("clearButton".equals(c.getName())) {
                onPlayForm_ClearButtonAction(c, event);
                return;
            }
            if("newButton".equals(c.getName())) {
                onPlayForm_NewButtonAction(c, event);
                return;
            }
        }
    }

      protected void onMenuForm_PlayButtonAction(Component c, ActionEvent event) {
      }

      protected void onMenuForm_InstrButtonAction(Component c, ActionEvent event) {
      }

      protected void onMenuForm_ScoresButtonAction(Component c, ActionEvent event) {
      }

      protected void onPlayForm_DisplayFieldAction(Component c, ActionEvent event) {
      }

      protected void onPlayForm_CheckButtonAction(Component c, ActionEvent event) {
      }

      protected void onPlayForm_ClearButtonAction(Component c, ActionEvent event) {
      }

      protected void onPlayForm_NewButtonAction(Component c, ActionEvent event) {
      }

}
