package Artists;
import java.awt.Color;
import java.awt.Toolkit;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        EditArtist
 * File         EditArtist.java
 * Description  A class used to edit existing artist.
 * @author	<i>Niko Culevski</i>
 * @see         java.awt.Color
 * @see         java.awt.Toolkit
 * @see         javax.swing.JOptionPane
 * @version	1.2.0
 * Environment  PC, Windows 10, jdk1.8.0_214, NetBeans 11.3
 * Date         3/6/2021
 * History log  8/24/2016, 4/3/2020
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class EditArtist extends javax.swing.JDialog
{
    private Artist newArtist;                   // Player to be created
    private boolean error = false;              // Checking for errors in input
    private String errorMessage = "";           // Error message
    private final int MAX_YEAR = 2021;          // Maximum birth year for artist
    private final int MIN_YEAR = 0;             // Minimum birth year for artist 
    private final Color white = Color.WHITE;    // Default background color for input textfield
    private final Color pink = Color.PINK;      // Background color for bad input textfield
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor   EditArtist()-default constructor
     * Description   Create an instance of the GUI form, set the default
     *               JButton to be saveJButton, set icon image, center form.
     * @author       <i>Niko Culevski</i>
     * Date          4/3/2020
     * History Log   7/18/2018
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public EditArtist()
    {
        initComponents();
        //set saveJButton as default button
        this.getRootPane().setDefaultButton(saveJButton);
        //set icon
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/Artist_small.png"));
        this.setLocationRelativeTo(null);       //center form
        yearJTextField.requestFocus();
        newArtist = null;		       
        setAlwaysOnTop(true);
        setModal(true);
        nameJTextField.requestFocus();
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  EditComposer()-overloaded copy constructor
     * Description  Calls the default constructor to create an instance of the
     *              GUI form and displays information of selected artist.
     * @param       artist Artist
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 4/3/2020
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public EditArtist(Artist artist)
    {
        this();     //call default constructor
        nameJTextField.setText(artist.getName());
        yearJTextField.setText(String.valueOf(artist.getBirthYear()));
        cityJTextField.setText(artist.getCity());  
        countryJTextField.setText(artist.getCountry());  
        nameJTextField.requestFocus();
        nameJTextField.selectAll();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleJPanel = new javax.swing.JPanel();
        addEditJLabel = new javax.swing.JLabel();
        logoJLabel = new javax.swing.JLabel();
        displayJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        ageJLabel = new javax.swing.JLabel();
        yearJTextField = new javax.swing.JTextField();
        balanceJLabel = new javax.swing.JLabel();
        cityJTextField = new javax.swing.JTextField();
        balanceJLabel1 = new javax.swing.JLabel();
        countryJTextField = new javax.swing.JTextField();
        controlPanel = new javax.swing.JPanel();
        saveJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Player");
        setResizable(false);

        addEditJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 36)); // NOI18N
        addEditJLabel.setForeground(new java.awt.Color(51, 0, 0));
        addEditJLabel.setText("Edit Artist");

        logoJLabel.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        logoJLabel.setForeground(new java.awt.Color(51, 0, 0));
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Artists_small.png"))); // NOI18N

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addEditJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addEditJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayJPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 15)));
        displayJPanel.setPreferredSize(new java.awt.Dimension(341, 201));
        displayJPanel.setLayout(new java.awt.GridLayout(4, 2, 5, 5));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameJLabel.setText("Name of Artist:");
        displayJPanel.add(nameJLabel);

        nameJTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nameJTextField.setToolTipText("2 to 40 letters and spaces only");
        nameJTextField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                nameJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(nameJTextField);

        ageJLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ageJLabel.setText("Birth Year:");
        displayJPanel.add(ageJLabel);

        yearJTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        yearJTextField.setToolTipText("2 to 40 letters and spaces only");
        yearJTextField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                yearJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(yearJTextField);

        balanceJLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        balanceJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        balanceJLabel.setText("Birth City:");
        displayJPanel.add(balanceJLabel);

        cityJTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cityJTextField.setToolTipText("Integer between 1600 to 2016");
        cityJTextField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                cityJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(cityJTextField);

        balanceJLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        balanceJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        balanceJLabel1.setText("Birth Country:");
        displayJPanel.add(balanceJLabel1);

        countryJTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        countryJTextField.setToolTipText("Integer between 1600 to 2016");
        countryJTextField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                countryJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(countryJTextField);

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        saveJButton.setBackground(new java.awt.Color(204, 255, 204));
        saveJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        saveJButton.setMnemonic('S');
        saveJButton.setText("Save");
        saveJButton.setMinimumSize(new java.awt.Dimension(57, 45));
        saveJButton.setPreferredSize(new java.awt.Dimension(57, 35));
        saveJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(saveJButton);

        cancelJButton.setBackground(new java.awt.Color(204, 255, 204));
        cancelJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cancelJButton.setMnemonic('n');
        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(cancelJButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       saveJButtonActionPerformed()
     * Description  Create new player if all fields are valid.
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 4/3/2020
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveJButtonActionPerformed
    {//GEN-HEADEREND:event_saveJButtonActionPerformed
        // Read all inputs as strings
        String artistName = nameJTextField.getText();
        String yearString = yearJTextField.getText();
        String cityString = cityJTextField.getText();
        String countryString = countryJTextField.getText();
        // Validate all inputs
        if(!Validation.isValidName(artistName))
        {
            errorMessage += "Invalid Artist Name\n";
            nameJTextField.requestFocus();
            error = true;
            nameJTextField.setToolTipText(nameJTextField.getToolTipText() + 
                    "--Invalid Player Name");
        }
        else if(!Validation.isInteger(yearString, MIN_YEAR, MAX_YEAR))
        {
            errorMessage += "Invalid Birth Year\n";
            yearJTextField.requestFocus();
            error = true;
            yearJTextField.setToolTipText(yearJTextField.getToolTipText() + 
                    "--Invalid Birth Year");
        }
        else if(!Validation.isValidName(cityString))
        {
            errorMessage += "Invalid City\n";
            cityJTextField.requestFocus();
            error = true;
            cityJTextField.setToolTipText(cityJTextField.getToolTipText() 
                + "--Invalid City");
        }
        else if(!Validation.isValidName(countryString))
        {
            errorMessage += "Invalid Country\n";
            countryJTextField.requestFocus();
            error = true;
            countryJTextField.setToolTipText(countryJTextField.getToolTipText() 
                + "--Invalid Country");
        }
        else
            error = false;
       
        if (!error)     // all fields are valid, create a newArtist
        {
            try
            {
                artistName = nameJTextField.getText();
                int year = Integer.parseInt(yearJTextField.getText());
                String city = cityJTextField.getText();
                String country = countryJTextField.getText();
                newArtist = new Artist(artistName, year, city, country);                
                this.dispose();     //close form
            }
            catch(NumberFormatException ex)
            {
                //We should never get here, throw runtime exception
                throw new RuntimeException("Error parsing input");
            }
        }
    }//GEN-LAST:event_saveJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getPlayer()
     * Description  Getter method to return newArtist
     * @author      <i>Niko Culevski</i>
     * @return      newArtist Player
     * Date         4/3/2020
     * History Log  7/18/2018
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public Artist getArtist()
    {
        return newArtist;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method        cancelJButtonActionPerformed()
     * Description   Cancel the operation of edit. newArtist remains null.
     * @param        java.awt.event.ActionEvent 
     * @author       <i>Niko Culevski</i>
     * Date          4/3/2020
     * History Log   7/18/2018
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/       
    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelJButtonActionPerformed
    {//GEN-HEADEREND:event_cancelJButtonActionPerformed
        this.dispose();        
    }//GEN-LAST:event_cancelJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       nameJTextFieldFocusLost()
     * Description  Validate name.
     * @parem       java.awt.event.FocusEvent 
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 4/3/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void nameJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_nameJTextFieldFocusLost
    {//GEN-HEADEREND:event_nameJTextFieldFocusLost
        // Set background textfield color
        String input = nameJTextField.getText();
        if(Validation.isValidName(input))
            nameJTextField.setBackground(white);
        else
            nameJTextField.setBackground(pink);
    }//GEN-LAST:event_nameJTextFieldFocusLost
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       yearJTextFieldFocusLost()
     * Description  Validate year of birth.
     * @parem       java.awt.event.FocusEvent 
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 4/3/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void yearJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_yearJTextFieldFocusLost
    {//GEN-HEADEREND:event_yearJTextFieldFocusLost
        // Set background textfield color
        String input = yearJTextField.getText();
        if(Validation.isInteger(input, MIN_YEAR, MAX_YEAR))
            yearJTextField.setBackground(white);
        else
            yearJTextField.setBackground(pink);
    }//GEN-LAST:event_yearJTextFieldFocusLost
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       cityJTextFieldFocusLost()
     * Description  Validate city.
     * @parem       java.awt.event.FocusEvent 
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 4/3/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void cityJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_cityJTextFieldFocusLost
    {//GEN-HEADEREND:event_cityJTextFieldFocusLost
        // Set background textfield color
        String input = cityJTextField.getText();
        if(Validation.isValidName(input))
            cityJTextField.setBackground(white);
        else
            cityJTextField.setBackground(pink);
    }//GEN-LAST:event_cityJTextFieldFocusLost
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       countryJTextFieldFocusLost()
     * Description  Validate country.
     * @parem       java.awt.event.FocusEvent 
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 4/3/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void countryJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_countryJTextFieldFocusLost
    {//GEN-HEADEREND:event_countryJTextFieldFocusLost
        // Set background textfield color     
        String input = countryJTextField.getText();
        if(Validation.isValidName(input))
            countryJTextField.setBackground(white);
        else
            countryJTextField.setBackground(pink);
    }//GEN-LAST:event_countryJTextFieldFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addEditJLabel;
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JLabel balanceJLabel;
    private javax.swing.JLabel balanceJLabel1;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JTextField cityJTextField;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTextField countryJTextField;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JButton saveJButton;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JTextField yearJTextField;
    // End of variables declaration//GEN-END:variables
}
