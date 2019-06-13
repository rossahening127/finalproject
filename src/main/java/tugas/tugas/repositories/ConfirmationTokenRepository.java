/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tugas.tugas.entities.ConfirmationToken;

/**
 *
 * @author RossaHening
 */
@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String>{
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
