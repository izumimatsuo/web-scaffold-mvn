package example.adapters.datasource.task;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Options;

import example.models.task.Task;

@Mapper
public interface TaskMapper {

    @Select({"SELECT id, title, memo, status, createAt",
             "FROM tasks",
             "WHERE id = #{id}"})
    Task select(long id);

    @Select({"SELECT id, title, memo, status, createAt",
             "FROM tasks"})
    List<Task> selectAll();

    @Insert({"INSERT INTO tasks (title, memo, status)",
             "VALUES (#{title}, #{memo}, #{status})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Task task);

    @Update({"UPDATE tasks",
             "SET title = #{title}, memo = #{memo}, status = #{status}",
             "WHERE id = #{id}"})
    int update(Task task);

    @Delete({"DELETE FROM tasks",
             "WHERE id = #{id}"})
    void delete(Task task);
}
