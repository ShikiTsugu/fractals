package src.graphic;

import src.builders.buildFractals;
import src.functions.Function;
import src.functions.Polynom;
import src.functions.Trigonometry;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;

    public Controller(Model m){
        model = m;
    }

    public Model getModel() {
        return model;
    }

    public void activateMainButtons(){
        model.getJulia().addActionListener((event)->{
            model.getMandelbrot().setEnabled(false);
            model.removeAll();
            model.typeSelect(this);
            model.updateUI();
        });
        model.getMandelbrot().addActionListener((event)->{
            model.getJulia().setEnabled(false);
            model.removeAll();
            model.typeSelect(this);
            model.updateUI();
        });
        model.getQuit().addActionListener((event)->System.exit(0));
    }

    public void removeListeners(JButton b){
        for(ActionListener al : b.getActionListeners()){
            b.removeActionListener(al);
        }
    }

    public void getModelFormat(int id){
        System.out.println("was = "+id);
        if(id == 1) {
            model.mainMenu();
            removeListeners(model.getBack());
            activateMainButtons();
        }else if (id == 2) {
            model.typeSelect(this);
            removeListeners(model.getBack());
            activateTypeButtons();
        }else if (id == 3){
            if(!model.getJulia().isEnabled()){
                model.mandelbrotSettings(this);
            }else if(!model.getMandelbrot().isEnabled()){
                model.juliaSettings(this);
                removeListeners(model.getBack());
            }
            removeListeners(model.getBack());
            activateSetSettings();
        }
    }

    public void activateTypeButtons(){
        if(!model.getMandelbrot().isEnabled()) {
            model.getPolynom().addActionListener((event) -> {
                model.getTrigonometry().setEnabled(false);
                model.removeAll();
                model.juliaSettings(this);
                model.updateUI();
            });
            model.getTrigonometry().addActionListener((event) -> {
                model.getPolynom().setEnabled(false);
                model.removeAll();
                model.juliaSettings(this);
                model.updateUI();
            });
        }else if(!model.getJulia().isEnabled()){
            model.getPolynom().addActionListener((event) -> {
                model.getTrigonometry().setEnabled(false);
                model.removeAll();
                model.mandelbrotSettings(this);
                model.updateUI();
            });
            model.getTrigonometry().addActionListener((event) -> {
                model.getPolynom().setEnabled(false);
                model.removeAll();
                model.mandelbrotSettings(this);
                model.updateUI();
            });
        }
        model.getBack().addActionListener((event)->{
            model.removeAll();
            getModelFormat(model.getId());
            model.updateUI();
        });
    }

    public void activatePolyOrTrigo() {
        if (!model.getTrigonometry().isEnabled()) {
            model.getDegre().addActionListener(e -> {
                try {
                    int val = Integer.parseInt(model.getDegre().getText());
                    model.setPolyInfo(val);
                    model.getDegre().setText("Value set to " + val);
                    model.getDegre().setEditable(false);
                } catch (NumberFormatException ex) {
                    model.getDegre().setText("Invalid value");
                }
            });
        } else if (!model.getPolynom().isEnabled()) {
            model.getType().addActionListener(e -> {
                String val = model.getType().getText();
                if(!val.equals("C")&&!val.equals("S")&&!val.equals("T")) {
                    model.getType().setText("Invalid value");
                }else {
                    model.setTrigoInfo(val);
                    model.getType().setText("Value set to " + val);
                    model.getType().setEditable(false);
                }
            });
        }
    }

    public Function generateFunction(){
        Function f = new Polynom(model);
        if (!model.getPolynom().isEnabled()) {
            f = new Trigonometry(model);
        }
        return f;
    }

    public void activateSetSettings(){
        activatePolyOrTrigo();
        if(!model.getMandelbrot().isEnabled()) {
            model.getcRe().addActionListener(e -> {
                try {
                    double val = Double.parseDouble(model.getcRe().getText());
                    model.setConstRE(val);
                    model.getcRe().setText("Value set to " + val);
                    model.getcRe().setEditable(false);
                } catch (NumberFormatException ex) {
                    model.getcRe().setText("Invalid value");
                }
            });
            model.getcIm().addActionListener(e -> {
                try {
                    double val = Double.parseDouble(model.getcIm().getText());
                    model.setConstIM(val);
                    model.getcIm().setText("Value set to " + val);
                    model.getcIm().setEditable(false);
                } catch (NumberFormatException ex) {
                    model.getcIm().setText("Invalid value");
                }
            });
        }
        model.getNext().addActionListener((event) -> {
            model.setTypeF(generateFunction());
            model.removeAll();
            model.finalChoices(this);
            model.updateUI();
        });
    }

    public void activateFinalSettings(){
        model.getHueVal().addActionListener(e -> {
            try {
                float val = Float.parseFloat(model.getHueVal().getText());
                model.setHue(val);
                model.getHueVal().setText("Value set to " + val);
                model.getHueVal().setEditable(false);
            } catch (NumberFormatException ex) {
                model.getHueVal().setText("Invalid value");
            }
        });
        model.getSizeVal().addActionListener(e -> {
            try {
                int val = Integer.parseInt(model.getSizeVal().getText());
                model.setSize(val);
                model.getSizeVal().setText("Value set to " + val);
                model.getSizeVal().setEditable(false);
                if(model.getHue()!=-1){
                    model.getDownload().setEnabled(true);
                }
            } catch (NumberFormatException ex) {
                model.getSizeVal().setText("Invalid value");
            }
        });
        model.getDownload().addActionListener((event)->{
            buildFractals f = new buildFractals(model.getSet(), false);
            f.setHue(model.getHue());
            f.setScale(model.getSizeFrac());
            f.generateFile();
            model.getDownload().setEnabled(false);
        });
        model.getBack().addActionListener((event)->{
            model.removeAll();
            getModelFormat(model.getId());
            model.updateUI();
        });
    }
}
