package com.api.auth.userauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.auth.userauthentication.model.Employee;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {

}
