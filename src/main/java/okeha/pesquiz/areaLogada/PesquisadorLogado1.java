package okeha.pesquiz.areaLogada;

public class PesquisadorLogado1 extends javax.swing.JFrame {
    
    Pesquisador P;
    public PesquisadorLogado1(Pesquisador P) {
        this.P = P;
        initComponents();
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botaoMinhasPesquisas = new javax.swing.JButton();
        botaoCriarPesquisas = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bem vindo(a)!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 20, 230, 40);

        botaoMinhasPesquisas.setText("Minhas Pesquisas ");
        botaoMinhasPesquisas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMinhasPesquisasActionPerformed(evt);
            }
        });
        getContentPane().add(botaoMinhasPesquisas);
        botaoMinhasPesquisas.setBounds(120, 100, 160, 40);

        botaoCriarPesquisas.setText("Criar Pesquisas ");
        botaoCriarPesquisas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarPesquisasActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCriarPesquisas);
        botaoCriarPesquisas.setBounds(120, 170, 160, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoMinhasPesquisasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMinhasPesquisasActionPerformed
        
    }//GEN-LAST:event_botaoMinhasPesquisasActionPerformed

    private void botaoCriarPesquisasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarPesquisasActionPerformed
        CriarPesquisa cp = new CriarPesquisa(P.getIdpesquisador());
    }//GEN-LAST:event_botaoCriarPesquisasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCriarPesquisas;
    private javax.swing.JButton botaoMinhasPesquisas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
