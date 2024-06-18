package kd.tms.task.management.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import kd.tms.task.management.system.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}
