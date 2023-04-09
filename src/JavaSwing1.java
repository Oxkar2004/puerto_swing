import PagG12.Contenedor;
import PagG12.Hub;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;;

public class JavaSwing1 extends JFrame{
    private JLabel NumId;
    private JTextField textNumId;
    private JTextField textPeso;
    private JTextArea textAreaDescrp;
    private JTextField textRemitente;
    private JTextField textReceptora;
    private JComboBox comboBoxProcedencia;
    private JRadioButton radioButton1;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JCheckBox checkBoxInspeccion;
    private JTextArea textAreaEstado;
    private JButton buttonApilar;
    private JButton buttonCuantos;
    private JButton buttonDesapilar;
    private JButton buttonDatosCont;
    private JTextField textDesapilar;
    private JTextField textDatoscont;
    private JComboBox comboBoxCuantos;
    private JTextField textField7;
    private JLabel Peso;
    private JLabel Descripcion;
    private JLabel EmpRemitente;
    private JLabel EmpReceptora;
    private JLabel Estado;
    private JLabel PaisProc;
    private JLabel Prioridad;
    private JPanel JPanel;
    private JPanel JpanelOperaciones;

    private Hub hub = new Hub();

    public JPanel getHUB() {
        return JPanel;
    }
    public JavaSwing1(){

        String[] paises = {"Argentina", "España", "Francia", "Italia", "Croacia", "Alemania", "Brasil", "Estados Unidos", "Inglaterra"};
        List<String> listaPaises = new ArrayList<>(Arrays.asList(paises));
        Collections.shuffle(listaPaises);

        mostrarEstadoHub();

        for (String pais : listaPaises) {
            comboBoxProcedencia.addItem(pais);
            comboBoxCuantos.addItem(pais);
        }
        buttonApilar.addActionListener(new ActionListener() {
            List<Integer> idList = new ArrayList<Integer>();
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                try {
                    id = Integer.parseInt(textNumId.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(JPanel, "Debe introducir un ID válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (idList.contains(id)) {
                    JOptionPane.showMessageDialog(JPanel, "El ID ya ha sido ingresado anteriormente", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                idList.add(id);
                int peso = Integer.parseInt(textPeso.getText());
                String contenido = textAreaDescrp.getText();
                String remitente = textRemitente.getText();
                String receptor = textReceptora.getText();
                String pais = comboBoxProcedencia.getSelectedItem().toString();
                int prioridad;
                if(radioButton1.isSelected()){
                    prioridad=1;
                }else if(a2RadioButton.isSelected()){
                    prioridad=2;
                }else if(a3RadioButton.isSelected()){
                    prioridad=3;
                }else {
                    prioridad=-1;
                }
                boolean inspeccionado;
                if(checkBoxInspeccion.isSelected()){
                     inspeccionado=true;
                }else {inspeccionado=false;}

                Contenedor m = new Contenedor(id,peso,prioridad,pais,contenido,remitente,receptor,inspeccionado);

                hub.apilar(m);
                mostrarEstadoHub();
            }
        });
        buttonDesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textDesapilar.getText();
                int columna = -1;
                try {
                    columna = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(JPanel, "Columna no válida ");
                    return;
                }

                Contenedor m = hub.desapilar(columna);

                if (m != null) {
                    textAreaEstado.setText(hub.toString());
                    JOptionPane.showMessageDialog(JPanel, "Contenedor desapilado correctamente: " + m.getId());
                } else {
                    JOptionPane.showMessageDialog(JPanel, "No se ha encontrado ningún contenedor en la columna ");
                }
                mostrarEstadoHub();
            }
        });
        buttonDatosCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textDatoscont.getText();
                if(id.isEmpty()) {
                    JOptionPane.showMessageDialog(JPanel, "Debe introducir un ID ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int idInt = Integer.parseInt(id);
                Contenedor m = null;
                Contenedor[][] c = hub.getC();
                for (int i = 0; i < c.length; i++) {
                    for (int j = 0; j < c[i].length; j++) {
                        if (c[i][j] != null && c[i][j].getId() == idInt) {
                            m = c[i][j];
                            break;
                        }
                    }
                    if (m != null) break;
                }
                if (m == null) {
                    JOptionPane.showMessageDialog(JPanel, "El contenedor con el ID " + id + " no está en el HUB", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(JPanel, m.toString() ,  "Datos del contenedor", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonCuantos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p = textField7.getText();
                if(p.isEmpty()) {
                    JOptionPane.showMessageDialog(JPanel, "Debe introducir una Prioridad ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int pInt = Integer.parseInt(p);
                List<Integer> contenedoresprioridad = new ArrayList<>();
                Contenedor[][] x = hub.getC();
                for (int i = 0; i < x.length; i++) {
                    for (int j = 0; j < x[i].length; j++) {
                        Contenedor m = x[i][j];
                        if (m != null && m.getPrioridad() == pInt) {
                            contenedoresprioridad.add(m.getId());
                        }
                    }
                }
                String pais = (String) comboBoxCuantos.getSelectedItem();
                if (pais == null || pais.isEmpty()) {
                    JOptionPane.showMessageDialog(JPanel, "Tienes que seleccionar un país.");
                    return;
                }
                List<Integer> contenedoresEnPais = new ArrayList<>();
                Contenedor[][] c = hub.getC();
                for (int i = 0; i < c.length; i++) {
                    for (int j = 0; j < c[i].length; j++) {
                        Contenedor m = c[i][j];
                        if (m != null && m.getPais().equals(pais)) {
                            contenedoresEnPais.add(m.getId());
                        }
                    }
                }
                if (contenedoresEnPais.isEmpty() || contenedoresprioridad.isEmpty()) {
                    JOptionPane.showMessageDialog(JPanel, "No hay contenedores en ese país y prioridad");
                } else {
                    List<Integer> contenedoresComunes = new ArrayList<>(contenedoresEnPais);
                    contenedoresComunes.retainAll(contenedoresprioridad);
                    if (contenedoresComunes.isEmpty()) {
                        JOptionPane.showMessageDialog(JPanel, "No hay contenedores en ese país y prioridad");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (Integer id : contenedoresComunes) {
                            sb.append(id).append("\n");
                        }
                        JOptionPane.showMessageDialog(JPanel, sb.toString());
                    }
                }
            }
        });
    }
    private void mostrarEstadoHub(){
        textAreaEstado.setText(hub.toString());
    }
}
