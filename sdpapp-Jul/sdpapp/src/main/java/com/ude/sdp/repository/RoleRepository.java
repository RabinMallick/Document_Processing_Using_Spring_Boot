package com.ude.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ude.sdp.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
