import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class frame extends JFrame{
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                InfectionTimeStorage.writeInfectionTime(virusList);
            } catch (IOException ex) {
            }
        }
    }
    private ArrayList<InfectionTime> virusList;
    private JButton getButton, writeButton, readButton, clearButton;
    private JPanel panel;
    private JScrollPane scroll;
    private final JTextArea textArea;

    public frame(ArrayList<InfectionTime> validViruses) {
        virusList = validViruses;
        setTitle("Infection Time");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 40);
        getContentPane().add(BorderLayout.CENTER, textArea);

        panel = new JPanel();
        scroll = new JScrollPane(textArea);
        textArea.setAutoscrolls(true);
        getContentPane().add(scroll);


        getButton = new JButton("Get");
        writeButton = new JButton("Write");
        readButton = new JButton("Read");
        clearButton = new JButton("Clear");

        panel.add(getButton);
        panel.add(writeButton);
        panel.add(readButton);
        panel.add(clearButton);

        getContentPane().add(BorderLayout.SOUTH, panel);


        getButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (InfectionTime iterate: virusList){
                textArea.append(String.valueOf(iterate) + "\n");
                }
                textArea.append(String.valueOf("\n" + virusList.size()) + " Viruses generated");
            }
        });

        writeButton.addActionListener(new ButtonListener());

        clearButton.addActionListener((e -> textArea.setText("")));

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                ArrayList<InfectionTime> VirusFile = InfectionTimeStorage.readInfectionTime();
                for(InfectionTime itterate: VirusFile){
                    textArea.append(String.valueOf(itterate) + "\n");
                }
            }
        });
        
        setVisible(true);
    }
}


