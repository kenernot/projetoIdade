package br.com.lucasj.view;

import br.com.lucasj.model.ModelIdade;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author lukas
 */
public class TelaIdade extends JFrame implements ActionListener {

    private ModelIdade modeloIdade;

    private JTextField edNascimento, edAtual, edIdade;
    private JButton btCalcular;

    public TelaIdade() {
        super("Calculo de idade!");
        init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void init() {
        this.setLayout(new GridLayout(0, 2));

        edNascimento = new JTextField();
        edAtual = new JTextField();
        edIdade = new JTextField();

        edIdade.setEditable(false);

        btCalcular = new JButton("Calcular");
        btCalcular.setActionCommand("idade.calcular");

        this.add(new JLabel("Ano Nascimento: "));
        this.add(edNascimento);
        this.add(new JLabel("Ano Atual: "));
        this.add(edAtual);
        this.add(new JLabel("Idade: "));
        this.add(edIdade);
        this.add(btCalcular);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public ModelIdade getModeloIdade() {
        if (!edNascimento.getText().isEmpty() && !edAtual.getText().isEmpty()) {
            modeloIdade.setAnoNascimento(Integer.parseInt(edNascimento.getText()));
            modeloIdade.setAnoAtual(Integer.parseInt(edAtual.getText()));
            return modeloIdade;
        }
        return null;
    }

    public void setModeloIdade(ModelIdade modeloIdade) {
        if (modeloIdade.getAnoAtual() > modeloIdade.getAnoNascimento()) {
            edIdade.setText(Integer.toString(modeloIdade.getIdade()));
        }
        this.modeloIdade = modeloIdade;
    }

    public void addControllerActionListener(ActionListener al) {
        btCalcular.addActionListener(al);
    }

}
