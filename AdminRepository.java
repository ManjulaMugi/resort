package com.lara.resort.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lara.resort.models.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{

}
