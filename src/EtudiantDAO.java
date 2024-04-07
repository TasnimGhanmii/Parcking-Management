/*import TP4EX2.IHM.DataBase.MyConnection;

import java.sql.*;

public class EtudiantDAO {
    Connection con = null;
    public EtudiantDAO(String url, String username, String password){

        con= MyConnection.getConnection(url,username,password);
    }


    public int insertEtudiant(String nom, String prenom, int cin, double moyenne) {
        String req1 = "insert into etudiant values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(req1);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setInt(3,cin);
            ps.setDouble(4,moyenne);
            return ps.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }


    }




    public ResultSet selection(String req) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(req);
        } catch (SQLException e) {
            return null;
        }
    }



    public void afficheResultSet(ResultSet rs) {
        try {
            while (rs.next()) {
                String n = rs.getString(1);
                String p = rs.getString(2);
                int cin = rs.getInt(3);
                double moy = rs.getDouble(4);
                System.out.println(n + " " + p + " " + cin + " " + moy);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int modifierEtudiant(String nom, String prenom, int cin, double moy) {
        String req = "UPDATE etudiant SET nom = ?, prenom = ?, moyenne = ? WHERE cin = ?";
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setDouble(3,moy);
            ps.setInt(4,cin);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public int supprimerEtudiant(int cin){
        String req="Delete from etudiant where cin = ?";
        try{
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1,cin);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


   /* public void afficheAll(String req) {
        try {
        Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                String n = rs.getString(1);
                String p = rs.getString(2);
                int cin = rs.getInt(3);
                double moy = rs.getDouble(4);
                System.out.println(n+" "+p+" "+" "+cin+" "+moy);
            }

        } catch (SQLException e) {
            System.out.println("Erreur"+e.getMessage());
        }
    }*/


/*}*/