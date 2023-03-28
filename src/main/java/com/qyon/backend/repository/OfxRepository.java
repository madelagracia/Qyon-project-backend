package com.qyon.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qyon.backend.entity.OfxData;


@Repository
public interface OfxRepository extends JpaRepository<OfxData, Integer>{}



