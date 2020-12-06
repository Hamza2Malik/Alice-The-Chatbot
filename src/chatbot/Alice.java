package chatbot;


import java.io.*;

import com.sun.speech.freetts.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alice extends javax.swing.JFrame {

    
    public Alice() {
        initComponents();
    }
 
    @SuppressWarnings("unchecked")

/**
 *
 * @author hamza malik
 */
   
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alice-The Chatbot");
        

        jTextField1.setBackground(new java.awt.Color(204, 204, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/chatbot.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
       
        String uText = jTextField1.getText();
       
        jTextArea1.append("You: "+uText + "\n");
        if(uText.toLowerCase().contains("hi")){
            botsay("Hello There");
        }
        else if (uText.toLowerCase().contains("how are you")){
                        int decider1 = (int) (Math.random() * 3 + 1);
            switch (decider1) {
                case 1:
                    botsay("I am doing fine.");
                    break;
                case 2:
                    botsay("Fine. How are you?");
                    break;
                case 3:
                    botsay("I am feeling great today.");
                    break;
                default:
                    break;
            }
        }
        else if (uText.toLowerCase().contains("i am fine")){
            botsay("Nice to hear");}
        else if (uText.toLowerCase().contains("who are you")){
            botsay("I am Alice the Chatbot");}
        else if (uText.toLowerCase().contains("who created you")){
            botsay("Hamza Created me ");}
        
       else if (uText.toLowerCase().contains("Tell me a joke")){
                botsay("Knock kock !");    
        }
        else if(uText.toLowerCase().contains("open chrome")){
            botsay("Opening Chrome");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Messi\\eclipse-workspace\\Chatbott\\src\\chatbot\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
        }
        else if (uText.toLowerCase().contains("show weather")){
        	 botsay("Opening weather");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Messi\\eclipse-workspace\\Chatbott\\src\\chatbot\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.accuweather.com/en/pk/islamabad/258278/weather-forecast/258278");
        }
        else if (uText.toLowerCase().contains("open facebook")){
            botsay("Opening Facebook");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Messi\\eclipse-workspace\\Chatbott\\src\\chatbot\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.facebook.com");
       
        }
        else{
            int decider2 = (int) (Math.random() * 3 + 1);
            switch (decider2) {
                case 1:
                    botsay("I did'nt get that");
                    break;
                case 2:
                    botsay("Please Rephrase that...");
                    break;
                case 3:
                    botsay("????");
                    break;
                default:
                    break;
            }
        }
        
        jTextField1.setText("");
    }

  
    public void botsay(String s){
         jTextArea1.append("Alice: " + s+ "\n");
        final String voicename = "kevin16";
         Voice voice;
         VoiceManager vm=VoiceManager.getInstance();
         voice = vm.getVoice(voicename);
         voice.allocate();
         try {
             voice.speak(s);
         }
         catch (Exception e){
             
         } 
    }
    
    public static void main(String args[]) {
      
    	  try {
              for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                  if ("Nimbus".equals(info.getName())) {
                      javax.swing.UIManager.setLookAndFeel(info.getClassName());
                      break;
                  }
              }
          } catch (ClassNotFoundException ex) {
              java.util.logging.Logger.getLogger(Alice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              java.util.logging.Logger.getLogger(Alice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              java.util.logging.Logger.getLogger(Alice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
              java.util.logging.Logger.getLogger(Alice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alice().setVisible(true);
            }
        });
    }

  
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;

}
