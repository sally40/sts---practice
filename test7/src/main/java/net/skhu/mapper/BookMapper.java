package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Book;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(int id);

    @Select("SELECT b.*, c.categoryName " +
            "FROM book b LEFT JOIN category c ON b.categoryId = c.id")
    List<Book> findAll();

    @Insert("INSERT book (title, author, categoryId, price) " +
            "VALUES (#{title}, #{author}, #{categoryId}, #{price})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Book book);

    @Update("UPDATE book SET title=#{title}, author=#{author}, categoryId=#{categoryId}, " +
            " price=#{price} WHERE id=#{id}")
    void update(Book book);

    @Delete("DELETE FROM book WHERE id=#{id}")
    void delete(int id);
}


