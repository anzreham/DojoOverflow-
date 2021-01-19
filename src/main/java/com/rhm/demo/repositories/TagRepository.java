package com.rhm.demo.repositories;
import com.rhm.demo.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;


@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    public List<Tag> findAll();

    public Optional <Tag> findBySubject(String subject);
}