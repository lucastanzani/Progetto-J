package gui;

import client.Client;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.InetAddressValidator;

/**
 * Pannello per il Login
 */
public class LoginFrame extends JFrame {
    
    private ConfigListener configListener;
    
    private Socket socket;
    //public BufferedReader in = null;
    //public PrintStream out = null;
    private String nickname;
    
    /**
     * Costruttore della finestra di Login
     */
    public LoginFrame() {
        super("Connessione al server");
        initComponents();
        portField.setEditable(false);
    }

    /**
     * Ritorna la socket
     * @return la socket
     */
    public Socket getSocket() {
        return socket;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ipField = new javax.swing.JFormattedTextField();
        portField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nicknameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        connectionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jLabel1.setText("IP:");

        ipField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipFieldActionPerformed(evt);
            }
        });

        portField.setText("7777");

        jLabel2.setText("Port:");

        jLabel3.setText("Nickname");

        connectButton.setText("Connetti");
        configListener = new ConfigListener(connectButton);
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(portField)
                            .addComponent(ipField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nicknameField, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(connectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(connectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        configListener.addDocument(ipField.getDocument());
        configListener.addDocument(nicknameField.getDocument());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipFieldActionPerformed
    }//GEN-LAST:event_ipFieldActionPerformed

    /**
     * Lancia la connessione
     */
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        if (!InetAddressValidator.getInstance().isValid(this.ipField.getText()) || Integer.parseInt(portField.getText()) > 65535)
            JOptionPane.showMessageDialog(this, "Indirizzo ip non valido", "Errore", JOptionPane.ERROR_MESSAGE);
        else {
            try {
                socket = new Socket();
                String ip = ipField.getText();
                int port = Integer.parseInt(portField.getText());
                socket.connect(new InetSocketAddress(ip, port), 10000);
                connectionLabel.setText("Connesso!");
                nickname = nicknameField.getText();
                //in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //out = new PrintStream(socket.getOutputStream(), true);
                Client client = new Client(socket, nickname);
                Thread clientThread = new Thread(client);
                clientThread.start();
                dispose();
            } catch (IOException ex) {
                connectionLabel.setText("Errore di connessione");
            }  
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JFormattedTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JTextField portField;
    // End of variables declaration//GEN-END:variables

    /**
     * Ritorna il nickname del giocatore
     * @return il nickname del giocatore
     */
    public String getNickname() {
        return this.nickname;
    }
}