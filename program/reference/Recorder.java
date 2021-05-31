
package sharpmacro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Francesco Verardo
 */
public class Recorder extends JFrame implements ActionListener{
    private JPanel main, panel1, panel2;
    private JButton play, strec, stprec, imp;
    private JTable list;
    String[][] process;
    String[] jTableName;
    
    public Recorder(){
        process = new String[10][2];
        jTableName = new String[1];
        jTableName[0] = "Active processes";
        
        Icon imgplay = new ImageIcon("C:\\Users\\Utente\\Downloads\\playback.png");
        Icon imgrec = new ImageIcon("C:\\Users\\Utente\\Downloads\\record.png");
        Icon imgstop = new ImageIcon("C:\\Users\\Utente\\Downloads\\stop.png");
        
        main = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        play = new JButton(imgplay);
        strec = new JButton(imgrec);
        stprec = new JButton(imgstop);
        imp = new JButton("imposta processo");
        list = new JTable(process, jTableName) {
            @Override
            public boolean isCellEditable(int row,int column) {
                return false;
            }
        };
        list.setSelectionModel(new ForcedListSelectionModel());
        
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(panel1);
        main.add(panel2);
        
        play.addActionListener(this);
        strec.addActionListener(this);
        stprec.addActionListener(this);
        imp.addActionListener(this);
        
        panel1.add(play,BorderLayout.NORTH);
        panel1.add(strec,BorderLayout.NORTH);
        panel1.add(stprec,BorderLayout.NORTH);
        panel2.add(list,BorderLayout.SOUTH);
        panel2.add(new JScrollPane(list));
        panel2.add(imp);
        
        TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black));
        title.setTitleJustification(TitledBorder.LEFT);
        main.setBorder(title);
        
        setContentPane(main);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,800);
        setResizable(false);
        setLocation(100, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
    
    public static void main(String[] args){
        Recorder c = new Recorder();
    }
    
    public class ForcedListSelectionModel extends DefaultListSelectionModel {
        public ForcedListSelectionModel () {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        
        @Override
        public void clearSelection() {}
        
        @Override
        public void removeSelectionInterval(int index0, int index1) {}
    }
}
