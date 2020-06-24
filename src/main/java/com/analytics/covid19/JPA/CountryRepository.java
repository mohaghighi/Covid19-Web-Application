
package com.analytics.covid19.JPA;

import com.analytics.covid19.data.Country;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mo
 */

@Repository
public interface CountryRepository extends JpaRepository <Country,Long> {
    
    Country findByName(String name);
    List<Country> findByNameIs(String name);
    List<Country> findByNameEquals(String name);
    List<Country> findByNameIsNot(String name);
    
}
