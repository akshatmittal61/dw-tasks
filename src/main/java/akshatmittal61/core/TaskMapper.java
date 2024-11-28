package akshatmittal61.core;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task map(ResultSet rs, StatementContext ctx) throws SQLException {
        String id = rs.getString("id");
        String content = rs.getString("content");
        Boolean completed = rs.getBoolean("completed");
        return new Task(id, content, completed);
    }
}
