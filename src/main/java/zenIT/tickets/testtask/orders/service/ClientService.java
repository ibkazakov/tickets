package zenIT.tickets.testtask.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zenIT.tickets.testtask.orders.dao.ClientRepository;
import zenIT.tickets.testtask.orders.model.Client;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client createClient(String name, String phone, String email) {
        Client newClient = new Client();
        newClient.setName(name);
        newClient.setEmail(email);
        newClient.setPhone(phone);
        clientRepository.save(newClient);
        return newClient;
    }

    public List<Client> getAllClients() {
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public boolean deleteClientById(Long id) {
        if (!clientRepository.existsById(id)) {
            return false;
        }
        clientRepository.deleteById(id);
        return true;
    }
}
