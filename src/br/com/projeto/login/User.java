package br.com.projeto.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A classe User gerencia a autenticação de usuários no sistema.
 * Ela se conecta ao banco de dados para verificar se o usuário existe e retornar seu nome.
 */
public class User {

    /**
     * Estabelece a conexão com o banco de dados MySQL.
     * 
     * @return Connection Retorna a conexão com o banco de dados ou null se não for possível se conectar.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC para o MySQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123&useSSL=false";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Log do erro em caso de falha na conexão
            e.printStackTrace();
        }
        return conn;
    }

    // Atributos da classe para armazenar o nome do usuário e o resultado da verificação
    public String nome = "";
    public boolean result = false;

    /**
     * Verifica se o login e senha fornecidos são válidos no banco de dados.
     * 
     * @param login O login do usuário
     * @param senha A senha do usuário
     * @return boolean Retorna true se o login e senha forem válidos, caso contrário false
     */
    public boolean verificarUsuario(String login, String senha) {
        // Consulta SQL para verificar se o usuário existe no banco
        String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";
        try (Connection conn = conectarBD(); // Estabelece a conexão com o banco
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            // Verifica se a conexão foi estabelecida com sucesso
            if (conn == null) {
                throw new IllegalStateException("Não foi possível conectar ao banco de dados.");
            }
            
            // Define os parâmetros da consulta
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();  // Executa a consulta no banco

            // Se o usuário for encontrado, define o resultado
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");  // Armazena o nome do usuário
            }
            rs.close();  // Fecha o ResultSet
        } catch (Exception e) {
            // Log do erro em caso de exceção
            e.printStackTrace();
        }
        return result;  // Retorna o resultado da verificação
    }
}
