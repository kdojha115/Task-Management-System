package kd.tms.task.management.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kd.tms.task.management.system.model.Task;
import kd.tms.task.management.system.repo.TaskRepo;

@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    public List<Task> getAllTaskItems() {
        return repo.findAll();
    }

    public Task getTaskItemById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public boolean updateStatus(Long id) {
        Task task = getTaskItemById(id);
        if (task != null) {
            task.setStatus("Completed");
            return saveOrUpdateTaskItem(task);
        }
        return false;
    }

    public boolean saveOrUpdateTaskItem(Task task) {
        try {
            repo.save(task);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTaskItem(Long id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
