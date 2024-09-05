// package com.realestate.Real_Estate.repository;

// import com.realestate.Real_Estate.entity.MostInteractive;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface MostInteractiveRepository extends JpaRepository<MostInteractive, Long> {
// }
package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.MostInteractive;
import com.realestate.Real_Estate.entity.Realty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MostInteractiveRepository extends JpaRepository<MostInteractive, Long> {

    // استعلام للحصول على العقارات حسب عدد التفاعلات الأكثر
    @Query("SELECT mi.realty FROM MostInteractive mi GROUP BY mi.realty ORDER BY COUNT(mi.realty) DESC")
    List<Realty> findTopInteractiveRealties();
}
