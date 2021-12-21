package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Lecture;


@Mapper
public interface LectureMapper {

    @Select("SELECT * FROM lecture WHERE id = #{id}")
    Lecture findById(int id);

    @Select("SELECT l.*, c.courseName " +
            "FROM lecture l LEFT JOIN course c ON l.courseId = c.id")
    List<Lecture> findAll();

    @Insert("INSERT lecture (year, semester, gubun, bunban, courseId, sigan) " +
            "VALUES (#{year}, #{semester}, #{gubun}, #{bunban}, #{courseId}, #{sigan})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Lecture lecture);

    @Update("UPDATE lecture SET year=#{year}, semester=#{semester}, gubun=#{gubun}, " +
            " bunban=#{bunban}, courseId=#{courseId}, sigan=#{sigan} WHERE id=#{id}")
    void update(Lecture lecture);

    @Delete("DELETE FROM lecture WHERE id=#{id}")
    void delete(int id);
}


