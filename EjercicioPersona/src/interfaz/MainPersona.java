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

        List <Persona> personas = new ArrayList<>();

        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:{
                    System.out.print("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    nombre= sc.nextLine();
                    System.out.print("Ingrese su universidad: ");
                    universidad= sc.nextLine();
                    System.out.print("Ingrese su carrera: ");
                    carrera= sc.nextLine();
                    personas.add(new AlumnoPregrado(cedula, nombre, universidad, carrera));
                }break;
                case 2:{
                    System.out.print("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    nombre= sc.nextLine();
                    System.out.print("Ingrese su universidad: ");
                    universidad= sc.nextLine();
                    System.out.print("Ingrese su tesis: ");
                    tesis= sc.nextLine();
                    personas.add(new AlumnoMagister(cedula, nombre, universidad, tesis));
                }break;
                case 3:{
                    System.out.print("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    nombre= sc.nextLine();
                    System.out.print("Ingrese su especialidad: ");
                    especialidad= sc.nextLine();
                    System.out.println("Ingrese el numero de horas: ");
                    horas= Integer.parseInt(sc.nextLine());
                    personas.add(new ProfesorHora(cedula, nombre, especialidad, horas));
                }break;
                case 4:{
                    mostrarAlumnosPregrado(personas);
                }break;
                case 5:{
                    mostrarAlumnosMagister(personas);
                }break;
                case 6:{
                    mostrarProfesoresCHS(personas);
                }break;
                case 7:{
                    mostrarAlumnosPregrado(personas);
                    mostrarAlumnosMagister(personas);
                    mostrarProfesores(personas);
                }break;
                case 8:{
                    System.out.println("Saliendo del programa");
                }break;
                default:{
                    System.out.println("No es una opcion valida");
                }
            }
        } while (opc!=8);
    }

    public static void menu(){
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
    public static void mostrarAlumnosPregrado(List<Persona> perso){
        System.out.println("---ALUMNOS DE PREGRADO---");
        for(Persona p : perso){
            if (p instanceof AlumnoPregrado){
                System.out.println(p);
            }
        }
    }
    public static void mostrarAlumnosMagister(List<Persona> perso){
        System.out.println("---ALUMNOS DE MAESTRIA---");
        for(Persona p : perso){
            if (p instanceof AlumnoMagister){
                System.out.println(p);
            }
        }
    }

    public static void mostrarProfesores(List<Persona> perso){
        System.out.println("---PROFESORES---");

        for(Persona p : perso){
            if (p instanceof ProfesorHora){
                System.out.println(p);
            }
        }
    }

    public static void mostrarProfesoresCHS(List<Persona> perso){
        System.out.println("====PROFESORES====");
        for(Persona p: perso){
            if (p instanceof ProfesorHora){
                ProfesorHora ph= (ProfesorHora) p;
                System.out.println("Nombre: "+ph.getNombre()+
                        "\nCedula: "+ph.getCedula()+
                        "\nHoras: "+ph.getHoras()+
                        "\nSueldo: "+ph.getHoras()*40);
            }
        }
    }
}
