package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConectionFactory;

public class ProjectController {
    
    public void save(Project project){
        String sql = "INSERT INTO projects (name,"
                + "description,"
                + "createdAT,"
                + "updatedAT) VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            //Estabelecendo a conexão com o banco de dados
            connection = ConectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores no statement
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAT().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAT().getTime()));
            //Executa sql para inserção de dados
            statement.execute();
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao salvar projeto ", ex);
        }finally{
            ConectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Project project){
        String sql = "UPDATE projects SET "
                + "name = ?,"
                + "description = ?,"
                + "createdAT = ?,"
                + "updatedAT = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            //Estabelecendo a conexão com o banco de dados
            connection = ConectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores no statement
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAT().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAT().getTime()));
            statement.setInt(5, project.getId());
            //Executando a query
            statement.execute();
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao atualizar o projeto ", ex);
        }finally{
            ConectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void removeById(int idProject){
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            //Criação da conexão com o banco de dados
            connection = ConectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores
            statement.setInt(1, idProject);
            //Executando a query
            statement.execute();
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao deletar o projeto ", ex);
        }finally{
            ConectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //Lista de projetos que será devolvida quando a chamada do método acontecer
        List<Project> projects = new ArrayList<>();
        
        try{
            //Criação da conexão com o banco de dados
            connection = ConectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Valor retornado pela execução da query
            resultSet = statement.executeQuery();
            
            //Enquanto houverem valores a ser percorridos no meu resultSet
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));      
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAT(resultSet.getDate("createdAT"));
                project.setUpdatedAT(resultSet.getDate("updatedAT"));
                
                projects.add(project);
            }
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao inserir a tarefa!", ex);
        }finally{
            ConectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        //Lista de tarefas que foi criada e carregada do banco de dados
        return projects;
    }
}
