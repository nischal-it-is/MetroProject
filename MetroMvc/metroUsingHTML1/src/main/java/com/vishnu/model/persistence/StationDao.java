package com.vishnu.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.beans.Station;

@Repository
public interface StationDao extends JpaRepository<Station, Integer>{

}
