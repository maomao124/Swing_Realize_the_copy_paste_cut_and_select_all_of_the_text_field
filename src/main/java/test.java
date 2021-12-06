import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：Swing实现文本域的复制粘贴剪切和全选
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/6
 * Time(创建时间)： 13:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */


class MyFrame extends JFrame implements ActionListener
{
    JScrollPane scrollPane; // 滚动面板，用于放置文本区域
    JTextArea jTextArea;           // 文本区域

    JPanel optionsPanel;    // 选项面板，用于放置按钮
    JButton ctrlA, ctrlX, ctrlC, ctrlV; // 全选，剪切，复制，粘贴。

    MyFrame()
    {
        // 设置文本区域及面板
        jTextArea = new JTextArea();
        jTextArea.setCaretPosition(0);
        jTextArea.setCaretColor(Color.RED);
        jTextArea.setBackground(new Color(0xEEEEEE));
        jTextArea.setFont(new Font("Dialog", Font.PLAIN, 16));
        jTextArea.setSelectionColor(Color.MAGENTA);
        jTextArea.setSelectedTextColor(Color.CYAN);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(jTextArea);

        // 设置功能按钮及面板
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1, 0, 70));
        ctrlA = new JButton("全选");
        ctrlX = new JButton("剪切");
        ctrlC = new JButton("复制");
        ctrlV = new JButton("粘贴");
        optionsPanel.add(ctrlA);
        optionsPanel.add(ctrlX);
        optionsPanel.add(ctrlC);
        optionsPanel.add(ctrlV);

        // 向窗口添加组件
        this.setLayout(new BorderLayout());     // 设置组件布局
        add(scrollPane, BorderLayout.CENTER);   // 文本区域的可滚动面板
        add(optionsPanel, BorderLayout.EAST);   // 功能按钮

        // 向按钮添加事件监听器
        ctrlA.addActionListener(this);
        ctrlX.addActionListener(this);
        ctrlC.addActionListener(this);
        ctrlV.addActionListener(this);

        // 设置窗口参数
        this.setTitle("文本编辑器");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        // TextArea对象的方法中有全选，剪切，复制，粘贴等操作。
        if (source == ctrlA)
        {
            jTextArea.selectAll();
            System.out.println(jTextArea.getSelectionStart() + "  " + jTextArea.getSelectionEnd());
        }
        else if (source == ctrlX)
        {
            jTextArea.cut();
        }
        else if (source == ctrlC)
        {
            jTextArea.copy();
        }
        else if (source == ctrlV)
        {
            jTextArea.paste();
        }
    }
}

public class test
{
    public static void main(String[] args)
    {
        new MyFrame();
    }
}
