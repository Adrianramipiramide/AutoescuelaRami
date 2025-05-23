package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class GUII {

    public static void menuEntrada() {

        JFrame frame = new JFrame("Autoescuela Rami");
        frame.setSize(800, 500);
        frame.setLayout(new GridLayout(4, 3, 5, 5));


        frame.getContentPane().setBackground(new Color(230, 240, 255)); // fondo azul claro

        JLabel etiqueta = new JLabel("Bienvenido a la autoescuela", JLabel.CENTER);
        etiqueta.setFont(new Font("SansSerif", Font.BOLD, 18));
        etiqueta.setForeground(new Color(25, 25, 112)); // azul oscuro


        JButton botonHacerTest = new JButton("Hacer Test");
        JButton botonPresentarseExamenTeorico = new JButton("Presentarse a examen");
        JButton botonInicioSesion = new JButton("Iniciar Sesion");
        JButton botonReservarClasePractica = new JButton("Reservar clase práctica");
        JButton botonMostrarClasesReservadas = new JButton("Mostrar clases pendientes");
        JButton botonMostrarClasesRealizadas = new JButton("Mostrar clases realizadas");
        JButton botonCrearUsuario = new JButton("Crear Usuario");
        JButton botonMostrarUsuarios = new JButton("Mostrar Usuarios");
        JButton botonEliminarUsuario = new JButton("Eliminar Usuario");


        Font fuenteBoton = new Font("SansSerif", Font.PLAIN, 14);
        Color fondoBoton = new Color(70, 130, 180); // azul acero
        Color textoBoton = Color.WHITE;

        JButton[] botones = {
                botonHacerTest, botonPresentarseExamenTeorico, botonInicioSesion,
                botonReservarClasePractica, botonMostrarClasesReservadas, botonMostrarClasesRealizadas,
                botonCrearUsuario, botonMostrarUsuarios, botonEliminarUsuario
        };

        for (JButton boton : botones) {
            boton.setFont(fuenteBoton);
            boton.setBackground(fondoBoton);
            boton.setForeground(textoBoton);
            boton.setFocusPainted(false);
            boton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        }


        frame.add(new JLabel(""));
        frame.add(etiqueta);
        frame.add(new JLabel(""));
        frame.add(botonCrearUsuario);
        frame.add(botonHacerTest);
        frame.add(botonPresentarseExamenTeorico);
        frame.add(botonInicioSesion);
        frame.add(botonReservarClasePractica);
        frame.add(botonMostrarClasesReservadas);
        frame.add(botonMostrarClasesRealizadas);
        frame.add(botonMostrarUsuarios);
        frame.add(botonEliminarUsuario);
        frame.setVisible(true);


        botonCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonCrearUsuario.isEnabled()) {
                    frame.setVisible(false);
                }
                GUII.crearUsuarioMenu();
            }
        });

        botonMostrarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarUsuarios();
                frame.setVisible(false);
            }
        });

        botonPresentarseExamenTeorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dia = (int) (Math.random() * 30);
                int mes = (int) (Math.random() * 12);

                int year = (int) (Math.random() * 2050);
                while (year < 2024) {
                    year = (int) (Math.random() * 2050);
                }

                System.out.println("Tu examen es el dia " + dia + " del mes " + mes + " del año " + year);
            }
        });

        botonHacerTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonHacerTest.isEnabled()) {
                    frame.setVisible(false);
                }

                BDConection.BDHacerTest();
            }
        });

        botonEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonEliminarUsuario.isEnabled()) {
                    frame.setVisible(false);
                }
                GUII.eliminarUsuario();
            }
        });

        botonInicioSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonInicioSesion.isEnabled()) {
                    frame.setVisible(false);
                }
                GUII.iniciarSesion();
            }
        });

        botonReservarClasePractica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

                GUII.reservarClase();

            }
        });
    }

    public static void iniciarSesion() {
        JFrame frame = new JFrame("Iniciar sesion");
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(3, 2, 5, 5));
        frame.setVisible(true);

        JLabel nombre = new JLabel("Nombre");
        JTextField nombreT = new JTextField();
        JLabel id = new JLabel("Password/Id");
        JTextField idT = new JTextField();
        JButton enviar  = new JButton("Enviar");
        JButton volver = new JButton("Volver");

        frame.add(nombre);
        frame.add(nombreT);
        frame.add(id);
        frame.add(idT);
        frame.add(volver);
        frame.add(enviar);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUII.menuEntrada();
            }
        });

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idTe = Integer.parseInt(idT.getText());
                String nombreTe = nombreT.getText();

                if(BDConection.inicioSesionBD(idTe,nombreTe)){
                    System.out.println("Se ha iniciado sesion correctamente");
                    GUII.menuEntrada();
                    frame.setVisible(false);
                }else{
                    System.out.println("Hay algun dato incorrecto");
                }
            }
        });
    }

    public static void reservarClase(){
        JFrame frame = new JFrame("Reservar clase");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel nombre = new JLabel("Nombre");
        JTextField nombreT = new JTextField();
        JLabel id = new JLabel("Hora");
        JTextField idT = new JTextField();
        JButton enviar  = new JButton("Enviar");
        JButton volver = new JButton("Volver");

        frame.add(nombre);
        frame.add(nombreT);
        frame.add(id);
        frame.add(idT);
        frame.add(volver);
        frame.add(enviar);


        frame.setVisible(true);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUII.menuEntrada();
            }
        });

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String hora = idT.getText();

                System.out.println("Tu clase ha sido reservada a las " + hora + " del dia " + (int)(Math.random()*30) + " de Junio");

                frame.setVisible(false);
                GUII.menuEntrada();
            }
        });
    }

    public static void crearUsuarioMenu() {
        JFrame frame = new JFrame("Crear Usuario");
        frame.setSize(800, 500);
        frame.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel nombre = new JLabel("Nombre");
        JLabel apellido = new JLabel("Apellido");
        JLabel telefono = new JLabel("Teléfono");
        JLabel id = new JLabel("ID");
        JLabel fechaNacimiento = new JLabel("Fecha Nacimiento");

        JTextField nombreT = new JTextField();
        JTextField apellidoT = new JTextField();
        JTextField telefonoT = new JTextField();
        JTextField idT = new JTextField();
        JTextField fechaNacimientoT = new JTextField();

        JButton enviar = new JButton("Enviar");
        JButton volver = new JButton("Volver");

        frame.add(nombre);
        frame.add(nombreT);
        frame.add(apellido);
        frame.add(apellidoT);
        frame.add(telefono);
        frame.add(telefonoT);
        frame.add(id);
        frame.add(idT);
        frame.add(fechaNacimiento);
        frame.add(fechaNacimientoT);
        frame.add(volver);
        frame.add(enviar);
        frame.setVisible(true);

        enviar.addActionListener((ActionEvent e) -> {
            try {
                int idNum = Integer.parseInt(idT.getText());
                String nombreStr = nombreT.getText();
                String apellidoStr = apellidoT.getText();
                String telefonoStr = telefonoT.getText();
                LocalDate fecha = LocalDate.parse(fechaNacimientoT.getText());

                Persona.listaUsuarios.add(new Alumno(idNum, nombreStr, apellidoStr, telefonoStr, fecha));
                System.out.println("Usuario agregado: " + Persona.listaUsuarios);

                BDConection.conectarConBDAddUsuario(idNum, nombreStr, apellidoStr, telefonoStr);

            } catch (NumberFormatException o) {
                System.out.println("Error con las conversiones de numeros");
            }
        });

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUII.menuEntrada();
            }
        });
    }


    public static void mostrarUsuarios() {


        BDConection.BDmostrarUsuarios();


    }

    public static void generarTest() {
        BDConection.BDHacerTest();
    }

    public static void eliminarUsuario() {
        JFrame frame = new JFrame("Eliminar user");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 2, 5, 5));
        frame.setVisible(true);

        JLabel etiqueta = new JLabel("id");
        JTextField text = new JTextField();
        JButton enviar = new JButton("Enviar");
        JButton volver = new JButton("Volver");

        frame.add(etiqueta);
        frame.add(text);


        frame.add(enviar);
        frame.add(volver);


        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idT = Integer.parseInt(text.getText());
                BDConection.eliminarUser(idT);
            }
        });

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUII.menuEntrada();
                frame.setVisible(false);
            }
        });
    }
}
