import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.*;  
import javax.swing.*;
import java.util.regex.*;
import java.util.Vector;
//import org.json.JSONArray;
class Db{
    Connection con;
    Db(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
            }catch(Exception e){ System.out.println(e);}        
    }
    public Connection fetchConnection(){
        return con;
    }
}
class EmployeeDisplay {  
    private javax.swing.JTable jTable1;  
    JFrame f;    
    static Connection con;
    JComboBox c1;
    EmployeeDisplay(){    
    f=new JFrame();
    Db db = new Db();
    con = db.fetchConnection(); 
    try{
        PreparedStatement statement =con.prepareStatement("SELECT * FROM `employee`");
        ResultSet rt  = statement.executeQuery();
         String [][] details={};
         String ids;
        int i=0,j=0;
        // Vector v = new Vector();
        //     while (rt.next()) {
        //         ids = rt.getString(2);
        //         v.add(ids);
        //     }
        //     c1 = new JComboBox(v);
        //     c1.setBounds(150, 110, 150, 20);

        //     add(c1);
        while(rt.next()){
            details[i][j]=rt.getString(6);
            details[i][++j]=rt.getString(2);
            details[i][++j]=rt.getString(4);
            details[i][++j]=rt.getString(5);
            details[i][++j]=rt.getString(3);
            i++;
        }
    } 
    catch(Exception er){}     
}     
}
class DataEntry extends JFrame {
    static Connection con;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;  
        JTextField tf1, tf2, tf5, tf6, tf7;  
        JButton btn1, btn2,btn3;  
        JPasswordField p1, p2;
    DataEntry() { 
            setVisible(true);  
            setSize(700, 700);  
            setLayout(null);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setTitle("Employee Registration Form");  
            l1 = new JLabel("Employee Registration Form");  
            l1.setForeground(Color.blue);  
            l1.setFont(new Font("Serif", Font.BOLD, 20));  
            l2 = new JLabel("Name:");  
            l3 = new JLabel("Email-ID:");  
            l4 = new JLabel("Employee ID:");  
            l5 = new JLabel("Salary:");  
            l6 = new JLabel("Address");   
            tf1 = new JTextField();  
            tf2 = new JTextField(); 
            tf5 = new JTextField();  
            tf6 = new JTextField();  
            tf7 = new JTextField();  
            btn1 = new JButton("Submit");  
            btn2 = new JButton("Clear");
            btn3 = new JButton("Display");
            l1.setBounds(100, 30, 400, 30);  
            l2.setBounds(80, 70, 200, 30);  
            l3.setBounds(80, 110, 200, 30);  
            l4.setBounds(80, 150, 200, 30);  
            l5.setBounds(80, 190, 200, 30);  
            l6.setBounds(80, 230, 200, 30);   
            tf1.setBounds(300, 70, 200, 30);  
            tf2.setBounds(300, 110, 200, 30);   
            tf5.setBounds(300, 150, 200, 30);  
            tf6.setBounds(300, 190, 200, 30);  
            tf7.setBounds(300, 230, 200, 30);  
            btn1.setBounds(50, 350, 100, 30);  
            btn2.setBounds(170, 350, 100, 30);
            btn3.setBounds(290, 350, 100, 30);  
            add(l1);  
            add(l2);  
            add(tf1);  
            add(l3);  
            add(tf2);  
            add(l4);    
            add(l5);   
            add(l6);  
            add(tf5);   
            add(tf6);  
            add(tf7);  
            add(btn1);  
            add(btn2);
            add(btn3);
            btn2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                             tf1.setText("");
                            tf2.setText("");
                            tf5.setText("");
                            tf6.setText("");
                            tf7.setText("");
                }
                });
                btn3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){  
                        dispose();
                        new EmployeeDisplay();
                    }
                    });
            btn1.addActionListener(new ActionListener(){  
                String name,mail,empid,salary,address;
                boolean m;
                public void actionPerformed(ActionEvent e){  
                    name= tf1.getText();
                    mail= tf2.getText();
                    empid= tf5.getText();
                    salary= tf6.getText();
                    address= tf7.getText();
                    if(name.length()==0 || mail.length()==0 || empid.length()==0 || address.length()==0 || salary.length()==0){
                        infoBox("Please fill all Mandatory Fields!","Error!");  
                    } 
                    else{
                        Db db = new Db();
                        con = db.fetchConnection();
                        try{
                            Integer s=Integer.valueOf(salary);
                        }
                        catch(Exception asas){
                            infoBox("Salary should be in Number Format!","Error!");
                        }
                        m = validate(mail);
                        if(m==false){
                            infoBox("Email Id Format not Correct!","Error!");
                        }
                        else{
                        try{
                            PreparedStatement statement =con.prepareStatement("INSERT INTO `employee` SET Name = ? ,Address = ?, Email=?,Salary=?, emp_id=?");
                            statement.setString(1, name);
                            statement.setString(2, address);
                            statement.setString(3, mail);
                            statement.setInt(4, Integer.valueOf(salary));
                            statement.setString(5, empid);
                            int i = statement.executeUpdate();
                            if(i==1){
                                infoBox("Employee Records Inserted!","Success!");
                                tf1.setText("");
                                tf2.setText("");
                                tf5.setText("");
                                tf6.setText("");
                                tf7.setText("");
                            }
                            }
                            catch(Exception f){System.out.println(f);}
                        }
                        
                    }
                }
                });
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
  }
class AdminLoginPage extends Frame
{
    TextField name,pass;
    Button b1,b2;
    String uname,pwd;
    static Connection con;
    AdminLoginPage()
    {
        setLayout(new FlowLayout());
        this.setLayout(null);
        Label n=new Label("User Name:",Label.CENTER);
        Label p=new Label("password:",Label.CENTER);
        name=new TextField(20);
        pass=new TextField(20);
        pass.setEchoChar('*');
        b1=new Button("submit");
        this.add(n);
        this.add(name);
        this.add(p);
        this.add(pass);
        this.add(b1);
        //this.add(b2);
        n.setBounds(70,90,90,60);
        p.setBounds(70,130,90,60);
        name.setBounds(200,100,90,20);
        pass.setBounds(200,140,90,20);
        b1.setBounds(100,260,70,40);
        b1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                uname= name.getText();
                pwd=pass.getText();
                if(uname.length()==0 || pwd.length()==0){
                    infoBox("Please fill all Mandatory Fields!","Error!");  
                } 
                else{
                    boolean res=check(uname,pwd);
                    if(res==false){
                        infoBox("UserName or Password not Correct!","Error!");
                    }
                    else{
                        infoBox("Login Successfully!","Success!");
                        dispose();
                        new DataEntry();
                    }
                }
            }
            });  
    }
    public static boolean check(String uname, String pwd){
        String user="";
        try{  
            PreparedStatement statement =con.prepareStatement("SELECT * from admin WHERE  uname = ? and Password = ?");
            statement.setString(1, uname);
            statement.setString(2, pwd);
            ResultSet rs=statement.executeQuery();
            if (!rs.next()) {
                return false;
            }
            else{
                return true;
            }
            }
            catch(Exception e){ System.out.println(e);}
            return false;
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String args[])
    {
        Db db = new Db();
        con = db.fetchConnection();
        AdminLoginPage ml=new AdminLoginPage();
        ml.setVisible(true);
        ml.setSize(400,400);
        ml.setTitle("Admin Login Window");
    }
}