package gui;
import database.Database;
import model.*;
import Service.TaskManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Gui {

    public static void main(String[] args) {
        String[] columns={"id","Title", "Type", "Priority", "Deadline", "Completed"};

        DefaultTableModel model=new DefaultTableModel(columns,0);
        //inserting rows to the table
        Database.initialize();
        TaskManager manager = new TaskManager();
        for(Task t : manager.getAllTasks()){
            Object[] row = { t.getId(), t.getTitle(), t.getType(),
                    t.getPriority(), t.getDeadline(), t.getStatus() };
            model.addRow(row);
        }

        JTable table=new JTable(model);

        JLabel points=new JLabel("Points:"+manager.getTotalPoints());

        JButton completebutton=new JButton("complete");
        completebutton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row==-1){
                System.err.println("Please select a row!");
                return;
            }
            int id=(Integer)model.getValueAt(row,0);
            manager.completeTask(id);
            model.setRowCount(0);
            for(Task t : manager.getAllTasks()){
                Object[] newRow = { t.getId(), t.getTitle(), t.getType(),
                        t.getPriority(), t.getDeadline(), t.getStatus() };
                model.addRow(newRow);
            }
            points.setText("Points: " + manager.getTotalPoints());

            System.out.println("Selected id: " + id);
        });

        JButton deleteButton = new JButton("delete");
        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row==-1){
                System.err.println("Please select a row!");
                return;
            }
            int id=(Integer)model.getValueAt(row,0);
            manager.removeTask(id);
            model.setRowCount(0);
            for(Task t : manager.getAllTasks()){
                Object[] newRow = { t.getId(), t.getTitle(), t.getType(),
                        t.getPriority(), t.getDeadline(), t.getStatus() };
                model.addRow(newRow);
            }
        });
        //adding task
        JTextField titlefield=new JTextField(15);
        String[] types = {"Academic", "Fitness", "Personal", "Project"};
        JComboBox<String> typeBox = new JComboBox<>(types);
        String[] priorities = {"High", "Medium", "Low"};
        JComboBox<String> prioritiesBox = new JComboBox<>(priorities);
        JTextField deadlineField = new JTextField("2026-12-31", 8);
        JButton addButton = new JButton("addtask");

        addButton.addActionListener(e -> {
            String title=titlefield.getText();
            String  type=typeBox.getSelectedItem().toString();
            String  priority=prioritiesBox.getSelectedItem().toString();
            String  deadline=deadlineField.getText();
            Task task;


            if(type.equals("Academic")) {
                task = new AcademicTask(title, priority, deadline);
            } else if (type.equals("Fitness")) {
                task = new FitnessTask(title, priority, deadline);
            } else if (type.equals("Personal")) {
                task = new PersonalTask(title, priority, deadline);
            } else {
                task = new ProjectTask(title, priority, deadline);
            }
            manager.addTask(task);

            model.setRowCount(0);
            for(Task t : manager.getAllTasks()){
                Object[] newRow = { t.getId(), t.getTitle(), t.getType(),
                        t.getPriority(), t.getDeadline(), t.getStatus() };
                model.addRow(newRow);
            }
        });



        JPanel npanel=new JPanel();
        npanel.add(titlefield);
        npanel.add(addButton);
        npanel.add(typeBox);
        npanel.add(prioritiesBox);
        npanel.add(deadlineField);
        npanel.add(addButton);



        //grouping compbutton and delt button
        JPanel spanel=new JPanel();
        spanel.add(completebutton);
        spanel.add(deleteButton);
        spanel.add(points);

        JFrame frame = new JFrame("Task Manager");
        frame.setSize(500, 400);
        frame.add(new JScrollPane(table),BorderLayout.CENTER);
        frame.add(spanel,BorderLayout.SOUTH);
        frame.add(npanel,BorderLayout.NORTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}



