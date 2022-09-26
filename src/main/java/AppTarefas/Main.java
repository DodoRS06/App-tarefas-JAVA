package AppTarefas;

import controller.ProjectController;
import controller.TaskController;
import java.util.Date;
import model.Project;
import model.Task;

public class Main {

    public static void main(String[] args) throws Exception {
        
        ProjectController projectController = new ProjectController();
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        //task.setId(12);
        task.setIdProject(18);
        task.setName("Novo nome do projeto");
        task.setDescription("description");
        task.setCompleted(false);
        task.setNotes("Novo nome do projeto");
        task.setDeadline(new Date());
        //project.setName("Projeto teste");
        taskController.save(task);
        
        //Project project = new Project();
        //project.setId(14);
        //task.setIdProject(13);
        //project.setName("novo nome do projeto");
        //project.setName("Projeto teste");
        //project.setDescription("description");
        //task.setCompleted(true);
        //task.setNotes("Novo nome do projeto");
        
        
        //projectController.update(project);
        
        //taskController.removeById(12);
        
        //List<Project> projects = projectController.getAll();
        //System.out.println("Total de projetos: "+ projects.size());
    }
}
