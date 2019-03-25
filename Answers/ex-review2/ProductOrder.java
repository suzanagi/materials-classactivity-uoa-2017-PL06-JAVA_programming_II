import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.event.*;


class SortableDataStore  implements Comparable<SortableDataStore> { 
	protected String productItem, noItem, orderInfo;
	public SortableDataStore() {
		this.productItem = "null";
		this.noItem = "";
		this.orderInfo = "";
	}		
	public SortableDataStore(String p, String n, String o) {
		this.productItem = p;
		this.noItem = n;
		this.orderInfo = o;
	}	
	public String toString() {
		if(this.productItem == null) this.productItem = "null";
		if(this.noItem == null) this.noItem = "";
		if(this.orderInfo == null) this.orderInfo = "";
		return new String(productItem + ", " + noItem + ", " + orderInfo) ;
	}
	@Override
	public int compareTo(SortableDataStore datastore) {
		int result = this.productItem.compareTo(datastore.productItem);
		switch(result) {
		case 0:
			result = this.noItem.compareTo(datastore.noItem);
		}
		return result;
	}
} // end of DataStore

public class ProductOrder extends JFrame {
    protected String list_Contents, noOrder, orderInfo;
    protected SortableDataStore[] v = new SortableDataStore[20];

    protected JPanel topp, leftp, rightp,bottomp,centerup, centerdown;
    protected JButton putb, showb, sortb, clearb;
    protected JLabel title, noorder, orderinfo;
    protected JList<String> plist;
    protected JTextField nofield, infofield;
    protected JTextArea contentsarea;
    protected String[] data = {"IBM NoteBook", "Dell Product", "MS Windows", "Sun Workstation", "Oracle DB", "MySQL"};
    protected int idx = 0;
    protected int lastIndex = -1;

    public ProductOrder() {
	    getContentPane().setLayout(new BorderLayout());
	    topp = new JPanel();
	    leftp = new JPanel();
	    rightp = new JPanel();
	    bottomp = new JPanel();
	    centerup = new JPanel();
	    centerdown = new JPanel();
	
	    getContentPane().add(topp, "North");
	    getContentPane().add(leftp, "West");
	    getContentPane().add(rightp, "Center");
	    getContentPane().add(bottomp, "South");
	
	    title = new JLabel("Product Order");
	    title.setFont(new Font("Product Order",Font.BOLD, 20));
	    topp.add(title);
	
	    plist = new JList<String>(data);
	    plist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    plist.addListSelectionListener(new ProductItemListener());
	    leftp.add(plist);
	
	    noorder = new JLabel("No. of Order Items");
	    orderinfo = new JLabel("Order Information");
	    nofield = new JTextField();
	    infofield = new JTextField();
	    
	    putb = new JButton("Put into Cart");
	    putb.addActionListener(new PutButtonListener());
	    sortb = new JButton("Sort Items");
	    sortb.addActionListener(new SortButtonListener());
	    clearb = new JButton("Reset Cart");
	    clearb.addActionListener(new ResetButtonListener());
	    
	    centerup.setLayout(new GridLayout(2,2));
	    centerup.add(noorder);
	    centerup.add(orderinfo);
	    centerup.add(nofield);
	    centerup.add(infofield);
	    centerdown.setLayout(new GridLayout(1,2));
	    centerdown.add(putb);
	    centerdown.add(sortb);
	    centerdown.add(clearb);
	    
	    rightp.setLayout(new GridLayout(2,1));
	    rightp.add(centerup);
	    rightp.add(centerdown);
	    
	    showb = new JButton("Show Cart");
	    showb.addActionListener(new ShowButtonListener());
	    
	    
	    contentsarea = new JTextArea(10,1);
	    bottomp.setLayout(new GridLayout(1,2));
	    bottomp.add(showb);
	    bottomp.add(contentsarea);
	    
    }  // Product Order constructor
    
    /* Method for checking the content of array v 
       protected void showContentToStdInput() {
       System.out.println("----------");
       for(int i = 0; i < idx; i++) System.out.println(v[i]);
    }
    */
    
    /* Method for updating the content of text area */
    public void updateContent() {
    		String textForDisplay = "";
		for(int i = 0; i < idx; i++) textForDisplay += v[i].toString() + "\n";
		contentsarea.setText(textForDisplay);
    }

/*****
Fill in code for event listeners.
You can use inner classes for the listeners.
*****/
    class ProductItemListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String selected = (String) plist.getSelectedValue();
			list_Contents = selected;
		}
    }
    
    class PutButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			noOrder = nofield.getText();
			orderInfo = infofield.getText();
			if(lastIndex < 20) v[++lastIndex] = new SortableDataStore(list_Contents, noOrder, orderInfo);
			idx++;
		}
    }
       
    class SortButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			SortableDataStore[] arrayForSort = new SortableDataStore[idx];
			for(int i = 0; i < idx; i++) arrayForSort[i] = v[i];
			Arrays.sort(arrayForSort);
			for(int i = 0; i < idx; i++) v[i] = arrayForSort[i];
			updateContent();
		}
    }
    
    class ResetButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v = new SortableDataStore[20];
			lastIndex = -1;
			idx = 0;
			updateContent();
		}
    }
    
    class ShowButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			updateContent();
		}
    }
    

    public static void main (String args[]) {
        ProductOrder f = new ProductOrder();
        f.setTitle("Product Order");
        f.setSize(500,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
} // end of ProductOrder
     
