package akshatmittal61.db;

import akshatmittal61.constants.Queries;
import akshatmittal61.core.Task;
import akshatmittal61.core.TaskMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.ArrayList;

public interface TaskDao {
    @SqlQuery(Queries.TASKS_TABLE_EXISTS)
    Boolean tableExists();

    @SqlUpdate(Queries.CREATE_TASKS_TABLE)
    void createTable();

    @SqlQuery(Queries.CREATE_TASK)
    @RegisterRowMapper(TaskMapper.class)
    Task create(@Bind("content") String content,@Bind("completed")  boolean completed);

    @SqlQuery(Queries.GET_ALL_TASKS)
    @RegisterRowMapper(TaskMapper.class)
    ArrayList<Task> findAll();

    @SqlQuery(Queries.GET_TASK_BY_ID)
    @RegisterRowMapper(TaskMapper.class)
    Task findById(@Bind("id") String id);

    @SqlQuery(Queries.UPDATE_TASK)
    @RegisterRowMapper(TaskMapper.class)
    Task update(@Bind("id") String id, @Bind("content")  String content, @Bind("completed")  boolean completed);

    @SqlQuery(Queries.DELETE_TASK)
    @RegisterRowMapper(TaskMapper.class)
    Task delete(@Bind("id") String id);
}
