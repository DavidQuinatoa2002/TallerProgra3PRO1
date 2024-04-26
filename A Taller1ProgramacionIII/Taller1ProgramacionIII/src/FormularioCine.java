import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FormularioCine {
    private JPanel principal;
    private JComboBox cboPelicula;
    private JComboBox cboCantidad;
    private JButton cboComprar;
    private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel txtAutor;

    private Cine mario = new Cine();
    private Cine xmen = new Cine();

    public FormularioCine() {
        try {
        String a="",b="";
        do {
            b= JOptionPane.showInputDialog("Ingrese su número de cédula real");
            a = JOptionPane.showInputDialog("Ingrese su nombre real");
        }while(b.length()<10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a+b);
        }catch (Exception ex) {

        }
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboPelicula.getSelectedItem().equals("XMEN")){
                    try {
                        if (Integer.parseInt((String) cboCantidad.getSelectedItem())==4 ){
                            JOptionPane.showMessageDialog(null,"Unicamente se puede reservar 3 entradas");
                        }else {
                            xmen.encolar((String) cboPelicula.getSelectedItem(),Integer.parseInt((String) cboCantidad.getSelectedItem()));
                        }
                        JOptionPane.showMessageDialog(null,"Entradas disponibles" + xmen.entradasDisponibles());

                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                if (cboPelicula.getSelectedItem().equals("MARIO")){
                    if (Integer.parseInt((String) cboCantidad.getSelectedItem())==4){
                        JOptionPane.showMessageDialog(null,"Unicamente se puede reservar 3 entradas");

                    }else{
                        mario.encolar((String) cboPelicula.getSelectedItem(),Integer.parseInt((String) cboCantidad.getSelectedItem()));
                        try {
                            JOptionPane.showMessageDialog(null,"Entradas disponibles"+mario.entradasDisponibles());
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }
                }


            txtEntradas.setText(xmen.listarAsistente()+mario.listarAsistente());
            }
        });


        btnPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null,"Entradas disponibles "+xmen.entradasDisponibles());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });

        btnPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null,"Entradas disponibles "+mario.entradasDisponibles());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioCine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
