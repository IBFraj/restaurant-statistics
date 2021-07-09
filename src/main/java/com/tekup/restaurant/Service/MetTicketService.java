package com.tekup.restaurant.Service;

import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.MetTicket;
import com.tekup.restaurant.model.Plat;
import com.tekup.restaurant.repository.MetTicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class MetTicketService {
    @Autowired
    private MetTicketRepository metTicketRepository;
    @Autowired
    private PlatService platService;
    public MetTicket save(MetTicket metTicket){
        return metTicketRepository.save(metTicket);
    }
    public List<MetTicket> findAll(){
        return metTicketRepository.findAll();
    }
    public MetUse findTopPlat(LocalDate dateP,LocalDate dateN){
        List<MetUse> listPlat = new ArrayList();
        System.out.println("mmmmmmmmm");
        System.out.println(metTicketRepository.findTopPlatSql(dateP,dateN).size());
        System.out.println(metTicketRepository.findTopPlatSql(dateP,dateN));
        List<MetUse> list = metTicketRepository.findTopPlat(dateP,dateN);
        list.forEach(e->{
            if (e.getMet().getType().equals("plat")){
                listPlat.add(e);
            }
        });
        MetUse metUse = null;
        if (listPlat.size() >0 ){
            metUse = Collections.max(listPlat);
        }
        return metUse;
    }
    public MetUse findTopPlatSql(LocalDate dateP,LocalDate dateN){
        List<MetUse> listPlat = new ArrayList();
        System.out.println("mmmmmmmmm");
        System.out.println(metTicketRepository.findTopPlatSql(dateP,dateN).size());
        System.out.println(metTicketRepository.findTopPlatSql(dateP,dateN));
        List<Object[]> data = metTicketRepository.findTopPlatSql(dateP,dateN);
        long platId = (long) ((Integer) data.get(0)[0]).doubleValue();
        Plat plat = (Plat) platService.findById(platId).get();
        long platUse = ((BigInteger) data.get(0)[1]).longValue();
        MetUse result = new MetUse(plat,platUse);
        /*System.out.println("platId"+platId);
                for (Object[] res : data) {  
                	System.out.println(((Integer) res[0]).doubleValue());
                	System.out.println(((BigInteger) res[1]).longValue());
                }*/
        MetUse metUse = null;
        if (listPlat.size() >0 ){
            metUse = Collections.max(listPlat);
        }
        return result;
    }
}
