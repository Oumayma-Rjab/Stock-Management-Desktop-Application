/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
    import java.net.Socket;
    import java.sql.*;
 
/**
 *
 * @author Asus
 */
public class BDD {
     
     Connection connection;
     Statement statement;
     String SQL;
     
     String url;
     String username;
     String password;
     Socket client;
     
     int Port;
     
     String Host;
     public BDD(String url,String username,String password,String Host ,int Port) {
        
         this.url = url;
         this.username = username;
         this.password = password;
         this.Host = Host;
         this.Port = Port;
     }
     //fonction eli rbatna beha application lel base de données
     public Connection connexionDatabase() {
         try {
             Class.forName("com.mysql.jdbc.Driver");
             
            connection = DriverManager.getConnection(url, username,password);
         } 
         catch(Exception e){
             System.err.println(e.getMessage());
             
         }
         return connection;
     }
     
     public Connection closeconnexion() {
         
         try {
             connection.close();
         }
        catch(Exception e){
             System.err.println(e.getMessage());
             
         }
         return connection;
         
     }
     
     //bch n'excutiw el requete 
     public ResultSet executionQuery(String sql) {
         connexionDatabase();
         ResultSet resultSet = null;
         try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery(sql);
             System.out.println(sql);
             
         }
         catch(SQLException ex){
             System.err.println(ex);
         }
         return resultSet;
     }
     
     //bch n'executiw les update
     public String executionUpdate(String sql) {
         connexionDatabase();
         String result = "";
         try {
             statement = connection.createStatement();
             statement.executeUpdate(sql);
             result = sql ;
             
         }
         catch(SQLException ex){
            result = ex.toString();
         }
         return result;
     }
     
     //bch n 'affichiew table kolha 
     public ResultSet querySelectAll(String nomTable) {
         connexionDatabase();
         SQL = "SELECT * FROM " + nomTable;
         System.out.println(SQL);
         return this.executionQuery(SQL);
     }
      // afficher kol chay mais avec condition
     public ResultSet querySelectAll(String nomTable, String etat) {
         connexionDatabase();
         SQL = "SELECT * FROM " + nomTable + " WHERE " + etat;
         System.out.println(SQL);
         return this.executionQuery(SQL);
     }
     //afficher une colonne
     public ResultSet querySelect(String[] nomColonne, String nomTable) {

        connexionDatabase();
        int i;
        SQL = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }

        SQL += " FROM " + nomTable;
        return this.executionQuery(SQL);

    }
     
     public ResultSet fcSelectCommand(String[] nomColonne, String nomTable, String etat){
        
        connexionDatabase();
        int i;
        SQL = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }

        SQL += " FROM " + nomTable + " WHERE " + etat;
        
         return this.executionQuery(SQL);
     }
     // entrer des données
     public String queryInsert(String nomTable , String[] contenuTuple){
         connexionDatabase();
         int i ;
         SQL = " INSERT INTO " + nomTable + " VALUES(";
         for (i = 0;i<=contenuTuple.length - 1;i++){
             SQL += "'" + contenuTuple[i] + "'";
             if (i < contenuTuple.length - 1) {
                 SQL += ","; 
             }
         }
         SQL += ")";
         return this.executionUpdate(SQL);
     }
     //
     
     public String queryInsert(String nomTable , String[] nomColonne ,String[] contenuTuple){
         connexionDatabase();
         int i;
         SQL = " INSERT INTO " + nomTable + "(";
         for (i = 0; i <= nomColonne.length - 1;i++){
        SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }
        SQL += ") VALUES(";
        for (i = 0; i <= contenuTuple.length - 1; i++) {
            SQL += "'" + contenuTuple[i] + "'";
            if (i < contenuTuple.length - 1) {
                SQL += ",";
            }
        }

        SQL += ")";
        return this.executionUpdate(SQL);

     }
    
     public String queryUpdate(String nomTable, String[] nomColonne, String[] contenuTuple, String etat) {

        connexionDatabase();
        int i;
        SQL = "UPDATE " + nomTable + " SET ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i] + "='" + contenuTuple[i] + "'";
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }

        SQL += " WHERE " + etat;
        return this.executionUpdate(SQL);

    }
     
     //supprimer sans parameter

   public String queryDelete(String nomtable) {
       connexionDatabase();
       SQL = " DELETE FROM " + nomtable;
       return this.executionUpdate(SQL);
       
   } 
   
   //supprimer avec parameter
    public String queryDelete(String nomTable, String etat) {

        connexionDatabase();
        SQL = "DELETE FROM " + nomTable + " WHERE " + etat;
        return this.executionUpdate(SQL);

    }
}
