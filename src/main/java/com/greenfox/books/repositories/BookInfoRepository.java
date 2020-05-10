package com.greenfox.books.repositories;

import com.greenfox.books.models.entities.VolumeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookInfoRepository extends CrudRepository<VolumeInfo, LocalDateTime> {
}
