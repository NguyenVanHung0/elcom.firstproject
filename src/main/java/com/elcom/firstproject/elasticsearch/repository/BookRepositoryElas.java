
package com.elcom.firstproject.elasticsearch.repository;

import com.elcom.firstproject.elasticsearch.model.BookElas;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryElas extends ElasticsearchRepository<BookElas, Long>{
     List<BookElas> findByName(String name);
}
