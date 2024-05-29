import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPaqueteria {
    private JPanel ventana;
    private JTabbedPane tabbedPane1;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton agregarButton;
    private JButton totalPaquetesButton;
    private JComboBox comboBox3;
    private JButton totalPesoPorCiudadButton;
    private JButton totalPesoButton;
    private JList list1;
    private JButton modificarButton;
    private JTextField textField3;
    private JButton modificarEstadoButton;
    private Lista paquetes = new Lista();
    public VentanaPaqueteria() {
        quemarDatos();
        llenarJList();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    paquetes.adicionarElemento(new Paqueteria(Integer.parseInt(spinner1.getValue().toString()),
                            Double.parseDouble(textField1.getText()),
                            comboBox1.getSelectedItem().toString(),
                            comboBox2.getSelectedItem().toString(),
                            textField2.getText()));
                    JOptionPane.showMessageDialog(null, "Paquete agregado");
                    System.out.println(paquetes.listarPaquetes());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }
                setearDatos();
                llenarJList();
            }
        });
        totalPaquetesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "El total de paquetes es " +
                        paquetes.sumarTotalPaquetes());
            }
        });

        totalPesoPorCiudadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Peso total de los paquetes es: " +
                        paquetes.sumarTotalPesoCiudad(comboBox3.getSelectedItem().toString()));

            }
        });
        totalPesoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "El peso total de la ciudad seleccionada es: "+
                        paquetes.sumarTotalPeso());

            }
        });


        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list1.getSelectedIndex() != -1) {
                    int indice = list1.getSelectedIndex();
                    Paqueteria pa = paquetes.getServiEntrega().get(indice);
                    spinner1.setValue(pa.getTracking());
                    textField2.setText(String.valueOf(pa.getPeso()));
                    comboBox1.setSelectedItem(pa.getCiudadEntrega());
                    comboBox2.setSelectedItem(pa.getCiduadRecepcion());
                    textField1.setText(pa.getCedulaReceptor());

                }
            }
        });

    }

    public void setearDatos(){
        spinner1.setValue(0);
        textField2.setText("");
        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);
        textField1.setText("");

    }
    public void quemarDatos(){
        try{
            paquetes.adicionarElemento(new Paqueteria(1,20,"Quito","Guayaquil","1111111111"));
            paquetes.adicionarElemento(new Paqueteria(2,24,"Cuenca","Guayaquil","1111111112"));
            paquetes.adicionarElemento(new Paqueteria(3,28,"Ibarra","Guayaquil","1111111113"));




        }catch (Exception ex1){

        }
    }
    public void llenarJList(){
        DefaultListModel dlm = new DefaultListModel<>();
        for (Paqueteria pa:paquetes.getServiEntrega())
            dlm.addElement(pa);
        list1.setModel(dlm);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPaqueteria");
        frame.setContentPane(new VentanaPaqueteria().ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.pack();
        frame.setVisible(true);
    }

}
