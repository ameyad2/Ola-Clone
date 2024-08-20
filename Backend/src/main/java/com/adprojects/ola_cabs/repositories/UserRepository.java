package com.adprojects.ola_cabs.repositories;

import com.adprojects.ola_cabs.models.Ride;
import com.adprojects.ola_cabs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    @Query("SELECT R FROM Ride R where R.status=COMPLETED AND R.user.Id=:userId ORDER BY R.endTime DESC")
    public List<Ride> getCompletedRides(@Param("userId")Integer userId);
}
