package TP4EX2.IHM.DataBase;

import java.sql.*;

public class EtudiantDAO {
    Connection con = null;
    public EtudiantDAO(String url, String username, String password){

        con= MyConnection.getConnection(url,username,password);
    }



    public int AjouterEtudiant(int id,String nom,String prenom,String filiere,String niveau,String grp)
    {
        String req="insert into etudiant values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setString(3,filiere);
            ps.setString(4,niveau);
            ps.setString(5,grp);
            return ps.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }

    }

    public void RechercherEtudiant(int studentId) throws SQLException {
        String sql = "SELECT * FROM etudiant WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, studentId);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Student found - Name: " + name + ", Age: " + age);
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (SQLException e) {
            System.out.println("RECHERCHER ERROR " );

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



    public void afficher(int studentId) {
        try {
           String req= "SELECT * FROM etudiant WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(req);
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Student ID: " + studentId + ", Name: " + name + ", Age: " + age);
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }







}
