//package com.employee.management;
import java.awt.*;
import java.awt.event.*;
class MenuBarExample
{
     MenuBarExample(){
         Frame f= new Frame("Menu and MenuItem Example");
         MenuBar mb=new MenuBar();
         Menu menu=new Menu("Menu");
         Menu submenu=new Menu("Sub Menu");
         MenuItem i1=new MenuItem("Item 1");
         MenuItem i2=new MenuItem("Item 2");
         MenuItem i3=new MenuItem("Item 3");
         MenuItem i4=new MenuItem("Item 4");
         MenuItem i5=new MenuItem("Item 5");
         menu.add(i1);
         menu.add(i2);
         menu.add(i3);
         submenu.add(i4);
         submenu.add(i5);
         menu.add(submenu);
         mb.add(menu);
         f.setMenuBar(mb);
         f.setSize(400,400);
         f.setLayout(null);
         f.setVisible(true);
         i1.addActionListener(new java.awt.event.ActionListener()
             {
                 public void actionPerformed(ActionEvent ae)
                 {
                     System.out.println("i1");
                 }
             });
             i2.addActionListener(new java.awt.event.ActionListener()
                 {
                     public void actionPerformed(ActionEvent ae)
                     {
                         System.out.println("i2");
                     }
                 });
}
public static void main(String args[])
{
new MenuBarExample();
}
}
