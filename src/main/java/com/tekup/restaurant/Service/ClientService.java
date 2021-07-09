package com.tekup.restaurant.Service;

import com.tekup.restaurant.domain.ClientUse;
import com.tekup.restaurant.domain.DayClient;
import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Client;
import com.tekup.restaurant.model.Plat;
import com.tekup.restaurant.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    public Client save(Client client){
        return repository.save(client);
    }
    public List<Client> findAll(){
        return repository.findAll();
    }
    public ClientUse findTopClient(){
        List<ClientUse> list = repository.findTopClient();

        ClientUse clientUse = null;
        if (list.size() >0 ){
             clientUse = Collections.max(list);
        }
        return clientUse;
    }
   /* public DayClient findTopDayByClient(Long clientId){
        List<DayClient> list = repository.findTopDayByClient(clientId);
        DayClient dayUse = null;
        if (list.size() >0 ){
            dayUse = Collections.max(list);
        }
        return dayUse;
     }*/
    public DayClient findTopDayByClientSql(Long clientId){
        List<MetUse> listPlat = new ArrayList();
        System.out.println("mmmmmmmmm");
        System.out.println(repository.findTopDayByClientSql(clientId).size()); 
        List<Object[]> data = repository.findTopDayByClientSql(clientId);
        LocalDateTime date = (LocalDateTime) ((LocalDateTime) data.get(0)[0]);
        long dayUse =  (long) data.get(0)[1];
        DayClient result = new DayClient(date.getDayOfWeek().getValue(),dayUse);
        return result;
    }
}
