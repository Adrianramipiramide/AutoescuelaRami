package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BDConection {

    public static void conectarConBDAddUsuario(int ido, String nombreo, String apellidoo, String telefonoo) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://database-1.cpwoqsmqg94x.us-east-1.rds.amazonaws.com/Autoescuela", "admin", "ARfed099");


            String consulta = "insert into Persona (id,nombre,apellido,telefono) values (?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ps.setInt(1, ido);
            ps.setString(2, nombreo);
            ps.setString(3, apellidoo);
            ps.setString(4, telefonoo);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void BDmostrarUsuarios() {

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://database-1.cpwoqsmqg94x.us-east-1.rds.amazonaws.com/Autoescuela", "admin", "ARfed099");
            String consulta = "select * from Persona";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);


            String nombre = "";
            String apellido = "";
            String telefono = "";

            StringBuilder texto = new StringBuilder();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                nombre = resultSet.getString("nombre");
                apellido = resultSet.getString("apellido");
                telefono = resultSet.getString("telefono");
                System.out.println("Nombre: " + nombre + " Apellido: " + apellido + " Telefono: " + telefono);


                texto.append("ID: ").append(id)
                        .append(" | Nombre: ").append(nombre)
                        .append(" | Apellido: ").append(apellido)
                        .append(" | Teléfono: ").append(telefono)
                        .append("\n");

            }

            JFrame frame = new JFrame("Test");
            frame.setSize(800, 500);
            frame.setLayout(new GridLayout(5, 1, 5, 5));
//Hay que hacer que sea una lista para quie saque todoo

            JLabel nombreE = new JLabel(nombre);
            JLabel apellidoE = new JLabel(apellido);
            JLabel telefonoE = new JLabel(telefono);
            JButton volver = new JButton("Volver");

            JTextArea areaTexto = new JTextArea(texto.toString());
            areaTexto.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(areaTexto);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(volver, BorderLayout.SOUTH);
            frame.add(volver);
            frame.setVisible(true);


            volver.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    GUII.menuEntrada();
                }
            });


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void BDHacerTest() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://database-1.cpwoqsmqg94x.us-east-1.rds.amazonaws.com/Autoescuela", "admin", "ARfed099");

            int numPregunta = (int) (Math.random() * 9);
            String consulta = "select * from Preguntas where id = " + numPregunta;
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);


            String enunciado = "";
            String respuesta1 = "";
            String respuesta2 = "";
            String respuesta3 = "";
            int correcta = 0;

            while (resultSet.next()) {
                enunciado = resultSet.getString("enunciado");
                respuesta1 = resultSet.getString("respuesta1");
                respuesta2 = resultSet.getString("respuesta2");
                respuesta3 = resultSet.getString("respuesta3");
                correcta = resultSet.getInt("correcta");


                System.out.println(enunciado);

            }

            JFrame frame = new JFrame("Test");
            frame.setSize(800, 500);
            frame.setLayout(new GridLayout(5, 1, 5, 5));


            JButton volver = new JButton("Volver");
            JLabel pregunta = new JLabel(enunciado);
            JButton opcion1 = new JButton(respuesta1);
            JButton opcion2 = new JButton(respuesta2);
            JButton opcion3 = new JButton(respuesta3);


            frame.add(pregunta);
            frame.add(opcion1);
            frame.add(opcion2);
            frame.add(opcion3);
            frame.add(volver);


            frame.setVisible(true);

            int finalCorrecta = correcta;
            opcion1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PreguntaTest.esCorrecta(1, finalCorrecta);
                    frame.setVisible(false);
                    GUII.generarTest();
                }
            });

            opcion2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PreguntaTest.esCorrecta(2, finalCorrecta);
                    frame.setVisible(false);
                    GUII.generarTest();
                }
            });

            opcion3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PreguntaTest.esCorrecta(3, finalCorrecta);
                    frame.setVisible(false);
                    GUII.generarTest();
                }
            });

            volver.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    GUII.menuEntrada();
                }
            });


        } catch (SQLException o) {
            o.printStackTrace();
        }


    }
}
