package TP4EX2.IHM.DataBase;

import java.sql.*;

public class FormationDAO {
    Connection con = null;
    public FormationDAO(String url, String username, String password){

        con= MyConnection.getConnection(url,username,password);
    }

    public int AjouterFormation(int id,String nom,String prenom,String filiere,String grade)
    {
        String req="insert into Formation values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setString(3,filiere);
            ps.setString(4,filiere);
            ps.setString(5,grade);
            return ps.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }

    }
    public void RechercherFormation(int FormationId) throws SQLException {
        String sql = "SELECT * FROM Formation WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, FormationId);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Enseignant found - Name: " + name + ", Age: " + age);
            } else {
                System.out.println("Enseignant not found with ID: " + FormationId);
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



    public void afficher(int EnseignantId) {
        try {
            String req= "SELECT * FROM Enseignant WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(req);
            statement.setInt(1, EnseignantId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Enseignant ID: " + EnseignantId + ", Name: " + name + ", Age: " + age);
            } else {
                System.out.println("Enseignant not found with ID: " + EnseignantId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
