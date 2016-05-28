package Bookstore;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Iterator;

/**
 * Created by 777 on 30.04.2016.
 */
public class ShopUI {

    private Shop shop;

    public ShopUI(Shop shop) {
        this.shop = shop;

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocation(100, 100);
        JPanel p = new JPanel();
        p.setLayout(null);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.setSize(new Dimension(400,140));
        panel.setLocation(0, 0);
        panel.setBorder(new BorderUIResource.LineBorderUIResource(Color.BLACK));
        panel1.setSize(new Dimension(800,160));
        panel1.setLocation(0, 440);
        panel1.setBorder(new BorderUIResource.LineBorderUIResource(Color.BLACK));

        p.add(panel);
        panel.setLayout(new GridBagLayout());

        JTable jt = new JTable(shop.returnTable(), shop.columnNames);
//        JScrollPane scrollPane = new JScrollPane(jt);
//        jt.setFillsViewportHeight(true);
        panel1.setLayout(new BorderLayout());
        panel1.add(jt.getTableHeader(), BorderLayout.PAGE_START);
        panel1.add(jt, BorderLayout.CENTER);
        p.add(panel1);
        JLabel label1 = new JLabel("Client name: ");
        JComboBox<Client> tf1 = new JComboBox<Client>();
        Client client;
        Iterator<Client> i = shop.getClients().iterator();
        while (i.hasNext()) {
            tf1.addItem(i.next());
        }

        JLabel label2 = new JLabel("Book name: ");
        JComboBox<Book> cb1 = new JComboBox<Book>();
        Book b;
        Iterator<Book> itr = shop.getBooks().iterator();
        while (itr.hasNext()) {
            cb1.addItem(itr.next());
        }


        JLabel label3 = new JLabel("Quontity: ");
        JButton b4 = new JButton("Add to basket");

        JComboBox<Integer> cb2 = new JComboBox<Integer>();
        Iterator<Book> itr1 = shop.getBooks().iterator();
        Book b1 = (Book) cb1.getSelectedItem();
        while (itr1.hasNext()) {
            Book b2 = itr1.next();
            if (b2.equals(cb1.getSelectedItem())) {
                b1 = b2;
                break;
            }
        }
        int j;
        for (j = 1; j <= (b1.getQuontity()); j++) {
            cb2.addItem(j);
        }


        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cb2.removeAllItems();
                Book b1 = (Book) cb1.getSelectedItem();
                while (itr1.hasNext()) {
                    Book b2 = itr1.next();
                    if (b2.equals(cb1.getSelectedItem())) {
                        b1 = b2;
                        break;
                    }
                }
                int j;
                for (j = 1; j <= (b1.getQuontity()); j++) {
                    cb2.addItem(j);
                }
                cb2.revalidate();
                panel.removeAll();
                panel.add(label1, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 10, 0, 10), 0, 0));
                panel.add(tf1, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                panel.add(label2, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 10, 0, 10), 0, 0));
                panel.add(cb1, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 25, 0));
                panel.add(label3, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 10, 0, 10), 0, 0));
                panel.add(cb2, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 199, 0));
                panel.add(b4, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 122, 0));
                panel.revalidate();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book b = (Book) cb1.getSelectedItem();
                b.setQuontity((int)cb2.getSelectedItem());
                Purchase p = new Purchase(b, (Client)tf1.getSelectedItem());
                shop.getBasket().add(p);

            }
        });

        panel.add(label1, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 10, 0, 10), 0, 0));
        panel.add(tf1, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(label2, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 10, 0, 10), 0, 0));
        panel.add(cb1, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 25, 0));
        panel.add(label3, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 10, 0, 10), 0, 0));
        panel.add(cb2, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 199, 0));
        panel.add(b4, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 122, 0));


        frame.getContentPane().add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}