package DAO;

import Control.ClassicSingleton;
import Control.Controller;
import Entity.Professore;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.sql.SQLException;


public class DBInsert extends DB_Connection_Aule {

    public void insert(String nameAula, String tipoPrenota, String dataPrenota, LocalTime timeInizioPrenota, LocalTime timeFinePrenota, boolean a) {

        if (!a) {  //PROFESSORE

            try{
                String controlQuery = "SELECT Nome FROM Aule.dati WHERE Nome='"+nameAula+"' AND((DataPr='"+dataPrenota+"' AND Inizio<='"+timeInizioPrenota+"' AND Fine>='"+timeInizioPrenota+"')"+"OR(DataPr='"+dataPrenota+"' AND Fine>='"+timeFinePrenota+"' AND Inizio<='"+timeFinePrenota+"') "+"OR(DataPr='"+dataPrenota+"' AND Inizio>='"+timeInizioPrenota+"' AND Fine<='"+timeFinePrenota+"')"+"OR(DataPr='"+dataPrenota+"'AND Inizio<='"+timeInizioPrenota+"'AND Fine>='"+timeFinePrenota+"'))";
                DB_Connection_Aule db_connection_aule = new DB_Connection_Aule();
                db_connection_aule.connect_Aule();
                Statement statement = conn_Aule.createStatement();
                ResultSet rs = statement.executeQuery(controlQuery);
                if(rs.next()){
                    Controller c9 = new Controller();
                    c9.duplicateKeyMessage();
                }else {
                    Professore professore = ClassicSingleton.getInstance().getProfessore();
                    System.out.println("Profesore username: " + professore.getUsername());

                    String QUERYprof = "INSERT INTO Aule.dati (Nome, TipoPr, DataPr, Inizio, Fine, FromP) VALUES " + "('"
                            + nameAula + "','" + tipoPrenota + "','" + dataPrenota + "','" + timeInizioPrenota + "','" + timeFinePrenota + "','" + professore.getUsername() + "')";
                    DB_Connection_Aule db_connection_aule1 = new DB_Connection_Aule();
                    db_connection_aule1.connect_Aule();
                    Statement statement1 = conn_Aule.createStatement();
                    statement.executeUpdate(QUERYprof);
                }
            }catch (Exception ex){
                System.err.println(ex);

            }

        } else { //SEGRETARIA
            System.out.println("CISTOOOOOOOOOOOO");
            //Prenotazione segretaria
            /*String controlQuery = "SELECT FROM Aule.dati WHERE Nome='" + nameAula + "' AND ((DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "')" + "OR (DataPr='" + dataPrenota + "' AND Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota + "' AND Inizio>='" + timeInizioPrenota + "' AND Fine<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeFinePrenota + "'))";
            try{
                DB_Connection_Aule db_connection_aule = new DB_Connection_Aule();
                db_connection_aule.connect_Aule();
                Statement statement = conn_Aule.createStatement();
                ResultSet rs = statement.executeQuery(controlQuery);
                while ((rs.next())){
                    System.out.println("CCCCCCCCCCCC");
                    *//*String updateSecretary = "DELETE FROM Aule.dati WHERE Nome='" + nameAula + "' AND ((DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "')" + "OR (DataPr='" + dataPrenota + "' AND Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota + "' AND Inizio>='" + timeInizioPrenota + "' AND Fine<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeFinePrenota + "'))";
                    db_connection_aule.connect_Aule();
                    Statement statement1 = conn_Aule.createStatement();
                    statement1.executeQuery(updateSecretary);
                    Statement statement2 =conn_Aule.createStatement();
                    String insertSecretary="INSERT INTO Aule.dati (Nome, TipoPr, DataPr, Inizio, Fine, FromP) VALUES " + "('" + nameAula + "','" + tipoPrenota + "','" + dataPrenota + "','" + timeInizioPrenota + "','" + timeFinePrenota + "','Secretary')";
                    statement2.executeQuery(insertSecretary);*//*
                }
                String insertSecretary="INSERT INTO Aule.dati (Nome, TipoPr, DataPr, Inizio, Fine, FromP) VALUES " + "('" + nameAula + "','" + tipoPrenota + "','" + dataPrenota + "','" + timeInizioPrenota + "','" + timeFinePrenota + "','Secretary')";
                db_connection_aule.connect_Aule();
                Statement statement1 = conn_Aule.createStatement();
                statement1.executeQuery(insertSecretary);
            }catch (SQLException e){
                e.printStackTrace();
            }*/
            String controlQuery = "SELECT Nome FROM Aule.dati WHERE Nome='" + nameAula + "' AND ((DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "')" + "OR (DataPr='" + dataPrenota + "' AND Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota + "' AND Inizio>='" + timeInizioPrenota + "' AND Fine<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeFinePrenota + "'))";

            /*String querySecretary = "INSERT INTO Aule.dati (Nome, TipoPr, DataPr, Inizio, Fine, FromP) VALUES " +
                    "('" + nameAula + "','" + tipoPrenota + "','" + dataPrenota + "','" + timeInizioPrenota +
                    "','" + timeFinePrenota + "','Secretary')";*/
            try {
                DB_Connection_Aule db_connection_aule = new DB_Connection_Aule();
                db_connection_aule.connect_Aule();
                Statement statement = conn_Aule.createStatement();
                ResultSet resultSet = statement.executeQuery(controlQuery);
                if (!resultSet.wasNull()) {
                    System.out.println("ERROREEEEEEEEEE");
                    try {
                        String deleteSecretary = "DELETE FROM Aule.dati WHERE Nome='" + nameAula +
                                "' AND ((DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota +
                                "' AND Fine>='" + timeInizioPrenota + "')" + "OR (DataPr='" + dataPrenota +
                                "' AND Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " +
                                "OR (DataPr='" + dataPrenota + "' AND Inizio>='" + timeInizioPrenota +
                                "' AND Fine<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota +
                                "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeFinePrenota + "'))";
                        DB_Connection_Aule db_connection_aule1 = new DB_Connection_Aule();
                        db_connection_aule1.connect_Aule();
                        Statement statement1 = conn_Aule.createStatement();
                        statement1.executeUpdate(deleteSecretary);
                        String insertSecretary="INSERT INTO Aule.dati (Nome, TipoPr, DataPr, Inizio, Fine, FromP) VALUES " + "('" + nameAula + "','" + tipoPrenota + "','" + dataPrenota + "','" + timeInizioPrenota + "','" + timeFinePrenota + "','Secretary')";
                        DB_Connection_Aule db_connection_aule2 = new DB_Connection_Aule();
                        db_connection_aule2.connect_Aule();
                        Statement statement2 = conn_Aule.createStatement();
                        statement2.executeUpdate(insertSecretary);
                        /*Controller c11 = new Controller();
                        c11.newP(nameAula, tipoPrenota, dataPrenota, timeInizioPrenota, timeFinePrenota, a);*/

                    } catch (Exception ex1) {
                        ex1.printStackTrace();
                    }
                }

            /*} catch (Exception e) {
                System.err.println("Got an exception");
                String s = String.valueOf(((SQLException) e).getErrorCode());
                if (s.equals("1062")) {
                    //String updateSecretary = "UPDATE Aule.dati SET TipoPr='" + tipoPrenota + "', DataPr='" + dataPrenota + "', Inizio='" + timeInizioPrenota + "', Fine='" + timeFinePrenota + "' WHERE (Nome='" + nameAula + "')";
                    String updateSecretary = "DELETE FROM Aule.dati WHERE Nome='" + nameAula +
                            "' AND ((DataPr='" + dataPrenota + "' AND Inizio<='" + timeInizioPrenota +
                            "' AND Fine>='" + timeInizioPrenota + "')" + "OR (DataPr='" + dataPrenota +
                            "' AND Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " +
                            "OR (DataPr='" + dataPrenota + "' AND Inizio>='" + timeInizioPrenota +
                            "' AND Fine<='" + timeFinePrenota + "') " + "OR (DataPr='" + dataPrenota +
                            "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeFinePrenota + "'))";
                    try {
                        DB_Connection_Aule db_connection_aule = new DB_Connection_Aule();
                        db_connection_aule.connect_Aule();
                        Statement statement = conn_Aule.createStatement();
                        statement.executeUpdate(updateSecretary);
                        Controller c11 = new Controller();
                        c11.newP(nameAula, tipoPrenota, dataPrenota, timeInizioPrenota, timeFinePrenota, a);

                    } catch (Exception ex1) {
                        ex1.printStackTrace();
                    }
                }

            }*/

            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }
}
