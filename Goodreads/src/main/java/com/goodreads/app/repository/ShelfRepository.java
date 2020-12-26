package com.goodreads.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goodreads.app.model.MyShelf;

@Repository
public interface ShelfRepository extends JpaRepository<MyShelf, Serializable>{

}
