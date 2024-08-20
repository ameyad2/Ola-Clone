package com.adprojects.ola_cabs.repositories;

import com.adprojects.ola_cabs.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
