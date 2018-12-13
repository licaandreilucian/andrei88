import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestGUI 
{ 
	AF af;
	Actiuni act;
	IUG iug;
  
  TestGUI()
  {   
    af = new AF();
    act = new Actiuni();
    iug = new IUG("Campuri de text");
  }
 
 
  /* clasa imbricata pentru interfata utilizator grafica */
  class IUG extends JFrame 
  {
    JButton button1;
    JLabel label1;

    IUG(String titlu) // constructorul clasei IUG
    {
      super(titlu);
      setSize(450, 150);
      setLocation(200, 50);
      Container cp = getContentPane();
      addWindowListener(af);  // adaugarea ascultatorului de fereastra

      /* Adaugarea in fereastra a butonului si a etichetei*/
      button1 = new JButton("Click me!");
      button1.addActionListener(act);
      cp.add(button1,BorderLayout.NORTH);

      label1 = new JLabel("Stare");
      cp.add(label1,BorderLayout.SOUTH);

      setVisible(true);
    }
  } 

  /* Clasa ascultatoare de fereastra */ 
  class AF extends WindowAdapter 
  {
    public void windowClosing(WindowEvent e) 
    {
      System.exit(0); // incheierea executarii aplicatiei
    }
  }

  /* Clasa ascultatoare a actiunilor asupra componentelor grafice din interfata */
  class Actiuni implements ActionListener 
  {
    public void actionPerformed(ActionEvent e) 
    {
      JButton sursa = (JButton)e.getSource();
      String text = e.getActionCommand();
      if(sursa == iug.button1) 
        iug.label1.setText("Event: " + text);
    }
  }

  /* Metoda principala a aplicatiei */
  public static void main(String args[]) 
  {
    TestGUI testg = new TestGUI();
  }
}