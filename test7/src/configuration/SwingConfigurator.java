/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.and open the template in the editor.
 */

package configuration;

/**
 *
 * @author Gabriel Edgar Delgado Rocha
 */

import java.util.ArrayList;
import utils.FileManager;

public class SwingConfigurator extends javax.swing.JFrame {

    private FileManager fileManager;
    private final String CONFIG_PATH = "config.txt";
    private final String APP_NAME = "Jarvis Blower Configuration";
    
    /**
     * Creates new form SwingConfigurator
     */
    public SwingConfigurator() {
        initComponents();
        this.setTitle(APP_NAME);
        
        try {
            fileManager = new FileManager();
            if (fileManager.existFile(CONFIG_PATH)) {

                ArrayList<String> content = fileManager.readFile(CONFIG_PATH);
                urlText.setText(content.get(0));
                usernameText.setText(content.get(1));
                passwordText.setText(content.get(2));
                tokenText.setText(content.get(3));
            }
        } catch(Exception ex) {
            
            System.out.println(ex.getMessage());
            // TODO add to logger
        }
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        centralPanel = new javax.swing.JPanel();
        urlLabel = new javax.swing.JLabel();
        urlText = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        tokenLabel = new javax.swing.JLabel();
        tokenText = new javax.swing.JTextField();
        tokenButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        buttonsSeparator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setLayout(new java.awt.BorderLayout());

        headerLabel.setText("Configuration");
        headerPanel.add(headerLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(headerPanel, java.awt.BorderLayout.NORTH);

        centralPanel.setLayout(new java.awt.GridBagLayout());

        urlLabel.setText("Server URL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        centralPanel.add(urlLabel, gridBagConstraints);

        urlText.setPreferredSize(new java.awt.Dimension(234, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        centralPanel.add(urlText, gridBagConstraints);

        usernameLabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        centralPanel.add(usernameLabel, gridBagConstraints);

        usernameText.setPreferredSize(new java.awt.Dimension(234, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        centralPanel.add(usernameText, gridBagConstraints);

        passwordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        centralPanel.add(passwordLabel, gridBagConstraints);

        passwordText.setPreferredSize(new java.awt.Dimension(234, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        centralPanel.add(passwordText, gridBagConstraints);

        tokenLabel.setText("Token");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        centralPanel.add(tokenLabel, gridBagConstraints);

        tokenText.setPreferredSize(new java.awt.Dimension(234, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        centralPanel.add(tokenText, gridBagConstraints);

        tokenButton.setText("Get Token");
        tokenButton.setPreferredSize(new java.awt.Dimension(106, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        centralPanel.add(tokenButton, gridBagConstraints);

        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        centralPanel.add(resultLabel, gridBagConstraints);

        getContentPane().add(centralPanel, java.awt.BorderLayout.CENTER);

        footerPanel.setLayout(new java.awt.GridBagLayout());

        clearButton.setText("Clear");
        clearButton.setPreferredSize(new java.awt.Dimension(94, 34));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        footerPanel.add(clearButton, gridBagConstraints);

        saveButton.setText("Save");
        saveButton.setPreferredSize(new java.awt.Dimension(94, 34));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        footerPanel.add(saveButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(94, 34));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        footerPanel.add(cancelButton, gridBagConstraints);

        buttonsSeparator.setPreferredSize(new java.awt.Dimension(21, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        footerPanel.add(buttonsSeparator, gridBagConstraints);

        getContentPane().add(footerPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        
        urlText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        tokenText.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        ArrayList<String> content = new ArrayList();
        content.add(urlText.getText());
        content.add(usernameText.getText());
        content.add(passwordText.getPassword().toString());
        content.add(tokenText.getText());
        
        fileManager.writeFile(CONFIG_PATH, content);
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SwingConfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SwingConfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SwingConfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SwingConfigurator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SwingConfigurator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator buttonsSeparator;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel centralPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton tokenButton;
    private javax.swing.JLabel tokenLabel;
    private javax.swing.JTextField tokenText;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlText;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
