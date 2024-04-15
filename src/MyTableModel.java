import DB.EtudiantDAO;
import DB.EtudiantDAO;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    ArrayList<Object[]>data=new ArrayList<Object[]>();
    ResultSetMetaData rsmd;
    EtudiantDAO dao;
    public MyTableModel(ResultSet rs, EtudiantDAO dao)
    {
        this.dao=dao;
        try {
            rsmd=rs.getMetaData();

            while(rs.next())
            {
                Object[] ligne=new Object[rsmd.getColumnCount()];
                for(int i=0;i<ligne.length;i++)
                {
                    ligne[i]=rs.getObject(i+1);
                    data.add(ligne);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getRowCount() {

        return data.size();
    }

    @Override
    public int getColumnCount() {

        try {
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int col) {
        try {
            return rsmd.getColumnName(col+1);
        } catch (SQLException e) {
            return null;
        }
    }
    //specification a cet projet
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(getColumnName(columnIndex).equalsIgnoreCase("cin"))
            return false;
        else
            return true;
    }
    public int columnNameToIndex(String columnName)
    {
        for(int i=0;i<getColumnCount();i++) {
            if (getColumnName(i).equalsIgnoreCase(columnName))
                return i;
        }
        return -1;
    }


    public void insertEtudiant(String nom,String prenom,int cin,double moyenne)
    {    int a=dao.insertEtudiant(nom,prenom,cin,moyenne);
        if(a>0) {
            data.add(new Object[]{nom, prenom, cin, moyenne});
            //refraiche (de l'affichage)
            fireTableDataChanged();
            JOptionPane.showMessageDialog(null,"done");
        }
        else
            JOptionPane.showMessageDialog(null,"error detected");
    }
}