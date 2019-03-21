package testy;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gnu.jpdf.PDFPrinterJob;

public class PrintPanelToPDF implements Printable
{
    public static void main (String [] args)
    {
    	try
    	{
    	 // create a PDF Printer Job
    	 PDFPrinterJob printer = (PDFPrinterJob)PDFPrinterJob.getPrinterJob ();
    	 // set the printable object 
    	 printer.setPrintable (new PrintPanelToPDF());
    	 // set number of copies to 1 
    	 printer.setCopies (1);
    	 // print and save the document
    	 printer.print("C:\\test\\mydoc.pdf");
    	 // output done message 
    	 System.out.println("Done!");
    	}
    	catch (Throwable t)
    	{
    	 t.printStackTrace();
    	}
    }
    
 
    public int print (Graphics g, PageFormat pf, int pageIndex) 
    {
    	if (pageIndex == 0)
    	{
 
          // translate the graphics for margins
    	  g.translate(100, 100);
 
    	  // create a panel with a label and a textfield
    	  JPanel myPanel = new javax.swing.JPanel();
    	  myPanel.setName("myPanel");
    	  myPanel.setBorder(new javax.swing.border.EtchedBorder());
    	  myPanel.setBounds(new java.awt.Rectangle(0, 0, 300, 300));
    	  // create a label
    	  JLabel myLabel = new JLabel("MyLabel");
    	  myLabel.setText("Label");
    	  myLabel.setLocation(10, 10);
    	  myLabel.setSize(50, 20);
    	  myLabel.setVisible(true);
    	  // add label to panel
    	  myPanel.add(myLabel);
    	  // create a text field 
    	  JTextField myTextField = new JTextField();
    	  myTextField.setText("My Text");
    	  myTextField.setLocation(65, 10);
    	  myTextField.setSize(50, 20);
    	  myTextField.setVisible(true);
    	  // add text field to panel
    	  myPanel.add(myTextField);
    	 // you can add any swing component here
    	 // ..... 
    	 // revalidate and repaint the panel
    	 myPanel.revalidate();
         myPanel.repaint();
    	 // print the panel to the graphics on page 0
    	 myPanel.print (g);
    	 return Printable.PAGE_EXISTS;
    	}
    	else
    	{
    	 return Printable.NO_SUCH_PAGE;
    	}
    }
}