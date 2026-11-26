package br.com.fatec;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String usuario = "root";
    private static String senha = "admin";
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "db_gta";

    public static Connection obterConexao() {
        try {
            Connection conexao = DriverManager.getConnection(
                String.format("jdbc:mysql://%s:%s/%s", host, porta, db),
                usuario,
                senha
            );
            return conexao;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conexao = ConnectionFactory.obterConexao();
        System.out.println(conexao);
    }
}