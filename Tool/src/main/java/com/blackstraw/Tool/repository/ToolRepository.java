package com.blackstraw.Tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackstraw.Tool.model.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {


}
