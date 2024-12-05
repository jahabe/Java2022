package Artists;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        About.java
 * Description  About form for the Artists Quiz Application
 * Project      Artists Quiz
 * Platform     jdk 1.8.0_214; NetBeans IDE 11.3; Windows 10
 * Course       CS 142, EdCC
 * Hourse       2 hours and 45 minutes
 * Date         3/6/2021
 * Histoly log  5/7/2020
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %4%
 * @see     	javax.swing.JDialog
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class About extends javax.swing.JDialog
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre> 
     * Constructor  JDialog to allow to select modal or modeless form
     * Description  Create the form as designed, center it, set the icon, 
     *              closeJButton as default.
     * Date         5/7//2020
     * History log  
     *</pre>
     * @author      <i>Niko Culevski</i>
     * @param       parent java.awt.Frame
     * @param       modal boolean
     * @see         javax.swing.JDialog
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public About(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        //set closeJButton as default
        this.getRootPane().setDefaultButton(closeJButton); 
        this.setLocationRelativeTo(null);       //center form
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleJLabel = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();
        authorJLabel = new javax.swing.JLabel();
        versionJLabel = new javax.swing.JLabel();
        copyrightJLabel1 = new javax.swing.JLabel();
        dateJLabel = new javax.swing.JLabel();
        infoJScrollPane = new javax.swing.JScrollPane();
        infoJTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Artists About");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 37)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Artists_small.png"))); // NOI18N
        titleJLabel.setText("Artists Quiz About Form");

        closeJButton.setBackground(new java.awt.Color(204, 255, 204));
        closeJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        closeJButton.setMnemonic('C');
        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                closeJButtonActionPerformed(evt);
            }
        });

        authorJLabel.setText("Author:  Niko Culevski");

        versionJLabel.setText("Version 1.2.4");

        copyrightJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyrightJLabel1.setText("Copyright: Freeware");

        dateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateJLabel.setText("Date:  5/7/2020");

        infoJScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        infoJTextArea.setEditable(false);
        infoJTextArea.setColumns(20);
        infoJTextArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        infoJTextArea.setLineWrap(true);
        infoJTextArea.setRows(5);
        infoJTextArea.setText("This program tests the user's knowledge of paintings by famous artists. The application displays a random unused for the duration of the quiz image of a painting and asks the user to identify the name of the artist who painted it. A binary search tree with Artist objects from an Artist class with name, year of birth, city of birth and country comma-delimited fields is used for the database. The program has the ability to add, edit, delete, and serch artists in the database that is maintainedin a text file, Artists.txt.");
        infoJTextArea.setWrapStyleWord(true);
        infoJScrollPane.setViewportView(infoJTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(versionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(authorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copyrightJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titleJLabel)
                .addGap(18, 18, 18)
                .addComponent(infoJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(copyrightJLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(versionJLabel))
                    .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorJLabel))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       closeJButtonActionPerformed
     * Description  Closes the About form only
     * Date         3/31/2020
     * History log  4/4/2016, 1/4/2019
     * @author      <i>Niko Culevski</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeJButtonActionPerformed
    {//GEN-HEADEREND:event_closeJButtonActionPerformed
        this.dispose();        
}//GEN-LAST:event_closeJButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorJLabel;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel1;
    private javax.swing.JLabel dateJLabel;
    private javax.swing.JScrollPane infoJScrollPane;
    private javax.swing.JTextArea infoJTextArea;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel versionJLabel;
    // End of variables declaration//GEN-END:variables
}
