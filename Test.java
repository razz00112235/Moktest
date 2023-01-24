import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
class Test{
    static int j=0,i;  
  static int data=0;
  static int cnext=0;
    public static void main(String[] args) {
             
           
        JFrame frame=new JFrame("MCQ Test");
        frame.setSize(500,600);

        JButton btn_val=new JButton("0");
        btn_val.setBounds(300,300,150,50);
        btn_val.setVisible(false);
        JSONParser parser=new JSONParser();    
                     try {
                        ButtonGroup G = new ButtonGroup();
                            Object obj=parser.parse(new FileReader("test.json")); 
                            JSONArray arr=(JSONArray)obj; 
                            
                            btn_val.setText(String.valueOf(cnext));
                            String qt,obj1,obj2,obj3,obj4,ans;                           
                               
                               JSONObject objdata=(JSONObject)arr.get(0);                     
                                qt=(String)objdata.get("Question");
                                obj1=(String)objdata.get("A");
                                obj2=(String)objdata.get("B");
                                obj3=(String)objdata.get("C");
                                obj4=(String)objdata.get("D");
                                ans=(String)objdata.get("ANS"); 
                               
                
                                JLabel Question=new JLabel(qt);
                                Question.setBounds(10, 10, 400, 50);
                        
                                JRadioButton op1=new JRadioButton(obj1);
                                op1.setBounds(10, 60, 300, 50);
                                JRadioButton op2=new JRadioButton(obj2);
                                op2.setBounds(10, 110, 300, 50);
                                JRadioButton op3=new JRadioButton(obj3);
                                op3.setBounds(10, 160, 300, 50);
                                JRadioButton op4=new JRadioButton(obj4);
                                op4.setBounds(10, 210, 300, 50);
                                JLabel answr=new JLabel("Answer:"+ans);
                                answr.setBounds(10, 260, 300, 50);
                                JButton next=new JButton("Next");
                                next.setBounds(150,300,150,50);
                                G.add(op1);G.add(op2);G.add(op3);G.add(op4);
                                
                                frame.add(Question);frame.add(op1);frame.add(op2);
                                frame.add(op3);frame.add(op4);frame.add(answr);frame.add(next);
                                frame.add(btn_val);
                            
                                frame.setLayout(null);
                                frame.setVisible(true);

                                ActionListener click=new ActionListener(){
                                    public void actionPerformed(ActionEvent e)
                                    { 
                                        JSONParser parser=new JSONParser();    
                                         try {
                                                Object obj=parser.parse(new FileReader("test.json")); 
                                                JSONArray arr=(JSONArray)obj; 
                                                
                                                cnext++;
                                                btn_val.setText(String.valueOf(cnext));
                                                String qt,obj1,obj2,obj3,obj4,ans;                           
                                                   int data=Integer.parseInt(btn_val.getText());
                                                   JSONObject objdata=(JSONObject)arr.get(data);                     
                                                    qt=(String)objdata.get("Question");
                                                    obj1=(String)objdata.get("A");
                                                    obj2=(String)objdata.get("B");
                                                    obj3=(String)objdata.get("C");
                                                    obj4=(String)objdata.get("D");
                                                    ans=(String)objdata.get("ANS"); 
                                                    Question.setText(qt); 
                                                    op1.setText(obj1);  
                                                    op2.setText(obj2); 
                                                    op3.setText(obj3); 
                                                    op4.setText(obj4);         
                                                    answr.setText("Answer:"+ans);
                                    
                                    
                                } catch (Exception ee) {
                                   System.out.println(ee);
                                }      
                                
                                        
                                    }
                                };
                                next.addActionListener(click);
                
            } catch (Exception ee) {
               System.out.println(ee);
            }      
       
                   
       


           
        
        
    
    }
}