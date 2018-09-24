/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul03;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tabelmodel extends AbstractTableModel {

    private List<DataMahasiswa> listMahasiswa = new ArrayList<>();

    public void insert(DataMahasiswa mahasiswaBaru) {
        listMahasiswa.add(mahasiswaBaru);
        fireTableDataChanged();
    }

    public void update(int index, DataMahasiswa mahasiswaUpdate) {
        listMahasiswa.set(index, mahasiswaUpdate);
        fireTableDataChanged();
    }

    public void delete(int index) {
        listMahasiswa.remove(index);
        fireTableDataChanged();
    }

    public DataMahasiswa getMahasiswa(int index) {
        return listMahasiswa.get(index);
    }

    public void setListMahasiswa(List<DataMahasiswa> listMahasiswaBaru) {
        listMahasiswa = listMahasiswaBaru;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listMahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return listMahasiswa.get(rowIndex).getNim();
            case 2:
                return listMahasiswa.get(rowIndex).getNama();
            case 3:
                return listMahasiswa.get(rowIndex).getJurusan();
            case 4:
                return listMahasiswa.get(rowIndex).getAsal();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "NIM";
            case 2:
                return "Nama";
            case 3:
                return "Jurusan";
            case 4:
                return "Asal";
            default:
                return null;
        }
    }
}
