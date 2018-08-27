package com.ude.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ude.sdp.model.FileDB;

@Repository
public interface FileRepository extends JpaRepository<FileDB, Long> {
}
