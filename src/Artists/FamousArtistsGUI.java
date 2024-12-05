package Artists;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        FamousArtistsGUI.java
 * Description  A class representing the GUI used in a famous artists quiz 
 *              application.
 * Project      FamousArtistsGUI Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 141
 * Hourse       8 hours and 45 minutes
 * Date         5/17/2020
 * History Log  4/4/2016, 11/21/2017
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %2%
 * @see     	javax.swing.JFrame
 * @see        java.awt.Toolkit 
 *</pre>
 * 8--Late.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class FamousArtistsGUI extends javax.swing.JFrame
{
    //class instance variables
    BinarySearchTree artistTree = new BinarySearchTree();
    private final int MAX_QUESTIONS = 5;        // maximun number of questions
    private String fileName = "src/Artists/Artists_1.txt";
    private String artistName = "";
    private int count = 0;  // number of artists that have been displayed
    
    private ArrayList<String> artistsNames = new ArrayList<String>();
    private ArrayList<Boolean> artUsed = new ArrayList<Boolean>();
    private ArrayList<Integer> numbersUsed = new ArrayList<Integer>();
    
    private int currentIndex;           // contains the index of current artist
    private int countCorrect = 0;       // number of correct answers
    private int numberOfArtists = 0;    // number of artists

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  FamousArtistsGUI()-default constructor
     * Description  Create an instance of the GUI form, set the default
     *              JButton to be submitJButton, set icon image, center form,
     *              read artists from external file.
     * Date         5/7/2020
     * History Log  7/18/2018  
     * @author      <i>Niko Culevski</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public FamousArtistsGUI()
    {
        initComponents();
       //set the display JButton as the default key as ENTER:
        this.getRootPane().setDefaultButton(submitJButton);
        //set a icon picture on the Title:
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/Artists_small.png"));        
        this.setLocationRelativeTo(null);   //center form
        readArtistsFromFile(fileName);
        //Arrays.sort(artistsNames.toArray());     // sort the array: replace this with insertion sort
        //fillComboBox(artistsNames);    // populate combobox with artists names
        displayArtist();          // display first sign  randomly      
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       readArtistsFromFile
     * Description  Reads artists from a file Artists.txt and fill artistsJComboBox.  
     * Date         5/7/2020
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     * @param       fileName String
     * @see         java.io.File
     * @see         java.util.Scanner
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void readArtistsFromFile(String fileName)
    {   
        numberOfArtists = 0;
        artistsJComboBox.removeAllItems();
        
        artistTree.removeAll(); //remove all from TreeSet
        artistsNames.clear();   //clear array list with names
        artUsed.clear();        //clear boolean array list
        try
        {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            String line = "";
            //read from file and count how many there are to size the arrays
            while(fileScanner.hasNextLine())
            {
                artUsed.add(false);     //set boolean ArrayList to false
                numbersUsed.add(numberOfArtists);
                line = fileScanner.nextLine();
                numberOfArtists++;
                Artist myArtist = new Artist();       //create an artist                
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                while (stringTokenizer.hasMoreElements()) 
                {
                    myArtist.setName(stringTokenizer.nextElement().toString());
                    myArtist.setBirthYear(Integer.parseInt(stringTokenizer.nextElement().toString()));                    
                    myArtist.setCity(stringTokenizer.nextElement().toString()); 
                    myArtist.setCountry(stringTokenizer.nextElement().toString()); 
		}
                //add player to players TreeSet
                artistTree.insertNode(myArtist);
                artistsNames.add(myArtist.getName());
 
            }
            fileScanner.close();
            fillComboBox(artistsNames);         // fill combo box with names
        } 
        catch(FileNotFoundException exp)
        {
            JOptionPane.showMessageDialog(null, fileName + " does not exist", 
                    "File Input Error", JOptionPane.WARNING_MESSAGE);            
            //Bring up JFileChooser to select file in current directory
            JFileChooser chooser= new JFileChooser("src/Artists");
            //Filter only txt files
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Txt Files", "txt");
            chooser.setFileFilter(filter);
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION)
            {          
                File chosenFile = chooser.getSelectedFile();
                fileName = "src/Artists/" + chosenFile.getName();
                System.out.println("file = " + fileName);  
                readArtistsFromFile(fileName);                
            }                                       
            else 
            {
                //exp.printStackTrace();
                System.exit(0);
            }
        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(null, "Unable to read file", 
                    "File Input Error", JOptionPane.WARNING_MESSAGE);          
        }                
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       fillComboBox
     * Description  Fill artistsJComboBox with names of artists only
     * Date         5/7/2020
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     * @param       artists String[]
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @SuppressWarnings("unchecked")
    private void fillComboBox(ArrayList<String> artists)
    {
        artistsJComboBox.removeAllItems();      //clear first artistsJComboBox
        for (String sign : artists)
        {
            artistsJComboBox.addItem(sign);
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       displayArtist
     * Description  Choose a random and unused art and display it in the 
     *              artistJLabel.
     * Date         5/7/2020
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void displayArtist()
    {
        currentIndex = getUniqueAlternate();   //getUniqueRandomNumber(); 
        // create the path for file
        String art = artistsJComboBox.getItemAt(currentIndex).toString();
        String artPath = "src/Images/" + art + ".png";
        // set the artistJLabel to display the art
        artistJLabel.setIcon(new ImageIcon(artPath));
        artistJLabel.setToolTipText(art);  //uncomment for tool tip to display artist
    } 

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       displayArtist
     * Description  Overloaded method to display art with a specified index.
     * Date         5/7/2020
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void displayArtist(int index)
    {
        currentIndex = getUniqueRandomNumber(); 
        // create the path for file
        artistName = artistsJComboBox.getItemAt(index).toString();
        String artPath = "src/Images/" + artistName + ".png";
        // set the artistJLabel to display the art
        artistJLabel.setIcon(new ImageIcon(artPath));
        artistJLabel.setToolTipText(artistName);  //uncomment for tool tip to display artist
    } 
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getUniqueRandomNumber
     * Description  Return an unused random number by a blind repetition of
     *              random generation and checking for unused artist
     * Date         5/7/2020
     * History Log  7/18/2018
     * @return      random int
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private int getUniqueRandomNumber()
    {
        Random generator = new Random();
        int randomNumber = 0;
        // generate random numbers until unused artist is found, blindly
        do
        {
            randomNumber = generator.nextInt(artistsNames.size());
        }
        while (artUsed.get(randomNumber));
        
        // indicate that artist has been used
        artUsed.set(randomNumber, true);
        return randomNumber;
    } 
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getUniqueAlternate
     * Description  A better way to select unique and unused random integer 
     *              for unused sign
     * Date         5/7/2020
     * History Log  7/18/2018
     * @return      random int
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private int getUniqueAlternate()
    {
        //Return unique unused integer for next artist
        int randomNumber = 0;
        Random rand = new Random();
        //get a random number of available ones
        if(numberOfArtists > 0)
            randomNumber = rand.nextInt(numberOfArtists);
        int uniqueRandomNumber = numbersUsed.get(randomNumber);

        //copy the last index into the current random index
        numbersUsed.set(randomNumber, numbersUsed.get(numberOfArtists - 1));
        numberOfArtists--;
        return uniqueRandomNumber;
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

        artistJLabel = new javax.swing.JLabel();
        controlJPanel = new javax.swing.JPanel();
        submitJButton = new javax.swing.JButton();
        nextJButton = new javax.swing.JButton();
        playJButton = new javax.swing.JButton();
        selectJPanel = new javax.swing.JPanel();
        selectJLabel = new javax.swing.JLabel();
        artistsJComboBox = new javax.swing.JComboBox();
        resultJLabel = new javax.swing.JLabel();
        quizJLabel = new javax.swing.JLabel();
        artistsJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        exitJMenuItem = new javax.swing.JMenuItem();
        dataJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Famous Artists Quiz");
        setResizable(false);

        artistJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edgar Degas.png"))); // NOI18N
        artistJLabel.setFocusable(false);

        controlJPanel.setLayout(new java.awt.GridLayout(3, 1, 3, 5));

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitJButton.setMnemonic('S');
        submitJButton.setText("Submit");
        submitJButton.setToolTipText("Click to submit your answer");
        submitJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                submitJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(submitJButton);

        nextJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextJButton.setMnemonic('N');
        nextJButton.setText("Next Artist");
        nextJButton.setToolTipText("Click to see next sign");
        nextJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(nextJButton);

        playJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        playJButton.setMnemonic('P');
        playJButton.setText("Play Again");
        playJButton.setToolTipText("Play all over again!");
        playJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                playJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(playJButton);

        selectJPanel.setLayout(new java.awt.GridLayout(3, 1, 3, 5));

        selectJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        selectJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectJLabel.setText("Select Artists:");
        selectJLabel.setToolTipText("");
        selectJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectJPanel.add(selectJLabel);

        artistsJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        artistsJComboBox.setToolTipText("Select sign description to match road sign");
        selectJPanel.add(artistsJComboBox);

        resultJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        resultJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectJPanel.add(resultJLabel);

        quizJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 24)); // NOI18N
        quizJLabel.setForeground(new java.awt.Color(0, 102, 102));
        quizJLabel.setText("Famous Artist Quiz");

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        openJMenuItem.setMnemonic('N');
        openJMenuItem.setText("New");
        openJMenuItem.setToolTipText("Open a new set of art works");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openJMenuItem);

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear player, start a new quiz");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print Form");
        printJMenuItem.setToolTipText("Print Form as GUI");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(fileJSeparator);

        exitJMenuItem.setMnemonic('X');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.setToolTipText("End application");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        artistsJMenuBar.add(fileJMenu);

        dataJMenu.setMnemonic('D');
        dataJMenu.setText("Database Operations");
        dataJMenu.setToolTipText("Add, Edit, Delete, Search and other operations");

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Add");
        addJMenuItem.setToolTipText("Add new artist");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addJMenuItemActionPerformed(evt);
            }
        });
        dataJMenu.add(addJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit");
        editJMenuItem.setToolTipText("Edit current artist");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editJMenuItemActionPerformed(evt);
            }
        });
        dataJMenu.add(editJMenuItem);

        deleteJMenuItem.setMnemonic('t');
        deleteJMenuItem.setText("Delete");
        deleteJMenuItem.setToolTipText("Delete selected artist");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        dataJMenu.add(deleteJMenuItem);

        searchJMenuItem.setMnemonic('S');
        searchJMenuItem.setText("Search");
        searchJMenuItem.setToolTipText("Search for artist (resets quiz)");
        searchJMenuItem.setEnabled(false);
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchJMenuItemActionPerformed(evt);
            }
        });
        dataJMenu.add(searchJMenuItem);

        artistsJMenuBar.add(dataJMenu);

        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        artistsJMenuBar.add(helpJMenu);

        setJMenuBar(artistsJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(artistJLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(quizJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quizJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(artistJLabel))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       submitJButtonActionPerformed
     * Description  Event handler to check if the user's answer is correct. The
     *              correct answer is held in class instance variable 
     *              currentIndex.
     * Date         5/7/2020
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        count++;
        if (artistsJComboBox.getSelectedIndex() == currentIndex) //correct
        {
            countCorrect++;
            resultJLabel.setText("Correct! " + countCorrect + "/" + count);
            
        }
        else    //if an incorrect answer is given
        {
            resultJLabel.setText("Incorrect " +  countCorrect + "/" + count);
        }              
        // Inform user if quiz is over and enable/disable appropriate buttons
        if (count == MAX_QUESTIONS) 
        {
            resultJLabel.setText(countCorrect + "/" + MAX_QUESTIONS + " Correct!");
            nextJButton.setEnabled(false);
            submitJButton.setEnabled(false);
            playJButton.setEnabled(true);
            playJButton.requestFocus();     //better: make default
            artistsJComboBox.setEnabled(false);
            searchJMenuItem.setEnabled(true);
        }
        else //if less than 5 questions have been displayed
        {
            submitJButton.setEnabled(false);
            nextJButton.setEnabled(true);
            nextJButton.requestFocus();     //better: make default
            playJButton.setEnabled(false);
            searchJMenuItem.setEnabled(false);
        }
    }//GEN-LAST:event_submitJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       nextJButtonActionPerformed
     * Description  Event handler to select next unused sign randomly by 
     *              calling the displayArtist() method.
     * Date         5/7/2020
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void nextJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJButtonActionPerformed
        displayArtist();    
        //reset GUI components to initial states
        resultJLabel.setText("");
        artistsJComboBox.setSelectedIndex(0);
        submitJButton.setEnabled(true);
        nextJButton.setEnabled(false);
    }//GEN-LAST:event_nextJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       playJButtonActionPerformed
     * Description  Event handler to start the game all over again.
     * Date         5/7/2020
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void playJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playJButtonActionPerformed
        // Start game all over
        countCorrect = 0;
        count = 0;
        resultJLabel.setText("");
        submitJButton.setEnabled(true);
        submitJButton.requestFocus();       //better: make default
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false);
        artistsJComboBox.setEnabled(true);
        searchJMenuItem.setEnabled(false);
        artistsJComboBox.setSelectedIndex(0);
        numberOfArtists = artistsNames.size();        
        //reset boolean array to false and number array to i's
        for(int i = 0; i < artistsNames.size(); i++)
        {
            artUsed.set(i, false); 
            numbersUsed.set(i, i);
        }
        displayArtist();      //redisplay new artists        
    }//GEN-LAST:event_playJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       openJMenuItemActionPerformed
     * Description  Event handler to chose a separate file of artists.
     * Date         5/7/2020
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void openJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJMenuItemActionPerformed
        //Bring up JFileChooser to select file in current directory
        try
        {
            JFileChooser fileJFileChooser = new JFileChooser("src/Artists");
            //limit to txt files
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Txt Files", "txt");
            fileJFileChooser.setFileFilter(filter);
            int returnVal = fileJFileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File file = fileJFileChooser.getSelectedFile();  
                fileName = "src/Artists/" + file.getName();
                //clear artUsed and numbersUsed ArrayList
                artUsed.clear();
                numbersUsed.clear();

                readArtistsFromFile(fileName);                           
                clearJMenuItemActionPerformed(evt);
                displayArtist();          // display first sign  randomly 
            } 
            else 
            {
                System.out.println("File access cancelled by user.");
            }
        }
        catch(Exception exp)
        {
             JOptionPane.showMessageDialog(null, "Unable to open file", 
                    "File Open Error", JOptionPane.WARNING_MESSAGE);   
        }
    }//GEN-LAST:event_openJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       aboutJMenuItemActionPerformed()
     * Description  Create an About form and show it. 
     * Date         5/3/2020
     * History Log  7/18/2018  
    *</pre>
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aboutJMenuItemActionPerformed
    {//GEN-HEADEREND:event_aboutJMenuItemActionPerformed
        About aboutWindow = new About(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       printJMenuItemActionPerformed()
     * Description  Event handler to print the for as a GUI. Calls the
     *              PrintUtilities class printComponent method.
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018     
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_printJMenuItemActionPerformed
    {//GEN-HEADEREND:event_printJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       clearJMenuItemActionPerformed()
     * Description  Event handler to clear the form and start anew. Calls the
     *              playJButtonActionPerformed event handler.
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018     
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearJMenuItemActionPerformed
    {//GEN-HEADEREND:event_clearJMenuItemActionPerformed
        playJButtonActionPerformed(evt);
    }//GEN-LAST:event_clearJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       exitJMenuItemActionPerformed()
     * Description  Event handler to end the application.
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018     
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJMenuItemActionPerformed
    {//GEN-HEADEREND:event_exitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       addJMenuItemActionPerformed()
     * Description  Event handler to add new artist do the DB.
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018     
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @SuppressWarnings("unchecked")
    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addJMenuItemActionPerformed
    {//GEN-HEADEREND:event_addJMenuItemActionPerformed
        try
        {
            AddArtist artistDialog = new AddArtist();
            artistDialog.setVisible(true);

            // The modal dialog takes focus, upon regaining focus
            Artist newArtist = artistDialog.getArtist();
            if (newArtist != null && !(artistTree.contains(newArtist)))
            {
                // Add the new player to the database and artistsJComboBox
                artistTree.insertNode(newArtist);
                artistsNames.add(newArtist.getName());
                numberOfArtists = artistsNames.size();
                artistsJComboBox.addItem(newArtist.getName());
                artUsed.add(false);
                numbersUsed.add(numberOfArtists - 1);
                displayArtist();                  //refresh GUI
                saveArtists(fileName);
            }
            else      //display message artist is not saved or not
            {
                JOptionPane.showMessageDialog(null, "Artist " + 
                    newArtist.getName() + " exists!", "Not Saved", 
                    JOptionPane.INFORMATION_MESSAGE);
                artistsJComboBox.setVisible(true);
                artistsJComboBox.setSelectedIndex(0);                
            }
        }
        catch (NullPointerException exp)
        {
            JOptionPane.showMessageDialog(null, "Artist not Added",
                "Input Error", JOptionPane.WARNING_MESSAGE);
            artistsJComboBox.setVisible(true);
            artistsJComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_addJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       saveArtists()
     * Description  Write artist to a text file that is comma (,) delimited.
     * @param       file String
     * @author      <i>Niko Culevski</i>
     * Date         5/10/2020
     * History Log  7/18/2018  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void saveArtists(String file)
    {
        try 
        {
            FileWriter filePointer = new FileWriter(file);
            PrintWriter writeFile = new PrintWriter(filePointer);    
            BinarySearchTreeNode root = artistTree.getRoot();     //get root of BinarySearchTree
            //initialize buffer
            artistTree.setBuffer(new StringBuilder());
            
            artistTree.buildBuffer(root);       // build file content
            //delete the last '\n'
            String buffer = artistTree.getBuffer().substring(0, 
                    artistTree.getBuffer().length() - 1);
            System.out.println("In Save buffer = " + buffer);
            writeFile.print(buffer);    // write to file
            //artistTree.saveTree(root,file);     // write to file
            //String output = artistTree.printTree(root);            
            //System.out.println("output in saveArtists = \n " + output);
            writeFile.close();
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, "Unable to write to file",
                "Write File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       searchArtist()
     * Description  Search for artist by name and return node that contains it.
     * @param       name String
     * @return      Artist node BinarySearchTreeNode
     * @author      <i>Niko Culevski</i>
     * Date         5/10/2020
     * History Log  7/18/2018  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode searchArtist(String name)
    {
        return artistTree.nodeWith(name, artistTree.getRoot());
    }
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       inorderSave()
     * Description  Recursive method to save tree nodes to an external file. Not
     *              used in the application and incomplete!
     * @param       node BinarySearchTreeNode 
     * @param       writeFile PrintWriter
     * @return      Artist node BinarySearchTreeNode
     * @author      <i>Niko Culevski</i>
     * Date         5/10/2020
     * History Log  7/18/2018  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void inorderSave(BinarySearchTreeNode node, PrintWriter writeFile)
    {
        StringBuilder buf = new StringBuilder("");
	if( node != null )
        {
            Artist temp = node.data;
            if(temp.compareTo(node.data) < 0)
                inorderSave(node.left, writeFile);
            else
                inorderSave(node.right, writeFile);
	    buf.append(temp.getName()+ "," + temp.getBirthYear() + "," + 
                    temp.getCity() + "," + temp.getCountry() + '\n');
            writeFile.write(buf.toString());	    
	}    
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       editJMenuItemActionPerformed()
     * Description  Edit selected artist.
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018, 1/5/2019
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @SuppressWarnings("unchecked")
    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editJMenuItemActionPerformed
    {//GEN-HEADEREND:event_editJMenuItemActionPerformed
        //int index = artistsJComboBox.getSelectedIndex();
        try
        {              
            //get name of selected composer, but strip year if there
            String artistName = artistsJComboBox.getSelectedItem().toString();
          
            //search for artist with given name and return Artist object
            Artist artistToEdit = searchArtist(artistName).data;
                                                
            //pass artist info to EditArtist constructor and view in Edit form
            EditArtist editGUI = new EditArtist(artistToEdit);
            editGUI.setVisible(true);                                

            //get edited artist and add to the TreeSet and array list  
            Artist editedArtist = editGUI.getArtist();
            if (editedArtist != null &&  !(artistTree.contains(editedArtist)))
            {
                //remove old artist from BST & ArrayList of names & artistsJComboBox
                artistTree.remove(artistToEdit);               
                artistsNames.remove(artistName);
                artistsJComboBox.removeItem(artistName);
                
                //add edited artist to BST & ArrayList of names & artistsJComboBox
                artistTree.insertNode(editedArtist);
                artistsNames.add(editedArtist.getName());
                artistsJComboBox.addItem(editedArtist.getName());
                
                //save new artists list to file
                saveArtists(fileName);                    
                displayArtist();
            }            
        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Artist not Edited", 
                    "Input Error", JOptionPane.WARNING_MESSAGE);
            artistsJComboBox.setVisible(true);
            artistsJComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_editJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       deleteJButtonActionPerformed()
     * Description  Delete an existing artist with confirmation dialog
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018, 1/5/2019
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteJMenuItemActionPerformed
    {//GEN-HEADEREND:event_deleteJMenuItemActionPerformed
        // get selected artist
        artistName = artistsJComboBox.getSelectedItem().toString();                
        int result = JOptionPane.showConfirmDialog(null, 
            "Are you sure you wish to delete " + artistName + "?", "Delete Artist",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);        

        if (result == JOptionPane.OK_OPTION) // confirm delete selected Artist
        {
            int index = artistsJComboBox.getSelectedIndex();  
            artistsJComboBox.removeItem(artistName); //remove from artistsJComboBox
            artistsNames.remove(artistName);    //remove name from artistsNames ArrayList
            
            //get node from tree that has artist name
            BinarySearchTreeNode tempNode = artistTree.nodeWith(artistName, artistTree.getRoot());
           
            Artist temp = tempNode.data;
            artistTree.remove(temp);        //remove artst from tree
            numbersUsed.add(numberOfArtists - 1);
            artUsed.remove(artUsed.size() - 1);
            numbersUsed.remove(numbersUsed.size() - 1);
            
            displayArtist();
            saveArtists(fileName);
        }
    }//GEN-LAST:event_deleteJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       searchJMenuItemActionPerformed()
     * Description  Event handler to search artist by name and to display it.
     *              Calls searchArtist() to do the searching
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018  
     * @param       evt java.awt.event.ActionEvent
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchJMenuItemActionPerformed
    {//GEN-HEADEREND:event_searchJMenuItemActionPerformed
        artistName = JOptionPane.showInputDialog(null, "Enter name of artist: ",
            "Search artist by name", JOptionPane.INFORMATION_MESSAGE);
        if ((artistName != null) && (artistName.length() > 0)) 
        {
            // get the BinarySearchTreeNode that has artist's name
            BinarySearchTreeNode result = searchArtist(artistName); 
            int index = findIndex(artistName);  //find index in combo box
            if(result != null && index >= 0)
            {
                playJButtonActionPerformed(evt);
                displayArtist(index);
                artistsJComboBox.setSelectedItem(artistName);
            }
            else
            {
                JOptionPane.showMessageDialog(null,artistName + 
                    " is not in the database.", "Search Artist", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }        
    }//GEN-LAST:event_searchJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       findIndex()
     * Description  Method to find the index of specified artist in 
     *              artistsJComboBox. Return -1 if not found.
     * @parem       name String
     * @return      index int
     * @author      <i>Niko Culevski</i>
     * Date         4/3/2020
     * History Log  7/18/2018     
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private int findIndex(String name)
    {
        int index = -1;
        for(int i = 0; i < artistsJComboBox.getItemCount(); i++)
        {
            if(name.equals(artistsJComboBox.getItemAt(i).toString()))
                return i;
        }
        return index;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
     * Method       main()
     * Description  Displays splash screen and the main RoadSign GUI form.
     * Date         5/7/2020     
     * History log 
     * @param       args are the command line strings
     * @author      <i>Niko Culevski</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[])
    {
        // Show splash screen
        Splash mySplash = new Splash(5000);     // duration = 4 seconds
        mySplash.showSplash();                  // show splash screen
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                FamousArtistsGUI flagQuiz = new FamousArtistsGUI();                
                flagQuiz.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.JLabel artistJLabel;
    private javax.swing.JComboBox artistsJComboBox;
    private javax.swing.JMenuBar artistsJMenuBar;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JMenu dataJMenu;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JButton nextJButton;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JButton playJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JLabel quizJLabel;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JLabel selectJLabel;
    private javax.swing.JPanel selectJPanel;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}