package interfaz;

import persona.AlumnoMagister;
import persona.AlumnoPregrado;
import persona.Persona;
import persona.ProfesorHora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainPersona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int horas, opc = 0;
        String cedula, nombre, universidad, carrera, tesis, especialidad;

        List<Persona> personas = new ArrayList<>();

        do {
            menu();

            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida. Ingrese un numero.");
                continue;
            }

            switch (opc) {

                case 1:
                    try {
                        System.out.print("Ingrese su cedula: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese su nombre: ");
                        nombre = sc.nextLine();
                        System.out.print("Ingrese su universidad: ");
                        universidad = sc.nextLine();
                        System.out.print("Ingrese su carrera: ");
                        carrera = sc.nextLine();

                        personas.add(new AlumnoPregrado(cedula, nombre, universidad, carrera));
                    } catch (Exception e) {
                        System.out.println("Error al ingresar Alumno Pregrado.");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Ingrese su cedula: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese su nombre: ");
                        nombre = sc.nextLine();
                        System.out.print("Ingrese su universidad: ");
                        universidad = sc.nextLine();
                        System.out.print("Ingrese su tesis: ");
                        tesis = sc.nextLine();

                        personas.add(new AlumnoMagister(cedula, nombre, universidad, tesis));
                    } catch (Exception e) {
                        System.out.println("Error al ingresar Alumno Magister.");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Ingrese su cedula: ");
                        cedula = sc.nextLine();
                        System.out.print("Ingrese su nombre: ");
                        nombre = sc.nextLine();
                        System.out.print("Ingrese su especialidad: ");
                        especialidad = sc.nextLine();
                        System.out.print("Ingrese el numero de horas: ");
                        horas = Integer.parseInt(sc.nextLine());

                        personas.add(new ProfesorHora(cedula, nombre, especialidad, horas));
                    } catch (NumberFormatException e) {
                        System.out.println("Las horas deben ser un numero.");
                    } catch (Exception e) {
                        System.out.println("Error al ingresar Profesor Hora.");
                    }
                    break;

                case 4:
                    try {
                        mostrarAlumnosPregrado(personas);
                    } catch (Exception e) {
                        System.out.println("Error al mostrar alumnos de pregrado.");
                    }
                    break;

                case 5:
                    try {
                        mostrarAlumnosMagister(personas);
                    } catch (Exception e) {
                        System.out.println("Error al mostrar alumnos de magister.");
                    }
                    break;

                case 6:
                    try {
                        mostrarProfesoresCHS(personas);
                    } catch (Exception e) {
                        System.out.println("Error al mostrar profesores.");
                    }
                    break;

                case 7:
                    try {
                        mostrarAlumnosPregrado(personas);
                        mostrarAlumnosMagister(personas);
                        mostrarProfesores(personas);
                    } catch (Exception e) {
                        System.out.println("Error al mostrar listado general.");
                    }
                    break;

                case 8:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("No es una opcion valida");
            }

        } while (opc != 8);

        sc.close();
    }

    public static void menu() {
        System.out.println("\n-------MENU--------");
        System.out.println("1. Ingresar Alumno Pregrado");
        System.out.println("2. Ingresar Alumno Magister");
        System.out.println("3. Ingresar Profesor Hora");
        System.out.println("4. Mostrar Alumnos Pregrado");
        System.out.println("5. Mostrar Alumnos Magister");
        System.out.println("6. Mostar Cedula, Horas y Sueldo de Profesor");
        System.out.println("7. Mostar Listado");
        System.out.println("8. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void mostrarAlumnosPregrado(List<Persona> perso) {
        if (perso == null || perso.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas está vacía o es nula");
        }

        System.out.println("---ALUMNOS DE PREGRADO---");
        boolean encontrado = false;

        for (Persona p : perso) {
            if (p instanceof AlumnoPregrado) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new IllegalStateException("No existen alumnos de pregrado registrados");
        }
    }

    public static void mostrarAlumnosMagister(List<Persona> perso) {
        if (perso == null || perso.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas está vacía o es nula");
        }

        System.out.println("---ALUMNOS DE MAESTRIA---");
        boolean encontrado = false;

        for (Persona p : perso) {
            if (p instanceof AlumnoMagister) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new IllegalStateException("No existen alumnos de maestría registrados");
        }
    }

    public static void mostrarProfesores(List<Persona> perso) {
        if (perso == null || perso.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas está vacía o es nula");
        }

        System.out.println("---PROFESORES---");
        boolean encontrado = false;

        for (Persona p : perso) {
            if (p instanceof ProfesorHora) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new IllegalStateException("No existen profesores registrados");
        }
    }

    public static void mostrarProfesoresCHS(List<Persona> perso) {
        if (perso == null || perso.isEmpty()) {
            throw new IllegalArgumentException("La lista de personas está vacía o es nula");
        }

        System.out.println("====PROFESORES====");
        boolean encontrado = false;

        for (Persona p : perso) {
            if (p instanceof ProfesorHora) {
                ProfesorHora ph = (ProfesorHora) p;
                System.out.println(
                        "Nombre: " + ph.getNombre() +
                                "\nCedula: " + ph.getCedula() +
                                "\nHoras: " + ph.getHoras() +
                                "\nSueldo: " + ph.getHoras() * 40
                );
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new IllegalStateException("No existen profesores por hora registrados");
        }
    }
}

