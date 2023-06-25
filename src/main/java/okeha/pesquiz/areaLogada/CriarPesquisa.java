package okeha.pesquiz.areaLogada;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okeha.pesquiz.conexaoBD.Creates;

public class CriarPesquisa extends javax.swing.JFrame {
    
    Creates c;
    int id_pesquisador;
    int id_pesquisa;
    public CriarPesquisa(int id_pesquisador) {
        this.id_pesquisador = id_pesquisador;
        initComponents();
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldTitulo = new javax.swing.JTextField();
        botaoProximo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Crie sua pesquisa:");

        fieldTitulo.setText("Titulo");

        botaoProximo.setText("Próximo");
        botaoProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoProximo)
                .addGap(196, 196, 196))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(fieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195)
                .addComponent(botaoProximo)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProximoActionPerformed
        try {
            c = new Creates();
        } catch (Exception ex) {
            Logger.getLogger(CriarPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            id_pesquisa = c.nova_pesquisa(id_pesquisador, fieldTitulo.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CriarPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        CriarQuestionario cq = new CriarQuestionario(id_pesquisa);
    }//GEN-LAST:event_botaoProximoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoProximo;
    private javax.swing.JTextField fieldTitulo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
